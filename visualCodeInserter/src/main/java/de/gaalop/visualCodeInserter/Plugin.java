package de.gaalop.visualCodeInserter;

import de.gaalop.Notifications;
import de.gaalop.VisualizerStrategy;
import de.gaalop.VisualizerStrategyPlugin;
import java.awt.Image;
import java.util.Observable;

/**
 * Sets the algebra on the Control Flow Graph
 * @author Christian Steinmetz
 */
public class Plugin extends Observable implements VisualizerStrategyPlugin {

    @Override
    public VisualizerStrategy createVisualizerStrategy() {
        return new VisualizerCodeInserter();
    }

    @Override
    public String getName() {
        return "Visualizer";
    }

    @Override
    public String getDescription() {
        return "This plugin sets the visualizing commands";
    }

    @Override
    public Image getIcon() {
        return null;
    }

    void notifyError(Throwable error) {
        setChanged();
        notifyObservers(new Notifications.Error(error));
    }

}
