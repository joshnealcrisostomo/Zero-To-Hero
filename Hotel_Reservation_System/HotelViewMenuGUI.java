package Hotel_Reservation_System;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Locale;

/**
 * GUI/View for the viewing of hotels.
 */
public class HotelViewMenuGUI extends JPanel {
    /**
     * Attributes of the class
     */
    private JPanel mainPanel;
    private JPanel northPanel;
    private JLabel hotelViewingLbl;
    private JLabel hotelNameInfoLbl, guestNameLbl;
    private JPanel centerPanel;
    private JPanel westCenterPanel;
    private JPanel eastCenterPanel;
    private JPanel southPanel;
    private JLabel footer;
    private JPanel headerPanel;
    private JPanel displayInfoPanel;
    private JPanel viewLabelPanel;
    private JLabel viewChoiceLabel;
    private JPanel updatingInfoPanel;
    private JTextArea viewInfoTextArea;
    private JPanel viewChoicesPanel;
    private JButton roomAvailBtn;
    private JButton roomInfoBtn;
    private JButton reserveInfoBtn;
    private JButton returnMainMenuBtn;
    private JButton highLvlBtn;
    private JLabel selectDateLbl, selectRoomLbl, checkInLbl, checkOutLbl;
    private JButton applyBtn;
    private JTextField dateInput, checkOutFld, checkInFld;
    private JTextField roomInput, roomNumInput, guestNameFld;
    private JPanel northOfHeader, southOfHeader;
    private MainGUI mainFrame;

    /**
     * The sole constructor of the HotelViewGUI class
     *
     * @param mainFrame - the GUI/View that contains all the GUIs
     */
    public HotelViewMenuGUI(MainGUI mainFrame) {
        this.mainFrame = mainFrame;
        setLayout(new BorderLayout());

        setSize(1400,750);

        viewHotel();

        setVisible(true);
    }


