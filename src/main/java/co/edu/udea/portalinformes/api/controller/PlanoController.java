package co.edu.udea.portalinformes.api.controller;

import co.edu.udea.portalinformes.api.model.Plano;
import co.edu.udea.portalinformes.api.model.Sismed;
import co.edu.udea.portalinformes.api.services.PlanoServiceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/planos")
public class PlanoController {

    @Autowired
    private PlanoServiceInt planoService;

    public PlanoController(PlanoServiceInt planoService) {
        this.planoService = planoService;
    }

    @GetMapping
    public ResponseEntity<List<Plano>> getPlanos() {
        return ResponseEntity.ok(planoService.getPlanos());
    }

    @GetMapping(value = "consultar/{id}")
    public ResponseEntity<Plano> getPlano(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(planoService.getPlano(id));
    }

    @PostMapping(value = "/add")
    public ResponseEntity<Plano> addPlano(@Valid @RequestBody Plano newPlano) {
        return new ResponseEntity<>(planoService.addPlano(newPlano), HttpStatus.CREATED);
    }

    @PostMapping("/importar")
    public List<Sismed> cargarPlano(@RequestBody Plano plano) throws ParseException {
        return planoService.cargarPlano(plano);
    }

}
