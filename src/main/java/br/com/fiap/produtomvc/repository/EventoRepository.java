package br.com.fiap.produtomvc.repository;

import br.com.fiap.produtomvc.models.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoRepository extends JpaRepository<Evento, Long> {
}
