package br.com.fireware.bpchoque.service;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;



import br.com.fireware.bpchoque.entity.Companhia;

import br.com.fireware.bpchoque.repository.CompanhiaRepository;

@Service
@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
public class CompanhiaService {

	@Autowired
	private CompanhiaRepository repository;
	
	
	private List<Companhia> cias;
	
	
	
	
	public CompanhiaService() {
		cias = new ArrayList<Companhia>();
	}
	
	
	public List<Companhia> getCias() {
		
		cias = repository.findAll();
		return cias;
	}


	public void setCias(List<Companhia> cias) {
		this.cias = cias;
	}


	@Transactional(readOnly = false)
	public void save(Companhia companhia){
		
		repository.save(companhia);
		
	}
	
	
	
	
	@Transactional(readOnly = false)
	public void delete(Integer id){
		repository.delete(id);
		
	}
	
	
	@Transactional(readOnly = false)
	public void delete(Companhia companhia){
		
		repository.delete(companhia);
		
	}
	
	
	
	
	
	
	public Iterable<Companhia> findAll(){
		return repository.findAll();
	}
	
	
	public Companhia findOne(Integer id){
		
		return repository.findOne(id);
	
	}
	
	
	
	
	
	
	
}
