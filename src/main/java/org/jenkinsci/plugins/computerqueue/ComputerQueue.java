package org.jenkinsci.plugins.computerqueue;

import hudson.Extension;
import hudson.model.*;
import hudson.model.Queue.BuildableItem;
import jenkins.model.Jenkins;

import java.util.ArrayList;
import java.util.List;

/**
 * Add a box with a queue of tasks for given computer to its page
 * 
 * @author Lucie Votypkova
 */
@Extension
public class ComputerQueue extends ComputerPanelBox {

    public List<BuildableItem> items() {
        List<BuildableItem> buildableItems = new ArrayList<BuildableItem>();
        Node node = super.getComputer().getNode();
        List<Queue.Item> approximateItemsQuickly = Jenkins.getInstance().getQueue().getApproximateItemsQuickly();
        for (Queue.Item item : approximateItemsQuickly) {
            if (item instanceof BuildableItem) {
                Queue.BuildableItem item1 = (BuildableItem) item;
                if (node.canTake(item1) == null)
                    buildableItems.add(item1);
            }
        }
        return buildableItems;
    }
    
}
