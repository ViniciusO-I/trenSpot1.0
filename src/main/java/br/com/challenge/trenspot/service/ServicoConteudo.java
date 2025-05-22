package br.com.challenge.trenspot.service;
import java.util.List;

import br.com.challenge.trenspot.entity.Conteudo;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.WebApplicationException;

@ApplicationScoped
public class ServicoConteudo {

    public List<Conteudo> listarTodos() {
        return Conteudo.listAll();
    }

    public Conteudo buscarPorId(Long id) {
        return (Conteudo) Conteudo.findByIdOptional(id)
                .orElseThrow(() -> new NotFoundException("ID: " + id + " nao encontrado"));
    }

    @Transactional
    public Conteudo salvar(Conteudo conteudo) {
        try {
            conteudo.persist();
            return conteudo;
        } catch (Exception e) {
            throw new WebApplicationException("Erro ao  tentar salvar conteudo: " + e.getMessage(), 500);
        }
    }

    @Transactional
    public Conteudo atualizar(Long id, Conteudo dados) {
        Conteudo existente = buscarPorId(id);
        try {
            existente.titulo = dados.titulo;
            return existente;
        } catch (Exception e) {
            throw new WebApplicationException("Erro ao tentar atualizar: " + e.getMessage(), 500);
        }
    }

    @Transactional
    public void excluir(Long id) {
        try {
            if (!Conteudo.deleteById(id)) {
                throw new NotFoundException("ID:  " + id + " nao encontrado");
            }
        } catch (Exception e) {
            throw new WebApplicationException("Erro ao excluir : " + e.getMessage(), 500);
        }
    }
}