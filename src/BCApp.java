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
    private JTextField txtMemberID;
    private JButton btnFindMemID;
    private JLabel lblMemberID;
    private JLabel lblRetMemID;
    private JLabel lblretValMemID;
    private JRadioButton radExisting;
    private JRadioButton radNewMember;

    private static BoutiqueCoffee boutiqueCoffee;

    private JPanel secondPanel; // goes here after finding member

    public BCApp() {
        txtEmail.setEditable(false);
        txtLastName.setEditable(false);
        txtFirstName.setEditable(false);
        btnAddMember.setEnabled(false);
        txtMemberID.setEditable(false);
        btnFindMemID.setEnabled(false);
        lblRetMemID.setVisible(false);

        boutiqueCoffee.addMemberLevel("Regular", 0.35);
        boutiqueCoffee.addMemberLevel("Gold", 0.7);
        boutiqueCoffee.addMemberLevel("Platinum", 1.1);
        boutiqueCoffee.addMemberLevel("Diamond", 1.89);

        btnAddMember.addActionListener(new ActionListener() {
            /**
             * Find Member Button Pressed.
             *
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                txtFirstName.getAccessibleContext();
                int val;
                val = boutiqueCoffee.addCustomer(txtFirstName.getText(), txtLastName.getText(), txtEmail.getText(), 1, 0);
                JOptionPane.showMessageDialog(null, "Member Created, \n Member ID: " + val);
            }
        });
        btnFindMemID.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                double ret;
                txtMemberID.getAccessibleContext();
                ret = boutiqueCoffee.getMemberID(Integer.parseInt(txtMemberID.getText()));
                lblretValMemID.setText(Double.toString(ret));

                if (ret != -1.0) {
                    lblRetMemID.setVisible(true);
                    lblretValMemID.setVisible(true);
                    BCAppDialog dialog = new BCAppDialog();
                    dialog.pack();
                    dialog.setVisible(true);
                } else {
                    lblRetMemID.setVisible(false);
                    lblretValMemID.setText("Member NOT FOUND");
                }
            }
        });
        txtMemberID.addKeyListener(new KeyAdapter() {
            /**
             * Invoked when a key has been pressed.
             *
             * @param e
             */
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                try {
                    int i = Integer.parseInt(txtMemberID.getText());
                } catch (NumberFormatException e1) {
                }
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
                lblRetMemID.setVisible(false);
                lblretValMemID.setVisible(false);

                txtMemberID.setEditable(true);
                btnFindMemID.setEnabled(true);

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
                lblRetMemID.setVisible(true);


                txtMemberID.setEditable(false);
                btnFindMemID.setEnabled(false);
                lblretValMemID.setVisible(false);
                lblRetMemID.setVisible(false);
            }
        });
    }

    private void createUIComponents() {
        mainPanel = new JPanel();
        btnAddMember = new JButton();
        txtFirstName = new JTextField();
        txtLastName = new JTextField();
        txtEmail = new JTextField();
        txtMemberID = new JTextField();

    }

    public static void main(String[] args) {
        try {
            boutiqueCoffee = new BoutiqueCoffee("postgres", "1");
        } catch (Exception e) {
            System.out.println("Connection Failed");
            System.out.println(e.getMessage());
            System.exit(-1);
        }

        JFrame frame = new JFrame("Boutique Coffee");
        frame.setContentPane(new BCApp().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}
