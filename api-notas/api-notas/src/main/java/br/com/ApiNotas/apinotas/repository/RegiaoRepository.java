package br.com.ApiNotas.apinotas.repository;

import java.util.List;

import br.com.ApiNotas.apinotas.domain.Regiao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegiaoRepository extends JpaRepository<Regiao , Long> {


    List<Regiao> findByDescricao(String descricao);
}

