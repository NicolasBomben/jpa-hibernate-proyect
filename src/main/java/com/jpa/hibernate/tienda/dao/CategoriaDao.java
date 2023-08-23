package com.jpa.hibernate.tienda.dao;

import javax.persistence.EntityManager;

import com.jpa.hibernate.tienda.model.Categoria;

public class CategoriaDao {
    
    private EntityManager entityManager;

    /*Contructor.*/
    public CategoriaDao(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    /*Methods */
    public void guardar(Categoria categoria){
        this.entityManager.persist(categoria);
    }

    public void actualizar(Categoria categoria){
        this.entityManager.merge(categoria);
    }

    public void remover(Categoria categoria){
        categoria = this.entityManager.merge(categoria);
        this.entityManager.remove(categoria);
    }

    public Categoria consultaPorNombre(String nombre){
		String jpql =" SELECT C FROM Categoria AS C WHERE C.nombre=:nombre ";
		return entityManager.createQuery(jpql,Categoria.class).setParameter("nombre", nombre).getSingleResult();
	}
}
