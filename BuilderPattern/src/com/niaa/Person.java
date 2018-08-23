package com.niaa;

public class Person {
	
	private String name;
	private String lastName;

	public String getName() {
		return name;
	}
	public String getLastName() {
		return lastName;
	}

	public Person(String name, String lastName) {
		this.name = name;
		this.lastName = lastName;
	}
	
	public static class Builder  {
		
		private String name;
		private String lastName;
		
		public Builder setName(String name) {
			this.name = name;
			return this;
		}
		
		public Builder setLastName(String lastname) {
			this.lastName = lastname;
			return this;
		}
		
		public Person build() {
			return new Person(name, lastName);
		}
		
	}
	
}
