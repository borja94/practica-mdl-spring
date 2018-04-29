package es.upm.miw.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

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

	public List<RoomDto> GetAvailableRooms() {

		ArrayList<RoomDto> result = new ArrayList<RoomDto>();

		List<Room> roomCollection = roomRespository.findAll();

		for (Room item : roomCollection) {
		}

		return result;
	}

}
