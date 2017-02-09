/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afleurdeuxpots802.widgets;

/**
 *
 * @author fabien
 */
public class ViewEvent {
    private final ViewEventType eventType;
    private final int number;
    private final int productNo;
    
    public ViewEvent(ViewEventType eventType) {
        this.eventType = eventType;
        number = productNo = 0;
    }

    public ViewEvent(ViewEventType eventType, int number, int productNo) {
        this.eventType = eventType;
        this.number = number;
        this.productNo = productNo;
    }

    public ViewEventType getEventType() {
        return eventType;
    }
    
}
