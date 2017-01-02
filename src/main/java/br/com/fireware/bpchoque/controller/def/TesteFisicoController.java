package br.com.fireware.bpchoque.controller.def;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.event.CellEditEvent;

import org.primefaces.model.StreamedContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import br.com.fireware.bpchoque.entity.Pessoa;

import br.com.fireware.bpchoque.entity.def.ResultadoTAF;
import br.com.fireware.bpchoque.entity.def.ResultadoTheCanil;
import br.com.fireware.bpchoque.entity.def.ResultadoTheCdc;

import br.com.fireware.bpchoque.entity.def.ResultadoTheCdc.SituacaoTheCdc;
import br.com.fireware.bpchoque.entity.def.ResultadoTheCotam;
import br.com.fireware.bpchoque.entity.def.ResultadoTheCotar;
import br.com.fireware.bpchoque.entity.def.ResultadoTheCotar.SituacaoTheCotar;
import br.com.fireware.bpchoque.entity.def.ResultadoTheGate;
import br.com.fireware.bpchoque.entity.def.TesteFisico;
import br.com.fireware.bpchoque.entity.def.TesteFisico.StatusTeste;
import br.com.fireware.bpchoque.entity.def.TesteFisico.TipoTesteFisico;


import br.com.fireware.bpchoque.service.PessoaService;
import br.com.fireware.bpchoque.service.PessoaService;
import br.com.fireware.bpchoque.service.RelatorioService;
import br.com.fireware.bpchoque.service.def.ResultadoTafService;
import br.com.fireware.bpchoque.service.def.ResultadoTheCanilService;
import br.com.fireware.bpchoque.service.def.ResultadoTheCdcService;
import br.com.fireware.bpchoque.service.def.ResultadoTheCotamService;
import br.com.fireware.bpchoque.service.def.ResultadoTheCotarService;
import br.com.fireware.bpchoque.service.def.ResultadoTheGateService;
import br.com.fireware.bpchoque.service.def.TesteFisicoService;

@Controller
public class TesteFisicoController {
	
	@RequestMapping(value = "/TestesFisicos")
	public ModelAndView testeFisico() {
		return new ModelAndView("/testefisico");

	
	}
	
	@RequestMapping(value = "/NovoTeste")
	public ModelAndView novoTeste() {
		return new ModelAndView("/novoTeste");

	
	}
	
	

	@Autowired
	private TesteFisicoService testeFisicoService;

	@Autowired
	private ResultadoTafService resultadoTafService;

	@Autowired
	private ResultadoTheCdcService resultadoTheCdcService;

	@Autowired
	private ResultadoTheCotarService resultadoTheCotarService;

	@Autowired
	private ResultadoTheCotamService resultadoTheCotamService;

	@Autowired
	private ResultadoTheCanilService resultadoTheCanilService;

	@Autowired
	private ResultadoTheGateService resultadoTheGateService;

	@Autowired
	private PessoaService pessoaService;



	



	

	private Iterable<TesteFisico> testesFisicos;

	private List<ResultadoTAF> resultadosTaf;

	private List<ResultadoTheCdc> resultadosTheCdc;

	private List<ResultadoTheCotar> resultadosTheCotar;

	private List<ResultadoTheCotam> resultadosTheCotam;

	private List<ResultadoTheCanil> resultadosTheCanil;

	private List<ResultadoTheGate> resultadosTheGate;

	private List<Pessoa> selectedPessoas;

	private List<Pessoa> pessoas;

	private Pessoa pessoaIncluir = null;

	private ResultadoTAF resultadoTaf = new ResultadoTAF();
	
	private TesteFisico testeFisico;

	private ResultadoTheCdc resultadoTheCdc = new ResultadoTheCdc();

	private ResultadoTheCotar resultadoTheCotar = new ResultadoTheCotar();

	private ResultadoTheGate resultadoTheGate = new ResultadoTheGate();

	private ResultadoTheCanil resultadoTheCanil = new ResultadoTheCanil();

	private ResultadoTheCotam resultadoTheCotam = new ResultadoTheCotam();

	private Boolean editando;

	private Boolean inclusao;

	private Boolean selecao;

	private Boolean ultimaEtapa;

	private Boolean andamento;

	private Boolean thecotam;
	private Boolean thecdc;
	private Boolean thecotar;
	private Boolean thegate;
	private Boolean thecanil;

	private StreamedContent arquivoRetorno;
	private int tipoRelatorio;

	private Boolean editandoResultados;
	
	private Boolean resultadostafAtualizados;
	
	private Boolean testesFisicosAtualizados;
	
	private Boolean resultadosTheCdcAtualizados;
	
	private Boolean pessoasAtualizados;
	
	private Boolean resultadosTheCotarAtualizados;
	
	private Boolean resultadosTheGateAtualizados;
	
	private Boolean resultadosTheCotamAtualizados;
	
