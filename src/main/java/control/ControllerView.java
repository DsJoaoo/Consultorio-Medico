package control;

import com.formdev.flatlaf.FlatLightLaf;
import domain.*;
import view.*;
import java.awt.Frame;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import org.hibernate.HibernateException;

/**
 *
 * @author 1547816
 */
public class ControllerView {
    
    // JANELAS
    private FrmMenu janCadPrincipal = null;
    private DlgCadPaciente janCadPaciente = null;
    private DlgListaConsulta janListaConsulta = null;
    private DlgCadMedico janCadMedico = null;
    private DlgCadFuncionario janCadFuncionario = null;
    private DlgCadConsulta janCadConsulta = null;
    private DlgLogin janCadLogin = null;
    private DlgTipoConsulta janCadServico = null;
    
    
    //GERENCIADORES de DOMINIO
    ControllerDomain gerDominio;

    public ControllerView() {        
        try {
            gerDominio = new ControllerDomain();
        }catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(janCadPrincipal, "Erro de conexão com o banco. " + ex.getMessage() );
                System.exit(-1);
        } 
    }
 
    //<editor-fold defaultstate="collapsed" desc="CODE: Abertura de interfaces DLG e FRM ">
    
   // ABRIR JDIALOG
    private JDialog abrirJanela(java.awt.Frame parent, JDialog dlg, Class classe) {
        if (dlg == null){     
            try {
                dlg = (JDialog) classe.getConstructor(Frame.class, boolean.class, ControllerView.class ).newInstance(parent,true,this);
            } catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                JOptionPane.showMessageDialog(parent, "Erro ao abrir a janela " + classe.getName() );
            } 
        }
        dlg.setLocationRelativeTo(null);        
        dlg.setVisible(true); 
        return dlg;
    }
    
    
    
    public void janelaPrincipal() {
        janCadPrincipal = new FrmMenu(this);
        janCadPrincipal.setVisible(true);
    }
    
    public void janelaLogin() {
        janCadLogin = (DlgLogin) abrirJanela(null, janCadLogin, DlgLogin.class);
    }
    
    public void janelaCadPaciente() {
        janCadPaciente = (DlgCadPaciente) abrirJanela(janCadPrincipal, janCadPaciente, DlgCadPaciente.class);

    }
    
    public void janelaCadConsulta() {
        janCadConsulta = (DlgCadConsulta) abrirJanela(janCadPrincipal, janCadConsulta, DlgCadConsulta.class);
    }
    
    public void janelaCadMedico() {
        janCadMedico = (DlgCadMedico) abrirJanela(janCadPrincipal, janCadMedico, DlgCadMedico.class);
    }
    
    public void janelaListaConsulta() {
        janListaConsulta = (DlgListaConsulta) abrirJanela(janCadPrincipal, janListaConsulta, DlgListaConsulta.class);
    }
    
    public void janelaCadFuncionario() {
        janCadFuncionario = (DlgCadFuncionario) abrirJanela(janCadPrincipal, janCadFuncionario, DlgCadFuncionario.class);
    }
    
    public void janelaCadServico() {
        janCadServico = (DlgTipoConsulta) abrirJanela(janCadPrincipal, janCadServico, DlgTipoConsulta.class);
    }
    
    //</editor-fold>
    
    public void carregarTabelaPacientes(JTable tbPacientes) throws ClassNotFoundException, SQLException{
        List<Paciente> lista = gerDominio.listar(Paciente.class);
        DefaultTableModel tabela = (DefaultTableModel) tbPacientes.getModel();
         
        tabela.setRowCount(0);
            for (Paciente p : lista) {
                Object dados[] = {p.getIdPessoa(), p, p.getCpf(), p.getEmail(), p.getDataNascimento(), p.getSexo(), p.getTelefone()};
                tabela.addRow(dados);
            }  
    }
        
    public void carregarTabelaFuncionarios(JTable tbFuncionarios) throws ClassNotFoundException, SQLException{
        List<Funcionario> lista = gerDominio.listar(Funcionario.class);
        DefaultTableModel tabela = (DefaultTableModel) tbFuncionarios.getModel();
         
        tabela.setRowCount(0);
            for (Funcionario p : lista) {
                Object dados[] = {p.getIdFuncionario(), p, p.getCpf(), p.getDataAdmissao(), p.getEmail(), p.getSenha(),p.getTelefone()};
                tabela.addRow(dados);
            }  
    }
    
     public void carregarTabelaMedicos(JTable tbMedicos) throws ClassNotFoundException, SQLException {
        List<Medico> lista = gerDominio.listar(Medico.class);
        DefaultTableModel tabela = (DefaultTableModel) tbMedicos.getModel();
         
        tabela.setRowCount(0);
            for (Medico p : lista) {
                Object dados[] = {p.getIdMedico(), p, p.getCpf(), p.getEmail(),p.getTelefone(), p.getCrm(), p.getEspecializacao()};
                tabela.addRow(dados);
            }  
    }
     
     public void carregarTabelaConsultas(JTable tbConsultas) throws ClassNotFoundException, SQLException{
        List<Consulta> lista = gerDominio.listar(Consulta.class);
        DefaultTableModel tabela = (DefaultTableModel) tbConsultas.getModel();
         
        tabela.setRowCount(0);
            for (Consulta p : lista) {
                Object dados[] = {p.getIdConsulta(), p.getData(), p.getHora(),p.getObjetoPaciente().getNomePessoa(), p.getObjetoFuncionario().getNomePessoa(), p.getObjetoMedico().getNomePessoa(), p.getObjetoConsulta().getDescricao(), p.getObjetoConsulta().getValor() };
                tabela.addRow(dados);
            }  
    }
     
     
     
     
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the FlatLighLaf and feel */
        
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        //Setando um tema de um repositório externo
        try {
            UIManager.setLookAndFeel( new FlatLightLaf() );
        } catch( UnsupportedLookAndFeelException ex ) {
            System.err.println( "Falha ao iniciar tema FlatLightLaf" );
        }catch (Exception ex) {
            System.err.println( "Falha ao definir tema" );
        } 
        //</editor-fold>
        
        // TRADUÇÃO
        javax.swing.UIManager.put("OptionPane.yesButtonText", "Sim"); 
        javax.swing.UIManager.put("OptionPane.noButtonText", "Não");
        

        ControllerView gerIG = new ControllerView();
        gerIG.janelaLogin();
    }  

    public void carregarCombosConsulta(JComboBox cmbPaciente, JComboBox cmbMedico, JComboBox cmbTipoConsulta, Class paciente, Class medico, Class tipoConsulta) {
        try {
            List<Paciente> listaPacientes = gerDominio.listar(paciente);
            List<Medico> listaMedicos = gerDominio.listar(medico);
            List<TipoConsulta> listaConsultas = gerDominio.listar(tipoConsulta);
            
            cmbPaciente.setModel( new DefaultComboBoxModel( listaPacientes.toArray() )  );
            cmbMedico.setModel( new DefaultComboBoxModel( listaMedicos.toArray() )  );
            cmbTipoConsulta.setModel( new DefaultComboBoxModel( listaConsultas.toArray() )  );
                                   
        } catch (HibernateException  ex) {
            JOptionPane.showMessageDialog(janCadPrincipal, "Erro ao carregar cidades. " + ex.getMessage() );          
        } 
    }

   
}
