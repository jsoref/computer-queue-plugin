/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jenkinsci.plugins.computerqueue;

import hudson.model.Action;
import hudson.model.Computer;
import hudson.model.ComputerPanelBox;
import hudson.model.Hudson;

/**
 * Updating a computer queue through Ajax is the only propose of this class
 *
 * @author Lucie Votypkova
 * 
 */
public class QueueUpdateAction implements Action{
    
    private Computer computer;
    
    public QueueUpdateAction(Computer computer){
        this.computer=computer;
    }
    
    public String getIconFileName() {
        return null;
    }

    public String getDisplayName() {
        return null;
    }

    public String getUrlName() {
        return "updateQueue";
    }
    
    public ComputerQueue getComputerQueue(){
        for(ComputerPanelBox box: computer.getComputerPanelBoxs()){
            if(box instanceof ComputerQueue)
                return (ComputerQueue) box;
        }
        ComputerQueue queue = new ComputerQueue();
        queue.setComputer(computer);
        return queue;
    }
    
    
}
