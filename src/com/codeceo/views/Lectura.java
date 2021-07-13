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
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

public class Lectura extends javax.swing.JFrame {

    double energia = 0, potencia = 0, totalEnergia = 0, totalPotencia = 0,
            energiaDemandaMaxima = 0, reactivaMaxima = 0;
    String patronFormatoNumero = "###,###.###";
    DefaultTableModel modelo;
    String[][] matrizArchivos;
    String[][] matrizLecturas;
    ArrayList<String> arrFechas = new ArrayList();
    ArrayList<String> arrHoras = new ArrayList();

    File[] listaArchivos = null;
    DecimalFormat formatoNumero = new DecimalFormat(patronFormatoNumero);
    int dimLecturas = 0;
    int indLecturas = 0;
    int indFechas = 0;

    public Lectura() {
        initComponents();

        establecerModel();

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
        jPanel3 = new javax.swing.JPanel();
        jcbHora = new javax.swing.JComboBox<>();
        jcbFecha = new javax.swing.JComboBox<>();
        btnConsulta1 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        btnLimpiar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel1.setText("LECTURA DE ARCHIVO");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel2.setText("Seleccionar archivo:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 50, -1, -1));

        btnSeleccionar.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        btnSeleccionar.setText("Seleccionar...");
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });
        jPanel1.add(btnSeleccionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 50, 170, -1));

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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 100, 1013, 280));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Consulta"));

        jcbFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbFechaActionPerformed(evt);
            }
        });

        btnConsulta1.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        btnConsulta1.setText("Consultar demanda");
        btnConsulta1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsulta1ActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel14.setText("<html>FECHA DE <br>HORA:<html>");

        jLabel15.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel15.setText("<html>FECHA DE <br>CONSULTA:<html>");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jcbFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 234, Short.MAX_VALUE)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jcbHora, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(114, 114, 114))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnConsulta1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(339, 339, 339))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jcbHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcbFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(btnConsulta1)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, 1010, 190));

        btnLimpiar.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com.images/limpiar.png"))); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        jPanel1.add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 50, -1, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1065, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 605, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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

            listaArchivos = fc.getSelectedFiles();
            FileReader fr = null;
            BufferedReader br = null;

            int nArchivos = listaArchivos.length;
            matrizArchivos = new String[nArchivos][9];
            //////////////matrizLecturas = new String[60][8];

            String[] datos_fila = new String[9];

            String linea = "", auxRegistro = "";
            String fechaIni = "", fechaFin = "";
            Integer cantLecturas = 0, band = 0;

            //Vector que almacenara un solo registro
            String[] registro;

            isDateFormat dateFormat = new isDateFormat();

            try {
                System.out.println("Numero de archivos: " + nArchivos);

                for (int i = 0; i < nArchivos; i++) {
                    fr = new FileReader(listaArchivos[i]);
                    br = new BufferedReader(fr);

                    while ((linea = br.readLine()) != null) {

                        //Elimina todos los espacios en blanco definiendolo en un unico espacio
                        auxRegistro = linea.replaceAll(" +", " ");
                        registro = auxRegistro.split(" ");

                        //Determina si el registro ingresado comienza por una fecha
                        if (dateFormat.isValid(registro[0]) && band == 0) {
                            cantLecturas++;
                            band = 1;

                            //Establece la fecha inicial y fecho final
                            fechaIni = registro[0];
                            fechaFin = registro[0];

                            //Sumatoria Energia (kW a + kW b + kW c) y Potencia Reactiva (kVar a + kVar b + kVar c)
                            sumatoriasEnergiaPotencia(registro);

                            dimLecturas++;

                        } else {
                            if (dateFormat.isValid(registro[0]) && band == 1) {
                                cantLecturas++;

                                fechaFin = registro[0];

                                //Sumatoria Energia (kW a + kW b + kW c) y Potencia Reactiva (kVar a + kVar b + kVar c)
                                sumatoriasEnergiaPotencia(registro);

                                dimLecturas++;
                            }
                        }
                    }

                    datos_fila[0] = listaArchivos[i].getName();
                    datos_fila[1] = fechaIni + " - " + fechaFin;
                    datos_fila[2] = cantLecturas + " lecturas";
                    datos_fila[3] = formatoNumero.format(Double.parseDouble((energia / 4) + ""));
                    datos_fila[4] = formatoNumero.format(Double.parseDouble((potencia / 4) + ""));
                    datos_fila[5] = formatoNumero.format(Double.parseDouble(energiaDemandaMaxima + ""));
                    datos_fila[6] = formatoNumero.format(Double.parseDouble(reactivaMaxima + ""));
                    datos_fila[7] = "0";
                    datos_fila[8] = "0";

                    //Llenar matriz
                    matrizArchivos[i][0] = datos_fila[0];
                    matrizArchivos[i][1] = datos_fila[1];
                    matrizArchivos[i][2] = datos_fila[2];
                    matrizArchivos[i][3] = datos_fila[3];
                    matrizArchivos[i][4] = datos_fila[4];
                    matrizArchivos[i][5] = datos_fila[5];
                    matrizArchivos[i][6] = datos_fila[6];
                    matrizArchivos[i][7] = datos_fila[7];
                    matrizArchivos[i][8] = datos_fila[8];

                    modelo.addRow(datos_fila);

                    cantLecturas = band = 0;
                    fechaIni = fechaFin = "";
                    energia = 0;
                    potencia = 0;
                    energiaDemandaMaxima = 0;
                    reactivaMaxima = 0;
                }

                JOptionPane.showMessageDialog(null, "Archivo leido correctamente");
                cargarDatosComboBox();

            } catch (Exception e) {
            }

        }
    }//GEN-LAST:event_btnSeleccionarActionPerformed

    private void jcbFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbFechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbFechaActionPerformed

    private void btnConsulta1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsulta1ActionPerformed

        String fechaConsulta = (String) jcbFecha.getSelectedItem();
        String horaConsulta = (String) jcbHora.getSelectedItem();
        int archivosFila = matrizArchivos.length;
        int archivosColumna = matrizArchivos[0].length;
        int lecturasFila = matrizLecturas.length;
        int lecturasColumna = matrizLecturas[0].length;
        String[] datos_fila = new String[9];
        String[] registro;
        int indInical = 0, indFinal = 0;
        double demandaConsulta = 0, reactivaConsulta = 0;

        System.out.println("Lecturas: " + lecturasFila + " ... " + lecturasColumna);
        System.out.println("archivos: " + archivosFila + " ... " + archivosColumna);

        if (fechaConsulta != "" && horaConsulta != "") {
            //model = null;
            vaciarModel();

            for (int i = 0; i < archivosFila; i++) {
                registro = matrizArchivos[i][2].split(" ");
                indFinal += Integer.parseInt(registro[0]);

                datos_fila[0] = matrizArchivos[i][0];
                datos_fila[1] = matrizArchivos[i][1];
                datos_fila[2] = matrizArchivos[i][2];
                datos_fila[3] = matrizArchivos[i][3];
                datos_fila[4] = matrizArchivos[i][4];
                datos_fila[5] = matrizArchivos[i][5];
                datos_fila[6] = matrizArchivos[i][6];

                //Recorre la matriz lecturas
                for (int j = indInical; j < indFinal; j++) {

                    //Comparacion de lecturas con la hora y fecha
                    if (matrizLecturas[j][0].equals(fechaConsulta) && matrizLecturas[j][1].equals(horaConsulta)) {

                        demandaConsulta = Double.parseDouble(matrizLecturas[j][2]) + Double.parseDouble(matrizLecturas[j][3])
                                + Double.parseDouble(matrizLecturas[j][4]);
                        reactivaConsulta = Double.parseDouble(matrizLecturas[j][5]) + Double.parseDouble(matrizLecturas[j][6])
                                + Double.parseDouble(matrizLecturas[j][7]);
                    }
                }

                //formatoNumero.format(Double.parseDouble((energia / 4) + ""));
                // datos_fila[3] = formatoNumero.format(Double.parseDouble((energia / 4) + ""));
                matrizArchivos[i][7] = formatoNumero.format(demandaConsulta);
                matrizArchivos[i][8] = formatoNumero.format(reactivaConsulta);

                datos_fila[7] = formatoNumero.format(demandaConsulta);
                datos_fila[8] = formatoNumero.format(reactivaConsulta);

                modelo.addRow(datos_fila);

                demandaConsulta = reactivaConsulta = 0;
                indInical = indFinal;
            }

        } else {
            JOptionPane.showMessageDialog(null, "Es necesario cargar los archivos.");
        }

    }//GEN-LAST:event_btnConsulta1ActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        matrizArchivos = null;
        matrizLecturas = null;
        arrFechas = new ArrayList();
        arrHoras = new ArrayList();
        listaArchivos = null;
        jcbFecha = new JComboBox<>();
        jcbHora = new JComboBox<>();
        
        vaciarModel();
    }//GEN-LAST:event_btnLimpiarActionPerformed

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
            java.util.logging.Logger.getLogger(Lectura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Lectura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Lectura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Lectura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Lectura().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsulta1;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jcbFecha;
    private javax.swing.JComboBox<String> jcbHora;
    private javax.swing.JTable tblDatos;
    // End of variables declaration//GEN-END:variables

    private void sumatoriasEnergiaPotencia(String[] registro) {
        double sumaEnergia = 0, sumaPotencia = 0;
        String v1, v2, v3, aux1, aux2, aux3;
        v1 = registro[6].replaceAll(",", ".");
        aux1 = v1.replace(".", "");
        v2 = registro[7].replaceAll(",", ".");
        aux2 = v2.replace(".", "");
        v3 = registro[8].replaceAll(",", ".");
        aux3 = v3.replace(".", "");

        sumaEnergia = Double.parseDouble(aux1) + Double.parseDouble(aux2) + Double.parseDouble(aux3);

        v1 = registro[9].replaceAll(",", ".");
        aux1 = v1.replace(".", "");
        v2 = registro[10].replaceAll(",", ".");
        aux2 = v2.replace(".", "");
        v3 = registro[11].replaceAll(",", ".");
        aux3 = v3.replace(".", "");

        sumaPotencia = Double.parseDouble(aux1) + Double.parseDouble(aux2) + Double.parseDouble(aux3);

        energia += sumaEnergia;
        potencia += sumaPotencia;

        if (sumaEnergia > energiaDemandaMaxima) {
            energiaDemandaMaxima = sumaEnergia;
        }

        if (sumaPotencia > reactivaMaxima) {
            reactivaMaxima = sumaPotencia;
        }
    }

    private void registrarLecturas(String[] registro, int fila) {

        String fecha, hora, v1, v2, v3, v4, v5, v6;

        fecha = registro[0];
        hora = registro[1].substring(0, 8);
        v1 = registro[6].replaceAll(",", ".");
        v2 = registro[7].replaceAll(",", ".");
        v3 = registro[8].replaceAll(",", ".");
        v4 = registro[9].replaceAll(",", ".");
        v5 = registro[10].replaceAll(",", ".");
        v6 = registro[11].replaceAll(",", ".");

        //vectorFechas[fila] = fecha;
        //vectorHoras[fila] = hora;
        arrFechas.add(fecha);
        arrHoras.add(hora);
        matrizLecturas[fila][0] = fecha;
        matrizLecturas[fila][1] = hora;
        matrizLecturas[fila][2] = v1.replace(".", "");
        matrizLecturas[fila][3] = v2.replace(".", "");
        matrizLecturas[fila][4] = v3.replace(".", "");
        matrizLecturas[fila][5] = v4.replace(".", "");
        matrizLecturas[fila][6] = v5.replace(".", "");
        matrizLecturas[fila][7] = v6.replace(".", "");
    }

    private void cargarDatosComboBox() {

        int nArchivos = listaArchivos.length;

        matrizLecturas = new String[dimLecturas][8];

        String linea = "", auxRegistro = "";
        Integer band = 0;
        FileReader fr = null;
        BufferedReader br = null;

        //Vector que almacenara un solo registro
        String[] registro;

        isDateFormat dateFormat = new isDateFormat();

        try {

            for (int i = 0; i < nArchivos; i++) {
                fr = new FileReader(listaArchivos[i]);
                br = new BufferedReader(fr);

                while ((linea = br.readLine()) != null) {

                    //Elimina todos los espacios en blanco definiendolo en un unico espacio
                    auxRegistro = linea.replaceAll(" +", " ");
                    registro = auxRegistro.split(" ");

                    //Determina si el registro ingresado comienza por una fecha
                    if (dateFormat.isValid(registro[0]) && band == 0) {
                        band = 1;

                        //Llena la matriz con cada lecturas 
                        registrarLecturas(registro, indLecturas);
                        indLecturas++;

                    } else {
                        if (dateFormat.isValid(registro[0]) && band == 1) {

                            //Llena la matriz con cada lecturas 
                            registrarLecturas(registro, indLecturas);
                            indLecturas++;
                        }
                    }
                }
                band = 0;
            }

            generarDatosfecha();
            generarDatosHora();

            System.out.println("Proceso finalizado");
        } catch (Exception e) {
        }
    }

    private void generarDatosfecha() {
        //System.out.println("Vector fecha: ");
        String[] vector;

        Set<String> hasSet = new HashSet<String>(arrFechas);
        arrFechas.clear();
        arrFechas.addAll(hasSet);
        //for (String elem : arrFechas) {
        //    System.out.println(elem);
        //}
        vector = OrdenarElementosFechas(arrFechas);

        for (int i = 0; i < vector.length; i++) {
            jcbFecha.addItem(vector[i]);
        }
    }

    private void generarDatosHora() {

        String[] vector;
        Set<String> hasSet = new HashSet<String>(arrHoras);
        arrHoras.clear();
        arrHoras.addAll(hasSet);
        //for (String elem : arrHoras) {
        //    System.out.println(elem);
        //}
        vector = OrdenarElementosHora(arrHoras);
        for (int i = 0; i < vector.length; i++) {
            jcbHora.addItem(vector[i]);
        }

    }

    //private String[] OrdenarElementosFechas(ArrayList<String> array) {
    private String[] OrdenarElementosFechas(ArrayList<String> array) {
        int temp, cont = 0;
        String auxDia, aux;
        int indice = array.size();

        int[] vDia = new int[indice];
        String[] vFinal = new String[indice];

        for (String elem : array) {
            vFinal[cont] = elem;
            auxDia = elem.substring(0, 2);
            vDia[cont] = Integer.parseInt(auxDia);
            cont++;
        }

        //Metodo burbuja ordenacion por dia
        for (int i = 1; i < indice; i++) {
            for (int k = indice - 1; k >= i; k--) {
                if (vDia[k] < vDia[k - 1]) {
                    temp = vDia[k];
                    vDia[k] = vDia[k - 1];
                    vDia[k - 1] = temp;

                    aux = vFinal[k];
                    vFinal[k] = vFinal[k - 1];
                    vFinal[k - 1] = aux;
                }
            }
        }

        //for (int i = 0; i < indice; i++) {
        //    System.out.println(vFinal[i]);
        //}
        return vFinal;
    }

    private String[] OrdenarElementosHora(ArrayList<String> array) {
        int temp, cont = 0;
        String auxHora, aux;
        int indice = array.size();

        int[] vHora = new int[indice];
        String[] vFinal = new String[indice];

        for (String elem : array) {
            vFinal[cont] = elem;
            auxHora = elem.substring(0, 2);
            vHora[cont] = Integer.parseInt(auxHora);
            cont++;
        }

        //Metodo burbuja ordenacion por hora
        for (int i = 1; i < indice; i++) {
            for (int k = indice - 1; k >= i; k--) {
                if (vHora[k] < vHora[k - 1]) {
                    temp = vHora[k];
                    vHora[k] = vHora[k - 1];
                    vHora[k - 1] = temp;

                    aux = vFinal[k];
                    vFinal[k] = vFinal[k - 1];
                    vFinal[k - 1] = aux;
                }
            }
        }

        //for (int i = 0; i < indice; i++) {
        //    System.out.println(vFinal[i]);
        //}
        return vFinal;
    }

    private void establecerModel() {
        modelo = new DefaultTableModel();
        modelo.addColumn("Nombre");
        modelo.addColumn("Periodo");
        modelo.addColumn("N° de registros");
        modelo.addColumn("Energia");
        modelo.addColumn("Potencia Reactiva");
        modelo.addColumn("Demanda Máxima");
        modelo.addColumn("Reactiva Máxima");
        modelo.addColumn("Demanda consulta");
        modelo.addColumn("Reactiva consulta");
    }

    private void vaciarModel() {
        for (int i = 0; i < tblDatos.getRowCount(); i++) {
            modelo.removeRow(i);
            i -= 1;
        }
    }

}
