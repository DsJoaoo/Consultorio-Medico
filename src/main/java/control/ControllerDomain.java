/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import domain.*;
import dao.*;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Date;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author joaop
 */
public class ControllerDomain {
    private final GenericDao genDao;
    private final PacienteDao pacDao;
    private final MedicoDao medDao;
    private final FuncionarioDao funDao;
    private final ConsultaDao conDao;
    private final TipoConsultaDao tipoDao;
    
    
    public ControllerDomain() throws ClassNotFoundException, SQLException {
        // TESTE
        ConexaoHibernate.getSessionFactory();
        genDao = new GenericDao();
        pacDao = new PacienteDao();
        medDao = new MedicoDao();
        funDao = new FuncionarioDao();
        conDao = new ConsultaDao();
        tipoDao = new TipoConsultaDao();
    }
    
    //<editor-fold defaultstate="collapsed" desc="CODE: Inserções e exclusão ">
    

    public int inserirPaciente(String nome, String cpf, String email, Date data, String telefone, String sexo){
        Pessoa p = new Paciente(nome, telefone, email, cpf, data, sexo);
        genDao.cadastrar(p);
        return p.getIdPessoa();
    }
    
    public int inserirFucionario(String nome, String cpf, Date dt, String email, String senha, String telefone) {
        Pessoa p = new Funcionario(nome, telefone,email, cpf, dt, senha);
        genDao.cadastrar(p);
        return p.getIdPessoa();
    }

    public int inserirMedico(String nome, String telefone, String email, String cpf, String crm, String especializacao) {
        Pessoa p = new Medico(nome, telefone,email, cpf, crm, especializacao);
        genDao.cadastrar(p);
        return p.getIdPessoa();
    }

    public int inserirConsulta(Date dt, Time hr, Funcionario fun, Paciente pac, Medico med, TipoConsulta tipo) {
        Consulta p = new Consulta(dt, hr, pac,fun, med, tipo);
        genDao.cadastrar(p);
        return p.getIdConsulta();
    }

    public int inserirTipo(String nome, Double preco, boolean selecionado) {
        TipoConsulta p = new TipoConsulta(nome, preco, selecionado);
        genDao.cadastrar(p);
        return p.getIdTipoConsulta();
    }
    
    
    public List listar(Class classe) throws HibernateException {        
        return genDao.listar(classe);        
    }    
     
    public void excluir (Object obj) throws HibernateException {
        genDao.remover(obj);
    }
    
        //</editor-fold>

    public List<TipoConsulta> pesquisarTipoConsulta(String pesq, int tipo) {
        List<TipoConsulta> lista = null;
        switch (tipo) {
            case 0: lista = tipoDao.pesquisarID(pesq); break;

            case 1: lista = tipoDao.pesquisarNome(pesq); break;

            case 2: lista = tipoDao.pesquisarPlano(pesq); break;
        }
        return lista;
    }

    public List<Paciente> pesquisarPaciente(String pesq, int tipo) {
        List<Paciente> lista = null;
        switch (tipo) {
            case 0: lista = pacDao.pesquisarNome(pesq); break;

            case 1: lista = pacDao.pesquisarData(pesq); break;

            case 2: lista = pacDao.pesquisarID(pesq); break;
            
            case 3: lista = pacDao.pesquisarCPF(pesq); break;
        }
        return lista;
    }

    public List<Medico> pesquisarMedico(String pesq, int tipo) {
        List<Medico> lista = null;
        switch (tipo) {
            case 0: lista = medDao.pesquisarNome(pesq); break;

            case 1: lista = medDao.pesquisarCPF(pesq); break;

            case 2: lista = medDao.pesquisarEMAIL(pesq); break;
            
            case 3: lista = medDao.pesquisarTEL(pesq); break;
            
            case 5: lista = medDao.pesquisarCRM(pesq); break;
            
            case 6: lista = medDao.pesquisarID(pesq); break;
        }
        return lista;
    }

    public List<Funcionario> pesquisarFuncionario(String pesq, int tipo) {
        List<Funcionario> lista = null;
        switch (tipo) {
            case 0: lista = funDao.pesquisarNome(pesq); break;

            case 1: lista = funDao.pesquisarCPF(pesq); break;

            case 2: lista = funDao.pesquisarData(pesq); break;
            
            case 3: lista = funDao.pesquisarEmail(pesq); break;
            
            case 4: lista = funDao.pesquisarID(pesq); break;
        }
        return lista;
    }
}
