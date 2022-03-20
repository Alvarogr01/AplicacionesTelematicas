package Indra.Solicitudes.Controler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController

public class SolicitudesControler {

    @GetMapping("/api/Identificadores")
    public @ResponseBody ResponseEntity<List<String>> getSolicitudes() {
        log.info("Ejecutando la lista de Identificadores");

            List<String> ID = List.of(
                    "Dni",
                    "Nif",
                    "Pasaporte",
                    "Otro");
            return ResponseEntity.ok().body(ID);
    }

    @GetMapping("/api/trenes/{id}")
    public  @ResponseBody
    ResponseEntity<String> getTrenesById(@PathVariable ("id") String id){
        log.info("El parametro recibido es : "+ id);
        Optional<String> Identificador = List.of(
                "Dni",
                "Nif",
                "Pasaporte",
                "Otro").stream()
                .filter(s -> s.toLowerCase().equals(id.toLowerCase()))
                .findAny() ;
        if(Identificador.isPresent()) {
            return ResponseEntity.ok().body(Identificador.get());
        } else  {
            log.error("no se ha encontrado");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("");
        }
    }

    @PostMapping("/postPersona")
    public String postPersona(@RequestBody Persona persona){
        
        return persona.toString();
    }
}
