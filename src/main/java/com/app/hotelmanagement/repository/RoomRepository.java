package com.app.hotelmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.app.hotelmanagement.entity.Room;

public interface RoomRepository extends JpaRepository<Room, Long> {

}
