package es.upm.miw.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
		
		for (Room item : roomCollection) {
			if (hotelsName.contains(item.getHotelName())) {
				if(reservarepo.findByIdHabitacion(item.getId()) == null) { //Si no hay ninguna reserva con ese ID de habitación la añado directamente
					result.add(new RoomDto(item.getHotelName(), item.getCharacteristics(), item.getPrice(),
							item.getRoomType(), 1));
				} else { //En caso de que ya haya reservas para esa habitación:
					List<Reserva> reservaCollection = reservarepo.findByIdHabitacion(item.getId());
					for (Reserva reserva : reservaCollection) { //Itero sobre esas reservas
						if(reserva.getFecha().equals(startDate) && reserva.getFechaSalida().equals(endDate)) { // Si las fechas de busqueda son las mimsas que las de reserva...
							if((reserva.getHora().compareTo(endHour) == 1 || reserva.getHoraSalida().compareTo(startHour) == -1)) { //Si las horas son compatibles añado la habitación...
								result.add(new RoomDto(item.getHotelName(), item.getCharacteristics(), item.getPrice(),
										item.getRoomType(), 1));
							}
						} else { //Si las fechas de reserva son distintas a las de búsqueda, la habitación está libre ese día
							result.add(new RoomDto(item.getHotelName(), item.getCharacteristics(), item.getPrice(),
									item.getRoomType(), 1));
						}
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
}
