package view;


import control.ControllerView;
import domain.Funcionario;
import domain.Medico;
import domain.Paciente;
import java.sql.SQLException;
import javax.swing.JOptionPane;



/**
 *
 * @author jean
 */
public class DlgPesqMedico extends javax.swing.JDialog {

    private ControllerView gerIG;
    private Medico medicoSelecionado;

    public DlgPesqMedico(java.awt.Frame parent, boolean modal, ControllerView gerIG) {
        super(parent, modal);
        initComponents();
        this.gerIG = gerIG;
        medicoSelecionado = null;
        
              
    }

    public Medico getMedico() {
        return medicoSelecionado;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        mnuPedidos = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable();
        txtPesq = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JButton();
        btnSelecionar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        cmbTipo = new javax.swing.JComboBox();
        btnExcluir = new javax.swing.JButton();
        btnRelatorios = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbMedicos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        mnuPedidos.setText("Ver pedidos");
        jPopupMenu1.add(mnuPedidos);

        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Bairro", "Cidade", "Dt. Nasc.", "Tel. Cel.", "Foto"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblClientes.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setViewportView(tblClientes);

        setTitle("Pesquisar Clientes");
        setMinimumSize(new java.awt.Dimension(612, 470));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(txtPesq, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 320, 40));

        btnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/intergraf/imagens/search.png"))); // NOI18N
        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });
        getContentPane().add(btnPesquisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 60, 140, 40));

        btnSelecionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/intergraf/imagens/accept.png"))); // NOI18N
        btnSelecionar.setText("Selecionar");
        btnSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecionarActionPerformed(evt);
            }
        });
        getContentPane().add(btnSelecionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 160, 50));

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 360, 110, 50));

        cmbTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nome", "Bairro", "Mês", "CPF" }));
        getContentPane().add(cmbTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 90, 40));

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/intergraf/imagens/remove.png"))); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        getContentPane().add(btnExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 360, 110, 50));

        btnRelatorios.setText("Relatório");
        btnRelatorios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRelatoriosActionPerformed(evt);
            }
        });
        getContentPane().add(btnRelatorios, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 360, 120, 50));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), "Médicos", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 18))); // NOI18N
        jPanel1.setLayout(new java.awt.BorderLayout());

        tbMedicos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOME", "CPF", "E-MAIL", "TELEFONE", "CRM", "ESPECIALIZACAO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tbMedicos);

        jPanel1.add(jScrollPane3, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 590, 220));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 35, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaces/imgs/TelaPaciente.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        /*
        try {
            List<Paciente> lista = gerIG.getGerDominio().pesquisarCliente(txtPesq.getText(), cmbTipo.getSelectedIndex() );
            
            // APAGA as linhas da tabela
            ( (DefaultTableModel) tblClientes.getModel() ).setNumRows(0);
            
            for (Cliente cli : lista ) {
                // ADICIONAR LINHA NA TABELA        
                ( (DefaultTableModel) tblClientes.getModel() ).addRow( cli.toArray() );                
            }
            
            
        } catch (HibernateException | ParseException  ex) {
            JOptionPane.showMessageDialog(this, ex, "ERRO ao PESQUISAR Cliente", JOptionPane.ERROR_MESSAGE  );
        } 
        
        */
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        /*
        int linha = tblClientes.getSelectedRow();
        if ( linha >= 0 ) {
            
            try {
                Cliente cli = (Cliente) tblClientes.getValueAt(linha, 0);
                if ( JOptionPane.showConfirmDialog(this, "Deseja realmente excluir esse cliente?", "Título", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION ) {
                    gerIG.getGerDominio().excluir(cli);
                    ( (DefaultTableModel) tblClientes.getModel() ).removeRow(linha);
                    JOptionPane.showMessageDialog(this, "Cliente " + cli.getNome() + " excluído com sucesso.", "ERRO ao PESQUISAR Cliente", JOptionPane.ERROR_MESSAGE  );
                }
                
            } catch (HibernateException ex) {
                JOptionPane.showMessageDialog(this, ex, "ERRO ao PESQUISAR Cliente", JOptionPane.ERROR_MESSAGE  );
            }             
        }        
        else {
            JOptionPane.showMessageDialog(this,"Selecione uma linha.", "Pesquisar cliente", JOptionPane.ERROR_MESSAGE  );
        }
    */
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        medicoSelecionado = null;
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecionarActionPerformed
        
        int linha = tbMedicos.getSelectedRow();
        if ( linha >= 0 ) {
            medicoSelecionado = (Medico) tbMedicos.getValueAt(linha, 1);
        }
        else {
            JOptionPane.showMessageDialog(this,"Selecione uma linha.", "Pesquisar Médico", JOptionPane.ERROR_MESSAGE  );
        }
        
        this.setVisible(false);
    }//GEN-LAST:event_btnSelecionarActionPerformed

    private void btnRelatoriosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRelatoriosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRelatoriosActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        try {
            gerIG.carregarTabela(tbMedicos, Medico.class);
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar médicos " + ex.getMessage() );
        }
    }//GEN-LAST:event_formComponentShown

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnRelatorios;
    private javax.swing.JButton btnSelecionar;
    private javax.swing.JComboBox cmbTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JMenuItem mnuPedidos;
    private javax.swing.JTable tbMedicos;
    private javax.swing.JTable tblClientes;
    private javax.swing.JTextField txtPesq;
    // End of variables declaration//GEN-END:variables


}