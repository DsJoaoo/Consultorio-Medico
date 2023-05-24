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
    
    public ControllerDomain() throws ClassNotFoundException, SQLException {
        // TESTE
        ConexaoHibernate.getSessionFactory();
        genDao = new GenericDao();
    }

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
     
   
}
