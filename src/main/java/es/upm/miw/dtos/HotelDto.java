package es.upm.miw.dtos;

public class HotelDto {

	public HotelDto() {
		super();
	}

	public HotelDto(String hotelName, String hotelChainName, String adress, String managerName, String managerSurname) {
		super();
		HotelName = hotelName;
		HotelChainName = hotelChainName;
		Adress = adress;
		ManagerName = managerName;
		ManagerSurname = managerSurname;
	}

	private String HotelName;

	private String HotelChainName;

	private String Adress;

	private String ManagerName;

	private String ManagerSurname;

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
