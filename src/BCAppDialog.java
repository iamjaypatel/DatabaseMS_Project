import javax.swing.*;
import java.awt.event.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.sql.Date;

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
    private JButton btnBackQuant;
    private JComboBox cbSelectCoffee;
    private JLabel lblGetIntensity;
    private JLabel lblptsRedeem;
    private JLabel lblTotPtsRedeem;
    private JLabel lblPtsEarn;
    private JLabel lblTotPtsEarn;
    private static BoutiqueCoffee boutiqueCoffee;
    private String customerID;

    public BCAppDialog() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(btnPurchase);
        btnPurchase.setEnabled(false);
        tabbedPane1.setEnabledAt(1, false);
        tabbedPane1.setEnabledAt(2, false);

        String userName = JOptionPane.showInputDialog("Please enter Username of  your postgres database!");
        String password = JOptionPane.showInputDialog("Enter Password!");

        try {
            boutiqueCoffee = new BoutiqueCoffee(userName, password);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Invalid Username or Password!");
            System.exit(0);
        }

        customerID = JOptionPane.showInputDialog("What is the Member ID?");
        double ret = boutiqueCoffee.getMemberID_GUI(Integer.parseInt(customerID));
        if (ret < 0) {
            JOptionPane.showMessageDialog(null, "Member Not Found");
        }
        String memFirstName = boutiqueCoffee.getMemberFirstName_GUI(Integer.parseInt(customerID));
        String memLastName = boutiqueCoffee.getMemberLastName_GUI(Integer.parseInt(customerID));
        lblGetCustName.setText(memFirstName + " " + memLastName);
        //Set up Points
        double pts = boutiqueCoffee.getPointsByCustomerId(Integer.parseInt(customerID));
        lblGetCustPts.setText(Double.toString(pts));

        btnPurchase.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                purchase();
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
                radStarbucks();
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
                radDunkin();
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
                radCrazyMocha();
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
                tabbedPane1.setEnabledAt(1, false);
                tabbedPane1.setEnabledAt(2, false);

                btnPurchase.setEnabled(false);
                cbSelectCoffee.removeAllItems();
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
                SpinnerNumberModel quantitylimit = new SpinnerNumberModel(0, 1, 9, 1);
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
        btnBackQuant.addActionListener(new ActionListener() {
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
            }
        });
        cbSelectCoffee.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                cbAction();
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

    private void radCrazyMocha() {
        tabbedPane1.setSelectedIndex(1);
        tabbedPane1.setEnabledAt(2, false);
        tabbedPane1.setEnabledAt(0, false);

        btnPurchase.setEnabled(false);
        cbSelectCoffee.addItem("Regular Coffee");
        cbSelectCoffee.addItem("Ice Coffee");
    }

    private void radDunkin() {
        tabbedPane1.setSelectedIndex(1);
        tabbedPane1.setEnabledAt(2, false);
        tabbedPane1.setEnabledAt(0, false);

        btnPurchase.setEnabled(false);
        cbSelectCoffee.addItem("Original Blend Vanilla");
        cbSelectCoffee.addItem("Dark Roast Mocha");
    }

    private void radStarbucks() {
        tabbedPane1.setSelectedIndex(1);
        tabbedPane1.setEnabledAt(2, false);
        tabbedPane1.setEnabledAt(0, false);

        btnPurchase.setEnabled(false);
        cbSelectCoffee.addItem("Caffee Misto");
        cbSelectCoffee.addItem("Iced Coffee ");
    }

    private void cbAction() {
        int coffeeID;
        if (radStarbucks.isSelected()) {
            if (cbSelectCoffee.getSelectedIndex() == 0) {
                coffeeID = 1;
                lblGetDesc.setText("Brewed Coffee w/Milk");
                lblGetIntensity.setText("Intensity: 5");
                lblGetPrice.setText("3.95");
                lblTotPtsRedeem.setText("50 Points");
                lblTotPtsEarn.setText("35 Points");
                setLabels();
            } else if (cbSelectCoffee.getSelectedIndex() == 1) {
                coffeeID = 2;
                lblGetDesc.setText("Ice Brewed Coffee");
                lblGetIntensity.setText("Intensity: 3");
                lblGetPrice.setText("4.95");
                lblTotPtsRedeem.setText("60 Points");
                lblTotPtsEarn.setText("45 Points");
                setLabels();
            } else {
                clearLabels();
            }
        } else if (radDunkin.isSelected()) {
            if (cbSelectCoffee.getSelectedIndex() == 0) {
                coffeeID = 3;
                lblGetDesc.setText("Vanilla Flavor");
                lblGetIntensity.setText("Intensity: 5");
                lblGetPrice.setText("2.99");
                lblTotPtsRedeem.setText("35 Points");
                lblTotPtsEarn.setText("20 Points");
                setLabels();
            } else if (cbSelectCoffee.getSelectedIndex() == 1) {
                coffeeID = 4;
                lblGetDesc.setText("Dark Roast w/ Mocha");
                lblGetIntensity.setText("Intensity: 7");
                lblGetPrice.setText("4.99");
                lblTotPtsRedeem.setText("65 Points");
                lblTotPtsEarn.setText("50 Points");
                setLabels();
            } else {
                clearLabels();
            }
        } else if (radCrazyMocha.isSelected()) {
            if (cbSelectCoffee.getSelectedIndex() == 0) {
                coffeeID = 5;
                lblGetDesc.setText("Coffee Blend");
                lblGetIntensity.setText("Intensity: 6");
                lblGetPrice.setText("5.49");
                lblTotPtsRedeem.setText("70 Points");
                lblTotPtsEarn.setText("55 Points");
                setLabels();
            } else if (cbSelectCoffee.getSelectedIndex() == 1) {
                coffeeID = 6;
                lblGetDesc.setText("Iced Coffee");
                lblGetIntensity.setText("Intensity: 2");
                lblGetPrice.setText("3.49");
                lblTotPtsRedeem.setText("30 Points");
                lblTotPtsEarn.setText("15 Points");
                setLabels();
            } else {
                clearLabels();
            }
        }
    }

    private void clearLabels() {
        lblGetDesc.setText("");
        lblGetIntensity.setText("");
        lblPrice.setText("");
        lblGetPrice.setText("");
        lblptsRedeem.setText("");
        lblTotPtsRedeem.setText("");
        lblPtsEarn.setText("");
        lblTotPtsEarn.setText("");
    }

    private void setLabels() {
        lblPtsEarn.setText("Earn: ");
        lblptsRedeem.setText("Redeem For:");
        lblPrice.setText("Price ($):");
    }

    private void purchase() {
        int StoreID = 0;
        if (radStarbucks.isSelected()) {
            StoreID = 1;
        } else if (radDunkin.isSelected()) {
            StoreID = 2;
        } else if (radCrazyMocha.isSelected()) {
            StoreID = 3;
        } else {
            JOptionPane.showMessageDialog(null, "Error in Store Selection");
        }
        int coffeeID = 0;
        if (radStarbucks.isSelected()) {
            if (cbSelectCoffee.getSelectedIndex() == 0) {
                coffeeID = 1;
            } else if (cbSelectCoffee.getSelectedIndex() == 1) {
                coffeeID = 2;
            }
        } else if (radDunkin.isSelected()) {
            if (cbSelectCoffee.getSelectedIndex() == 0) {
                coffeeID = 3;
            } else if (cbSelectCoffee.getSelectedIndex() == 1) {
                coffeeID = 4;
            }
        } else if (radCrazyMocha.isSelected()) {
            if (cbSelectCoffee.getSelectedIndex() == 0) {
                coffeeID = 5;

            } else if (cbSelectCoffee.getSelectedIndex() == 1) {
                coffeeID = 6;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Error in Coffee ID");
        }
        int quant = (int) spnQuantity.getValue();
        int redeem = (int) spnRedeem.getValue();
        Date d = Date.valueOf("2017-07-25");

        int ret = boutiqueCoffee.addPurchase_GUI(Integer.parseInt(customerID), StoreID, d, coffeeID, quant, redeem);
        if (ret < 0) {
            JOptionPane.showMessageDialog(null, "Purchase Failed, Please Retry!");
        } else {
            JOptionPane.showMessageDialog(null, "Thank you for your purchase. Your Purchase ID is: " + ret + ".");
        }
    }
}
