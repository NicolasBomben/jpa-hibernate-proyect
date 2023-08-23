package com.jpa.hibernate.tienda.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="categorias")
public class Categoria {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long Id;
    private String nombre;

    /*Default constructor */
    public Categoria(){      
    }

    /*Constructor.*/
    public Categoria(String nombre){
        this.nombre = nombre;
    }    

    /*Getters and setters.*/
    public long getId() {
      return this.Id;
    }
    
    public String getNombre() {
      return this.nombre;
    }
    public void setNombre(String value) {
      this.nombre = value;
    }
}
