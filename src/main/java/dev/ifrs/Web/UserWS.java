package dev.ifrs.Web;

import java.util.List;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dev.ifrs.Model.User;

@Path("/user")
@Transactional
public class UserWS {

    @POST
    @Path("/save")
    @PermitAll
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public User save(@FormParam("nome") String nome, @FormParam("login") String login, @FormParam("senha") String senha) {
        User user = new User();
        user.setNome(nome);
        user.setLogin(login);
        user.setSenha(senha);
        // 2 - O método do Panache `persist` possibilita persistir um objeto.
        user.persist();
        return user;
    }

    @GET
    @Path("/list")
    // @RolesAllowed({"User"})
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> list() {
        // 3 - O método `listAll` recupera todos os objetos da classe User.
        return User.listAll();
    }

    @GET
    @Path("/list/{id}")
    // @RolesAllowed({"User"})
    @Produces(MediaType.APPLICATION_JSON)
    public User list(@PathParam("id") Long id) {
        // 4 - O método do Panache `findById` recupera um objeto da classe User.
        return User.findById(id);
    }

    @DELETE
    @Path("/delete/{id}")
    // @RolesAllowed({"User"})
    @Produces(MediaType.APPLICATION_JSON)
    public User delete(@PathParam("id") Long id) {
        User u = User.findById(id);
        u.delete();
        return u;
    }

    @PUT
    @Path("/edit")
    // @RolesAllowed({"User"})
    @Produces(MediaType.APPLICATION_JSON)
    public User edit(@FormParam("id") Long id, @FormParam("nome") String nome, @FormParam("senha") String senha) {
        User u = User.findById(id);
        u.setNome(nome);
        u.setSenha(senha);
        return u;
    }

}