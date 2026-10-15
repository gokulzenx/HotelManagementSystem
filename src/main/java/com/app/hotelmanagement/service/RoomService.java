package com.app.hotelmanagement.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.app.hotelmanagement.entity.Room;
import com.app.hotelmanagement.repository.RoomRepository;

@Service
public class RoomService {

	private final RoomRepository roomRepository;
	
	public RoomService(RoomRepository roomRepository) {
		this.roomRepository = roomRepository;
	}
	
	public Room addRoom(Room room) {
		return roomRepository.save(room);
	}
	
	public List<Room> getAllRooms() {
		return roomRepository.findAll();
	}
	
	public Room getRoomById(Long id) {
		return roomRepository.findById(id).orElse(null);
	}
	
	public void deleteRoom(Long id) {
		roomRepository.deleteById(id);
	}
	
	public Room updateRoom(Long id, Room updatedRoom) {
		Room existingRoom = roomRepository.findById(id).orElse(null);
		if(existingRoom != null) {
			existingRoom.setRoomNumber(updatedRoom.getRoomNumber());
			existingRoom.setPricePerNight(updatedRoom.getPricePerNight());
			existingRoom.setRoomType(updatedRoom.getRoomType());
			existingRoom.setAvailable(updatedRoom.getAvailable());
			
			return roomRepository.save(existingRoom);
		}
		return null;
	}
}
