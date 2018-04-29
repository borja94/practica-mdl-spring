package es.upm.miw.resources;

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


@RestController
@RequestMapping(RoomResource.ROOM)
public class RoomResource {
	
	 public static final String ROOM = "/room";
	 
	 @Autowired
	 private RoomController roomController;
	 
	 @GetMapping
	 public List<RoomDto> getAllRoomFiltered(String hotelsName, String roomTypes, 
			 @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @RequestParam("searchDate") Date searchDate){
		 
		 return roomController.GetFilteredRooms(null, null, null);		 
	 }

}
