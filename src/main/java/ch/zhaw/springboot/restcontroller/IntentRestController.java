package ch.zhaw.springboot.restcontroller;

import ch.zhaw.springboot.entities.Intent;
import ch.zhaw.springboot.repositories.IntentRepository;
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
public class IntentRestController {

	@Autowired
	private IntentRepository repository;

	@RequestMapping(value = "feedback/v1/intents", method = RequestMethod.GET)
	public ResponseEntity<List<Intent>> getIntents() {
		List<Intent> result = this.repository.findAll();

		if (!result.isEmpty()) {
			return new ResponseEntity<List<Intent>>(result, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Intent>>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "feedback/v1/intents/{id}", method = RequestMethod.GET)
	public ResponseEntity<Optional<Intent>> getIntentById(@PathVariable("id") long id) {
		Optional<Intent> result = this.repository.findById(id);
		if (result != null) {
			return new ResponseEntity<Optional<Intent>>(result, HttpStatus.OK);
		} else {
			return new ResponseEntity<Optional<Intent>>(HttpStatus.NOT_FOUND);
		}
	}
}
