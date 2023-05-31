/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author 2021122760194
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pessoa implements Serializable, Adpater {
    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    protected int idPessoa;
    
    @Column (length = 50, nullable = false)
    private String nomePessoa;
    
    
    @Column (length = 20, nullable = false)
    private String telefone;
    
    
    @Column ( unique = true, length = 50, nullable = false)
    private String email;
     
     
    @Column (updatable = false, unique = true, length = 14) 
    private String cpf;

    public Pessoa() {
    }

    public Pessoa( String nomePessoa, String telefone, String email, String cpf) {
        this.nomePessoa = nomePessoa;
        this.telefone = telefone;
        this.email = email;
        this.cpf = cpf;
    }
    
    

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNomePessoa() {
        return nomePessoa;
    }

    public void setNomePessoa(String nomePessoa) {
        this.nomePessoa = nomePessoa;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    @Override
    public String toString(){
        return nomePessoa;
    }   
}
