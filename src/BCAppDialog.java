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

    public BCAppDialog() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(btnPurchase);

        btnPurchase.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }
}
