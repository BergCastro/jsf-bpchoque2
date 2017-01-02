package br.com.fireware.bpchoque.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name="avatares")
public class Avatar extends AbstractPersistable<Long>{
	
	
	@Column(nullable=false)
	private String titulo;
	
	@Column(nullable=false)
	private String tipo;
	
	@Lob
	@Column(nullable=false)
	private byte[] avatar;
	
	
	
	

	@Override//sobrescrever o setid pois na classe pai est� como privado e n�o permitiria o seu acesso 
	public void setId(Long id) {
		// TODO Auto-generated method stub
		super.setId(id);
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public byte[] getAvatar() {
		return avatar;
	}

	public void setAvatar(byte[] avatar) {
		this.avatar = avatar;
	}
	
	
	
	
}
