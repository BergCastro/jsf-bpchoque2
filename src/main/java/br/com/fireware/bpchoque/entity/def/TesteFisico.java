//TESTE_FISICO(COD_TF, DATA_TF, COD_TTF)
package br.com.fireware.bpchoque.entity.def;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



import javax.persistence.Table;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;


import lombok.Data;

@Data
@Entity
@Table(name="TESTE_FISICO")
public class TesteFisico{
	
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	
	private Long id;
	
	@NotNull(message="O campo não pode estar vazio!")
	
	@Column(name = "dataInicial")
	private LocalDate dataInicial;
	
	
	
	@Column(name = "dataFinal")
	private LocalDate dataFinal;
	
	
	@NotEmpty(message="O campo não pode estar vazio!")
	
	private String objetivo;
	
	
	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	private StatusTeste status;
	
	@NotNull(message="Selecione uma opção!")
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo")
	private TipoTesteFisico tipo;
	
	@Column(name= "fase")
	private Integer fase;
	
	

	

	public enum StatusTeste {
		PREVISTO(0), SELEÇÃO_DE_PARTICIPANTES(1), EM_ANDAMENTO(2), CONCLUÍDO(3);
		
		private final int valor;
		StatusTeste(int valorOpcao){
			valor = valorOpcao;
		}
		public int getValor(){
			return valor;
		}
	}
	
	public enum TipoTesteFisico {
		
		TAF, TAF_THE_CDC, TAF_THE_COTAR, TAF_THE_COTAM, TAF_THE_GATE, TAF_THE_CANIL
		
	}
	
	
	
	

	

	

	
	
	
	
	
	

}
