/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;


import java.util.Date;
import java.sql.Time;

/**
 *
 * @author joaop
 */
public class Consulta {
    private int idConsulta;
    private Date data;
    private Time hora;
    private Paciente paciente;
    private Funcionario funcionario;
    private Medico medico;
    private TipoConsulta tipoConsulta;

    public Consulta(int idAgendamento, Date data, Time hora, Paciente paciente, Funcionario funcionario, Medico medico, TipoConsulta tipoConsulta) {
        this.idConsulta = idAgendamento;
        this.data = data;
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
        return data;
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
}
