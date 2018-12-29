import finalproject.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class loginPage{
    JFrame f;
    public String insertSpace(int length){
        String retval = "";
        int rem = 40 - length;
        while(rem!=0){
            retval += " ";
            rem--;
        }
        return retval;
    }
    public loginPage() {
        f = new JFrame("Login");
        f.setVisible(true);
        f.setLayout(null);
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel l_usercode = new JLabel("User Code: ");
        JLabel l_password = new JLabel("Password: ");

        l_usercode.setBounds(60, 50, 100, 50);
        l_password.setBounds(60, 110, 100, 50);

        f.add(l_password);
        f.add(l_usercode);

        JTextField tf_usercode = new JTextField();
        JTextField tf_password = new JTextField();

        tf_usercode.setBounds(140,50,100,50);
        f.add(tf_usercode);

        tf_password.setBounds(140,110,100,50);
        f.add(tf_password);

        f.setSize(300,300);

        JButton b = new JButton("Sign In!");
        b.setBounds(100,180,75,50);
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                String input_user = tf_usercode.getText();
                String input_pword = tf_password.getText();
                input_user = input_user + insertSpace(input_user.length());
                input_pword = input_pword + insertSpace(input_pword.length());
                pressedButton(input_user, input_pword);
            }
        });
        f.add(b);
    }

    public void pressedButton(String input_user, String input_pword) {
        BufferedReader br = null;
        ArrayList<String> list = new ArrayList<String>();
        try{
            br = new BufferedReader(new FileReader("LibProjUserDataFile.txt"));
            String content = new String();
            content = br.readLine();
            while(content != null){
                list.add(content);
                if((content.substring(0,40)).equals(input_user) && content.substring(41,80).equals(input_pword)){
                    personalScreen ps = new personalScreen(content.substring(80,120));
                    f.setVisible(false);
                }
                content = br.readLine();
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}
