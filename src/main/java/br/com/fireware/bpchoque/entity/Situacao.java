//PATENTE(COD_PATENTE, NOME_PATENTE, ABREVIACAO_PATENTE)

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
@Table(name="situacoes")
public class Situacao extends AbstractPersistable<Long>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="COD_SITUACAO")
	private Long id;
	@NotEmpty(message="O campo não pode estar vazio")
	@Length(max=30, message="A situação tem que ter no máximo {max} caracteres")
	@Column(name="NOME_SITUACAO", nullable= false, length=30, unique=true)
	private String nome;
	@NotEmpty(message="O campo não pode estar vazio")
	@Column(name="DESCRICAO_SITUACAO", length=60, unique=true)
	private String descricao;
	
	
		

	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	
	
	
	
}
