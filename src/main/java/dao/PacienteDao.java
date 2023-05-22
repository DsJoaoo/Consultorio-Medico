/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import domain.Paciente;
import java.io.IOException;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author joaop
 */

public class PacienteDao{
    
    public void cadastrar(Paciente paciente) throws HibernateException{
        Session sessao = null;
        try {
            sessao = ConexaoHibernate.getSessionFactory().openSession();
            sessao.getTransaction().begin();

            sessao.save(paciente);
            
            sessao.getTransaction().commit();
            sessao.close();
        } catch (HibernateException e) {
            if(sessao != null){
                sessao.getTransaction().rollback();
                sessao.close();
            }
            throw new HibernateException(e);
        }
    }
    
    public void atualizar(Paciente paciente)throws HibernateException{
        Session sessao = null;
        try {
            sessao = ConexaoHibernate.getSessionFactory().openSession();
            sessao.getTransaction().begin();

            sessao.update(paciente);
            
            sessao.getTransaction().commit();
            sessao.close();
        } catch (HibernateException e) {
            if(sessao != null){
                sessao.getTransaction().rollback();
                sessao.close();
            }
            throw new HibernateException(e);
        }
        
    }
    
    
    public void remover(Paciente paciente)throws HibernateException{
        Session sessao = null;
        try {
            sessao = ConexaoHibernate.getSessionFactory().openSession();
            sessao.getTransaction().begin();

            sessao.delete(paciente);
            
            sessao.getTransaction().commit();
            sessao.close();
        } catch (HibernateException e) {
            if(sessao != null){
                sessao.getTransaction().rollback();
                sessao.close();
            }
            throw new HibernateException(e);
        }
    }
    
    public List<Paciente> listar() throws HibernateException{
        Session sessao = null;
        List<Paciente> lista = null;
        try {
            sessao = ConexaoHibernate.getSessionFactory().openSession();
            sessao.getTransaction().begin();

            Criteria consulta = sessao.createCriteria(Paciente.class);
            lista = consulta.list();
            
            sessao.getTransaction().commit();
            sessao.close();
        } catch (HibernateException e) {
            if(sessao != null){
                sessao.getTransaction().rollback();
                sessao.close();
            }
            throw new HibernateException(e);
        }
       
        return lista; 
    }
    
    public Paciente buscarPacientePorId(int idPaciente) {
        
        return null;
        
    }   
}
