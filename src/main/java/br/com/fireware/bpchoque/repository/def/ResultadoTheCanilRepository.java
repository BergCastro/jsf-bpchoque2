package br.com.fireware.bpchoque.repository.def;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fireware.bpchoque.entity.Pessoa;
import br.com.fireware.bpchoque.entity.def.ResultadoTheCanil;
import br.com.fireware.bpchoque.entity.def.ResultadoTheCotam;

import br.com.fireware.bpchoque.entity.def.TesteFisico;


public interface ResultadoTheCanilRepository extends JpaRepository<ResultadoTheCanil, Long> {

	List<ResultadoTheCanil> findAll();
	List<ResultadoTheCanil> findByTesteFisico(TesteFisico testeFisico);
	ResultadoTheCanil findByTesteFisicoAndPessoa(TesteFisico testeFisico, Pessoa pessoa);

}
