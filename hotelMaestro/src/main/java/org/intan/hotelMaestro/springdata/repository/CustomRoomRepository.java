package org.intan.hotelMaestro.springdata.repository;

import java.util.List;

import org.intan.hotelMaestro.springdata.model.Room;

public interface CustomRoomRepository {
	
	public List<Room>  findByRangeDate();

}
