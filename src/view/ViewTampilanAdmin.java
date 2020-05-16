/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;


import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author PC
 */
public class ViewTampilanAdmin extends JFrame {
    
    public JButton btnInputPanel = new JButton("Input Data Kariawan");
    public JButton btnLihatPanel = new JButton("Input Gaji");
    public JButton btnKembaliPanel = new JButton("Kembali");
    public ViewTampilanAdmin (){
        setTitle("Halaman Admin");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setSize(400, 150);
        
        add(btnLihatPanel);
        btnLihatPanel.setBounds(110, 55, 155, 20);
        add(btnInputPanel);
        btnInputPanel.setBounds(110, 25, 155, 20);
    }
}

//Android Junior
//Android Junior