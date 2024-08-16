package Hotel_Reservation_System;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Locale;

/**
 * GUI/View for the program's main menus.
 */
public class MainMenuGUI extends JPanel {
    /**
     * Attributes of the class
     */
    private JButton createHotelBtn;
    private JButton viewHotelBtn;
    private JButton manageHotelBtn;
    private JButton simulateBookBtn;
    private MainGUI mainFrame;

    /**
     * The sole constructor of the MainMenuGUI class
     *
     * @param mainFrame - the GUI/View that contains all the GUIs
     */
    public MainMenuGUI(MainGUI mainFrame) {
        this.mainFrame = mainFrame;
        setLayout(new BorderLayout());

        setSize(1400,750);

        designPanels();

        setVisible(true);
    }

    /**
     * designPanels method that provides the visual components of the program
     */
    private void designPanels() {
        // NORTH PANEL
        JPanel northPanel = new JPanel();
        northPanel.setLayout(new FlowLayout());
        northPanel.setBackground(Color.decode("#FAF0E6")); // sets the background of the panel

        JLabel textTitle = new JLabel("HOTEL MANAGEMENT SYSTEM");
        textTitle.setFont(new Font("Garamond", Font.BOLD, 70));
        textTitle.setBorder(BorderFactory.createEmptyBorder(50, 0, 0, 0));
        northPanel.add(textTitle);

        this.add(northPanel, BorderLayout.NORTH);

        // center panel
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setBackground(Color.decode("#FAF0E6"));

        JLabel mainMenuLabel = new JLabel(" Main Menu ");
        mainMenuLabel.setFont(new Font("Garamond", Font.ITALIC, 40));
        mainMenuLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainMenuLabel.setAlignmentY(Component.CENTER_ALIGNMENT);
        mainMenuLabel.setBorder(BorderFactory.createEmptyBorder(75, 0, 30, 0));
        centerPanel.add(mainMenuLabel);
        centerPanel.add(Box.createVerticalStrut(20));

        // buttons
        createHotelBtn = new JButton("CREATE A HOTEL");
        createHotelBtn.setActionCommand("CREATE A HOTEL");
        setButtonColor(createHotelBtn,"#FFFFFF", "#006937");
        setButtonSize(createHotelBtn, 200, 40);
        centerPanel.add(createHotelBtn);
        centerPanel.add(Box.createVerticalStrut(20));

        viewHotelBtn = new JButton("VIEW A HOTEL");
        setButtonColor(viewHotelBtn,"#FFFFFF", "#006937");
        setButtonSize(viewHotelBtn, 200, 40);
        centerPanel.add(viewHotelBtn);
        centerPanel.add(Box.createVerticalStrut(20));

        manageHotelBtn = new JButton("MANAGE A HOTEL");
        setButtonColor(manageHotelBtn,"#FFFFFF", "#006937");
        setButtonSize(manageHotelBtn, 200, 40);
        centerPanel.add(manageHotelBtn);
        centerPanel.add(Box.createVerticalStrut(20));

        simulateBookBtn = new JButton("SIMULATE BOOKING");
        setButtonColor(simulateBookBtn, "#FFFFFF", "#006937");
        setButtonSize(simulateBookBtn, 200, 40);
        centerPanel.add(simulateBookBtn);
        centerPanel.add(Box.createVerticalStrut(20));

        this.add(centerPanel, BorderLayout.CENTER);

        // this is a band-aid solution only
        JPanel eastPanel = new JPanel();
        eastPanel.setBackground(Color.decode("#FAF0E6"));
        JPanel westPanel = new JPanel();
        westPanel.setBackground(Color.decode("#FAF0E6"));

        // south panel
        JPanel southPanel = new JPanel();
        southPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        southPanel.setBackground(new Color(-331546));
        southPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(40, 0, 40, 0), null, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));

        JLabel footer = new JLabel();
        footer.setBackground(new Color(-331546));
        Font footerFont = this.$$$getFont$$$("Franklin Gothic Book", Font.ITALIC, 14, footer.getFont());
        if (footerFont != null) footer.setFont(footerFont);
        footer.setForeground(new Color(-16777216));
        footer.setText("Crisostomo, De Jesus. 2024.");
        southPanel.add(footer);

        this.add(southPanel, BorderLayout.SOUTH);
        this.add(eastPanel, BorderLayout.EAST);
        this.add(westPanel, BorderLayout.WEST);
    }

    /**
     * setButtonSize method that sets the size attributes of a button
     *
     * @param button The JButton object whose size is to be set.
     * @param width The width of the button in pixels.
     * @param height The height of the button in pixels
     */
    private void setButtonSize(JButton button, int width, int height) {
        Dimension dimension = new Dimension(width, height);
        button.setPreferredSize(dimension);
        button.setMaximumSize(dimension);
        button.setMinimumSize(dimension);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
    }

    /**
     * setButtonColor method that sets the color attributes of a button
     *
     * @param button The JButton object whose colors are to be set
     * @param foreColor The hexadecimal color code or name for the foreground (text) color
     * @param backColor The hexadecimal color code or name for the background color
     */
    private void setButtonColor(JButton button, String foreColor, String backColor) {
        button.setForeground(Color.decode(foreColor));
        button.setBackground(Color.decode(backColor));
    }

    /**
     * $$$getFont$$$ method that retrieves a Font object with specified attributes, handling platform-specific font fallbacks.
     *
     * @param fontName The name of the font to use
     * @param style The style of the font
     * @param size The size of the font
     * @param currentFont The current Font object to base attributes on
     *
     * @return A Font object configured with the specified attributes and appropriate platform fallbacks.
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        Font font = new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
        boolean isMac = System.getProperty("os.name", "").toLowerCase(Locale.ENGLISH).startsWith("mac");
        Font fontWithFallback = isMac ? new Font(font.getFamily(), font.getStyle(), font.getSize()) : new StyleContext().getFont(font.getFamily(), font.getStyle(), font.getSize());
        return fontWithFallback instanceof FontUIResource ? fontWithFallback : new FontUIResource(fontWithFallback);
    }

    /**
     * setActionListener method adds a listener to the appropriate GUI components
     *
     * @param listener - listens to the action
     */
    public void setActionListener(ActionListener listener) {
        createHotelBtn.addActionListener(listener);
        viewHotelBtn.addActionListener(listener);
        manageHotelBtn.addActionListener(listener);
        simulateBookBtn.addActionListener(listener);
    }

    /**
     * setErrorMessage a method that sets the error message to be display
     *
     * @param error the error message to be display
     */
    public void setErrorMessage(String error) {
        JOptionPane.showMessageDialog(this, error, "Error", JOptionPane.ERROR_MESSAGE);
    }
}

