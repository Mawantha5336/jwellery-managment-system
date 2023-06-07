/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.MySql;

/**
 *
 * @author DELL
 */
public class Home extends javax.swing.JFrame {
    
    
     public void loadexchange() {

        try {
            ResultSet rs = MySql.search("SELECT `exchange_item`.`id`,`exchange_item`.`Date`,`exchange_item`.`NIC`,`jwellary`.`name` AS `jwellary`,`category`.`name` AS `category` FROM `exchange_item` INNER JOIN `jwellary` ON `exchange_item`.`jwellary_id`=`jwellary`.`id` INNER JOIN `category` ON `exchange_item`.`category_id`=`category`.`id`;");

            //DefaultTableModel dtm = new DefaultTableModel();
            DefaultTableModel dtm = (DefaultTableModel) jTable10.getModel();
            dtm.setRowCount(0);

            while (rs.next()) {

                Vector v = new Vector();
                v.add(rs.getString("id"));
                v.add(rs.getString("Date"));
                v.add(rs.getString("NIC"));
                v.add(rs.getString("jwellary"));
                v.add(rs.getString("category"));
                dtm.addRow(v);

            }

            jTable10.setModel(dtm);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     
              public void loadJwellerys() {

        try {

            ResultSet rs = MySql.search("SELECT * FROM `jwellary`");

            Vector v = new Vector();
            v.add("Select");

            while (rs.next()) {
                v.add(rs.getString("name"));

            }

            DefaultComboBoxModel dcm = new DefaultComboBoxModel(v);
            jComboBox18.setModel(dcm);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
          
          public void loadcateg() {

        try {

            ResultSet rs = MySql.search("SELECT * FROM `category`");

            Vector v = new Vector();
            v.add("Select");

            while (rs.next()) {
                v.add(rs.getString("name"));

            }

            DefaultComboBoxModel dcm = new DefaultComboBoxModel(v);
            jComboBox19.setModel(dcm);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    
    
    
    
    
    
    
    //Exchange item---------------------------------------------------------------->>>>>>>>>>>>>>>>>>>>>
    
    
    
    
            
    public void loadStock() {

        try {

            ResultSet rs = MySql.search("SELECT DISTINCT `stock`.`Status`,`stock`.`id`,`jwellary`.`id`,`category`.`name`,`jwellary`.`caret_no`,`jwellary`.`name`,`stock`.`quantity`,`grn_item`.`buying_price`,`stock`.`selling_price`,`stock`.`mfd`  FROM `stock` INNER JOIN `grn_item` ON `grn_item`.`stock_id`=`stock`.`id` INNER JOIN `jwellary` ON `stock`.`jwellary_id`=`jwellary`.`id` INNER JOIN `category` ON `jwellary`.`category_id`=`category`.`id` ORDER BY `jwellary`.`name` ASC");
            DefaultTableModel dtm = (DefaultTableModel) jTable9.getModel();
            dtm.setRowCount(0);

            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString("stock.id"));
                v.add(rs.getString("jwellary.id"));
                v.add(rs.getString("category.name"));
                v.add(rs.getString("jwellary.name"));
                v.add(rs.getString("jwellary.caret_no"));
                v.add(rs.getString("stock.quantity"));
                v.add(rs.getString("grn_item.buying_price"));
                v.add(rs.getString("stock.selling_price"));
                v.add(rs.getString("stock.mfd"));
                v.add(rs.getString("Status"));
                
                
                dtm.addRow(v);
            }
            jTable9.setModel(dtm);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    public void loadcaretno() {

        try {

            ResultSet rs = MySql.search("SELECT * FROM `jwellary`");

            Vector v = new Vector();
            v.add("Select");

            while (rs.next()) {
                v.add(rs.getString("caret_no"));

            }

            DefaultComboBoxModel dcm = new DefaultComboBoxModel(v);
            jComboBox15.setModel(dcm);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
     public void loadjewellername() {

        try {

            ResultSet rs = MySql.search("SELECT * FROM `jwellary`");

            Vector v = new Vector();
            v.add("Select");

            while (rs.next()) {
                v.add(rs.getString("name"));

            }

            DefaultComboBoxModel dcm = new DefaultComboBoxModel(v);
            jComboBox16.setModel(dcm);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
     
      public void loadcategoryname() {

        try {

            ResultSet rs = MySql.search("SELECT * FROM `category`");

            Vector v = new Vector();
            v.add("Select");

            while (rs.next()) {
                v.add(rs.getString("name"));

            }

            DefaultComboBoxModel dcm = new DefaultComboBoxModel(v);
            jComboBox17.setModel(dcm);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    
    
    
    
    //Stock----------------------------------------------------------------------------->>>>>>>>>>>>>>>
    
    
    
    
    
    
        public void loadowner() {

        try {
            ResultSet rs = MySql.search("SELECT `owner`.`id`,`owner`.`name`,`owner`.`user_name`,`owner`.`emaill`,`owner`.`passcode`,`emp_category`.`name` AS `category` FROM `owner` INNER JOIN `emp_category` ON `owner`.`emp_category_id`=`emp_category`.`id`;");

            //DefaultTableModel dtm = new DefaultTableModel();
            DefaultTableModel dtm = (DefaultTableModel) jTable8.getModel();
            dtm.setRowCount(0);

            while (rs.next()) {

                Vector v = new Vector();
                v.add(rs.getString("id"));
                v.add(rs.getString("name"));
                v.add(rs.getString("user_name"));
                v.add(rs.getString("emaill"));
                 v.add(rs.getString("passcode"));
                v.add(rs.getString("category"));
                dtm.addRow(v);

            }

            jTable8.setModel(dtm);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     
           public void loadempcategoriy() {

        try {

            ResultSet rs = MySql.search("SELECT * FROM `emp_category`");

            Vector v = new Vector();
            v.add("Select");

            while (rs.next()) {
                v.add(rs.getString("name"));

            }

            DefaultComboBoxModel dcm = new DefaultComboBoxModel(v);
            jComboBox14.setModel(dcm);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
           
        public void resetowner() {
        jTextField29.setText("");
        jTextField30.setText("");
        jTextField31.setText("");
        jPasswordField1.setText("");
        jComboBox14.setSelectedIndex(0);
        jTextField29.grabFocus();
    }

    
    
    
    
    //Owner Registration---------------------------------------------------------------------------------->>>>>>>>>>>>>>>>>>>>
    
    
    
     public void loadbranches() {

        try {
            ResultSet rs = MySql.search("SELECT `company_branch`.`id`,`company_branch`.`branch_contact_number`,`company_branch`.`name`,`company`.`name` AS `company`,`company_branch_address`.`Address` AS `Address` FROM `company_branch` INNER JOIN `company` ON `company_branch`.`company_id`=`company`.`id` INNER JOIN `company_branch_address` ON `company_branch`.`company_branch_address_id`=`company_branch_address`.`id`;");

            //DefaultTableModel dtm = new DefaultTableModel();
            DefaultTableModel dtm = (DefaultTableModel) jTable7.getModel();
            dtm.setRowCount(0);

            while (rs.next()) {

                Vector v = new Vector();
                v.add(rs.getString("id"));
                v.add(rs.getString("branch_contact_number"));
                v.add(rs.getString("name"));
                v.add(rs.getString("company"));
                v.add(rs.getString("Address"));
                dtm.addRow(v);

            }

            jTable7.setModel(dtm);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
       
       public void loadcompany() {

        try {

            ResultSet rs = MySql.search("SELECT * FROM `company`");

            Vector v = new Vector();
            v.add("Select");

            while (rs.next()) {
                v.add(rs.getString("name"));

            }

            DefaultComboBoxModel dcm = new DefaultComboBoxModel(v);
            jComboBox12.setModel(dcm);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
       
       
       public void loadaddress() {

        try {

            ResultSet rs = MySql.search("SELECT * FROM `company_branch_address`");

            Vector v = new Vector();
            v.add("Select");

            while (rs.next()) {
                v.add(rs.getString("Address"));

            }

            DefaultComboBoxModel dcm = new DefaultComboBoxModel(v);
            jComboBox13.setModel(dcm);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    
    
    
    //Branch Registration--------------------------------------------------------------->>>>>>>>>>>>>>>>>>>>>>>>
    
    
      public void loadjewellery() {

        try {
            ResultSet rs = MySql.search("SELECT `jwellary`.`id`,`jwellary`.`name`,`jwellary`.`caret_no`,`supplier`.`name` AS `supplier_name`,`category`.`name` AS `category`,`material`.`name` AS `material` FROM `jwellary` INNER JOIN `supplier` ON `jwellary`.`supplier_id`=`supplier`.`id` INNER JOIN `category` ON `jwellary`.`category_id`=`category`.`id` INNER JOIN `material` ON `jwellary`.`material_id`=`material`.`id`;");

            //DefaultTableModel dtm = new DefaultTableModel();
            DefaultTableModel dtm = (DefaultTableModel) jTable6.getModel();
            dtm.setRowCount(0);

            while (rs.next()) {

                Vector v = new Vector();
                v.add(rs.getString("id"));
                v.add(rs.getString("name"));
                v.add(rs.getString("caret_no"));
                v.add(rs.getString("supplier_name"));
                v.add(rs.getString("category"));
                v.add(rs.getString("material"));
                dtm.addRow(v);

            }

            jTable6.setModel(dtm);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadjewellery(String text) {

        try {
            ResultSet rs = MySql.search("SELECT `jwellary`.`id`,`jwellary`.`name`,`jwellary`.`caret_no`,`supplier`.`name` AS `supplier_name`,`category`.`name` AS `category`,`material`.`name` AS `material` FROM `jwellary` INNER JOIN `supplier` ON `jwellary`.`supplier_id`=`supplier`.`id` INNER JOIN `category` ON `jwellary`.`category_id`=`category`.`id` INNER JOIN `material` ON `jwellary`.`material_id`=`material`.`id`WHERE `jwellary`.`name` LIKE '" + text + "%' OR `jwellary`.`caret_no` LIKE '" + text + "%' ORDER BY `jwellary`.`id` ASC;");

            //DefaultTableModel dtm = new DefaultTableModel();
            DefaultTableModel dtm = (DefaultTableModel) jTable6.getModel();
            dtm.setRowCount(0);

            while (rs.next()) {

                Vector v = new Vector();
                v.add(rs.getString("id"));
                v.add(rs.getString("name"));
                v.add(rs.getString("caret_no"));
                v.add(rs.getString("supplier_name"));
                v.add(rs.getString("category"));
                v.add(rs.getString("material"));
                dtm.addRow(v);

            }

            jTable6.setModel(dtm);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadsup() {

        try {

            ResultSet rs = MySql.search("SELECT * FROM `supplier`");

            Vector v = new Vector();
            v.add("Select");

            while (rs.next()) {
                v.add(rs.getString("name"));

            }

            DefaultComboBoxModel dcm = new DefaultComboBoxModel(v);
            jComboBox10.setModel(dcm);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void loadcategory() {

        try {

            ResultSet rs = MySql.search("SELECT * FROM `category`");

            Vector v = new Vector();
            v.add("Select");

            while (rs.next()) {
                v.add(rs.getString("name"));

            }

            DefaultComboBoxModel dcm = new DefaultComboBoxModel(v);
            jComboBox11.setModel(dcm);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void loadmaterial() {

        try {

            ResultSet rs = MySql.search("SELECT * FROM `material`");

            Vector v = new Vector();
            v.add("Select");

            while (rs.next()) {
                v.add(rs.getString("name"));

            }

            DefaultComboBoxModel dcm = new DefaultComboBoxModel(v);
            jComboBox5.setModel(dcm);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void resetaddjewelery() {
        jTextField11.setText("");
        jTextField25.setText("");
        jComboBox10.setSelectedIndex(0);
        jComboBox11.setSelectedIndex(0);
        jComboBox5.setSelectedIndex(0);
        jTextField11.grabFocus();
    }
    
    
    
    
    
    //Jwellery Registration------------------------------------------------------------------------------------------------>>>>>>>>>>>>>>>>>>>>

    
    public void loademployee() {

        try {
            ResultSet rs = MySql.search("SELECT `employee`.`id`,`employee`.`name`,`employee`.`user_name`,`employee`.`password`,`employee`.`NIC`,`employee`.`emaill`,`employee`.`Contact_No`,`employee`.`Address`,`category`.`name` AS `category`,`emp_category`.`name` AS `emp_category` FROM `employee` INNER JOIN `category` ON `employee`.`category_id`=`category`.`id` INNER JOIN `emp_category` ON `employee`.`emp_category_id`=`emp_category`.`id`;");

            //DefaultTableModel dtm = new DefaultTableModel();
            DefaultTableModel dtm = (DefaultTableModel) jTable5.getModel();
            dtm.setRowCount(0);

            while (rs.next()) {

                Vector v = new Vector();
                v.add(rs.getString("id"));
                v.add(rs.getString("name"));
                v.add(rs.getString("user_name"));
                v.add(rs.getString("password"));
                v.add(rs.getString("NIC"));
                v.add(rs.getString("emaill"));
                 v.add(rs.getString("Contact_No"));
                v.add(rs.getString("Address"));
                v.add(rs.getString("category"));
                v.add(rs.getString("emp_category"));
                dtm.addRow(v);

            }

            jTable5.setModel(dtm);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void loademployee(String text) {

        try {
            ResultSet rs = MySql.search("SELECT `employee`.`id`,`employee`.`name`,`employee`.`user_name`,`employee`.`password`,`employee`.`NIC`,`employee`.`emaill`,`employee`.`Contact_No`,`employee`.`Address`,`category`.`name` AS `category`,`emp_category`.`name` AS `emp_category` FROM `employee` INNER JOIN `category` ON `employee`.`category_id`=`category`.`id` INNER JOIN `emp_category` ON `employee`.`emp_category_id`=`emp_category`.`id`  WHERE `employee`.`name` LIKE '"+text+"%' OR `employee`.`Contact_No` LIKE '"+text+"%' ORDER BY `employee`.`id` ASC;;");

            //DefaultTableModel dtm = new DefaultTableModel();
            DefaultTableModel dtm = (DefaultTableModel) jTable5.getModel();
            dtm.setRowCount(0);

            while (rs.next()) {

                Vector v = new Vector();
                v.add(rs.getString("id"));
                v.add(rs.getString("name"));
                v.add(rs.getString("user_name"));
                v.add(rs.getString("password"));
                v.add(rs.getString("NIC"));
                v.add(rs.getString("emaill"));
                 v.add(rs.getString("Contact_No"));
                v.add(rs.getString("Address"));
                v.add(rs.getString("category"));
                v.add(rs.getString("emp_category"));
                dtm.addRow(v);

            }

            jTable5.setModel(dtm);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }     
       public void loadjcategory() {

        try {

            ResultSet rs = MySql.search("SELECT * FROM `category`");

            Vector v = new Vector();
            v.add("Select");

            while (rs.next()) {
                v.add(rs.getString("name"));

            }

            DefaultComboBoxModel dcm = new DefaultComboBoxModel(v);
            jComboBox9.setModel(dcm);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
       
       public void loadempcategory() {

        try {

            ResultSet rs = MySql.search("SELECT * FROM `emp_category`");

            Vector v = new Vector();
            v.add("Select");

            while (rs.next()) {
                v.add(rs.getString("name"));

            }

            DefaultComboBoxModel dcm = new DefaultComboBoxModel(v);
            jComboBox8.setModel(dcm);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
       public void resetemployee() {
        jTextField18.setText("");
        jTextField19.setText("");
        jPasswordField2.setText("");
        jTextField20.setText("");
        jTextField21.setText("");
        jTextField22.setText("");
        jTextField23.setText("");
        jComboBox9.setSelectedIndex(0);
        jComboBox8.setSelectedIndex(0);
        jTextField18.grabFocus();
    }

    
    
    
    
    
    
    //Employee Registration ----------------------------------------------------------------------------->>>>>>>>>>>>
    
    
      
     public void loadsupplier() {

        try {
            ResultSet rs = MySql.search("SELECT `supplier`.`id`,`supplier`.`name`,`supplier`.`contact_number`,`supplier`.`email`,`company_branch`.`name` AS `branch_name` FROM `supplier` INNER JOIN `company_branch` ON `Supplier`.`company_branch_id`=`company_branch`.`id`;");

            //DefaultTableModel dtm = new DefaultTableModel();
            DefaultTableModel dtm = (DefaultTableModel) jTable4.getModel();
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

            jTable4.setModel(dtm);

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
   
    }
     
       
     public void loadsupplier(String text) {

        try {
            ResultSet rs = MySql.search("SELECT `supplier`.`id`,`supplier`.`name`,`supplier`.`contact_number`,`supplier`.`email`,`company_branch`.`name` AS `branch_name` FROM `supplier` INNER JOIN `company_branch` ON `Supplier`.`company_branch_id`=`company_branch`.`id` WHERE `supplier`.`name` LIKE '"+text+"%' OR `supplier`.`contact_number` LIKE '"+text+"%' ORDER BY `supplier`.`id` ASC;");

            //DefaultTableModel dtm = new DefaultTableModel();
            DefaultTableModel dtm = (DefaultTableModel) jTable4.getModel();
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

            jTable4.setModel(dtm);

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
   
    }
     
     
     
          
    public void loadbranchess() {

        try {

            ResultSet rs = MySql.search("SELECT * FROM `company_branch`");

            Vector v = new Vector();
            v.add("Select");

            while (rs.next()) {
                v.add(rs.getString("name"));

            }

            DefaultComboBoxModel dcm = new DefaultComboBoxModel(v);
            jComboBox7.setModel(dcm);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     public void resetsupplier() {
        jTextField14.setText("");
        jTextField15.setText("");
        jTextField16.setText("");
        jComboBox7.setSelectedIndex(0);
        jTextField14.grabFocus();
    }






//Customer Registration -------------------------------------------------------------------------------------------------->>>>>>>>>>    
       public void loadcustomer() {

        try {
            ResultSet rs = MySql.search("SELECT `user`.`id`,`user`.`first_name`,`user`.`last_name`,`user`.`contact_number`,`city`.`name` AS `city_name` FROM `user` INNER JOIN `city` ON `user`.`city_id`=`city`.`id`;");

            //DefaultTableModel dtm = new DefaultTableModel();
            DefaultTableModel dtm = (DefaultTableModel) jTable3.getModel();
            dtm.setRowCount(0);

            while (rs.next()) {

               Vector v = new Vector();
                v.add(rs.getString("id"));
                v.add(rs.getString("first_name"));
                v.add(rs.getString("last_name"));
                v.add(rs.getString("contact_number"));
                v.add(rs.getString("city_name"));
                dtm.addRow(v);

            }

            jTable3.setModel(dtm);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    public void loadUsertypes() {
//
//        try {
//
//            ResultSet rs = MySql.search("SELECT * FROM `user_type`");
//
//            Vector v = new Vector();
//            v.add("Select");
//
//            while (rs.next()) {
//                v.add(rs.getString("name"));
//
//            }
//
//            DefaultComboBoxModel dcm = new DefaultComboBoxModel(v);
//            jComboBox5.setModel(dcm);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }

    public void loadCities() {

        try {

            ResultSet rs = MySql.search("SELECT * FROM `city`");

            Vector v = new Vector();
            v.add("Select");

            while (rs.next()) {
                v.add(rs.getString("name"));

            }

            DefaultComboBoxModel dcm = new DefaultComboBoxModel(v);
            jComboBox6.setModel(dcm);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void resetFields() {
        jTextField9.setText("");
        jTextField10.setText("");
        jTextField12.setText("");
        jComboBox6.setSelectedIndex(0);
        jTextField9.grabFocus();
    }

//    public void resetLables() {
//        jLabel48.setText("None");
//        jLabel50.setText("None");
//        jLabel52.setText("None");
//        jLabel54.setText("None");
//        jLabel56.setText("None");
//        jLabel48.grabFocus();
//    }

    public void loadcustomer(String text) {

        try {
            ResultSet rs = MySql.search("SELECT `user`.`id`,`user`.`first_name`,`user`.`last_name`,`user`.`contact_number`,`city`.`name` AS `city_name` FROM `user` INNER JOIN `city` ON `user`.`city_id`=`city`.`id` WHERE `user`.`first_name` LIKE '"+text+"%' OR `user`.`contact_number` LIKE '"+text+"%' ORDER BY `user`.`id` ASC;");

            //DefaultTableModel dtm = new DefaultTableModel();
            DefaultTableModel dtm = (DefaultTableModel) jTable3.getModel();
            dtm.setRowCount(0);

            while (rs.next()) {

                Vector v = new Vector();
                v.add(rs.getString("id"));
                v.add(rs.getString("first_name"));
                v.add(rs.getString("last_name"));
                v.add(rs.getString("contact_number"));
                v.add(rs.getString("city_name"));
                dtm.addRow(v);


            }

            jTable3.setModel(dtm);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Creates new form Home
     */
    public Home() {
        
        
        
        //customer Registration---------------------------->>>>>>>>


        initComponents();
        loadcustomer();
       // loadUsertypes();
        loadCities();
         //Supplier Registration---------------------------->>>>>>>>
         
        loadsupplier();
        loadbranchess();
        
        //Employee Registration----------------------------->>>>>>>>
        loademployee();
        loadjcategory();
        loadempcategory();
        
        
        //Jwellery Registration----------------------------->>>>>>>>
        
        loadjewellery();
        loadsup();
        loadcategory();
        loadmaterial();
        
        //Branches Registration---------------------------->>>>>>>>>
        
        loadbranches();
        loadcompany();
        loadaddress();
        
        
        //Owner Registration------------------------------->>>>>>>>>
        
        loadowner(); 
        loadempcategoriy();
        
        //Stock-------------------------------------------->>>>>>>>>
        
        loadStock(); 
        loadcaretno();
        loadjewellername();
        loadcategoryname();
        
        
        
        //timer------------------------------------------->>>>>>>>>>
        time();
        
        
        //Exchange item----------------------------------->>>>>>>>>>
        
        loadexchange();
        loadJwellerys();
        loadcateg();
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel2 = new com.k33ptoo.components.KGradientPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel100 = new javax.swing.JLabel();
        jLabel115 = new javax.swing.JLabel();
        jLabel128 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel137 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        kButton1 = new com.k33ptoo.components.KButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        kButton2 = new com.k33ptoo.components.KButton();
        emp = new com.k33ptoo.components.KButton();
        kButton4 = new com.k33ptoo.components.KButton();
        kButton5 = new com.k33ptoo.components.KButton();
        kButton6 = new com.k33ptoo.components.KButton();
        kButton8 = new com.k33ptoo.components.KButton();
        kButton9 = new com.k33ptoo.components.KButton();
        kButton7 = new com.k33ptoo.components.KButton();
        kButton14 = new com.k33ptoo.components.KButton();
        kGradientPanel1 = new com.k33ptoo.components.KGradientPanel();
        time = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        jTextField12 = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        jComboBox6 = new javax.swing.JComboBox<>();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        jLabel46 = new javax.swing.JLabel();
        jTextField13 = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel57 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jLabel63 = new javax.swing.JLabel();
        jTextField14 = new javax.swing.JTextField();
        jLabel64 = new javax.swing.JLabel();
        jTextField15 = new javax.swing.JTextField();
        jLabel65 = new javax.swing.JLabel();
        jTextField16 = new javax.swing.JTextField();
        jLabel66 = new javax.swing.JLabel();
        jComboBox7 = new javax.swing.JComboBox<>();
        mmd = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jPanel17 = new javax.swing.JPanel();
        jLabel67 = new javax.swing.JLabel();
        jTextField17 = new javax.swing.JTextField();
        jLabel68 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jLabel77 = new javax.swing.JLabel();
        jTextField18 = new javax.swing.JTextField();
        jLabel78 = new javax.swing.JLabel();
        jTextField19 = new javax.swing.JTextField();
        jLabel79 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        jTextField20 = new javax.swing.JTextField();
        jLabel81 = new javax.swing.JLabel();
        jTextField21 = new javax.swing.JTextField();
        jLabel82 = new javax.swing.JLabel();
        jTextField22 = new javax.swing.JTextField();
        jPasswordField2 = new javax.swing.JPasswordField();
        jLabel83 = new javax.swing.JLabel();
        jTextField23 = new javax.swing.JTextField();
        jLabel84 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        jComboBox8 = new javax.swing.JComboBox<>();
        jComboBox9 = new javax.swing.JComboBox<>();
        addbutton = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jPanel21 = new javax.swing.JPanel();
        jLabel86 = new javax.swing.JLabel();
        jTextField24 = new javax.swing.JTextField();
        jLabel87 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        jPanel24 = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        jComboBox5 = new javax.swing.JComboBox<>();
        jLabel44 = new javax.swing.JLabel();
        jTextField25 = new javax.swing.JTextField();
        jLabel101 = new javax.swing.JLabel();
        jComboBox10 = new javax.swing.JComboBox<>();
        jLabel102 = new javax.swing.JLabel();
        jComboBox11 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jLabel103 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();
        jButton17 = new javax.swing.JButton();
        jPanel25 = new javax.swing.JPanel();
        jLabel114 = new javax.swing.JLabel();
        jTextField26 = new javax.swing.JTextField();
        jButton11 = new javax.swing.JButton();
        jLabel48 = new javax.swing.JLabel();
        jPanel26 = new javax.swing.JPanel();
        jPanel27 = new javax.swing.JPanel();
        jPanel28 = new javax.swing.JPanel();
        jLabel116 = new javax.swing.JLabel();
        jLabel117 = new javax.swing.JLabel();
        jTextField27 = new javax.swing.JTextField();
        jButton18 = new javax.swing.JButton();
        jLabel118 = new javax.swing.JLabel();
        jTextField28 = new javax.swing.JTextField();
        jLabel119 = new javax.swing.JLabel();
        jButton19 = new javax.swing.JButton();
        jComboBox12 = new javax.swing.JComboBox<>();
        jComboBox13 = new javax.swing.JComboBox<>();
        jButton20 = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTable7 = new javax.swing.JTable();
        jLabel120 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jPanel29 = new javax.swing.JPanel();
        jPanel30 = new javax.swing.JPanel();
        jLabel121 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        kButton3 = new com.k33ptoo.components.KButton();
        kButton10 = new com.k33ptoo.components.KButton();
        kButton11 = new com.k33ptoo.components.KButton();
        kButton12 = new com.k33ptoo.components.KButton();
        kButton13 = new com.k33ptoo.components.KButton();
        jPanel31 = new javax.swing.JPanel();
        jPanel32 = new javax.swing.JPanel();
        jPanel33 = new javax.swing.JPanel();
        jLabel122 = new javax.swing.JLabel();
        jTextField29 = new javax.swing.JTextField();
        jLabel123 = new javax.swing.JLabel();
        jTextField30 = new javax.swing.JTextField();
        jLabel124 = new javax.swing.JLabel();
        jTextField31 = new javax.swing.JTextField();
        jLabel125 = new javax.swing.JLabel();
        jLabel126 = new javax.swing.JLabel();
        jComboBox14 = new javax.swing.JComboBox<>();
        jButton27 = new javax.swing.JButton();
        jButton28 = new javax.swing.JButton();
        jPasswordField1 = new javax.swing.JPasswordField();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTable8 = new javax.swing.JTable();
        jLabel127 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jPanel38 = new javax.swing.JPanel();
        jPanel34 = new javax.swing.JPanel();
        jPanel35 = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        jTable9 = new javax.swing.JTable();
        jLabel129 = new javax.swing.JLabel();
        jPanel36 = new javax.swing.JPanel();
        jLabel130 = new javax.swing.JLabel();
        jLabel131 = new javax.swing.JLabel();
        jLabel132 = new javax.swing.JLabel();
        jTextField32 = new javax.swing.JTextField();
        jButton29 = new javax.swing.JButton();
        jLabel133 = new javax.swing.JLabel();
        jComboBox15 = new javax.swing.JComboBox<>();
        jLabel134 = new javax.swing.JLabel();
        jComboBox16 = new javax.swing.JComboBox<>();
        jLabel135 = new javax.swing.JLabel();
        jComboBox17 = new javax.swing.JComboBox<>();
        jLabel136 = new javax.swing.JLabel();
        jButton30 = new javax.swing.JButton();
        dateChooserCombo1 = new datechooser.beans.DateChooserCombo();
        jLabel51 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel26 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox<>();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jPanel37 = new javax.swing.JPanel();
        jPanel39 = new javax.swing.JPanel();
        jPanel40 = new javax.swing.JPanel();
        jPanel41 = new javax.swing.JPanel();
        jLabel52 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel53 = new javax.swing.JLabel();
        jTextField33 = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        jComboBox18 = new javax.swing.JComboBox<>();
        jLabel55 = new javax.swing.JLabel();
        jComboBox19 = new javax.swing.JComboBox<>();
        jButton12 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jScrollPane11 = new javax.swing.JScrollPane();
        jTable10 = new javax.swing.JTable();
        jLabel56 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        kGradientPanel2.setkStartColor(new java.awt.Color(153, 255, 255));
        kGradientPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/jewelry-logo-design-template-cir_1.png"))); // NOI18N
        kGradientPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, -1, 128));

        jLabel59.setFont(new java.awt.Font("Dubai Medium", 1, 18)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(51, 51, 51));
        jLabel59.setText("Customer Registration");
        kGradientPanel2.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, -1, -1));

        jLabel58.setFont(new java.awt.Font("Dubai Medium", 1, 18)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(51, 51, 51));
        jLabel58.setText("Supplier Registration");
        kGradientPanel2.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, -1, -1));

        jLabel60.setFont(new java.awt.Font("Dubai Medium", 1, 18)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(51, 51, 51));
        jLabel60.setText("Add Jewellery");
        kGradientPanel2.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 500, -1, -1));

        jLabel61.setFont(new java.awt.Font("Dubai Medium", 1, 18)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(51, 51, 51));
        jLabel61.setText("Stock");
        kGradientPanel2.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 560, -1, -1));

        jLabel100.setFont(new java.awt.Font("Dubai Medium", 1, 18)); // NOI18N
        jLabel100.setForeground(new java.awt.Color(51, 51, 51));
        jLabel100.setText("Employee Registration");
        kGradientPanel2.add(jLabel100, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 320, -1, -1));

        jLabel115.setFont(new java.awt.Font("Dubai Medium", 1, 18)); // NOI18N
        jLabel115.setForeground(new java.awt.Color(51, 51, 51));
        jLabel115.setText("Branch Registration");
        kGradientPanel2.add(jLabel115, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 380, -1, -1));

        jLabel128.setFont(new java.awt.Font("Dubai Medium", 1, 18)); // NOI18N
        jLabel128.setForeground(new java.awt.Color(51, 51, 51));
        jLabel128.setText("Reports");
        kGradientPanel2.add(jLabel128, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 620, -1, -1));

        jLabel62.setFont(new java.awt.Font("Dubai Medium", 1, 18)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(51, 51, 51));
        jLabel62.setText("Logout");
        kGradientPanel2.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 740, -1, -1));

        jLabel137.setFont(new java.awt.Font("Dubai Medium", 1, 18)); // NOI18N
        jLabel137.setForeground(new java.awt.Color(51, 51, 51));
        jLabel137.setText("Owner Registration");
        kGradientPanel2.add(jLabel137, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 440, -1, -1));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/social-media-unscreen(1).gif"))); // NOI18N
        kGradientPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 50, 50));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/document-unscreen(1).gif"))); // NOI18N
        kGradientPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 610, 50, 50));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/export-unscreen(1).gif"))); // NOI18N
        kGradientPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 730, 50, 50));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/shopping-cart-unscreen(1).gif"))); // NOI18N
        kGradientPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 550, 50, 40));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/briefcase-unscreen(1).gif"))); // NOI18N
        kGradientPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 50, 40));

        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/truck-unscreen(1).gif"))); // NOI18N
        kGradientPanel2.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 50, 40));

        jLabel34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/university-unscreen(1).gif"))); // NOI18N
        kGradientPanel2.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 50, 40));

        jLabel35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/diamond-unscreen(1).gif"))); // NOI18N
        kGradientPanel2.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 490, 50, 50));

        jLabel36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/id-unscreen(1).gif"))); // NOI18N
        kGradientPanel2.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, 50, 40));

        jLabel69.setFont(new java.awt.Font("Dubai Medium", 1, 18)); // NOI18N
        jLabel69.setForeground(new java.awt.Color(51, 51, 51));
        jLabel69.setText("Exchanged Item");
        kGradientPanel2.add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 680, -1, -1));

        jLabel72.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/swap-unscreen(1).gif"))); // NOI18N
        kGradientPanel2.add(jLabel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 670, 50, 50));

        kButton1.setForeground(new java.awt.Color(51, 51, 51));
        kButton1.setBorderPainted(false);
        kButton1.setDefaultCapable(false);
        kButton1.setFocusPainted(false);
        kButton1.setFocusable(false);
        kButton1.setFont(new java.awt.Font("Dubai Light", 1, 14)); // NOI18N
        kButton1.setkEndColor(new java.awt.Color(0,0,0,0)
        );
        kButton1.setkHoverEndColor(new java.awt.Color(204, 204, 204));
        kButton1.setkHoverForeGround(new java.awt.Color(51, 51, 51));
        kButton1.setkHoverStartColor(new java.awt.Color(51, 102, 255));
        kButton1.setkStartColor(new java.awt.Color(0,0,0,0)
        );
        kButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton1ActionPerformed(evt);
            }
        });
        kGradientPanel2.add(kButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 191, 290, -1));
        kGradientPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, -1));
        kGradientPanel2.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));
        kGradientPanel2.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 201, 12));

        kButton2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(0, 0, 0)));
        kButton2.setDefaultCapable(false);
        kButton2.setFocusPainted(false);
        kButton2.setFocusable(false);
        kButton2.setFont(new java.awt.Font("Dubai Light", 1, 14)); // NOI18N
        kButton2.setkEndColor(new java.awt.Color(0,0,0,0)
        );
        kButton2.setkHoverEndColor(new java.awt.Color(204, 204, 204));
        kButton2.setkHoverForeGround(new java.awt.Color(51, 51, 51));
        kButton2.setkHoverStartColor(new java.awt.Color(51, 102, 255));
        kButton2.setkStartColor(new java.awt.Color(0,0,0,0)
        );
        kButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton2ActionPerformed(evt);
            }
        });
        kGradientPanel2.add(kButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 290, -1));

        emp.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(0, 0, 0)));
        emp.setFont(new java.awt.Font("Dubai Light", 1, 14)); // NOI18N
        emp.setkEndColor(new java.awt.Color(0,0,0,0)
        );
        emp.setkHoverEndColor(new java.awt.Color(204, 204, 204));
        emp.setkHoverForeGround(new java.awt.Color(51, 51, 51));
        emp.setkHoverStartColor(new java.awt.Color(51, 102, 255));
        emp.setkStartColor(new java.awt.Color(0,0,0,0)
        );
        emp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empActionPerformed(evt);
            }
        });
        kGradientPanel2.add(emp, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 290, -1));

        kButton4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(0, 0, 0)));
        kButton4.setkEndColor(new java.awt.Color(0,0,0,0)
        );
        kButton4.setkHoverEndColor(new java.awt.Color(204, 204, 204));
        kButton4.setkHoverForeGround(new java.awt.Color(51, 51, 51));
        kButton4.setkHoverStartColor(new java.awt.Color(51, 102, 255));
        kButton4.setkStartColor(new java.awt.Color(0,0,0,0)
        );
        kButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton4ActionPerformed(evt);
            }
        });
        kGradientPanel2.add(kButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, 290, -1));

        kButton5.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(0, 0, 0)));
        kButton5.setkEndColor(new java.awt.Color(0,0,0,0)
        );
        kButton5.setkHoverEndColor(new java.awt.Color(204, 204, 204));
        kButton5.setkHoverForeGround(new java.awt.Color(51, 51, 51));
        kButton5.setkHoverStartColor(new java.awt.Color(51, 102, 255));
        kButton5.setkStartColor(new java.awt.Color(0,0,0,0)
        );
        kButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton5ActionPerformed(evt);
            }
        });
        kGradientPanel2.add(kButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 490, 290, -1));

        kButton6.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(0, 0, 0)));
        kButton6.setkEndColor(new java.awt.Color(0,0,0,0)
        );
        kButton6.setkHoverEndColor(new java.awt.Color(204, 204, 204));
        kButton6.setkHoverForeGround(new java.awt.Color(51, 51, 51));
        kButton6.setkHoverStartColor(new java.awt.Color(51, 102, 255));
        kButton6.setkStartColor(new java.awt.Color(0,0,0,0)
        );
        kButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton6ActionPerformed(evt);
            }
        });
        kGradientPanel2.add(kButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 550, 290, -1));

        kButton8.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(0, 0, 0)));
        kButton8.setkEndColor(new java.awt.Color(0,0,0,0)
        );
        kButton8.setkHoverEndColor(new java.awt.Color(204, 204, 204));
        kButton8.setkHoverForeGround(new java.awt.Color(51, 51, 51));
        kButton8.setkHoverStartColor(new java.awt.Color(51, 102, 255));
        kButton8.setkStartColor(new java.awt.Color(0,0,0,0)
        );
        kButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton8ActionPerformed(evt);
            }
        });
        kGradientPanel2.add(kButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 610, 290, -1));

        kButton9.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(0, 0, 0)));
        kButton9.setkEndColor(new java.awt.Color(0,0,0,0)
        );
        kButton9.setkHoverEndColor(new java.awt.Color(204, 204, 204));
        kButton9.setkHoverForeGround(new java.awt.Color(51, 51, 51));
        kButton9.setkHoverStartColor(new java.awt.Color(51, 102, 255));
        kButton9.setkStartColor(new java.awt.Color(0,0,0,0)
        );
        kButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton9ActionPerformed(evt);
            }
        });
        kGradientPanel2.add(kButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 430, 290, -1));

        kButton7.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(0, 0, 0)));
        kButton7.setkEndColor(new java.awt.Color(0,0,0,0)
        );
        kButton7.setkHoverEndColor(new java.awt.Color(204, 204, 204));
        kButton7.setkHoverForeGround(new java.awt.Color(51, 51, 51));
        kButton7.setkHoverStartColor(new java.awt.Color(51, 102, 255));
        kButton7.setkStartColor(new java.awt.Color(0,0,0,0)
        );
        kButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton7ActionPerformed(evt);
            }
        });
        kGradientPanel2.add(kButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 730, 290, -1));

        kButton14.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(0, 0, 0)));
        kButton14.setkEndColor(new java.awt.Color(0,0,0,0)
        );
        kButton14.setkHoverEndColor(new java.awt.Color(204, 204, 204));
        kButton14.setkHoverForeGround(new java.awt.Color(51, 51, 51));
        kButton14.setkHoverStartColor(new java.awt.Color(51, 102, 255));
        kButton14.setkStartColor(new java.awt.Color(0,0,0,0)
        );
        kButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton14ActionPerformed(evt);
            }
        });
        kGradientPanel2.add(kButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 670, 290, -1));

        kGradientPanel1.setkStartColor(new java.awt.Color(0, 204, 255));

        time.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        time.setForeground(new java.awt.Color(255, 255, 255));
        time.setText("5:44:00 PM");

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(823, 823, 823)
                .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel2.setText("Name");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel5.setText("Matirial");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel4.setText("Caret No");

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel6.setText("Supplier");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel7.setText("Category");

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton3.setText("Add Jiwellary");

        jButton4.setText("Update");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel2)
                .addGap(27, 27, 27)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel5)
                .addGap(22, 22, 22)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel4)
                .addGap(12, 12, 12)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel6)
                .addGap(15, 15, 15)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel5))
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel4))
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel6))
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel7))
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(jButton3)
                .addGap(26, 26, 26)
                .addComponent(jButton4)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/jewelry-logo-design-template-cir_1.png"))); // NOI18N

        jTable1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 0, 51)));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Matirial", "Caret No", "Supplier", "Category"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton5.setText("Delete");

        jLabel19.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel19.setText("Search");

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(227, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(jLabel8))
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(412, 412, 412)
                .addComponent(jButton5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 614, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("", jPanel3);

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));

        jLabel39.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel39.setText("First Name");

        jTextField9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField9ActionPerformed(evt);
            }
        });
        jTextField9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField9KeyTyped(evt);
            }
        });

        jLabel40.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel40.setText("Last Name");

        jTextField10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField10ActionPerformed(evt);
            }
        });
        jTextField10.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField10KeyTyped(evt);
            }
        });

        jLabel43.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel43.setText("Contact No");

        jTextField12.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField12KeyTyped(evt);
            }
        });

        jLabel45.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel45.setText("City");

        jComboBox6.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N

        jButton9.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButton9.setText("Create Account");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButton10.setText("Update");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton13.setText("Add City");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel12Layout.createSequentialGroup()
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel39)
                                    .addComponent(jLabel40))
                                .addGap(29, 29, 29)
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField9, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                                    .addComponent(jTextField10)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel12Layout.createSequentialGroup()
                                .addComponent(jLabel43)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                                .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel12Layout.createSequentialGroup()
                                .addComponent(jLabel45)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel39))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43)
                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel45)
                    .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addComponent(jButton9)
                .addGap(50, 50, 50)
                .addComponent(jButton10)
                .addGap(35, 35, 35)
                .addComponent(jButton13)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel46.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel46.setText("Search Customer");

        jTextField13.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField13KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel46)
                .addGap(32, 32, 32)
                .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, 535, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel46)
                    .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jTable3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0), 2));
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "First Name", "Last Name", "Contact No", "City"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable3MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTable3);

        jLabel57.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/jewelry-logo-design-template-cir_1.png"))); // NOI18N

        jLabel37.setFont(new java.awt.Font("Javanese Text", 1, 24)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(102, 102, 102));
        jLabel37.setText("Customer Registration");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jLabel57)))
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                                .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel37)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("", jPanel10);

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));

        jPanel16.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jPanel16KeyTyped(evt);
            }
        });

        jLabel63.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel63.setText("Name");

        jTextField14.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField14KeyTyped(evt);
            }
        });

        jLabel64.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel64.setText("Contact No");

        jTextField15.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField15KeyTyped(evt);
            }
        });

        jLabel65.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel65.setText("Emaill");

        jTextField16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField16ActionPerformed(evt);
            }
        });

        jLabel66.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel66.setText("Co-Branch");

        jComboBox7.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N

        mmd.setText("Add");
        mmd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mmdActionPerformed(evt);
            }
        });

        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel65)
                    .addComponent(jLabel66)
                    .addComponent(jLabel64)
                    .addComponent(jLabel63))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField14)
                    .addComponent(jComboBox7, 0, 135, Short.MAX_VALUE)
                    .addComponent(jTextField16)
                    .addComponent(jTextField15))
                .addContainerGap())
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(mmd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel63)
                    .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel64))
                .addGap(27, 27, 27)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel65))
                .addGap(21, 21, 21)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel66)
                    .addComponent(jComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addComponent(mmd)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addContainerGap(71, Short.MAX_VALUE))
        );

        jTable4.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 0, 0)));
        jTable4.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jTable4.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable4MouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(jTable4);

        jLabel67.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel67.setText("Search");

        jTextField17.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField17KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel67)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, 526, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(231, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel67)
                    .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jLabel68.setBackground(new java.awt.Color(204, 204, 204));
        jLabel68.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/jewelry-logo-design-template-cir_1.png"))); // NOI18N

        jLabel38.setFont(new java.awt.Font("Javanese Text", 1, 24)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(102, 102, 102));
        jLabel38.setText("Supplier Registration");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane5)))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(166, 166, 166)
                        .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel68)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel38)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)))
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("", jPanel14);

        jPanel19.setBackground(new java.awt.Color(255, 255, 255));
        jPanel19.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel20.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel77.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel77.setText("Name");
        jPanel20.add(jLabel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 29, -1, -1));

        jTextField18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField18ActionPerformed(evt);
            }
        });
        jTextField18.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField18KeyTyped(evt);
            }
        });
        jPanel20.add(jTextField18, new org.netbeans.lib.awtextra.AbsoluteConstraints(88, 28, 115, -1));

        jLabel78.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel78.setText("User Name");
        jPanel20.add(jLabel78, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 66, -1, -1));
        jPanel20.add(jTextField19, new org.netbeans.lib.awtextra.AbsoluteConstraints(88, 65, 115, -1));

        jLabel79.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel79.setText("Password");
        jPanel20.add(jLabel79, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 103, -1, -1));

        jLabel80.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel80.setText("NIC");
        jPanel20.add(jLabel80, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 140, -1, -1));

        jTextField20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField20ActionPerformed(evt);
            }
        });
        jPanel20.add(jTextField20, new org.netbeans.lib.awtextra.AbsoluteConstraints(89, 139, 114, -1));

        jLabel81.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel81.setText("Email");
        jPanel20.add(jLabel81, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 179, -1, -1));
        jPanel20.add(jTextField21, new org.netbeans.lib.awtextra.AbsoluteConstraints(89, 176, 114, -1));

        jLabel82.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel82.setText("Mobile_No");
        jPanel20.add(jLabel82, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 214, -1, -1));

        jTextField22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField22ActionPerformed(evt);
            }
        });
        jTextField22.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField22KeyTyped(evt);
            }
        });
        jPanel20.add(jTextField22, new org.netbeans.lib.awtextra.AbsoluteConstraints(89, 213, 114, -1));
        jPanel20.add(jPasswordField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(89, 102, 114, -1));

        jLabel83.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel83.setText("Address");
        jPanel20.add(jLabel83, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 251, -1, -1));

        jTextField23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField23ActionPerformed(evt);
            }
        });
        jPanel20.add(jTextField23, new org.netbeans.lib.awtextra.AbsoluteConstraints(89, 250, 114, -1));

        jLabel84.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel84.setText("JCategory");
        jPanel20.add(jLabel84, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 291, -1, -1));

        jLabel85.setText("ECategory");
        jPanel20.add(jLabel85, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 334, -1, -1));

        jComboBox8.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jPanel20.add(jComboBox8, new org.netbeans.lib.awtextra.AbsoluteConstraints(89, 329, 114, -1));

        jComboBox9.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jPanel20.add(jComboBox9, new org.netbeans.lib.awtextra.AbsoluteConstraints(89, 287, 114, -1));

        addbutton.setText("Add");
        addbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addbuttonActionPerformed(evt);
            }
        });
        jPanel20.add(addbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 371, 191, -1));

        jButton14.setText("Update");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        jPanel20.add(jButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 407, 191, -1));

        jPanel19.add(jPanel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 156, 210, 470));

        jTable5.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 0, 0)));
        jTable5.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "User Name", "Password", "NIC", "Email", "Contact_No", "Address", "Category ", "Emp Category"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable5MouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(jTable5);

        jPanel19.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(215, 156, 843, 450));

        jLabel86.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel86.setText("Search");

        jTextField24.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField24KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel86)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField24, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel86)
                    .addComponent(jTextField24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jPanel19.add(jPanel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 70, 843, -1));

        jLabel87.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/jewelry-logo-design-template-cir_1.png"))); // NOI18N
        jPanel19.add(jLabel87, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 12, 121, -1));

        jLabel47.setFont(new java.awt.Font("Javanese Text", 1, 24)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(102, 102, 102));
        jLabel47.setText("Employee Registration");
        jPanel19.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 20, -1, 40));

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("", jPanel18);

        jPanel23.setBackground(new java.awt.Color(255, 255, 255));

        jLabel41.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel41.setText("Jewellery\n   Name");

        jTextField11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField11ActionPerformed(evt);
            }
        });
        jTextField11.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField11KeyTyped(evt);
            }
        });

        jLabel42.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel42.setText("Matirial");

        jComboBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox5ActionPerformed(evt);
            }
        });

        jLabel44.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel44.setText("Caret No");

        jTextField25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField25ActionPerformed(evt);
            }
        });

        jLabel101.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel101.setText("Supplier");

        jComboBox10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox10ActionPerformed(evt);
            }
        });

        jLabel102.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel102.setText("Category");

        jComboBox11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox11ActionPerformed(evt);
            }
        });

        jButton1.setText("Add Jiwellary");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton16.setText("Update");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel24Layout.createSequentialGroup()
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel44)
                                    .addComponent(jLabel101)
                                    .addComponent(jLabel41))
                                .addComponent(jLabel102))
                            .addComponent(jLabel42))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField25, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jComboBox10, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jComboBox11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 31, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel41))
                .addGap(18, 18, 18)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel44))
                .addGap(18, 18, 18)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel101))
                .addGap(18, 18, 18)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel102)
                    .addComponent(jComboBox11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42)
                    .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addComponent(jButton1)
                .addGap(26, 26, 26)
                .addComponent(jButton16)
                .addContainerGap(116, Short.MAX_VALUE))
        );

        jLabel103.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/jewelry-logo-design-template-cir_1.png"))); // NOI18N

        jTable6.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 0, 51)));
        jTable6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Caret No", "Supplier", "Category", "Material"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable6MouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(jTable6);

        jButton17.setText("Add Category");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        jLabel114.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel114.setText("Search");

        jTextField26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField26ActionPerformed(evt);
            }
        });
        jTextField26.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField26KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel114)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField26, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel25Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel114)
                    .addComponent(jTextField26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );

        jButton11.setText("Add Material");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jLabel48.setFont(new java.awt.Font("Javanese Text", 1, 24)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(102, 102, 102));
        jLabel48.setText("Add Jwellery");

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(jLabel103)))
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 748, Short.MAX_VALUE)
                            .addComponent(jPanel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel23Layout.createSequentialGroup()
                                .addGap(103, 103, 103)
                                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton17, javax.swing.GroupLayout.DEFAULT_SIZE, 517, Short.MAX_VALUE)
                                    .addComponent(jButton11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel23Layout.createSequentialGroup()
                                .addGap(176, 176, 176)
                                .addComponent(jLabel48)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel103, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton17)
                        .addGap(18, 18, 18)
                        .addComponent(jButton11))
                    .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("", jPanel22);

        jPanel27.setBackground(new java.awt.Color(255, 255, 255));

        jLabel116.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel116.setText("Company Name :");

        jLabel117.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel117.setText("Contact No :");

        jTextField27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField27ActionPerformed(evt);
            }
        });
        jTextField27.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField27KeyTyped(evt);
            }
        });

        jButton18.setText("Add Company");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        jLabel118.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel118.setText("Branch Name :");

        jTextField28.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField28KeyTyped(evt);
            }
        });

        jLabel119.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel119.setText("Address :");

        jButton19.setText("Add New Branch");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });

        jComboBox12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox12ActionPerformed(evt);
            }
        });

        jComboBox13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox13ActionPerformed(evt);
            }
        });

        jButton20.setText("Add Branch Address");
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel118)
                    .addComponent(jLabel117))
                .addGap(26, 26, 26)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addComponent(jTextField27, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel116)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox12, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel28Layout.createSequentialGroup()
                                .addComponent(jTextField28, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel119)
                                .addGap(59, 59, 59)
                                .addComponent(jComboBox13, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton18, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                            .addComponent(jButton20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel117)
                    .addComponent(jTextField27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel116)
                    .addComponent(jComboBox12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel118)
                    .addComponent(jTextField28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel119)
                    .addComponent(jComboBox13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton18))
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jButton19))
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton20)))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jTable7.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Branch ID", "Branch Contact No", "Branch Name", "Company ", "Address"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane8.setViewportView(jTable7);

        jLabel120.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/jewelry-logo-design-template-cir_1.png"))); // NOI18N

        jLabel49.setFont(new java.awt.Font("Javanese Text", 1, 24)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(102, 102, 102));
        jLabel49.setText("Branch Registration");

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane8, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel27Layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addComponent(jLabel120, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 133, Short.MAX_VALUE)
                .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel27Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel49)
                .addGap(414, 414, 414))
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel49)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel27Layout.createSequentialGroup()
                        .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel27Layout.createSequentialGroup()
                        .addComponent(jLabel120)
                        .addGap(59, 59, 59)))
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("", jPanel26);

        jPanel30.setBackground(new java.awt.Color(102, 102, 102));
        jPanel30.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel121.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/jewelry-logo-design-template-cir_1.png"))); // NOI18N
        jPanel30.add(jLabel121, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 20, 116, 217));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("GRN");
        jPanel30.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 140, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("Invoice");
        jPanel30.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 230, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setText("Stock");
        jPanel30.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 310, -1, 40));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 102, 102));
        jLabel11.setText("Employee");
        jPanel30.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 410, -1, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 102, 102));
        jLabel12.setText("Supplier");
        jPanel30.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 500, -1, -1));

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/document-unscreen(1).gif"))); // NOI18N
        jPanel30.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 130, 50, 40));

        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/document-unscreen(1).gif"))); // NOI18N
        jPanel30.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 220, 60, 40));

        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/document-unscreen(1).gif"))); // NOI18N
        jPanel30.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 310, 60, 40));

        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/document-unscreen(1).gif"))); // NOI18N
        jPanel30.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 400, 60, 40));

        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/document-unscreen(1).gif"))); // NOI18N
        jPanel30.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 490, 60, 40));

        kButton3.setkEndColor(new java.awt.Color(102, 204, 255));
        kButton3.setkHoverEndColor(new java.awt.Color(204, 204, 255));
        kButton3.setkHoverForeGround(new java.awt.Color(204, 204, 204));
        kButton3.setkHoverStartColor(new java.awt.Color(204, 204, 204));
        kButton3.setkStartColor(new java.awt.Color(153, 0, 255));
        kButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton3ActionPerformed(evt);
            }
        });
        jPanel30.add(kButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 130, 408, -1));

        kButton10.setkEndColor(new java.awt.Color(102, 204, 255));
        kButton10.setkHoverEndColor(new java.awt.Color(204, 204, 255));
        kButton10.setkHoverForeGround(new java.awt.Color(204, 204, 204));
        kButton10.setkHoverStartColor(new java.awt.Color(204, 204, 204));
        kButton10.setkStartColor(new java.awt.Color(153, 0, 255));
        kButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton10ActionPerformed(evt);
            }
        });
        jPanel30.add(kButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 220, 410, -1));

        kButton11.setkEndColor(new java.awt.Color(102, 204, 255));
        kButton11.setkHoverEndColor(new java.awt.Color(204, 204, 255));
        kButton11.setkHoverForeGround(new java.awt.Color(204, 204, 204));
        kButton11.setkHoverStartColor(new java.awt.Color(204, 204, 204));
        kButton11.setkStartColor(new java.awt.Color(153, 0, 255));
        kButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton11ActionPerformed(evt);
            }
        });
        jPanel30.add(kButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 310, 410, -1));

        kButton12.setkEndColor(new java.awt.Color(102, 204, 255));
        kButton12.setkHoverEndColor(new java.awt.Color(204, 204, 255));
        kButton12.setkHoverForeGround(new java.awt.Color(204, 204, 204));
        kButton12.setkHoverStartColor(new java.awt.Color(204, 204, 204));
        kButton12.setkStartColor(new java.awt.Color(153, 0, 255));
        kButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton12ActionPerformed(evt);
            }
        });
        jPanel30.add(kButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 400, 410, -1));

        kButton13.setkEndColor(new java.awt.Color(102, 204, 255));
        kButton13.setkHoverEndColor(new java.awt.Color(204, 204, 255));
        kButton13.setkHoverForeGround(new java.awt.Color(204, 204, 204));
        kButton13.setkHoverStartColor(new java.awt.Color(204, 204, 204));
        kButton13.setkStartColor(new java.awt.Color(153, 0, 255));
        kButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton13ActionPerformed(evt);
            }
        });
        jPanel30.add(kButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 490, 410, -1));

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("", jPanel29);

        jPanel32.setBackground(new java.awt.Color(255, 255, 255));

        jLabel122.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel122.setText("Name :");

        jTextField29.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField29KeyTyped(evt);
            }
        });

        jLabel123.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel123.setText("User Name :");

        jLabel124.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel124.setText("Emaill :");

        jLabel125.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel125.setText("Passcode :");

        jLabel126.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel126.setText("Emp Category:");

        jComboBox14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox14ActionPerformed(evt);
            }
        });

        jButton27.setText("Add");
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton27ActionPerformed(evt);
            }
        });

        jButton28.setText("Update");
        jButton28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton28ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel33Layout.createSequentialGroup()
                        .addComponent(jLabel124)
                        .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel33Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jButton28, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 658, Short.MAX_VALUE)
                                    .addComponent(jButton27, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel33Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jTextField31, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel33Layout.createSequentialGroup()
                        .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel33Layout.createSequentialGroup()
                                .addComponent(jLabel122)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField29, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(51, 51, 51)
                                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel123)
                                    .addComponent(jLabel125))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField30, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel126)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox14, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(241, Short.MAX_VALUE))
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel123)
                        .addComponent(jTextField30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel126)
                        .addComponent(jComboBox14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel122))
                .addGap(31, 31, 31)
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel124)
                    .addComponent(jTextField31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel125)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addComponent(jButton27)
                .addGap(18, 18, 18)
                .addComponent(jButton28)
                .addContainerGap(90, Short.MAX_VALUE))
        );

        jTable8.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "User Name", "Emaill", "Passcode", "Emp_Category"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable8MouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(jTable8);

        jLabel127.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/jewelry-logo-design-template-cir_1.png"))); // NOI18N

        jLabel50.setFont(new java.awt.Font("Javanese Text", 1, 24)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(102, 102, 102));
        jLabel50.setText("Owner Registration");

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel32Layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(jLabel127, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel32Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel50, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 759, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel32Layout.createSequentialGroup()
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel32Layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(jLabel127)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel50)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("", jPanel31);

        jPanel38.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jTabbedPane1.addTab("", jPanel38);

        jPanel35.setBackground(new java.awt.Color(255, 255, 255));

        jTable9.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Stock id", "Jewellery id", "Category", "Name", "Caret No", "Quantity", "Buying Price", "Selling_Price", "Pirches Date", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable9MouseClicked(evt);
            }
        });
        jScrollPane10.setViewportView(jTable9);

        jLabel129.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/jewelry-logo-design-template-cir_1.png"))); // NOI18N

        jLabel130.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel130.setText("Buying Price :");

        jLabel131.setForeground(new java.awt.Color(255, 0, 0));
        jLabel131.setText("0.00");

        jLabel132.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel132.setText("New Price :");

        jButton29.setText("Update");
        jButton29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton29ActionPerformed(evt);
            }
        });

        jLabel133.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel133.setText("Caret No :");

        jLabel134.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel134.setText("Name :");

        jLabel135.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel135.setText("Category :");

        jLabel136.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel136.setText("PD");

        jButton30.setText("Reset");
        jButton30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton30ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel36Layout = new javax.swing.GroupLayout(jPanel36);
        jPanel36.setLayout(jPanel36Layout);
        jPanel36Layout.setHorizontalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel36Layout.createSequentialGroup()
                        .addComponent(jLabel130)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel131, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel36Layout.createSequentialGroup()
                        .addComponent(jLabel132)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField32, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(61, 61, 61)
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel36Layout.createSequentialGroup()
                        .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel133)
                            .addComponent(jLabel134))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBox15, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBox16, 0, 148, Short.MAX_VALUE)))
                    .addGroup(jPanel36Layout.createSequentialGroup()
                        .addComponent(jLabel135)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox17, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(29, 29, 29)
                .addComponent(jLabel136)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dateChooserCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jButton30)
                .addContainerGap(341, Short.MAX_VALUE))
        );
        jPanel36Layout.setVerticalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel130)
                        .addComponent(jLabel131)
                        .addComponent(jLabel133)
                        .addComponent(jComboBox15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel136))
                    .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jButton30, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                        .addComponent(dateChooserCombo1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel36Layout.createSequentialGroup()
                        .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel132)
                            .addComponent(jTextField32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel36Layout.createSequentialGroup()
                        .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel134))
                        .addGap(18, 18, 18)))
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton29)
                    .addComponent(jLabel135)
                    .addComponent(jComboBox17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        jLabel51.setFont(new java.awt.Font("Javanese Text", 1, 24)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(102, 102, 102));
        jLabel51.setText("Stock");

        javax.swing.GroupLayout jPanel35Layout = new javax.swing.GroupLayout(jPanel35);
        jPanel35.setLayout(jPanel35Layout);
        jPanel35Layout.setHorizontalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane10)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel129, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(329, 329, 329)
                .addComponent(jLabel51)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel35Layout.setVerticalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel35Layout.createSequentialGroup()
                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel129, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel35Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabel51)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addComponent(jPanel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("", jPanel34);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel20.setText("Cus Name");

        jLabel21.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel21.setText("NIC");

        jLabel22.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel22.setText("Address");

        jLabel23.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel23.setText("Desig Name");

        jLabel24.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel24.setText("image");

        jLabel25.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel25.setText("Description");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jLabel26.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel26.setText("Category");

        jButton6.setText("Add");

        jButton7.setText("Update");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField7)
                        .addContainerGap())
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel26)
                                .addGap(33, 33, 33)
                                .addComponent(jComboBox4, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel20)
                                            .addComponent(jLabel21)
                                            .addComponent(jLabel22))
                                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel8Layout.createSequentialGroup()
                                                .addGap(23, 23, 23)
                                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addComponent(jLabel24))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(10, 10, 10))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel25)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel24)
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addComponent(jButton6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton7)
                .addContainerGap())
        );

        jPanel7.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 154, 260, 470));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Cus Name", "NIC", "Address", "Design Name", "Image", "Description", "Category"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTable2);

        jPanel7.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(271, 154, 778, 341));

        jLabel27.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel27.setText("Search");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(228, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );

        jPanel7.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(271, 58, 778, -1));

        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/jewelry-logo-design-template-cir_1.png"))); // NOI18N
        jPanel7.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(124, 12, 135, 125));

        jButton8.setText("Delete");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(299, 559, 533, -1));

        jPanel37.setBackground(new java.awt.Color(255, 255, 255));
        jPanel37.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel7.add(jPanel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 12, 1080, 620));

        jPanel2.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 625));

        jTabbedPane1.addTab("", jPanel2);

        jPanel40.setBackground(new java.awt.Color(255, 255, 255));

        jLabel52.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel52.setText("Date :");

        jLabel53.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel53.setText("NIC :");

        jLabel54.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel54.setText("Jewellery Name :");

        jLabel55.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel55.setText("Category :");

        jButton12.setText("Add");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton15.setText("Update");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel41Layout = new javax.swing.GroupLayout(jPanel41);
        jPanel41.setLayout(jPanel41Layout);
        jPanel41Layout.setHorizontalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel41Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel55)
                    .addComponent(jLabel52))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel41Layout.createSequentialGroup()
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 220, Short.MAX_VALUE)
                        .addComponent(jLabel53)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField33, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63)
                        .addComponent(jLabel54)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox18, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53))
                    .addGroup(jPanel41Layout.createSequentialGroup()
                        .addComponent(jComboBox19, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(130, 130, 130)
                        .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton15, javax.swing.GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE)
                            .addComponent(jButton12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel41Layout.setVerticalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel41Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel54)
                        .addComponent(jComboBox18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel53))
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel52))
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel41Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel55)
                            .addComponent(jComboBox19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel41Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jButton12)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton15)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jTable10.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Date", "NIC", "Jewellery Name", "Category"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable10MouseClicked(evt);
            }
        });
        jScrollPane11.setViewportView(jTable10);

        jLabel56.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/jewelry-logo-design-template-cir_1.png"))); // NOI18N

        jLabel70.setFont(new java.awt.Font("Javanese Text", 1, 24)); // NOI18N
        jLabel70.setForeground(new java.awt.Color(102, 102, 102));
        jLabel70.setText("Exchanged Item");

        javax.swing.GroupLayout jPanel40Layout = new javax.swing.GroupLayout(jPanel40);
        jPanel40.setLayout(jPanel40Layout);
        jPanel40Layout.setHorizontalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel40Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 781, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addGap(430, 430, 430)
                .addComponent(jLabel70)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel40Layout.setVerticalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel40Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel70)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel40Layout.createSequentialGroup()
                        .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel40Layout.createSequentialGroup()
                        .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(148, 148, 148)))
                .addComponent(jPanel41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel39Layout = new javax.swing.GroupLayout(jPanel39);
        jPanel39.setLayout(jPanel39Layout);
        jPanel39Layout.setHorizontalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel39Layout.setVerticalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("", jPanel39);

        jTabbedPane1.setSelectedIndex(11);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1063, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 647, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(kGradientPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(kGradientPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void kButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton1ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_kButton1ActionPerformed

    private void kButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton2ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_kButton2ActionPerformed

    private void empActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(3);
    }//GEN-LAST:event_empActionPerformed

    private void kButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton7ActionPerformed
        // TODO add your handling code here:
        
           
       SignUp ur = new SignUp();
        ur.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_kButton7ActionPerformed

    private void kButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton5ActionPerformed
        // TODO add your handling code here:
        
        jTabbedPane1.setSelectedIndex(4);
        
//          GRN1 ur = new GRN1();
//                    ur.setVisible(true);
//                    this.dispose();
    }//GEN-LAST:event_kButton5ActionPerformed

    private void kButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton6ActionPerformed
        // TODO add your handling code here:
         jTabbedPane1.setSelectedIndex(9);
       
    }//GEN-LAST:event_kButton6ActionPerformed

    private void kButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton4ActionPerformed
        // TODO add your handling code here:
         jTabbedPane1.setSelectedIndex(5);
    }//GEN-LAST:event_kButton4ActionPerformed

    private void kButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton8ActionPerformed
        // TODO add your handling code here:
           jTabbedPane1.setSelectedIndex(6);
    }//GEN-LAST:event_kButton8ActionPerformed

    private void kButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton9ActionPerformed
        // TODO add your handling code here:
          jTabbedPane1.setSelectedIndex(7);
    }//GEN-LAST:event_kButton9ActionPerformed

    private void jButton30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton30ActionPerformed
        // TODO add your handling code here:

        jComboBox15.setSelectedIndex(0);
        jComboBox16.setSelectedIndex(0);
        jComboBox17.setSelectedIndex(0);
        jTextField32.setText("");
        dateChooserCombo1.setDateFormat(null);

        loadStock();
    }//GEN-LAST:event_jButton30ActionPerformed

    private void jButton29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton29ActionPerformed
        // TODO add your handling code here:

        String newPrice = jTextField32.getText();
        String buyingPrice = jLabel131.getText();
        int selectedRow = jTable9.getSelectedRow();

        if(selectedRow==-1) {
            JOptionPane.showMessageDialog(this, "Please select a stock","Warning",JOptionPane.WARNING_MESSAGE);
        }
        else if(!Pattern.compile("(0)|([1-9][0-9]*)|(([1-9][0-9]*)[.]([0]*[1-9][0-9]*))|([0][.]([0]*[1-9][0-9]*))").matcher(newPrice).matches()) {
            JOptionPane.showMessageDialog(this, "Invalid Selling Price", "Warning", JOptionPane.WARNING_MESSAGE);
        }else {

            String stock_id = jTable9.getValueAt(jTable9.getSelectedRow(),0).toString();

            if(Double.parseDouble(newPrice)<Double.parseDouble(buyingPrice)){
                int x = JOptionPane.showConfirmDialog(this, "New price < Buying Price, Do you want to Continue", "Warning", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

                if(x==JOptionPane.YES_NO_OPTION){
                    try {
                        MySql.iud("UPDATE `stock` SET `selling_price`='"+newPrice+"' WHERE `id`='"+stock_id+"'");
                    } catch (Exception ex) {
                        Logger.getLogger(Stock.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }else {
                try {
                    MySql.iud("UPDATE `stock` SET `selling_price`='"+newPrice+"' WHERE `id`='"+stock_id+"'");
                } catch (Exception ex) {
                    Logger.getLogger(Stock.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            //reset();
        }
    }//GEN-LAST:event_jButton29ActionPerformed

    private void jTable9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable9MouseClicked
        // TODO add your handling code here:
        int selectedRow = jTable9.getSelectedRow();
        if(selectedRow!=-1) {

            String buying_price = jTable9.getValueAt(selectedRow, 6).toString();
            jLabel131.setText(buying_price);
        }
    }//GEN-LAST:event_jTable9MouseClicked

    private void jTable8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable8MouseClicked
        // TODO add your handling code here:

        if(evt.getClickCount() == 1){
            int r = jTable8.getSelectedRow();

            if (r== -1) {
                JOptionPane.showMessageDialog(this, "Please select a Jewellery","Warning",JOptionPane.WARNING_MESSAGE);
            } else {

                String name = jTable8.getValueAt(r, 1).toString();
                String u_name = jTable8.getValueAt(r, 2).toString();
                String emaill = jTable8.getValueAt(r, 3).toString();
                String passcode = jTable8.getValueAt(r, 4).toString();
                String e_category = jTable8.getValueAt(r, 5).toString();

                jTextField29.setText(name);
                jTextField30.setText(u_name);
                jTextField31.setText(emaill);
                jPasswordField1.setText(passcode);
                jComboBox14.setSelectedItem(e_category);
                jButton27.setEnabled(false);

            }

        }
    }//GEN-LAST:event_jTable8MouseClicked

    private void jButton28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton28ActionPerformed
        // TODO add your handling code here:

        int r = jTable8.getSelectedRow();

        String id = jTable8.getValueAt(r, 0).toString();
        String Name = jTextField29.getText();
        String u_name  = jTextField30.getText();
        String Emaill = jTextField31.getText();
        String password = jPasswordField1.getText();
        String e_cate = jComboBox14.getSelectedItem().toString();

        if(Name.isEmpty()){
            JOptionPane.showMessageDialog(this, "Please Select  a Row you want to update from the table", "warning", JOptionPane.WARNING_MESSAGE);
        }else if(u_name.isEmpty()){
            JOptionPane.showMessageDialog(this, "Please Enter User Name", "warning", JOptionPane.WARNING_MESSAGE);
        }else if(Emaill.isEmpty()){
            JOptionPane.showMessageDialog(this, "Please Enter Emaill", "warning", JOptionPane.WARNING_MESSAGE);
        }else if(password.isEmpty()){
            JOptionPane.showMessageDialog(this, "Please Enter Password", "warning", JOptionPane.WARNING_MESSAGE);
        }else if(e_cate.isEmpty()){
            JOptionPane.showMessageDialog(this, "Please Select a employee Category", "warning", JOptionPane.WARNING_MESSAGE);
        }else{

            try{

                ResultSet rs1 = MySql.search("SELECT `id` FROM `emp_category` WHERE `name` = '" + e_cate + "'");
                rs1.next();

                String emp_id = rs1.getString("id");

                MySql.iud("Update owner set name='"+Name+"',user_name='"+u_name+"',emaill='"+Emaill+"',passcode='"+password+"',emp_category_id='"+ Integer.parseInt(emp_id) +"' where id='"+id+"';");

                resetowner();
                loadowner();

                JOptionPane.showMessageDialog(this, "Owner status updated", "Success",JOptionPane.INFORMATION_MESSAGE);
                jButton27.setEnabled(true);
            }catch(Exception e){
                e.printStackTrace();
            }

        }
    }//GEN-LAST:event_jButton28ActionPerformed

    private void jButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton27ActionPerformed
        // TODO add your handling code here:

        String name = jTextField29.getText();
        String u_name = jTextField30.getText();
        String Emaill = jTextField31.getText();
        String passcode = jPasswordField1.getText();
        String ecat = jComboBox14.getSelectedItem().toString();

        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter  Name", "warning", JOptionPane.WARNING_MESSAGE);
        } else if (u_name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter User Name", "warning", JOptionPane.WARNING_MESSAGE);
        } else if (passcode.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Password", "warning", JOptionPane.WARNING_MESSAGE);
        } else if (ecat.equals("Select")) {
            JOptionPane.showMessageDialog(this, "Please Select Employee Category", "warning", JOptionPane.WARNING_MESSAGE);
        } else {

            try {

                ResultSet rs1 = MySql.search("SELECT `id` FROM `emp_category` WHERE `name` = '" + ecat + "'");
                rs1.next();

                String e_id = rs1.getString("id");

                MySql.iud("INSERT INTO `owner`(`name`,`user_name`,`emaill`,`passcode`,`emp_category_id`) VALUES ('" + name + "','" + u_name + "','" + Emaill + "','" + passcode + "','" + Integer.parseInt(e_id) + "');");

                resetowner();
                loadowner();

                JOptionPane.showMessageDialog(this, "New Owner Regidterd", "Success", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }//GEN-LAST:event_jButton27ActionPerformed

    private void jComboBox14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox14ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        // TODO add your handling code here:

        company_branch_address ur = new company_branch_address();
        ur.setVisible(true);
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jComboBox13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox13ActionPerformed

    private void jComboBox12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox12ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        // TODO add your handling code here:

        String cno = jTextField27.getText();
        String b_name = jTextField28.getText();
        String com_name = jComboBox12.getSelectedItem().toString();
        String addre = jComboBox13.getSelectedItem().toString();

        if (cno.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Contact Number", "warning", JOptionPane.WARNING_MESSAGE);
        } else if (b_name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Branch Name", "warning", JOptionPane.WARNING_MESSAGE);
        } else if (com_name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Select Company Name", "warning", JOptionPane.WARNING_MESSAGE);
        } else if (addre.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Select Address", "warning", JOptionPane.WARNING_MESSAGE);
        } else {

            try {

                ResultSet rs1 = MySql.search("SELECT `id` FROM `company` WHERE `name` = '" + com_name + "'");
                rs1.next();

                ResultSet rs2 = MySql.search("SELECT `id` FROM `company_branch_address` WHERE `Address` = '" + addre + "'");
                rs2.next();

                String com_id = rs1.getString("id");
                String addre_id = rs2.getString("id");

                MySql.iud("INSERT INTO `company_branch`(`branch_contact_number`,`name`,`company_id`,`company_branch_address_id`) VALUES ('" + cno + "','" + b_name + "'," + Integer.parseInt(com_id) + "," + Integer.parseInt(addre_id) + ");");

                jTextField27.setText("");
                jTextField28.setText("");
                jComboBox12.setSelectedIndex(0);
                jComboBox13.setSelectedIndex(0);
                jTextField27.grabFocus();

                loadbranches();

                JOptionPane.showMessageDialog(this, "New User Acoount Regidterd", "Success", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jTextField28KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField28KeyTyped
        // TODO add your handling code here:

        char m = evt.getKeyChar();

        if(Character.isLetter(m)||Character.isWhitespace(m)||Character.isISOControl(m)){

            jTextField28.setEditable(true);
        }else{

            jTextField28.setEditable(false);
        }
    }//GEN-LAST:event_jTextField28KeyTyped

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        // TODO add your handling code here:

        // Company_Registration cr = new Company_Registration(this, true);
        //cr.setVisible(true);
        Company_Registration ur = new Company_Registration();
        ur.setVisible(true);
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jTextField27KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField27KeyTyped
        // TODO add your handling code here:

        System.out.println("1");
        String mobile = jTextField27.getText();
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
    }//GEN-LAST:event_jTextField27KeyTyped

    private void jTextField27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField27ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField27ActionPerformed

    private void jTextField26KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField26KeyReleased
        // TODO add your handling code here:

        String text = jTextField26.getText();
        loadjewellery(text);
    }//GEN-LAST:event_jTextField26KeyReleased

    private void jTextField26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField26ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField26ActionPerformed

    private void jTable6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable6MouseClicked
        // TODO add your handling code here:
        //        try {
            if (evt.getClickCount() == 1) {
                int r = jTable6.getSelectedRow();

                if (r == -1) {
                    JOptionPane.showMessageDialog(this, "Please select a Jewellery", "Warning", JOptionPane.WARNING_MESSAGE);
                } else {
                    String name = jTable6.getValueAt(r, 1).toString();
                    String car_no = jTable6.getValueAt(r, 2).toString();
                    String supplier = jTable6.getValueAt(r, 3).toString();
                    String j_category = jTable6.getValueAt(r, 4).toString();
                    String material = jTable6.getValueAt(r, 5).toString();

                    jTextField11.setText(name);
                    jTextField25.setText(car_no);
                    jComboBox10.setSelectedItem(supplier);
                    jComboBox11.setSelectedItem(j_category);
                    jComboBox5.setSelectedItem(material);
                    jButton1.setEnabled(false);
                }

            }

            //            if (evt.getClickCount() == 2) {
                //
                //                int r = jTable1.getSelectedRow();
                //                if (r == -1) {
                    //                    System.out.println("ok");
                    //                    JOptionPane.showMessageDialog(this, "Please select a branch", "Warning", JOptionPane.WARNING_MESSAGE);
                    //                } else {
                    //
                    //                    if (invoice != null) {
                        //
                        //                        String pid = jTable1.getValueAt(r, 0).toString();
                        //                        String pname = jTable1.getValueAt(r, 1).toString();
                        //                        String brand = jTable1.getValueAt(r, 2).toString();
                        //                        String category = jTable1.getValueAt(r, 3).toString();
                        //
                        //                        invoice.jLabel10.setText(pid);
                        //                        invoice.jLabel12.setText(pname);
                        //                        invoice.jLabel14.setText(brand);
                        //                        invoice.jLabel16.setText(category);
                        //
                        //                        invoice.jTextField1.grabFocus();
                        //
                        //                        this.dispose();
                        //
                        //                    }
                    //
                    //                }
                //            }
            //            if (evt.getClickCount() == 2) {
                //
                //                int r = jTable1.getSelectedRow();
                //                if (r == -1) {
                    //                    JOptionPane.showMessageDialog(this, "Please select a branch", "Warning", JOptionPane.WARNING_MESSAGE);
                    //                } else {
                    //
                    //                    String pid = jTable1.getValueAt(r, 0).toString();
                    //                    String pname = jTable1.getValueAt(r, 1).toString();
                    //                    String brand = jTable1.getValueAt(r, 2).toString();
                    //                    String category = jTable1.getValueAt(r, 4).toString();
                    //
                    //                    grn.jLabel10.setText(pid);
                    //                    grn.jLabel12.setText(pname);
                    //                    grn.jLabel14.setText(brand);
                    //                    grn.jLabel16.setText(category);
                    //
                    //                    grn.jTextField1.grabFocus();
                    //
                    //                    this.dispose();
                    //
                    //                }
                //
                //            }

            //        } catch (java.lang.NullPointerException e) {
            //        }catch(Exception ex){
            //            ex.printStackTrace();
            //        }

        /* if (evt.getClickCount() == 2) {
            int r = jTable1.getSelectedRow();

            if (r == -1) {
                JOptionPane.showMessageDialog(this, "Please select a branch", "Warning", JOptionPane.WARNING_MESSAGE);
            } else {
                if (grn != null) {

                    String id = jTable1.getValueAt(r, 0).toString();
                    String name = jTable1.getValueAt(r, 1).toString();

                    grn.lbel1.setText(id);
                    grn.lbel2.setText(name);

                    //      grn.jButton1.setText("Update Supplier");
                    //  grn.jbutton1.setEnabled(false);

                    this.dispose();

                }
            }
        }*/
    }//GEN-LAST:event_jTable6MouseClicked

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        // TODO add your handling code here:

        int r = jTable6.getSelectedRow();

        String id = jTable6.getValueAt(r, 0).toString();

        String J_Name = jTextField11.getText();
        String Car_no = jTextField25.getText();
        String supplier = jComboBox10.getSelectedItem().toString();
        String j_category = jComboBox11.getSelectedItem().toString();
        String material = jComboBox5.getSelectedItem().toString();

        if (J_Name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Select  a Row you want to update from the table", "warning", JOptionPane.WARNING_MESSAGE);
        } else if (Car_no.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Caret Number", "warning", JOptionPane.WARNING_MESSAGE);
        } else if (supplier.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Select a Supplier", "warning", JOptionPane.WARNING_MESSAGE);
        } else if (j_category.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Select a Jewellery Category", "warning", JOptionPane.WARNING_MESSAGE);
        } else if (material.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Select a Jewellery Material", "warning", JOptionPane.WARNING_MESSAGE);
        } else {

            try {

                ResultSet rs1 = MySql.search("SELECT `id` FROM `supplier` WHERE `name` = '" + supplier + "'");
                rs1.next();
                ResultSet rs2 = MySql.search("SELECT `id` FROM `category` WHERE `name` = '" + j_category + "'");
                rs2.next();
                ResultSet rs3 = MySql.search("SELECT `id` FROM `material` WHERE `name` = '" + material + "'");
                rs3.next();

                String sup_id = rs1.getString("id");
                String cat_id = rs2.getString("id");
                String mat_id = rs3.getString("id");

                MySql.iud("Update jwellary set name='" + J_Name + "',caret_no='" + Car_no + "',supplier_id='" + Integer.parseInt(sup_id) + "',category_id='" + Integer.parseInt(cat_id) + "',material_id='" + Integer.parseInt(mat_id) + "' where id='" + id + "';");

                resetaddjewelery();
                loadjewellery();

                JOptionPane.showMessageDialog(this, "User status updated", "Success", JOptionPane.INFORMATION_MESSAGE);
                jButton1.setEnabled(true);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        String name = jTextField11.getText();
        String c_no = jTextField25.getText();
        String sup = jComboBox10.getSelectedItem().toString();
        String cat = jComboBox11.getSelectedItem().toString();
        String mat = jComboBox5.getSelectedItem().toString();

        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter  Name", "warning", JOptionPane.WARNING_MESSAGE);
        } else if (c_no.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Caret No", "warning", JOptionPane.WARNING_MESSAGE);
        } else if (sup.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Select Supplier", "warning", JOptionPane.WARNING_MESSAGE);
        } else if (cat.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Select Category", "warning", JOptionPane.WARNING_MESSAGE);
        } else if (mat.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Select Material ", "warning", JOptionPane.WARNING_MESSAGE);
        } else {

            try {

                ResultSet rs1 = MySql.search("SELECT `id` FROM `supplier` WHERE `name` = '" + sup + "'");
                rs1.next();

                ResultSet rs2 = MySql.search("SELECT `id` FROM `category` WHERE `name` = '" + cat + "'");
                rs2.next();

                ResultSet rs3 = MySql.search("SELECT `id` FROM `material` WHERE `name` = '" + mat + "'");
                rs3.next();

                String sup_id = rs1.getString("id");
                String cat_id = rs2.getString("id");
                String mat_id = rs3.getString("id");

                MySql.iud("INSERT INTO `jwellary`(`name`,`caret_no`,`supplier_id`,`category_id`,`material_id`) VALUES ('" + name + "','" + c_no + "'," + Integer.parseInt(sup_id) + "," + Integer.parseInt(cat_id) + "," + Integer.parseInt(mat_id) + ");");

                resetaddjewelery();
                loadjewellery();

                JOptionPane.showMessageDialog(this, "New Jewellery added", "Success", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox11ActionPerformed

    private void jComboBox10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox10ActionPerformed

    private void jTextField25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField25ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField25ActionPerformed

    private void jComboBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox5ActionPerformed

    private void jTextField11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField11ActionPerformed

    private void jTextField24KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField24KeyReleased
        // TODO add your handling code here:
        String text = jTextField24.getText();
        loademployee(text);
    }//GEN-LAST:event_jTextField24KeyReleased

    private void jTable5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable5MouseClicked
        // TODO add your handling code here:

        if(evt.getClickCount() == 1){
            int r = jTable5.getSelectedRow();

            if (r== -1) {
                JOptionPane.showMessageDialog(this, "Please select a Jewellery","Warning",JOptionPane.WARNING_MESSAGE);
            } else {

                String name = jTable5.getValueAt(r, 1).toString();
                String u_name = jTable5.getValueAt(r, 2).toString();
                String password = jTable5.getValueAt(r, 3).toString();
                String nic = jTable5.getValueAt(r, 4).toString();
                String emaill = jTable5.getValueAt(r, 5).toString();
                String mobile_no = jTable5.getValueAt(r, 6).toString();
                String address = jTable5.getValueAt(r, 7).toString();
                String j_category = jTable5.getValueAt(r, 8).toString();
                String e_category = jTable5.getValueAt(r, 9).toString();

                jTextField18.setText(name);
                jTextField19.setText(u_name);
                jPasswordField2.setText(password);
                jTextField20.setText(nic);
                jTextField21.setText(emaill);
                jTextField22.setText(mobile_no);
                jTextField23.setText(address);
                jComboBox9.setSelectedItem(j_category);
                jComboBox8.setSelectedItem(e_category);
                addbutton.setEnabled(false);

            }

        }
    }//GEN-LAST:event_jTable5MouseClicked

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
        int r = jTable5.getSelectedRow();

        String id = jTable5.getValueAt(r, 0).toString();
        String e_Name = jTextField18.getText();
        String u_name  = jTextField19.getText();
        String password = jPasswordField2.getText();
        String nic  = jTextField20.getText();
        String emaill = jTextField21.getText();
        String m_no  = jTextField22.getText();
        String addr = jTextField23.getText();
        String j_cate = jComboBox9.getSelectedItem().toString();
        String e_cate = jComboBox8.getSelectedItem().toString();

        if(e_Name.isEmpty()){
            JOptionPane.showMessageDialog(this, "Please Select  a Row you want to update from the table", "warning", JOptionPane.WARNING_MESSAGE);
        }else if(u_name.isEmpty()){
            JOptionPane.showMessageDialog(this, "Please Enter User Name", "warning", JOptionPane.WARNING_MESSAGE);
        }else if(password.isEmpty()){
            JOptionPane.showMessageDialog(this, "Please Enter Password", "warning", JOptionPane.WARNING_MESSAGE);
        }else if(nic.isEmpty()){
            JOptionPane.showMessageDialog(this, "Please Enter NIC", "warning", JOptionPane.WARNING_MESSAGE);
        }else if(emaill.isEmpty()){
            JOptionPane.showMessageDialog(this, "Please Enter Emaill", "warning", JOptionPane.WARNING_MESSAGE);
        }else if(m_no.isEmpty()){
            JOptionPane.showMessageDialog(this, "Please Enter Mobile Number", "warning", JOptionPane.WARNING_MESSAGE);
        }else if(addr.isEmpty()){
            JOptionPane.showMessageDialog(this, "Please Enter Address", "warning", JOptionPane.WARNING_MESSAGE);
        }else if(j_cate.isEmpty()){
            JOptionPane.showMessageDialog(this, "Please Select a Jewellery Category", "warning", JOptionPane.WARNING_MESSAGE);
        }else if(e_cate.isEmpty()){
            JOptionPane.showMessageDialog(this, "Please Select a employee Category", "warning", JOptionPane.WARNING_MESSAGE);
        }else{

            try{

                ResultSet rs1 = MySql.search("SELECT `id` FROM `category` WHERE `name` = '" + j_cate + "'");
                rs1.next();
                ResultSet rs2 = MySql.search("SELECT `id` FROM `emp_category` WHERE `name` = '" + e_cate + "'");
                rs2.next();

                String cate_id = rs1.getString("id");
                String emp_id = rs2.getString("id");

                MySql.iud("Update employee set name='"+e_Name+"',user_name='"+u_name+"',password='"+password+"',NIC='"+nic+"',emaill='"+emaill+"',Contact_No='"+m_no+"',Address='"+addr+"',category_id='"+ Integer.parseInt(cate_id) +"',emp_category_id='"+ Integer.parseInt(emp_id) +"' where id='"+id+"';");

                resetemployee();
                loademployee();

                JOptionPane.showMessageDialog(this, "User status updated", "Success",JOptionPane.INFORMATION_MESSAGE);
                addbutton.setEnabled(true);
            }catch(Exception e){
                e.printStackTrace();
            }

        }
    }//GEN-LAST:event_jButton14ActionPerformed

    private void addbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addbuttonActionPerformed
        // TODO add your handling code here:

        String ename = jTextField18.getText();
        String u_name = jTextField19.getText();
        String password = jPasswordField2.getText();
        String nic = jTextField20.getText();
        String Emaill = jTextField21.getText();
        String cont_no = jTextField22.getText();
        String address = jTextField23.getText();
        String jcate = jComboBox9.getSelectedItem().toString();
        String ecat = jComboBox8.getSelectedItem().toString();

        if (ename.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter  Name", "warning", JOptionPane.WARNING_MESSAGE);
        } else if (u_name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter User Name", "warning", JOptionPane.WARNING_MESSAGE);
        } else if (password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Password", "warning", JOptionPane.WARNING_MESSAGE);
        } else if (nic.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter NIC", "warning", JOptionPane.WARNING_MESSAGE);
        } else if (Emaill.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Emaill Address", "warning", JOptionPane.WARNING_MESSAGE);
        } else if (cont_no.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Contact Number", "warning", JOptionPane.WARNING_MESSAGE);
        } else if (address.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Select jeweller Category", "warning", JOptionPane.WARNING_MESSAGE);
        } else if (jcate.equals("Select")) {
            JOptionPane.showMessageDialog(this, "Please Select type", "warning", JOptionPane.WARNING_MESSAGE);
        } else if (ecat.equals("Select")) {
            JOptionPane.showMessageDialog(this, "Please Select Employee Category", "warning", JOptionPane.WARNING_MESSAGE);
        } else {

            try {

                ResultSet rs1 = MySql.search("SELECT `id` FROM `category` WHERE `name` = '" + jcate + "'");
                rs1.next();

                ResultSet rs2 = MySql.search("SELECT `id` FROM `emp_category` WHERE `name` = '" + ecat + "'");
                rs2.next();

                String j_id = rs1.getString("id");
                String e_id = rs2.getString("id");

                MySql.iud("INSERT INTO `employee`(`name`,`user_name`,`password`,`NIC`,`emaill`,`Contact_No`,`Address`,`category_id`,`emp_category_id`) VALUES ('" + ename + "','" + u_name + "','" + password + "','" + nic + "','" + Emaill + "','" + cont_no + "','" + address + "'," + Integer.parseInt(j_id) + "," + Integer.parseInt(e_id) + ");");

                resetemployee();
                loademployee();

                JOptionPane.showMessageDialog(this, "New Employee Regidterd", "Success", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }//GEN-LAST:event_addbuttonActionPerformed

    private void jTextField23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField23ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField23ActionPerformed

    private void jTextField22KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField22KeyTyped
        // TODO add your handling code here:

        System.out.println("1");
        String mobile = jTextField22.getText();
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
    }//GEN-LAST:event_jTextField22KeyTyped

    private void jTextField22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField22ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField22ActionPerformed

    private void jTextField20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField20ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField20ActionPerformed

    private void jTextField18KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField18KeyTyped
        // TODO add your handling code here:

        char m = evt.getKeyChar();

        if(Character.isLetter(m)||Character.isWhitespace(m)||Character.isISOControl(m)){

            jTextField1.setEditable(true);
        }else{

            jTextField1.setEditable(false);
        }
    }//GEN-LAST:event_jTextField18KeyTyped

    private void jTextField18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField18ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField18ActionPerformed

    private void jTextField17KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField17KeyReleased
        // TODO add your handling code here:

        String text = jTextField17.getText();
        loadsupplier(text);
    }//GEN-LAST:event_jTextField17KeyReleased

    private void jTable4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable4MouseClicked
        // TODO add your handling code here:

        if(evt.getClickCount() == 1){
            int r = jTable4.getSelectedRow();

            if (r== -1) {
                JOptionPane.showMessageDialog(this, "Please select a Supplier","Warning",JOptionPane.WARNING_MESSAGE);
            } else {

                String name = jTable4.getValueAt(r, 1).toString();
                String c_no = jTable4.getValueAt(r, 2).toString();
                String emaill = jTable4.getValueAt(r, 3).toString();
                String co_branch = jTable4.getValueAt(r, 4).toString();

                jTextField14.setText(name);
                jTextField15.setText(c_no);
                jTextField16.setText(emaill);
                jComboBox7.setSelectedItem(co_branch);
                mmd.setEnabled(false);

            }

        }
    }//GEN-LAST:event_jTable4MouseClicked

    private void jPanel16KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel16KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel16KeyTyped

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int r = jTable4.getSelectedRow();

        String id = jTable4.getValueAt(r, 0).toString();
        String Name = jTextField14.getText();
        String C_no  = jTextField15.getText();
        String emaill_add  = jTextField16.getText();
        String Co_branch = jComboBox7.getSelectedItem().toString();

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
                mmd.setEnabled(true);
            }catch(Exception e){
                e.printStackTrace();
            }

        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void mmdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mmdActionPerformed
        // TODO add your handling code here:

        String name = jTextField14.getText();
        String contact_no = jTextField15.getText();
        String emaill = jTextField16.getText();
        String co_branch = jComboBox7.getSelectedItem().toString();

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
    }//GEN-LAST:event_mmdActionPerformed

    private void jTextField16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField16ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField16ActionPerformed

    private void jTextField15KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField15KeyTyped
        // TODO add your handling code here:

        System.out.println("1");
        String mobile = jTextField15.getText();
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
    }//GEN-LAST:event_jTextField15KeyTyped

    private void jTextField14KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField14KeyTyped
        // TODO add your handling code here:
        char m = evt.getKeyChar();

        if(Character.isLetter(m)||Character.isWhitespace(m)||Character.isISOControl(m)){

            jTextField14.setEditable(true);
        }else{

            jTextField14.setEditable(false);
        }
    }//GEN-LAST:event_jTextField14KeyTyped

    private void jTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseClicked
        // TODO add your handling code here:

        if (evt.getClickCount() == 1) {
            int r = jTable3.getSelectedRow();

            if (r == -1) {
                JOptionPane.showMessageDialog(this, "Please select a Supplier", "Warning", JOptionPane.WARNING_MESSAGE);
            } else {

                String fname = jTable3.getValueAt(r, 1).toString();
                String lname = jTable3.getValueAt(r, 2).toString();
                String cno = jTable3.getValueAt(r, 3).toString();
                String city = jTable3.getValueAt(r, 4).toString();

                jTextField9.setText(fname);
                jTextField10.setText(lname);
                jTextField12.setText(cno);
                jComboBox6.setSelectedItem(city);

            }

        }
    }//GEN-LAST:event_jTable3MouseClicked

    private void jTextField13KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField13KeyReleased
        // TODO add your handling code here:
        String text = jTextField13.getText();
        loadcustomer(text);
    }//GEN-LAST:event_jTextField13KeyReleased

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:

        //        int selectedRow = jTable3.getSelectedRow();
        //
        //        if (selectedRow == -1) {
            //            JOptionPane.showMessageDialog(this, "Please select user", "Warning", JOptionPane.WARNING_MESSAGE);
            //        } else {
            //
            //            try {
                //                String id = jTable3.getValueAt(selectedRow, 0).toString();
                //                String currentStatus = jTable3.getValueAt(selectedRow, 8).toString();
                //
                //                int status;
                //
                //                if (currentStatus.equals("Active")) {
                    //                    status = 2;
                    //                } else {
                    //                    status = 1;
                    //                }
                //
                //                MySql.iud("UPDATE `user` SET `user_status_id`=" + status + " WHERE `id`=" + Integer.parseInt(id) + "");
                //
                //                loadcustomer();
                //
                //                JOptionPane.showMessageDialog(this, "User status updated", "Success", JOptionPane.INFORMATION_MESSAGE);
                //            } catch (Exception e) {
                //                e.printStackTrace();
                //            }
            //
            //

            int r = jTable3.getSelectedRow();

            String id = jTable3.getValueAt(r, 0).toString();

            String f_Name = jTextField9.getText();
            String l_Name = jTextField10.getText();
            String cno = jTextField12.getText();
            String city = jComboBox6.getSelectedItem().toString();

            if (f_Name.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please Select  a Row you want to update from the table", "warning", JOptionPane.WARNING_MESSAGE);
            } else if (l_Name.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please Enter last Number", "warning", JOptionPane.WARNING_MESSAGE);
            } else if (cno.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please  Enter a Mobile Number", "warning", JOptionPane.WARNING_MESSAGE);
            } else if (city.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please Select a City", "warning", JOptionPane.WARNING_MESSAGE);
            } else {

                try {

                    ResultSet rs1 = MySql.search("SELECT `id` FROM `city` WHERE `name` = '" + city + "'");
                    rs1.next();

                    String city_id = rs1.getString("id");

                    MySql.iud("Update user set first_name='" + f_Name + "',last_name='" + l_Name + "',contact_number='" + cno + "',city_id='" + Integer.parseInt(city_id) + "' where id='" + id + "';");

                    resetFields();
                    loadcustomer();

                    JOptionPane.showMessageDialog(this, "User status updated", "Success", JOptionPane.INFORMATION_MESSAGE);
                    jButton9.setEnabled(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:

        String f_name = jTextField9.getText();
        String l_name = jTextField10.getText();
        String mobile = jTextField12.getText();
        String city = jComboBox6.getSelectedItem().toString();

        if (f_name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter First Name", "warning", JOptionPane.WARNING_MESSAGE);
        } else if (l_name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Last Name", "warning", JOptionPane.WARNING_MESSAGE);
        } else if (mobile.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Contact No", "warning", JOptionPane.WARNING_MESSAGE);
        } else if (city.equals("Select")) {
            JOptionPane.showMessageDialog(this, "Please Select city", "warning", JOptionPane.WARNING_MESSAGE);
        } else {

            try {

                ResultSet rs1 = MySql.search("SELECT `id` FROM `city` WHERE `name` = '" + city + "'");
                rs1.next();

                String city_id = rs1.getString("id");

                MySql.iud("INSERT INTO `user`(`first_name`,`last_name`,`contact_number`,`city_id`) VALUES ('" + f_name + "','" + l_name + "','" + mobile + "'," + Integer.parseInt(city_id) + ");");

                resetFields();
                loadcustomer();

                JOptionPane.showMessageDialog(this, "New User Acoount Regidterd", "Success", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jTextField12KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField12KeyTyped
        // TODO add your handling code here:

        System.out.println("1");
        String mobile = jTextField12.getText();
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
    }//GEN-LAST:event_jTextField12KeyTyped

    private void jTextField10KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField10KeyTyped
        // TODO add your handling code here:

        char m = evt.getKeyChar();

        if(Character.isLetter(m)|| Character.isISOControl(m)){

            jTextField10.setEditable(true);
        }else{

            jTextField10.setEditable(false);
        }
    }//GEN-LAST:event_jTextField10KeyTyped

    private void jTextField10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField10ActionPerformed

    private void jTextField9KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField9KeyTyped
        // TODO add your handling code here:
        char m = evt.getKeyChar();

        if(Character.isLetter(m)||Character.isISOControl(m)){

            jTextField9.setEditable(true);
        }else{

            jTextField9.setEditable(false);
        }
    }//GEN-LAST:event_jTextField9KeyTyped

    private void jTextField9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField9ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    private void kButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton3ActionPerformed
        // TODO add your handling code here:
        GRN1 ur = new GRN1();
        ur.setVisible(true);
    }//GEN-LAST:event_kButton3ActionPerformed

    private void kButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton10ActionPerformed
        // TODO add your handling code here:
        Invoice ur = new Invoice();
        ur.setVisible(true);
    }//GEN-LAST:event_kButton10ActionPerformed

    private void kButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton11ActionPerformed
        // TODO add your handling code here:
        stock_report ur = new stock_report();
        ur.setVisible(true);
    }//GEN-LAST:event_kButton11ActionPerformed

    private void kButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton12ActionPerformed
        // TODO add your handling code here:
         Employee_report ur = new Employee_report();
         ur.setVisible(true);
        //  this.dispose();
    }//GEN-LAST:event_kButton12ActionPerformed

    private void kButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton13ActionPerformed
        // TODO add your handling code here:
         Supplier_Report ur = new Supplier_Report();
         ur.setVisible(true);
        //this.dispose();
    }//GEN-LAST:event_kButton13ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
           
                   city ur = new city();
                   ur.setVisible(true);
