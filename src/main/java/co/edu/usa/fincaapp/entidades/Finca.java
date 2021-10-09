package co.edu.usa.fincaapp.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name="fincas")
public class Finca{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="address")
    private String address;
    @Column(name="exension")
    private Double exension;
    @Column(name="name")
    private String name;

    @ManyToOne
    @JoinColumn(name="categoria_id")
    @JsonIgnoreProperties("fincas")
    private Categoria categoria;

   
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public Double getExension() {
        return exension;
    }
    public void setExension(Double exension) {
        this.exension = exension;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }



}
