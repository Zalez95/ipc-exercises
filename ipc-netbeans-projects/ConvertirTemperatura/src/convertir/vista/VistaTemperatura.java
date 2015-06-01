/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convertir.vista;

import convertir.modelo.ModeloTemperatura;
import com.sun.media.sound.ModelAbstractChannelMixer;

/**
 *
 * @author daniel
 */
public class VistaTemperatura extends javax.swing.JFrame {
    private ControladorTemperatura micontrol;
    private ModeloTemperatura mimodelo;
    
    /**
     * Creates new form VistaTemperatura
     */
    public VistaTemperatura() {
        initComponents();
        mimodelo = new ModeloTemperatura();
        micontrol = new ControladorTemperatura(this, mimodelo);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        etiq_C = new javax.swing.JLabel();
        etiq_F = new javax.swing.JLabel();
        bot_Convertir = new javax.swing.JButton();
        bot_Salir = new javax.swing.JButton();
        txt_gC = new javax.swing.JTextField();
        txt_gF = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        etiq_C.setText("Centigrados:");

        etiq_F.setText("Fahrenheit:");

        bot_Convertir.setText("Convertir a F");
        bot_Convertir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bot_ConvertirActionPerformed(evt);
            }
        });

        bot_Salir.setText("Salir");
        bot_Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bot_SalirActionPerformed(evt);
            }
        });

        txt_gC.setText("0");

        txt_gF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_gFActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(bot_Convertir)
                        .addGap(30, 30, 30)
                        .addComponent(bot_Salir, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(etiq_C)
                            .addComponent(etiq_F))
                        .addGap(75, 75, 75)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_gF, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_gC, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(etiq_C)
                    .addComponent(txt_gC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(etiq_F))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_gF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bot_Convertir)
                    .addComponent(bot_Salir))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_gFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_gFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_gFActionPerformed

    private void bot_ConvertirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bot_ConvertirActionPerformed
        // TODO add your handling code here:
        micontrol.convierte();
    }//GEN-LAST:event_bot_ConvertirActionPerformed

    private void bot_SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bot_SalirActionPerformed
        // TODO add your handling code here:
        micontrol.salir();
    }//GEN-LAST:event_bot_SalirActionPerformed

    public double getTxtGrados (){
        return Double.valueOf(txt_gC.getText());
    }
    
    public void actualiza (){
        txt_gF.setText(String.valueOf(mimodelo.getFahrenheit()));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bot_Convertir;
    private javax.swing.JButton bot_Salir;
    private javax.swing.JLabel etiq_C;
    private javax.swing.JLabel etiq_F;
    private javax.swing.JTextField txt_gC;
    private javax.swing.JTextField txt_gF;
    // End of variables declaration//GEN-END:variables
}