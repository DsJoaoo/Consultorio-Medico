/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import domain.*;
import dao.*;
import java.sql.SQLException;
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
        Paciente p = new Paciente(nome, telefone, email, cpf, data, sexo);
        genDao.cadastrar(p);
        return 0;
    }

    
    public List listar(Class classe) throws HibernateException {        
        return genDao.listar(classe);        
    }    
     
    public void excluir (Object obj) throws HibernateException {
        genDao.remover(obj);
    }
     
   
}
