/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afleurdeuxpots802.pages.content;

import afleurdeuxpots802.controller.Controller;
import afleurdeuxpots802.module.IFleur2PotsPage;
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
        controller = new Controller(contentFrame.getContentPanel());
        contentFrame.setController(controller);
        controller.initState();
    }
    
    @Override
    public void showWindow() {
        contentFrame.setVisible(true);
    }

    @Override
    public void hideWindow() {
        contentFrame.setVisible(false);
    }
    
}