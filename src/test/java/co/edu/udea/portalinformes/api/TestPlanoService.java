package co.edu.udea.portalinformes.api;

import co.edu.udea.portalinformes.api.model.InformeSismed;
import co.edu.udea.portalinformes.api.model.Plano;
import co.edu.udea.portalinformes.api.services.PlanoService;
import co.edu.udea.portalinformes.api.services.PlanoServiceInt;
import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class TestPlanoService {

    @Test
    public void DadoImportarPlanoEntoncesDebeRetornarListaObjectos() throws ParseException {
        //arrange
        Plano plano = new Plano();
        plano.setPlanoID(1);
        plano.setDataPlano("5136|999999999|38991-1|1|36.700|2323|7/02/2020|VN|4|A|0555555555|38991|1\n" +
                "5136|999999999|19949535-1|2|445|211122|8/02/2020|VN|4|A|0555555555|19949535|1");

        PlanoServiceInt planoService = new PlanoService();

        List<InformeSismed> esperado = new ArrayList<InformeSismed>();
        InformeSismed informeSismed = new InformeSismed(1, 1, 5136, "999999999",
                "38991-1", 1, 36.700,
                "2323", new SimpleDateFormat("dd/MM/yyyy").parse("7/02/2020"),
                "VN", "4", "A",
                0555555555, 38991, 1);
        esperado.add(informeSismed);
        InformeSismed informeSismed2 = new InformeSismed(1, 2, 5136, "999999999",
                "19949535-1", 2, Double.valueOf("445"),
                "211122", new SimpleDateFormat("dd/MM/yyyy").parse("8/02/2020"),
                "VN", "4", "A",
                0555555555, 19949535, 1);
        esperado.add(informeSismed2);

        List<InformeSismed> obtenido;

        //act
        obtenido = planoService.cargarPlano(plano);

        //assert
        Assert.assertEquals(esperado, obtenido);
    }
}
