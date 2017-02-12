/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afleurdeuxpots802.pages.accueil;

import afleurdeuxpots802.module.IFleur2PotsPage;
import java.util.Observable;

/**
 *
 * @author desertle
 */
public class Accueil extends Observable implements IFleur2PotsPage {

    private AccueilPage accueilPage;

    public Accueil() {
        accueilPage = new AccueilPage();
    }
    
    @Override
    public void showWindow() {
        accueilPage.setVisible(true);
    }

    @Override
    public void hideWindow() {
        accueilPage.setVisible(false);
    }
    
}
