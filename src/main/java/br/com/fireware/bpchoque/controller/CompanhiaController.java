package br.com.fireware.bpchoque.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.fireware.bpchoque.entity.Companhia;

import br.com.fireware.bpchoque.service.CompanhiaService;

@Controller

public class CompanhiaController {

	
	@Autowired
	CompanhiaService companhiaService;

	private Companhia companhia = new Companhia();

	private Iterable<Companhia> companhias;

	public Iterable<Companhia> getCompanhias() {
		return companhiaService.findAll();
	}

	public void setCompanhias(Iterable<Companhia> companhias) {
		this.companhias = companhias;
	}

	public void salvar(Companhia companhia) {

		companhiaService.save(companhia);
		this.companhia = new Companhia();

	}

	public void excluir(Companhia companhia) {

		System.out.println("Entrou no método excluir");
		companhiaService.delete(companhia.getId());

	}

	public void editar(Companhia companhia) {

	}

	public Companhia getCompanhia() {
		return companhia;
	}

	public void setCompanhia(Companhia companhia) {
		this.companhia = companhia;
	}

}
