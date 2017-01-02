package br.com.fireware.bpchoque.service.def;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.fireware.bpchoque.entity.Pessoa;
import br.com.fireware.bpchoque.entity.def.ResultadoTheCdc;
import br.com.fireware.bpchoque.entity.def.TesteFisico;
import br.com.fireware.bpchoque.repository.def.ResultadoTheCdcRepository;


@Service
@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
public class ResultadoTheCdcService {

	@Autowired
	private ResultadoTheCdcRepository repository;
	
	
	@Transactional(readOnly = false)
	public void save(ResultadoTheCdc resultadoTheCdc){
		
		repository.save(resultadoTheCdc);
		
	}
	
	
	@Transactional(readOnly = false)
	public void delete(Long id){
		repository.delete(id);
		
	}
	
	
	@Transactional(readOnly = false)
	public void delete(ResultadoTheCdc resultadoTheCdc){
		
		repository.delete(resultadoTheCdc);
		
	}
	
	
	
	public ResultadoTheCdc finById(Long id){
		
		return repository.findOne(id);
		
	}
	
	
	
	public List<ResultadoTheCdc> findAll(){
		return repository.findAll();
	}
	
	
	public List<ResultadoTheCdc> findByTesteFisico(TesteFisico testeFisico){
		
		return repository.findByTesteFisico(testeFisico);
	}
	
	public ResultadoTheCdc finByTesteFisicoAndPessoa(TesteFisico testeFisico, Pessoa pessoa){
		
		return repository.findByTesteFisicoAndPessoa(testeFisico, pessoa);
	}
	
}
	
	