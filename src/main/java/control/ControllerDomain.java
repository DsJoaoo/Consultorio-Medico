/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import domain.TipoConsulta;
import dao.*;
import domain.*;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author joaop
 */
public class ControllerDomain {
    private final MedicoDao medicoDao;
    private final PacienteDao pacienteDao;
    private final TipoConsultaDao tipoDao;    
    
    public ControllerDomain() throws ClassNotFoundException, SQLException {
        // TESTE
        ConexaoHibernate.getSessionFactory();
        pacienteDao = new PacienteDao();
        medicoDao = new MedicoDao();
        tipoDao = new TipoConsultaDao();
    }

    public List<Paciente> listarPacientes() throws ClassNotFoundException, SQLException {
        return pacienteDao.listar();
    }
    
    public List<Medico> listarMedicos() throws ClassNotFoundException, SQLException {
        return medicoDao.listar();
    }
   
    
    public List<TipoConsulta> listarTiposDisponiveis() throws ClassNotFoundException, SQLException {
        return tipoDao.listar();
    }
    
    public Paciente buscarPacientePorId(int id){
        Paciente buscado = pacienteDao.buscarPacientePorId(id);
        return buscado;
    }

    
    public Medico buscarMedicoPorId(int id){
        Medico buscado = medicoDao.buscarMedicoPorId(id);
        return buscado;
    }
    
    public TipoConsulta buscarConsultaPorId(int id){
        TipoConsulta buscado = tipoDao.buscarTipoConsultaPorId(id);
        return buscado;
    }
}
