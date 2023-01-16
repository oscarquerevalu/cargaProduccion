package net.wong.archivoproduccion;

import business_logic.BLProduccion;
import org.apache.log4j.Logger;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class PrincipalGui extends JFrame {
    private static Logger log = Logger.getLogger(PrincipalGui.class);
    private JRadioButton btn_archivos_prod;

    private JButton btn_ejecutar;

    private JRadioButton btn_niubiz;

    private ButtonGroup buttonGroup1;

    private JLabel jLabel1;

    private JScrollPane jScrollPane1;

    private JTextField txt_dias_atras;

    private JTextArea txt_log;

    public PrincipalGui() {
        initComponents();
    }

    private void initComponents() {
        this.buttonGroup1 = new ButtonGroup();
        this.txt_dias_atras = new JTextField();
        this.jLabel1 = new JLabel();
        this.btn_niubiz = new JRadioButton();
        this.btn_archivos_prod = new JRadioButton();
        this.btn_ejecutar = new JButton();
        this.jScrollPane1 = new JScrollPane();
        this.txt_log = new JTextArea();
        setDefaultCloseOperation(3);
        setTitle("Generar archivos FTP");
        this.jLabel1.setText("Dias atras:");
        this.buttonGroup1.add(this.btn_niubiz);
        this.btn_niubiz.setSelected(true);
        this.btn_niubiz.setText("Niubiz");
        this.btn_niubiz.setName("btn_niubiz");
        this.buttonGroup1.add(this.btn_archivos_prod);
        this.btn_archivos_prod.setText("Archivos Produccion");
        this.btn_ejecutar.setText("Ejecutar");
        this.btn_ejecutar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                PrincipalGui.this.btn_ejecutarActionPerformed(evt);
            }
        });
        this.txt_log.setColumns(20);
        this.txt_log.setRows(5);
        this.txt_log.setText("LOG");
        this.jScrollPane1.setViewportView(this.txt_log);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(this.jLabel1)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(this.txt_dias_atras, -2, 159, -2))
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(27, 27, 27)
                                        .addComponent(this.btn_niubiz)
                                        .addGap(29, 29, 29)
                                        .addComponent(this.btn_archivos_prod))
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(78, 78, 78)
                                        .addComponent(this.btn_ejecutar))
                                .addGroup(layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(this.jScrollPane1, -2, 243, -2)))
                        .addContainerGap(24, 32767)));
        layout.setVerticalGroup(layout
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(this.txt_dias_atras, -2, -1, -2)
                                .addComponent(this.jLabel1))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(this.btn_niubiz)
                                .addComponent(this.btn_archivos_prod))
                        .addGap(18, 18, 18)
                        .addComponent(this.jScrollPane1, -1, 175, 32767)
                        .addGap(18, 18, 18)
                        .addComponent(this.btn_ejecutar)));
        pack();
        setLocationRelativeTo(null);
    }

    private void btn_ejecutarActionPerformed(ActionEvent evt) {
        this.txt_log.setText("");
        if (this.btn_niubiz.isSelected()) {
            (new Thread(new Runnable() {
                public void run() {
                    int dias = 0;
                    PrincipalGui.this.txt_log.setText("");
                    try {
                        dias = Integer.parseInt(PrincipalGui.this.txt_dias_atras.getText());
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Ingrese un numero valido para dias");
                    }
                    PrincipalGui.this.txt_log.setText("");
                    PrincipalGui.this.txt_log.append("/*NIUBIZ*/\n");
                    PrincipalGui.this.txt_log.append("PLAZA NORTE\n");
                    (new BLProduccion()).listarNiubiz("abenitez@wong.net.pe", "Mendiola1400", dias, "5f370dde2affee0007b03eed", "20514020907", "02f903ec23e1a6b5feb2ffb9db633c62", "PLN");
                    PrincipalGui.this.txt_log.append("MDS\n");
                    (new BLProduccion()).listarNiubiz("elsie.yagui.uku@gmail.com", "Elsie1962", dias, "60995aa18712650007014e1d", "20507884823", "02f903ec23e1a6b5feb2ffb9db633c62", "MDS");
                    PrincipalGui.this.txt_log.append("PANISTERIA\n");
                    (new BLProduccion()).listarNiubiz("pblas@wong.net.pe", "Panisteria20", dias, "5e4851d93675cbabdb684fee", "20416026948", "02f903ec23e1a6b5feb2ffb9db633c62", "PAN");
                    PrincipalGui.this.txt_log.append("ENTREPAGINAS\n");
                    (new BLProduccion()).listarNiubiz("mherrera@wong.net.pe", "Entrepaginas20", dias, "5e484d3afae43b0c52e9dd3f", "20507885391", "02f903ec23e1a6b5feb2ffb9db633c62", "LIB");
                    PrincipalGui.this.txt_log.append("MEDITERRANEO\n");
                    (new BLProduccion()).listarNiubiz("mediterraneo@wong.net.pe", "V09udey5e", dias, "5e484d39fae43b0c52e9dc41", "20553255881", "02f903ec23e1a6b5feb2ffb9db633c62", "MED");
                    PrincipalGui.this.txt_log.append("PRODUSANA\n");
                    (new BLProduccion()).listarNiubiz("daniel@produsana.com", "Produsana1", dias, "5e4857ff6724d5a236858ffa", "20563468646", "02f903ec23e1a6b5feb2ffb9db633c62", "PRO");
                    PrincipalGui.this.txt_log.append("/*EXPRESS NET*/\n");
                    PrincipalGui.this.txt_log.append("MDS\n");
                    (new BLProduccion()).listarExpressNet(dias, "20507884823", "20507884823", "Elsie1962", "MDS");
                    PrincipalGui.this.txt_log.append("PAN\n");
                    (new BLProduccion()).listarExpressNet(dias, "20416026948", "20416026948", "Vale2107*", "PAN");
                    PrincipalGui.this.txt_log.append("LIB\n");
                    (new BLProduccion()).listarExpressNet(dias, "20507885391", "20507885391", "2020Libreria", "LIB");
                    PrincipalGui.this.txt_log.append("MED\n");
                    (new BLProduccion()).listarExpressNet(dias, "20553255881", "20553255881", "V09udey5e", "MED");
                    PrincipalGui.this.txt_log.append("PRO\n");
                    (new BLProduccion()).listarExpressNet(dias, "20563468646", "20563468646", "Magnolia59", "PRO");
                    JOptionPane.showMessageDialog(null, "Se ha generado los archivos de niubiz");
                }
            })).start();
        } else {
            (new Thread(new Runnable() {
                public void run() {
                    try {
                        int dias = 0;
                        PrincipalGui.this.txt_log.setText("");
                        try {
                            dias = Integer.parseInt(PrincipalGui.this.txt_dias_atras.getText());
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "Ingrese un numero valido para dias");
                        }
                        String data = "";
                        try {
                            File myObj = new File("token_arisale.txt");
                            Scanner myReader = new Scanner(myObj);
                            while (myReader.hasNextLine()) {
                                data = myReader.nextLine();
                                log.info(data);
                            }
                            myReader.close();
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
                        }
                        PrincipalGui.this.txt_log.append("/*ARHIVOS PRODUCCION*/\n");
                        PrincipalGui.this.txt_log.append("Mediterraneo\n");
                        (new BLProduccion()).listarMediterraneo(dias);
                        PrincipalGui.this.txt_log.append("DonBuffet\n");
                        (new BLProduccion()).listarDonBuffet(dias);
                        PrincipalGui.this.txt_log.append("Papas\n");
                        (new BLProduccion()).listarPapas(dias);
                        PrincipalGui.this.txt_log.append("Arisale\n");
                        (new BLProduccion()).listarArisale(dias, data);
                        JOptionPane.showMessageDialog(null, "Se ha generado los archivos de produccion");
                    } catch (IOException ex) {
                        log.error(ex);
                    }
                }
            })).start();
        }
    }

    public static void main(String[] args) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            log.error(ex);
        } catch (InstantiationException ex) {
            log.error(ex);
        } catch (IllegalAccessException ex) {
            log.error(ex);
        } catch (UnsupportedLookAndFeelException ex) {
            log.error(ex);
        }
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                (new PrincipalGui()).setVisible(true);
            }
        });
    }
}
