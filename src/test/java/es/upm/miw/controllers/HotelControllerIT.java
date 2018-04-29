package es.upm.miw.controllers;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;

import es.upm.miw.dtos.HotelDto;
import es.upm.miw.repositories.core.HotelRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HotelControllerIT {

	@Autowired
	private HotelController hotelController;

	@Autowired
	private HotelRepository hotelRepository;

	@Before
	public void before() {
		HotelDto hotelDto = new HotelDto("Hotel1", "chain1", "adress1", "m1", "m1surname");
		this.hotelController.InsertHotel(hotelDto);
	}

	@Test
	public void getAllNamesTest() {

		List<String> names = hotelController.GetHotelNames();
		assertEquals(true, names.size() > 0);

	}

}
