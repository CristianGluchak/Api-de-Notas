package br.com.ApiNotas.apinotas.service;

import br.com.ApiNotas.apinotas.domain.Local;
import br.com.ApiNotas.apinotas.repository.LocalRepository;
import br.com.ApiNotas.apinotas.request.LocalPostRequestBody;
import br.com.ApiNotas.apinotas.request.LocalPutRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LocalService {

    private final LocalRepository localRepository;



    public List<Local> listAll(){
        return localRepository.findAll();
    }

    public Local findByIdOrThrowBadRequestException(long id){
        return localRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST,"Local not Found"));
    }

    public Local save(LocalPostRequestBody localPostRequestBody) {
        return localRepository.save(Local.builder().descricaoLocal(localPostRequestBody.getDescricaoLocal())
                              .cnpjLocal((localPostRequestBody.getCnpjLocal()))
                              .regiao(localPostRequestBody.getRegiao())
                              .build());
    }

    public void replace(LocalPutRequestBody localPutRequestBody) {
        Local localsave = findByIdOrThrowBadRequestException(localPutRequestBody.getId());
        Local local = Local.builder()
                .id(localsave.getId())
                .descricaoLocal(localPutRequestBody.getDescricaoLocal())
                .cnpjLocal(localPutRequestBody.getCnpjLocal())
                .regiao(localPutRequestBody.getRegiao())
                .build();

        localRepository.save(local);
    }
    public void delete(long id) {
        localRepository.delete(findByIdOrThrowBadRequestException(id));
    }

}
