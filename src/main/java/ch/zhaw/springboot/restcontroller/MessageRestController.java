package ch.zhaw.springboot.restcontroller;

import ch.zhaw.springboot.entities.Message;
import ch.zhaw.springboot.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class MessageRestController {

	@Autowired
	private MessageRepository repository;

	@RequestMapping(value = "support/v1/messages", method = RequestMethod.GET)
	public ResponseEntity<List<Message>> getMessages() {
		List<Message> result = this.repository.findAll();

		if (!result.isEmpty()) {
			return new ResponseEntity<List<Message>>(result, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Message>>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "support/v1/messages/{id}", method = RequestMethod.GET)
	public ResponseEntity<Optional<Message>> getMessageById(@PathVariable("id") long id) {
		Optional<Message> result = this.repository.findById(id);
		if (result != null) {
			return new ResponseEntity<Optional<Message>>(result, HttpStatus.OK);
		} else {
			return new ResponseEntity<Optional<Message>>(HttpStatus.NOT_FOUND);
		}
	}
}
