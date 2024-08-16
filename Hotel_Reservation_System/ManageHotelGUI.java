package Hotel_Reservation_System;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.event.ActionListener;
import java.awt.*;
import java.util.Locale;

/**
 * GUI/View for the management of hotels.
 */
public class ManageHotelGUI extends JPanel {
    /**
     * Attributes of the class
     */
    private JPanel mainPanel;
    private JPanel northPanel;
    private JPanel southPanel;
    private JPanel centerPanel;
    private JTextField hotelNameFld;
    private JButton View;
    private JPanel westCenterPanel;
    private JPanel northOfWestPanel;
    private JPanel southOfWestPanel;
    private JPanel centerOfWestPanel;
    private JPanel eastCenterPanel;
    private JPanel displayHotelsPanel;
    private JPanel hotelListPanel;
    private JPanel hotelListLabelPanel;
    private JTextArea displayHotels;
    private JLabel hoteListLabel;
    private JPanel southOfEastPanel;
    private JButton menuBtn;
    private JLabel footer;
    private MainGUI mainFrame;

    /**
     * The sole constructor of the ManageHotelGUI class
     *
     * @param mainFrame - the GUI/View that contains all the GUIs
     */
    public ManageHotelGUI(MainGUI mainFrame) {
        setLayout(new BorderLayout());

        setSize(1400, 750);

        displayGUI();

        setVisible(true);
    }

    /**
     * displayGUI method that provides the visual components of the program
     */
    private void displayGUI() {
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
        Font northPanelFont = this.getFont(null, -1, -1, northPanel.getFont());
        if (northPanelFont != null) northPanel.setFont(northPanelFont);

        JLabel managHotelLbl = new JLabel();
        managHotelLbl.setBackground(new Color(-331546));
        Font manageHotelFont = this.getFont("Garamond", Font.BOLD | Font.ITALIC, 50, managHotelLbl.getFont());
        if (manageHotelFont != null) managHotelLbl.setFont(manageHotelFont);
        managHotelLbl.setForeground(new Color(-16750281));
        managHotelLbl.setText("Manage Hotel  ");
        northPanel.add(managHotelLbl, BorderLayout.WEST);

        mainPanel.add(northPanel, BorderLayout.NORTH);
        northPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(40, 60, 0, 0), null, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));

        centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout(0, 0));
        centerPanel.setBackground(new Color(-331546));
        mainPanel.add(centerPanel, BorderLayout.CENTER);

        westCenterPanel = new JPanel();
        westCenterPanel.setLayout(new BorderLayout(0, 0));
        westCenterPanel.setBackground(new Color(-331546));
        westCenterPanel.setPreferredSize(new Dimension(700,300));
        westCenterPanel.setBorder(BorderFactory.createEmptyBorder(20,50,0,0));
        centerPanel.add(westCenterPanel, BorderLayout.WEST);

        northOfWestPanel = new JPanel();
        northOfWestPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        northOfWestPanel.setAutoscrolls(false);
        northOfWestPanel.setBackground(new Color(-331546));
        northOfWestPanel.setBorder(BorderFactory.createEmptyBorder(90,0,50,0));
        westCenterPanel.add(northOfWestPanel, BorderLayout.NORTH);

        JLabel askHotelToManage = new JLabel();
        Font askHotelToManageFont = this.getFont("SansSerif", Font.ITALIC, 30, askHotelToManage.getFont());
        if (askHotelToManageFont != null) askHotelToManage.setFont(askHotelToManageFont);
        askHotelToManage.setForeground(new Color(-16777216));
        askHotelToManage.setText("Which hotel would you like to manage?");

        northOfWestPanel.add(askHotelToManage);

        centerOfWestPanel = new JPanel();
        centerOfWestPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        centerOfWestPanel.setBorder(BorderFactory.createEmptyBorder(50,0,0,0));
        centerOfWestPanel.setAutoscrolls(false);
        centerOfWestPanel.setBackground(new Color(-331546));

        JLabel hotelNameLbl = new JLabel();
        Font hotelNameFont = this.getFont("SansSerif", Font.PLAIN, 25, hotelNameLbl.getFont());
        if (hotelNameFont != null) hotelNameLbl.setFont(hotelNameFont);
        hotelNameLbl.setForeground(new Color(-16777216));
        hotelNameLbl.setText("Hotel Name: ");
        centerOfWestPanel.add(hotelNameLbl);

        hotelNameFld = new JTextField();
        hotelNameFld.setBackground(new Color(-2500135));
        hotelNameFld.setOpaque(true);
        hotelNameFld.setPreferredSize(new Dimension(400, 34));
        centerOfWestPanel.add(hotelNameFld);

        westCenterPanel.add(centerOfWestPanel, BorderLayout.CENTER);

        southOfWestPanel = new JPanel();
        southOfWestPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        southOfWestPanel.setAutoscrolls(false);
        southOfWestPanel.setBackground(new Color(-331546));
        southOfWestPanel.setBorder(BorderFactory.createEmptyBorder(0,0,20,0));

        View = new JButton();
        View.setBackground(new Color(-2500135));
        View.setText("MANAGE HOTEL");
        southOfWestPanel.add(View);

        westCenterPanel.add(southOfWestPanel, BorderLayout.SOUTH);

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
        Font hoteListLabelFont = this.getFont("Garamond", Font.BOLD, 29, hoteListLabel.getFont());
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
        Font displayHotelsFont = this.getFont("Garamond", Font.BOLD, 19, displayHotels.getFont());
        if (displayHotelsFont != null) displayHotels.setFont(displayHotelsFont);
        displayHotels.setForeground(new Color(-331546));
        displayHotels.setLineWrap(true);
        displayHotels.setMargin(new Insets(0, 90, 20, 90));
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
        Font menuBtnFont = this.getFont("SansSerif", Font.BOLD, 12, menuBtn.getFont());
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
        Font footerFont = this.getFont("Franklin Gothic Book", Font.ITALIC, 14, footer.getFont());
        if (footerFont != null) footer.setFont(footerFont);
        footer.setForeground(new Color(-16777216));
        footer.setText("Crisostomo, De Jesus. 2024.");
        southPanel.add(footer);
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
    private Font getFont (String fontName,int style, int size, Font currentFont){
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
     * $$$getRootComponent$$$ method that returns the main panel of the GUI.
     *
     * @return mainPanel The main panel of the GUI.
     */
    public JComponent $$$getRootComponent$$$ () {
        return mainPanel;
    }

    /**
     * setActionListener method adds a listener to the appropriate GUI components
     *
     * @param listener - listens to the action
     */
    public void setActionListener(ActionListener listener) {
        menuBtn.addActionListener(listener);
        View.addActionListener(listener);
    }

    /**
     * getHotelToManage retrieves the name of the hotel to be managed entered in the text field
     *
     * @return name of the hotel to be manage
     */
    public String getHotelToManage() {
        return hotelNameFld.getText();
    }

    /**
     * setInstructionMessage method that displays an instruction message in a dialog box
     *
     * @param instructionMessage the instruction message to be display
     */
    public void setInstructionMessage(String instructionMessage) {
        JOptionPane.showMessageDialog(mainPanel, instructionMessage, "PROCESS",JOptionPane.INFORMATION_MESSAGE);
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
     * setErrorMessage a method that sets the error message to be display
     *
     * @param error the error message to be display
     */
    public void setErrorMessage(String error) {
        JOptionPane.showMessageDialog(this, error, "Error", JOptionPane.ERROR_MESSAGE);
    }
}


