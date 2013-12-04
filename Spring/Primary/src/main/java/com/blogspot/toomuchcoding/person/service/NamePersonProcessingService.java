package com.blogspot.toomuchcoding.person.service;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import com.blogspot.toomuchcoding.person.domain.Person;

@Component
class NamePersonProcessingService implements PersonProcessingService {

	@Override
	public boolean isApplicableFor(Person person) {
		return StringUtils.isNotBlank(person.getName());
	}

	@Override
	public String process(Person person) {
		return String.format("Person with NAME [%s] has been processed", person.getName());
	}
}
