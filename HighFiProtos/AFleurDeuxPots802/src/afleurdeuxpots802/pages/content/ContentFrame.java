/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afleurdeuxpots802.pages.content;

import afleurdeuxpots802.header.IHeaderHolder;
import afleurdeuxpots802.pages.content.view.ContentPanel;
import java.beans.PropertyChangeListener;

/**
 *
 * @author bonnevfa
 */
public class ContentFrame extends javax.swing.JFrame implements IHeaderHolder{

    /**
     * Creates new form ContentFrame
     */
    public ContentFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        header1 = new afleurdeuxpots802.header.Header();
        contentPanel1 = new afleurdeuxpots802.pages.content.view.ContentPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(contentPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(header1, javax.swing.GroupLayout.PREFERRED_SIZE, 913, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(header1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contentPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private afleurdeuxpots802.pages.content.view.ContentPanel contentPanel1;
    private afleurdeuxpots802.header.Header header1;
    // End of variables declaration//GEN-END:variables

    void setController(Controller controller) {
        contentPanel1.setController(controller);
    }

    public ContentPanel getContentPanel() {
        return contentPanel1;
    }
    
    public void setPanier(boolean b) {
        header1.setFull(b);
    }

    @Override
    public void addHeaderCallback(String name, PropertyChangeListener li) {
        header1.addPropertyChangeListener(name, li);
    }

    @Override
    public void removeHeaderCallback(String name, PropertyChangeListener li) {
        header1.removePropertyChangeListener(name, li);
    }

    void setFull(boolean b) {
        header1.setFull(b);
    }
    
    
}
