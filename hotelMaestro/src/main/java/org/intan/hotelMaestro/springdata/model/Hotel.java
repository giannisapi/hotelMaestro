package org.intan.hotelMaestro.springdata.model;


import java.io.Serializable;
import java.math.BigInteger;

import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Data;
import lombok.Data;

@Data
@Document
public class Hotel extends AbstractDocument {


	private String altHotelName;

	private BigInteger chainID;

	private String city;

	private String cityCode;

	private String companyName;

	private String country;

	private String countryCode;

	private String eBridgeID;

	private String email;

	private String fax;

	private String im;

	private String lang;

	private String latitude;

	private String logoFileURL;

	private String longitude;

	private String name;

	private String otaUrl;

	private String postCode;

	private String registration;

	private String state;

	private String street;

	private String taxID1;

	private String taxID2;

	private String telephone;

	private String web;
	
	private Map<String, String> attributes = new HashMap<String, String>();

	
	public Hotel() {
	}

	@PersistenceConstructor
	public Hotel(String altHotelName, BigInteger chainID, String city,
			String cityCode, String companyName, String country,
			String countryCode, String eBridgeID, String email, String fax,
			String im, String lang, String latitude, String logoFileURL,
			String longitude, String name, String otaUrl, String postCode,
			String registration, String state, String street, String taxID1,
			String taxID2, String telephone, String web, Map<String, String> attributes) {
		super();
		this.altHotelName = altHotelName;
		this.chainID = chainID;
		this.city = city;
		this.cityCode = cityCode;
		this.companyName = companyName;
		this.country = country;
		this.countryCode = countryCode;
		this.eBridgeID = eBridgeID;
		this.email = email;
		this.fax = fax;
		this.im = im;
		this.lang = lang;
		this.latitude = latitude;
		this.logoFileURL = logoFileURL;
		this.longitude = longitude;
		this.name = name;
		this.otaUrl = otaUrl;
		this.postCode = postCode;
		this.registration = registration;
		this.state = state;
		this.street = street;
		this.taxID1 = taxID1;
		this.taxID2 = taxID2;
		this.telephone = telephone;
		this.web = web;
		this.attributes = attributes;
	}

}