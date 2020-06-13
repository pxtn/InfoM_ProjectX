package ch.zhaw.springboot.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Sender extends Person{

	@Column(length = 16)
	private String phoneNumber;

	@OneToMany(mappedBy = "sender")
	private List<Message> messages = new ArrayList<Message>();

	public Sender(String name, String email, String phoneNumber) {
		super(name, email);
		this.phoneNumber = phoneNumber;
	}

	public Sender() {
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public List<Message> getMessages() {
		return messages;
	}
}
