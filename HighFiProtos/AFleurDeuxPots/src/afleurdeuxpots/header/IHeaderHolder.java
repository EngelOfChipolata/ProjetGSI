/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afleurdeuxpots.header;

import java.beans.PropertyChangeListener;

/**
 *
 * @author guilhem
 */
public interface IHeaderHolder {
    public void addHeaderCallback(String name, PropertyChangeListener li);
    public void removeHeaderCallback(String name, PropertyChangeListener li);
    public void setFull(boolean b);
}
