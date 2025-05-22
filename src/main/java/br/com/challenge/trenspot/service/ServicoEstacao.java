package br.com.challenge.trenspot.service;

import java.util.List;

import br.com.challenge.trenspot.entity.Estacao;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
public class ServicoEstacao {

    @PersistenceContext
    EntityManager em;

    public List<Estacao> listarTodos() {
        return em.createQuery("FROM Estacao", Estacao.class).getResultList();
    }

    public Estacao buscarPorId(Long id) {
        Estacao estacao = em.find(Estacao.class, id);
        if (estacao == null) {
            throw new NotFoundException("Estacao ID " + id + " nao encontrada.");
        }
        return estacao;
    }

    @Transactional
    public Estacao salvar(Estacao estacao) {
        try {
            em.persist(estacao);
            return estacao;
        } catch (Exception e) {
            throw new WebApplicationException("Erro ao salvar estacao: " + e.getMessage(), Response.Status.BAD_REQUEST);
        }
    }

    @Transactional
    public Estacao atualizar(Long id, Estacao estacaoAtualizada) {
        Estacao existente = em.find(Estacao.class, id);
        if (existente == null) {
            throw new NotFoundException("Estacao ID:  " + id + " nao encontrada para atualizar.");
        }

        try {
            existente.setNome(estacaoAtualizada.getNome());
            existente.setMediaPassageiro(estacaoAtualizada.getMediaPassageiro());
            return existente;
        } catch (Exception e) {
            throw new WebApplicationException("Erro ao atualizar estacao: " + e.getMessage(), Response.Status.BAD_REQUEST);
        }
    }

    @Transactional
    public void excluir(Long id) {
        Estacao estacao = em.find(Estacao.class, id);
        if (estacao == null) {
            throw new NotFoundException("Estacao ID:  " + id + " nao encontrada para excluir.");
        }

        try {
            em.remove(estacao);
        } catch (Exception e) {
            throw new WebApplicationException("Erro ao excluir estacao: " + e.getMessage(), Response.Status.INTERNAL_SERVER_ERROR);
        }
    }
}