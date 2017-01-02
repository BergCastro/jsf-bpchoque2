package br.com.fireware.bpchoque.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
@Table(name="telefones")
public class Telefone extends AbstractPersistable<Long>{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public enum TipoTelefone{
		CELULAR, COMERCIAL, RESIDENCIAL
	}
	

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="COD_TELEFONE")
	private Long id;
	
	@Enumerated(EnumType.STRING)
	@Column(name="TIPO_TELEFONE")
	private TipoTelefone tipoTelefone;
	
	@NotEmpty(message="O campo não pode estar vazio!")
	@Column(name="NUMERO_TELEFONE", nullable= false, length=12, unique=true)
	private String numero;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name="COD_PESSOA")
	private Pessoa pessoa;

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public TipoTelefone getTipoTelefone() {
		return tipoTelefone;
	}

	public void setTipoTelefone(TipoTelefone tipoTelefone) {
		this.tipoTelefone = tipoTelefone;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public Telefone(){
		super();
	}

	public Telefone(TipoTelefone tipoTelefone, String numero, Pessoa pessoa) {
		super();
		this.tipoTelefone = tipoTelefone;
		this.numero = numero;
		this.pessoa = pessoa;
	}

	
		
	
	
}
