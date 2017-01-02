package br.com.fireware.bpchoque.service.def;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.fireware.bpchoque.entity.Pessoa;
import br.com.fireware.bpchoque.entity.def.ResultadoTheCanil;
import br.com.fireware.bpchoque.entity.def.TesteFisico;
import br.com.fireware.bpchoque.repository.def.ResultadoTheCanilRepository;


@Service
@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
public class ResultadoTheCanilService {

	@Autowired
	private ResultadoTheCanilRepository repository;
	
	
	@Transactional(readOnly = false)
	public void save(ResultadoTheCanil resultadoTheCanil){
		
		repository.save(resultadoTheCanil);
		
	}
	
	
	@Transactional(readOnly = false)
	public void delete(Long id){
		repository.delete(id);
		
	}
	
	
	@Transactional(readOnly = false)
	public void delete(ResultadoTheCanil resultadoTheCanil){
		
		repository.delete(resultadoTheCanil);
		
	}
	
	
	
	public ResultadoTheCanil finById(Long id){
		
		return repository.findOne(id);
		
	}
	
	
	
	public List<ResultadoTheCanil> findAll(){
		return repository.findAll();
	}
	
	
	public List<ResultadoTheCanil> findByTesteFisico(TesteFisico testeFisico){
		
		return repository.findByTesteFisico(testeFisico);
	}


	public ResultadoTheCanil findByTesteFisicoAndPessoa(TesteFisico testeFisico, Pessoa pessoa) {
		
		return repository.findByTesteFisicoAndPessoa(testeFisico, pessoa);
	}
	
	
	
}
	
	