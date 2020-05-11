package co.edu.udea.portalinformes.api.services;

import co.edu.udea.portalinformes.api.model.Plano;
import co.edu.udea.portalinformes.api.model.Sismed;
import co.edu.udea.portalinformes.api.repository.PlanoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

@Service
public class PlanoService implements PlanoServiceInt {

    @Autowired
    private PlanoRepository planoRepository;

    public PlanoService(PlanoRepository planoRepository) {
        this.planoRepository = planoRepository;
    }

    @Override
    public Plano addPlano(Plano plano) {
        System.out.println("se recibe para add: \n" + plano.getData_plano());
        return planoRepository.save(plano);
    }

    @Override
    public List<Plano> getPlanos() {
        return planoRepository.findAll();
    }

    @Override
    public Plano getPlano(Integer planoID) {
        Optional<Plano> posiblePlano = planoRepository.findById(planoID);
        if (posiblePlano.isPresent()) {
            return posiblePlano.get();
        } else {
            return null;
        }
    }

    @Override
    public List<Sismed> cargarPlano(Plano plano) throws ParseException {
        System.out.println("se recibe: \n" + plano.getData_plano());
        List<Sismed> informe = new ArrayList<Sismed>();
        String[] lines = plano.getData_plano().split("\\s*\\r?\\n\\s*");
        int cont = 1;
        //int idRandom = (new Random()).nextInt(10000);
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyyhhmmss");
        String idRandom = formatter.format(date);
        for (String line : lines) {
            System.out.println("Linea" + cont + ": " + line);
            String[] campos = line.split(Pattern.quote("|"));
            Sismed sismed = new Sismed(idRandom, cont,
                    Integer.parseInt(campos[0]), campos[1], campos[2], Integer.parseInt(campos[3]),
                    Double.valueOf(campos[4]), campos[5], new SimpleDateFormat("dd/MM/yyyy").parse(campos[6]),
                    campos[7], campos[8], campos[9], Integer.parseInt(campos[10]), Integer.parseInt(campos[11]),
                    Integer.parseInt(campos[12]));
            informe.add(sismed);
            cont = cont + 1;
        }
        return informe;
/*
           return Stream.of(plano.getDataPlano().split(Pattern.quote("|")))
                    .map (elem -> new String(elem))
                    .collect(Collectors.toList());

 */

    }

}
