package br.com.fireware.bpchoque.service.def;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.fireware.bpchoque.entity.Pessoa;
import br.com.fireware.bpchoque.entity.def.ResultadoTheCdc;
import br.com.fireware.bpchoque.entity.def.ResultadoTheCotam;
import br.com.fireware.bpchoque.entity.def.TesteFisico;
import br.com.fireware.bpchoque.repository.def.ResultadoTheCdcRepository;
import br.com.fireware.bpchoque.repository.def.ResultadoTheCotamRepository;


@Service
@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
public class ResultadoTheCotamService {

	@Autowired
	private ResultadoTheCotamRepository repository;
	
	
	@Transactional(readOnly = false)
	public void save(ResultadoTheCotam resultadoTheCotam){
		
		repository.save(resultadoTheCotam);
		
	}
	
	
	@Transactional(readOnly = false)
	public void delete(Long id){
		repository.delete(id);
		
	}
	
	
	@Transactional(readOnly = false)
	public void delete(ResultadoTheCotam resultadoTheCotam){
		
		repository.delete(resultadoTheCotam);
		
	}
	
	
	
	public ResultadoTheCotam finById(Long id){
		
		return repository.findOne(id);
		
	}
	
	
	
	public List<ResultadoTheCotam> findAll(){
		return repository.findAll();
	}
	
	
	public List<ResultadoTheCotam> findByTesteFisico(TesteFisico testeFisico){
		
		return repository.findByTesteFisico(testeFisico);
	}


	public ResultadoTheCotam findByTesteFisicoAndPessoa(TesteFisico testeFisico, Pessoa pessoa) {
	
		return repository.findByTesteFisicoAndPessoa(testeFisico, pessoa);
	}
	
	
	
}
	
	