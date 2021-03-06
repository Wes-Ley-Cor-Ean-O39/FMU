package br.com.treinaweb.springbootapi.controller;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.treinaweb.springbootapi.entity.Desbravador;
import br.com.treinaweb.springbootapi.repository.DesbravadorRepository;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DesbravadorController {

	@Autowired
	private DesbravadorRepository _desbravadorRepository;

	@RequestMapping(value = "/desbravador", method = RequestMethod.GET, produces = "application/json")
	public List<Desbravador> Get() {
		log.info("Realizando consulta de todos os Desbravadores...");
		return _desbravadorRepository.findAll();
	}

	@RequestMapping(value = "/desbravador/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Desbravador> GetById(@PathVariable(value = "id") long id) {
		Optional<Desbravador> dbv = _desbravadorRepository.findById(id);
		if (dbv.isPresent()) {
			log.info("Consultando Desbravador especifico: " + id);
			return new ResponseEntity<Desbravador>(dbv.get(), HttpStatus.OK);
		} else
			log.info("Desbravador não encontrado!");
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/desbravador", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public Desbravador Post(@Valid @RequestBody Desbravador dbv) {
		log.info("Salvando Desbravador na base. " + dbv.toString());
		return _desbravadorRepository.save(dbv);
	}

	@Transactional
	@RequestMapping(value = "/desbravador/{id}", method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
	public ResponseEntity<Desbravador> Put(@PathVariable(value = "id") long id,
			@Valid @RequestBody Desbravador novoDbv) {
		Optional<Desbravador> oldDbv = _desbravadorRepository.findById(id);
		if (oldDbv.isPresent()) {
			Desbravador dbv = oldDbv.get();
			dbv.setNome(novoDbv.getNome());
			log.info("Atualizando Desbravador! " + dbv.toString());
			_desbravadorRepository.save(dbv);
			return new ResponseEntity<Desbravador>(dbv, HttpStatus.OK);
		} else
			log.info("Desbravador não encontrado! " + oldDbv.toString());
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/desbravador/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id) {
		Optional<Desbravador> dbv = _desbravadorRepository.findById(id);
		if (dbv.isPresent()) {
			_desbravadorRepository.delete(dbv.get());
			log.info("Desbravador deletado da base!");
			return new ResponseEntity<>(HttpStatus.OK);
		} else
			log.info("Desbravador não encontrado!");
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
}