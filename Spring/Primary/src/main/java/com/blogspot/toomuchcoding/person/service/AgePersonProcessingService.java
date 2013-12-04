package com.blogspot.toomuchcoding.person.service;

import org.springframework.stereotype.Component;

import com.blogspot.toomuchcoding.person.domain.Person;

@Component
class AgePersonProcessingService implements PersonProcessingService {

	@Override
	public boolean isApplicableFor(Person person) {
		return person.getAge() >= 18;
	}

	@Override
	public String process(Person person) {
		return String.format("Person's AGE is [%s] so we could process him", person.getAge());
	}
}
