package co.edu.udea.portalinformes.api;

import co.edu.udea.portalinformes.api.controller.PlanoController;
import co.edu.udea.portalinformes.api.model.Plano;
import co.edu.udea.portalinformes.api.services.PlanoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.text.ParseException;

@WebMvcTest(PlanoController.class)
@ActiveProfiles("test")
public class TestPlanoService {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

    @MockBean
    PlanoService PlanoService;

    @Test
    public void DadoImportarPlanoEntoncesDebeRetornarInformeSismed() throws ParseException {
        //arrange
        Plano plano = new Plano();
        plano.setId(1);
        plano.setData_plano("5136|999999999|38991-1|1|36.700|2323|7/02/2020|VN|4|A|0555555555|38991|1\n" +
                "5136|999999999|19949535-1|2|445|211122|8/02/2020|VN|4|A|0555555555|19949535|1");

        /*PlanoServiceInt planoService = new PlanoService();

        List<InformeSismed> esperado = new ArrayList<InformeSismed>();
        InformeSismed informeSismed = new InformeSismed("1", 1, 5136, "999999999",
                "38991-1", 1, 36.700,
                "2323", new SimpleDateFormat("dd/MM/yyyy").parse("7/02/2020"),
                "VN", "4", "A",
                0555555555, 38991, 1);
        esperado.add(informeSismed);
        InformeSismed informeSismed2 = new InformeSismed("1", 2, 5136, "999999999",
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

         */
    }
}
