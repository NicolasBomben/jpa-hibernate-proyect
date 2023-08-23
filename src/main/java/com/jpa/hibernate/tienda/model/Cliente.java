package com.jpa.hibernate.tienda.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long Id;
    private String nombre;
    private String dni;

    /*Default constructor.*/
    public Cliente(){

    }
    
    public Cliente(String nombre, String dni){
        this.nombre = nombre;
        this.dni = dni;
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

    public String getDni() {
      return this.dni;
    }
    public void setDni(String value) {
      this.dni = value;
    }
}

    
