package br.com.ApiNotas.apinotas.service;
import br.com.ApiNotas.apinotas.repository.RegiaoRepository;
import br.com.ApiNotas.apinotas.request.RegiaoPostRequestBody;
import br.com.ApiNotas.apinotas.request.RegiaoPutRequestBody;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import br.com.ApiNotas.apinotas.domain.Regiao;

@Service

public class RegiaoService {
	private final RegiaoRepository regiaoRepository;

	public RegiaoService(@Autowired RegiaoRepository regiaoRepository) {
		this.regiaoRepository = regiaoRepository;
	}

	public List<Regiao> listAll(){

		return regiaoRepository.findAll();
	}
	
	public Regiao findByIdOrThrowBadRequestException(long id){
		return regiaoRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST,"Regiao not Found"));
	}
	public List<Regiao> findByDescricaoOrThrowBadRequestException(String descricao){
		return regiaoRepository.findByDescricao(descricao);	}


	public Regiao save(RegiaoPostRequestBody regiaoPostRequestBody) {
		String descricao = regiaoPostRequestBody.getDescricao();
		List<Regiao> regiao = findByDescricaoOrThrowBadRequestException(descricao);
		if (regiao.isEmpty()) {
			return regiaoRepository.save(Regiao.builder().descricao(regiaoPostRequestBody.getDescricao())
					.status((regiaoPostRequestBody.getStatus())).build());
		} else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Regiao já cadastrada");
		}
	}


	public void delete(long id) {
		regiaoRepository.delete(findByIdOrThrowBadRequestException(id));
		
	}

	public void replace(RegiaoPutRequestBody regiaoPutRequestBody) {
		Regiao  regiaosave =findByIdOrThrowBadRequestException(regiaoPutRequestBody.getId());
		Regiao regiao = Regiao.builder()
				.id(regiaosave.getId())
				.descricao(regiaoPutRequestBody.getDescricao())
				.status(regiaoPutRequestBody.getStatus())
				.build();
		regiaoRepository.save(regiao);

		
	}


}
