package br.com.jrcsofthouse.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import br.com.jrcsofthouse.model.Person;

@Service
public class PersonService {
	
	private final AtomicLong counter = new AtomicLong();
	
	public Person create(Person person) {
		return person;
	}
	
	public Person update(Person person) {
		return person;
	}
	
	public void delete(String id) {
		
	}
	
	public Person findbyId(String id) {
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Jorge");
		person.setLastName("Coutinho");
		person.setAddress("Rua Prof, Carlos A A C Pinto, 308, Itagaçaba, Cruzeiro-SP");
		person.setGender("Male");
		return person;
	}
	
	public List<Person> findAll(){
		List<Person> persons = new ArrayList<Person>();
		for (int i = 0; i < 8; i++) {
			Person person = mockPerson(i);
			persons.add(person);
		}
		return persons;
	}

	private Person mockPerson(int i) {
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Person Name" + i);
		person.setLastName("Last Name" + i);
		person.setAddress("Some Address in Brazil" + i);
		person.setGender("Male");
		return person;
	}

}
