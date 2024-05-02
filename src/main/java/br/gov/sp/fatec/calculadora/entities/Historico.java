package br.gov.sp.fatec.calculadora.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity @Table(name = "HISTORICO")
public class Historico implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "FAVORAVEIS")
    private double favoraveis;
    @Column(name = "POSSIVEIS")
    private double possiveis;
    @Column(name = "RESULTADO")
    private String resultado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getFavoraveis() {
        return favoraveis;
    }

    public void setFavoraveis(double favoraveis) {
        this.favoraveis = favoraveis;
    }

    public double getPossiveis() {
        return possiveis;
    }

    public void setPossiveis(double possiveis) {
        this.possiveis = possiveis;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Historico other = (Historico) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}