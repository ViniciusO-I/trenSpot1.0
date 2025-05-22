package br.com.challenge.trenspot.service;

import java.util.List;

import br.com.challenge.trenspot.entity.Investidor;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.WebApplicationException;

@ApplicationScoped
public class ServicoInvestidor {

    public List<Investidor> listarTodos() {
        return Investidor.listAll();
    }

    public Investidor buscarPorId(Long id) {
        return (Investidor) Investidor.findByIdOptional(id)
                .orElseThrow(() -> new NotFoundException("ID: " + id + " nao encontrado"));
    }

    @Transactional
    public Investidor salvar(Investidor investidor) {
        try {
            investidor.persist();
            return investidor;
        } catch (Exception e) {
            throw new WebApplicationException("Erro ao tentar salvar investidor: " + e.getMessage(), 500);
        }
    }

    @Transactional
    public Investidor atualizar(Long id, Investidor dados) {
        Investidor existente = buscarPorId(id);
        try {
            existente.nomeEmpresa = dados.nomeEmpresa;
            existente.email = dados.email;
            existente.quantidade = dados.quantidade;
            existente.nome = dados.nome;
            return existente;
        } catch (Exception e) {
            throw new WebApplicationException("Erro ao tentar atualizar: " + e.getMessage(), 500);
        }
    }

    @Transactional
    public boolean excluir(Long id) {
        try {
            if (!Investidor.deleteById(id)) {
                throw new NotFoundException("ID: " + id + " nao encontrado");
            }
        } catch (Exception e) {
            throw new WebApplicationException("Erro ao excluir: " + e.getMessage(), 500);
        }
                return false;
    }
}