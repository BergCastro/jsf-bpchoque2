package br.com.fireware.bpchoque.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;



import br.com.fireware.bpchoque.entity.Pessoa;

import br.com.fireware.bpchoque.repository.PessoaRepository;


@Service
@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
public class PessoaService {

	@Autowired
	private PessoaRepository repository;
	
	
	@Transactional(readOnly = false)
	public void save(Pessoa pessoa){
		
		repository.save(pessoa);
		
	}
	
	
	@Transactional(readOnly = false)
	public void delete(Long id){
		repository.delete(id);
		
	}
	
	
	@Transactional(readOnly = false)
	public void delete(Pessoa pessoa){
		
		repository.delete(pessoa);
		
	}
	
	
	
	public Pessoa finById(Long id){
		
		return repository.findOne(id);
		
	}
	
	public Pessoa findByNome(String nome){
		return repository.findByNome(nome);
	}
	
	
	public List<Pessoa> findAll(){
		return repository.findAll();
	}
	
	public List<Pessoa> findTodos(){
		
		return repository.findAll();
	}


	public Pessoa findById(Long id) {
	
		return repository.findById(id);
		
	}
	
	
}
	
	