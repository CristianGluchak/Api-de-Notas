package br.com.ApiNotas.apinotas.request;

import br.com.ApiNotas.apinotas.domain.Regiao;
import lombok.Data;

@Data

public class LocalPostRequestBody {


    private String descricaoLocal;
    private String cnpjLocal;
    private Regiao regiao;
    public LocalPostRequestBody(String descricao,String cnpj, Regiao regiao){
        this.descricaoLocal=descricao;
        this.cnpjLocal=cnpj;
        this.regiao=regiao;

    }

}
