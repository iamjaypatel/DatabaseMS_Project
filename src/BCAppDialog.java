import javax.swing.*;
import java.awt.event.*;

public class BCAppDialog extends JDialog {
    private JPanel contentPane;
    private JButton btnPurchase;
    private JButton buttonCancel;
    private JTabbedPane tabbedPane1;
    private JRadioButton radStarbucks;
    private JRadioButton radDunkin;
    private JRadioButton radCrazyMocha;
    private JLabel lblGetCustName;
    private JLabel lblCustomerName;
    private JLabel lblGetCustPts;
    private JLabel lblCustomerPoints;
    private JButton btnBack;
    private JList lstCoffee;
    private JLabel lblGetDesc;
    private JLabel lblPrice;
    private JLabel lblGetPrice;
    private JButton btnNext;
    private JSpinner spnQuantity;
    private JLabel lblQualtity;
    private JLabel lbltp;
    private JLabel lblPriceQ;
    private JLabel lblRedeem;
    private JSpinner spnRedeem;
    private JButton btnCalcTot;
    private static BoutiqueCoffee boutiqueCoffee;

    public BCAppDialog() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(btnPurchase);
        btnPurchase.setEnabled(false);
        tabbedPane1.setEnabledAt(1, false);
        tabbedPane1.setEnabledAt(2, false);

        btnPurchase.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int StoreID = 0;
                if (radStarbucks.isSelected()) {
                    StoreID = 1;
                } else if (radDunkin.isSelected()) {
                    StoreID = 2;
                } else if (radCrazyMocha.isSelected()) {
                    StoreID = 3;
                } else {
                    JOptionPane.showMessageDialog(null, "Select Appropriate Store");
                }
                //boutiqueCoffee.addPurchase(custid, StoreID, Date, coffe, quant, redeem);
                dispose();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        radStarbucks.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                tabbedPane1.setSelectedIndex(1);
                tabbedPane1.setEnabledAt(2, false);
                btnPurchase.setEnabled(false);
                DefaultListModel model = new DefaultListModel<>();
                model.addElement("Caffee Misto");
                model.addElement("Iced Coffee");
                lstCoffee.setModel(model);

                if (lstCoffee.getSelectedIndex() == 0) {
                    lblGetDesc.setText("Brewed Coffee w/Milk, Intensity: 5");
                    lblGetPrice.setText("3.95");
                } else if (lstCoffee.getSelectedIndex() == 1) {
                    lblGetDesc.setText("Ice Brewed Coffee, Intensity: 3");
                    lblGetPrice.setText("4.95");
                }
            }
        });

        radDunkin.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                tabbedPane1.setSelectedIndex(1);
                tabbedPane1.setEnabledAt(2, false);
                btnPurchase.setEnabled(false);
                DefaultListModel model = new DefaultListModel<>();
                model.addElement("Original Blend Vanilla");
                model.addElement("Dark Roast Mocha");
                lstCoffee.setModel(model);

                if (lstCoffee.getSelectedIndex() == 0) {
                    lblGetDesc.setText("Vanilla Flavor, Intensity: 5");
                    lblGetPrice.setText("2.99");
                } else if (lstCoffee.getSelectedIndex() == 1) {
                    lblGetDesc.setText("Dark Roast w/ Mocha, Intensity: 7");
                    lblGetPrice.setText("4.99");
                }

            }
        });

        radCrazyMocha.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                tabbedPane1.setSelectedIndex(1);
                tabbedPane1.setEnabledAt(2, false);
                btnPurchase.setEnabled(false);
                DefaultListModel model = new DefaultListModel<>();
                model.addElement("Regular Coffee");
                model.addElement("Ice Coffee");
                lstCoffee.setModel(model);

                if (lstCoffee.getSelectedIndex() == 0) {
                    lblGetDesc.setText("Coffee Blend, Intensity: 6");
                    lblGetPrice.setText("5.49");
                } else if (lstCoffee.getSelectedIndex() == 1) {
                    lblGetDesc.setText("Iced Coffee, Intensity: 2");
                    lblGetPrice.setText("3.49");
                }
            }
        });


        btnBack.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                tabbedPane1.setSelectedIndex(0);
                tabbedPane1.setEnabledAt(2, false);
                btnPurchase.setEnabled(false);

            }
        });
        btnNext.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                tabbedPane1.setEnabledAt(2, true);
                tabbedPane1.setSelectedIndex(2);
                btnPurchase.setEnabled(true);
                SpinnerNumberModel quantitylimit = new SpinnerNumberModel(0, 0, 9, 1);
                SpinnerNumberModel redeemlimit = new SpinnerNumberModel(0, 0, 1, 1);
                spnQuantity.setModel(quantitylimit);
                spnRedeem.setModel(redeemlimit);
            }
        });
        btnCalcTot.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                double quantity = (int) spnQuantity.getValue();
                double price = Double.parseDouble(lblGetPrice.getText());
                double redeem = (int) spnRedeem.getValue();
                redeem = (quantity - redeem);
                double total = redeem * price;
                total = Math.round(total * 100) * .01;
                lblPriceQ.setText("$ " + total);
            }
        });
    }

    private void createUIComponents() {
        contentPane = new JPanel();
        tabbedPane1 = new JTabbedPane();
        lblGetCustPts = new JLabel();
        lblGetCustName = new JLabel();
        lblCustomerName = new JLabel();
        lblCustomerPoints = new JLabel();
        radCrazyMocha = new JRadioButton();
        radDunkin = new JRadioButton();
        radStarbucks = new JRadioButton();
        lstCoffee = new JList();
        spnQuantity = new JSpinner();
        spnRedeem = new JSpinner();
    }
}
