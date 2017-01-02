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
@Table(name="PONTOS_TAF")
public class PontosTAF extends AbstractPersistable<Long>{
	@Id
	@GeneratedValue
	@Column(name="COD_PTS_TAF")
	private int id;
	
	@Column(name="SEXO_PTS_TAF")
	private String sexo;
	
	@Column(name="EXERCICIO_PTS_TAF")
	private String exercicio;
	@Column(name="IDADE_INICIAL_PTS_TAF")
	private int idade_inicial;
	@Column(name="IDADE_FINAL_PTS_TAF")
	private int idade_final;
	@Column(name="REF_INICIAL_PTS_TAF")
	private int ref_inicial;
	@Column(name="REF_FINAL_PTS_TAF")
	private int ref_final;
	@Column(name="VALOR_PTS_TAF")
	private int valor;
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getExercicio() {
		return exercicio;
	}
	public void setExercicio(String exercicio) {
		this.exercicio = exercicio;
	}
	public int getIdade_inicial() {
		return idade_inicial;
	}
	public void setIdade_inicial(int idade_inicial) {
		this.idade_inicial = idade_inicial;
	}
	public int getIdade_final() {
		return idade_final;
	}
	public void setIdade_final(int idade_final) {
		this.idade_final = idade_final;
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
