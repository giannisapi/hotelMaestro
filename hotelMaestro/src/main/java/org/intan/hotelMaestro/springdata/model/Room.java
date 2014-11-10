package org.intan.hotelMaestro.springdata.model;

import java.math.BigInteger;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Data;

import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
@Document
public class Room extends AbstractDocument {
	
	private int bedcount;

	private int bedtype1;

	private int bedtype2;

	private int bedtype3;

	private int bedtype4;

	private String filetype;
	
	private BigInteger hotelID; 

	private byte noofrooms;

	private byte occupancy;

	private Object photo;

	private int rateid;

	private String roomname;

	private int roomno;

	private String status;
	
	private BigInteger roomTypeID;
	
	private List<Date>     occupiedDates;
	
	private Map<String, String> attributes = new HashMap<String, String>();

	public Room() {
		super();
	}

	public Room(int bedcount, int bedtype1, int bedtype2, int bedtype3,
			int bedtype4, String filetype, byte noofrooms, byte occupancy,
			Object photo, int rateid, String roomname, int roomno,
			String status, BigInteger roomTypeID, Map<String, String> attributes) {
		super();
		this.bedcount = bedcount;
		this.bedtype1 = bedtype1;
		this.bedtype2 = bedtype2;
		this.bedtype3 = bedtype3;
		this.bedtype4 = bedtype4;
		this.filetype = filetype;
		this.noofrooms = noofrooms;
		this.occupancy = occupancy;
		this.photo = photo;
		this.rateid = rateid;
		this.roomname = roomname;
		this.roomno = roomno;
		this.status = status;
		this.roomTypeID = roomTypeID;
		this.attributes = attributes;
	}
	
	

}
