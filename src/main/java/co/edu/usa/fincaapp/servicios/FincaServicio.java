package co.edu.usa.fincaapp.servicios;

import java.lang.StackWalker.Option;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usa.fincaapp.entidades.Finca;
import co.edu.usa.fincaapp.respositorios.FincaRepository;

@Service
public class FincaServicio {
    @Autowired
    private FincaRepository fincaRepository;
    
    public List<Finca> getFincas(){
        return fincaRepository.getTodasFinca();
    }
    public Finca guardarFinca(Finca finca){
        return fincaRepository.guardar(finca);
    }
    public void eliminarFinca(Long id){
        fincaRepository.borrar(id);
    }

    public Optional<Finca> getFincaPorId(Long id){
        return fincaRepository.getFincaPorId(id);
    }

    public Finca actualizar(Finca finca){
        Optional<Finca> fincaInDB = fincaRepository.getFincaPorId(finca.getId());
        if(fincaInDB.isPresent()){
            Finca f = fincaInDB.get();
            f.setName(finca.getName());
            f.setAddress(finca.getAddress());
            f.setExension(finca.getExension());
            return fincaRepository.editar(f);
        }
        return null;
    }
}
