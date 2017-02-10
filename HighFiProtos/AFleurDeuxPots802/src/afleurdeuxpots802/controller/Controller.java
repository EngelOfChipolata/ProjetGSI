/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afleurdeuxpots802.controller;

import afleurdeuxpots802.widgets.ContentPanel;
import afleurdeuxpots802.model.Product;
import afleurdeuxpots802.widgets.ViewEvent;
import java.util.ArrayList;

/**
 *
 * @author fabien
 */
public class Controller {
    private State state;
    private int NB_ITEMS_IN_PAGE;
    private ArrayList<Product> products;
    private ContentPanel contentPanel;
    private int noFirstProduct;

    public Controller(ContentPanel contentPanel) {
        this.contentPanel = contentPanel;
        NB_ITEMS_IN_PAGE = 7;
        init();
    }
    
    public void handleEvent(ViewEvent viewEvent) {
        switch(viewEvent.getEventType()) {
            case PREVIOUS_PAGE:
                switch(state) {
                    case LEFT_STOP:
                        //forbidden
                        break;
                    case RIGHT_STOP:
                        noFirstProduct += NB_ITEMS_IN_PAGE;
                        updateProducts();
                        state = getNewState();
                        break;
                    case LEFT_RIGHT_STOP:
                        //forbidden
                        break;
                    case NO_STOP:
                        noFirstProduct += NB_ITEMS_IN_PAGE;
                        updateProducts();
                        state = getNewState();
                        break;                    
                }
                break;
            case NEXT_PAGE:
                switch(state) {
                    case LEFT_STOP:
                        noFirstProduct += NB_ITEMS_IN_PAGE;
                        updateProducts();
                        state = getNewState();
                        break;
                    case RIGHT_STOP:
                        //forbidden
                        break;
                    case LEFT_RIGHT_STOP:
                        //forbidden
                        break;
                    case NO_STOP:
                        noFirstProduct += NB_ITEMS_IN_PAGE;
                        updateProducts();
                        state = getNewState();
                        break;                    
                }
                break;
            case ADD_TO_CART:
                break;
            case CHANGE_NB:
                break; 
        }
    }

    private void updateProducts() {
        for(int i = 0; i<NB_ITEMS_IN_PAGE; i++) {
            Product product = null;
            if(i+noFirstProduct < products.size()) {
                product = products.get(i+noFirstProduct);
            }
            contentPanel.setProduct(i, product);
        }
        
        setNextThumbnails();
        setPrevThumbnails();
        
    }
    
    private void setNextThumbnails() {
        int nbNextPages = (int) Math.ceil(((double)(products.size() - noFirstProduct - NB_ITEMS_IN_PAGE))/NB_ITEMS_IN_PAGE);
        contentPanel.setNextPagesNumber(nbNextPages);
        for(int i = NB_ITEMS_IN_PAGE + noFirstProduct; i<(2*NB_ITEMS_IN_PAGE + noFirstProduct); i++) {
            Product product = null;
            try {
                product = products.get(i);
            } catch (IndexOutOfBoundsException e) {}
            
            contentPanel.setNextPageThumbnail(i - noFirstProduct - NB_ITEMS_IN_PAGE, product);
        }
    }
    
    private void setPrevThumbnails() {
        int nbPrevPages = (int) Math.ceil(((double)(noFirstProduct))/NB_ITEMS_IN_PAGE);
        contentPanel.setPrevPageNumber(nbPrevPages);
        for(int i = noFirstProduct - NB_ITEMS_IN_PAGE; i<noFirstProduct; i++) {
            Product product = null;
            try {
                product = products.get(i);
            } catch (IndexOutOfBoundsException e) {}
            
            contentPanel.setPrevPageThumbnail(i - noFirstProduct + NB_ITEMS_IN_PAGE, product);
        }
    }
    
    private State getNewState() {
        if(products.size() <= NB_ITEMS_IN_PAGE) {
            System.out.println(State.LEFT_RIGHT_STOP);
            return State.LEFT_RIGHT_STOP;
        }
        if(noFirstProduct <= 0) {
            System.out.println(State.LEFT_STOP);
            return State.LEFT_STOP;
        }
        if(noFirstProduct + NB_ITEMS_IN_PAGE >= products.size()) {
            System.out.println(State.RIGHT_STOP);
            return State.RIGHT_STOP;
        }
        System.out.println(State.NO_STOP);
        return State.NO_STOP;
    }
    
    public void init() {
        products = new ArrayList<>();
        loadSome();
        noFirstProduct = 0;
        state = getNewState();
        
        updateProducts();
    }
    
    public void loadSome() {
        products.add(new Product("./ressources/1.jpg", "Roses", 12.5));
        products.add(new Product("./ressources/2.jpg", "Pervenches", 10.3));
        products.add(new Product("./ressources/3.jpg", "Tulipes", 25));
        products.add(new Product("./ressources/4.jpg", "Jonquilles", 15));
        products.add(new Product("./ressources/5.jpg", "Orthies", 2));
        products.add(new Product("./ressources/6.jpg", "yop", 2));
        products.add(new Product("./ressources/7.jpg", "Plop", 2));
        products.add(new Product("./ressources/8.jpg", "Géranium", 2));
        products.add(new Product("./ressources/9.jpg", "Azerty", 2));
        products.add(new Product("./ressources/10.jpg", "Qwerty", 2));
        products.add(new Product("./ressources/11.jpg", "Bépo", 2));
        //products.add(new Product("./ressources/12.jpg", "ÉÉÉ", 2));
    }
    
    private enum State {
        LEFT_STOP,
        RIGHT_STOP,
        LEFT_RIGHT_STOP,
        NO_STOP
    }
}
