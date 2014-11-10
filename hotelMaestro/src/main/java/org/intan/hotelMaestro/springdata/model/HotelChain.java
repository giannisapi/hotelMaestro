package org.intan.hotelMaestro.springdata.model;

import java.math.BigInteger;
import java.util.Map;

import lombok.Data;

import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document
public class HotelChain extends AbstractDocument {
	
	
	private String name;
	private String description;
	private String logoFileURL;

}
