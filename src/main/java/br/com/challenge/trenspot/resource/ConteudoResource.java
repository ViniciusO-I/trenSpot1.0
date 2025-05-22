package br.com.challenge.trenspot.resource;
import java.util.List;

import br.com.challenge.trenspot.entity.Conteudo;
import br.com.challenge.trenspot.service.ServicoConteudo;
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

@Path("/conteudos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ConteudoResource {

    @Inject
    ServicoConteudo conteudoService;

    @GET
    public Response listar() {
        List<Conteudo> conteudos = conteudoService.listarTodos();
        return Response.ok(conteudos).build();
    }

    @GET
    @Path("/{id}")
    public Response buscarPorId(@PathParam("id") Long id) {
        Conteudo conteudo = conteudoService.buscarPorId(id);
        return Response.ok(conteudo).build();
    }

    @POST
    public Response criar(Conteudo conteudo) {
        Conteudo novo = conteudoService.salvar(conteudo);
        return Response.status(Response.Status.CREATED).entity(novo).build();
    }

    @PUT
    @Path("/{id}")
    public Response atualizar(@PathParam("id") Long id, Conteudo conteudo) {
        Conteudo atualizado = conteudoService.atualizar(id, conteudo);
        return Response.ok(atualizado).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deletar(@PathParam("id") Long id) {
        conteudoService.excluir(id);
        return Response.noContent().build();
    }
}