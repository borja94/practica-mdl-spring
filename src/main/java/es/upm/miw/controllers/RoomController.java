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

//		Boolean seguirHabitacion = true;
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
						if (reserva.getFecha().equals(reserva.getFechaSalida())){
							// si la fecha inicio y fin de la reserva es el mismo día..
							if (comprobarHoras(startHour, endHour, reserva)) { // si esta libre a esas horas...
								result.add(new RoomDto(habitacion.getHotelName(), habitacion.getCharacteristics(), habitacion.getPrice(),
										habitacion.getRoomType(), habitacion.getId()));
							} else {
								// ha encontrado una reserva para esas horas.. asiq sale dl bucle y NO se añade la habitacion
								seguirReserva = false;
							}
						}else {
							// si la reserva es de varios dias..
							if (comprobarDisponibilidad()) {
								result.add(new RoomDto(habitacion.getHotelName(), habitacion.getCharacteristics(), habitacion.getPrice(),
										habitacion.getRoomType(), habitacion.getId()));
							} else {
								seguirReserva = false;
							}
						}
					}
				}

			}
		}
		return result;
	}

	private boolean isCorrectType (RoomType tipoHabitacion, List<String> tipos ){
		for (String tipoPermitido : tipos) {
			if (tipoPermitido.equals(tipoHabitacion)) {
				return true;
			}
		}
		return false;
	}

	private boolean comprobarDisponibilidad(Date startDate, Date endDate, Reserva reserva){

		if ((startDate.after(reserva.getFecha()) && startDate.before(reserva.getFechaSalida())) ||
				(endDate.after(reserva.getFecha()) && endDate.before(reserva.getFechaSalida()))){
			// si la reserva que se intenta hacer, la fecha inicio o fin está comprendida entre un periodo de ocupacion
			return false;
		} else if (startDate.before(reserva.getFecha()) && ) {

		} else {
			return true;
		}
	}

	private boolean comprobarHoras(String startHour, String endHour, Reserva reserva){
		int horaEntradaReserva = Integer.parseInt(reserva.getHora().split(":")[0]);
		int horaSalidaReserva = Integer.parseInt(reserva.getHoraSalida().split(":")[0]);
		int horaEntrada = Integer.parseInt(startHour);
		int horaSalida = Integer.parseInt(endHour);

		if ((horaEntrada > horaEntradaReserva && horaEntrada < horaSalidaReserva) ||
			(horaSalida > horaEntradaReserva && horaSalida < horaSalidaReserva)){
			// la hora de entrada o salida de la posible reserva esta comprendida entre horas de reserva existente
			return false;
		} else if ((horaEntradaReserva > horaEntrada && horaEntradaReserva < horaSalida) ||
				(horaSalidaReserva > horaEntrada && horaSalidaReserva < horaSalida)){
			// existe una reserva entre las horas de la posible reserva
			return false;
		} else {
			// las horas de la posible reserva son antes o despues de la reserva existente
			return true;
		}
	}
}
