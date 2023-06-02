/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;


import domain.Adapter;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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
    
    
        public boolean validar(String pesq, int tipo, Class classe) throws HibernateException {
        List<Adapter> lista = null;
        Session sessao = null;
        try {
            sessao = ConexaoHibernate.getSessionFactory().openSession();
            sessao.beginTransaction();

            // Construtor da CONSULTA
            CriteriaBuilder builder = sessao.getCriteriaBuilder();
            CriteriaQuery consulta = builder.createQuery( classe );
            
            // FROM
            Root tabela = consulta.from(classe);
            
            // RESTRIÇÕES
            Predicate restricoes = null;
            
            switch (tipo) {
                case 0: restricoes = builder.equal(tabela.get("cpf"), pesq);
                        break; 
                case 1: restricoes = builder.like(tabela.get("email"), pesq + "%"); 
                        break;
            }
                        
            consulta.where(restricoes);
            lista = sessao.createQuery(consulta).getResultList();            
            sessao.getTransaction().commit();
            sessao.close();
        } catch (HibernateException ex) {
            if (sessao != null ) {
                sessao.getTransaction().rollback();          
                sessao.close();
            }
            throw new HibernateException(ex);
        }
        return lista.isEmpty();
    }    
}
