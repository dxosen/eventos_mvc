package br.com.fiap.produtomvc.services;

import br.com.fiap.produtomvc.models.Evento;
import br.com.fiap.produtomvc.repository.EventoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EventoService {

    @Autowired
    private EventoRepository repository;

    @Transactional(readOnly = true)
    public List<Evento> findAll() {
        return repository.findAll();
    }

    @Transactional
    public Evento insert(Evento evento) {
        return repository.save(evento);
    }

    @Transactional(readOnly = true)
    public Evento findById(Long id) {

        Evento evento = repository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Recurso inválido - " + id)
        );
        return evento;
    }

    @Transactional
    public Evento update(Long id, Evento entity) {
        try {
            Evento evento = repository.getReferenceById(id);
            copyToEvento(entity, evento);
            evento = repository.save(evento);
            return evento;
        } catch (EntityNotFoundException e) {
            throw new IllegalArgumentException("Recurso não encontrado");
        }
    }

    @Transactional
    public void delete(Long id){
        if(!repository.existsById(id)){
            throw new IllegalArgumentException("Evento inválido - id: " + id);
        }
        try {
            repository.deleteById(id);
        } catch (Exception e){
            throw new IllegalArgumentException("Evento inválido - id: " + id);
        }
    }

    private void copyToEvento(Evento entity, Evento evento) {
        evento.setNome(entity.getNome());
        evento.setData(entity.getData());
        evento.setUrl(entity.getUrl());
        evento.setCidade(entity.getCidade());
    }


}



