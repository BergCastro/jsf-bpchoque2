package br.com.fireware.bpchoque.repository.def;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;



import br.com.fireware.bpchoque.entity.def.TesteFisico;

public interface TesteFisicoRepository extends JpaRepository<TesteFisico, Long> {
	
	List<TesteFisico> findAll();
	

}
