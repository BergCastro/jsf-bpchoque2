package br.com.fireware.bpchoque.controller;

import java.util.List;

import javax.faces.event.AjaxBehaviorEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.fireware.bpchoque.entity.Companhia;
import br.com.fireware.bpchoque.entity.Grupo;

import br.com.fireware.bpchoque.service.GrupoService;

@Controller

public class GrupoController {

	@Autowired
	GrupoService grupoService;

	private Grupo grupo = new Grupo();

	private Iterable<Grupo> grupos;
	
	
	

	
	

	public void salvar(Grupo grupo) {

		grupoService.save(grupo);
		this.grupo = new Grupo();

	}

	public void excluir(Grupo grupo) {

		System.out.println("Entrou no método excluir");
		grupoService.delete(grupo.getId());

	}

	public void editar(Grupo grupo) {

	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}
	
	

}