	private Boolean resultadosTheCanilAtualizados;
	
	
	@Digits(integer = 2, fraction = 0, message = "Apenas números com até dois dígitos")
	@Min(value = 0, message = "O valor mínimo é 0")
	@Max(value = 50, message = "O valor máximo é 50")
	private Integer barra;
	@Digits(integer = 2, fraction = 0, message = "Apenas números com até dois dígitos")
	@Min(value = 0, message = "O valor mínimo é 0")
	@Max(value = 100, message = "O valor máximo é 100")
	private Integer apoio;
	@Digits(integer = 2, fraction = 0, message = "Apenas números com até dois dígitos")
	@Min(value = 0, message = "O valor mínimo é 0")
	@Max(value = 60, message = "O valor máximo é 60")
	private Integer abdominal;
	@Digits(integer = 4, fraction = 0, message = "Apenas números com até quatro dígitos")
	@Min(value = 0, message = "O valor mínimo é 0")
	@Max(value = 1500, message = "O valor máximo é 1500")
	private Integer corrida50;
	@Digits(integer = 4, fraction = 0, message = "Apenas números com até quatro dígitos")
	@Min(value = 0, message = "O valor mínimo é 0")
	@Max(value = 5000, message = "O valor máximo é 5000")
	private Integer corrida12;

	private SituacaoTheCdc corrida5km;

	private SituacaoTheCdc granada;

	private SituacaoTheCdc natacao50m;

	private SituacaoTheCdc flutuacao_cdc;

	private SituacaoTheCotar flutuacao_cotar;

	private Integer natacao_200m;

	private Integer shutlerun;

	private Integer corrida_sobrecarga;

	private SituacaoTheCotar salto_plataforma;

	public SituacaoTheCotar getFlutuacao_cotar() {
		return flutuacao_cotar;
	}

	public void setFlutuacao_cotar(SituacaoTheCotar flutuacao_cotar) {
		this.flutuacao_cotar = flutuacao_cotar;
	}

	public List<ResultadoTheCotar> getResultadosTheCotar() {
		if(resultadosTheCotarAtualizados || resultadosTheCotar == null){
			resultadosTheCotar = resultadoTheCotarService.findByTesteFisico(getTesteFisico());
			resultadosTheCotarAtualizados = false;
		}
		return resultadosTheCotar;
	}

	public void setResultadosTheCotar(List<ResultadoTheCotar> resultadosTheCotar) {
		this.resultadosTheCotar = resultadosTheCotar;
	}

	public List<ResultadoTheCotam> getResultadosTheCotam() {
		if(resultadosTheCotamAtualizados || resultadosTheCotam == null){
			resultadosTheCotam = resultadoTheCotamService.findByTesteFisico(getTesteFisico());
			resultadosTheCotamAtualizados = false;
		}
		return resultadosTheCotam;
	}

	public void setResultadosTheCotam(List<ResultadoTheCotam> resultadosTheCotam) {
		this.resultadosTheCotam = resultadosTheCotam;
	}

	public List<ResultadoTheCanil> getResultadosTheCanil() {
		if(resultadosTheCanilAtualizados || resultadosTheCanil == null){	
			resultadosTheCanil = resultadoTheCanilService.findByTesteFisico(getTesteFisico());
			resultadosTheCanilAtualizados = false;
		}
		return resultadosTheCanil;
	}

	public void setResultadosTheCanil(List<ResultadoTheCanil> resultadosTheCanil) {
		this.resultadosTheCanil = resultadosTheCanil;
	}

	public List<ResultadoTheGate> getResultadosTheGate() {
		if(resultadosTheGateAtualizados || resultadosTheGate == null){
			resultadosTheGate = resultadoTheGateService.findByTesteFisico(getTesteFisico());
			resultadosTheGateAtualizados = false;
		}
		return resultadosTheGate;
	}

	public void setResultadosTheGate(List<ResultadoTheGate> resultadosTheGate) {
		this.resultadosTheGate = resultadosTheGate;
	}

	public SituacaoTheCdc getCorrida5km() {
		return corrida5km;
	}

	public void setCorrida5km(SituacaoTheCdc corrida5km) {
		this.corrida5km = corrida5km;
	}

	public SituacaoTheCdc getGranada() {
		return granada;
	}

	public void setGranada(SituacaoTheCdc granada) {
		this.granada = granada;
	}

	public SituacaoTheCdc getNatacao50m() {
		return natacao50m;
	}

	public void setNatacao50m(SituacaoTheCdc natacao50m) {
		this.natacao50m = natacao50m;
	}

	public SituacaoTheCdc getFlutuacao_cdc() {
		return flutuacao_cdc;
	}

