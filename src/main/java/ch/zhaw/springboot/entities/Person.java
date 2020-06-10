package ch.zhaw.springboot.entities;

import javax.persistence.*;

@MappedSuperclass
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String email;


	public Person(String email) {
		this.email = email;
	}

	public Person() {
	}


	public String getEmail() {
		return email;
	}
}
