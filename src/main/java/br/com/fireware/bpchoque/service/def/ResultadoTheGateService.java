package br.com.fireware.bpchoque.service.def;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.fireware.bpchoque.entity.Pessoa;
import br.com.fireware.bpchoque.entity.def.ResultadoTheGate;
import br.com.fireware.bpchoque.entity.def.TesteFisico;
import br.com.fireware.bpchoque.repository.def.ResultadoTheGateRepository;


@Service
@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
public class ResultadoTheGateService {

	@Autowired
	private ResultadoTheGateRepository repository;
	
	
	@Transactional(readOnly = false)
	public void save(ResultadoTheGate resultadoTheGate){
		
		repository.save(resultadoTheGate);
		
	}
	
	
	@Transactional(readOnly = false)
	public void delete(Long id){
		repository.delete(id);
		
	}
	
	
	@Transactional(readOnly = false)
	public void delete(ResultadoTheGate resultadoTheGate){
		
		repository.delete(resultadoTheGate);
		
	}
	
	
	
	public ResultadoTheGate finById(Long id){
		
		return repository.findOne(id);
		
	}
	
	
	
	public List<ResultadoTheGate> findAll(){
		return repository.findAll();
	}
	
	
	public List<ResultadoTheGate> findByTesteFisico(TesteFisico testeFisico){
		
		return repository.findByTesteFisico(testeFisico);
	}


	public ResultadoTheGate findByTesteFisicoAndPessoa(TesteFisico testeFisico, Pessoa pessoa) {
		
		return repository.findByTesteFisicoAndPessoa(testeFisico, pessoa);
	}
	
	
	
}
	
	