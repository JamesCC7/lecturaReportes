/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeceo.views;

import com.ceodeceo.utils.isDateFormat;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

public class Respaldo extends javax.swing.JFrame {

    double energia = 0, potencia = 0, totalEnergia = 0, totalPotencia = 0,
            energiaDemandaMaxima = 0, reactivaMaxima = 0;
    DefaultTableModel modelo;

    public Respaldo() {
        initComponents();
        modelo = new DefaultTableModel();
        modelo.addColumn("kW a");
        modelo.addColumn("kW b");
        modelo.addColumn("kW c");
        modelo.addColumn("kVAR a");
        modelo.addColumn("kVAR b");
        modelo.addColumn("kVAR c");
        modelo.addColumn("--");

        this.tblDatos.setModel(modelo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnSeleccionar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDatos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel1.setText("LECTURA DE ARCHIVO");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 30, -1, -1));

        jLabel2.setText("Seleccionar archivo:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 80, -1, -1));

        btnSeleccionar.setText("Seleccionar...");
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });
        jPanel1.add(btnSeleccionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 80, 130, -1));

        tblDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblDatos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 770, 420));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 810, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        //Creacion del objeto JFileChooser
        JFileChooser fc = new JFileChooser();

        //Creamos el filtro para el tipo de texto a recibir
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.txt", "txt");

        //Indicamos el filtro a aplicar
        fc.setFileFilter(filter);

        //Seleccionar varios archivos
        fc.setMultiSelectionEnabled(true);

        //Guardamos la opcion seleccionada por el usuario
        int select = fc.showOpenDialog(this);

        //Si el usuario presiona aceptar
        if (select == JFileChooser.APPROVE_OPTION) {
            File archivo = fc.getSelectedFile();          //Selecciona un solo archivo

            //Object datos_archivo[] = null;
            String[] datos_ = new String[7];

            String linea = "", aux = "", nAux = "";
            Integer band = 0;
            
            //Vector que almacenara un solo registro
            String[] registro;
            isDateFormat dateFormat = new isDateFormat();

            try {
                FileReader fr = new FileReader(archivo);
                //File name = fc.getSelectedFile();
                System.out.println("Nombre del archivo: " + archivo.getName());
                BufferedReader br = new BufferedReader(fr);

                while ((linea = br.readLine()) != null) {

                    //Elimina todos los espacios en blanco en caso de existir mas de un espacio y lo
                    //define en un unico espacio
                    aux = linea.replaceAll(" +", " ");
                    registro = aux.split(" ");

                    if (dateFormat.isValid(registro[0]) && band == 0) {

                        band = 1;

                        nAux = registro[6].replaceAll(",", ".");
                        datos_[0] = nAux.replace(".", "");
                        
                        nAux = registro[7].replaceAll(",", ".");
                        datos_[1] = nAux.replace(".", "");
                        
                        nAux = registro[8].replaceAll(",", ".");
                        datos_[2] = nAux.replace(".", "");
                        
                        nAux = registro[9].replaceAll(",", ".");
                        datos_[3] = nAux.replace(".", "");
                        
                        nAux = registro[10].replaceAll(",", ".");
                        datos_[4] = nAux.replace(".", "");
                        
                        nAux = registro[11].replaceAll(",", ".");
                        datos_[5] = nAux.replace(".", "");
                        modelo.addRow(datos_);

                    } else {
                        if (dateFormat.isValid(registro[0]) && band == 1) {

                            nAux = registro[6].replaceAll(",", ".");
                        datos_[0] = nAux.replace(".", "");
                        
                        nAux = registro[7].replaceAll(",", ".");
                        datos_[1] = nAux.replace(".", "");
                        
                        nAux = registro[8].replaceAll(",", ".");
                        datos_[2] = nAux.replace(".", "");
                        
                        nAux = registro[9].replaceAll(",", ".");
                        datos_[3] = nAux.replace(".", "");
                        
                        nAux = registro[10].replaceAll(",", ".");
                        datos_[4] = nAux.replace(".", "");
                        
                        nAux = registro[11].replaceAll(",", ".");
                        datos_[5] = nAux.replace(".", "");
                            modelo.addRow(datos_);
                        }
                    }

                    //modelo.addRow(datos_);

                }

                JOptionPane.showMessageDialog(null, "Archivo leido correctamente");
            } catch (Exception e) {
            }

        }

    }//GEN-LAST:event_btnSeleccionarActionPerformed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Respaldo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Respaldo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Respaldo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Respaldo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Respaldo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDatos;
    // End of variables declaration//GEN-END:variables

    private void sumatoriasEnergiaPotencia(String[] registro) {
        double sumaEnergia = 0, sumaPotencia = 0;
        sumaEnergia = Double.parseDouble(registro[6]) + Double.parseDouble(registro[7]) + Double.parseDouble(registro[8]);
        sumaPotencia = Double.parseDouble(registro[9]) + Double.parseDouble(registro[10]) + Double.parseDouble(registro[11]);

        energia += sumaEnergia;
        potencia += sumaPotencia;

        if (sumaEnergia > energiaDemandaMaxima) {
            energiaDemandaMaxima = sumaEnergia;
        }

        if (sumaPotencia > reactivaMaxima) {
            reactivaMaxima = sumaEnergia;
        }
    }
}
