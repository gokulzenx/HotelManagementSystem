package com.app.hotelmanagement.dto;

public class RoomDTO {
	
	private Long id;
	public Long getId() {
        return id;
	}
	public void setId(Long id) {
        this.id = id;
    }
	
    private String roomNumber;
    public String getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}
	
	private String roomType;
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	
	private Double pricePerNight;
	public Double getPricePerNight() {
		return pricePerNight;
	}
	public void setPricePerNight(Double pricePerNight) {
		this.pricePerNight = pricePerNight;
	}
	
	private Boolean isAvailable;
	public Boolean getIsAvailable() {
		return isAvailable;
	}
	public void setIsAvailable(Boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

}
