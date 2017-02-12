/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afleurdeuxpots802.module;

import afleurdeuxpots802.header.Header;
import afleurdeuxpots802.pages.accueil.Accueil;
import afleurdeuxpots802.pages.commander.Commander;
import afleurdeuxpots802.pages.content.Content;
import afleurdeuxpots802.pages.panier.Panier;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author buisangu
 */
public class Module implements Observer{
    
    private enum State{
        ACCUEIL,
        ST_VALENTIN,
        PANIER,
        COMMANDES
    }
    
    private State state;
    private Observable accueil;
    private Observable content;
    private Observable panier;
    private Observable commander;

    public Module() {
        init();
    }
    
    private void init(){
        state = State.ACCUEIL;
        accueil = new Accueil();
        content = new Content();
        panier = new Panier();
        commander = new Commander();
        accueil.addObserver(this);
        content.addObserver(this);
        panier.addObserver(this);
        commander.addObserver(this);
        showAccueil();
    }
    
    

    @Override
    public void update(Observable o, Object arg) {
        int event = (int) arg;
        switch (event){
            case Header.ST_VALENTIN_CLICKED_SIGNAL:
                handleContentClicked();
                break;
            /*case PANIER_CLICKED:
                handlePanierClicked();
                break;*/
            case Panier.COMMANDE_CLICKED_SIGNAL:
                handleCommanderClicked();
                break;
            case Header.ACCUEIL_CLICKED_SIGNAL:
                handleAccueilClicked();
                break;
        }
    }
    
    private void handleContentClicked(){
        switch (state){
            case ACCUEIL:
                state = State.ST_VALENTIN;
                showContent();
                break;
            case ST_VALENTIN:
                //Non géré
                break;
            case PANIER:
                //Non géré
                break;
            case COMMANDES:
                // Non géré
                break;
            default:
                throw new AssertionError(state.name());
            
        }
    }
    
    private void handlePanierClicked(){
            switch (state){
            case ACCUEIL:
                //Non géré
                break;
            case ST_VALENTIN:
                state = State.PANIER;
                showPanier();
                break;
            case PANIER:
                //Non géré
                break;
            case COMMANDES:
                // Non géré
                break;
            default:
                throw new AssertionError(state.name());
            
        }
    }
    
    private void handleCommanderClicked(){
            switch (state){
            case ACCUEIL:
                //Interdit
                break;
            case ST_VALENTIN:
                //Interdit
                break;
            case PANIER:
                state = State.COMMANDES;
                showCommander();
                break;
            case COMMANDES:
                // Interdit
                break;
            default:
                throw new AssertionError(state.name());
            
        }
    }
    
    private void handleAccueilClicked(){
            switch (state){
            case ACCUEIL:
                state = State.ACCUEIL;
                showAccueil();
                break;
            case ST_VALENTIN:
                state = State.ACCUEIL;
                showAccueil();
                break;
            case PANIER:
                state = State.ACCUEIL;
                showAccueil();
                break;
            case COMMANDES:
                state = State.ACCUEIL;
                showAccueil();
                break;
            default:
                throw new AssertionError(state.name());
            
        }
    }
    
    private void showContent(){
        ((IFleur2PotsPage) accueil).hideWindow();
        ((IFleur2PotsPage) panier).hideWindow();
        ((IFleur2PotsPage) commander).hideWindow();
        ((IFleur2PotsPage) content).showWindow();
    }
    
    private void showPanier(){
        ((IFleur2PotsPage) accueil).hideWindow();
        ((IFleur2PotsPage) content).hideWindow();
        ((IFleur2PotsPage) panier).showWindow();
        ((IFleur2PotsPage) commander).hideWindow();      
    }
    
    private void showCommander(){
        ((IFleur2PotsPage) accueil).hideWindow();
        ((IFleur2PotsPage) content).hideWindow();
        ((IFleur2PotsPage) panier).hideWindow();
        ((IFleur2PotsPage) commander).showWindow();
    }
    
    private void showAccueil(){
        ((IFleur2PotsPage) accueil).showWindow();
        ((IFleur2PotsPage) content).hideWindow();
        ((IFleur2PotsPage) panier).hideWindow();
        ((IFleur2PotsPage) commander).hideWindow();   
    }
    
}
