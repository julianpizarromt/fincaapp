package co.edu.usa.fincaapp.servicios;

import java.util.List;

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
}
