package br.com.challenge.trenspot.resource;

import java.util.List;

import br.com.challenge.trenspot.entity.Estacao;
import br.com.challenge.trenspot.service.ServicoEstacao;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/estacoes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EstacaoResource {

    @Inject
    ServicoEstacao servico;

    @GET
    public List<Estacao> listarTodos() {
        return servico.listarTodos();
    }

    @GET
    @Path("/{id}")
    public Estacao buscarPorId(@PathParam("id") Long id) {
        return servico.buscarPorId(id);
    }

    @POST
    public Response criar(Estacao estacao) {
        Estacao nova = servico.salvar(estacao);
        return Response.status(Response.Status.CREATED).entity(nova).build();
    }

    @PUT
    @Path("/{id}")
    public Estacao atualizar(@PathParam("id") Long id, Estacao estacao) {
        return servico.atualizar(id, estacao);
    }

    @DELETE
    @Path("/{id}")
    public Response excluir(@PathParam("id") Long id) {
        servico.excluir(id);
        return Response.noContent().build();
    }
}