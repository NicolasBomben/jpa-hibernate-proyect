package com.jpa.hibernate.tienda.test;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import com.jpa.hibernate.tienda.dao.CategoriaDao;
import com.jpa.hibernate.tienda.dao.ProductoDao;
import com.jpa.hibernate.tienda.model.Categoria;
import com.jpa.hibernate.tienda.model.Producto;
import com.jpa.hibernate.tienda.utils.JPAUtils;

public class RegistroDeProducto {

    public static void main(String[] args) {
        registrarProducto();
        EntityManager em = JPAUtils.getEntityManager();
        ProductoDao productoDao = new ProductoDao(em);
        Producto producto = productoDao.consultaPorId(1l);
        System.out.println(producto.getNombre());

        BigDecimal precio = productoDao.consultarPrecioPorNombreDeProducto("Xiaomi Redmi");
        System.out.println(precio);

    }

    private static void registrarProducto() {
        Categoria celulares = new Categoria("CELULARES");

        Producto celular = new Producto("Xiaomi Redmi", "Muy bueno", new BigDecimal("800"), celulares);

        EntityManager em = JPAUtils.getEntityManager();
        ProductoDao productoDao = new ProductoDao(em);
        CategoriaDao categoriaDao = new CategoriaDao(em);

        em.getTransaction().begin();

        categoriaDao.guardar(celulares);
        productoDao.guardar(celular);

        em.getTransaction().commit();
        em.close();
    }

}