package Hotel_Reservation_System;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Locale;

/**
 * GUI/View for the booking simulation.
 */
public class SimBookGUI extends JPanel {
    /**
     * Attributes of the class
     */
    private JPanel mainPanel;
    private JPanel northPanel;
    private JPanel eastPanel;
    private JPanel southPanel;
    private JPanel westPanel;
    private JButton RETURNTOMAINMENUButton;
    private JPanel northOfEast;
    private JPanel southOfEast;
    private JTextArea textArea1;
    private JPanel centerOfEast;
    private JTextField textField1;
    private JButton ENTERButton;
    private JButton BOOK;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JLabel label2;
    private JPanel gridBagLayoutPanel;
    private JPanel bookBtnPanel;
    private JPanel hotelNameBkngPanel;
    private JPanel northOfWest;
    private JTextArea hotelToDisplay;
    private MainGUI mainFrame;
    private JLabel label4;

    /**
     * The sole constructor of the SimBookGUI class
     *
     * @param mainFrame - the GUI/View that contains all the GUIs
     */
    public SimBookGUI(MainGUI mainFrame) {
        this.mainFrame = mainFrame;
        setLayout(new BorderLayout());
        setSize(1400, 750);
        $$$setupUI$$$();
        setVisible(true);
    }

    /**
     * $$$setupUI$$$ method that provides the visual components of the program
     */
    private void $$$setupUI$$$() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(0, 0));
        mainPanel.setBackground(new Color(-331546));
        mainPanel.setMaximumSize(new Dimension(1400, 750));
        mainPanel.setMinimumSize(new Dimension(1400, 750));
        mainPanel.setPreferredSize(new Dimension(1400, 750));
        this.add(mainPanel);

        northPanel = new JPanel();
        northPanel.setLayout(new BorderLayout(0, 0));
        northPanel.setBackground(new Color(-331546));
        mainPanel.add(northPanel, BorderLayout.NORTH);
        northPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(40, 60, 0, 0), null, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
        final JLabel label1 = new JLabel();
        Font label1Font = this.$$$getFont$$$("Garamond", Font.BOLD, 50, label1.getFont());
        if (label1Font != null) label1.setFont(label1Font);
        label1.setForeground(new Color(-16750281));
        label1.setText("Simulate Booking");
        northPanel.add(label1, BorderLayout.SOUTH);
        eastPanel = new JPanel();
        eastPanel.setLayout(new BorderLayout(0, 0));
        eastPanel.setBackground(new Color(-331546));
        eastPanel.setMaximumSize(new Dimension(744, 38));
        mainPanel.add(eastPanel, BorderLayout.EAST);
        eastPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(20, 100, 0, 90), null, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
        southOfEast = new JPanel();

        southOfEast.setLayout(new GridLayout(1,1));

        southOfEast.setBackground(new Color(-331546));
        eastPanel.add(southOfEast, BorderLayout.SOUTH);
        southOfEast.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(40, 280, 0, 0), null, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
        RETURNTOMAINMENUButton = new JButton();
        RETURNTOMAINMENUButton.setBackground(new Color(-43177));
        RETURNTOMAINMENUButton.setText("RETURN TO MAIN MENU");
        RETURNTOMAINMENUButton.setForeground(new Color(-331546));

        southOfEast.add(RETURNTOMAINMENUButton);

        northOfEast = new JPanel();
        northOfEast.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        northOfEast.setBackground(new Color(-3309774));
        eastPanel.add(northOfEast, BorderLayout.NORTH);
        northOfEast.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0), null, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));

        label2 = new JLabel();
        Font label2Font = this.$$$getFont$$$("Garamond", Font.BOLD, 29, label2.getFont());
        if (label2Font != null) label2.setFont(label2Font);
        label2.setForeground(Color.decode("#FAF0E6"));
        label2.setText("HOTEL LIST");
        northOfEast.add(label2);

        centerOfEast = new JPanel();
        centerOfEast.setLayout(new GridLayout(1,1));
        centerOfEast.setPreferredSize(new Dimension(500, 54));
        centerOfEast.setRequestFocusEnabled(true);
        eastPanel.add(centerOfEast, BorderLayout.CENTER);
        centerOfEast.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0), null, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));

        textArea1 = new JTextArea();
        textArea1.setBackground(new Color(-3309774));
        textArea1.setEditable(false);
        textArea1.setEnabled(true);
        Font textArea1Font = this.$$$getFont$$$("Garamond", Font.BOLD, 16, textArea1.getFont());
        if (textArea1Font != null) textArea1.setFont(textArea1Font);
        textArea1.setForeground(new Color(-331546));
        textArea1.setLineWrap(true);
        textArea1.setMargin(new Insets(30, 40, 20, 40));
        textArea1.setText("");
        textArea1.setWrapStyleWord(true);
        centerOfEast.add(textArea1);

        JScrollPane scrollPane = new JScrollPane(textArea1);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(700, 300));
        centerOfEast.add(scrollPane, BorderLayout.CENTER);

        southPanel = new JPanel();
        southPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        southPanel.setBackground(new Color(-331546));
        mainPanel.add(southPanel, BorderLayout.SOUTH);
        southPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(40, 0, 40, 0), null, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
        final JLabel label3 = new JLabel();
        Font label3Font = this.$$$getFont$$$("Franklin Gothic Book", Font.ITALIC, 14, label3.getFont());
        if (label3Font != null) label3.setFont(label3Font);
        label3.setForeground(new Color(-16777216));
        label3.setText("Crisostomo, De Jesus. 2024.");
        southPanel.add(label3);

        westPanel = new JPanel();
        westPanel.setLayout(new BorderLayout(0, 0));
        westPanel.setBackground(new Color(-331546));
        mainPanel.add(westPanel, BorderLayout.CENTER);
        westPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(20, 90, 0, 0), null, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));

        final JPanel panel1 = new JPanel();
        panel1.setLayout(new BorderLayout(0, 0));
        panel1.setBackground(new Color(-16750281));
        panel1.setPreferredSize(new Dimension(1020, 24));
        westPanel.add(panel1, BorderLayout.CENTER);
        panel1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0), null, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));

        hotelNameBkngPanel = new JPanel();
        hotelNameBkngPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        hotelNameBkngPanel.setBackground(new Color(-16750281));
        panel1.add(hotelNameBkngPanel, BorderLayout.NORTH);

        label4 = new JLabel();
        Font label4Font = this.$$$getFont$$$("Garamond", Font.BOLD, 28, label4.getFont());
        if (label4Font != null) label4.setFont(label4Font);
        label4.setForeground(new Color(-331546));
        label4.setText("BOOKING FOR [-]");
        label4.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        hotelNameBkngPanel.add(label4);

        bookBtnPanel = new JPanel();
        bookBtnPanel.setLayout(new GridLayout(1,1));
        bookBtnPanel.setBackground(new Color(-16750281));
        panel1.add(bookBtnPanel, BorderLayout.SOUTH);
        bookBtnPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(0, 220, 20, 220), null, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));

        BOOK = new JButton();
        BOOK.setBackground(new Color(-2500135));
        BOOK.setText("BOOK");
        BOOK.setBorder(BorderFactory.createEmptyBorder(10,0,10,0));
        bookBtnPanel.add(BOOK);

        gridBagLayoutPanel = new JPanel();
        gridBagLayoutPanel.setLayout(new GridBagLayout());
        gridBagLayoutPanel.setBackground(new Color(-16750281));
        panel1.add(gridBagLayoutPanel, BorderLayout.CENTER);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(0, 0, 10, 0);

        final JLabel label5 = new JLabel();
        Font label5Font = this.$$$getFont$$$("SansSerif", Font.ITALIC, 25, label5.getFont());
        if (label5Font != null) label5.setFont(label5Font);
        label5.setForeground(new Color(-331546));
        label5.setText("Guest Name:      ");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gridBagLayoutPanel.add(label5, gbc);

        final JLabel label6 = new JLabel();
        Font label6Font = this.$$$getFont$$$("SansSerif", Font.ITALIC, 25, label6.getFont());
        if (label6Font != null) label6.setFont(label6Font);
        label6.setForeground(new Color(-331546));
        label6.setText("Room Type:     ");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gridBagLayoutPanel.add(label6, gbc);

        final JLabel label7 = new JLabel();
        Font label7Font = this.$$$getFont$$$("SansSerif", Font.ITALIC, 25, label7.getFont());
        if (label7Font != null) label7.setFont(label7Font);
        label7.setForeground(new Color(-331546));
        label7.setText("Room Number: ");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gridBagLayoutPanel.add(label7, gbc);

        final JLabel label8 = new JLabel();
        Font label8Font = this.$$$getFont$$$("SansSerif", Font.ITALIC, 25, label8.getFont());
        if (label8Font != null) label8.setFont(label8Font);
        label8.setForeground(new Color(-331546));
        label8.setText("Check-out Date: ");
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        gridBagLayoutPanel.add(label8, gbc);

        final JLabel label9 = new JLabel();
        Font label9Font = this.$$$getFont$$$("SansSerif", Font.ITALIC, 25, label9.getFont());
        if (label9Font != null) label9.setFont(label9Font);
        label9.setForeground(new Color(-331546));
        label9.setText("Discount Code: ");
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.WEST;
        gridBagLayoutPanel.add(label9, gbc);

        final JLabel label10 = new JLabel();
        Font label10Font = this.$$$getFont$$$("SansSerif", Font.ITALIC, 25, label10.getFont());
        if (label10Font != null) label10.setFont(label10Font);
        label10.setForeground(new Color(-331546));
        label10.setText("Check-In Date: ");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        gridBagLayoutPanel.add(label10, gbc);

        textField2 = new JTextField();
        textField2.setBackground(new Color(-2500135));
        textField2.setPreferredSize(new Dimension(330, 34));
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gridBagLayoutPanel.add(textField2, gbc);

        textField3 = new JTextField();
        textField3.setBackground(new Color(-2500135));
        textField3.setPreferredSize(new Dimension(330, 34));
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gridBagLayoutPanel.add(textField3, gbc);

        textField4 = new JTextField();
        textField4.setBackground(new Color(-2500135));
        textField4.setPreferredSize(new Dimension(330, 34));
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gridBagLayoutPanel.add(textField4, gbc);

        textField5 = new JTextField();
        textField5.setBackground(new Color(-2500135));
        textField5.setPreferredSize(new Dimension(330, 34));
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gridBagLayoutPanel.add(textField5, gbc);

        textField6 = new JTextField();
        textField6.setBackground(new Color(-2500135));
        textField6.setPreferredSize(new Dimension(330, 34));
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gridBagLayoutPanel.add(textField6, gbc);

        textField7 = new JTextField();
        textField7.setBackground(new Color(-2500135));
        textField7.setPreferredSize(new Dimension(330, 34));
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gridBagLayoutPanel.add(textField7, gbc);

        northOfWest = new JPanel();
        northOfWest.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        northOfWest.setBackground(new Color(-331546));
        westPanel.add(northOfWest, BorderLayout.NORTH);
        northOfWest.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0), null, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));

        final JLabel label11 = new JLabel();
        Font label11Font = this.$$$getFont$$$("SansSerif", Font.ITALIC, 25, label11.getFont());
        if (label11Font != null) label11.setFont(label11Font);
        label11.setForeground(new Color(-16777216));
        label11.setText("Enter hotel name: ");
        northOfWest.add(label11);

        textField1 = new JTextField();
        textField1.setBackground(new Color(-2500135));
        textField1.setPreferredSize(new Dimension(230, 34));
        northOfWest.add(textField1);

        ENTERButton = new JButton();
        ENTERButton.setBackground(new Color(-2500135));
        ENTERButton.setText("ENTER");
        northOfWest.add(ENTERButton);
    }

    /**
     * $$$getFont$$$ method that retrieves a Font object with specified attributes, handling platform-specific font fallbacks.
     *
     * @param fontName The name of the font to use
     * @param style The style of the font
     * @param size The size of the font.
     * @param currentFont The current Font object to base attributes on.
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
    } // add a description to the java doc

    /**
     * $$$getRootComponent$$$ method that returns the main panel of the GUI.
     *
     * @return mainPanel The main panel of the GUI.
     */
    public JComponent $$$getRootComponent$$$() {
        return mainPanel;
    }

    /**
     * setActionListener method that sets the action listener for various buttons.
     *
     * @param listener The ActionListener to be set for the buttons.
     */
    public void setActionListener(ActionListener listener) {
        RETURNTOMAINMENUButton.addActionListener(listener);
        ENTERButton.addActionListener(listener);
        BOOK.addActionListener(listener);
    }

    /**
     * showConfirmationMessage method that displays a confirmation dialog and returns the user's choice.
     *
     * @return The user's choice: either JOptionPane.YES_OPTION or JOptionPane.NO_OPTION.
     */
    public int showConfirmationMessage() {
        return JOptionPane.showConfirmDialog(mainPanel,
                "Do you want to continue with the reservation?",
                "CONFIRMATION",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );
    }

    /**
     * getYesOption method that returns a constant for a "Yes" option.
     *
     * @return The constant value for "Yes" option (JOptionPane.YES_OPTION).
     */
    public int getYesOption() {
        return JOptionPane.YES_OPTION;
    }

    /**
     * getNoOption method that returns a constant for a "No" option.
     *
     * @return The constant value for "No" option (JOptionPane.NO_OPTION).
     */
    public int getNoOption() {
        return JOptionPane.NO_OPTION;
    }

    /**
     * handleYesChangeOption method that handles the action when the user selects "Yes".
     */
    public void handleYesChangeOption() {
        JOptionPane.showMessageDialog(mainPanel, "CHANGE WAS APPLIED");
        clearInputFields();
    }

    /**
     * handleNoChangeOption method that handles the action when the user selects "No".
     */
    public void handleNoChangeOption() {
        JOptionPane.showMessageDialog(mainPanel, "CHANGE WAS NOT APPLIED");
    }


    /**
     * clearInputFields method that clears multiple text fields at once
     *
     */
    public void clearInputFields() {
        textField1.setText("");
        textField2.setText("");
        textField3.setText("");
        textField4.setText("");
        textField5.setText("");
        textField6.setText("");
        textField7.setText("");
    }

    /**
     * setErrorMessage a method that sets the error message to be display
     *
     * @param errorMessage the error message to be display
     */
    public void setErrorMessage(String errorMessage) {
        JOptionPane.showMessageDialog(mainPanel, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * updateTextArea method that updates and displays the information
     *
     * @param info a String that holds the information to be displayed
     */
    public void updateTextArea(String info) {
        textArea1.setText(info);
    }

    /**
     * getHotelName method that retrieves the hotel name entered in the text field
     *
     * @return hotel name
     */
    public String getHotelName() {
        return textField1.getText();
    }

    /**
     * getGuestName method that retrieves the guest nae entered in the text field
     *
     * @return guest name
     */
    public String getGuestName() {
        return textField2.getText();
    }

    /**
     * getRoomType method that retrieves the room type entered in the text field
     *
     * @return room type
     */
    public String getRoomType() {
        return textField3.getText();
    }

    /**
     * getRoomNumber method that retrieves the room number entered in the text field
     *
     * @return room number
     */
    public int getRoomNumber() {
        try {
            return Integer.parseInt(textField4.getText());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    /**
     * getCheckIn method that retrieves the check-in date entered in the text field
     *
     * @return check in date, otherwise -1 if input is not valid
     */
    public int getCheckIn() {
        try {
            return Integer.parseInt(textField5.getText());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    /**
     * getCheckOut method that retrieves the check-out date entered in the text field
     *
     * @return check out date, otherwise -1 if input is not valid
     */
    public int getCheckOut() {
        try {
            return Integer.parseInt(textField6.getText());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    /**
     * getDiscountCode method retrieves the discount code entered in the text field
     *
     * @return discount code
     */
    public String getDiscountCode() {
        return textField7.getText();
    }

    /**
     * setInstructionMessage method that displays an instruction message in a dialog box.
     *
     * @param instructionMessage The instruction message to be displayed.
     */
    public void setInstructionMessage(String instructionMessage) {
        JOptionPane.showMessageDialog(mainPanel, instructionMessage, "INSTRUCTION", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * setHotelList method that sets the hotel list to be displayed
     *
     * @param hotelList a list of hotels to be displayed
     */
    public void setHotelList(String hotelList) {
        updateTextArea(hotelList);
    }

    /**
     * setTextAreaLabel method that sets
     *
     * @param label a String that holds
     */
    public void setTextAreaLabel(String label) {
        label2.setText(label);
    }

    /**
     * setLabel4 method that sets and displays the name of hotel to be book
     *
     * @param hotel a String that holds the name of the hotel to be book
     */
    public void setLabel4(String hotel) {
        label4.setText("BOOKING FOR [" + hotel + "]");
    }

    /**
     * clearTextArea method that clears a text field
     *
     */
    public void clearTextArea() {
        textArea1.setText("");
    }
}



