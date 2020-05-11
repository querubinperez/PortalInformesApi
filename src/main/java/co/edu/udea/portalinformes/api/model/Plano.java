package co.edu.udea.portalinformes.api.model;

import javax.persistence.*;

@Entity
@Table(name = "planos")
public class Plano {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "dataPlano", columnDefinition = "TEXT")
    private String data_plano;

    public Plano() {
    }

    public Plano(Integer id, String data_plano) {
        this.id = id;
        this.data_plano = data_plano;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getData_plano() {
        return data_plano;
    }

    public void setData_plano(String data_plano) {
        this.data_plano = data_plano;
    }
}
