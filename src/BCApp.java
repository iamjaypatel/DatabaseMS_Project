import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class BCApp {
    private JPanel mainPanel; // Member ID Panel
    private JButton btnAddMember;
    private JTextField txtFirstName;
    private JTextField txtLastName;
    private JTextField txtEmail;
    private JLabel lblFirstName;
    private JLabel lblLastName;
    private JLabel lblEmail;
    private JRadioButton radExisting;
    private JRadioButton radNewMember;
    private JComboBox cbMemberLvl;
    private JLabel lblMemberLvl;
    private JButton btnExit;

    private static BoutiqueCoffee boutiqueCoffee;

    public BCApp() {
        txtEmail.setEditable(false);
        txtLastName.setEditable(false);
        txtFirstName.setEditable(false);
        btnAddMember.setEnabled(false);
        cbMemberLvl.setEnabled(false);

        btnAddMember.addActionListener(new ActionListener() {
            /**
             * Find Member Button Pressed.
             *
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                addCustomer();
            }
        });

        radExisting.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                txtEmail.setEditable(false);
                txtLastName.setEditable(false);
                txtFirstName.setEditable(false);
                btnAddMember.setEnabled(false);

                BCAppDialog dialog = new BCAppDialog();
                dialog.pack();
                dialog.setVisible(true);

            }
        });
        radNewMember.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                txtEmail.setEditable(true);
                txtLastName.setEditable(true);
                txtFirstName.setEditable(true);
                btnAddMember.setEnabled(true);
                cbMemberLvl.setEnabled(true);
            }
        });
        btnExit.addActionListener(new ActionListener() {
            /**
             * Exit Button
             *
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    private void createUIComponents() {
        mainPanel = new JPanel();
        btnAddMember = new JButton();
        txtFirstName = new JTextField();
        txtLastName = new JTextField();
        txtEmail = new JTextField();

    }

    private void addCustomer() {
        String userName = JOptionPane.showInputDialog("Please enter Username of  your postgres database!");
        String password = JOptionPane.showInputDialog("Enter Password!");

        try {
            boutiqueCoffee = new BoutiqueCoffee(userName, password);
        } catch (Exception e1) {
            JOptionPane.showMessageDialog(null, "Invalid Username or Password!");
            System.exit(0);
        }
        fillMemberLevelTable();
        txtFirstName.getAccessibleContext();
        int val;
        int points = 0;
        int memberlvl = 1;
        if (cbMemberLvl.getSelectedIndex() == 1) {
            points = 100;
            memberlvl = 1;
            val = boutiqueCoffee.addCustomer(txtFirstName.getText(), txtLastName.getText(), txtEmail.getText(), memberlvl, points);
            JOptionPane.showMessageDialog(null, "Member Created, \n Member ID: " + val);
        } else if (cbMemberLvl.getSelectedIndex() == 2) {
            points = 250;
            memberlvl = 2;
            val = boutiqueCoffee.addCustomer(txtFirstName.getText(), txtLastName.getText(), txtEmail.getText(), memberlvl, points);
            JOptionPane.showMessageDialog(null, "Member Created, \n Member ID: " + val);
        } else if (cbMemberLvl.getSelectedIndex() == 3) {
            points = 450;
            memberlvl = 3;
            val = boutiqueCoffee.addCustomer(txtFirstName.getText(), txtLastName.getText(), txtEmail.getText(), memberlvl, points);
            JOptionPane.showMessageDialog(null, "Member Created, \n Member ID: " + val);
        } else if (cbMemberLvl.getSelectedIndex() == 4) {
            points = 750;
            memberlvl = 4;
            val = boutiqueCoffee.addCustomer(txtFirstName.getText(), txtLastName.getText(), txtEmail.getText(), memberlvl, points);
            JOptionPane.showMessageDialog(null, "Member Created, \n Member ID: " + val);
        } else {
            JOptionPane.showMessageDialog(null, "Please Select Member ID");
        }
    }

    private void fillMemberLevelTable() {
        boutiqueCoffee.addMemberLevel("Regular", 0.35);
        boutiqueCoffee.addMemberLevel("Gold", 0.7);
        boutiqueCoffee.addMemberLevel("Platinum", 1.1);
        boutiqueCoffee.addMemberLevel("Diamond", 1.89);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Boutique Coffee");
        frame.setContentPane(new BCApp().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}
