//PATENTE(COD_PATENTE, NOME_PATENTE, ABREVIACAO_PATENTE)

package br.com.fireware.bpchoque.entity;



import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import org.springframework.data.jpa.domain.AbstractPersistable;

import lombok.Getter;
import lombok.Setter;
import net.bootsfaces.component.dataTable.DataTable.DataTablePropertyType;
@Getter
@Setter
@Entity
@Table(name="movimentacoes")
public class Movimentacao extends AbstractPersistable<Long>{
	
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="COD_MOVIMENTACAO")
	private Long id;
	@NotEmpty(message="O campo não pode estar vazio")
	@Length(max=30, message="A função tem que ter no máximo {max} caracteres")
	@Column(name="NOME_MOVIMENTACAO", nullable= false, length=30, unique=true)
	private String tipo;
	@Temporal(TemporalType.DATE)
	@Column(name="DATA")
	private Calendar data;
	
	@NotEmpty(message="O campo não pode estar vazio")
	@Column(name="DESCRICAO_MOVIMENTACAO", length=60, unique=true)
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name="COD_CIA")
	private Companhia companhia;
	
	
	
	
	
	
	
	
	
}
