package com.javaex.phonebook;

public class PhoneDb {
	
	//필드
	private String name;
	private String hp;
	private String company;
	
	//생성자
	public PhoneDb() {
		super();
	}
	
	public PhoneDb(String name, String hp, String company) {
		this.name = name;
		this.hp = hp;
		this.company = company;
	}
	//메서드 gs

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHp() {
		return hp;
	}

	public void setHp(String hp) {
		this.hp = hp;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	
	//메서드 일반
	@Override
	public String toString() {
		return  name + hp +company ;
	}
	
	public void showInfo() {
		System.out.println(this.name +"\t"+ this.hp +"\t"+ this.company);
	}


	
	
	

}
