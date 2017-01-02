package br.com.fireware.bpchoque.entity.def;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;




@Entity
@Table(name="PONTOS_THE_COTAR")
public class PontosTheCotar extends AbstractPersistable<Long>{
	@Id
	@GeneratedValue
	@Column(name="COD_PTS")
	private int id;
	
	
	
	@Column(name="EXERCICIO_PTS")
	private String exercicio;
	
	@Column(name="REF_INICIAL_PTS")
	private int ref_inicial;
	@Column(name="REF_FINAL_PTS")
	private int ref_final;
	@Column(name="VALOR_PTS")
	private int valor;
	
	public String getExercicio() {
		return exercicio;
	}
	public void setExercicio(String exercicio) {
		this.exercicio = exercicio;
	}
	
	public int getRef_inicial() {
		return ref_inicial;
	}
	public void setRef_inicial(int ref_inicial) {
		this.ref_inicial = ref_inicial;
	}
	public int getRef_final() {
		return ref_final;
	}
	public void setRef_final(int ref_final) {
		this.ref_final = ref_final;
	}
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
	
	
}
