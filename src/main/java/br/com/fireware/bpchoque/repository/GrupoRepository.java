package br.com.fireware.bpchoque.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.fireware.bpchoque.entity.Companhia;
import br.com.fireware.bpchoque.entity.Grupo;


public interface GrupoRepository extends JpaRepository<Grupo, Long>{

	Grupo findByNome(String nome);
	
	/*@Query("select g from Grupo g where g.companhia=?1")
	List<Grupo> buscaPorCompanhia(Integer cod);*/
	
	List<Grupo> findByCompanhia(Companhia cia);

}
