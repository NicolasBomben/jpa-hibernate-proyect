package com.jpa.hibernate.tienda.test;

import java.io.FileNotFoundException;

import javax.persistence.EntityManager;

import com.jpa.hibernate.tienda.dao.PedidoDao;
import com.jpa.hibernate.tienda.model.Pedido;
import com.jpa.hibernate.tienda.utils.JPAUtils;

public class PruebaDeDesempeño {
	public static void main(String[] args) throws FileNotFoundException {
		LoadRecords.cargarRegistros();
		
		EntityManager em = JPAUtils.getEntityManager();
		
		PedidoDao pedidoDao = new PedidoDao(em);
		Pedido pedidoConCliente = pedidoDao.consultarPedidoConCliente(2l);
		
		em.close();
		
        //System.out.println(pedido.getFecha());
        //System.out.println(pedido.getItems().size());
		System.out.println(pedidoConCliente.getCliente().getNombre());
		
	}
}
