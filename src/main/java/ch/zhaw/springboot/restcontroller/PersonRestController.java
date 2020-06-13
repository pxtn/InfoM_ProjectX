package ch.zhaw.springboot.restcontroller;

import ch.zhaw.springboot.entities.Person;
import ch.zhaw.springboot.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class PersonRestController {

	@Autowired
	private PersonRepository repository;

	@RequestMapping(value = "support/v1/persons", method = RequestMethod.GET)
	public ResponseEntity<List<Person>> getPersons() {
		List<Person> result = this.repository.findAll();

		if (!result.isEmpty()) {
			return new ResponseEntity<List<Person>>(result, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Person>>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "support/v1/persons/{id}", method = RequestMethod.GET)
	public ResponseEntity<Optional<Person>> getPersonById(@PathVariable("id") long id) {
		Optional<Person> result = this.repository.findById(id);
		if (result != null) {
			return new ResponseEntity<Optional<Person>>(result, HttpStatus.OK);
		} else {
			return new ResponseEntity<Optional<Person>>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "support/v1/persons/names/{date}", method = RequestMethod.GET)
	public ResponseEntity<List<String>> getNameOfPersonThatIsSenderOfMessageFromDate(@PathVariable("date") Date date) {
		List<String> result = this.repository.getNameOfPersonThatIsSenderOfMessageFromDate(date);
		if (result != null) {
			return new ResponseEntity<List<String>>(result, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<String>>(HttpStatus.NOT_FOUND);
		}
	}
}
