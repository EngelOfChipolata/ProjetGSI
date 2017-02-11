/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afleurdeuxpots802.pages.content;

import afleurdeuxpots802.controller.Controller;
import afleurdeuxpots802.module.IFleur2PotsPage;
import afleurdeuxpots802.widgets.ContentPanel;
import java.util.Observable;

/**
 *
 * @author bonnevfa
 */
public class Content extends Observable implements IFleur2PotsPage{

    ContentPanel contentPanel;
    Controller controller;
    
    public Content() {
        contentPanel = new ContentPanel();
        controller = new Controller(contentPanel);
        contentPanel.setController(controller);
    }
    
    @Override
    public void ShowWindow() {
        contentPanel.setVisible(true);
    }

    @Override
    public void HideWindow() {
        contentPanel.setVisible(false);
    }
    
}
