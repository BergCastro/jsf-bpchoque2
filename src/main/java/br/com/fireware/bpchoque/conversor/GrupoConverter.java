package br.com.fireware.bpchoque.conversor;

import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.fireware.bpchoque.entity.Grupo;

import br.com.fireware.bpchoque.repository.GrupoRepository;


@Component
public class GrupoConverter implements Converter{
	
	@Autowired
	GrupoRepository grupoRepository;

	

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String string) {
		
		if(string.isEmpty()){
			return null;
		}
		try{
		Grupo grupo = grupoRepository.findOne(new Long(string));
		return grupo;
		}
		catch (Exception e) {
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object obj) {
		if (obj instanceof Grupo) {
			
			Grupo retorno = (Grupo) obj;
			return retorno.getId().toString();
			
		}else{
			return null;	
		}
		
		
	}
	
	
}
