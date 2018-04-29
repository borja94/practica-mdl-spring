package es.upm.miw.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import es.upm.miw.documents.core.Room;
import es.upm.miw.documents.core.RoomType;
import es.upm.miw.dtos.RoomDto;
import es.upm.miw.repositories.core.ReservaRepository;
import es.upm.miw.repositories.core.RoomRepository;

@Controller
public class RoomController {

	@Autowired
	private ReservaRepository reservarepo;

	@Autowired
	private RoomRepository roomRespository;

	public List<RoomDto> GetFilteredRooms(List<String> hotelsName, List<String> roomTypes, Date searchDate) {

		ArrayList<RoomDto> result = new ArrayList<RoomDto>();

		List<Room> roomCollection = roomRespository.findAll();

		for (Room item : roomCollection) {
			Boolean insert = false;
			if (hotelsName == null && roomTypes == null) {
				result.add(new RoomDto(item.getHotelName(), item.getCharacteristics(), item.getPrice(),
						item.getRoomType(), 1));
			} else if (hotelsName.contains(item.getHotelName())) {
				result.add(new RoomDto(item.getHotelName(), item.getCharacteristics(), item.getPrice(),
						item.getRoomType(), 1));
			}

			else if (roomTypes.contains(item.getRoomType().toString())) {
				result.add(new RoomDto(item.getHotelName(), item.getCharacteristics(), item.getPrice(),
						item.getRoomType(), 1));
			}
		}

		return result;
	}

	public void InsertRoom(RoomDto roomDto) {
		Room aux = new Room(1,roomDto.getHotelName(),roomDto.getCharacteristics(),roomDto.getPrice(),roomDto.getRoomType());
		this.roomRespository.insert(aux );
	}
}
