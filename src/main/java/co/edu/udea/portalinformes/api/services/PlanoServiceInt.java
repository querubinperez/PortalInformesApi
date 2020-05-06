package co.edu.udea.portalinformes.api.services;

import co.edu.udea.portalinformes.api.model.InformeSismed;
import co.edu.udea.portalinformes.api.model.Plano;

import java.text.ParseException;
import java.util.List;

public interface PlanoServiceInt {
    List<InformeSismed> cargarPlano(Plano plano) throws ParseException;
}
