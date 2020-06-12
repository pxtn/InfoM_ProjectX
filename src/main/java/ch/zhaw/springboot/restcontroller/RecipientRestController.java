package ch.zhaw.springboot.restcontroller;

import ch.zhaw.springboot.entities.Recipient;
import ch.zhaw.springboot.repositories.RecipientRepository;
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
public class RecipientRestController {

	@Autowired
	private RecipientRepository repository;

	@RequestMapping(value = "support/v1/recipients", method = RequestMethod.GET)
	public ResponseEntity<List<Recipient>> getRecipients() {
		List<Recipient> result = this.repository.findAll();

		if (!result.isEmpty()) {
			return new ResponseEntity<List<Recipient>>(result, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Recipient>>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "support/v1/recipients/{id}", method = RequestMethod.GET)
	public ResponseEntity<Optional<Recipient>> getRecipientById(@PathVariable("id") long id) {
		Optional<Recipient> result = this.repository.findById(id);
		if (result != null) {
			return new ResponseEntity<Optional<Recipient>>(result, HttpStatus.OK);
		} else {
			return new ResponseEntity<Optional<Recipient>>(HttpStatus.NOT_FOUND);
		}
	}
}
