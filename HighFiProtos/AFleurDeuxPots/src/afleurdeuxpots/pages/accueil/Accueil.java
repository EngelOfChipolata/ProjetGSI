/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afleurdeuxpots.pages.accueil;

import afleurdeuxpots.header.Header;
import afleurdeuxpots.module.IFleur2PotsPage;
import java.util.Observable;

/**
 *
 * @author desertle
 */
public class Accueil extends Observable implements IFleur2PotsPage {

    private final AccueilPage accueilPage;

    public Accueil() {
        accueilPage = new AccueilPage();
        accueilPage.addHeaderCallback(String.valueOf(Header.ACCUEIL_CLICKED_SIGNAL), (evt) -> {
            setChanged();
            notifyObservers(Header.ACCUEIL_CLICKED_SIGNAL);
        });
        accueilPage.addHeaderCallback(String.valueOf(Header.ST_VALENTIN_CLICKED_SIGNAL), (evt) -> {
            setChanged();
            notifyObservers(Header.ST_VALENTIN_CLICKED_SIGNAL);
        });
        accueilPage.addHeaderCallback(String.valueOf(Header.CART_CLICKED_SIGNAL), (evt) -> {
            setChanged();
            notifyObservers(Header.CART_CLICKED_SIGNAL);
        });
    }
    
    @Override
    public void showWindow() {
        accueilPage.setVisible(true);
    }

    @Override
    public void hideWindow() {
        accueilPage.setVisible(false);
    }
    
    @Override
    public void setFull(boolean b) {
        accueilPage.setFull(b);
    }
}
