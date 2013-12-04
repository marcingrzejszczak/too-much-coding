package com.blogspot.toomuchcoding.person.domain;

public final class Person {
	private final String name;
	private final int age;
	private final boolean stupid;

	public Person(String name, int age, boolean stupid) {
		this.name = name;
		this.age = age;
		this.stupid = stupid;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public boolean isStupid() {
		return stupid;
	}
}
