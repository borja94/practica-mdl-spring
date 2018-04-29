package es.upm.miw.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.upm.miw.controllers.HotelController;

@RestController
@RequestMapping(HotelResource.HOTEL)
public class HotelResource {
	
	 public static final String HOTEL = "/hotel";
	 
	 @Autowired
	 private HotelController hotelController;
	 
	 @GetMapping
	 public List<String> getAllHotelNames(){
		 
		 return hotelController.GetHotelNames();		 
	 }

}
