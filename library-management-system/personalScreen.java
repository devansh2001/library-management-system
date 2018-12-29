import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class personalScreen {
    JFrame f;
    public personalScreen(String user) {
        f = new JFrame(user + "'s Homepage");
        JLabel l = new JLabel("Welcome, " + user + "!");
        l.setBounds(30,0,200,75);
        f.add(l);
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);

        JButton borrowbutton = new JButton("Borrow Book");
        borrowbutton.setBounds(30,100,150,50);
        f.add(borrowbutton);

        JButton returnbutton = new JButton("Return Book");
        returnbutton.setBounds(30,150,150,50);
        f.add(returnbutton);

        JButton logout = new JButton("Logout");
        logout.setBounds(30,250,150,50);
        f.add(logout);

        JButton donate = new JButton("Donate Book");
        donate.setBounds(30, 200, 150, 50);
        f.add(donate);

        donate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
                bookPage p = new bookPage(f);
            }
        });

        borrowbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
                borrowSystem br2 = new borrowSystem(f);

            }
        });
        returnbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                returnSystem br2 = new returnSystem(f);
            }
        });
        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(f, "Successfully signed out!");
                f.setVisible(false);
                mainScreen m = new mainScreen();
            }
        });

        f.setVisible(true);
        f.setLayout(null);
        f.setSize(270, 380);
    }
}
