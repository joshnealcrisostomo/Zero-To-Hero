package Hotel_Reservation_System;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Locale;

/**
 * GUI/View for the management of hotels.
 */
public class InManageHotelGUI extends JPanel {
    /**
     * Attributes of the class
     */
    private JPanel mainPanel,northPanel, westPanel, eastPanel, southPanel, southOfEast, northOfEast, southOfEastHeader, southOfEastFooter;
    private JLabel tradeMarkHolder, manageHotelLbl, hotelNameLbl;
    private JTextField roomNumResFld, newHotelNameFld, roomQuantityFld, roomToRemoveFld;
    private JTextField guestNameFld, newPriceFld, dayFld, roomTypeAddFld, newPercentFld, checkInFld, checkOutFld;
    private JButton ENTERButton, changeHotelNameButton,addRoomButton, updateBasePriceButton, removeRoomButton, removeReservationButton;
    private JButton removeHotelButton, datePriceModifierButton, menuBtn;
    private JPanel updatePanel, updateLabelPanel;
    private JTextArea displayUpdatesFont;
    private JLabel updateLbl, newHtlNameLbl, newBasePriceLbl, dayLbl, roomTypeAddLbl, guestNameLbl;
    private JLabel checkInLbl, checkOutLbl;
    private MainGUI mainFrame;

    /**
     * The sole constructor of the InManageHotelGUI class
     *
     * @param mainFrame - the GUI/View that contains all the GUIs
     */
    public InManageHotelGUI(MainGUI mainFrame) {
        this.mainFrame = mainFrame;
        setLayout(new BorderLayout());
        setSize(1400, 750);
        setupUI();
        setVisible(true);
    }

