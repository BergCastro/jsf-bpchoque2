package br.com.fireware.bpchoque.entity.def;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Table(name="objetivo_teste_fisico")
@Entity
public class ObjetivoTesteFisico extends AbstractPersistable<Long>{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="COD_OBJ_TESTE_FISICO")
	private Long id;
	@NotEmpty(message="O campo não pode estar vazio!")
	@Length(max=40, message="O nome tem que ter no máximo {max} caracteres")
	@Column(name="OBJ_TESTE_FISICO", nullable=false, unique=true, length=40)
	private String objetivo;
	
	
	public String getObjetivo() {
		return objetivo;
	}
	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}
	
	
	
	
}
