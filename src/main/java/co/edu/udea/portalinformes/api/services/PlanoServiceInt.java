package co.edu.udea.portalinformes.api.services;

import co.edu.udea.portalinformes.api.model.Plano;
import co.edu.udea.portalinformes.api.model.Sismed;

import java.text.ParseException;
import java.util.List;

public interface PlanoServiceInt {
    List<Plano> getPlanos();

    Plano getPlano(Integer plano_id);

    Plano addPlano(Plano plano);

    List<Sismed> cargarPlano(Plano plano) throws ParseException;
}
