package br.com.fireware.bpchoque.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.fireware.bpchoque.entity.Companhia;
import br.com.fireware.bpchoque.entity.Grupo;
import br.com.fireware.bpchoque.entity.Pessoa;
import br.com.fireware.bpchoque.entity.Cargo;
import br.com.fireware.bpchoque.entity.Pessoa.EstadoCivil;
import br.com.fireware.bpchoque.entity.Pessoa.Sexo;
import br.com.fireware.bpchoque.service.CompanhiaService;
import br.com.fireware.bpchoque.service.GrupoService;
import br.com.fireware.bpchoque.service.PessoaService;

@Controller
public class PessoaController {

	
	@RequestMapping(value = {"/Pessoas"})
	public ModelAndView error() {
		return new ModelAndView("/pessoas");
	}
	
	
	@Autowired
	PessoaService pessoaService;

	@Autowired
	GrupoService grupoService;

	@Autowired
	CompanhiaService companhiaService;
	
	

	private Grupo grupo = new Grupo();

	private Companhia cia = null;

	private Pessoa pessoa = new Pessoa();

	

	

	private Iterable<Pessoa> pessoas;

	private Boolean pertenceBtl;

	private boolean editandoPessoa;

	public PessoaController() {

		pertenceBtl = true;

	}

	public EstadoCivil[] getEstadoCivil() {
		return EstadoCivil.values();
	}

	public Sexo[] getSexos() {
		return Sexo.values();
	}

	@PostConstruct
	public void init() {
		// cia = companhiaService.findOne(1);

	}

	

	public boolean isEditandoPessoa() {
	
		return editandoPessoa;
		
	}

	public void setEditandoPessoa(boolean editandoPessoa) {
		this.editandoPessoa = editandoPessoa;
	}

	

	public void novoPessoa() {
		pessoa = new Pessoa();
		
		editandoPessoa = true;
	}

	public void salvar() {

		pessoaService.save(pessoa);
		editandoPessoa = false;

	}

	public void cancelar() {

		editandoPessoa = false;

	}

	public void alterar(Pessoa pessoa) {
		this.pessoa = pessoa;
		editandoPessoa = true;
		
		
		try {
			//setCia(pessoa.getGrupo().getCompanhia());
			//cidadeController.setEstado(pessoa.getBairro().getCidade().getEstado());
			//bairroController.setCidade(pessoa.getBairro().getCidade());
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	

	

	public void excluirPessoa(Pessoa pessoa) {

		pessoaService.delete(pessoa.getId());

	}

	public Grupo getGrupo() {

		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public Companhia getCia() {

		return cia;
	}

	public void setCia(Companhia cia) {
		this.cia = cia;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	

	

	public void setPessoas(Iterable<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	public Boolean getPertenceBtl() {
		return pertenceBtl;
	}

	public void setPertenceBtl(Boolean pertenceBtl) {
		this.pertenceBtl = pertenceBtl;
	}

	public Iterable<Pessoa> getPessoas() {

		pessoas = pessoaService.findAll();

		return pessoas;

	}

}
