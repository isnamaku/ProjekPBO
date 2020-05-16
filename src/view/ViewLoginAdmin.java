/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author PC
 */

import javax.swing.*;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;


public class ViewLoginAdmin extends JFrame{
 
    
    public JButton btnMasukAdmin = new JButton("Login");
    public JButton btnKembaliAdmin = new JButton("Kembali");
    JLabel lblTitle = new JLabel ("Login Sebagai Admin");
    JLabel lblNik = new JLabel ("NIK ");
    JLabel lblPass = new JLabel ("Password");
    JTextField tfNik = new JTextField ();
    JTextField tfPass = new JTextField ();
    
    public ViewLoginAdmin (){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setSize(400,350);
        setTitle("Halaman Login Admin");
        
        add (lblTitle);
            lblTitle.setBounds(125,50,200,20);
        add (lblNik);
            lblNik.setBounds(70,110,50,20);
        add (tfNik);
            tfNik.setBounds(140,110,200,20);
        add (lblPass);
            lblPass.setBounds(70,150,110,20);    
        add (tfPass);
            tfPass.setBounds(140,150,200,20);
        add (btnMasukAdmin);
            btnMasukAdmin.setBounds(250,200,80,20);
        add (btnKembaliAdmin);
            btnKembaliAdmin.setBounds(250,240,80,20);
      
 
}

    public String getTfNik() {
        return tfNik.getText();
    }

    public String getTfPass() {
        return tfPass.getText();
    }

    
}

