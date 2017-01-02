package br.com.fireware.bpchoque.controller;

import java.util.List;

import javax.faces.bean.*;

import br.com.fireware.bpchoque.entity.def.TesteFisico;
import br.com.fireware.bpchoque.service.RelatorioService;
import br.com.fireware.bpchoque.service.def.TesteFisicoService;

import org.primefaces.model.StreamedContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


import javax.faces.context.FacesContext;
import javax.faces.application.FacesMessage;

import java.util.HashMap;

@Controller
@RequestScoped
public class TesteFisicoBean {
	@Autowired
	private TesteFisicoService testeFisicoService;
	
	
	
	private StreamedContent	arquivoRetorno;
	private int tipoRelatorio;
	
	
	
	public StreamedContent getArquivoRetorno() {
		FacesContext context = FacesContext.getCurrentInstance();
		
		String nomeRelatorioJasper = "testesfisicos"; //(_1_)
		String nomeRelatorioSaida ="testes"; //(_2_)
		RelatorioService relatorioUtil = new RelatorioService();
		HashMap parametrosRelatorio = new HashMap(); //(_3_)
		
		try {
			this.arquivoRetorno = relatorioUtil.geraRelatorio(parametrosRelatorio, nomeRelatorioJasper,
				nomeRelatorioSaida, getLista(), this.tipoRelatorio);
		} catch (br.com.fireware.bpchoque.exception.UtilException e) {
			context.addMessage(null, new FacesMessage(e.getMessage()));
			return null;
		} 
		return this.arquivoRetorno;
	}

	public int getTipoRelatorio() {
		return tipoRelatorio;
	}
	
	public void setTipoRelatorio(int tipoRelatorio) {
		this.tipoRelatorio = tipoRelatorio;
	}

	

	public List<TesteFisico> getLista() {
		
			 
			
		
		return testeFisicoService.findAllList();

	}

	

}
