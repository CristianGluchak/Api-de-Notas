package br.com.ApiNotas.apinotas.domain;

import br.com.ApiNotas.apinotas.domain.Regiao;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@Builder
@NoArgsConstructor
public class Local {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String descricaoLocal;
	@NotBlank
	private String cnpjLocal;

	@ManyToOne
	@JoinColumn(name = "regiao_id")
	private Regiao regiao;


	public String getDescricaoLocal() {
		return descricaoLocal;
	}
	public void setDescricaoLocal(String descricaoLocal) {
		this.descricaoLocal = descricaoLocal;
	}
	public String getCnpjLocal() {
		return cnpjLocal;
	}
	public void setCnpjLocal(String cnpjLocal) {
		this.cnpjLocal = cnpjLocal;
	}


}
