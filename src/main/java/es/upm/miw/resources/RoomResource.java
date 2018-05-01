package es.upm.miw.resources;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.upm.miw.controllers.RoomController;
import es.upm.miw.dtos.RoomDto;

//Crear controlador, repositorio (metodos por defecto) y lo hacemos en memoria

@RestController
@RequestMapping(RoomResource.ROOM)
public class RoomResource {
	
	 public static final String ROOM = "/room";
	 
	 @Autowired
	 private RoomController roomController;
	 
	 @GetMapping
	 public List<RoomDto> getAllRoomFiltered(String hotelsName, String roomTypes, 
			 @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @RequestParam("startDate") Date startDate,
			 @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @RequestParam("endDate") Date endDate,
			  String startHour, String endHour){
		 
		 List<String> hotelsNameList = Arrays.asList(hotelsName.split(","));
		 List<String> roomTypesList = Arrays.asList(roomTypes.split(","));
		 
		 return roomController.GetFilteredRooms(hotelsNameList, roomTypesList, startDate, endDate, startHour, endHour);
	 }
	
}
