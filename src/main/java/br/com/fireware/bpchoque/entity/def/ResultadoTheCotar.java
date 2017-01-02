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

import javax.persistence.Table;


import br.com.fireware.bpchoque.entity.Pessoa;


@Table(name="RESULTADO_THE_COTAR")
@Entity
public class ResultadoTheCotar {
	
	public enum SituacaoTheCotar{
		APTO, INAPTO
	}
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="COD_RTHE_COTAR")
	private Long id;
	
	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name = "COD_TESTE_FISICO")
	private TesteFisico testeFisico;
	
	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name = "COD_PESSOA")
	private Pessoa pessoa;
		
	
	@Column(name="SALTO_PLATAFORMA_THE_COTAR")
	@Enumerated(EnumType.STRING)
	private SituacaoTheCotar salto_plataforma;
	
	@Column(name="FLUTUACAO_THE_COTAR")
	@Enumerated(EnumType.STRING)
	private SituacaoTheCotar flutuacao;
	
	@Column(name="NATACAO_200M_THE_CDC")
	private Integer natacao_200m;
	
	@Column(name="SHUTLERUN_THE_CDC")
	private Integer shutlerun;
	
	@Column(name="CORRIDA50_SOBR_THE_CDC")
	private Integer corrida_50m_sobr;
	

	
	
	
	
	
	public SituacaoTheCotar getFlutuacao() {
		return flutuacao;
	}

	public void setFlutuacao(SituacaoTheCotar flutuacao) {
		this.flutuacao = flutuacao;
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

	

	public SituacaoTheCotar getSalto_plataforma() {
		return salto_plataforma;
	}

	public void setSalto_plataforma(SituacaoTheCotar salto_plataforma) {
		this.salto_plataforma = salto_plataforma;
	}

	public Integer getNatacao_200m() {
		return natacao_200m;
	}

	public void setNatacao_200m(Integer natacao_200m) {
		this.natacao_200m = natacao_200m;
	}

	public Integer getShutlerun() {
		return shutlerun;
	}

	public void setShutlerun(Integer shutlerun) {
		this.shutlerun = shutlerun;
	}

	public Integer getCorrida_50m_sobr() {
		return corrida_50m_sobr;
	}

	public void setCorrida_50m_sobr(Integer corrida_50m_sobr) {
		this.corrida_50m_sobr = corrida_50m_sobr;
	}

	

	

	
	
	
}
