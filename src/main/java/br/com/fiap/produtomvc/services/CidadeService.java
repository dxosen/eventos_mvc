package br.com.fiap.produtomvc.services;

import br.com.fiap.produtomvc.models.Cidade;
import br.com.fiap.produtomvc.repository.CidadeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CidadeService {


    @Autowired
    private CidadeRepository repository;


    @Transactional(readOnly = true)
    public List<Cidade> findAll() {
        return repository.findAll();
    }


    @Transactional
    public Cidade insert(Cidade cidade) {
        return repository.save(cidade);
    }


    @Transactional(readOnly = true)
    public Cidade findById(Long id) {

        Cidade cidade = repository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Recurso inválido - " + id)
        );
        return cidade;
    }


    @Transactional
    public Cidade update(Long id, Cidade entity) {

        try {
            Cidade cidade = repository.getReferenceById(id);
            copyToCategoria(entity, cidade);
            cidade = repository.save(cidade);
            return cidade;
        } catch (EntityNotFoundException e) {
            throw new IllegalArgumentException("Recurso não encontrado");
        }
    }


    @Transactional
    public void delete(Long id) {

        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Recurso inválido - id: " + id);
        }
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new IllegalArgumentException("Falha de integridade referencial - id: " + id);
        }
    }


    private void copyToCategoria(Cidade entity, Cidade cidade) {
        cidade.setNome(entity.getNome());
    }


}



