package ch.zhaw.springboot.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Message{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private Date date;
	private String content;

	@ManyToOne(fetch=FetchType.EAGER)
	private Sender sender;

	@ManyToOne(fetch=FetchType.EAGER)
	private Recipient recipient;

	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<Intent> intents = new ArrayList<Intent>();


	public Message(Date date, String content, Sender sender, Recipient recipient) {
		this.date = date;
		this.content = content;
		this.sender = sender;
		this.recipient = recipient;
	}

	public Message() {
	}


	public Date getDate() {
		return date;
	}

	public String getContent() {
		return content;
	}

	public Sender getSender() {
		return sender;
	}

	public Recipient getRecipient() {
		return recipient;
	}

	public List<Intent> getIntents() {
		return intents;
	}
}
