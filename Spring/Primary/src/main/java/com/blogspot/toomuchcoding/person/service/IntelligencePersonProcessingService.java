package com.blogspot.toomuchcoding.person.service;

import org.springframework.stereotype.Component;

import com.blogspot.toomuchcoding.person.domain.Person;

@Component
class IntelligencePersonProcessingService implements PersonProcessingService {

	@Override
	public boolean isApplicableFor(Person person) {
		return person.isStupid();
	}

	@Override
	public String process(Person person) {
		return "Person's STUPID so can process him";
	}
}
