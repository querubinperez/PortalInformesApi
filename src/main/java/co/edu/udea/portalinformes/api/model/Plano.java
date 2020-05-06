package co.edu.udea.portalinformes.api.model;

public class Plano {
    private Integer planoID;
    private String dataPlano;

    public String getDataPlano() {
        return dataPlano;
    }

    public void setDataPlano(String dataPlano) {
        this.dataPlano = dataPlano;
    }

    public Integer getPlanoID() {
        return planoID;
    }

    public void setPlanoID(Integer planoID) {
        this.planoID = planoID;
    }
}
