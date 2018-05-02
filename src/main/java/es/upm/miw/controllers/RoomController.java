package es.upm.miw.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import es.upm.miw.documents.core.RoomType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import es.upm.miw.documents.core.Reserva;
import es.upm.miw.documents.core.Room;
import es.upm.miw.dtos.RoomDto;
import es.upm.miw.repositories.core.ReservaRepository;
import es.upm.miw.repositories.core.RoomRepository;

@Controller
public class RoomController {

	@Autowired
	private ReservaRepository reservarepo;

	@Autowired
	private RoomRepository roomRespository;

	public List<RoomDto> GetFilteredRooms(List<String> hotelsName, List<String> roomTypes, Date startDate, Date endDate, String startHour, String endHour) {

		ArrayList<RoomDto> result = new ArrayList<RoomDto>();

		List<Room> roomCollection = roomRespository.findAll();

		for (int i = 0; i < roomCollection.size(); i++) {
			Room habitacion = roomCollection.get(i);
			if (hotelsName.contains(habitacion.getHotelName()) && isCorrectType (habitacion.getRoomType(),roomTypes)) {

				if(reservarepo.findByIdHabitacion(habitacion.getId()) == null) { //Si la habitacion no tiene reservas...
					result.add(new RoomDto(habitacion.getHotelName(), habitacion.getCharacteristics(), habitacion.getPrice(),
							habitacion.getRoomType(), habitacion.getId()));
				} else { //En caso de que ya haya reservas para esa habitación:
					List<Reserva> reservaCollection = reservarepo.findByIdHabitacion(habitacion.getId());
					Boolean seguirReserva = true;
					for (int j = 0; j < reservaCollection.size() && seguirReserva; j++) { // Itero sobre esas reservas
						Reserva reserva = reservaCollection.get(j);
						if (startDate.equals(endDate)){
							// si la fecha inicio y fin de la reserva es el mismo día..
							if (!comprobarHoras(startHour, endHour, reserva)) { // si esta libre a esas horas...
								// ha encontrado una reserva para esas horas.. asiq sale dl bucle y NO se añade la habitacion
								seguirReserva = false;
							}
						}else {
							// si la reserva es de varios dias..
							if (!comprobarDisponibilidad(startDate, endDate, reserva)) {
								seguirReserva = false;

							}
						}
					}
					if (seguirReserva){
						result.add(new RoomDto(habitacion.getHotelName(), habitacion.getCharacteristics(), habitacion.getPrice(),
								habitacion.getRoomType(), habitacion.getId()));
					}
				}

			}
		}
		return result;
	}

	
	public void InsertRoom(RoomDto roomDto) {
		Room aux = new Room(1,roomDto.getHotelName(),roomDto.getCharacteristics(),roomDto.getPrice(),roomDto.getRoomType());
		this.roomRespository.insert(aux);
	}
	
	
	private boolean isCorrectType (RoomType tipoHabitacion, List<String> tipos ){
		for (String tipoPermitido : tipos) {
			if (tipoPermitido.equals(tipoHabitacion.toString())) {
				return true;
			}
		}
		return false;
	}

	private boolean comprobarDisponibilidad(Date startDate, Date endDate, Reserva reserva){

		if (startDate.before(reserva.getFecha()) && endDate.before(reserva.getFecha())){
			return true;
		}

		if (startDate.after(reserva.getFechaSalida()) && endDate.after(reserva.getFechaSalida())) {
			return true;
		}

		return false;
	}

	private boolean comprobarHoras(String startHour, String endHour, Reserva reserva){
		int horaEntradaReserva = Integer.parseInt(reserva.getHora().split(":")[0]);
		int horaSalidaReserva = Integer.parseInt(reserva.getHoraSalida().split(":")[0]);
		int horaEntrada = Integer.parseInt(startHour.split(":")[0]);
		int horaSalida = Integer.parseInt(endHour.split(":")[0]);

		if (horaEntrada < horaEntradaReserva && horaSalida < horaSalidaReserva) {
			return true;
		}

		if (horaEntrada > horaSalidaReserva && horaSalida > horaSalidaReserva) {
			return true;
		}

		return false;
	}
}
