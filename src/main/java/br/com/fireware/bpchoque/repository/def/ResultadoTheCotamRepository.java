package br.com.fireware.bpchoque.repository.def;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fireware.bpchoque.entity.Pessoa;
import br.com.fireware.bpchoque.entity.def.ResultadoTheCotam;

import br.com.fireware.bpchoque.entity.def.TesteFisico;


public interface ResultadoTheCotamRepository extends JpaRepository<ResultadoTheCotam, Long> {

	List<ResultadoTheCotam> findAll();
	List<ResultadoTheCotam> findByTesteFisico(TesteFisico testeFisico);
	ResultadoTheCotam findByTesteFisicoAndPessoa(TesteFisico testeFisico, Pessoa pessoa);

}
