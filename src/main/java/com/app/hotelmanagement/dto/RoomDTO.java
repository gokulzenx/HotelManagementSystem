package com.app.hotelmanagement.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class RoomDTO {
	
	private Long id;
	public Long getId() {
        return id;
	}
	public void setId(Long id) {
        this.id = id;
    }
	
	@NotBlank(message = "Room number is required")
    private String roomNumber;
    public String getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}
	
	@NotBlank(message = "Room type is required")
	private String roomType;
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	
	@NotNull(message = "Price per night is required")
    @Positive(message = "Price must be greater than zero")
	private Double pricePerNight;
	public Double getPricePerNight() {
		return pricePerNight;
	}
	public void setPricePerNight(Double pricePerNight) {
		this.pricePerNight = pricePerNight;
	}
	
	@NotNull(message = "Availability status is required")
	private Boolean isAvailable;
	public Boolean getIsAvailable() {
		return isAvailable;
	}
	public void setIsAvailable(Boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

}
