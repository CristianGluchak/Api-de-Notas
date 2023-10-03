package br.com.ApiNotas.apinotas.request;

import lombok.Data;

@Data

public class RegiaoPostRequestBody {


    private String descricao;
    private  boolean status;

    public RegiaoPostRequestBody(String descricao, boolean status){
        this.descricao=descricao;
        this.status=status;
    }
    public boolean getStatus() {
        return status;
    }

}
