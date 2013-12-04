package com.blogspot.toomuchcoding.person.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.blogspot.toomuchcoding.person.domain.Person;

@Component
@Primary
class PersonProcessingServiceContainer implements PersonProcessingService {

	private static final Logger LOGGER = LoggerFactory.getLogger(PersonProcessingServiceContainer.class);
	
	@Autowired
	private List<PersonProcessingService> personProcessingServices = new ArrayList<PersonProcessingService>();
	
	@Override
	public boolean isApplicableFor(Person person) {
		return person != null;
	}

	@Override
	public String process(Person person) {
		List<String> output = new ArrayList<String>();
		for(PersonProcessingService personProcessingService : personProcessingServices){
			if(personProcessingService.isApplicableFor(person)){
				output.add(personProcessingService.process(person));
			}
		}
		String result = StringUtils.join(output, ",");
		LOGGER.info(result);
		return result;
	}

	public List<PersonProcessingService> getPersonProcessingServices() {
		return personProcessingServices;
	}
}
