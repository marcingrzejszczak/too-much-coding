package com.blogspot.toomuchcoding.person.service;

import com.blogspot.toomuchcoding.person.domain.Person;

public interface PersonProcessingService {
	boolean isApplicableFor(Person person);
	String process(Person person);
}
