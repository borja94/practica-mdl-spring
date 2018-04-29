package es.upm.miw.documents.core;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Room {

	
	
	public Room() {
		super();
	}



	public Room(String id, int roomNumber, String characteristics, Float price) {
		super();
		Id = id;
		RoomNumber = roomNumber;
		Characteristics = characteristics;
		Price = price;
	}



	@Id
	private String Id;
	
	@Indexed
	private int RoomNumber;
	
	private String Characteristics;
	
	private Float Price;

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
	
	
}
