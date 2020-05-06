package co.edu.udea.portalinformes.api.services;

import co.edu.udea.portalinformes.api.model.InformeSismed;
import co.edu.udea.portalinformes.api.model.Plano;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;

@Service
public class PlanoService implements PlanoServiceInt {

    @Override
    public List<InformeSismed> cargarPlano(Plano plano) throws ParseException {
        List<InformeSismed> informe = new ArrayList<InformeSismed>();
        String[] lines = plano.getDataPlano().split("\\s*\\r?\\n\\s*");
        int cont = 1;
        int idRandom = (new Random()).nextInt(10000);
        for (String line : lines) {
            System.out.println(line);
            String[] campos = line.split(Pattern.quote("|"));
            InformeSismed informeSismed = new InformeSismed(idRandom, cont,
                    Integer.parseInt(campos[0]), campos[1], campos[2], Integer.parseInt(campos[3]),
                    Double.valueOf(campos[4]), campos[5], new SimpleDateFormat("dd/MM/yyyy").parse(campos[6]),
                    campos[7], campos[8], campos[9], Integer.parseInt(campos[10]), Integer.parseInt(campos[11]),
                    Integer.parseInt(campos[12]));
            informe.add(informeSismed);
        }
        return informe;
/*
           return Stream.of(plano.getDataPlano().split(Pattern.quote("|")))
                    .map (elem -> new String(elem))
                    .collect(Collectors.toList());

 */

    }

}
