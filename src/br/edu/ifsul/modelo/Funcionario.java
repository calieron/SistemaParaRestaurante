/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
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
@Table(name = "funcionario")
public class Funcionario extends Pessoa implements Serializable{
    @NotBlank(message = "O apelido deve ser informado")
    @Length(max = 50, message = "O apelido não deve ter mais que {max} caracteres")
    @Column(name = "apelido", length = 50, nullable = false)
    private String apelido;
    @NotBlank(message = "A senha deve ser informada")
    @Length(min= 6,max = 15, message ="A senha deve ter {max} caracteres")
    @Column(name = "senha", nullable = false)
    private String senha;
    @NotBlank(message = "O cargo deve ser informado")
    @Length(max = 50, message = "O cargo não deve ter mais que {max} caracteres")
    @Column(name = "cargo", length = 50, nullable = false)
    private String cargo;

    public Funcionario() {
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
}
