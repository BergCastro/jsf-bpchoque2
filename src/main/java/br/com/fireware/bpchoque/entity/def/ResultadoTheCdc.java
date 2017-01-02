package br.com.fireware.bpchoque.entity.def;

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
import javax.persistence.OneToOne;
import javax.persistence.Table;


import br.com.fireware.bpchoque.entity.Pessoa;

@Table(name="RESULTADO_THE_CDC")
@Entity
public class ResultadoTheCdc {
	
	public enum SituacaoTheCdc{
		APTO, INAPTO
	}
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="COD_RTHE_CDC")
	private Long id;
	
	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name = "COD_TESTE_FISICO")
	private TesteFisico testeFisico;
	
	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name = "COD_PESSOA")
	private Pessoa pessoa;
		
	private String participante;
	
	
	private String corrida_5km;
	
	
	
	private String granada;
	
	
	
	private String natacao_50m;
	
	
	
	private String flutuacao;
	
	
	
	
	
	
	
	
	
	
	public String getParticipante() {
		return participante;
	}

	public void setParticipante(String participante) {
		this.participante = participante;
	}

	
	public TesteFisico getTesteFisico() {
		return testeFisico;
	}

	public void setTesteFisico(TesteFisico testeFisico) {
		this.testeFisico = testeFisico;
	}

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

	public String getCorrida_5km() {
		return corrida_5km;
	}

	public void setCorrida_5km(String corrida_5km) {
		this.corrida_5km = corrida_5km;
	}

	public String getGranada() {
		return granada;
	}

	public void setGranada(String granada) {
		this.granada = granada;
	}

	public String getNatacao_50m() {
		return natacao_50m;
	}

	public void setNatacao_50m(String natacao_50m) {
		this.natacao_50m = natacao_50m;
	}

	public String getFlutuacao() {
		return flutuacao;
	}

	public void setFlutuacao(String flutuacao) {
		this.flutuacao = flutuacao;
	}

	

	
	
	
}
