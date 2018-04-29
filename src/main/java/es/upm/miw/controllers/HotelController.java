package es.upm.miw.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import es.upm.miw.documents.core.Hotel;
import es.upm.miw.dtos.HotelDto;
import es.upm.miw.repositories.core.HotelRepository;


@Controller
public class HotelController {

	
	@Autowired
	private HotelRepository hotelRepository;
	
	
	public List<String> GetHotelNames(){
		
		List<String> result = new ArrayList<String>();
		
		List<Hotel> hotelCollection = hotelRepository.findAll();
		
		for(Hotel item : hotelCollection) {
			result.add(item.getHotelName());
		}
		
		return result;
	}
	
	public Hotel InsertHotel(HotelDto hotelDto) {
		Hotel hotel = new Hotel(hotelDto.getHotelName(),hotelDto.getHotelChainName(),
				hotelDto.getAdress(),hotelDto.getManagerName(),hotelDto.getManagerSurname());
		return this.hotelRepository.insert(hotel);
	}
}
