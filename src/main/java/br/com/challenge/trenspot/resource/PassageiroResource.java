package br.com.challenge.trenspot.resource;
import java.util.List;

import br.com.challenge.trenspot.entity.Passageiro;
import br.com.challenge.trenspot.service.ServicoPassageiro;
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

@Path("/passageiros")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PassageiroResource {

    @Inject
    ServicoPassageiro servico;

    @GET
    public List<Passageiro> listarTodos() {
        return servico.listarTodos();
    }

    @GET
    @Path("/{id}")
    public Passageiro buscarPorId(@PathParam("id") Long id) {
        return servico.buscarPorId(id);
    }

    @POST
    public Response criar(Passageiro passageiro) {
        Passageiro novo = servico.salvar(passageiro);
        return Response.status(Response.Status.CREATED).entity(novo).build();
    }

    @PUT
    @Path("/{id}")
    public Passageiro atualizar(@PathParam("id") Long id, Passageiro passageiro) {
        return servico.atualizar(id, passageiro);
    }

    @DELETE
    @Path("/{id}")
    public Response excluir(@PathParam("id") Long id) {
        servico.excluir(id);
        return Response.noContent().build();
    }
}