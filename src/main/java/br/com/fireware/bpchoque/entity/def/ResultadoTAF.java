//RESULTADO_TAF(COD_RT, COD_TF, COD_PESSOA, FLEXAO_BARRA_RT, FLEXAO_SOLO_RT, 
//ABDOMINAL_RT, CORRIDA_50M_RT, CORRIDA_12MIN_RT)
package br.com.fireware.bpchoque.entity.def;



import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.data.jpa.domain.AbstractPersistable;

import br.com.fireware.bpchoque.entity.Pessoa;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
@Table(name = "RESULTADOS_TAF")
public class ResultadoTAF extends AbstractPersistable<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COD_RT")
	private Long id;

	
	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name = "COD_TESTE_FISICO")
	private TesteFisico testeFisico;

	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn
	private Pessoa pessoa;
	
	private String participante;

	@Digits(integer = 2, fraction = 0, message = "Apenas números com até dois dígitos")
	@Min(value = 0, message = "O valor mínimo é 0")
	@Max(value = 50, message = "O valor máximo é 50")
	
	private int flexao_barra;
	
	private int flexao_barra_pts;
	

	@Digits(integer = 2, fraction = 0, message = "Apenas números com até dois dígitos")
	@Min(value = 0, message = "O valor mínimo é 0")
	@Max(value = 100, message = "O valor máximo é 100")
	
	private int flexao_solo;
	
	private int flexao_solo_pts;

	@Digits(integer = 2, fraction = 0, message = "Apenas números com até dois dígitos")
	@Min(value = 0, message = "O valor mínimo é 0")
	@Max(value = 60, message = "O valor máximo é 60")
	
	private int abdominal;
	
	private int abdominal_pts;

	@Digits(integer = 4, fraction = 0, message = "Apenas números com até quatro dígitos")
	@Min(value = 0, message = "O valor mínimo é 0")
	@Max(value = 1500, message = "O valor máximo é 100")
	
	private int corrida_50m;
	
	private int corrida_50m_pts;

	@Digits(integer = 4, fraction = 0, message = "Apenas números com até quatro dígitos")
	@Min(value = 0, message = "O valor mínimo é 0")
	@Max(value = 5000, message = "O valor máximo é 5000")
	
	private int corrida_12min;

	
	private int corrida_12min_pts;
	
	
	private Double pontuacao_total;
	
	
	
	
	
	
	
	
	
	

	

}
