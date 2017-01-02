package br.com.fireware.bpchoque.conversor;

import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.fireware.bpchoque.entity.Companhia;

import br.com.fireware.bpchoque.repository.CompanhiaRepository;


@Component
public class CompanhiaConverter implements Converter{
	
	@Autowired
	CompanhiaRepository companhiaRepository;

	

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String string) {
		
		if(string.isEmpty()){
			return null;
		}
		try{
		Companhia companhia = companhiaRepository.findOne(new Integer(string));
		return companhia;
		}
		catch (Exception e) {
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object obj) {
		if (obj instanceof Companhia) {
			
			Companhia retorno = (Companhia) obj;
			return retorno.getId().toString();
			
		}else{
			return null;	
		}
		
		
	}
	
	
}
