package co.edu.usa.fincaapp.respositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.usa.fincaapp.entidades.Finca;
@Repository
public class FincaRepository {
 
    @Autowired 
    private FincaCrudRepository fincaRepoitorio;

    public Optional<Finca> getFincaPorId(Long idFinca){
         return  fincaRepoitorio.findById(idFinca);
    }
    public List<Finca> getTodasFinca(){
        return (List<Finca>)fincaRepoitorio.findAll();
    }
    public Finca guardar(Finca f){
        return fincaRepoitorio.save(f);
    }
    public void borrar(Long id){
        fincaRepoitorio.deleteById(id);
    }
}
