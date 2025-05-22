package br.com.challenge.trenspot.service;

import java.util.List;

import br.com.challenge.trenspot.entity.Plataforma;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
public class ServicoPlataforma {

    @PersistenceContext
    EntityManager em;

    public List<Plataforma> listarTodos() {
        return em.createQuery("FROM Plataforma", Plataforma.class).getResultList();
    }

    public Plataforma buscarPorId(Long id) {
        Plataforma plataforma = em.find(Plataforma.class, id);
        if (plataforma == null) {
            throw new NotFoundException("Plataforma  ID: " + id + " nao encontrado.");
        }
        return plataforma;
    }

    @Transactional
    public Plataforma salvar(Plataforma plataforma) {
        try {
            em.persist(plataforma);
            return plataforma;
        } catch (Exception e) {
            throw new WebApplicationException("Erro ao salvar plataforma: " + e.getMessage(), Response.Status.BAD_REQUEST);
        }
    }

    @Transactional
    public Plataforma atualizar(Long id, Plataforma plataformaAtualizada) {
        Plataforma existente = em.find(Plataforma.class, id);
        if (existente == null) {
            throw new NotFoundException("Plataforma ID " + id + " nao atualizada.");
        }

        try {
            existente.setIdEstacao(plataformaAtualizada.getIdEstacao());
            existente.setNome(plataformaAtualizada.getNome());
            existente.setStatus(plataformaAtualizada.getStatus());
            existente.setDescricao(plataformaAtualizada.getDescricao());
            return existente;
        } catch (Exception e) {
            throw new WebApplicationException("Erro ao atualizar plataforma: " + e.getMessage(), Response.Status.BAD_REQUEST);
        }
    }

    @Transactional
    public void excluir(Long id) {
        Plataforma plataforma = em.find(Plataforma.class, id);
        if (plataforma == null) {
            throw new NotFoundException("Plataforma ID:  " + id + " nqo excluida, erro na busca.");
        }

        try {
            em.remove(plataforma);
        } catch (Exception e) {
            throw new WebApplicationException("Erro ao excluir plataforma: " + e.getMessage(), Response.Status.INTERNAL_SERVER_ERROR);
        }
    }
}