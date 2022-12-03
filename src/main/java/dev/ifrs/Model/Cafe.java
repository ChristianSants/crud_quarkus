package dev.ifrs.Model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

/**
 * Example JPA entity.
 *
 * To use it, get access to a JPA EntityManager via injection.
 *
 * {@code
 *     @Inject
 *     EntityManager em;
 *
 *     public void doSomething() {
 *         MyEntity entity1 = new MyEntity();
 *         entity1.setField("field-1");
 *         em.persist(entity1);
 *
 *         List<MyEntity> entities = em.createQuery("from MyEntity", MyEntity.class).getResultList();
 *     }
 * }
 */
@Entity
public class Cafe extends PanacheEntity {
    private String nome;
    private int nota;
    private String tipo;
    private boolean favorito;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonManagedReference
    private Cafeteria cafeteria;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference
    private User user;

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNota() {
        return this.nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean getFavorito() {
        return favorito;
    }

    public void setFavorito(boolean favorito) {
        this.favorito = favorito;
    }

    public Cafeteria getCafeteria() {
        return cafeteria;
    }

    public void setCafeteria(Cafeteria cafeteria) {
        this.cafeteria = cafeteria;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
