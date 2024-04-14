package br.com.fiap.produtomvc.repository;

import br.com.fiap.produtomvc.models.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {
}
