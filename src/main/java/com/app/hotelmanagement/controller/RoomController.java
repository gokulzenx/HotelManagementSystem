package com.app.hotelmanagement.controller;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.app.hotelmanagement.entity.Room;
import com.app.hotelmanagement.service.RoomService;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {
	
	private final RoomService roomService;
	
	public RoomController(RoomService roomService) {
		this.roomService = roomService;
	}
	
	@GetMapping("/new/prefill")
	public Room prefillRoom() {
		return new Room();
	}

	@PostMapping
	public Room addRoom(@RequestBody Room room) {
		return roomService.addRoom(room);
	}
	
	@GetMapping("/{id}")
	public Room getRoomById(@PathVariable Long id) {
		return roomService.getRoomById(id);
	}
	
	@GetMapping
	public List<Room> getAllRooms() {
		return roomService.getAllRooms();
	}
	
	@DeleteMapping("/{id}")
	public void deleteRoom(@PathVariable Long id) {
		roomService.deleteRoom(id);
	}
}
