package br.com.fireware.bpchoque.repository.def;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fireware.bpchoque.entity.Pessoa;
import br.com.fireware.bpchoque.entity.def.ResultadoTheCdc;
import br.com.fireware.bpchoque.entity.def.TesteFisico;


public interface ResultadoTheCdcRepository extends JpaRepository<ResultadoTheCdc, Long> {

	List<ResultadoTheCdc> findAll();
	List<ResultadoTheCdc> findByTesteFisico(TesteFisico testeFisico);
	ResultadoTheCdc findByTesteFisicoAndPessoa(TesteFisico testeFisico, Pessoa pessoa);

}