//                   this.dispose();
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
         material ur = new material();
         ur.setVisible(true);
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        // TODO add your handling code here:
        jwellery_cate ur = new jwellery_cate();
        ur.setVisible(true);
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:

        Date d = jDateChooser1.getDate();

        String NIC = jTextField33.getText();
        String JC = jComboBox19.getSelectedItem().toString();
        String jname = jComboBox18.getSelectedItem().toString();

        if (d == null) {
            JOptionPane.showMessageDialog(this, "Please Select a Date", "warning", JOptionPane.WARNING_MESSAGE);
        } else if (d.after(new Date())) {
            JOptionPane.showMessageDialog(this, "Invalid MFD", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (NIC.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter NIC", "warning", JOptionPane.WARNING_MESSAGE);
        } else if (jname.equals("Select")) {
            JOptionPane.showMessageDialog(this, "Please Select Jwellery", "warning", JOptionPane.WARNING_MESSAGE);
        } else if (JC.equals("Select")) {
            JOptionPane.showMessageDialog(this, "Please Select  Category", "warning", JOptionPane.WARNING_MESSAGE);
        } else {

            SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
            String dNow = sdf2.format(new Date());

            try {

                ResultSet rs1 = MySql.search("SELECT `id` FROM `category` WHERE `name` = '" + JC + "'");
                rs1.next();

                ResultSet rs2 = MySql.search("SELECT `id` FROM `jwellary` WHERE `name` = '" + jname + "'");
                rs2.next();

                String j_id = rs1.getString("id");
                String e_id = rs2.getString("id");

                MySql.iud("INSERT INTO `exchange_item`(`Date`,`NIC`,`jwellary_id`,`category_id`) VALUES ('" + dNow + "','" + NIC + "'," + Integer.parseInt(e_id) + "," + Integer.parseInt(j_id) + ");");

                loadexchange();
                // jDateChooser1.setDate();
                jTextField33.setText("");
                jComboBox18.setSelectedIndex(0);
                jComboBox19.setSelectedIndex(0);

                JOptionPane.showMessageDialog(this, "New Employee Regidterd", "Success", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        // TODO add your handling code here:

        int r = jTable10.getSelectedRow();

        String id = jTable10.getValueAt(r, 0).toString();

        Date d = jDateChooser1.getDate();

        String NIC = jTextField33.getText();
        String JC = jComboBox19.getSelectedItem().toString();
        String jname = jComboBox18.getSelectedItem().toString();

        if (d == null) {
            JOptionPane.showMessageDialog(this, "Please Select a Date", "warning", JOptionPane.WARNING_MESSAGE);
        } else if (d.after(new Date())) {
            JOptionPane.showMessageDialog(this, "Invalid MFD", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (NIC.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter NIC", "warning", JOptionPane.WARNING_MESSAGE);
        } else if (jname.equals("Select")) {
            JOptionPane.showMessageDialog(this, "Please Select Jwellery", "warning", JOptionPane.WARNING_MESSAGE);
        } else if (JC.equals("Select")) {
            JOptionPane.showMessageDialog(this, "Please Select  Category", "warning", JOptionPane.WARNING_MESSAGE);
        } else {

            SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
            String dNow = sdf2.format(new Date());

            try {

                ResultSet rs1 = MySql.search("SELECT `id` FROM `category` WHERE `name` = '" + JC + "'");
                rs1.next();

                ResultSet rs2 = MySql.search("SELECT `id` FROM `jwellary` WHERE `name` = '" + jname + "'");
                rs2.next();

                String j_id = rs1.getString("id");
                String e_id = rs2.getString("id");

                MySql.iud("Update exchange_item set Date='" + dNow + "',NIC='" + NIC + "',jwellary_id='" + Integer.parseInt(e_id) + "',category_id='" + Integer.parseInt(j_id) + "' where id='" + id + "';");

                loadexchange();
                // jDateChooser1.setDate();
                jTextField33.setText("");
                jComboBox18.setSelectedIndex(0);
                jComboBox19.setSelectedIndex(0);

                JOptionPane.showMessageDialog(this, "Update Sucsses", "Success", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jTable10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable10MouseClicked
        // TODO add your handling code here:

        if(evt.getClickCount() == 1){
            int r = jTable10.getSelectedRow();

            if (r== -1) {
                JOptionPane.showMessageDialog(this, "Please select a Jewellery","Warning",JOptionPane.WARNING_MESSAGE);
            } else {

                String Date = jTable10.getValueAt(r, 1).toString();
                String NIC = jTable10.getValueAt(r, 2).toString();
                String j_name = jTable10.getValueAt(r, 3).toString();
                String category = jTable10.getValueAt(r, 4).toString();

                jTextField33.setText(NIC);
                //                    jDateChooser1.setDate();
                jComboBox19.setSelectedItem(category);
                jComboBox18.setSelectedItem(j_name);
                jButton12.setEnabled(false);

            }

        }
    }//GEN-LAST:event_jTable10MouseClicked

    private void kButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton14ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(11);
    }//GEN-LAST:event_kButton14ActionPerformed

    private void jTextField11KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField11KeyTyped
        // TODO add your handling code here:
        
        char m = evt.getKeyChar();

        if(Character.isLetter(m)||Character.isWhitespace(m)||Character.isISOControl(m)){

            jTextField11.setEditable(true);
        }else{

            jTextField11.setEditable(false);
        }
                    
    }//GEN-LAST:event_jTextField11KeyTyped

    private void jTextField29KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField29KeyTyped
        // TODO add your handling code here:
         char m = evt.getKeyChar();

        if(Character.isLetter(m)||Character.isWhitespace(m)||Character.isISOControl(m)){

            jTextField29.setEditable(true);
        }else{

            jTextField29.setEditable(false);
        }
    }//GEN-LAST:event_jTextField29KeyTyped

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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addbutton;
    private datechooser.beans.DateChooserCombo dateChooserCombo1;
    public com.k33ptoo.components.KButton emp;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    public javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox10;
    private javax.swing.JComboBox<String> jComboBox11;
    private javax.swing.JComboBox<String> jComboBox12;
    private javax.swing.JComboBox<String> jComboBox13;
    private javax.swing.JComboBox<String> jComboBox14;
    private javax.swing.JComboBox<String> jComboBox15;
    private javax.swing.JComboBox<String> jComboBox16;
    private javax.swing.JComboBox<String> jComboBox17;
    private javax.swing.JComboBox<String> jComboBox18;
    private javax.swing.JComboBox<String> jComboBox19;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JComboBox<String> jComboBox6;
    private javax.swing.JComboBox<String> jComboBox7;
    private javax.swing.JComboBox<String> jComboBox8;
    private javax.swing.JComboBox<String> jComboBox9;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel122;
    private javax.swing.JLabel jLabel123;
    private javax.swing.JLabel jLabel124;
    private javax.swing.JLabel jLabel125;
    private javax.swing.JLabel jLabel126;
    private javax.swing.JLabel jLabel127;
    private javax.swing.JLabel jLabel128;
    private javax.swing.JLabel jLabel129;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel130;
    private javax.swing.JLabel jLabel131;
    private javax.swing.JLabel jLabel132;
    private javax.swing.JLabel jLabel133;
    private javax.swing.JLabel jLabel134;
    private javax.swing.JLabel jLabel135;
    private javax.swing.JLabel jLabel136;
    private javax.swing.JLabel jLabel137;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable10;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JTable jTable6;
    private javax.swing.JTable jTable7;
    private javax.swing.JTable jTable8;
    private javax.swing.JTable jTable9;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField20;
    private javax.swing.JTextField jTextField21;
    private javax.swing.JTextField jTextField22;
    private javax.swing.JTextField jTextField23;
    private javax.swing.JTextField jTextField24;
    private javax.swing.JTextField jTextField25;
    private javax.swing.JTextField jTextField26;
    private javax.swing.JTextField jTextField27;
    private javax.swing.JTextField jTextField28;
    private javax.swing.JTextField jTextField29;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField30;
    private javax.swing.JTextField jTextField31;
    private javax.swing.JTextField jTextField32;
    private javax.swing.JTextField jTextField33;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    public com.k33ptoo.components.KButton kButton1;
    private com.k33ptoo.components.KButton kButton10;
    private com.k33ptoo.components.KButton kButton11;
    private com.k33ptoo.components.KButton kButton12;
    private com.k33ptoo.components.KButton kButton13;
    private com.k33ptoo.components.KButton kButton14;
    private com.k33ptoo.components.KButton kButton2;
    private com.k33ptoo.components.KButton kButton3;
    private com.k33ptoo.components.KButton kButton4;
    private com.k33ptoo.components.KButton kButton5;
    private com.k33ptoo.components.KButton kButton6;
    private com.k33ptoo.components.KButton kButton7;
    private com.k33ptoo.components.KButton kButton8;
    public com.k33ptoo.components.KButton kButton9;
    private com.k33ptoo.components.KGradientPanel kGradientPanel1;
    private com.k33ptoo.components.KGradientPanel kGradientPanel2;
    private javax.swing.JButton mmd;
    private javax.swing.JLabel time;
    // End of variables declaration//GEN-END:variables


    public void time(){
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                
                while(true){
                    
                    Date d = new Date();
                    
                    SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a");
                    
                    String Date = sdf.format(d);
                    
                    time.setText(Date);
                    
                    try{
                        
                        Thread.sleep(1000);
                        
                    }catch (InterruptedException ex){
                        
                        
                    }
                    
                    
                }
               
            }
        });
        t.start();
    }
}
