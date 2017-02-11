/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afleurdeuxpots802.controller;

import afleurdeuxpots802.widgets.ContentPanel;
import afleurdeuxpots802.model.Product;
import afleurdeuxpots802.widgets.ViewEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author fabien
 */
public class Controller {
    private State state;
    private final static String PATH_PRODUCTS = "./ressources/products/";
    private final int NB_ITEMS_IN_PAGE;
    private final ContentPanel contentPanel;
    private ArrayList<Product> products;
    
    private int noFirstProduct;

    public Controller(ContentPanel contentPanel) {
        this.contentPanel = contentPanel;
        NB_ITEMS_IN_PAGE = 7;
        initState();
    }
    
    public void handleEvent(ViewEvent viewEvent) {
        switch(viewEvent.getEventType()) {
            case PREVIOUS_PAGE:
                switch(state) {
                    case LEFT_STOP:
                        //forbidden
                        break;
                    case RIGHT_STOP:
                        noFirstProduct -= NB_ITEMS_IN_PAGE;
                        updateProducts();
                        state = getNewState();
                        break;
                    case LEFT_RIGHT_STOP:
                        //forbidden
                        break;
                    case NO_STOP:
                        noFirstProduct -= NB_ITEMS_IN_PAGE;
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
    
    private void initState() {
        products = new ArrayList<>();
        loadProducts(PATH_PRODUCTS + "catalog.txt");
        noFirstProduct = 0;
        state = getNewState();
        updateProducts();
    }
    
    public void loadProducts(String filename) {
    BufferedReader br = null;
    FileReader fr = null;

    try {
        String sCurrentLine;
        fr = new FileReader(filename);
        br = new BufferedReader(fr);

        while ((sCurrentLine = br.readLine()) != null) {
            String[] params = sCurrentLine.split(";");
            if(params.length != 3) {
                continue;
            }
            String path = PATH_PRODUCTS + params[0];
            System.out.println(path);
            String name = params[1];
            double price = Double.parseDouble(params[2]);
            products.add(new Product(path, name, price));

        }

    } catch (IOException e) {
            e.printStackTrace();
    }
    finally {
        try {
            if (br != null){
                br.close();
            }
            if (fr != null){
                fr.close();
        }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    }
    
    
    
    private enum State {
        LEFT_STOP,
        RIGHT_STOP,
        LEFT_RIGHT_STOP,
        NO_STOP
    }
}
