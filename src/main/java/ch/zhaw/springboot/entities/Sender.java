package ch.zhaw.springboot.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Sender extends Person{

	private String location;

	@OneToMany(mappedBy = "sender", cascade = CascadeType.ALL)
	private List<Message> messages = new ArrayList<Message>();

	public Sender(String email, String location, List<Message> messages) {
		super(email);
		this.location = location;
		this.messages = messages;
	}

	public Sender() {
	}

	public String getLocation() {
		return location;
	}

	public List<Message> getMessages() {
		return messages;
	}
}
