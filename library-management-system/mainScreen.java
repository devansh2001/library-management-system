import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;

public class mainScreen {
    JFrame f;
    public mainScreen() {
        f = new JFrame("Main Menu");
        f.setLayout(null);
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
        f.setVisible(true);
        f.setSize(550,300);

        JButton newuser = new JButton("New User");
        JButton existinguser = new JButton("Existing User");
        JLabel welcome = new JLabel("Welcome to Library Management System");
        welcome.setBounds(30,50,300,100);
        newuser.setBounds(60, 150, 150, 75);
        existinguser.setBounds(300, 150, 150, 75);

        newuser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                f.setVisible(false);
                userCreate up = new userCreate();
            }
        });

        existinguser.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                f.setVisible(false);
                loginPage lp = new loginPage();
            }
        });

        f.add(newuser);
        f.add(existinguser);
        f.add(welcome);

    }
    public static void main(String[] args) {
        new mainScreen();
    }
}
