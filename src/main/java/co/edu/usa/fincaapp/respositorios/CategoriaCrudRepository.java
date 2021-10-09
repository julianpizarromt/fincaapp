package co.edu.usa.fincaapp.respositorios;

import org.springframework.data.repository.CrudRepository;

import co.edu.usa.fincaapp.entidades.Categoria;

public interface CategoriaCrudRepository extends CrudRepository<Categoria, Long>{
    
}
