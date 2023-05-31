/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import control.Functions;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author joaop
 */
@Entity
@PrimaryKeyJoinColumn (name = "idFuncionario")
public class Funcionario extends Pessoa implements Serializable{
    
    @Column (nullable = true)
    @Temporal (TemporalType.DATE)
    private Date dataAdmissao;
    
    @Column (length = 30, nullable = false)
    private String senha;
    
    @OneToMany (mappedBy = "funcionario", fetch = FetchType.LAZY)
    private List<Consulta> consulta = new ArrayList();

    public Funcionario() {
    }

    
     public Funcionario( String nomePessoa, String telefone, String email, String cpf, Date dataAdmissao, String senha) {
        super(nomePessoa, telefone, email, cpf);
        this.dataAdmissao = dataAdmissao;
        this.senha = senha;
    }

     
    public Date getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(Date dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Consulta> getConsulta() {
        return consulta;
    }

    public void setConsulta(List<Consulta> consulta) {
        this.consulta = consulta;
    }
    
    @Override
    public Object[] toArray(){
        Object dados[] = {getIdPessoa(), this, getCpf(), Functions.formatarDataParaInterface(dataAdmissao.toString()),getEmail(), senha, getTelefone()};
        return dados;
    };
}
