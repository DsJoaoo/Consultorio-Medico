/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author joaop
 */
@Entity

@PrimaryKeyJoinColumn (name = "idMedico")
public class Medico extends Pessoa implements Serializable{
    @Column ( unique = true, updatable = false, length = 14) 
    private String crm;
    
    
    @Column (length = 50, nullable = false)
    private String especializacao;
    
    
    @OneToMany (mappedBy = "medico", fetch = FetchType.LAZY)
    private List<Consulta> consulta = new ArrayList();

    public Medico() {
    }

    public Medico(String nomePessoa, String telefone, String email, String cpf, String crm, String especializacao) {
        super(nomePessoa, telefone, email, cpf);
        this.crm = crm;
        this.especializacao = especializacao;
    }



    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getEspecializacao() {
        return especializacao;
    }

    public void setEspecializacao(String especializacao) {
        this.especializacao = especializacao;
    }

    public List<Consulta> getConsulta() {
        return consulta;
    }

    public void setConsulta(List<Consulta> consulta) {
        this.consulta = consulta;
    }
    
    @Override
    public Object[] toArray(){
       return new Object[] {getIdPessoa(), this, getCpf(), getEmail(),getTelefone(), crm, especializacao};
    };
    
}
