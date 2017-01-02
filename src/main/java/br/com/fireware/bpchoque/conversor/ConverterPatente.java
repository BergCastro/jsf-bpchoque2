package br.com.fireware.bpchoque.conversor;

import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.fireware.bpchoque.entity.Cargo;
import br.com.fireware.bpchoque.repository.CargoRepository;

@Component
public class ConverterPatente implements Converter{
	
	@Autowired
	CargoRepository cargoRepository;

	

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String string) {
		
		if(string.isEmpty()){
			return null;
		}
		try{
		Cargo cargo = cargoRepository.findOne(new Long(string));
		return cargo;
		}
		catch (Exception e) {
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object obj) {
		if (obj instanceof Cargo) {
			
			Cargo retorno = (Cargo) obj;
			return retorno.getId().toString();
			
		}else{
			return null;	
		}
		
		
	}
	
	
}
