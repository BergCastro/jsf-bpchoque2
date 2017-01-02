package br.com.fireware.bpchoque.repository.def;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fireware.bpchoque.entity.Pessoa;
import br.com.fireware.bpchoque.entity.def.ResultadoTheCotar;
import br.com.fireware.bpchoque.entity.def.TesteFisico;


public interface ResultadoTheCotarRepository extends JpaRepository<ResultadoTheCotar, Long> {

	List<ResultadoTheCotar> findAll();
	List<ResultadoTheCotar> findByTesteFisico(TesteFisico testeFisico);
	ResultadoTheCotar findByTesteFisicoAndPessoa(TesteFisico testeFisico, Pessoa pessoa);

}
