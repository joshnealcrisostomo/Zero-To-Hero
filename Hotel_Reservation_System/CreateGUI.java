package Hotel_Reservation_System;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Locale;

/**
 * GUI/View for the creation of hotels.
 */
public class CreateGUI extends JPanel {
    /**
     * Attributes of the class
     */
    private JPanel panel1;
    private JPanel northPanel;
    private JLabel hotelCreationLbl;
    private JPanel centerPanel;
    private JPanel westCenterPanel;
    private JPanel eastCenterPanel;
    private JPanel displayHotelsPanel;
    private JPanel southOfEastPanel;
    private JButton menuBtn;
    private JPanel hotelListLabelPanel;
    private JLabel hoteListLabel;
    private JPanel hotelListPanel;
    private JTextArea displayHotels;
    private JPanel southPanel;
    private JLabel footer;
    private JPanel northOfWestPanel;
    private JLabel numOfHotelsLabel;
    private JTextField numOfHotelField;
    private JButton enterBtn;
    private JPanel hotelInfoPanel;
    private JPanel prevBtnPanel;
    private JPanel nextBtnPanel;
    private JButton prevBtn;
    private JButton nextBtn;
    private JPanel hotelPagePanel;
    private JLabel hotelPageLabel;
    private JPanel borderSouthPanel;
    private JPanel inputPanel;
    private JPanel nameInputPanel;
    private JTextField hotelNameFld;
    private JLabel hotelNameLabel;
    private JPanel roomCountPanel;
    private JPanel displayRoomCountPanel;
    private JLabel roomCountLabel;
    private JPanel standardPanel;
    private JPanel inputStandard;
    private JTextField standardFld;
    private JPanel deluxePanel;
    private JPanel inputDeluxe;
    private JTextField deluxeFld;
    private JPanel executivePanel;
    private JPanel inputExecutive;
    private JTextField executiveFld;
    private JPanel borderPanel;
    private JLabel standardLabel;
    private JLabel deluxeLabel;
    private JLabel executiveLabel;
    private JPanel applyBtnPanel;
    private JPanel westBtnPanel;
    private JPanel eastBtnPanel;
    private JPanel btnPanel;
    private JButton applyBtn;
    private JPanel southOfHotelInfoPanel;
    private MainGUI mainFrame;

    /**
     * The sole constructor of the CreateGUI class
     *
     * @param mainFrame - the GUI/View that contains all the GUIs
     */
    public CreateGUI(MainGUI mainFrame) {
        this.mainFrame = mainFrame;
        setLayout(new BorderLayout());

        setSize(1400, 750);

        createPanels();

        setVisible(true);
    }

