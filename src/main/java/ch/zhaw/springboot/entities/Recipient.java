package ch.zhaw.springboot.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Recipient extends Person{

	private String company;

	@OneToMany(mappedBy = "recipient", cascade = CascadeType.ALL)
	private List<Message> messages = new ArrayList<Message>();

	public Recipient(String name, String email, String company, List<Message> messages) {
		super(name, email);
		this.company = company;
		this.messages = messages;
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
