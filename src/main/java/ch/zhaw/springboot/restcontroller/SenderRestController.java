package ch.zhaw.springboot.restcontroller;

import ch.zhaw.springboot.entities.Sender;
import ch.zhaw.springboot.repositories.SenderRepository;
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
public class SenderRestController {

	@Autowired
	private SenderRepository repository;

	@RequestMapping(value = "feedback/v1/senders", method = RequestMethod.GET)
	public ResponseEntity<List<Sender>> getSenders() {
		List<Sender> result = this.repository.findAll();

		if (!result.isEmpty()) {
			return new ResponseEntity<List<Sender>>(result, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Sender>>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "feedback/v1/senders/{id}", method = RequestMethod.GET)
	public ResponseEntity<Optional<Sender>> getSenderById(@PathVariable("id") long id) {
		Optional<Sender> result = this.repository.findById(id);
		if (result != null) {
			return new ResponseEntity<Optional<Sender>>(result, HttpStatus.OK);
		} else {
			return new ResponseEntity<Optional<Sender>>(HttpStatus.NOT_FOUND);
		}
	}
}
