package edu;

public class BoardDTO {
	
	private int ID;
	private String Name;
	private String CountryCode;
	private String District;
	private int Population;
	
	public BoardDTO() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public BoardDTO(int iD, String name, String countryCode, String district, int population) {
		super();
		ID = iD;
		Name = name;
		CountryCode = countryCode;
		District = district;
		Population = population;
	}



	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		this.ID = iD;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		this.Name = name;
	}
	public String getCountryCode() {
		return CountryCode;
	}
	public void setCountryCode(String countryCode) {
		this.CountryCode = countryCode;
	}
	public String getDistrict() {
		return District;
	}
	public void setDistrict(String district) {
		this.District = district;
	}
	public int getPopulation() {
		return Population;
	}
	public void setPopulation(int population) {
		this.Population = population;
	}
	@Override
	public String toString() {
		return "BoardDTO [ID=" + ID + ", Name=" + Name + ", CountryCode=" + CountryCode + ", District=" + District
				+ ", Population=" + Population + "]";
	}
	
	
	
}
