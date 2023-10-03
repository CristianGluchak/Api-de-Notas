package br.com.ApiNotas.apinotas.request;

import lombok.Data;

@Data
public class RegiaoPutRequestBody {

    private  Long id;
    private String descricao;
    private  boolean status;

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
