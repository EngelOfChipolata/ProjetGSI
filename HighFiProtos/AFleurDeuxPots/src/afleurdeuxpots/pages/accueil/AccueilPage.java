/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afleurdeuxpots.pages.accueil;

import afleurdeuxpots.header.IHeaderHolder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 *
 * @author desertle
 */
public class AccueilPage extends javax.swing.JFrame implements IHeaderHolder{

    @Override
    public void addHeaderCallback(String name, PropertyChangeListener li) {
        header1.addPropertyChangeListener(name, li);
    }

    @Override
    public void removeHeaderCallback(String name, PropertyChangeListener li) {
        header1.removePropertyChangeListener(name, li);
    }

    @Override
    public void setFull(boolean b) {
        header1.setFull(b);
    }

    /**
     * Creates new form AcceuilPage
     */
    private enum States {
        RUBAN_1, RUBAN_2, RUBAN_3, RUBAN_4
    };
    private States state;
    private Timer timerRuban;
    private static final String PATH_IMG1 = "./src/images/valentine.jpg";
    private static final String PATH_IMG2 = "./src/images/pimpMyBouquet.png";
    private static final String PATH_IMG3 = "./src/images/fleurRandom.png";
    private static final String PATH_IMG4 = "./src/images/Bouquet.jpg";
    private static final String PATH_PRD1 = "./ressources/products/Bouquet (23).jpg";
    private static final String PATH_PRD2 = "./ressources/products/Bouquet (24).jpg";
    private static final String PATH_PRD3 = "./ressources/products/Bouquet (2).jpg";
    private static final String PATH_PRD4 = "./ressources/products/Bouquet (5).jpg";
    private static final String PATH_PRD5 = "./ressources/products/Bouquet (6).jpg";
    private static final String PATH_PRD6 = "./ressources/products/Bouquet (7).jpg";
    private static final String PATH_PRD7 = "./ressources/products/Bouquet (8).jpg";
    private static final String PATH_PRD8 = "./ressources/products/Bouquet (10).jpg";
    private BufferedImage img;

    public AccueilPage() {
        initComponents();
        init();
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    private void init() {
        state = States.RUBAN_1;
        timerRuban = new Timer(5000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (state) {
                    case RUBAN_1:
                        state = States.RUBAN_2;
                        ActionTimer1();
                        break;
                    case RUBAN_2:
                        state = States.RUBAN_3;
                        ActionTimer2();
                        break;
                    case RUBAN_3:
                        state = States.RUBAN_4;
                        ActionTimer3();
                        break;
                    case RUBAN_4:
                        state = States.RUBAN_1;
                        ActionTimer4();
                        break;
                }
            }
        });

        bouttonRuban1.setEnabled(false);
        bouttonRuban2.setEnabled(true);
        bouttonRuban3.setEnabled(true);
        bouttonRuban4.setEnabled(true);
 
