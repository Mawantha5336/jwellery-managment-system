/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.sql.ResultSet;
import java.util.Vector;
import java.util.regex.Pattern;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.MySql;

/**
 *
 * @author DELL
 */
public class Suplier_registration extends javax.swing.JFrame {


    GRN1 grn;    
    
     public void loadsupplier() {

        try {
            ResultSet rs = MySql.search("SELECT `supplier`.`id`,`supplier`.`name`,`supplier`.`contact_number`,`supplier`.`email`,`company_branch`.`name` AS `branch_name` FROM `supplier` INNER JOIN `company_branch` ON `Supplier`.`company_branch_id`=`company_branch`.`id`;");

            //DefaultTableModel dtm = new DefaultTableModel();
            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
            dtm.setRowCount(0);

            while (rs.next()) {

                Vector v = new Vector();
                v.add(rs.getString("id"));
                v.add(rs.getString("name"));
                v.add(rs.getString("contact_number"));
                v.add(rs.getString("email"));
                v.add(rs.getString("branch_name"));
                dtm.addRow(v);

            }

            jTable1.setModel(dtm);

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
   
    }
     
       
     public void loadsupplier(String text) {

        try {
            ResultSet rs = MySql.search("SELECT `supplier`.`id`,`supplier`.`name`,`supplier`.`contact_number`,`supplier`.`email`,`company_branch`.`name` AS `branch_name` FROM `supplier` INNER JOIN `company_branch` ON `Supplier`.`company_branch_id`=`company_branch`.`id` WHERE `supplier`.`name` LIKE '"+text+"%' OR `supplier`.`contact_number` LIKE '"+text+"%' ORDER BY `supplier`.`id` ASC;");

            //DefaultTableModel dtm = new DefaultTableModel();
            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
            dtm.setRowCount(0);

            while (rs.next()) {

                Vector v = new Vector();
                v.add(rs.getString("id"));
                v.add(rs.getString("name"));
                v.add(rs.getString("contact_number"));
                v.add(rs.getString("email"));
                v.add(rs.getString("branch_name"));
                dtm.addRow(v);

            }

            jTable1.setModel(dtm);

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
   
    }
     
     
     
          
    public void loadbranches() {

        try {

            ResultSet rs = MySql.search("SELECT * FROM `company_branch`");

            Vector v = new Vector();
            v.add("Select");

            while (rs.next()) {
                v.add(rs.getString("name"));

            }

            DefaultComboBoxModel dcm = new DefaultComboBoxModel(v);
            jComboBox1.setModel(dcm);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     public void resetsupplier() {
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jComboBox1.setSelectedIndex(0);
        jTextField1.grabFocus();
    }

    /**
     * Creates new form Suplier_registration
     */
    public Suplier_registration() {
        
        initComponents();
        loadsupplier();
        loadbranches();
    }

     public Suplier_registration(GRN1 grn) {
         
        
         
        initComponents();
        loadsupplier();
        this.grn = grn;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jPanel2KeyTyped(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel1.setText("Name");

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel2.setText("Contact No");

        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField2KeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel3.setText("Emaill");

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel4.setText("Co-Branch");

        jComboBox1.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N

        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1)
                    .addComponent(jComboBox1, 0, 135, Short.MAX_VALUE)
                    .addComponent(jTextField3)
                    .addComponent(jTextField2))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addContainerGap(71, Short.MAX_VALUE))
        );

        jTable1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 0, 0)));
        jTable1.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Contact No", "Emaill", "Company Branch"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel6.setText("Search");

        jTextField5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField5KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(71, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/jewelry-logo-design-template-cir_1.png"))); // NOI18N

        jButton3.setText("Delete");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)))
                .addGap(4, 4, 4))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        String name = jTextField1.getText();
        String contact_no = jTextField2.getText();
        String emaill = jTextField3.getText();
        String co_branch = jComboBox1.getSelectedItem().toString();
       

        if(name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter  Name", "warning", JOptionPane.WARNING_MESSAGE);
        } else if (contact_no.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Contact_No", "warning", JOptionPane.WARNING_MESSAGE);
        } else if (emaill.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Emaill", "warning", JOptionPane.WARNING_MESSAGE);
        } else if (co_branch.equals("Select")) {
            JOptionPane.showMessageDialog(this, "Please Select company Branch", "warning", JOptionPane.WARNING_MESSAGE);
        } else {

            try {

                ResultSet rs1 = MySql.search("SELECT `id` FROM `company_branch` WHERE `name` = '" + co_branch + "'");
                rs1.next();

               
                String branch_id = rs1.getString("id");

                MySql.iud("INSERT INTO `jwellary_shop`.`supplier` (`name`, `contact_number`, `email`, `company_branch_id`) VALUES ('" + name + "','" + contact_no + "','" + emaill + "'," + Integer.parseInt(branch_id) + ");");

                resetsupplier();
                loadsupplier();

                JOptionPane.showMessageDialog(this, "New Supplier Regidterd", "Success", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyTyped
        // TODO add your handling code here:
        
        System.out.println("1");
        String mobile = jTextField2.getText();
        String text = mobile + evt.getKeyChar();

        if (text.length() == 1) {
            if (!text.equals("0")) {
                evt.consume();
            }
        } else if (text.length() == 2) {
            if (!text.equals("07")) {
                evt.consume();
            }
        } else if (text.length() == 3) {
            if (!Pattern.compile("07[01245678]").matcher(text).matches()) {
                evt.consume();
            }
        } else if (text.length() <= 10) {
            if (!Pattern.compile("07[01245678][0-9]+").matcher(text).matches()) {
                evt.consume();
            }
        } else {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField2KeyTyped

    private void jPanel2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel2KeyTyped
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jPanel2KeyTyped

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
        // TODO add your handling code here:
        char m = evt.getKeyChar();
        
        if(Character.isLetter(m)||Character.isWhitespace(m)||Character.isISOControl(m)){
            
            
            jTextField1.setEditable(true);
        }else{
            
            jTextField1.setEditable(false);
        }
    }//GEN-LAST:event_jTextField1KeyTyped

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
         int r = jTable1.getSelectedRow();
         
        String id = jTable1.getValueAt(r, 0).toString();
        String Name = jTextField1.getText();
        String C_no  = jTextField2.getText();
        String emaill_add  = jTextField3.getText();
        String Co_branch = jComboBox1.getSelectedItem().toString();
       
        
        
        if(Name.isEmpty()){
            JOptionPane.showMessageDialog(this, "Please Select  Supplier Name  you want to update from the table", "warning", JOptionPane.WARNING_MESSAGE);
        }else if(C_no.isEmpty()){
            JOptionPane.showMessageDialog(this, "Please Enter Contact Number", "warning", JOptionPane.WARNING_MESSAGE); 
        }else if(emaill_add.isEmpty()){
            JOptionPane.showMessageDialog(this, "Please Enter Emaill Address", "warning", JOptionPane.WARNING_MESSAGE); 
        }else if(Co_branch.isEmpty()){
            JOptionPane.showMessageDialog(this, "Please Enter Company Branch", "warning", JOptionPane.WARNING_MESSAGE); 
        }else{
            
            try{
                
                ResultSet rs1 = MySql.search("SELECT `id` FROM `company_branch` WHERE `name` = '" + Co_branch + "'");
                rs1.next();

               
                String branch_id = rs1.getString("id");

            
                
            
                MySql.iud("Update supplier set name='"+Name+"',contact_number='"+C_no+"',email='"+emaill_add+"', "
                        + "company_branch_id='"+ Integer.parseInt(branch_id) +"' where id='"+id+"';");
            
                resetsupplier();
                loadsupplier();
                
               JOptionPane.showMessageDialog(this, "User status updated", "Success",JOptionPane.INFORMATION_MESSAGE);
               jButton1.setEnabled(true);
            }catch(Exception e){
                e.printStackTrace();
            }
            
            
        
        
        
    }                            
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        
         if(evt.getClickCount() == 1){
            int r = jTable1.getSelectedRow();
        
            if (r== -1) {
                JOptionPane.showMessageDialog(this, "Please select a Supplier","Warning",JOptionPane.WARNING_MESSAGE);
            } else {
                
                
                    
                    String name = jTable1.getValueAt(r, 1).toString();
                    String c_no = jTable1.getValueAt(r, 2).toString();
                    String emaill = jTable1.getValueAt(r, 3).toString();
                    String co_branch = jTable1.getValueAt(r, 4).toString();

                   
                    jTextField1.setText(name);
                    jTextField2.setText(c_no);
                    jTextField3.setText(emaill);
                    jComboBox1.setSelectedItem(co_branch);
                    jButton1.setEnabled(false);

                    


                }
                
            }
         
           if(evt.getClickCount() == 2){
            int r = jTable1.getSelectedRow();
        
            if (r== -1) {
                JOptionPane.showMessageDialog(this, "Please select a Supplier","Warning",JOptionPane.WARNING_MESSAGE);
            } else {
                
                if(grn != null){
                    String sid = jTable1.getValueAt(r, 0).toString();
                    String sname = jTable1.getValueAt(r, 1).toString();
                    String smobile = jTable1.getValueAt(r, 2).toString();
                    String branch = jTable1.getValueAt(r, 4).toString();

                    grn.jLabel5.setText(sid);
                    grn.jLabel6.setText(sname);
                    grn.jLabel7.setText(smobile);
                    grn.jLabel8.setText(branch);

                    grn.jButton1.setText("Update Supplier");
                    grn.jButton1.setEnabled(false);

                    this.dispose();
                }
                
            }
        }
         
         /* if (evt.getClickCount() == 2) {
            int r = jTable1.getSelectedRow();

            if (r == -1) {
                JOptionPane.showMessageDialog(this, "Please select a branch", "Warning", JOptionPane.WARNING_MESSAGE);
            } else {
                if (grn != null) {

                    String sid = jTable1.getValueAt(r, 0).toString();
                    String sname = jTable1.getValueAt(r, 1).toString();
                    String smobile = jTable1.getValueAt(r, 2).toString();
                    System.out.println(sid);

                    grn.sup_id.setText(sid);
                    grn.jLabel15.setText(sname);
                    grn.jLabel12.setText(smobile);
                   

                //      grn.jButton1.setText("Update Supplier");
                    //  grn.jbutton1.setEnabled(false);

                    this.dispose();

                }
            }
        }*/
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTextField5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyReleased
        // TODO add your handling code here:
        
         String text = jTextField5.getText();
         loadsupplier(text);
    }//GEN-LAST:event_jTextField5KeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Suplier_registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Suplier_registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Suplier_registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Suplier_registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Suplier_registration().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables
}