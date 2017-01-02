package br.com.fireware.bpchoque.conversor;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.fireware.bpchoque.entity.Pessoa;
import br.com.fireware.bpchoque.service.PessoaService;

@Component
public class PessoaConverter2 implements Converter {

	@Autowired
	PessoaService pessoaService;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
	   Long id = Long.valueOf(value);
		return pessoaService.findById(id);
		
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		return ((Pessoa)value).getId().toString();
	}
}