package com.yc;

public class Entity {
	private String ID;
	private String name;
	private String gender;
	private String age;
	
	public Entity(){}
	
	public Entity(String iD, String name, String gender, String age) {
		super();
		ID = iD;
		this.name = name;
		this.gender = gender;
		this.age = age;
	}

	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Entity [ID=" + ID + ", name=" + name + ", gender=" + gender
				+ ", age=" + age + "]";
	}
	
	
}
