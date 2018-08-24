package com.niaa;

public class Person {
	
	private String name;
	private String lastName;

	// private constructor : so that 'new' on Person can not be instantiated 
	private Person(Builder b) {
		this.name = b.name;
		this.lastName = b.lastName;
	}
	
	//create a static method which returns Builder object
	public static Builder builder() {
		return new Builder();
	}
	
	public String getName() {
		return name;
	}
	public String getLastName() {
		return lastName;
	}

	
	// Builder to create person
	public static class Builder  {
		
		private String name;
		private String lastName;
		
		private Builder() {
			
		}
		
		public Builder setName(String name) {
			this.name = name;
			return this;
		}
		
		public Builder setLastName(String lastname) {
			this.lastName = lastname;
			return this;
		}
		
		public Person build() {
			return new Person(this);
		}
		
	}
	
}
