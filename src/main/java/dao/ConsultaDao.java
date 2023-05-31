package dao;

import control.Functions;
import domain.Consulta;
import domain.Funcionario;
import domain.Medico;
import domain.Paciente;
import domain.TipoConsulta;
import java.util.Date;

import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class ConsultaDao extends GenericDao {

    public ConsultaDao() {
    }

private List<Consulta> pesquisar(String pesq, int tipo) throws HibernateException {
        List<Consulta> lista = null;
        Session sessao = null;
        try {
            sessao = ConexaoHibernate.getSessionFactory().openSession();
            sessao.beginTransaction();

            CriteriaBuilder builder = sessao.getCriteriaBuilder();
            CriteriaQuery<Consulta> consulta = builder.createQuery(Consulta.class);
            Root<Consulta> tabela = consulta.from(Consulta.class);
            Predicate restricoes = null;

            switch (tipo) {
            case 0:
                restricoes = builder.equal(tabela.get("idConsulta"), Integer.valueOf(pesq));
                break;
            case 1:
                Join<Consulta, TipoConsulta> tipoConsultaJoin = tabela.join("tipoConsulta");
                restricoes = builder.equal(tipoConsultaJoin.get("descricao"), pesq);
                break;
            case 2:
                Join<Consulta, Medico> medicoJoin = tabela.join("medico");
                restricoes = builder.equal(medicoJoin.get("nomePessoa"), pesq);
                break;
            case 3:
                Join<Consulta, Paciente> pacienteJoin = tabela.join("paciente");
                restricoes = builder.equal(pacienteJoin.get("nomePessoa"), pesq);
                break;
            case 4:
                Join<Consulta, Funcionario> funcionarioJoin = tabela.join("funcionario");
                restricoes = builder.equal(funcionarioJoin.get("nomePessoa"), pesq);
                break;
            case 5:
                restricoes = builder.equal(tabela.get("dataConsulta"), Functions.formatarDataParaSQL(pesq));
                break;
        }

        consulta.where(restricoes);
        lista = sessao.createQuery(consulta).getResultList();

        sessao.getTransaction().commit();
        sessao.close();
    } catch (HibernateException ex) {
        if (sessao != null) {
            sessao.getTransaction().rollback();
            sessao.close();
        }
        throw new HibernateException(ex);
    }
    return lista;
    }

    public List<Consulta> pesquisarID(String pesq) {
        return pesquisar(pesq, 0);
    }

    public List<Consulta> pesquisarTIPO(String pesq) {
        return pesquisar(pesq, 1);
    }

    public List<Consulta> pesquisarMedico(String pesq) {
        return pesquisar(pesq, 2);
    }

    public List<Consulta> pesquisarPaciente(String pesq) {
        return pesquisar(pesq, 3);
    }

    public List<Consulta> pesquisarFuncionario(String pesq) {
        return pesquisar(pesq, 4);
    }

    public List<Consulta> pesquisarData(String pesq) {
        return pesquisar(pesq, 5);
    }
}
