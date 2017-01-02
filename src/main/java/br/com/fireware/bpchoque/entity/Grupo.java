package br.com.fireware.bpchoque.entity;



import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name="grupos")
public class Grupo extends AbstractPersistable<Long>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="COD_GRUPO")
	private Long id;
	
	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="COD_COMPANHIA")
	private Companhia companhia;
	@NotEmpty(message="O campo não pode estar vazio!")
	@Length(max=30, message="O campo tem que ter no máximo {max} caracteres")
	@Column(name="NOME_GRUPO", nullable= false, length=30, unique=true)
	private String nome;
	@NotEmpty(message="O campo não pode estar vazio!")
	@Length(max=20, message="O campo tem que ter no máximo {max} caracteres")
	@Column(name="ABREVIACAO_GRUPO", nullable= false, length=20, unique=true)
	private String abreviacao;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Companhia getCompanhia() {
		return companhia;
	}
	public void setCompanhia(Companhia companhia) {
		this.companhia = companhia;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String grupo) {
		this.nome = grupo;
	}
	public String getAbreviacao() {
		return abreviacao;
	}
	public void setAbreviacao(String abreviacao) {
		this.abreviacao = abreviacao;
	}
	
	
	
}
