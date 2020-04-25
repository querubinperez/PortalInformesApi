package co.edu.udea.portalinformes.api;

import co.edu.udea.portalinformes.api.model.Plano;
import co.edu.udea.portalinformes.api.services.PlanoService;
import co.edu.udea.portalinformes.api.services.PlanoServiceInt;
import org.junit.Assert;
import org.junit.Test;

public class TestPlanoService {

    @Test
    public void DadoImportarPlanoEntoncesDebeRetornarOK() {
        //arrange
        PlanoServiceInt planoService = new PlanoService();
        String esperado = "OK";
        String obtenido;
        Plano plano = new Plano();

        //act
        obtenido = planoService.cargarPlano(plano);

        //assert
        Assert.assertEquals(esperado, obtenido);
    }
}
