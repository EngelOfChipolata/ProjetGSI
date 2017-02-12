/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afleurdeuxpots802.pages.content;

import afleurdeuxpots802.pages.content.view.ContentPanel;
import afleurdeuxpots802.model.Product;
import afleurdeuxpots802.pages.content.view.ViewEvent;
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
    private final static String PATH_PANIER_FULL = "./src/afleurdeuxpots802/header/Panie_ plein.png";
    private final int NB_ITEMS_IN_PAGE;
    private final ContentFrame contentFrame;
    private ArrayList<Product> products;
    
    private int noFirstProduct;

    public Controller(ContentFrame contentFrame) {
        this.contentFrame = contentFrame;
        NB_ITEMS_IN_PAGE = 7;
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
                int productNo = viewEvent.getProductNo();
                System.out.println(productNo);
                if(productNo == 7) {
                    contentFrame.setPanier(PATH_PANIER_FULL);
                }
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
            contentFrame.getContentPanel().setProduct(i, product, i+noFirstProduct);
        }
        
        setNextThumbnails();
        setPrevThumbnails();
        
    }
    
    private void setNextThumbnails() {
        int nbNextPages = (int) Math.ceil(((double)(products.size() - noFirstProduct - NB_ITEMS_IN_PAGE))/NB_ITEMS_IN_PAGE);
        contentFrame.getContentPanel().setNextPagesNumber(nbNextPages);
        for(int i = NB_ITEMS_IN_PAGE + noFirstProduct; i<(2*NB_ITEMS_IN_PAGE + noFirstProduct); i++) {
            Product product = null;
            try {
                product = products.get(i);
            } catch (IndexOutOfBoundsException e) {}
            
            contentFrame.getContentPanel().setNextPageThumbnail(i - noFirstProduct - NB_ITEMS_IN_PAGE, product);
        }
    }
    
    private void setPrevThumbnails() {
        int nbPrevPages = (int) Math.ceil(((double)(noFirstProduct))/NB_ITEMS_IN_PAGE);
        contentFrame.getContentPanel().setPrevPageNumber(nbPrevPages);
        for(int i = noFirstProduct - NB_ITEMS_IN_PAGE; i<noFirstProduct; i++) {
            Product product = null;
            try {
                product = products.get(i);
            } catch (IndexOutOfBoundsException e) {}
            
            contentFrame.getContentPanel().setPrevPageThumbnail(i - noFirstProduct + NB_ITEMS_IN_PAGE, product);
        }
    }
    
    private State getNewState() {
        if(products.size() <= NB_ITEMS_IN_PAGE) {
            //System.out.println(State.LEFT_RIGHT_STOP);
            return State.LEFT_RIGHT_STOP;
        }
        if(noFirstProduct <= 0) {
            //System.out.println(State.LEFT_STOP);
            return State.LEFT_STOP;
        }
        if(noFirstProduct + NB_ITEMS_IN_PAGE >= products.size()) {
            //System.out.println(State.RIGHT_STOP);
            return State.RIGHT_STOP;
        }
        //System.out.println(State.NO_STOP);
        return State.NO_STOP;
    }
    
    public void initState() {
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
