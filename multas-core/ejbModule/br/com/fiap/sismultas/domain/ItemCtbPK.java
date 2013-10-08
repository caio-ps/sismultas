package br.com.fiap.sismultas.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ItemCtbPK implements Serializable {

	private static final long serialVersionUID = -1585227489508584045L;

	@Column(name="codigo_infracao")
	private String codigoInfracao;
	
	@Column(name="desdobramento")
	private Integer desdobramento;

	public ItemCtbPK() {}
	
	public ItemCtbPK(String codigoInfracao, Integer desdobramento) {
		this.codigoInfracao = codigoInfracao;
		this.desdobramento = desdobramento;
	}

	public String getCodigoInfracao() {
		return codigoInfracao;
	}

	public void setCodigoInfracao(String codigoInfracao) {
		this.codigoInfracao = codigoInfracao;
	}

	public Integer getDesdobramento() {
		return desdobramento;
	}

	public void setDesdobramento(Integer desdobramento) {
		this.desdobramento = desdobramento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((codigoInfracao == null) ? 0 : codigoInfracao.hashCode());
		result = prime * result
				+ ((desdobramento == null) ? 0 : desdobramento.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemCtbPK other = (ItemCtbPK) obj;
		if (codigoInfracao == null) {
			if (other.codigoInfracao != null)
				return false;
		} else if (!codigoInfracao.equals(other.codigoInfracao))
			return false;
		if (desdobramento == null) {
			if (other.desdobramento != null)
				return false;
		} else if (!desdobramento.equals(other.desdobramento))
			return false;
		return true;
	}

}
