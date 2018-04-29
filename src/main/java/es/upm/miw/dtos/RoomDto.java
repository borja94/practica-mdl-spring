package es.upm.miw.dtos;

import es.upm.miw.documents.core.RoomType;

public class RoomDto {

	public RoomDto() {
		super();
	}

	public RoomDto(String hotelName, String characteristics, Float price, es.upm.miw.documents.core.RoomType roomType,
			int quantity) {
		super();
		HotelName = hotelName;
		Characteristics = characteristics;
		Price = price;
		RoomType = roomType;
		Quantity = quantity;
	}

	private String HotelName;

	private String Characteristics;

	private Float Price;

	private RoomType RoomType;

	private int Quantity;

	public String getHotelName() {
		return HotelName;
	}

	public void setHotelName(String hotelName) {
		HotelName = hotelName;
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

	public int getQuantity() {
		return Quantity;
	}

	public void setQuantity(int quantity) {
		Quantity = quantity;
	}

}
