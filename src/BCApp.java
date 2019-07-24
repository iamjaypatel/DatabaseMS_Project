import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BCApp {
    private JPanel mainPanel; // Member ID Panel
    private JButton btnAddMember;
    private JTextField txtFirstName;
    private JTextField txtLastName;
    private JTextField txtEmail;
    private JLabel lblFirstName;
    private JLabel lblLastName;
    private JLabel lblEmail;

    private static BoutiqueCoffee boutiqueCoffee;

    private JPanel secondPanel; // goes here after finding member
    public BCApp() {
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
                boutiqueCoffee.addCustomer(txtFirstName.getText(), txtLastName.getText(), txtEmail.getText(),1,0);
                JOptionPane.showMessageDialog(null, "Customer Added");
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        mainPanel = new JPanel();
        btnAddMember = new JButton();
        txtFirstName = new JTextField();
        txtLastName = new JTextField();
        txtEmail = new JTextField();
    }

    public static void main(String[] args) {
        try {
            boutiqueCoffee = new BoutiqueCoffee("postgres", "1");
        } catch (Exception e) {
            System.out.println("Connection Failed");
            System.out.println(e.getMessage());
            System.exit(-1);
        }

        JFrame frame = new JFrame("Boutique Coffee: Add Customer");
        frame.setContentPane(new BCApp().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        JFrame frame1 = new JFrame();
    }
}
