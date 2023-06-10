/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import domain.Medico;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author joaop
 */
public class MedicoDao extends GenericDao{

     private List<Medico> pesquisar(String pesq, int tipo) throws HibernateException {
        List lista = null;
        Session sessao = null;
        try {
            sessao = ConexaoHibernate.getSessionFactory().openSession();
            sessao.beginTransaction();

            // Construtor da CONSULTA
            CriteriaBuilder builder = sessao.getCriteriaBuilder();
            CriteriaQuery consulta = builder.createQuery( Medico.class );
            
            // FROM
            Root tabela = consulta.from(Medico.class);
            
            // RESTRIÇÕES
            Predicate restricoes;
            
            switch (tipo) {
                case 0: restricoes = builder.like(tabela.get("nomePessoa"), pesq + "%"); 
                        break;
                case 1: restricoes = builder.equal(tabela.get("cpf"), pesq);
                        break; 
                case 2: restricoes = builder.like(tabela.get("email"), pesq + "%"); 
                        break;
                case 3: restricoes = builder.equal(tabela.get("telefone"), pesq);
                        break;
                case 4: restricoes = builder.equal(tabela.get("crm"), pesq);
                        break;  
                case 5: restricoes = builder.equal(tabela.get("idPessoa"), Integer.valueOf(pesq) ); 
                        break;  
                default:
                    restricoes = null;
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
        return lista;
    }   
    
    public List<Medico> pesquisarNome(String pesq) {
        return pesquisar(pesq,0);
    }

    public List<Medico> pesquisarCPF(String pesq) {
        return pesquisar(pesq,1);
    }

    public List<Medico> pesquisarEMAIL(String pesq) {
        return pesquisar(pesq,2);
    }

    public List<Medico> pesquisarTEL(String pesq) {
        return pesquisar(pesq,3);
    }

    public List<Medico> pesquisarCRM(String pesq) {
        return pesquisar(pesq,4);
    }

    public List<Medico> pesquisarID(String pesq) {
        return pesquisar(pesq,5);
    }

    
}
