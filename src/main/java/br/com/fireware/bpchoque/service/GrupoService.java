package br.com.fireware.bpchoque.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.fireware.bpchoque.entity.Companhia;
import br.com.fireware.bpchoque.entity.Grupo;

import br.com.fireware.bpchoque.repository.GrupoRepository;

@Service
@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
public class GrupoService {

	@Autowired
	private GrupoRepository repository;
	
	Iterable<Grupo> grupos;

	public Iterable<Grupo> findAll() {
		
		grupos = repository.findAll();
		
		
		return grupos;
	}

	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}

	@Transactional(readOnly = false)
	public void save(Grupo grupo) {

		repository.save(grupo);

	}

	@Transactional(readOnly = false)
	public void delete(Long id) {
		repository.delete(id);

	}

	@Transactional(readOnly = false)
	public void delete(Grupo grupo) {

		repository.delete(grupo);

	}

	public Grupo finById(Long id) {

		return repository.findOne(id);

	}

	public Grupo findByNome(String nome) {
		return repository.findByNome(nome);
	}
	
	

	public List<Grupo> findByCompanhia(Companhia cia) {
		
		return repository.findByCompanhia(cia);
		
		
	}
	
	

}