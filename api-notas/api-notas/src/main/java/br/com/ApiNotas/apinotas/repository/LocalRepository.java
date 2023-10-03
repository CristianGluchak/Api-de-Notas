package br.com.ApiNotas.apinotas.repository;

import br.com.ApiNotas.apinotas.domain.Local;
import br.com.ApiNotas.apinotas.domain.Regiao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalRepository extends JpaRepository<Local , Long> {


}
