package br.com.ApiNotas.apinotas.controller;

import java.util.List;

import br.com.ApiNotas.apinotas.domain.Local;
import br.com.ApiNotas.apinotas.request.LocalPostRequestBody;
import br.com.ApiNotas.apinotas.request.LocalPutRequestBody;
import br.com.ApiNotas.apinotas.request.RegiaoPostRequestBody;
import br.com.ApiNotas.apinotas.request.RegiaoPutRequestBody;
import br.com.ApiNotas.apinotas.service.LocalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ApiNotas.apinotas.domain.Regiao;
import br.com.ApiNotas.apinotas.service.RegiaoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping(value= "home")//ou Regioes
@Log4j2
@AllArgsConstructor
public class RegiaoController {
	
	private final RegiaoService regiaoService ;
	private  final LocalService localService;



	@GetMapping(path = "/regiao")
	public ResponseEntity<List<Regiao>> list(){
		return ResponseEntity.ok(regiaoService.listAll());
	}

	@GetMapping(path = "/regiao/{id}")
	public ResponseEntity<Regiao> findById(@PathVariable long id){
		return ResponseEntity.ok(regiaoService.findByIdOrThrowBadRequestException(id));
	}

	
	@PostMapping(path = "/regiao")
	public  ResponseEntity<Regiao> cadastrar(@RequestBody @Valid RegiaoPostRequestBody regiaoPostRequestBody ){
		return new ResponseEntity<>(regiaoService.save(regiaoPostRequestBody),HttpStatus.CREATED);
	}
	
	@DeleteMapping(path = "/regiao/{id}")
	public ResponseEntity<Void> excluir(@PathVariable long id){
		regiaoService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}


	@PutMapping(path = "/regiao")
	public ResponseEntity<Void> atualiza(@RequestBody @Valid RegiaoPutRequestBody regiaoPutRequestBody){
		regiaoService.replace(regiaoPutRequestBody);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
/*
A baixo todos estão relaiconados ao local
*/

	@GetMapping(path = "/local")
	public ResponseEntity<List<Local>> Locallist(){
		return ResponseEntity.ok(localService.listAll());
	}

	@GetMapping(path = "/local/{id}")
	public ResponseEntity<Local> findByLocalId(@PathVariable long id){
		return ResponseEntity.ok(localService.findByIdOrThrowBadRequestException(id));
	}

	@PostMapping(path = "/local")
	public  ResponseEntity<Local> cadastrarLocal(@RequestBody @Valid LocalPostRequestBody localPostRequestBody ){
		return new ResponseEntity<>(localService.save(localPostRequestBody),HttpStatus.CREATED);
	}

	@DeleteMapping(path = "/local/{id}")
	public ResponseEntity<Void> excluirLocal(@PathVariable long id){
		localService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@PutMapping(path = "/local")
	public ResponseEntity<Void> atualizaLocal(@RequestBody  LocalPutRequestBody localPutRequestBody){
		localService.replace(localPutRequestBody);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}


}

