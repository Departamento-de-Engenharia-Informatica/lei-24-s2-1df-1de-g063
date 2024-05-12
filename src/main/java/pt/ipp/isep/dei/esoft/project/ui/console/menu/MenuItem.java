package pt.ipp.isep.dei.esoft.project.ui.console.menu;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

import java.util.Objects;

/**
 * The MenuItem class represents an item in a menu, containing a description and a corresponding UI action.
 */
public class MenuItem {
    private final String description;
    private final Runnable ui;

    /**
     * Constructs a new MenuItem with the specified description and UI action.
     * @param description The description of the menu item.
     * @param ui The UI action associated with the menu item.
     * @throws IllegalArgumentException if the description is null or empty, or if the UI action is null.
     */
    public MenuItem(String description, Runnable ui) {
        if (description == null || description.isEmpty()) {
            throw new IllegalArgumentException("MenuItem description cannot be null or empty.");
        }
        if (ui == null) {
            throw new IllegalArgumentException("MenuItem does not support a null UI.");
        }

        this.description = description;
        this.ui = ui;
    }

    /**
     * Executes the UI action associated with this menu item.
     */
    public void run() {
        this.ui.run();
    }

    /**
     * Checks if this menu item has the specified description.
     * @param description The description to check against.
     * @return true if the descriptions match, false otherwise.
     */
    public boolean hasDescription(String description) {
        return this.description.equals(description);
    }

    /**
     * Returns the string representation of this menu item (its description).
     * @return The description of this menu item.
     */
    public String toString() {
        return this.description;
    }
}
