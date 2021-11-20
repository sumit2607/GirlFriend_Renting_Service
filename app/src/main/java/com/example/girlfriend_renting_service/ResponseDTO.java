package com.example.girlfriend_renting_service;

import java.util.List;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class ResponseDTO implements Serializable {

	@SerializedName("profile")
	private List<ProfileDTO> profile;

	public List<ProfileDTO> getProfile(){
		return profile;
	}
}