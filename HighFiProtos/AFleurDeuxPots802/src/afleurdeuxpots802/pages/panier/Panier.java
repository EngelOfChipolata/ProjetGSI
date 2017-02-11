/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afleurdeuxpots802.pages.panier;

import afleurdeuxpots802.module.IFleur2PotsPage;
import java.util.Observable;

/**
 *
 * @author guilhem
 */
public class Panier extends Observable implements IFleur2PotsPage{
    
    private final PanierPage page;
    public static final int COMMANDE_CLICKED_SIGNAL = 3;

    public Panier() {
        page = new PanierPage();
    }
    
    

    @Override
    public void showWindow() {
        page.setVisible(true);
    }

    @Override
    public void hideWindow() {
        page.setVisible(false);
    }
    
}
