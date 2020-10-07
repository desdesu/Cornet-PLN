/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cornet_desktop;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 *
 * @author ilham
 */
public class DropDownListener implements ItemListener{

    @Override
    public void itemStateChanged(ItemEvent event) {
        if(event.getStateChange() == ItemEvent.SELECTED){
            System.out.println("item selectable:"+event.getItemSelectable());
            System.out.println("item source:"+event.getSource());
            System.out.println("item class:"+event.getClass());
            System.out.println("item:"+event.getItem());
        }
    }
    
}
