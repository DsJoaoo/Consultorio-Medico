/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
*/
package view;

import control.UtilGeral;
import java.awt.Color;
import javax.swing.JOptionPane;

import control.ControllerView;
import control.UtilCriptografia;
import domain.Funcionario;
import java.awt.HeadlessException;
import java.text.ParseException;
import java.util.Date;
import javax.swing.UIManager;


public class DlgCadCadastro extends javax.swing.JDialog {
    private ControllerView gerIG;
    public DlgCadCadastro(java.awt.Frame parent, boolean modal,ControllerView controller) {
        initComponents();
        gerIG = controller;
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btEntrar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jpDados = new javax.swing.JPanel();
        jpInfo = new javax.swing.JPanel();
        jpNome = new javax.swing.JPanel();
        lbNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jpEmail = new javax.swing.JPanel();
        lbEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lbCPF = new javax.swing.JLabel();
        txtCPF = new javax.swing.JFormattedTextField();
        lbTelefone = new javax.swing.JLabel();
        txtTelefone = new javax.swing.JFormattedTextField();
        jpCapacidade = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        txtDataAdmissao = new javax.swing.JFormattedTextField();
        txtPSW = new javax.swing.JPasswordField();
        txtConfirmarPSW = new javax.swing.JPasswordField();
        jPanel3 = new javax.swing.JPanel();
        lbDataAdmissao = new javax.swing.JLabel();
        lbSenha = new javax.swing.JLabel();
        lbConfirmarSenha = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Login");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btEntrar.setBackground(new java.awt.Color(0, 153, 51));
        btEntrar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btEntrar.setText("Cadastrar-se");
        btEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEntrarActionPerformed(evt);
            }
        });
        jPanel1.add(btEntrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 270, 140, 40));

        btCancelar.setBackground(new java.awt.Color(102, 102, 102));
        btCancelar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 270, 110, 40));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaces/imgs/icons/logo (2).png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 0, 110, 60));

        jpDados.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 18))); // NOI18N
        jpDados.setPreferredSize(new java.awt.Dimension(570, 130));
        jpDados.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpNome.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbNome.setBackground(new java.awt.Color(255, 255, 255));
        lbNome.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbNome.setText("Nome");
        jpNome.add(lbNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, 32));
        jpNome.add(txtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(62, 0, 120, 30));

        jpEmail.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbEmail.setBackground(new java.awt.Color(255, 255, 255));
        lbEmail.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbEmail.setText("E-mail");
        jpEmail.add(lbEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, 30));
        jpEmail.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 120, 30));

        lbCPF.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbCPF.setText("CPF");

        try {
            txtCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        lbTelefone.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbTelefone.setText("Telefone");

        try {
            txtTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout jpInfoLayout = new javax.swing.GroupLayout(jpInfo);
        jpInfo.setLayout(jpInfoLayout);
        jpInfoLayout.setHorizontalGroup(
            jpInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jpNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jpEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jpInfoLayout.createSequentialGroup()
                        .addGroup(jpInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jpInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTelefone)
                            .addComponent(txtCPF))))
                .addContainerGap())
        );
        jpInfoLayout.setVerticalGroup(
            jpInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpNome, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbTelefone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(jpInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jpDados.add(jpInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 190, 170));

        jpCapacidade.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setLayout(new java.awt.GridLayout(3, 1, 0, 20));

        try {
            txtDataAdmissao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel4.add(txtDataAdmissao);
        jPanel4.add(txtPSW);
        jPanel4.add(txtConfirmarPSW);

        jpCapacidade.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 100, 130));

        jPanel3.setLayout(new java.awt.GridLayout(3, 1, 0, 10));

        lbDataAdmissao.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbDataAdmissao.setText("Data de Admissao");
        jPanel3.add(lbDataAdmissao);

        lbSenha.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbSenha.setText("Senha");
        jPanel3.add(lbSenha);

        lbConfirmarSenha.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbConfirmarSenha.setText("Confir. Senha");
        jPanel3.add(lbConfirmarSenha);

        jpCapacidade.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 100, 150));

        jpDados.add(jpCapacidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, 220, 170));

        jPanel1.add(jpDados, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 430, 200));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Cadastrar-se");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 160, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 430, 320));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaces/imgs/telaLogin.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 400));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    private void setCor(){
        Color defaultLabelColor = UIManager.getColor("Label.foreground");
        lbNome.setForeground(defaultLabelColor);
        lbCPF.setForeground(defaultLabelColor);
        lbEmail.setForeground(defaultLabelColor);
        lbDataAdmissao.setForeground(defaultLabelColor);
        lbTelefone.setForeground(defaultLabelColor);
        lbSenha.setForeground(defaultLabelColor);
        lbConfirmarSenha.setForeground(defaultLabelColor);
    }
    
    
    private boolean validarCampos(){
        String msgErro = "";
        setCor();
        
        String senha = String.valueOf(txtPSW.getPassword());
        String confirmarSenha = String.valueOf(txtConfirmarPSW.getPassword());
        
        if(txtNome.getText().isEmpty()){
            msgErro += "Nome invalido\n";
            lbNome.setForeground(Color.red);
        }
        
        if(!UtilCriptografia.validarSenha(senha)){
            msgErro += "Senha invalida\nVerifique se sua senha possui pelo menos:\n    (8) caracteres;\n    (1) caractere especial;\n    (1) número;\n    (1) letra maiúscula;\n    (1) letra minúscula.\n";
            lbSenha.setForeground(Color.red);
            lbConfirmarSenha.setForeground(Color.red);
        }
       
        
        if((!senha.equals(confirmarSenha))){
            msgErro += "As senhas não conferem\n";
            lbConfirmarSenha.setForeground(Color.red);
        }
        
        if(txtCPF.getText().isEmpty() ){
            msgErro += "Inseria um CPF\n";
            lbCPF.setForeground(Color.red);
        }
        
        if(!gerIG.getGerDominio().validarEmail(txtEmail.getText(), Funcionario.class)){
            msgErro += "Email invalido ou já cadastrado\n";
            lbEmail.setForeground(Color.red);
        }
        
        if(!UtilGeral.verificarFormatoData(txtDataAdmissao.getText())){
            msgErro += "Data de admissao invalida\n";
            lbDataAdmissao.setForeground(Color.red);
        }
        
        if(!UtilGeral.validarTelefone(txtTelefone.getText())){
            msgErro += "Telefone ou dd invalido\n";
            lbTelefone.setForeground(Color.red);
        }
        
        if(!gerIG.getGerDominio().validarCPF(txtCPF.getText(), Funcionario.class)){
            lbCPF.setForeground(Color.red);
            msgErro += "CPF Invalido ou  já cadastrado!\n";
        }
        
        if(msgErro.isEmpty()){
            return true;
        }else{
            JOptionPane.showMessageDialog(this, msgErro, "Verifique os campos e tente novamente", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    private void limparCampos(){
        setCor();
        txtNome.setText("");
        txtCPF.setText("");
        txtEmail.setText("");      
        txtDataAdmissao.setText("");
        txtTelefone.setText("");
        txtPSW.setText("");
        txtConfirmarPSW.setText("");
    } 
    
    
    private void btEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEntrarActionPerformed
        String nome = txtNome.getText();
        String cpf = txtCPF.getText();
        String dataAdmissao = txtDataAdmissao.getText();
        String email = txtEmail.getText(); 
        String senha  = txtPSW.getText();
        String telefone = txtTelefone.getText(); 
        if(validarCampos()){
            try {
                Date dt = UtilGeral.strToDate(dataAdmissao);
                
                gerIG.getGerDominio().inserirFucionario(nome, cpf,dt, email, senha, telefone);
                JOptionPane.showMessageDialog(this, "Funcionario inserido com sucesso.", "Inserir Funcionario", JOptionPane.INFORMATION_MESSAGE  );
                gerIG.janelaLogin();
                this.dispose();
            } catch (HeadlessException | ParseException e) {
               JOptionPane.showMessageDialog(this, e, "ERRO Cliente", JOptionPane.ERROR_MESSAGE  );
            }
            limparCampos();
        }
    }//GEN-LAST:event_btEntrarActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btCancelarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btEntrar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jpCapacidade;
    private javax.swing.JPanel jpDados;
    private javax.swing.JPanel jpEmail;
    private javax.swing.JPanel jpInfo;
    private javax.swing.JPanel jpNome;
    private javax.swing.JLabel lbCPF;
    private javax.swing.JLabel lbConfirmarSenha;
    private javax.swing.JLabel lbDataAdmissao;
    private javax.swing.JLabel lbEmail;
    private javax.swing.JLabel lbNome;
    private javax.swing.JLabel lbSenha;
    private javax.swing.JLabel lbTelefone;
    private javax.swing.JFormattedTextField txtCPF;
    private javax.swing.JPasswordField txtConfirmarPSW;
    private javax.swing.JFormattedTextField txtDataAdmissao;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNome;
    private javax.swing.JPasswordField txtPSW;
    private javax.swing.JFormattedTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}