        updateImage(PATH_IMG1);
        productView1.setImage(PATH_PRD1);
        productView2.setImage(PATH_PRD2);
        productView3.setImage(PATH_PRD3);
        productView4.setImage(PATH_PRD4);
        productView5.setImage(PATH_PRD5);
        productView6.setImage(PATH_PRD6);
        productView7.setImage(PATH_PRD7);
        productView8.setImage(PATH_PRD8);
        timerRuban.start();
        
    }

    private void updateImage(String filepath) {
        ImageIcon icon = new ImageIcon(filepath);
        imageRuban.setText("");
        imageRuban.setIcon(icon);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonPrecedent = new javax.swing.JButton();
        buttonPrecedent1 = new javax.swing.JButton();
        imageRuban = new javax.swing.JLabel();
        bouttonRuban1 = new javax.swing.JButton();
        bouttonRuban3 = new javax.swing.JButton();
        bouttonRuban4 = new javax.swing.JButton();
        header1 = new afleurdeuxpots.header.Header();
        bouttonRuban2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        productView1 = new afleurdeuxpots.pages.content.view.ProductView();
        productView2 = new afleurdeuxpots.pages.content.view.ProductView();
        productView3 = new afleurdeuxpots.pages.content.view.ProductView();
        productView4 = new afleurdeuxpots.pages.content.view.ProductView();
        productView5 = new afleurdeuxpots.pages.content.view.ProductView();
        productView6 = new afleurdeuxpots.pages.content.view.ProductView();
        productView7 = new afleurdeuxpots.pages.content.view.ProductView();
        productView8 = new afleurdeuxpots.pages.content.view.ProductView();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        buttonPrecedent.setText("<<");
        buttonPrecedent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPrecedentActionPerformed(evt);
            }
        });

        buttonPrecedent1.setText(">>");
        buttonPrecedent1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPrecedent1ActionPerformed(evt);
            }
        });

        imageRuban.setText("Image");
        imageRuban.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imageRubanMouseClicked(evt);
            }
        });

        bouttonRuban1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bouttonRuban1ActionPerformed(evt);
            }
        });

        bouttonRuban3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bouttonRuban3ActionPerformed(evt);
            }
        });

        bouttonRuban4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bouttonRuban4ActionPerformed(evt);
            }
        });

        bouttonRuban2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bouttonRuban2ActionPerformed(evt);
            }
        });

        productView1.setName("Joli Bouquet"); // NOI18N
        productView1.setPrice(new java.lang.Double(15.2));

        productView2.setName("Viens là"); // NOI18N
        productView2.setPrice(new java.lang.Double(52.2));

        productView3.setName("Mignone"); // NOI18N
        productView3.setPrice(new java.lang.Double(32.2));

        productView4.setName("La fleur du fusil"); // NOI18N
        productView4.setPrice(new java.lang.Double(23.22));

        productView5.setName("Je ne la connais pas"); // NOI18N
        productView5.setPrice(new java.lang.Double(66.6));

        productView6.setName("Les Fleurs du Male"); // NOI18N
        productView6.setPrice(new java.lang.Double(60.5));

        productView7.setName("Pardon"); // NOI18N
        productView7.setPrice(new java.lang.Double(45.3));

        productView8.setName("Je t'aime"); // NOI18N
        productView8.setPrice(new java.lang.Double(55.6));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(productView1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(productView6, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(productView5, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(productView3, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(productView7, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(productView8, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(productView2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(productView4, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(productView7, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addComponent(productView2, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(productView6, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(productView3, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(productView1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(productView5, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(productView8, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(productView4, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 117, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(header1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(buttonPrecedent)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(imageRuban, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonPrecedent1))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bouttonRuban1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bouttonRuban2, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bouttonRuban3, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bouttonRuban4, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(322, 322, 322))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(header1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonPrecedent, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonPrecedent1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(imageRuban, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(bouttonRuban1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bouttonRuban3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bouttonRuban4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(bouttonRuban2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bouttonRuban1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bouttonRuban1ActionPerformed
        state = States.RUBAN_1;
        forceImage1();
    }//GEN-LAST:event_bouttonRuban1ActionPerformed

    private void bouttonRuban3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bouttonRuban3ActionPerformed
        state = States.RUBAN_3;
        forceImage3();
    }//GEN-LAST:event_bouttonRuban3ActionPerformed

    private void bouttonRuban4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bouttonRuban4ActionPerformed
        state = States.RUBAN_4;
        forceImage4();
    }//GEN-LAST:event_bouttonRuban4ActionPerformed

    private void buttonPrecedentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPrecedentActionPerformed
        switch (state){
            case RUBAN_1:
                state = States.RUBAN_4;
                forceImage4();
                break;
            case RUBAN_2:
                state = States.RUBAN_1;
                forceImage1();
                break;
            case RUBAN_3:
                state = States.RUBAN_2;
                forceImage2();
                break;
            case RUBAN_4:
                state = States.RUBAN_3;
                forceImage3();
                break;
        }
    }//GEN-LAST:event_buttonPrecedentActionPerformed

    private void buttonPrecedent1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPrecedent1ActionPerformed
        switch (state){
            case RUBAN_1:
                state = States.RUBAN_2;
                forceImage2();
                break;
            case RUBAN_2:
                state = States.RUBAN_3;
                forceImage3();
                break;
            case RUBAN_3:
                state = States.RUBAN_4;
                forceImage4();
                break;
            case RUBAN_4:
                state = States.RUBAN_1;
                forceImage1();
                break;
        }
    }//GEN-LAST:event_buttonPrecedent1ActionPerformed

    private void imageRubanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imageRubanMouseClicked
        switch (state){
            case RUBAN_1:
                header1.goToStVal();
                break;
            case RUBAN_2:
                break;
            case RUBAN_3:
                header1.goToStVal();
                break;
            case RUBAN_4:
                break;
        }
    }//GEN-LAST:event_imageRubanMouseClicked

    private void bouttonRuban2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bouttonRuban2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bouttonRuban2ActionPerformed

    private void ActionTimer1() {
        bouttonRuban1.setEnabled(true);
        bouttonRuban2.setEnabled(false);
        bouttonRuban3.setEnabled(true);
        bouttonRuban4.setEnabled(true);
        updateImage(PATH_IMG2);
    }
    
    private void ActionTimer2() {
        bouttonRuban1.setEnabled(true);
        bouttonRuban2.setEnabled(true);
        bouttonRuban3.setEnabled(false);
        bouttonRuban4.setEnabled(true);
        updateImage(PATH_IMG3);
    }
    
    private void ActionTimer3() {
        bouttonRuban1.setEnabled(true);
        bouttonRuban2.setEnabled(true);
        bouttonRuban3.setEnabled(true);
        bouttonRuban4.setEnabled(false);
        updateImage(PATH_IMG4);
    }
    private void ActionTimer4() {
        bouttonRuban1.setEnabled(false);
        bouttonRuban2.setEnabled(true);
        bouttonRuban3.setEnabled(true);
        bouttonRuban4.setEnabled(true);
        updateImage(PATH_IMG1);
    }
    
    private void forceImage1(){
        bouttonRuban1.setEnabled(false);
        bouttonRuban2.setEnabled(true);
        bouttonRuban3.setEnabled(true);
        bouttonRuban4.setEnabled(true);
        updateImage(PATH_IMG1);
        timerRuban.restart();
    }
    
    private void forceImage2(){
        bouttonRuban1.setEnabled(true);
        bouttonRuban2.setEnabled(false);
        bouttonRuban3.setEnabled(true);
        bouttonRuban4.setEnabled(true);
        updateImage(PATH_IMG2);
        timerRuban.restart();
    }
    
    private void forceImage3(){
        bouttonRuban1.setEnabled(true);
        bouttonRuban2.setEnabled(true);
        bouttonRuban3.setEnabled(false);
        bouttonRuban4.setEnabled(true);
        updateImage(PATH_IMG3);
        timerRuban.restart();
    }
    
    private void forceImage4(){
        bouttonRuban1.setEnabled(true);
        bouttonRuban2.setEnabled(true);
        bouttonRuban3.setEnabled(true);
        bouttonRuban4.setEnabled(false);
        updateImage(PATH_IMG4);
        timerRuban.restart();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bouttonRuban1;
    private javax.swing.JButton bouttonRuban2;
    private javax.swing.JButton bouttonRuban3;
    private javax.swing.JButton bouttonRuban4;
    private javax.swing.JButton buttonPrecedent;
    private javax.swing.JButton buttonPrecedent1;
    private afleurdeuxpots.header.Header header1;
    private javax.swing.JLabel imageRuban;
    private javax.swing.JPanel jPanel1;
    private afleurdeuxpots.pages.content.view.ProductView productView1;
    private afleurdeuxpots.pages.content.view.ProductView productView2;
    private afleurdeuxpots.pages.content.view.ProductView productView3;
    private afleurdeuxpots.pages.content.view.ProductView productView4;
    private afleurdeuxpots.pages.content.view.ProductView productView5;
    private afleurdeuxpots.pages.content.view.ProductView productView6;
    private afleurdeuxpots.pages.content.view.ProductView productView7;
    private afleurdeuxpots.pages.content.view.ProductView productView8;
    // End of variables declaration//GEN-END:variables
}
