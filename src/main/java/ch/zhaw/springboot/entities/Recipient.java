package ch.zhaw.springboot.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Recipient extends Person{

	private String company;

	@OneToMany(mappedBy = "recipient")
	@JsonBackReference
	private List<Message> messages = new ArrayList<Message>();

	public Recipient(String name, String email, String company) {
		super(name, email);
		this.company = company;
	}

	public Recipient() {
	}

	public String getCompany() {
		return company;
	}

	public List<Message> getMessages() {
		return messages;
	}
}
