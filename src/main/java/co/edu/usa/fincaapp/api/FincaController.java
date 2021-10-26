package co.edu.usa.fincaapp.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usa.fincaapp.entidades.Finca;
import co.edu.usa.fincaapp.servicios.FincaServicio;

@RestController
@RequestMapping("/api/Farm")
@CrossOrigin(origins = "*")

public class FincaController {
    @Autowired private FincaServicio fincaServicio;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Finca> getTodasFincas(){
        return fincaServicio.getFincas();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Finca guardar(@RequestBody Finca finca){
        Finca f = fincaServicio.guardarFinca(finca);
        return f;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable("id") Long id){
        fincaServicio.eliminarFinca(id);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Finca> getFincaPorId(@PathVariable("id") Long id){
        Optional<Finca> fincaInDB = fincaServicio.getFincaPorId(id);
        if(fincaInDB.isPresent()){
            return new ResponseEntity(fincaInDB.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/update")
    public ResponseEntity<Finca> actualizar (@RequestBody Finca finca){
        Finca f = fincaServicio.actualizar(finca);
        if(f != null)
            return new ResponseEntity<>(f, HttpStatus.CREATED);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
}
