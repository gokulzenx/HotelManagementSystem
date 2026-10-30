
package com.app.hotelmanagement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.app.hotelmanagement.dto.RoomDTO;
import com.app.hotelmanagement.entity.Room;
import com.app.hotelmanagement.repository.RoomRepository;

@Service
public class RoomService {

    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    private RoomDTO convertToDTO(Room room) {
        RoomDTO dto = new RoomDTO();

        dto.setId(room.getId());
        dto.setRoomNumber(room.getRoomNumber());
        dto.setRoomType(room.getRoomType());
        dto.setPricePerNight(room.getPricePerNight());
        dto.setIsAvailable(room.getIsAvailable());

        return dto;
    }

    private Room convertToEntity(RoomDTO dto) {
        Room room = new Room();

        room.setRoomNumber(dto.getRoomNumber());
        room.setRoomType(dto.getRoomType());
        room.setPricePerNight(dto.getPricePerNight());
        room.setIsAvailable(dto.getIsAvailable());

        return room;
    }

    public RoomDTO addRoom(RoomDTO roomDTO) {
        Room room = convertToEntity(roomDTO);

        Room savedRoom = roomRepository.save(room);

        return convertToDTO(savedRoom);
    }

    public List<RoomDTO> getAllRooms() {
        List<Room> rooms = roomRepository.findAll();
        List<RoomDTO> roomDTOs = new ArrayList<>();

        for (Room room : rooms) {
            RoomDTO dto = convertToDTO(room);
            roomDTOs.add(dto);
        }

        return roomDTOs;
    }

    public RoomDTO getRoomById(Long id) {
        Optional<Room> optionalRoom = roomRepository.findById(id);

        if (optionalRoom.isPresent()) {
            Room room = optionalRoom.get();
            return convertToDTO(room);
        }

        return null;
    }

    public RoomDTO updateRoom(Long id, RoomDTO updatedRoomDTO) {
        Room existingRoom = roomRepository.findById(id).orElse(null);

        if (existingRoom != null) {
            existingRoom.setRoomNumber(updatedRoomDTO.getRoomNumber());
            existingRoom.setRoomType(updatedRoomDTO.getRoomType());
            existingRoom.setPricePerNight(
                    updatedRoomDTO.getPricePerNight());
            existingRoom.setIsAvailable(
                    updatedRoomDTO.getIsAvailable());

            Room savedRoom = roomRepository.save(existingRoom);

            return convertToDTO(savedRoom);
        }

        return null;
    }

    public boolean deleteRoom(Long id) {
        if (!roomRepository.existsById(id)) {
            return false;
        }

        roomRepository.deleteById(id);
        return true;
    }
    
    public RoomDTO getRoomByNumber(String roomNumber) {
        Optional<Room> optionalRoom = roomRepository.findByRoomNumber(roomNumber);

        if (optionalRoom.isPresent()) {
            Room room = optionalRoom.get();
            return convertToDTO(room);
        }
        return null;
    }

	public List<RoomDTO> searchByRoomType(String roomType) {
		List<Room> rooms = roomRepository.findByRoomType(roomType);
		
		List<RoomDTO> roomDTOs = new ArrayList<>();
		for(Room room : rooms) {
			roomDTOs.add(convertToDTO(room));
		}
		return roomDTOs;
	}

	public List<RoomDTO> searchByAvailability(Boolean isAvailable) {
	    List<Room> rooms = roomRepository.findByIsAvailable(isAvailable);

	    List<RoomDTO> roomDTOs = new ArrayList<>();
	    for (Room room : rooms) {
	        roomDTOs.add(convertToDTO(room));
	    }
	    return roomDTOs;
	}
}