    /**
     * viewHotel method that provides the visual components of the program
     */
    private void viewHotel() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(0, 0));
        mainPanel.setBackground(new Color(-331546));
        mainPanel.setMaximumSize(new Dimension(1400, 750));
        mainPanel.setMinimumSize(new Dimension(1400, 750));
        mainPanel.setOpaque(true);
        mainPanel.setPreferredSize(new Dimension(1400, 750));
        this.add(mainPanel);

        northPanel = new JPanel();
        northPanel.setLayout(new BorderLayout());
        northPanel.setBackground(new Color(-331546));
        mainPanel.add(northPanel, BorderLayout.NORTH);
        northPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(40, 60, 0, 0), null, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));

        hotelViewingLbl = new JLabel();
        hotelViewingLbl.setBackground(new Color(-331546));
        Font hotelViewingLblFont = this.getFont("Garamond", Font.BOLD | Font.ITALIC, 50, hotelViewingLbl.getFont());
        if (hotelViewingLblFont != null) hotelViewingLbl.setFont(hotelViewingLblFont);
        hotelViewingLbl.setForeground(new Color(-16750281));
        hotelViewingLbl.setText("Hotel Viewing ");
        northPanel.add(hotelViewingLbl, BorderLayout.WEST);

        hotelNameInfoLbl = new JLabel();
        hotelNameInfoLbl.setBackground(new Color(-331546));
        Font hotelNameInfoLblFont = this.getFont("Garamond", Font.BOLD, 50, hotelNameInfoLbl.getFont());
        if (hotelNameInfoLblFont != null) hotelNameInfoLbl.setFont(hotelNameInfoLblFont);
        hotelNameInfoLbl.setForeground(new Color(-16750281));
        northPanel.add(hotelNameInfoLbl, BorderLayout.CENTER);

        centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout(0, 0));
        centerPanel.setBackground(new Color(-331546));
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        centerPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0), null, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));

        westCenterPanel = new JPanel();
        westCenterPanel.setLayout(new BorderLayout(0, 0));
        westCenterPanel.setBackground(new Color(-331546));
        westCenterPanel.setPreferredSize(new Dimension(600, 49));
        centerPanel.add(westCenterPanel, BorderLayout.WEST);
        westCenterPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(0, 50, 0, 30), null, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));

        viewChoicesPanel = new JPanel();
        viewChoicesPanel.setLayout(new GridBagLayout());
        viewChoicesPanel.setBackground(new Color(-331546));
        westCenterPanel.add(viewChoicesPanel, BorderLayout.CENTER);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(20, 0, 20, 0);
        gbc.gridx = 0;

        highLvlBtn = new JButton();
        highLvlBtn.setBackground(new Color(-16750281));
        Font highLvlBtnFont = this.getFont("SansSerif", Font.BOLD, 18, highLvlBtn.getFont());
        if (highLvlBtnFont != null) highLvlBtn.setFont(highLvlBtnFont);
        highLvlBtn.setPreferredSize(new Dimension(500, 40));
        highLvlBtn.setForeground(new Color(-331546));
        highLvlBtn.setText("High-Level Information");
        gbc.gridy = 0;
        viewChoicesPanel.add(highLvlBtn, gbc);

        roomAvailBtn = new JButton();
        roomAvailBtn.setBackground(new Color(-16750281));
        Font roomAvailBtnFont = this.getFont("SansSerif", Font.BOLD, 18, roomAvailBtn.getFont());
        if (roomAvailBtnFont != null) roomAvailBtn.setFont(roomAvailBtnFont);
        roomAvailBtn.setPreferredSize(new Dimension(500, 40));
        roomAvailBtn.setForeground(new Color(-331546));
        roomAvailBtn.setHorizontalTextPosition(11);
        roomAvailBtn.setText("Room Availability For A Selected Date");
        gbc.gridy = 1;
        viewChoicesPanel.add(roomAvailBtn, gbc);

        roomInfoBtn = new JButton();
        roomInfoBtn.setBackground(new Color(-16750281));
        Font roomInfoBtnFont = this.getFont("SansSerif", Font.BOLD, 18, roomInfoBtn.getFont());
        if (roomInfoBtnFont != null) roomInfoBtn.setFont(roomInfoBtnFont);
        roomInfoBtn.setPreferredSize(new Dimension(500, 40));
        roomInfoBtn.setForeground(new Color(-331546));
        roomInfoBtn.setText("Room Information");
        gbc.gridy = 2;
        viewChoicesPanel.add(roomInfoBtn, gbc);

        reserveInfoBtn = new JButton();
        reserveInfoBtn.setBackground(new Color(-16750281));
        Font reserveInfoBtnFont = this.getFont("SansSerif", Font.BOLD, 18, reserveInfoBtn.getFont());
        if (reserveInfoBtnFont != null) reserveInfoBtn.setFont(reserveInfoBtnFont);
        reserveInfoBtn.setPreferredSize(new Dimension(500, 40));
        reserveInfoBtn.setForeground(new Color(-331546));
        reserveInfoBtn.setText("Reservation Information");
        gbc.gridy = 3;
        viewChoicesPanel.add(reserveInfoBtn, gbc);

        returnMainMenuBtn = new JButton();
        returnMainMenuBtn.setBackground(new Color(-5103070));
        Font returnMainMenuBtnFont = this.getFont("SansSerif", Font.BOLD, 18, returnMainMenuBtn.getFont());
        if (returnMainMenuBtnFont != null) returnMainMenuBtn.setFont(returnMainMenuBtnFont);
        returnMainMenuBtn.setPreferredSize(new Dimension(500, 40));
        returnMainMenuBtn.setForeground(new Color(-331546));
        returnMainMenuBtn.setText("RETURN TO MAIN MENU");
        gbc.gridy = 4;
        viewChoicesPanel.add(returnMainMenuBtn, gbc);

        eastCenterPanel = new JPanel();
        eastCenterPanel.setLayout(new BorderLayout(0, 0));
        eastCenterPanel.setBackground(new Color(-331546));
        eastCenterPanel.setMinimumSize(new Dimension(0, 0));
        eastCenterPanel.setPreferredSize(new Dimension(800, 400));
        centerPanel.add(eastCenterPanel, BorderLayout.EAST);
        eastCenterPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(0, 0, 0, 50), null, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));

        headerPanel = new JPanel();
        headerPanel.setLayout(new BorderLayout());
        headerPanel.setBackground(new Color(-331546));
        headerPanel.setOpaque(true);
        headerPanel.setPreferredSize(new Dimension(500, 100));
        eastCenterPanel.add(headerPanel, BorderLayout.NORTH);

        northOfHeader = new JPanel();
        northOfHeader.setLayout(new FlowLayout());
        northOfHeader.setBackground(new Color(-331546));
        northOfHeader.setBorder(BorderFactory.createEmptyBorder(10,0,0,0));
        headerPanel.add(northOfHeader, BorderLayout.NORTH);

        southOfHeader = new JPanel();
        southOfHeader.setLayout(new FlowLayout());
        southOfHeader.setBackground(new Color(-331546));
        southOfHeader.setBorder(BorderFactory.createEmptyBorder(0,0,10,0));
        headerPanel.add(southOfHeader, BorderLayout.SOUTH);

        applyBtn = new JButton();
        applyBtn.setBackground(new Color(-331546));
        applyBtn.setText("");
        headerPanel.add(applyBtn);

        displayInfoPanel = new JPanel();
        displayInfoPanel.setLayout(new BorderLayout(0, 0));
        displayInfoPanel.setBackground(new Color(-3309774));
        displayInfoPanel.setPreferredSize(new Dimension(500, 300));
        eastCenterPanel.add(displayInfoPanel, BorderLayout.CENTER);

        viewLabelPanel = new JPanel();
        viewLabelPanel.setLayout(new BorderLayout(0, 0));
        viewLabelPanel.setBackground(new Color(-3309774));
        displayInfoPanel.add(viewLabelPanel, BorderLayout.NORTH);
        viewLabelPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0), null, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));

        viewChoiceLabel = new JLabel();
        viewChoiceLabel.setBackground(new Color(-3309774));
        viewChoiceLabel.setForeground(new Color(-331546));
        Font viewChoiceLabelFont = this.getFont("Garamond", Font.BOLD, 26, viewChoiceLabel.getFont());
        if (viewChoiceLabelFont != null) viewChoiceLabel.setFont(viewChoiceLabelFont);
        viewChoiceLabel.setHorizontalAlignment(0);
        viewLabelPanel.add(viewChoiceLabel, BorderLayout.CENTER);

        updatingInfoPanel = new JPanel();
        updatingInfoPanel.setLayout(new BorderLayout(0, 0));
        displayInfoPanel.add(updatingInfoPanel, BorderLayout.CENTER);

        viewInfoTextArea = new JTextArea();
        viewInfoTextArea.setBackground(new Color(-3309774));
        viewInfoTextArea.setForeground(new Color(-331546));
        viewInfoTextArea.setEditable(false);
        Font viewInfoTextAreaFont = this.getFont("Garamond", Font.BOLD, 19, viewInfoTextArea.getFont());
        if (viewInfoTextAreaFont != null) viewInfoTextArea.setFont(viewInfoTextAreaFont);
        viewInfoTextArea.setLineWrap(true);
        viewInfoTextArea.setMargin(new Insets(30, 40, 20, 20));
        viewInfoTextArea.setWrapStyleWord(true);
        updatingInfoPanel.add(viewInfoTextArea, BorderLayout.CENTER);

        JScrollPane scrollPane = new JScrollPane(viewInfoTextArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(500, 300));
        updatingInfoPanel.add(scrollPane, BorderLayout.CENTER);

        southPanel = new JPanel();
        southPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        southPanel.setBackground(new Color(-331546));
        centerPanel.add(southPanel, BorderLayout.SOUTH);
        southPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(40, 0, 40, 0), null, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));

        footer = new JLabel();
        footer.setBackground(new Color(-331546));
        Font footerFont = this.getFont("Franklin Gothic Book", Font.ITALIC, 14, footer.getFont());
        if (footerFont != null) footer.setFont(footerFont);
        footer.setForeground(new Color(-16777216));
        footer.setText("Crisostomo, De Jesus. 2024.");
        southPanel.add(footer);
    }

    private Font getFont(String fontName, int style, int size, Font currentFont) {
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

    public JComponent $$$getRootComponent$$$() {
        return mainPanel;
    }

    /**
     * setViewHotelName method sets the current hotel's name
     *
     * @param hotelName - a String value that holds the hotel name input
     */
    public void setViewHotelName(String hotelName) {
        hotelNameInfoLbl.setText("[" + hotelName + " Information]");
    }

    /**
     * clearTextArea method clears/resets the text inside the text area
     */
    public void clearTextArea() {
        viewInfoTextArea.setText("");
    }

    /**
     * updateTextArea method updates the text area with the appropriate information
     *
     * @param newInfo - a String value that holds the new information
     */
    public void updateTextArea(String newInfo) {
        viewInfoTextArea.setText(newInfo);
    }

    /**
     * updateViewChoiceLabel method updates the title of the text area with the appropriate option title
     *
     * @param newTitle - a string value that holds the title of the text area
     */
    public void updateViewChoiceLabel(String newTitle) {
        viewChoiceLabel.setText(newTitle);
    }

    /**
     * updateForHighLvlInfo method updates the right side of the GUI with the appropriate information
     *
     * @param highLvlInfo - a string that holds the high-level info of a hotel
     */
    public void updateForHighLvlInfo(String highLvlInfo) {
        northOfHeader.removeAll();
        southOfHeader.removeAll();

        updateViewChoiceLabel("HIGH-LEVEL INFORMATION");
        updateTextArea(highLvlInfo);

        northOfHeader.removeAll();
        southOfHeader.removeAll();
    }

    /**
     * updateForRoomAvail method updates the right side of the GUI with the appropriate text fields, buttons, and information
     */
    public void updateForRoomAvail() {
        updateViewChoiceLabel("ROOM DAY AVAILABILITY");

        northOfHeader.removeAll();
        southOfHeader.removeAll();

        selectDateLbl = new JLabel();
        Font selectDateLblFont = this.getFont("SansSerif", Font.PLAIN, 25, selectDateLbl.getFont());
        if (selectDateLblFont != null) selectDateLbl.setFont(selectDateLblFont);
        selectDateLbl.setForeground(new Color(-16777216));
        selectDateLbl.setText("Selected Date [December 2024]: ");
        northOfHeader.add(selectDateLbl);

        dateInput = new JTextField();
        dateInput.setColumns(10);
        northOfHeader.add(dateInput);

        applyBtn.setText("APPLY");
        applyBtn.setBackground(new Color(-2500135));
        southOfHeader.add(applyBtn);

        northOfHeader.revalidate();
        northOfHeader.repaint();

        southOfHeader.revalidate();
        southOfHeader.repaint();
    }

    /**
     * updateForRoomInfo method updates the right side of the GUI with the appropriate text fields, buttons, and information
     */
    public void updateForRoomInfo() {
        updateViewChoiceLabel("ROOM INFORMATION");

        northOfHeader.removeAll();
        southOfHeader.removeAll();

        selectRoomLbl = new JLabel();
        Font selectRoomLblFont = this.getFont("SansSerif", Font.PLAIN, 25, selectRoomLbl.getFont());
        if (selectRoomLblFont != null) selectRoomLbl.setFont(selectRoomLblFont);
        selectRoomLbl.setForeground(new Color(-16777216));
        selectRoomLbl.setText("Room Number: ");
        northOfHeader.add(selectRoomLbl);

        roomInput = new JTextField();
        roomInput.setColumns(10);
        northOfHeader.add(roomInput);

        applyBtn.setBackground(new Color(-2500135));
        applyBtn.setText("APPLY");
        southOfHeader.add(applyBtn);

        northOfHeader.revalidate();
        northOfHeader.repaint();

        southOfHeader.revalidate();
        southOfHeader.repaint();
    }

    /**
     * updateForReservationInfo method updates the right side of the GUI with the appropriate text fields, buttons, and information
     */
    public void updateForReservationInfo() {
        updateViewChoiceLabel("RESERVATION INFORMATION");

        northOfHeader.removeAll();
        southOfHeader.removeAll();

        selectRoomLbl = new JLabel();
        Font selectRoomLblFont = this.getFont("SansSerif", Font.PLAIN, 25, selectRoomLbl.getFont());
        if (selectRoomLblFont != null) selectRoomLbl.setFont(selectRoomLblFont);
        selectRoomLbl.setForeground(new Color(-16777216));
        selectRoomLbl.setText("Room Number: ");
        northOfHeader.add(selectRoomLbl);

        roomNumInput = new JTextField();
        roomNumInput.setColumns(5);
        northOfHeader.add(roomNumInput);

        guestNameLbl = new JLabel();
        Font guestNameLblFont = this.getFont("SansSerif", Font.PLAIN, 25, guestNameLbl.getFont());
        if (guestNameLblFont != null) guestNameLbl.setFont(guestNameLblFont);
        guestNameLbl.setForeground(new Color(-16777216));
        guestNameLbl.setText("Guest Name: ");
        northOfHeader.add(guestNameLbl);

        guestNameFld = new JTextField();
        guestNameFld.setColumns(20);
        northOfHeader.add(guestNameFld);

        checkInLbl = new JLabel();
        Font checkInLblFont = this.getFont("SansSerif", Font.PLAIN, 25, checkInLbl.getFont());
        if (checkInLblFont != null) checkInLbl.setFont(checkInLblFont);
        checkInLbl.setForeground(new Color(-16777216));
        checkInLbl.setText("Check In: ");
        southOfHeader.add(checkInLbl);

        checkInFld = new JTextField();
        checkInFld.setColumns(7);
        southOfHeader.add(checkInFld);

        checkOutLbl = new JLabel();
        Font checkOutLblfont = this.getFont("SansSerif", Font.PLAIN, 25, checkOutLbl.getFont());
        if (checkOutLblfont != null) checkOutLbl.setFont(checkOutLblfont);
        checkOutLbl.setForeground(new Color(-16777216));
        checkOutLbl.setText("Check Out: ");
        southOfHeader.add(checkOutLbl);

        checkOutFld = new JTextField();
        checkOutFld.setColumns(7);
        southOfHeader.add(checkOutFld);

        applyBtn.setBackground(new Color(-2500135));
        applyBtn.setText("APPLY");
        southOfHeader.add(applyBtn);

        northOfHeader.revalidate();
        northOfHeader.repaint();

        southOfHeader.revalidate();
        southOfHeader.repaint();
    }

    /**
     * setActionListener method adds a listener to the appropriate GUI components
     *
     * @param listener - listens to the action
     */
    public void setActionListener(ActionListener listener) {
        returnMainMenuBtn.addActionListener(listener);
        roomAvailBtn.addActionListener(listener);
        roomInfoBtn.addActionListener(listener);
        reserveInfoBtn.addActionListener(listener);
        highLvlBtn.addActionListener(listener);
        applyBtn.addActionListener(listener);
    }

    /**
     * getRoomInfoInput method returns the value input of the user
     *
     * @return the value inside the text field or -1
     */
    public int getRoomInfoInput() {
        try {
            return Integer.parseInt(roomInput.getText());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    /**
     * getDateInput method returns the value input of the user
     *
     * @return the value inside the text field or -1
     */
    public int getDateInput() {
        try {
            return Integer.parseInt(dateInput.getText());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    /**
     * getViewChoiceLabel method returns the choice title
     *
     * @return the choice title
     */
    public String getViewChoiceLabel() {
        return viewChoiceLabel.getText();
    }

    /**
     * getRoomNumInput method returns the value input of the user
     *
     * @return the value inside the text field or -1
     */
    public int getRoomNumInput() {
        try {
            return Integer.parseInt(roomNumInput.getText());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    /**
     * getGuestName method returns the value input of the user
     *
     * @return the value inside the text field
     */
    public String getGuestName() {
        return guestNameFld.getText();
    }

    /**
     * getCheckInDate method returns the value input of the user
     *
     * @return the value inside the text field or -1
     */
    public int getCheckInDate() {
        try {
            return Integer.parseInt(checkInFld.getText());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    /**
     * getCheckOutDate method returns the value input of the user
     *
     * @return the value inside the text field or -1
     */
    public int getCheckOutDate() {
        try {
            return Integer.parseInt(checkOutFld.getText());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    /**
     * clearResFlds method clears the text fields in the reservation info
     */
    public void clearResFlds() {
        guestNameFld.setText("");
        roomNumInput.setText("");
        checkInFld.setText("");
        checkOutFld.setText("");
    }

    /**
     * clearRoomInputFLd method clears the roomInput text field
     */
    public void clearRoomInputFLd() {
        roomInput.setText("");
    }

    /**
     * clearDateInput method clears the dateInput text field
     */
    public void clearDateInput() {
        dateInput.setText("");
    }

    /**
     * setErrorMessage method sets an error message to pop up
     *
     * @param errorMessage - a string that holds the value of the error message
     */
    public void setErrorMessage(String errorMessage) {
        JOptionPane.showMessageDialog(mainPanel, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
    }
}


