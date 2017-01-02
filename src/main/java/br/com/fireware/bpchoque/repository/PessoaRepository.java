package br.com.fireware.bpchoque.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.fireware.bpchoque.entity.Pessoa;


public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

	Pessoa findByNome(String nome);
	List<Pessoa> findAll();
	
	Pessoa findById(Long id);
	
	
}
