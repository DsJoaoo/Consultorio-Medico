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
public class Medico implements Serializable{
    
    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    private int idMedico;
    
    @Column (name="nomeMedico", length = 50, nullable = false)
    private String nomePessoa;
    
    
    @Column (length = 11, nullable = false)
    private String telefone;
    
    
    @Column ( unique = true, length = 50, nullable = false)
    private String email;
    
    
    @Column ( unique = true, updatable = false, length = 14) 
    private String cpf;
    
    
    @Column ( unique = true, updatable = false, length = 14) 
    private String crm;
    
    
    @Column (length = 50, nullable = false)
    private String especializacao;
    
    
    @OneToMany (mappedBy = "medico", fetch = FetchType.LAZY)
    private List<Consulta> consulta = new ArrayList();

    public Medico() {
    }

    public Medico(String nomePessoa, String telefone, String email, String cpf, String crm, String especializacao) {
        this.nomePessoa = nomePessoa;
        this.telefone = telefone;
        this.email = email;
        this.cpf = cpf;
        this.crm = crm;
        this.especializacao = especializacao;
    }

    public int getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(int idMedico) {
        this.idMedico = idMedico;
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

    
}
