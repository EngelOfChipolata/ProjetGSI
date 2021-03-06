/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afleurdeuxpots.pages.panier;

import afleurdeuxpots.header.Header;
import afleurdeuxpots.model.Product;
import afleurdeuxpots.module.IFleur2PotsPage;
import java.util.Observable;

/**
 *
 * @author guilhem
 */
public class Panier extends Observable implements IFleur2PotsPage{
    
    private final PanierPage page;
    public static final int COMMANDE_CLICKED_SIGNAL = 3;
    private Product product;

    public Panier() {
        page = new PanierPage();
        page.addHeaderCallback(String.valueOf(Header.ACCUEIL_CLICKED_SIGNAL), (evt) -> {
            setChanged();
            notifyObservers(Header.ACCUEIL_CLICKED_SIGNAL);
        });
        page.addHeaderCallback(String.valueOf(Header.ST_VALENTIN_CLICKED_SIGNAL), (evt) -> {
            setChanged();
            notifyObservers(Header.ST_VALENTIN_CLICKED_SIGNAL);
        });
        page.addPropertyChangeListener(String.valueOf(COMMANDE_CLICKED_SIGNAL), (evt) -> {
            setChanged();
            notifyObservers(COMMANDE_CLICKED_SIGNAL);
        });
        
    }
    public void setProduct(Product product) {
        page.setProduct(product);
    }

    @Override
    public void showWindow() {
        page.setVisible(true);
    }

    @Override
    public void hideWindow() {
        page.setVisible(false);
    }

    @Override
    public void setFull(boolean b) {
        page.setFull(b);
    }
    
}