	public void setFlutuacao_cdc(SituacaoTheCdc flutuacao) {
		this.flutuacao_cdc = flutuacao;
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

	public void setShutlerun(Integer shutleRun) {
		this.shutlerun = shutleRun;
	}

	public Integer getCorrida_sobrecarga() {
		return corrida_sobrecarga;
	}

	public void setCorrida_sobrecarga(Integer corrida_sobrecarga) {
		this.corrida_sobrecarga = corrida_sobrecarga;
	}

	public SituacaoTheCotar getSalto_plataforma() {
		return salto_plataforma;
	}

	public void setSalto_plataforma(SituacaoTheCotar salto_plataforma) {
		this.salto_plataforma = salto_plataforma;
	}

	public ResultadoTheCdc getResultadotheCdc() {

		return resultadoTheCdc;
	}

	public void setResultadotheCdc(ResultadoTheCdc resultadotheCdc) {
		this.resultadoTheCdc = resultadotheCdc;
	}

	public List<ResultadoTheCdc> getResultadosTheCdc() {
		
		if(resultadosTheCdcAtualizados || resultadosTheCdc == null){
			
		resultadosTheCdc = resultadoTheCdcService.findByTesteFisico(getTesteFisico());
		resultadosTheCdcAtualizados = false;
		}
		return resultadosTheCdc;
	}

	public void setResultadosTheCdc(List<ResultadoTheCdc> resultadosTheCdc) {
		this.resultadosTheCdc = resultadosTheCdc;
	}

	public ResultadoTheCotar getResultadoTheCotar() {
		return resultadoTheCotar;
	}

	public void setResultadoTheCotar(ResultadoTheCotar resultadoTheCotar) {
		this.resultadoTheCotar = resultadoTheCotar;
	}

	public ResultadoTheGate getResultadoTheGate() {
		return resultadoTheGate;
	}

	public void setResultadoTheGate(ResultadoTheGate resultadoTheGate) {
		this.resultadoTheGate = resultadoTheGate;
	}

	public ResultadoTheCanil getResultadoTheCanil() {
		return resultadoTheCanil;
	}

	public void setResultadoTheCanil(ResultadoTheCanil resultadoTheCanil) {
		this.resultadoTheCanil = resultadoTheCanil;
	}

	public Boolean enableBarra(Pessoa pessoa) {

		if (pessoa.getSexo().toString().equals("MASCULINO")) {
			return true;

		} else {
			return false;
		}

	}

	public Boolean getSelecao() {
		return selecao;
	}

	public void setSelecao(Boolean selecao) {
		this.selecao = selecao;
	}

	public Boolean getEditandoResultados() {
		return editandoResultados;
	}

	public void setEditandoResultados(Boolean editandoResultados) {
		this.editandoResultados = editandoResultados;
	}

	public Boolean getThecanil() {

		String tipo = testeFisico.getTipo().toString();
		if (tipo.equals("TAF")) {
			thecanil = false;
		} else if (tipo.equals("TAF_THE_CDC")) {
			thecanil = false;
		} else if (tipo.equals("TAF_THE_COTAM")) {
			thecanil = true;
		} else if (tipo.equals("TAF_THE_COTAR")) {
			thecanil = false;
		} else if (tipo.equals("TAF_THE_GATE")) {
			thecanil = false;
		} else if (tipo.equals("TAF_THE_CANIL")) {
			thecanil = true;
		}

		return thecanil;
	}

	public void setThecanil(Boolean thecanil) {
		this.thecanil = thecanil;
	}

	public Boolean getThecotam() {
		String tipo = testeFisico.getTipo().toString();
		if (tipo.equals("TAF")) {
			thecotam = false;
		} else if (tipo.equals("TAF_THE_CDC")) {
			thecotam = false;
		} else if (tipo.equals("TAF_THE_COTAM")) {
			thecotam = true;
		} else if (tipo.equals("TAF_THE_COTAR")) {
			thecotam = false;
		} else if (tipo.equals("TAF_THE_GATE")) {
			thecotam = false;
		} else if (tipo.equals("TAF_THE_CANIL")) {
			thecotam = false;
		}

		return thecotam;
	}

	public void setThecotam(Boolean thecotam) {
		this.thecotam = thecotam;
	}

	public Boolean getThecdc() {

		String tipo = testeFisico.getTipo().toString();

		if (tipo.equals("TAF")) {
			thecdc = false;
		} else if (tipo.equals("TAF_THE_CDC")) {
			thecdc = true;
		} else if (tipo.equals("TAF_THE_COTAM")) {
			thecdc = false;
		} else if (tipo.equals("TAF_THE_COTAR")) {
			thecdc = false;
		} else if (tipo.equals("TAF_THE_GATE")) {
			thecdc = false;
		} else if (tipo.equals("TAF_THE_CANIL")) {
			thecdc = false;
		}

		return thecdc;
	}

	public void setThecdc(Boolean thecdc) {
		this.thecdc = thecdc;
	}

	public Boolean getThecotar() {
		String tipo = testeFisico.getTipo().toString();
		if (tipo.equals("TAF")) {
			thecotar = false;
		} else if (tipo.equals("TAF_THE_CDC")) {
			thecotar = false;
		} else if (tipo.equals("TAF_THE_COTAM")) {
			thecotar = false;
		} else if (tipo.equals("TAF_THE_COTAR")) {
			thecotar = true;
		} else if (tipo.equals("TAF_THE_GATE")) {
			thecotar = false;
		} else if (tipo.equals("TAF_THE_CANIL")) {
			thecotar = false;
		}

		return thecotar;
	}

	public void setThecotar(Boolean thecotar) {
		this.thecotar = thecotar;
	}

	public Boolean getThegate() {
		String tipo = testeFisico.getTipo().toString();

		if (tipo.equals("TAF")) {
			thegate = false;
		} else if (tipo.equals("TAF_THE_CDC")) {
			thegate = false;
		} else if (tipo.equals("TAF_THE_COTAM")) {
			thegate = false;
		} else if (tipo.equals("TAF_THE_COTAR")) {
			thegate = false;
		} else if (tipo.equals("TAF_THE_GATE")) {
			thegate = true;
		} else if (tipo.equals("TAF_THE_CANIL")) {
			thegate = false;
		}

		return thegate;
	}
	
	
	public StreamedContent imprimirResultadoTaf(){
		List<ResultadoTAF> resultadostaf = resultadoTafService.findByTesteFisico(testeFisico);
		return arquivoRetorno("resultadostaf6", "resultadoTaf", resultadostaf);
	}
	
	public StreamedContent imprimirResultadoTheCdc(){
		List<ResultadoTheCdc> resultadosTheCdc = resultadoTheCdcService.findByTesteFisico(testeFisico);
		return arquivoRetorno("resultadoTheCdc", "resultadoTheCdc", resultadosTheCdc);
	}

	public StreamedContent arquivoRetorno(String nomeArquivo, String nomeSaida, Collection<?> collection) {
		
		FacesContext context = FacesContext.getCurrentInstance();
		
		
		
		
		//String nomeRelatorioJasper = "resultadostaf6"; // (_1_)
		//String nomeRelatorioSaida = "resultadotaf"; // (_2_)
		RelatorioService relatorioUtil = new RelatorioService();
		HashMap parametrosRelatorio = new HashMap(); // (_3_)
		parametrosRelatorio.put("titulo", testeFisico.getObjetivo());
		LocalDate dataInicial = testeFisico.getDataInicial();
		LocalDate dateFinal = testeFisico.getDataFinal();
		dataInicial.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		
		parametrosRelatorio.put("dataInicial", dataInicial.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		parametrosRelatorio.put("dataFinal",dataInicial.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));

		try {
			this.arquivoRetorno = relatorioUtil.geraRelatorio(parametrosRelatorio, nomeArquivo,
					nomeSaida, collection, this.tipoRelatorio);
		} catch (br.com.fireware.bpchoque.exception.UtilException e) {
			context.addMessage(null, new FacesMessage(e.getMessage()));
			return null;
		}
		return this.arquivoRetorno;
	}

	public int getTipoRelatorio() {
		return tipoRelatorio;
	}

	public void setTipoRelatorio(int tipoRelatorio) {
		this.tipoRelatorio = tipoRelatorio;
	}

	public void setThegate(Boolean thegate) {
		this.thegate = thegate;
	}

	public Integer getBarra() {
		return barra;
	}

	public void setBarra(Integer barra) {
		this.barra = barra;
	}

	public Integer getApoio() {
		return apoio;
	}

	public void setApoio(Integer apoio) {
		this.apoio = apoio;
	}

	public Integer getAbdominal() {
		return abdominal;
	}

	public void setAbdominal(Integer abdominal) {
		this.abdominal = abdominal;
	}

	public Integer getCorrida50() {
		return corrida50;
	}

	public void setCorrida50(Integer corrida50) {
		this.corrida50 = corrida50;
	}

	public Integer getCorrida12() {
		return corrida12;
	}

	public void setCorrida12(Integer corrida12) {
		this.corrida12 = corrida12;
	}

	public Boolean getAndamento() {
		return andamento;
	}

	public void setAndamento(Boolean andamento) {
		this.andamento = andamento;
	}

	public Pessoa getPessoaIncluir() {
		return pessoaIncluir;

	}

	public void setPessoaIncluir(Pessoa pessoaIncluir) {
		this.pessoaIncluir = pessoaIncluir;
	}

	public Boolean getUltimaEtapa() {
		return ultimaEtapa;
	}

	public void setUltimaEtapa(Boolean ultimaEtapa) {
		this.ultimaEtapa = ultimaEtapa;
	}

	public Boolean getInclusao() {
		return inclusao;
	}

	public void setInclusao(Boolean inclusao) {
		this.inclusao = inclusao;
	}

	public void setResultadosTaf(List<ResultadoTAF> resultadosTaf) {
		this.resultadosTaf = resultadosTaf;
	}

	public List<Pessoa> pessoas(String query) {
		List<Pessoa> allPessoas = pessoaService.findTodos();
		List<Pessoa> filteredPessoas = new ArrayList<Pessoa>();

		List<ResultadoTAF> resultados = resultadoTafService.findByTesteFisico(testeFisico);

		for (int i = 0; i < allPessoas.size(); i++) {
			Pessoa skin = allPessoas.get(i);
			if (skin.getMatricula().toLowerCase().startsWith(query)) {
				filteredPessoas.add(skin);
				for (int j = 0; j < resultados.size(); j++) {

					if (resultados.get(j).getPessoa().getId().toString().equals(skin.getId().toString())) {
						filteredPessoas.remove(skin);
					}
				}
			}
		}

		return filteredPessoas;
	}
	
	public List<Pessoa> pessoasNome(String query) {
		List<Pessoa> allPessoas = pessoaService.findTodos();
		List<Pessoa> filteredPessoas = new ArrayList<Pessoa>();

		List<ResultadoTAF> resultados = resultadoTafService.findByTesteFisico(testeFisico);

		for (int i = 0; i < allPessoas.size(); i++) {
			Pessoa skin = allPessoas.get(i);
			if (skin.getNome().toLowerCase().startsWith(query)) {
				filteredPessoas.add(skin);
				for (int j = 0; j < resultados.size(); j++) {

					if (resultados.get(j).getPessoa().getId().toString().equals(skin.getId().toString())) {
						filteredPessoas.remove(skin);
					}
				}
			}
		}

		return filteredPessoas;
	}

	public void teste1() {
		System.out.println("Teste");
	}

	

	public StatusTeste[] getStatusTeste() {
		return StatusTeste.values();
	}

	public TipoTesteFisico[] getTipoTesteFisico() {
		return TipoTesteFisico.values();
	}

	public SituacaoTheCdc[] getSituacaoCdc() {
		return SituacaoTheCdc.values();
	}

	public SituacaoTheCotar[] getSituacaoCotar() {
		return SituacaoTheCotar.values();
	}

	
	
	
	
	
	
	
	
	@PostConstruct
	public void init(){
		editando = false;
		inclusao = false;
		thecdc = false;
		editandoResultados = false;
		selecao = false;
		resultadostafAtualizados = false;
		testesFisicosAtualizados = false;
		resultadosTheCdcAtualizados = false;
		resultadosTheCanilAtualizados = false;
		resultadosTheCotamAtualizados = false;
		pessoasAtualizados = false;
		resultadosTheGateAtualizados = false;
		resultadosTheCotarAtualizados = false;
		
		testeFisico = new TesteFisico();
		//resultadosTaf = resultadoTafService.findByTesteFisico(getTesteFisico());
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public List<Pessoa> getSelectedPessoas() {
		return selectedPessoas;
	}

	public void setSelectedPessoas(List<Pessoa> selectedPessoas) {
		this.selectedPessoas = selectedPessoas;
	}





	public List<ResultadoTAF> getResultadosTaf() {
		
		if(resultadostafAtualizados || resultadosTaf == null){
			
			resultadosTaf = resultadoTafService.findByTesteFisico(getTesteFisico());
		resultadostafAtualizados = false;
		}
		

		return resultadosTaf;
	}

	public List<Pessoa> getPessoas() {
		
		if(pessoasAtualizados || pessoas == null){
			
		pessoas = pessoaService.findAll();
		pessoasAtualizados = false;
		}
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	public ResultadoTAF getResultadoTaf() {
		
		return resultadoTaf;
	}

	public void setResultadoTaf(ResultadoTAF resultadoTaf) {
		this.resultadoTaf = resultadoTaf;
	}

	public TesteFisico getTesteFisico() {
		return testeFisico;
	}

	public void setTesteFisico(TesteFisico testeFisico) {
		this.testeFisico = testeFisico;
	}

	public Boolean getEditando() {
		return editando;
	}

	public void setEditando(Boolean editando) {
		this.editando = editando;
	}

	public void incluir() {
		
		if(pessoaIncluir != null){
		
		setBarra(null);
		setAbdominal(null);
		setApoio(null);
		setCorrida12(null);
		setCorrida50(null);

		resultadoTaf = new ResultadoTAF();
		resultadoTaf.setPessoa(null);
		resultadoTafService.save(resultadoTaf);
		resultadoTaf.setPessoa(pessoaIncluir);
		resultadoTaf.setParticipante(participante(pessoaIncluir));
		resultadoTaf.setTesteFisico(getTesteFisico());
		resultadoTafService.save(resultadoTaf);

		String tipo = testeFisico.getTipo().toString();

		if (tipo.equals("TAF")) {

		} else if (tipo.equals("TAF_THE_CDC")) {
			resultadoTheCdc = new ResultadoTheCdc();
			resultadoTheCdc.setPessoa(null);
			resultadoTheCdcService.save(resultadoTheCdc);
			resultadoTheCdc.setPessoa(pessoaIncluir);
			resultadoTheCdc.setParticipante(participante(pessoaIncluir));
			resultadoTheCdc.setTesteFisico(getTesteFisico());
			resultadoTheCdcService.save(resultadoTheCdc);

		} else if (tipo.equals("TAF_THE_COTAM")) {
			resultadoTheCotam = new ResultadoTheCotam();
			resultadoTheCotam.setPessoa(null);
			resultadoTheCotamService.save(resultadoTheCotam);
			resultadoTheCotam.setPessoa(pessoaIncluir);
			resultadoTheCotam.setTesteFisico(getTesteFisico());
			resultadoTheCotamService.save(resultadoTheCotam);

		} else if (tipo.equals("TAF_THE_COTAR")) {
			resultadoTheCotar = new ResultadoTheCotar();
			resultadoTheCotar.setPessoa(null);
			resultadoTheCotarService.save(resultadoTheCotar);
			resultadoTheCotar.setPessoa(pessoaIncluir);
			resultadoTheCotar.setTesteFisico(getTesteFisico());
			resultadoTheCotarService.save(resultadoTheCotar);

		} else if (tipo.equals("TAF_THE_GATE")) {
			resultadoTheGate = new ResultadoTheGate();
			resultadoTheGate.setPessoa(null);
			resultadoTheGateService.save(resultadoTheGate);
			resultadoTheGate.setPessoa(pessoaIncluir);
			resultadoTheGate.setTesteFisico(getTesteFisico());
			resultadoTheGateService.save(resultadoTheGate);

		} else if (tipo.equals("TAF_THE_CANIL")) {
			resultadoTheCanil = new ResultadoTheCanil();
			resultadoTheCanil.setPessoa(null);
			resultadoTheCanilService.save(resultadoTheCanil);
			resultadoTheCanil.setPessoa(pessoaIncluir);
			resultadoTheCanil.setTesteFisico(getTesteFisico());
			resultadoTheCanilService.save(resultadoTheCanil);
		}
		setPessoaIncluir(null);
		resultadostafAtualizados=true;
		resultadosTheCdcAtualizados=true;
		}
	}

	public String novo() {
		testeFisico = new TesteFisico();
		testeFisico.setFase(0);
		editando = true;
		inclusao = false;
		selecao = false;

		return "/novoTeste";
		//"novoTeste?faces-redirect=true"
	}

	public void salvarResultado(ResultadoTAF resultado) {

		resultado.setFlexao_barra(resultado.getFlexao_barra());
		resultadoTafService.save(resultado);

	}

	public String salvar() {

		if (testeFisico.getFase() == 0) {

			testeFisico.setStatus(StatusTeste.PREVISTO);
			testeFisicoService.save(testeFisico);

		} else if (testeFisico.getFase() == 1) {

			testeFisico.setStatus(StatusTeste.SELEÇÃO_DE_PARTICIPANTES);
			testeFisicoService.save(testeFisico);

		} else if (testeFisico.getFase() == 2) {

			testeFisico.setStatus(StatusTeste.EM_ANDAMENTO);
			testeFisicoService.save(testeFisico);

		} else if (testeFisico.getFase() == 3) {
			testeFisico.setStatus(StatusTeste.CONCLUÍDO);
			testeFisicoService.save(testeFisico);

		}
		editando = false;
		testesFisicosAtualizados = true;

		return "testefisico?faces-redirect=true";
	}

	public void continuar() {

		if (testeFisico.getFase() == 0) {

			testeFisico.setFase(1);
			inclusao = true;
			selecao = true;

		} else if (testeFisico.getFase() == 1) {

			testeFisico.setFase(2);
			inclusao = true;
			selecao = false;
			ultimaEtapa = true;
			andamento = true;
		} else if (testeFisico.getFase() == 2) {

			testeFisico.setFase(3);
			inclusao = true;
			selecao = false;
			andamento = true;

		} else if (testeFisico.getFase() == 3) {

		}
		salvar();
		editando = true;

	}

	@Transactional(readOnly = true)
	public String cancelar() {

		editando = false;
		inclusao = false;
		selecao = false;

		return "testefisico?faces-redirect=true";

	}

	public String alterar(TesteFisico testeFisico) {
		this.testeFisico = testeFisico;
		resultadostafAtualizados = true;
		resultadosTheCdcAtualizados = true;
		editando = true;
		if (testeFisico.getFase() == 0) {

			inclusao = false;
			selecao = false;
			andamento = false;

		} else if (testeFisico.getFase() == 1) {
			inclusao = true;
			selecao = true;
			andamento = false;

		} else if (testeFisico.getFase() == 2) {
			inclusao = true;
			selecao = false;
			andamento = true;
		} else if (testeFisico.getFase() == 3) {
			inclusao = true;
			selecao = false;
			andamento = true;
		}
		setPessoaIncluir(null);
		

		return "editandoTeste3?faces-redirect=true";

	}

	public void alterarResultado() {

	}

	public String participante(Pessoa pessoa) {
		String participante = "";

		
			System.out.println("Entrou no if");
			Pessoa pessoaParticipante = pessoaService.findById(pessoa.getId());
			participante = pessoaParticipante.getMatricula() + " :: " + pessoaParticipante.getCargo().getAbreviacao() + " :: "
					+ pessoaParticipante.getNome() + " :: " + Pessoa.idadeAvaliacao(pessoaParticipante.getDatanasc()) + " i.a.";
		

		return participante;
	}

	public void excluir(TesteFisico testeFisico) {

		testeFisicoService.delete(testeFisico.getId());
		testesFisicosAtualizados=true;

	}

	public void excluirResultadoTaf(ResultadoTAF resultado) {

		String tipo = testeFisico.getTipo().toString();

		if (tipo.equals("TAF_THE_CDC")) {
			resultadoTheCdcService.delete(resultadoTheCdcService.finByTesteFisicoAndPessoa(resultado.getTesteFisico(),
					resultado.getPessoa()));

		} else if (tipo.equals("TAF_THE_COTAM")) {
			resultadoTheCotamService.delete(resultadoTheCotamService
					.findByTesteFisicoAndPessoa(resultado.getTesteFisico(), resultado.getPessoa()));

		} else if (tipo.equals("TAF_THE_COTAR")) {
			resultadoTheCotarService.delete(resultadoTheCotarService
					.findByTesteFisicoAndPessoa(resultado.getTesteFisico(), resultado.getPessoa()));

		} else if (tipo.equals("TAF_THE_GATE")) {
			resultadoTheGateService.delete(resultadoTheGateService
					.findByTesteFisicoAndPessoa(resultado.getTesteFisico(), resultado.getPessoa()));

		} else if (tipo.equals("TAF_THE_CANIL")) {
			resultadoTheCanilService.delete(resultadoTheCanilService
					.findByTesteFisicoAndPessoa(resultado.getTesteFisico(), resultado.getPessoa()));

		}
		resultadoTafService.delete(resultado.getId());
		resultadostafAtualizados=true;
		resultadosTheCdcAtualizados=true;
		resultadosTheCotamAtualizados=true;
		resultadosTheCotarAtualizados=true;
		resultadosTheGateAtualizados=true;
		resultadosTheCanilAtualizados=true;

	}

	public void excluirResultadoTheCdc(ResultadoTheCdc resultado) {

		resultadoTheCdcService.delete(resultado.getId());
	}

	public void excluirResultadoTheCotar(ResultadoTheCotar resultado) {

		resultadoTheCotarService.delete(resultado.getId());
	}

	public void excluirResultadoTheCanil(ResultadoTheCanil resultado) {

		resultadoTheCanilService.delete(resultado.getId());
	}

	public void excluirResultadoTheCotam(ResultadoTheCotam resultado) {

		resultadoTheCotamService.delete(resultado.getId());
	}

	public void excluirResultadoTheGate(ResultadoTheGate resultado) {

		resultadoTheGateService.delete(resultado.getId());
	}

	public Iterable<TesteFisico> getTestesFisicos() {
		
		if(testesFisicosAtualizados || testesFisicos == null){
			
		testesFisicos = testeFisicoService.findAll();
		testesFisicosAtualizados = false;
		}
		return testesFisicos;

	}

	

	public void salvarBarra(ResultadoTAF resultado) {
		if (getBarra() != null) {
			resultado.setFlexao_barra(getBarra());
			resultado.setFlexao_barra_pts(resultadoTafService.findNota("FLEXAO_BARRA",
					Pessoa.idadeAvaliacao(resultado.getPessoa().getDatanasc()), getBarra(), "MASCULINO"));
			// resultadoTafService.save(resultado);

			resultado.setPontuacao_total(((double) resultado.getFlexao_barra_pts()
					+ (double) resultado.getFlexao_solo_pts() + (double) resultado.getAbdominal_pts()
					+ (double) resultado.getCorrida_50m_pts() + (double) resultado.getCorrida_12min_pts()) / 40);

			
			resultadoTafService.save(resultado);
		}
		setBarra(null);
	}

	public void salvarApoio(ResultadoTAF resultado) {
		if (getApoio() != null) {
			if(resultado.getPessoa().getSexo().equals("MASCULINO")){
			resultado.setFlexao_solo(getApoio());
			resultado.setFlexao_solo_pts(resultadoTafService.findNota("FLEXAO_SOLO",
					Pessoa.idadeAvaliacao(resultado.getPessoa().getDatanasc()), getApoio(), "MASCULINO"));
			

			}else{
				resultado.setFlexao_solo(getApoio());
				resultado.setFlexao_solo_pts(resultadoTafService.findNota("FLEXAO_SOLO",
						Pessoa.idadeAvaliacao(resultado.getPessoa().getDatanasc()), getApoio(), "FEMININO"));
				
			}
			resultado.setPontuacao_total(((double) resultado.getFlexao_barra_pts()
					+ (double) resultado.getFlexao_solo_pts() + (double) resultado.getAbdominal_pts()
					+ (double) resultado.getCorrida_50m_pts() + (double) resultado.getCorrida_12min_pts()) / 40);
			resultadoTafService.save(resultado);
			
		}
		setApoio(null);

	}
	

	public void salvarAbdominal(ResultadoTAF resultado) {
		if (getAbdominal() != null) {
			
			resultado.setAbdominal(getAbdominal());
			resultado.setAbdominal_pts(resultadoTafService.findNota("ABDOMINAL",
					Pessoa.idadeAvaliacao(resultado.getPessoa().getDatanasc()), getAbdominal(), resultado.getPessoa().getSexo().toString()));
			
			
			resultado.setPontuacao_total(((double) resultado.getFlexao_barra_pts()
					+ (double) resultado.getFlexao_solo_pts() + (double) resultado.getAbdominal_pts()
					+ (double) resultado.getCorrida_50m_pts() + (double) resultado.getCorrida_12min_pts()) / 40);
			
			
			resultadoTafService.save(resultado);

		}
		setAbdominal(null);
	}

	public void salvarCorrida50(ResultadoTAF resultado) {
		if (getCorrida50() != null) {
			resultado.setCorrida_50m(getCorrida50());
			resultado.setCorrida_50m_pts(resultadoTafService.findNota("CORRIDA_50M",
					Pessoa.idadeAvaliacao(resultado.getPessoa().getDatanasc()), getCorrida50(), resultado.getPessoa().getSexo().toString()));
			resultado.setPontuacao_total(((double) resultado.getFlexao_barra_pts()
					+ (double) resultado.getFlexao_solo_pts() + (double) resultado.getAbdominal_pts()
					+ (double) resultado.getCorrida_50m_pts() + (double) resultado.getCorrida_12min_pts()) / 40);

			
			resultadoTafService.save(resultado);
		}
		setCorrida50(null);
	}

	public void salvarCorrida12(ResultadoTAF resultado) {
		if (getCorrida12() != null) {
			resultado.setCorrida_12min(getCorrida12());
			resultado.setCorrida_12min_pts(resultadoTafService.findNota("CORRIDA_12MIN",
					Pessoa.idadeAvaliacao(resultado.getPessoa().getDatanasc()), getCorrida12(), resultado.getPessoa().getSexo().toString()));
			resultado.setPontuacao_total(((double) resultado.getFlexao_barra_pts()
					+ (double) resultado.getFlexao_solo_pts() + (double) resultado.getAbdominal_pts()
					+ (double) resultado.getCorrida_50m_pts() + (double) resultado.getCorrida_12min_pts()) / 40);

			
			resultadoTafService.save(resultado);

		}
		setCorrida12(null);
	}

	public void salvarCorrida5km(ResultadoTheCdc resultado) {
		if (getCorrida5km() != null) {
			resultado.setCorrida_5km(getCorrida5km().toString());
			
			
			resultadoTheCdcService.save(resultado);

		}
		setCorrida5km(null);
	}
	
	public void salvarGranada(ResultadoTheCdc resultado) {
		if (getGranada() != null) {
			resultado.setGranada(getGranada().toString());
			
			
			resultadoTheCdcService.save(resultado);

		}
		setGranada(null);
	}
	public void salvarFlutuacao(ResultadoTheCdc resultado) {
		if (getFlutuacao_cdc() != null) {
			resultado.setFlutuacao(getFlutuacao_cdc().toString());
			
			
			resultadoTheCdcService.save(resultado);

		}
		setFlutuacao_cdc(null);
	}
	public void salvarNatacao50(ResultadoTheCdc resultado) {
		if (getNatacao50m() != null) {
			resultado.setNatacao_50m(getNatacao50m().toString());
			
			
			resultadoTheCdcService.save(resultado);

		}
		setNatacao50m(null);
	}

	

	public void onCellEditTheCotar(CellEditEvent event) {

		ResultadoTheCotar entity = (ResultadoTheCotar) ((DataTable) event.getComponent()).getRowData();

		if (getNatacao_200m() != null) {
			entity.setNatacao_200m(getNatacao_200m());
			resultadoTheCotarService.save(entity);
			setNatacao_200m(null);
		}
		if (getShutlerun() != null) {
			entity.setShutlerun(getShutlerun());
			resultadoTheCotarService.save(entity);
			setShutlerun(null);
		}
		if (getCorrida_sobrecarga() != null) {
			entity.setCorrida_50m_sobr(getCorrida_sobrecarga());
			resultadoTheCotarService.save(entity);
			setCorrida_sobrecarga(null);
		}
		if (getFlutuacao_cotar() != null) {
			entity.setFlutuacao(getFlutuacao_cotar());
			resultadoTheCotarService.save(entity);
			setFlutuacao_cotar(null);
		}
		if (getSalto_plataforma() != null) {
			entity.setSalto_plataforma(getSalto_plataforma());
			resultadoTheCotarService.save(entity);
			setSalto_plataforma(null);
		}

	}

	

	

}
