/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;


import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

import javax.persistence.*;

/**
 *
 * @author joaop
 */
@Entity
public class Consulta implements Serializable, Convertivel {
    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    private int idConsulta;
    
    
    @Column (nullable = true)
    @Temporal (TemporalType.DATE)
    private Date dataConsulta;
    
    
    @Column(name = "hora", columnDefinition = "TIME")
    private Time hora;
    
    
    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn (name = "idPaciente")
    private Paciente paciente;    
    
    
    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn (name = "idFuncionario")
    private Funcionario funcionario;
    
    
    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn (name = "idMedico")
    private Medico medico;
    
    
    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn (name = "idTipoConsulta")
    private TipoConsulta tipoConsulta;

    public Consulta() {
    }

    public Consulta( Date data, Time hora, Paciente paciente, Funcionario funcionario, Medico medico, TipoConsulta tipoConsulta) {
        this.dataConsulta = data;
        this.hora = hora;
        this.paciente = paciente;
        this.funcionario = funcionario;
        this.medico = medico;
        this.tipoConsulta = tipoConsulta;
    }
    
    public Double getValor(){
        return tipoConsulta.getValor();
    }
    
    public String getTipoDeConsulta(){
        return tipoConsulta.getDescricao();
    }

    public String getNomeMedico() {
        return medico.getNomePessoa();
    }
    
    public String getNomeFuncionario() {
        return funcionario.getNomePessoa();
    }

    public int getIdConsulta() {
        return idConsulta;
    }
    
    public Date getData() {
        return dataConsulta;
    }

    public Time getHora() {
        return hora;
    }

    public String getNomePaciente() {
        return paciente.getNomePessoa();
    }

    public TipoConsulta getObjetoConsulta() {
        return tipoConsulta;
    }
    
    public Paciente getObjetoPaciente() {
        return paciente;
    }
    
    public Funcionario getObjetoFuncionario() {
        return funcionario;
    }
    
    public Medico getObjetoMedico() {
        return medico;
    }

    public void setTipoConsulta(TipoConsulta tipoConsulta) {
        this.tipoConsulta = tipoConsulta;
    }
    
    @Override
    public Object[] toArray(){
       return new Object[] {idConsulta, dataConsulta, hora, paciente, funcionario, medico, tipoConsulta, tipoConsulta.getValor() };
    };
    
}
