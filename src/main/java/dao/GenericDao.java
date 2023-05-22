/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;


import domain.Paciente;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author joaop
 */
public class GenericDao {
    
    
     public void cadastrar(Object obj) throws HibernateException{
        Session sessao = null;
        try {
            sessao = ConexaoHibernate.getSessionFactory().openSession();
            sessao.getTransaction().begin();

            sessao.save(obj);
            
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
    
    public void atualizar(Object obj)throws HibernateException{
        Session sessao = null;
        try {
            sessao = ConexaoHibernate.getSessionFactory().openSession();
            sessao.getTransaction().begin();

            sessao.update(obj);
            
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
    
    
    public void remover(Object obj)throws HibernateException{
        Session sessao = null;
        try {
            sessao = ConexaoHibernate.getSessionFactory().openSession();
            sessao.getTransaction().begin();

            sessao.delete(obj);
            
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
    
    public List listar(Class classe) throws HibernateException{
        Session sessao = null;
        List<Class> lista = null;
        try {
            sessao = ConexaoHibernate.getSessionFactory().openSession();
            sessao.getTransaction().begin();

            Criteria consulta = sessao.createCriteria(classe);
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
    
    
}
