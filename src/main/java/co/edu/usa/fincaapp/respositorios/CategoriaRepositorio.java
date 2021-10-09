package co.edu.usa.fincaapp.respositorios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CategoriaRepositorio {
    @Autowired 
    private CategoriaCrudRepository categoriaRespositorio; 

}
