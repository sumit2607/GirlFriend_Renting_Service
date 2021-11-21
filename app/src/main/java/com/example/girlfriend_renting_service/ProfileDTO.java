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

	@SerializedName("location")
	private String location;

	@SerializedName("phone")
	private String phone;

	@SerializedName("about_me")
	private String aboutMe;

	@SerializedName("height")
	private String height;

	@SerializedName("weight")
	private String weight;

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

	public String getLocation(){
		return location;
	}

	public String getPhone(){
		return phone;
	}

	public String getAboutMe(){
		return aboutMe;
	}

	public String getHeight(){
		return height;
	}

	public String getWeight(){
		return weight;
	}

	public String getType(){
		return type;
	}
}
