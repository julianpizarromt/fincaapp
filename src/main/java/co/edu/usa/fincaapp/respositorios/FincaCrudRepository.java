package co.edu.usa.fincaapp.respositorios;

import org.springframework.data.repository.CrudRepository;

import co.edu.usa.fincaapp.entidades.Finca;

public interface FincaRepository extends CrudRepository<Finca,Long>{
    
}