    /**
     * createPanels method that provides the visual components of the program
     */
    private void createPanels() {
        panel1 = new JPanel();
        panel1.setLayout(new BorderLayout(0, 0));
        panel1.setBackground(new Color(-331546));
        panel1.setMaximumSize(new Dimension(1400, 750));
        panel1.setMinimumSize(new Dimension(1400, 750));
        panel1.setOpaque(true);
        panel1.setPreferredSize(new Dimension(1400, 750));
        this.add(panel1);

        northPanel = new JPanel();
        northPanel.setLayout(new BorderLayout(0, 0));
        northPanel.setBackground(new Color(-331546));
        Font northPanelFont = this.$$$getFont$$$(null, -1, -1, northPanel.getFont());
        if (northPanelFont != null) northPanel.setFont(northPanelFont);

        panel1.add(northPanel, BorderLayout.NORTH);
        northPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(40, 60, 0, 0), null, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));

        hotelCreationLbl = new JLabel();
        hotelCreationLbl.setBackground(new Color(-331546));
        Font hotelCreationLblFont = this.$$$getFont$$$("Garamond", Font.BOLD | Font.ITALIC, 50, hotelCreationLbl.getFont());
        if (hotelCreationLblFont != null) hotelCreationLbl.setFont(hotelCreationLblFont);
        hotelCreationLbl.setForeground(new Color(-16750281));
        hotelCreationLbl.setText("Hotel Creation ");
        northPanel.add(hotelCreationLbl, BorderLayout.WEST);

        centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout(0, 0));
        centerPanel.setBackground(new Color(-331546));
        panel1.add(centerPanel, BorderLayout.CENTER);

        westCenterPanel = new JPanel();
        westCenterPanel.setLayout(new BorderLayout(0, 0));
        westCenterPanel.setBackground(new Color(-331546));
        westCenterPanel.setPreferredSize(new Dimension(800, 300));
        westCenterPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 0, 0));
        centerPanel.add(westCenterPanel, BorderLayout.WEST);

        northOfWestPanel = new JPanel();
        northOfWestPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        northOfWestPanel.setAutoscrolls(false);
        northOfWestPanel.setBackground(new Color(-331546));
        northOfWestPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));
        westCenterPanel.add(northOfWestPanel, BorderLayout.NORTH);

        numOfHotelsLabel = new JLabel();
        Font numOfHotelsLabelFont = this.$$$getFont$$$("SansSerif", Font.PLAIN, 20, numOfHotelsLabel.getFont());
        if (numOfHotelsLabelFont != null) numOfHotelsLabel.setFont(numOfHotelsLabelFont);
        numOfHotelsLabel.setForeground(new Color(-16777216));
        numOfHotelsLabel.setHorizontalAlignment(11);
        numOfHotelsLabel.setHorizontalTextPosition(11);
        numOfHotelsLabel.setText("Number of Hotels:");
        numOfHotelsLabel.setVerticalAlignment(0);
        northOfWestPanel.add(numOfHotelsLabel);

        numOfHotelField = new JTextField();
        numOfHotelField.setBackground(new Color(-2104859));
        numOfHotelField.setColumns(40);
        numOfHotelField.setHorizontalAlignment(10);
        numOfHotelField.setInheritsPopupMenu(false);
        northOfWestPanel.add(numOfHotelField);

        enterBtn = new JButton();
        enterBtn.setAutoscrolls(false);
        enterBtn.setBackground(new Color(-2500135));
        enterBtn.setBorderPainted(true);
        enterBtn.setContentAreaFilled(true);
        enterBtn.setFocusPainted(false);
        enterBtn.setForeground(new Color(-16777216));
        enterBtn.setText("ENTER");
        northOfWestPanel.add(enterBtn);

        hotelInfoPanel = new JPanel();
        hotelInfoPanel.setLayout(new BorderLayout(0, 0));
        hotelInfoPanel.setBackground(new Color(-16750281));
        westCenterPanel.add(hotelInfoPanel, BorderLayout.CENTER);

        prevBtnPanel = new JPanel();
        prevBtnPanel.setLayout(new BorderLayout(0, 0));
        prevBtnPanel.setBackground(new Color(-16750281));
        hotelInfoPanel.add(prevBtnPanel, BorderLayout.WEST);

        prevBtn = new JButton();
        prevBtn.setBackground(new Color(-16750281));
        Font prevBtnFont = this.$$$getFont$$$("Garamond", Font.BOLD, 30, prevBtn.getFont());
        if (prevBtnFont != null) prevBtn.setFont(prevBtnFont);
        prevBtn.setForeground(new Color(-331546));
        prevBtn.setText("");
        prevBtnPanel.add(prevBtn, BorderLayout.CENTER);

        nextBtnPanel = new JPanel();
        nextBtnPanel.setLayout(new BorderLayout(0, 0));
        nextBtnPanel.setBackground(new Color(-16750281));
        hotelInfoPanel.add(nextBtnPanel, BorderLayout.EAST);

        nextBtn = new JButton();
        nextBtn.setBackground(new Color(-16750281));
        Font nextBtnFont = this.$$$getFont$$$("Garamond", Font.BOLD, 30, nextBtn.getFont());
        if (nextBtnFont != null) nextBtn.setFont(nextBtnFont);
        nextBtn.setForeground(new Color(-331546));
        nextBtn.setRolloverEnabled(true);
        nextBtn.setText("");
        nextBtnPanel.add(nextBtn, BorderLayout.CENTER);

        hotelPagePanel = new JPanel();
        hotelPagePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        hotelPagePanel.setBackground(new Color(-16750281));
        hotelPagePanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        hotelInfoPanel.add(hotelPagePanel, BorderLayout.NORTH);

        hotelPageLabel = new JLabel();
        hotelPageLabel.setBackground(new Color(-16750281));
        Font hotelPageLabelFont = this.$$$getFont$$$("Garamond", Font.PLAIN, 40, hotelPageLabel.getFont());
        if (hotelPageLabelFont != null) hotelPageLabel.setFont(hotelPageLabelFont);
        hotelPageLabel.setForeground(new Color(-331546));
        hotelPageLabel.setText("Hotel");
        hotelPagePanel.add(hotelPageLabel);

        borderSouthPanel = new JPanel();
        borderSouthPanel.setLayout(new BorderLayout(0, 0));
        borderSouthPanel.setBackground(new Color(-16750281));
        borderSouthPanel.setPreferredSize(new Dimension(60, 35));
        borderSouthPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        hotelInfoPanel.add(borderSouthPanel, BorderLayout.SOUTH);

        inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout(0, 0));
        inputPanel.setBackground(new Color(-16750281));
        hotelInfoPanel.add(inputPanel, BorderLayout.CENTER);

        nameInputPanel = new JPanel();
        nameInputPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));
        nameInputPanel.setBackground(new Color(-16750281));
        inputPanel.add(nameInputPanel, BorderLayout.NORTH);

        hotelNameLabel = new JLabel();
        Font hotelNameLabelFont = this.$$$getFont$$$("Garamond", Font.PLAIN, 26, hotelNameLabel.getFont());
        if (hotelNameLabelFont != null) hotelNameLabel.setFont(hotelNameLabelFont);
        hotelNameLabel.setText("Hotel Name: ");
        hotelNameLabel.setForeground(new Color(-331546));
        nameInputPanel.add(hotelNameLabel);

        hotelNameFld = new JTextField();
        hotelNameFld.setBackground(new Color(-2104859));
        hotelNameFld.setColumns(40);
        nameInputPanel.add(hotelNameFld);

        roomCountPanel = new JPanel();
        roomCountPanel.setLayout(new BorderLayout(10, 10));
        roomCountPanel.setBackground(new Color(-16750281));
        inputPanel.add(roomCountPanel, BorderLayout.CENTER);

        displayRoomCountPanel = new JPanel();
        displayRoomCountPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        displayRoomCountPanel.setBackground(new Color(-16750281));
        roomCountPanel.add(displayRoomCountPanel, BorderLayout.NORTH);

        roomCountLabel = new JLabel();
        Font roomCountLabelFont = this.$$$getFont$$$("Garamond", Font.PLAIN, 26, roomCountLabel.getFont());
        if (roomCountLabelFont != null) roomCountLabel.setFont(roomCountLabelFont);
        roomCountLabel.setForeground(new Color(-331546));
        roomCountLabel.setText("Room Count (50 max.)");
        displayRoomCountPanel.add(roomCountLabel);

        standardPanel = new JPanel();
        standardPanel.setLayout(new BorderLayout(10, 10));
        standardPanel.setBackground(new Color(-16750281));
        roomCountPanel.add(standardPanel, BorderLayout.CENTER);

        inputStandard = new JPanel();
        inputStandard.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        inputStandard.setBackground(new Color(-16750281));
        standardPanel.add(inputStandard, BorderLayout.NORTH);

        standardLabel = new JLabel();
        Font standardLabelFont = this.$$$getFont$$$("Garamond", Font.PLAIN, 26, standardLabel.getFont());
        if (standardLabelFont != null) standardLabel.setFont(standardLabelFont);
        standardLabel.setText("Standard Room: ");
        standardLabel.setForeground(new Color(-331546));
        inputStandard.add(standardLabel);

        standardFld = new JTextField();
        standardFld.setBackground(new Color(-2104859));
        standardFld.setColumns(35);
        inputStandard.add(standardFld);

        deluxePanel = new JPanel();
        deluxePanel.setLayout(new BorderLayout(10, 10));
        deluxePanel.setBackground(new Color(-16750281));
        standardPanel.add(deluxePanel, BorderLayout.CENTER);

        inputDeluxe = new JPanel();
        inputDeluxe.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        inputDeluxe.setBackground(new Color(-16750281));
        deluxePanel.add(inputDeluxe, BorderLayout.NORTH);

        deluxeLabel = new JLabel();
        Font deluxeLabelFont = this.$$$getFont$$$("Garamond", Font.PLAIN, 26, deluxeLabel.getFont());
        if (deluxeLabelFont != null) deluxeLabel.setFont(deluxeLabelFont);
        deluxeLabel.setText("Deluxe Room: ");
        deluxeLabel.setForeground(new Color(-331546));
        inputDeluxe.add(deluxeLabel);

        deluxeFld = new JTextField();
        deluxeFld.setBackground(new Color(-2104859));
        deluxeFld.setColumns(35);
        Font deluxeFldFont = this.$$$getFont$$$(null, -1, -1, deluxeFld.getFont());
        if (deluxeFldFont != null) deluxeFld.setFont(deluxeFldFont);
        inputDeluxe.add(deluxeFld);

        executivePanel = new JPanel();
        executivePanel.setLayout(new BorderLayout(10, 10));
        executivePanel.setBackground(new Color(-16750281));
        deluxePanel.add(executivePanel, BorderLayout.CENTER);

        inputExecutive = new JPanel();
        inputExecutive.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        inputExecutive.setBackground(new Color(-16750281));
        executivePanel.add(inputExecutive, BorderLayout.NORTH);

        executiveLabel = new JLabel();
        Font exclusiveLabelFont = this.$$$getFont$$$("Garamond", Font.PLAIN, 26, executiveLabel.getFont());
        if (exclusiveLabelFont != null) executiveLabel.setFont(exclusiveLabelFont);
        executiveLabel.setRequestFocusEnabled(true);
        executiveLabel.setText("Exclusive Room: ");
        executiveLabel.setForeground(new Color(-331546));
        inputExecutive.add(executiveLabel);

        executiveFld = new JTextField();
        executiveFld.setBackground(new Color(-2104859));
        executiveFld.setColumns(35);
        inputExecutive.add(executiveFld);

        borderPanel = new JPanel();
        borderPanel.setLayout(new FlowLayout());
        borderPanel.setBackground(new Color(-16750281));
        executivePanel.add(borderPanel, BorderLayout.CENTER);

        applyBtnPanel = new JPanel();
        applyBtnPanel.setLayout(new BorderLayout(10, 25));
        applyBtnPanel.setBackground(new Color(-16750281));
        borderPanel.add(applyBtnPanel, BorderLayout.CENTER);

        westBtnPanel = new JPanel();
        westBtnPanel.setLayout(new BorderLayout(0, 0));
        westBtnPanel.setBackground(new Color(-16750281));
        westBtnPanel.setFocusable(false);
        applyBtnPanel.add(westBtnPanel, BorderLayout.WEST);

        eastBtnPanel = new JPanel();
        eastBtnPanel.setLayout(new BorderLayout(0, 0));
        eastBtnPanel.setBackground(new Color(-16750281));
        applyBtnPanel.add(eastBtnPanel, BorderLayout.EAST);

        btnPanel = new JPanel();
        btnPanel.setLayout(new BorderLayout(0, 0));
        btnPanel.setBackground(new Color(-16750281));
        applyBtnPanel.add(btnPanel, BorderLayout.SOUTH);

        applyBtn = new JButton();
        applyBtn.setBackground(new Color(-2104859));
        Font applyBtnFont = this.$$$getFont$$$("Garamond", Font.BOLD, 14, applyBtn.getFont());
        if (applyBtnFont != null) applyBtn.setFont(applyBtnFont);
        applyBtn.setForeground(new Color(-16777216));
        applyBtn.setText("APPLY");
        btnPanel.add(applyBtn, BorderLayout.CENTER);

        southOfHotelInfoPanel = new JPanel();
        southOfHotelInfoPanel.setLayout(new BorderLayout());
        southOfHotelInfoPanel.setPreferredSize(new Dimension(0, 35));
        southOfHotelInfoPanel.setBackground(new Color(-16750281));
        hotelInfoPanel.add(southOfHotelInfoPanel, BorderLayout.SOUTH);

        eastCenterPanel = new JPanel();
        eastCenterPanel.setLayout(new BorderLayout(0, 0));
        eastCenterPanel.setBackground(new Color(-331546));
        centerPanel.add(eastCenterPanel, BorderLayout.EAST);
        eastCenterPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(45, 0, 0, 50), null, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));

        displayHotelsPanel = new JPanel();
        displayHotelsPanel.setLayout(new BorderLayout(0, 0));
        displayHotelsPanel.setBackground(new Color(-3309774));
        displayHotelsPanel.setMaximumSize(new Dimension(500, 300));
        displayHotelsPanel.setMinimumSize(new Dimension(0, 0));
        displayHotelsPanel.setPreferredSize(new Dimension(500, 300));
        displayHotelsPanel.putClientProperty("html.disable", Boolean.FALSE);
        eastCenterPanel.add(displayHotelsPanel, BorderLayout.CENTER);

        hotelListLabelPanel = new JPanel();
        hotelListLabelPanel.setLayout(new BorderLayout(0, 0));
        hotelListLabelPanel.setBackground(new Color(-3309774));
        displayHotelsPanel.add(hotelListLabelPanel, BorderLayout.NORTH);
        hotelListLabelPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(30, 0, 20, 0), null, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));

        hoteListLabel = new JLabel();
        Font hoteListLabelFont = this.$$$getFont$$$("Garamond", Font.BOLD, 29, hoteListLabel.getFont());
        if (hoteListLabelFont != null) hoteListLabel.setFont(hoteListLabelFont);
        hoteListLabel.setForeground(new Color(-331546));
        hoteListLabel.setHorizontalAlignment(0);
        hoteListLabel.setText("HOTEL LIST");
        hotelListLabelPanel.add(hoteListLabel, BorderLayout.CENTER);

        hotelListPanel = new JPanel();
        hotelListPanel.setLayout(new BorderLayout(0, 0));
        displayHotelsPanel.add(hotelListPanel, BorderLayout.CENTER);

        displayHotels = new JTextArea();
        displayHotels.setBackground(new Color(-3309774));
        displayHotels.setEditable(false);
        displayHotels.setEnabled(true);
        Font displayHotelsFont = this.$$$getFont$$$("Garamond", Font.BOLD, 19, displayHotels.getFont());
        if (displayHotelsFont != null) displayHotels.setFont(displayHotelsFont);
        displayHotels.setForeground(new Color(-331546));
        displayHotels.setLineWrap(true);
        displayHotels.setMargin(new Insets(0, 90, 20, 90));
        displayHotels.setText("");
        displayHotels.setWrapStyleWord(true);
        hotelListPanel.add(displayHotels, BorderLayout.CENTER);

        southOfEastPanel = new JPanel();
        southOfEastPanel.setLayout(new BorderLayout(0, 0));
        southOfEastPanel.setBackground(new Color(-331546));
        eastCenterPanel.add(southOfEastPanel, BorderLayout.SOUTH);
        southOfEastPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0), null, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));

        menuBtn = new JButton();
        menuBtn.setBackground(new Color(-5103070));
        menuBtn.setBorderPainted(true);
        menuBtn.setContentAreaFilled(true);
        menuBtn.setDefaultCapable(true);
        menuBtn.setFocusable(false);
        Font menuBtnFont = this.$$$getFont$$$("SansSerif", Font.BOLD, 12, menuBtn.getFont());
        if (menuBtnFont != null) menuBtn.setFont(menuBtnFont);
        menuBtn.setForeground(new Color(-331546));
        menuBtn.setOpaque(true);
        menuBtn.setText("RETURN TO MAIN MENU");
        menuBtn.setVisible(true);
        southOfEastPanel.add(menuBtn, BorderLayout.EAST);

        southPanel = new JPanel();
        southPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        southPanel.setBackground(new Color(-331546));
        centerPanel.add(southPanel, BorderLayout.SOUTH);
        southPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(40, 0, 40, 0), null, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));

        footer = new JLabel();
        footer.setBackground(new Color(-331546));
        Font footerFont = this.$$$getFont$$$("Franklin Gothic Book", Font.ITALIC, 14, footer.getFont());
        if (footerFont != null) footer.setFont(footerFont);
        footer.setForeground(new Color(-16777216));
        footer.setText("Crisostomo, De Jesus. 2024.");
        southPanel.add(footer);
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
    }

    /**
     * $$$getRootComponent$$$ method that retrieves the root component of the form
     *
     * @return panel1
     */
    public JComponent $$$getRootComponent$$$() {
        return panel1;
    }

    /**
     * setActionListener method that sets the action listener for various buttons.
     *
     * @param listener The ActionListener to be set for the buttons.
     */
    public void setActionListener(ActionListener listener) {
        enterBtn.addActionListener(listener);
        applyBtn.addActionListener(listener);
        menuBtn.addActionListener(listener);
    }

    /**
     * getHotelName method that retrieves the hotel name entered in a text field
     *
     * @return name of the hotel
     */
    public String getHotelName() {
        return hotelNameFld.getText();
    }

    /**
     * getNumOfHotel method that retrieves the number of hotels entered in a text field
     *
     * @return the number of hotels to be created, otherwise 0 if input is not valid
     */
    public int getNumOfHotel() {
        try {
            return Integer.parseInt(numOfHotelField.getText());
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    /**
     * getStandardRooms method that retrieves the number of standard rooms entered in a text field.
     *
     * @return the number of standard rooms, otherwise -1 if the input is not valid
     */
    public int getStandardRooms() {
        try {
            return Integer.parseInt(standardFld.getText());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    /**
     * getDeluxeRooms method that retrieves the number of deluxe rooms entered in a text field.
     *
     * @return the number of deluxe rooms, otherwise -1 if the input is not valid
     */
    public int getDeluxeRooms() {
        try {
            return Integer.parseInt(deluxeFld.getText());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    /**
     * getExecutiveRooms method that retrieves the number of executive rooms entered in a text field.
     *
     * @return the number of executive rooms, otherwise -1 if the input is not valid
     */
    public int getExecutiveRooms() {
        try {
            return Integer.parseInt(executiveFld.getText());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    /**
     * clearInputFields method that clears multiple text fields at once
     */
    public void clearInputFields() {
        hotelNameFld.setText("");
        standardFld.setText("");
        deluxeFld.setText("");
        executiveFld.setText("");
    }

    /**
     * clearHotelFld method that clears the text field
     *
     */
    public void clearHotelFld() {
        numOfHotelField.setText("");
    }

    /**
     * setErrorMessage a method that sets the error message to be display
     *
     * @param errorMessage the error message to be display
     */
    public void setErrorMessage(String errorMessage) {
        JOptionPane.showMessageDialog(panel1, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * setHotelList method that sets the hotel list to be displayed
     *
     * @param hotelName a list of hotels to be displayed
     */
    public void setHotelList(String hotelName) {
        displayHotels.setText(hotelName);
    }

    /**
     * setInstructionMessage method that displays an instruction message in a dialog box
     *
     * @param instructionMessage the instruction message to be display
     */
    public void setInstructionMessage(String instructionMessage) {
        JOptionPane.showMessageDialog(panel1, instructionMessage, "INSTRUCTION", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * disableEnterBtn method that disables the enter button
     *
     */
    public void disableEnterBtn() {
        enterBtn.setEnabled(false);
    }

    /**
     * enableEnterBtn method that enables the enter button
     *
     */
    public void enableEnterBtn() {
        enterBtn.setEnabled(true);
    }

}
