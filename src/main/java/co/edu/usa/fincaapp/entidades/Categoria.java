package co.edu.usa.fincaapp.entidades;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="categorias")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nombre",nullable = false,length = 50)
    private String nombre;
    @Column
    private String descripcion; 
    
    @JsonIgnore
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "categoria")
    //@JsonIgnoreProperties("categoria")
    private List<Finca> fincas;

    public List<Finca> getFincas(){
        return fincas;
    }
    public void setFincas(List<Finca> fincas){
        this.fincas = fincas;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
