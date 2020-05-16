/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;


import javax.swing.*;
import javax.swing.JFrame;
/**
 *
 * @author PC
 */
public class ViewLogin extends JFrame {
    public JButton btnLoginAdmin = new JButton("Login Admin");
    public JButton btnLoginKaryawan = new JButton ("Login Karyawan");
    JLabel lblTitle = new JLabel ("SISTEM PENGGAJIAN KARYAWAN");
    
    public ViewLogin (){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setSize(400,400);
        setTitle("Halaman Login");
        
        add (lblTitle);
            lblTitle.setBounds(100,80,200,20);
        add (btnLoginAdmin);
            btnLoginAdmin.setBounds(100,120,200,20);
        add (btnLoginKaryawan);
            btnLoginKaryawan.setBounds(100,150,200,20);
 
}
    
    
    
}
