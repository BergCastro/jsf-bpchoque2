package br.com.fireware.bpchoque.conversor;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.springframework.stereotype.Component;

@Component
public class ToLowerCaseConverter implements Converter {
 
    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return (value != null) ? value.toString().toLowerCase() : null;
    }
 
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return (value != null) ? value.toLowerCase() : null;
    }
}
