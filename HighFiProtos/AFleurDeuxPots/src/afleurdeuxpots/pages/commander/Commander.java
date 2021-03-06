/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afleurdeuxpots.pages.commander;

import afleurdeuxpots.header.Header;
import afleurdeuxpots.module.IFleur2PotsPage;
import java.util.Observable;

/**
 *
 * @author bonnevfa
 */
public class Commander  extends Observable implements IFleur2PotsPage{

    private final CommanderFrame commanderFrame;

    public Commander() {
        commanderFrame = new CommanderFrame();
        commanderFrame.addHeaderCallback(String.valueOf(Header.ACCUEIL_CLICKED_SIGNAL), (evt) -> {
            setChanged();
            notifyObservers(Header.ACCUEIL_CLICKED_SIGNAL);
        });
        commanderFrame.addHeaderCallback(String.valueOf(Header.CART_CLICKED_SIGNAL), (evt) -> {
            setChanged();
            notifyObservers(Header.CART_CLICKED_SIGNAL);
        });
        commanderFrame.setFull(true);
    }
    
    
    
    @Override
    public void showWindow() {
        commanderFrame.setVisible(true);
    }

    @Override
    public void hideWindow() {
        commanderFrame.setVisible(false);
    }
    
    @Override
    public void setFull(boolean b) {
        commanderFrame.setFull(b);
    }
}
