package br.com.challenge.trenspot.service;

import java.util.List;

import br.com.challenge.trenspot.entity.Passageiro;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.WebApplicationException;

@ApplicationScoped
public class ServicoPassageiro {

    public List<Passageiro> listarTodos() {
        return Passageiro.listAll();
    }

    public Passageiro buscarPorId(Long id) {
        return (Passageiro) Passageiro.findByIdOptional(id)
                .orElseThrow(() -> new NotFoundException("ID " + id + " nao encontrado"));
    }

    @Transactional
    public Passageiro salvar(Passageiro passageiro) {
        try {
            passageiro.persist();
            return passageiro;
        } catch (Exception e) {
            throw new WebApplicationException("Erro ao salvar passageiro: " + e.getMessage(), 500);
        }
    }

    @Transactional
    public Passageiro atualizar(Long id, Passageiro dados) {
        Passageiro existente = buscarPorId(id);
        try {
            existente.setNome(dados.getNome());
            existente.setEmail(dados.getEmail());
            return existente;
        } catch (Exception e) {
            throw new WebApplicationException("Erro ao atualizar passageiro: " + e.getMessage(), 500);
        }
    }

    @Transactional
    public void excluir(Long id) {
        try {
            if (!Passageiro.deleteById(id)) {
                throw new NotFoundException("ID " + id + " nao encontrado");
            }
        } catch (Exception e) {
            throw new WebApplicationException("Erro ao excluir passageiro: " + e.getMessage(), 500);
        }
    }
}