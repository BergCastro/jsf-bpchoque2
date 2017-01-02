package br.com.fireware.bpchoque.service.def;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.fireware.bpchoque.entity.Pessoa;
import br.com.fireware.bpchoque.entity.def.ResultadoTheCdc;
import br.com.fireware.bpchoque.entity.def.ResultadoTheCotam;
import br.com.fireware.bpchoque.entity.def.ResultadoTheCotar;
import br.com.fireware.bpchoque.entity.def.TesteFisico;
import br.com.fireware.bpchoque.repository.def.ResultadoTheCdcRepository;
import br.com.fireware.bpchoque.repository.def.ResultadoTheCotarRepository;


@Service
@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
public class ResultadoTheCotarService {

	@Autowired
	private ResultadoTheCotarRepository repository;
	
	
	@Transactional(readOnly = false)
	public void save(ResultadoTheCotar resultadoTheCotar){
		
		repository.save(resultadoTheCotar);
		
	}
	
	
	@Transactional(readOnly = false)
	public void delete(Long id){
		repository.delete(id);
		
	}
	
	
	@Transactional(readOnly = false)
	public void delete(ResultadoTheCotar resultadoTheCotar){
		
		repository.delete(resultadoTheCotar);
		
	}
	
	
	
	public ResultadoTheCotar finById(Long id){
		
		return repository.findOne(id);
		
	}
	
	
	
	public List<ResultadoTheCotar> findAll(){
		return repository.findAll();
	}
	
	
	public List<ResultadoTheCotar> findByTesteFisico(TesteFisico testeFisico){
		
		return repository.findByTesteFisico(testeFisico);
	}


	public ResultadoTheCotar findByTesteFisicoAndPessoa(TesteFisico testeFisico, Pessoa pessoa) {
		
		return repository.findByTesteFisicoAndPessoa(testeFisico, pessoa);
	}



	
	
	
}
	
	