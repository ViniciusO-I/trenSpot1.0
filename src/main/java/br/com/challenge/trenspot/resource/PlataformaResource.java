package br.com.challenge.trenspot.resource;

import java.util.List;

import br.com.challenge.trenspot.entity.Plataforma;
import br.com.challenge.trenspot.service.ServicoPlataforma;
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

@Path("/plataformas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PlataformaResource {

    @Inject
    ServicoPlataforma servico;

    @GET
    public List<Plataforma> listarTodos() {
        return servico.listarTodos();
    }

    @GET
    @Path("/{id}")
    public Plataforma buscarPorId(@PathParam("id") Long id) {
        return servico.buscarPorId(id);
    }

    @POST
    public Response criar(Plataforma plataforma) {
        Plataforma nova = servico.salvar(plataforma);
        return Response.status(Response.Status.CREATED).entity(nova).build();
    }

    @PUT
    @Path("/{id}")
    public Plataforma atualizar(@PathParam("id") Long id, Plataforma plataforma) {
        return servico.atualizar(id, plataforma);
    }

    @DELETE
    @Path("/{id}")
    public Response excluir(@PathParam("id") Long id) {
        servico.excluir(id);
        return Response.noContent().build();
    }
}