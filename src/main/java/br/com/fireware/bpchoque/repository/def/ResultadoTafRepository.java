package br.com.fireware.bpchoque.repository.def;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.fireware.bpchoque.entity.def.ResultadoTAF;

import br.com.fireware.bpchoque.entity.def.TesteFisico;


public interface ResultadoTafRepository extends JpaRepository<ResultadoTAF, Long> {

	List<ResultadoTAF> findAll();
	List<ResultadoTAF> findByTesteFisicoOrderByParticipante(TesteFisico testeFisico);
	@Query("select r.valor from PontosTAF r where r.exercicio=?1 and r.idade_inicial <= ?2 and r.idade_final >=?2 and r.ref_inicial <= ?3 and r.ref_final >=?3 and r.sexo=?4") 
	Integer findNota(String exercicio, Integer idade, Integer valor, String sexo);
	

}
