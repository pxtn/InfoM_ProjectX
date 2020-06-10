package ch.zhaw.springboot.entities;

import javax.persistence.*;

@MappedSuperclass
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String name;
	private String email;


	public Person(String name, String email) {
		this.name = name;
		this.email = email;
	}

	public Person() {
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}
}
