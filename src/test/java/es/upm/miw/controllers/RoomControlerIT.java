package es.upm.miw.controllers;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import es.upm.miw.documents.core.RoomType;
import es.upm.miw.dtos.RoomDto;
import es.upm.miw.repositories.core.RoomRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoomControlerIT {
	
	@Autowired
	private RoomController roomController;
	
	
	@Before
	public void before() {
		float price = 10;
		RoomDto roomDto = new RoomDto("hotel1", "caracteriticas", price,RoomType.SINGLE,1 );
		this.roomController.InsertRoom(roomDto);
	}
	
	@Test
	public void GetAllRoomstest() {
		List<RoomDto> aux = roomController.GetFilteredRooms(null, null, new Date());
		assertEquals(true, aux.size() > 0);
	}

}


