package es.upm.miw.documents.core;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Room {

	public Room() {
		super();
	}

	public Room(int roomNumber, String hotelName, String characteristics, Float price,
			es.upm.miw.documents.core.RoomType roomType) {
		super();
		RoomNumber = roomNumber;
		HotelName = hotelName;
		Characteristics = characteristics;
		Price = price;
		RoomType = roomType;
	}

	@Id
	private String Id;

	@Indexed
	private int RoomNumber;

	@Indexed
	private String HotelName;

	private String Characteristics;

	private Float Price;

	private RoomType RoomType;

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public int getRoomNumber() {
		return RoomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		RoomNumber = roomNumber;
	}

	public String getCharacteristics() {
		return Characteristics;
	}

	public void setCharacteristics(String characteristics) {
		Characteristics = characteristics;
	}

	public Float getPrice() {
		return Price;
	}

	public void setPrice(Float price) {
		Price = price;
	}

	public RoomType getRoomType() {
		return RoomType;
	}

	public void setRoomType(RoomType roomType) {
		RoomType = roomType;
	}

	public String getHotelName() {
		return HotelName;
	}

	public void setHotelName(String hotelName) {
		HotelName = hotelName;
	}

}
