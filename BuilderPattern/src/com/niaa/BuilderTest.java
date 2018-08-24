package com.niaa;

public class BuilderTest {

	public static void main(String[] args) {
		
		Person p = Person.builder().setName("Nitesh").setLastName("Agrawal").build();
	
		System.out.println(p.getName());
		System.out.println(p.getLastName());
		
		Person p1 = Person.builder().setName("Niharika").setLastName("Gupta").build();
		
		System.out.println(p1.getName());
		System.out.println(p1.getLastName());

	}

}
