package co.edu.usa.fincaapp.respositorios;

import org.springframework.data.repository.CrudRepository;

import co.edu.usa.fincaapp.entidades.Categoria;

public interface FincaCrudRespository extends CrudRepository<Categoria, Long>{
    
}
