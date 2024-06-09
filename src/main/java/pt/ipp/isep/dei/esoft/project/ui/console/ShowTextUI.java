package pt.ipp.isep.dei.esoft.project.ui.console;

import org.apache.commons.lang3.StringUtils;

/**
 * This class provides a console-based user interface for displaying a text message.
 * It allows the user to specify the text message to be displayed.
 * The class implements the Runnable interface, meaning it can be used in a thread.
 * The class includes a private instance variable to store the text message.
 * The class includes a main method, run(), which is called when the class is run as a thread.
 * This method prints the text message to the console.
 * The class includes a constructor that initializes the text message.
 * If the text message is null or empty, the constructor throws an IllegalArgumentException.
 */
public class ShowTextUI implements Runnable {

    private String text;

    /**
     * Constructs a new ShowTextUI with the specified text message.
     *
     * @param text The text message to be displayed.
     * @throws IllegalArgumentException If the text message is null or empty.
     */
    public ShowTextUI(String text) {
        if (StringUtils.isBlank(text))
            throw new IllegalArgumentException("ShowTextUI does not support null or empty text");

        this.text = text;
    }

    /**
     * Runs the ShowTextUI, printing the text message to the console.
     */
    public void run() {
        System.out.println("\n");
        System.out.println(this.text);
        System.out.println("\n");
    }
}