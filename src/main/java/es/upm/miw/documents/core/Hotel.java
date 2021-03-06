package es.upm.miw.documents.core;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Hotel {

	public Hotel() {
		super();
	}

	public Hotel(String hotelName, String hotelChainName, String adress, String managerName,
			String managerSurname) {
		super();
		HotelName = hotelName;
		HotelChainName = hotelChainName;
		Adress = adress;
		ManagerName = managerName;
		ManagerSurname = managerSurname;
	}

	@Id
	private String id;

	@Indexed
	private String HotelName;

	@Indexed
	private String HotelChainName;

	private String Adress;

	private String ManagerName;

	private String ManagerSurname;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		id = id;
	}

	public String getHotelName() {
		return HotelName;
	}

	public void setHotelName(String hotelName) {
		HotelName = hotelName;
	}

	public String getHotelChainName() {
		return HotelChainName;
	}

	public void setHotelChainName(String hotelChainName) {
		HotelChainName = hotelChainName;
	}

	public String getAdress() {
		return Adress;
	}

	public void setAdress(String adress) {
		Adress = adress;
	}

	public String getManagerName() {
		return ManagerName;
	}

	public void setManagerName(String managerName) {
		ManagerName = managerName;
	}

	public String getManagerSurname() {
		return ManagerSurname;
	}

	public void setManagerSurname(String managerSurname) {
		ManagerSurname = managerSurname;
	}

}
