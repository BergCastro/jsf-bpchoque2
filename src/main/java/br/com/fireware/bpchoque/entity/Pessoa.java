/**
 PESSOA(COD_PESSOA, NOME_PESSOA, LOGRADOURO_PESSOA, NUMERO_END_PESSOA,
  COMPLEMENTO_END_PESSOA, COD_CIDADE, 
 COD_BAIRRO, COD_UF, CEP_PESSOA, DATA_NASC_PESSOA,
  EMAIL_PESSOA, CPF_PESSOA, COD_ESTADO_CIVIL, COD_SEXO)
 **/

package br.com.fireware.bpchoque.entity;


import java.time.LocalDate;
import java.time.Period;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.data.jpa.domain.AbstractPersistable;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Table(name = "pessoas")
@Entity
											// Pessoa e a relaciona
public class Pessoa {

	

	/**
	 * 
	 */
	

	public enum EstadoCivil {
		CASADO, SOLTEIRO
	}

	public enum Sexo {
		MASCULINO, FEMININO

	}

	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "COD_PESSOA")
	protected Long id;
	@NotEmpty(message = "O campo não pode estar vazio!")
	@Length(max = 60, message = "O nome tem que ter no máximo {max} caracteres")
	@Column(name = "NOME_PESSOA", nullable = false, length = 60)
	protected String nome;

	@NotNull(message = "Selecione uma opção!")
	@Enumerated(EnumType.STRING)
	@Column(name = "SEXO")
	protected Sexo sexo;

	
	/*@Length(max = 30, message = "O logradouro tem que ter no máximo {max} caracteres")
	@Column(name = "LOGRADOURO_ENDERECO", nullable = false, length = 30, columnDefinition="VARCHAR(30) DEFAULT 'RUA FALTANDO'")
	private String logradouro;

	
	@Length(max = 6, message = "O número tem que ter no máximo {max} caracteres")
	@Column(name = "NUMERO_ENDERECO", length = 6, columnDefinition="VARCHAR(6) DEFAULT 'FALTA'")
	private String numero;

	
	@Length(max = 30, message = "O complemento tem que ter no máximo {max} caracteres")
	@Column(name = "COMPLEMENTO_ENDERECO", length = 30)
	private String complemento;*/

	
	/*@ManyToOne
	@JoinColumn(name = "COD_BAIRRO", columnDefinition="BIGINT(20) DEFAULT '1'")
	private Bairro bairro;*/
	
	
	
	

	@NotNull(message = "Insira uma data válida!")
	@Column(name = "DATA_NAS_PESSOA", length = 8, columnDefinition="DATE DEFAULT '1978-08-25'")
	protected LocalDate datanasc;

	
	

	@Enumerated(EnumType.STRING)
	@Column(name = "ESTADO_CIVIL")
	protected EstadoCivil estado_civil;

	@Lob
	@Column(name = "FOTO_PESSOA")
	protected Byte[] foto;
	
	@Column(name= "PESSOA_TIPO")
	private String tipo;

	@Column(name = "MATRICULA_MILITAR", nullable = false, unique = true)
	private String matricula;

	@NotNull(message = "Selecione uma opção!")
	@ManyToOne(optional = false)
	@JoinColumn(name = "COD_CARGO")
	private Cargo cargo;

	//@NotEmpty(message = "O campo não pode estar vazio!")
	//@Digits(integer = 6, fraction = 0, message = "Digite apenas números neste campo!")
	
	@Column(name = "NUMERO_PM_MILITAR", length = 6)
	private String numero_pm;

	//@NotEmpty(message = "O campo não pode estar vazio!")
	@Length(max = 20, message = "O campo tem que ter no máximo {max} caracteres")
	@Column(name = "NOME_GUERRA_MILITAR", length = 20)
	private String nome_guerra;

	

	
	@Column(name = "OPM_MILITAR")
	private String opm;




	

	
	
	
	public static int idade(final LocalDate aniversario) {
	    final LocalDate dataAtual = LocalDate.now();
	    final Period periodo = Period.between(aniversario, dataAtual);
	    return periodo.getYears();
	}
	
	public static int idadeAvaliacao(final LocalDate aniversario) {
	    final int anoAtual = LocalDate.now().getYear();
	    final int anoAniversario = aniversario.getYear();
	    final int resultado = anoAtual-anoAniversario; 
	    
	    return resultado;
	}

		
	
	

}
