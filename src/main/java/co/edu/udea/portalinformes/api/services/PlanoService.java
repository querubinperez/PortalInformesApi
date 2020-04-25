package co.edu.udea.portalinformes.api.services;

import co.edu.udea.portalinformes.api.model.Plano;
import org.springframework.stereotype.Service;

@Service
public class PlanoService implements PlanoServiceInt {

    @Override
    public String cargarPlano(Plano plano) {
        //plano.getDataPlano().split("|");
        return "OK";
    }


}
