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
    private DlgCadTipoConsulta janCadServico = null;
    private DlgPesqPaciente janPesqPaciente = null;
    private DlgPesqMedico janPesqMedico = null;
    private DlgPesqFuncionario janPesqFuncionario = null;
    
    
    
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
        janCadServico = (DlgCadTipoConsulta) abrirJanela(janCadPrincipal, janCadServico, DlgCadTipoConsulta.class);
    }
    
    
    
    
    public Paciente janelaPesqPaciente() {
        janPesqPaciente = (DlgPesqPaciente) abrirJanela(janCadPrincipal, janPesqPaciente, DlgPesqPaciente.class);
        return janPesqPaciente.getPaciente();
    }
    
    public Medico janelaPesqMedico() {
        janPesqMedico = (DlgPesqMedico) abrirJanela(janCadPrincipal, janPesqMedico, DlgPesqMedico.class);
        return janPesqMedico.getMedico();
    }
    
    public Funcionario janelaPesqFuncionario() {
        janPesqFuncionario = (DlgPesqFuncionario) abrirJanela(janCadPrincipal, janPesqFuncionario, DlgPesqFuncionario.class);
        return janPesqFuncionario.getFuncionario();
    }
    
    
    
    
    
    //</editor-fold>
    
    
    public void carregarTabela(JTable tabela, Class classe) throws ClassNotFoundException, SQLException {
        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();

        try {
            List<Adpater> lista = gerDominio.listar(classe);
            modelo.setRowCount(0);
            lista.forEach(objeto -> {
                modelo.addRow(objeto.toArray());
            });
            Functions.centralizarColunas(tabela);
        } catch (HibernateException e) {
            JOptionPane.showMessageDialog(janCadPrincipal, "Erro ao tentar listar tabela do banco de dados. " + e.getMessage());
    }
}
    
    public void carregarCombo(JComboBox cmb, Class classe){
        try {
            List<Class> listaObjetos = gerDominio.listar(classe);
            cmb.setModel(new DefaultComboBoxModel( listaObjetos.toArray() )  );
        }catch (HibernateException  ex) {
            JOptionPane.showMessageDialog(janCadPrincipal, "Erro ao carregar informações. " + ex.getMessage() );          
        } 
    }
 

    public ControllerDomain getGerDominio() {
        return gerDominio;
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

    
   
}
