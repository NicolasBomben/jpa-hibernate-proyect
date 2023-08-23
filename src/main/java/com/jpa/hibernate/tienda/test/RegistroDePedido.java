package com.jpa.hibernate.tienda.test;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import com.jpa.hibernate.tienda.dao.CategoriaDao;
import com.jpa.hibernate.tienda.dao.ClienteDao;
import com.jpa.hibernate.tienda.dao.PedidoDao;
import com.jpa.hibernate.tienda.dao.ProductoDao;
import com.jpa.hibernate.tienda.model.Categoria;
import com.jpa.hibernate.tienda.model.Cliente;
import com.jpa.hibernate.tienda.model.ItemsPedido;
import com.jpa.hibernate.tienda.model.Pedido;
import com.jpa.hibernate.tienda.model.Producto;
import com.jpa.hibernate.tienda.utils.JPAUtils;
import com.jpa.hibernate.tienda.vo.RelatorioDeVenta;


public class RegistroDePedido {

	public static void main(String[] args) throws FileNotFoundException {
		registrarProducto();
		
		EntityManager em = JPAUtils.getEntityManager();
		
		ProductoDao productoDao = new ProductoDao(em);
		Producto producto = productoDao.consultaPorId(1l);

		ClienteDao clienteDao = new ClienteDao(em);
		PedidoDao pedidoDao = new PedidoDao(em);

		Cliente cliente = new Cliente("Juan","k6757kjb");
		Pedido pedido = new Pedido(cliente);
		pedido.agregarItems(new ItemsPedido(5,producto,pedido));
		
		em.getTransaction().begin();

		clienteDao.guardar(cliente);
		pedidoDao.guardar(pedido);
		
		em.getTransaction().commit();
		
		BigDecimal valorTotal=pedidoDao.valorTotalVendido();
		System.out.println("Valor Total: "+ valorTotal);
		
		List<RelatorioDeVenta> relatorio = pedidoDao.relatorioDeVentasVO();
		
		relatorio.forEach(System.out::println);
		
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