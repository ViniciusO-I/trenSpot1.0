package br.com.challenge.trenspot.resource;
import java.util.List;

import br.com.challenge.trenspot.entity.Investidor;
import br.com.challenge.trenspot.service.ServicoInvestidor;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/investidores")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class InvestidorResource {

    @Inject
    ServicoInvestidor servico;

    @GET
    public List<Investidor> listar() {
        return servico.listarTodos();
    }

    @GET
    @Path("/{id}")
    public Response buscar(@PathParam("id") Long id) {
        Investidor investidor = servico.buscarPorId(id);
        if (investidor == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(investidor).build();
    }

    @POST
    public Response criar(Investidor investidor) {
        Investidor novo = servico.salvar(investidor);
        return Response.status(Response.Status.CREATED).entity(novo).build();
    }

    @DELETE
    @Path("/{id}")
    public Response excluir(@PathParam("id") Long id) {
        boolean removido = servico.excluir(id);
        if (removido) {
            return Response.noContent().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}