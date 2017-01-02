package br.com.fireware.bpchoque.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.fireware.bpchoque.entity.Cargo;
import br.com.fireware.bpchoque.service.CargoService;

@Controller

public class CargoController {

	
	@RequestMapping(value = "/Cargos")
	public ModelAndView testeFisico() {
		return new ModelAndView("/cargos");

	
	}
	
	
	
	@Autowired
	CargoService cargoService;
	
	

	private Cargo cargo = new Cargo();

	private Iterable<Cargo> cargos;

	private Boolean editando;
	
	private Boolean cargosAtualizados;
	
	

	
	
	@PostConstruct
	public void init(){
		editando = false;
		cargosAtualizados = false;
		
	}
	
	
	
	
	
	public Boolean getEditando() {
		return editando;
	}

	public void setEditando(Boolean editando) {
		this.editando = editando;
	}

	public void setCargos(Iterable<Cargo> cargos) {
		this.cargos = cargos;

	}

	public Iterable<Cargo> getCargos() {
		if(cargosAtualizados || cargos == null){
			cargos = cargoService.findAll();
			cargosAtualizados = false;
		}
		
		return cargos;
	}

	
	
	public void novo(){
		cargo = new Cargo();
		editando = true;
		
	}

	public void salvar() {

		cargoService.save(cargo);
		editando = false;
		cargosAtualizados = true;

	}
	
	public void cancelar(){
		editando = false;
		
	}

	public void excluir(Cargo cargo) {

		cargoService.delete(cargo.getId());
		cargosAtualizados = true;

	}

	public void alterar(Cargo cargo){
		this.cargo = cargo;
		editando = true;
	}

	
	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

}
