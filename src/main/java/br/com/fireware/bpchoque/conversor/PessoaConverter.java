package br.com.fireware.bpchoque.conversor;





import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



import br.com.fireware.bpchoque.entity.Pessoa;

import br.com.fireware.bpchoque.repository.PessoaRepository;


@Component
public class PessoaConverter implements Converter{
	
	@Autowired
	PessoaRepository pessoaRepository;
	
	

	

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String string) {
		
		if(string.isEmpty()){
			return null;
		}
		try{
		Pessoa pessoa = pessoaRepository.findById(new Long(string));
		return pessoa;
		}
		catch (Exception e) {
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object obj) {
		if (obj instanceof Pessoa) {
			
			Pessoa retorno = (Pessoa) obj;
			return retorno.getNome().toString();
		}
		else{
			return null;	
		}
		
		
	}
	
	
}
