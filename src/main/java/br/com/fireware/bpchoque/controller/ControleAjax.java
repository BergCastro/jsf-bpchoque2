package br.com.fireware.bpchoque.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.springframework.stereotype.Controller;

@Controller
public class ControleAjax implements Serializable{
	private String texto;
	private String saida;
	
	public void inverteTexto(){
		StringBuffer stb = new StringBuffer(texto);
		saida = stb.reverse().toString();		
	}
	
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public String getSaida() {
		return saida;
	}
	public void setSaida(String saida) {
		this.saida = saida;
	}
}
