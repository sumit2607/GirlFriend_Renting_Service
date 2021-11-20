package com.example.girlfriend_renting_service;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class ProfileDTO implements Serializable {

	@SerializedName("id")
	private String id;

	@SerializedName("name")
	private String name;

	@SerializedName("profile_image_url")
	private String profileImageUrl;

	@SerializedName("age")
	private String age;

	@SerializedName("color")
	private String color;

	@SerializedName("type")
	private String type;

	public String getId(){
		return id;
	}

	public String getName(){
		return name;
	}

	public String getProfileImageUrl(){
		return profileImageUrl;
	}

	public String getAge(){
		return age;
	}

	public String getColor(){
		return color;
	}

	public String getType(){
		return type;
	}
}