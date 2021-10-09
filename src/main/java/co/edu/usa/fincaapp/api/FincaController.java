package co.edu.usa.fincaapp.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usa.fincaapp.entidades.Finca;
import co.edu.usa.fincaapp.servicios.FincaServicio;

@RestController
@RequestMapping("/api/v1/finca")
@CrossOrigin(origins = "*")

public class FincaController {
    @Autowired private FincaServicio fincaServicio;

    @GetMapping("/all")
    public List<Finca> getTodasFincas(){
        return fincaServicio.getFincas();
    }

    @PostMapping("/save")
    public Finca guardar(@RequestBody Finca finca){
        Finca f = fincaServicio.guardarFinca(finca);
        return f;
    }
    
}
