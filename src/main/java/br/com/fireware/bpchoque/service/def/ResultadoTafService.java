package br.com.fireware.bpchoque.service.def;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.fireware.bpchoque.entity.def.ResultadoTAF;

import br.com.fireware.bpchoque.entity.def.TesteFisico;
import br.com.fireware.bpchoque.repository.def.ResultadoTafRepository;


@Service
@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
public class ResultadoTafService {

	@Autowired
	private ResultadoTafRepository repository;
	
	
	@Transactional(readOnly = false)
	public void save(ResultadoTAF resultadoTaf){
		
		repository.save(resultadoTaf);
		
	}
	
	
	@Transactional(readOnly = false)
	public void delete(Long id){
		repository.delete(id);
		
	}
	
	
	@Transactional(readOnly = false)
	public void delete(ResultadoTAF resultadoTaf){
		
		repository.delete(resultadoTaf);
		
	}
	
	
	
	public ResultadoTAF finById(Long id){
		
		return repository.findOne(id);
		
	}
	
	
	
	public List<ResultadoTAF> findAll(){
		return repository.findAll();
	}
	
	
	public List<ResultadoTAF> findByTesteFisico(TesteFisico testeFisico){
		
		return repository.findByTesteFisicoOrderByParticipante(testeFisico);
	}
	
	public Integer findNota(String exercicio, Integer idade, Integer valor, String sexo){
		
		
			return repository.findNota(exercicio, idade, valor, sexo);	
		
			
		
		
		
		
	}
	
	
	
}
	
	