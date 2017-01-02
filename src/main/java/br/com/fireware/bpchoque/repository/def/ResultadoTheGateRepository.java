package br.com.fireware.bpchoque.repository.def;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fireware.bpchoque.entity.Pessoa;
import br.com.fireware.bpchoque.entity.def.ResultadoTheGate;
import br.com.fireware.bpchoque.entity.def.TesteFisico;


public interface ResultadoTheGateRepository extends JpaRepository<ResultadoTheGate, Long> {

	List<ResultadoTheGate> findAll();
	List<ResultadoTheGate> findByTesteFisico(TesteFisico testeFisico);
	ResultadoTheGate findByTesteFisicoAndPessoa(TesteFisico testeFisico, Pessoa pessoa);

}
