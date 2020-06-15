package ch.zhaw.springboot.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Intent {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String type;

	@ManyToMany(mappedBy = "intents")
	@JsonBackReference
	private List<Message> messages = new ArrayList<Message>();

	public Intent(String type) {
		this.type = type;
	}

	public Intent() {
	}

	public String getType() {
		return type;
	}

	public List<Message> getMessages() {
		return messages;
	}
}
