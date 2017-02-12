/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afleurdeuxpots802.pages.commander;

import afleurdeuxpots802.module.IFleur2PotsPage;
import java.util.Observable;

/**
 *
 * @author bonnevfa
 */
public class Commander  extends Observable implements IFleur2PotsPage{

    private final CommanderFrame commanderFrame;

    public Commander() {
        commanderFrame = new CommanderFrame();
    }
    
    
    
    @Override
    public void showWindow() {
        commanderFrame.setVisible(true);
    }

    @Override
    public void hideWindow() {
        commanderFrame.setVisible(false);
    }
    
}
