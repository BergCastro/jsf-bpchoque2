//CIA(COD_CIA, NOME_CIA)
package br.com.fireware.bpchoque.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.jpa.domain.AbstractPersistable;



@Entity
@Table(name="companhias")
public class Companhia extends AbstractPersistable<Integer>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="COD_COMPANHIA")
	private Integer id;
	@NotEmpty(message="O campo não pode estar vazio!")
	@Length(max=40, message="O campo tem que ter no máximo {max} caracteres")
	@Column(name="NOME_COMPANHIA", nullable=false, length=40, unique=true)
	private String nome;
	
	
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	
	
}