    /**
     * setupUI method that provides the visual components of the program
     */
    private void setupUI() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(0, 0));
        mainPanel.setBackground(new Color(-331546));
        mainPanel.setMaximumSize(new Dimension(1400, 750));
        mainPanel.setMinimumSize(new Dimension(1400, 750));
        mainPanel.setOpaque(true);
        mainPanel.setPreferredSize(new Dimension(1400, 750));
        this.add(mainPanel);

        northPanel = new JPanel();
        northPanel.setLayout(new BorderLayout(0, 0));
        northPanel.setBackground(new Color(-331546));
        mainPanel.add(northPanel, BorderLayout.NORTH);
        northPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(40, 60, 0, 0), null, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));

        manageHotelLbl = new JLabel();
        manageHotelLbl.setBackground(new Color(-331546));
        Font manageHotelLblFont = this.getFont("Garamond", Font.BOLD | Font.ITALIC, 50, manageHotelLbl.getFont());
        if (manageHotelLblFont != null) manageHotelLbl.setFont(manageHotelLblFont);
        manageHotelLbl.setForeground(new Color(-16750281));
        manageHotelLbl.setText("Manage Hotel ");
        northPanel.add(manageHotelLbl, BorderLayout.WEST);

        hotelNameLbl = new JLabel();
        hotelNameLbl.setBackground(new Color(-331546));
        Font hotelNameLblFont = this.getFont("Garamond", Font.BOLD, 50, hotelNameLbl.getFont());
        if (hotelNameLblFont != null) hotelNameLbl.setFont(hotelNameLblFont);
        hotelNameLbl.setForeground(new Color(-16750281));
        hotelNameLbl.setText("[NAME]"); // update this with hotel name
        northPanel.add(hotelNameLbl, BorderLayout.CENTER);

        westPanel = new JPanel();
        westPanel.setLayout(new BorderLayout(0, 0));
        westPanel.setBackground(new Color(-331546));
        mainPanel.add(westPanel, BorderLayout.WEST);
        westPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(30, 35, 40, 0), null, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));

        updatePanel = new JPanel();
        updatePanel.setLayout(new BorderLayout(0, 0));
        updatePanel.setBackground(new Color(-3309774));
        updatePanel.setMaximumSize(new Dimension(500, 300));
        updatePanel.setPreferredSize(new Dimension(650, 300));
        westPanel.add(updatePanel, BorderLayout.CENTER);

        updateLabelPanel = new JPanel();
        updateLabelPanel.setLayout(new BorderLayout(0,0));
        updateLabelPanel.setBackground(new Color(-3309774));
        updatePanel.add(updateLabelPanel, BorderLayout.NORTH);
        updateLabelPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0), null, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));

        updateLbl = new JLabel();
        updateLbl.setBackground(new Color(-3309774));
        updateLbl.setForeground(new Color(-331546));
        Font updateLblFont = this.getFont("Garamond", Font.BOLD, 26, updateLbl.getFont());
        if (updateLblFont != null) updateLbl.setFont(updateLblFont);
        updateLbl.setHorizontalAlignment(0);
        updateLbl.setText("");
        updateLabelPanel.add(updateLbl, BorderLayout.CENTER);

        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(1, 1));
        panel1.setBackground(new Color(-3309774));
        updatePanel.add(panel1, BorderLayout.CENTER);

        displayUpdatesFont = new JTextArea();
        displayUpdatesFont.setBackground(new Color(-3309774));
        displayUpdatesFont.setEditable(false);
        Font displayUpdatesFontFont = this.getFont("Garamond", Font.BOLD, 19, displayUpdatesFont.getFont());
        if (displayUpdatesFontFont != null) displayUpdatesFont.setFont(displayUpdatesFontFont);
        displayUpdatesFont.setForeground(new Color(-331546));
        displayUpdatesFont.setLineWrap(true);
        displayUpdatesFont.setMargin(new Insets(30, 40, 20, 40));
        displayUpdatesFont.setWrapStyleWord(true);
        panel1.add(displayUpdatesFont);

        JScrollPane scrollPane = new JScrollPane(displayUpdatesFont);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(700, 300));
        panel1.add(scrollPane, BorderLayout.CENTER);

        eastPanel = new JPanel();
        eastPanel.setLayout(new BorderLayout(0, 0));
        eastPanel.setBackground(new Color(-331546));
        mainPanel.add(eastPanel, BorderLayout.EAST);
        eastPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(70, 0, 0, 0), null, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));

        northOfEast = new JPanel();
        northOfEast.setLayout(new GridLayout(3, 3, 20, 20));
        northOfEast.setBackground(new Color(-331546));
        eastPanel.add(northOfEast, BorderLayout.NORTH);
        northOfEast.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(100, 0, 0, 75), null, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));

        changeHotelNameButton = new JButton();
        changeHotelNameButton.setBackground(new Color(-16750281));
        changeHotelNameButton.setForeground(new Color(-331546));
        changeHotelNameButton.setText("Change Hotel Name");
        northOfEast.add(changeHotelNameButton);

        addRoomButton = new JButton();
        addRoomButton.setBackground(new Color(-16750281));
        addRoomButton.setForeground(new Color(-331546));
        addRoomButton.setText("Add Room");
        northOfEast.add(addRoomButton);

        updateBasePriceButton = new JButton();
        updateBasePriceButton.setBackground(new Color(-16750281));
        updateBasePriceButton.setForeground(new Color(-331546));
        updateBasePriceButton.setText("Update Base Price");
        northOfEast.add(updateBasePriceButton);

        removeRoomButton = new JButton();
        removeRoomButton.setBackground(new Color(-16750281));
        removeRoomButton.setForeground(new Color(-331546));
        removeRoomButton.setText("Remove Room");
        northOfEast.add(removeRoomButton);

        removeReservationButton = new JButton();
        removeReservationButton.setBackground(new Color(-16750281));
        removeReservationButton.setForeground(new Color(-331546));
        removeReservationButton.setText("Remove Reservation");
        northOfEast.add(removeReservationButton);

        removeHotelButton = new JButton();
        removeHotelButton.setBackground(new Color(-16750281));
        removeHotelButton.setForeground(new Color(-331546));
        removeHotelButton.setText("Remove Hotel");
        northOfEast.add(removeHotelButton);

        datePriceModifierButton = new JButton();
        datePriceModifierButton.setBackground(new Color(-16750281));
        datePriceModifierButton.setForeground(new Color(-331546));
        datePriceModifierButton.setText("Date Price Modifier");
        northOfEast.add(datePriceModifierButton);

        menuBtn = new JButton();
        menuBtn.setBackground(new Color(-5103070));
        menuBtn.setForeground(new Color(-331546));
        menuBtn.setText("RETURN TO MAIN MENU");
        northOfEast.add(menuBtn);

        southOfEast = new JPanel();
        southOfEast.setLayout(new BorderLayout(0,0));
        southOfEast.setBackground(new Color(-331546));
        eastPanel.add(southOfEast, BorderLayout.SOUTH);
        southOfEast.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(0, 0, 90, 0), null, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));

        southOfEastHeader = new JPanel();
        southOfEastHeader.setLayout(new FlowLayout());
        southOfEastHeader.setBackground(new Color(-331546));
        southOfEast.add(southOfEastHeader, BorderLayout.NORTH);

        southOfEastFooter = new JPanel();
        southOfEastFooter.setLayout(new FlowLayout());
        southOfEastFooter.setBackground(new Color(-331546));
        southOfEast.add(southOfEastFooter, BorderLayout.SOUTH);

        ENTERButton = new JButton();
        ENTERButton.setBackground(new Color(-331546));
        ENTERButton.setText("");
        southOfEastFooter.add(ENTERButton);

        southPanel = new JPanel();
        southPanel.setLayout(new BorderLayout(0, 0));
        southPanel.setBackground(new Color(-331546));
        mainPanel.add(southPanel, BorderLayout.SOUTH);
        southPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0), null, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));

        JPanel southOfSouthPanel = new JPanel();
        southOfSouthPanel.setLayout(new FlowLayout());
        southOfSouthPanel.setBackground(new Color(-331546));
        southPanel.add(southOfSouthPanel, BorderLayout.SOUTH);

        tradeMarkHolder = new JLabel();
        tradeMarkHolder.setText("Crisostomo, De Jesus. 2024.");
        tradeMarkHolder.setFont(new Font("Frutiger", Font.ITALIC, 14));
        southOfSouthPanel.add(tradeMarkHolder, BorderLayout.CENTER);
    }

    /**
     * getFont method that retrieves a Font object with specified attributes, handling platform-specific font fallbacks.
     *
     * @param fontName The name of the font to use
     * @param style The style of the font
     * @param size The size of the font.
     * @param currentFont The current Font object to base attributes on.
     *
     * @return A Font object configured with the specified attributes and appropriate platform fallbacks.
     */
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
        Font font = new Font(resultName, style, size);
        boolean isMac = System.getProperty("os.name", "").toLowerCase(Locale.ENGLISH).startsWith("mac");
        Font fontWithFallback = isMac ? new FontUIResource(font) : new StyleContext().getFont(resultName, style, size);
        return fontWithFallback instanceof FontUIResource ? font : fontWithFallback;
    }

    /**
     * setManageHotelName method that sets the label of the hotel to be manage
     *
     * @param hotelName the hotel to be manage
     */
    public void setManageHotelName(String hotelName) {
        hotelNameLbl.setText("[" + hotelName + "]");
    }

    /**
     * clearTextArea method that clears the text field
     *
     */
    public void clearTextArea() {
        displayUpdatesFont.setText("");
    }

    /**
     * updateTextArea method that updates the text area
     *
     * @param newInfo a String that holds the information to be displayed
     */
    public void updateTextArea(String newInfo) {
        displayUpdatesFont.setText(newInfo);
    }

    /**
     * updateManageChoiceLabel method
     *
     * @param newTitle a String that holds the new title
     */
    public void updateManageChoiceLabel(String newTitle) {
        updateLbl.setText(newTitle);
    }

    /**
     * setActionListener method that sets the action listener for various buttons.
     *
     * @param listener The ActionListener to be set for the buttons.
     */
    public void setActionListener(ActionListener listener) {
        ENTERButton.addActionListener(listener);
        menuBtn.addActionListener(listener);
        changeHotelNameButton.addActionListener(listener);
        addRoomButton.addActionListener(listener);
        removeRoomButton.addActionListener(listener);
        removeHotelButton.addActionListener(listener);
        removeReservationButton.addActionListener(listener);
        datePriceModifierButton.addActionListener(listener);
        updateBasePriceButton.addActionListener(listener);
    }

    /**
     * updateForChangeHotelName method that updates the GUI with the appropriate text fields, buttons, and information for the change hotel name function
     *
     */
    public void updateForChangeHotelName() {
        updateManageChoiceLabel("CHANGE HOTEL NAME:");

        southOfEastHeader.removeAll();
        southOfEastFooter.removeAll();

        newHtlNameLbl = new JLabel();
        Font newHtlNameLblFont = this.getFont("SansSerif", Font.PLAIN, 18, newHtlNameLbl.getFont());
        if (newHtlNameLblFont != null) newHtlNameLbl.setFont(newHtlNameLblFont);
        newHtlNameLbl.setForeground(new Color(-16777216));
        newHtlNameLbl.setText("New Hotel Name: ");
        newHtlNameLbl.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 20));
        southOfEastHeader.add(newHtlNameLbl);

        newHotelNameFld = new JTextField();
        newHotelNameFld.setBackground(new Color(-2500135));
        newHotelNameFld.setForeground(new Color(-16777216));
        newHotelNameFld.setColumns(20);
        southOfEastHeader.add(newHotelNameFld);

        ENTERButton.setBackground(new Color(-16750281));
        ENTERButton.setForeground(new Color(-331546));
        ENTERButton.setText("ENTER");
        ENTERButton.setPreferredSize(new Dimension(100,30));
        southOfEastFooter.add(ENTERButton);

        southOfEastHeader.revalidate();
        southOfEastHeader.repaint();

        southOfEastFooter.revalidate();
        southOfEastFooter.repaint();
    }

    /**
     * updateForAddRoom method that updates the GUI with the appropriate text fields, buttons, and information for the add room function
     *
     */
    public void updateForAddRoom() {
        updateManageChoiceLabel("ADD ROOMS:");

        southOfEastHeader.removeAll();
        southOfEastFooter.removeAll();

        dayLbl = new JLabel();
        Font dayLblFont = this.getFont("SansSerif", Font.PLAIN, 18, dayLbl.getFont());
        if (dayLblFont != null) dayLbl.setFont(dayLblFont);
        dayLbl.setForeground(new Color(-16777216));
        dayLbl.setText("Quantity:  ");
        dayLbl.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 20));
        southOfEastHeader.add(dayLbl);

        roomQuantityFld = new JTextField();
        roomQuantityFld.setBackground(new Color(-2500135));
        roomQuantityFld.setForeground(new Color(-16777216));
        roomQuantityFld.setColumns(5);
        southOfEastHeader.add(roomQuantityFld);

        roomTypeAddLbl = new JLabel();
        Font roomTypeAddFont = this.getFont("SansSerif", Font.PLAIN, 18, roomTypeAddLbl.getFont());
        if (roomTypeAddFont != null) roomTypeAddLbl.setFont(roomTypeAddFont);
        roomTypeAddLbl.setForeground(new Color(-16777216));
        roomTypeAddLbl.setText(" Room Type:  ");
        roomTypeAddLbl.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 20));
        southOfEastHeader.add(roomTypeAddLbl);

        roomTypeAddFld = new JTextField();
        roomTypeAddFld.setColumns(15);
        roomTypeAddFld.setBackground(new Color(-2500135));
        roomTypeAddFld.setForeground(new Color(-16777216));
        southOfEastHeader.add(roomTypeAddFld);

        ENTERButton.setBackground(new Color(-16750281));
        ENTERButton.setForeground(new Color(-331546));
        ENTERButton.setText("ENTER");
        ENTERButton.setPreferredSize(new Dimension(100,30));
        southOfEastFooter.add(ENTERButton);

        southOfEastHeader.revalidate();
        southOfEastHeader.repaint();

        southOfEastFooter.revalidate();
        southOfEastFooter.repaint();
    }

    /**
     * updateForRemoveRoom method that updates the GUI with the appropriate text fields, buttons, and information for the remove room function
     *
     */
    public void updateForRemoveRoom() {
        updateManageChoiceLabel("REMOVE ROOM:");

        southOfEastHeader.removeAll();
        southOfEastFooter.removeAll();

        newHtlNameLbl = new JLabel();
        Font newHtlNameLblFont = this.getFont("SansSerif", Font.PLAIN, 18, newHtlNameLbl.getFont());
        if (newHtlNameLblFont != null) newHtlNameLbl.setFont(newHtlNameLblFont);
        newHtlNameLbl.setForeground(new Color(-16777216));
        newHtlNameLbl.setText("Room to remove: ");
        newHtlNameLbl.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 20));
        southOfEastHeader.add(newHtlNameLbl);

        roomToRemoveFld = new JTextField();
        roomToRemoveFld.setBackground(new Color(-2500135));
        roomToRemoveFld.setForeground(new Color(-16777216));
        roomToRemoveFld.setColumns(20);
        southOfEastHeader.add(roomToRemoveFld);

        ENTERButton.setBackground(new Color(-16750281));
        ENTERButton.setForeground(new Color(-331546));
        ENTERButton.setText("ENTER");
        ENTERButton.setPreferredSize(new Dimension(100,30));
        southOfEastFooter.add(ENTERButton);

        southOfEastHeader.revalidate();
        southOfEastHeader.repaint();

        southOfEastFooter.revalidate();
        southOfEastFooter.repaint();
    }

    /**
     * updateForBasePrice method that updates the GUI with the appropriate text fields, buttons, and information for the update base price function
     *
     */
    public void updateForBasePrice() {
        updateManageChoiceLabel("UPDATE BASE PRICE:");

        southOfEastHeader.removeAll();
        southOfEastFooter.removeAll();

        newBasePriceLbl = new JLabel();
        Font newBasePriceLblFont = this.getFont("SansSerif", Font.PLAIN, 18, newBasePriceLbl.getFont());
        if (newBasePriceLblFont != null) newBasePriceLbl.setFont(newBasePriceLblFont);
        newBasePriceLbl.setForeground(new Color(-16777216));
        newBasePriceLbl.setText("New Base Price: ");
        newBasePriceLbl.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 20));
        southOfEastHeader.add(newBasePriceLbl);

        newPriceFld = new JTextField();
        newPriceFld.setBackground(new Color(-2500135));
        newPriceFld.setForeground(new Color(-16777216));
        newPriceFld.setColumns(10);
        southOfEastHeader.add(newPriceFld);

        ENTERButton.setBackground(new Color(-16750281));
        ENTERButton.setForeground(new Color(-331546));
        ENTERButton.setText("ENTER");
        ENTERButton.setPreferredSize(new Dimension(100,30));
        southOfEastFooter.add(ENTERButton);

        southOfEastHeader.revalidate();
        southOfEastHeader.repaint();

        southOfEastFooter.revalidate();
        southOfEastFooter.repaint();
    }

    /**
     * updateForRemoveRes method that updates the GUI with the appropriate text fields, buttons, and information for the remove reservation function
     *
     */
    public void updateForRemoveRes() {
        updateManageChoiceLabel("REMOVE RESERVATION:");

        southOfEastHeader.removeAll();
        southOfEastFooter.removeAll();

        newBasePriceLbl = new JLabel();
        Font newBasePriceLblFont = this.getFont("SansSerif", Font.PLAIN, 18, newBasePriceLbl.getFont());
        if (newBasePriceLblFont != null) newBasePriceLbl.setFont(newBasePriceLblFont);
        newBasePriceLbl.setForeground(new Color(-16777216));
        newBasePriceLbl.setText("Room: ");
        newBasePriceLbl.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 20));
        southOfEastHeader.add(newBasePriceLbl);

        roomNumResFld = new JTextField();
        roomNumResFld.setBackground(new Color(-2500135));
        roomNumResFld.setForeground(new Color(-16777216));
        roomNumResFld.setColumns(7);
        southOfEastHeader.add(roomNumResFld);

        guestNameLbl = new JLabel();
        Font guestNameLblFont = this.getFont("SansSerif", Font.PLAIN, 18, guestNameLbl.getFont());
        if (guestNameLblFont != null) guestNameLbl.setFont(guestNameLblFont);
        guestNameLbl.setForeground(new Color(-16777216));
        guestNameLbl.setText(" Guest Name: ");
        guestNameLbl.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 20));
        southOfEastHeader.add(guestNameLbl);

        guestNameFld = new JTextField();
        guestNameFld.setBackground(new Color(-2500135));
        guestNameFld.setForeground(new Color(-16777216));
        guestNameFld.setColumns(15);
        southOfEastHeader.add(guestNameFld);

        checkInLbl = new JLabel();
        Font checkInLblFont = this.getFont("SansSerif", Font.PLAIN, 18, checkInLbl.getFont());
        if (checkInLblFont != null) checkInLbl.setFont(checkInLblFont);
        checkInLbl.setForeground(new Color(-16777216));
        checkInLbl.setText(" Check-in: ");
        checkInLbl.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 20));
        southOfEastFooter.add(checkInLbl);

        checkInFld = new JTextField();
        checkInFld.setBackground(new Color(-2500135));
        checkInFld.setForeground(new Color(-16777216));
        checkInFld.setColumns(8);
        southOfEastFooter.add(checkInFld);

        checkOutLbl = new JLabel();
        Font checkOutLblFont = this.getFont("SansSerif", Font.PLAIN, 18, checkOutLbl.getFont());
        if (checkOutLblFont != null) checkOutLbl.setFont(checkOutLblFont);
        checkOutLbl.setForeground(new Color(-16777216));
        checkOutLbl.setText(" Check-out: ");
        checkOutLbl.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 20));
        southOfEastFooter.add(checkOutLbl);

        checkOutFld = new JTextField();
        checkOutFld.setBackground(new Color(-2500135));
        checkOutFld.setForeground(new Color(-16777216));
        checkOutFld.setColumns(8);
        southOfEastFooter.add(checkOutFld);

        ENTERButton.setBackground(new Color(-16750281));
        ENTERButton.setForeground(new Color(-331546));
        ENTERButton.setText("ENTER");
        ENTERButton.setPreferredSize(new Dimension(100,30));
        southOfEastFooter.add(ENTERButton);

        southOfEastHeader.revalidate();
        southOfEastHeader.repaint();

        southOfEastFooter.revalidate();
        southOfEastFooter.repaint();
    }

    /**
     * updateForRemoveHotel method that updates the GUI with the appropriate text fields, buttons, and information for the remove hotel function
     *
     */
    public void updateForRemoveHotel() {
        updateManageChoiceLabel("REMOVE HOTEL:");

        southOfEastHeader.revalidate();
        southOfEastHeader.repaint();

        southOfEastFooter.revalidate();
        southOfEastFooter.repaint();
    }

    /**
     * updateForDatePriceMod method that updates the GUI with the appropriate text fields, buttons, and information for the date price modifier function
     *
     */
    public void updateForDatePriceMod() {
        updateManageChoiceLabel("DATE PRICE MODIFIER:");

        southOfEastHeader.removeAll();
        southOfEastFooter.removeAll();

        dayLbl = new JLabel();
        Font dayLblFont = this.getFont("SansSerif", Font.PLAIN, 18, dayLbl.getFont());
        if (dayLblFont != null) dayLbl.setFont(dayLblFont);
        dayLbl.setForeground(new Color(-16777216));
        dayLbl.setText("Day to modify:  ");
        dayLbl.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 20));
        southOfEastHeader.add(dayLbl);

        dayFld = new JTextField();
        dayFld.setBackground(new Color(-2500135));
        dayFld.setForeground(new Color(-16777216));
        dayFld.setColumns(5);
        southOfEastHeader.add(dayFld);

        newBasePriceLbl = new JLabel();
        Font newBasePriceFOnt = this.getFont("SansSerif", Font.PLAIN, 18, newBasePriceLbl.getFont());
        if (newBasePriceFOnt != null) newBasePriceLbl.setFont(newBasePriceFOnt);
        newBasePriceLbl.setForeground(new Color(-16777216));
        newBasePriceLbl.setText(" Percentage (in decimals):  ");
        newBasePriceLbl.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 20));
        southOfEastHeader.add(newBasePriceLbl);

        newPercentFld = new JTextField();
        newPercentFld.setColumns(10);
        newPercentFld.setBackground(new Color(-2500135));
        newPercentFld.setForeground(new Color(-16777216));
        southOfEastHeader.add(newPercentFld);

        ENTERButton.setBackground(new Color(-16750281));
        ENTERButton.setForeground(new Color(-331546));
        ENTERButton.setText("ENTER");
        ENTERButton.setPreferredSize(new Dimension(100,30));
        southOfEastFooter.add(ENTERButton);

        southOfEastHeader.revalidate();
        southOfEastHeader.repaint();

        southOfEastFooter.revalidate();
        southOfEastFooter.repaint();
    }

    /**
     * getManageChoiceLabel method that retrieves the entered update text in the text field
     *
     * @return update text
     */
    public String getManageChoiceLabel() {
        return updateLbl.getText();
    }

    /**
     * getHotelName method that retrieves the newly entered hotel name in the text field
     *
     * @return new hotel name
     */
    public String getHotelName() {
        return newHotelNameFld.getText();
    }

    /**
     * getDayToModify method that retrieves the entered day to be modified in the text field
     *
     * @return day to be modified, otherwise -1 if input is not valid
     */
    public int getDayToModify() {
        try {
            return Integer.parseInt(dayFld.getText());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    /**
     * getNumRoomsToAdd method that retrieves the entered number of rooms to be added in the text field
     *
     * @return number of rooms, otherwise -1 if input is not valid
     */
    public int getNumRoomsToAdd() {
        try {
            return Integer.parseInt(roomQuantityFld.getText());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    /**
     * getRoomTypeToAdd method that retrieves the entered room type in the text field
     *
     * @return room type
     */
    public String getRoomTypeToAdd() {
        return roomTypeAddFld.getText().toUpperCase();
    }

    /**
     * getRoomToRemove method that retrieves the entered room number to be removed in the text field
     *
     * @return room to remove, otherwise -1 if input is not valid
     */
    public int getRoomToRemove() {
        try {
            return Integer.parseInt(roomToRemoveFld.getText());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    /**
     * getBasePrice method that retrieves the newly entered base price in the text field
     *
     * @return new base price, otherwise -1.0 if input is not valid
     */
    public double getBasePrice() {
        try {
            return Double.parseDouble(newPriceFld.getText());
        } catch (NumberFormatException e) {
            return -1.0;
        }
    }

    /**
     * getNewPercent method that retrieves the entered new percent modifier in the text field
     *
     * @return new percentage, otherwise -1.0 if input is not valid
     */
    public double getNewPercent() {
        try {
            return Double.parseDouble(newPercentFld.getText());
        } catch (NumberFormatException e) {
            return -1.0;
        }
    }

    /**
     * getRoomRes method that retrieves the entered room number in the text field
     *
     * @return room number, otherwise -1 if input is not valid
     */
    public int getRoomRes() {
        try {
            return Integer.parseInt(roomNumResFld.getText());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    /**
     * getGuestName method that retrieves the entered guest name in the text field
     *
     * @return guest name
     */
    public String getGuestName() {
        return guestNameFld.getText();
    }

    /**
     * getCheckInDate method that retrieves the entered check in date in the text field
     *
     * @return check in date, otherwise -1 if input is not valid
     */
    public int getCheckInDate() {
        try {
            return Integer.parseInt(checkInFld.getText());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    /**
     * getCheckOutDate method that retrieves the entered check out date in the text field
     *
     * @return check out date, otherwise -1 if input is not valid
     */
    public int getCheckOutDate() {
        try {
            return Integer.parseInt(checkOutFld.getText());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    /**
     * showConfirmationMessage method that displays a confirmation dialog to the user asking if they want to apply the changes
     *
     * @return an integer indicating the user's choice
     */
    public int showConfirmationMessage() {
        return JOptionPane.showConfirmDialog(mainPanel,
                "Do you want to continue and apply the changes?",
                "CONFIRMATION",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );
    }

    /**
     * showConfirmRemoveHotel method that displays a confirmation dialog to the user asking if they want to remove a hotel
     *
     * @return an integer indicating the user's choice
     */
    public int showConfirmRemoveHotel() {
        return JOptionPane.showConfirmDialog(mainPanel,
                "Are you sure you want to remove this hotel?",
                "CONFIRMATION",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );
    }

    /**
     * getYesOption method that returns the yes option
     *
     * @return JOptionPane.YES_OPTION
     */
    public int getYesOption() {
        return JOptionPane.YES_OPTION;
    }

    /**
     * getNoOption method that returns the no option
     *
     * @return JOptionPane.NO_OPTION
     */
    public int getNoOption() {
        return JOptionPane.NO_OPTION;
    }

    /**
     * handleYesChangeOption method that displays a String when change is applied
     *
     */
    public void handleYesChangeOption() {
        JOptionPane.showMessageDialog(mainPanel,"CHANGE WAS APPLIED");
    }

    /**
     * handleNoChangeOption method that displays a String when change is not applied
     *
     */
    public void handleNoChangeOption() {
        JOptionPane.showMessageDialog(mainPanel, "CHANGE WAS NOT APPLIED");
    }

    /**
     * clearHotelNameFld method that clears the text field
     *
     */
    public void clearHotelNameFld() {
        newHotelNameFld.setText("");
    }

    /**
     * clearAddRoomFld method that clears the text field
     *
     */
    public void clearAddRoomFld() {
        roomQuantityFld.setText("");
        roomTypeAddFld.setText("");
    }

    /**
     * clearRemoveRoomFld method that clears the text field for the remove room function
     *
     */
    public void clearRemoveRoomFld() {
        roomToRemoveFld.setText("");
    }

    /**
     * clearUpdBasePriceFld method that clears the text field for the update base price function
     *
     */
    public void clearUpdBasePriceFld() {
        newPriceFld.setText("");
    }

    /**
     * clearRemoveResFld method that clears the text field for the remove reservation function
     */
    public void clearRemoveResFld() {
        guestNameFld.setText("");
        roomNumResFld.setText("");
        checkInFld.setText("");
        checkOutFld.setText("");
    }

    /**
     * clearDatePriceFld method that clears the text field for the date price function
     */
    public void clearDatePriceFld() {
        newPercentFld.setText("");
        dayFld.setText("");
    }

    /**
     * displayRoomList method that displays the room list of a hotel
     *
     * @param roomList the rooms in the hotel
     */
    public void displayRoomList(String roomList) {
        displayUpdatesFont.append("\n-------------------------------------------------------------------\n\n");
        displayUpdatesFont.append(roomList);
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
     * displayPriceModList method displays the updated price modifier list each day
     *
     * @param list - a String that holds the value of the list
     */
    public void displayPriceModList(String list) {
        displayUpdatesFont.append("\n-------------------------------------------------------------------\n\n");
        displayUpdatesFont.append(list);
    }
}


