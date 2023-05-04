/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.*;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author joaop
 */
@Entity
public class Funcionario implements Serializable{
    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    private int idPessoa;
    
    @Column (name="nomeFuncionario", length = 250, nullable = false)
    private String nomePessoa;
    
    @Column (length = 11, nullable = false)
    private String telefone;
    
    @Column ( unique = true, length = 50, nullable = false)
    private String email;
     
    @Column ( unique = true, updatable = false, length = 14) 
    private String cpf;
    
    @Column (nullable = true)
    @Temporal (TemporalType.DATE)
    private Date dataAdmissao;
    
    @Column (length = 30, nullable = false)
    private String Senha;

    public Funcionario(int idPessoa, String nomePessoa, String telefone, String email, String cpf, Date dataAdmissao, String Senha) {
        this.idPessoa = idPessoa;
        this.nomePessoa = nomePessoa;
        this.telefone = telefone;
        this.email = email;
        this.cpf = cpf;
        this.dataAdmissao = dataAdmissao;
        this.Senha = Senha;
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

    


    public Date getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(Date dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String Senha) {
        this.Senha = Senha;
    } 

}
