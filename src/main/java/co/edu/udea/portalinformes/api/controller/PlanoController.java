package co.edu.udea.portalinformes.api.controller;

import co.edu.udea.portalinformes.api.model.InformeSismed;
import co.edu.udea.portalinformes.api.model.Plano;
import co.edu.udea.portalinformes.api.services.PlanoService;
import co.edu.udea.portalinformes.api.services.PlanoServiceInt;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;


@RestController
@RequestMapping("/planos")
public class PlanoController {
    private PlanoServiceInt planoService;

    public PlanoController(PlanoServiceInt planoService) {
        this.planoService = planoService;
    }

    @PostMapping("/importar")
    public List<InformeSismed> cargarPlano(@RequestBody Plano plano) throws ParseException {
        planoService = new PlanoService();
        return planoService.cargarPlano(plano);
    }

}
