/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afleurdeuxpots.pages.content;

import afleurdeuxpots.header.Header;
import afleurdeuxpots.model.Product;
import afleurdeuxpots.module.IFleur2PotsPage;
import java.util.ArrayList;
import java.util.Observable;

/**
 *
 * @author bonnevfa
 */
public class Content extends Observable implements IFleur2PotsPage{
    ContentFrame contentFrame;               //the frame
    Controller controller;      //the amazing controller for the amazing content panel
    
    public Content() {
        contentFrame = new ContentFrame();
        controller = new Controller(contentFrame);
        contentFrame.setController(controller);
        controller.initState();
        
        contentFrame.addHeaderCallback(String.valueOf(Header.ACCUEIL_CLICKED_SIGNAL), (evt) -> {
            setChanged();
            notifyObservers(Header.ACCUEIL_CLICKED_SIGNAL);
        });
        contentFrame.addHeaderCallback(String.valueOf(Header.ST_VALENTIN_CLICKED_SIGNAL), (evt) -> {
            setChanged();
            notifyObservers(Header.ST_VALENTIN_CLICKED_SIGNAL);
        });
        contentFrame.addHeaderCallback(String.valueOf(Header.PRODUCT_ADDED_SIGNAL), (evt) -> {
            setChanged();
            notifyObservers(Header.PRODUCT_ADDED_SIGNAL);
        });
        contentFrame.addHeaderCallback(String.valueOf(Header.CART_CLICKED_SIGNAL), (evt) -> {
            setChanged();
            notifyObservers(Header.CART_CLICKED_SIGNAL);
        });
    }
    
    @Override
    public void showWindow() {
        contentFrame.setVisible(true);
    }

    @Override
    public void hideWindow() {
        contentFrame.setVisible(false);
    }

    @Override
    public void setFull(boolean b) {
        contentFrame.setFull(b);
    }

    public ArrayList<Product> getProducts() {
        return controller.getProducts();
    }
    
}
