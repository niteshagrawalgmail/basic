package com.niaa;

public class BuilderTest {

	public static void main(String[] args) {
		
		Person p = new Person.Builder().setName("Nitesh").setLastName("Agrawal").build();
	
		System.out.println(p.getName());
		System.out.println(p.getLastName());

	}

}
