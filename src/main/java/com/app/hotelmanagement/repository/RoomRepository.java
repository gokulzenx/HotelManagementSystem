package com.app.hotelmanagement.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.app.hotelmanagement.entity.Room;

public interface RoomRepository extends JpaRepository<Room, Long> {

	Optional<Room> findByRoomNumber(String roomNumber);
	List<Room> findByRoomType(String roomType);
	List<Room> findByIsAvailable(Boolean isAvailable);
}
