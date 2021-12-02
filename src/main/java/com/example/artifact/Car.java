package com.example.artifact;

import java.util.function.IntPredicate;

public class Car {
	private String name;
	private String type;

    public Car(String name, String type) {
		this.name = name;
		this.type = type;
    }

    public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getType() {
		// TODO Auto-generated method stub
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}


}
