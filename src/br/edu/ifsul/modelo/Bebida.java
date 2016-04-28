/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Vinicius
 */
@Entity
@Table(name = "bebida")
public class Bebida extends Produto implements Serializable{
    @NotBlank(message = "O codigo deve ser informado")
    @Length(max = 5, message = "O código não pode ter mais de {max} caracteres")
    @Column(name = "cod_bebida", length = 5, nullable = false) 
    private String cod_bebida;
    @NotBlank(message = "O lote deve ser informado")
    @Length(max = 10, message = "O lote não pode ter mais de {max} caracteres")
    @Column(name = "lote", length = 10, nullable = false)
    private String lote;

    public Bebida() {
    }

    public String getCod_bebida() {
        return cod_bebida;
    }

    public void setCod_bebida(String cod_bebida) {
        this.cod_bebida = cod_bebida;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.cod_bebida);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Bebida other = (Bebida) obj;
        if (!Objects.equals(this.cod_bebida, other.cod_bebida)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Bebida{" + "lote=" + lote + '}';
    }
    
}
