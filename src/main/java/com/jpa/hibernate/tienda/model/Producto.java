package com.jpa.hibernate.tienda.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name="productos")
@NamedQuery(name="Producto.consultarPrecioPorNombre", query="SELECT P.precio FROM Producto AS P WHERE P.nombre=:nombre")
@Inheritance(strategy=InheritanceType.JOINED)
public class Producto {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String descripcion;
    private BigDecimal precio;
    private LocalDate fechaDeRegistro = LocalDate.now();

    @ManyToOne(fetch=FetchType.LAZY)
    private Categoria categoria;

    /*Constructor.*/
    public Producto(String nombre, String descripcion, BigDecimal precio, Categoria categoria){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.categoria = categoria;
    }

    /*Default constructor */
    public Producto(){
      
    }

    /*getters and setters */
    public Long getId() {
      return this.id;
    }
    public void setId(Long value) {
      this.id = value;
    }

    public String getNombre() {
      return this.nombre;
    }
    public void setNombre(String value) {
      this.nombre = value;
    }

    public String getDescripcion() {
      return this.descripcion;
    }
    public void setDescripcion(String value) {
      this.descripcion = value;
    }

    public BigDecimal getPrecio() {
      return this.precio;
    }
    public void setPrecio(BigDecimal value) {
      this.precio = value;
    }
}
