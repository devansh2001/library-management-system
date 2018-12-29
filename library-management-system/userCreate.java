import javax.swing.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class userCreate {

    public userCreate(){
        gui_userPage();
    }

    public String insertSpace(int length) {
        String retval = "";
        int rem = 40 - length;
        while(rem != 0) {
            retval += " ";
            rem--;
        }
        retval += "  ";
        return retval;
    }

    public void gui_userPage() {
        JFrame f = new JFrame("Create User");
        JLabel l_id = new JLabel("ID: ");
        JLabel l_name = new JLabel("Name: ");
        JLabel l_contact = new JLabel("Contact: ");
        JLabel l_password = new JLabel("Password: ");

        l_id.setBounds(50, 50, 75, 50);
        l_name.setBounds(50, 100, 75, 50);
        l_contact.setBounds(50, 150, 75, 50);
        l_password.setBounds(50, 200, 75, 50);

        f.add(l_id);
        f.add(l_name);
        f.add(l_contact);
        f.add(l_password);

        JTextField tf_id = new JTextField();
        JTextField tf_name = new JTextField();
        JTextField tf_contact = new JTextField();
        JTextField tf_password = new JTextField();

        tf_id.setBounds(130, 50, 100, 50);
        tf_name.setBounds(130, 100, 100, 50);
        tf_contact.setBounds(130, 150, 100, 50);
        tf_password.setBounds(130, 200, 100, 50);

        f.add(tf_id);
        f.add(tf_name);
        f.add(tf_contact);
        f.add(tf_password);

        JButton b = new JButton("Create!");
        b.setBounds(100, 270, 100, 50);
        f.add(b);
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                BufferedWriter bw = null;
                FileWriter fw = null;
                try {
                    File file = new File("LibProjUserDataFile.txt");
        	        fw = new FileWriter(file.getAbsoluteFile(), true);
                    bw = new BufferedWriter(fw);
                    bw.write(tf_id.getText() + insertSpace(tf_id.getText().length())+ tf_password.getText() + insertSpace(tf_password.getText().length()) + tf_name.getText() + insertSpace(tf_name.getText().length()) + tf_contact.getText() + insertSpace(tf_contact.getText().length()) );
                    bw.write('\n');
                    bw.close();
                    fw.close();
                    JOptionPane.showMessageDialog(f, "User Account Successfully Created!");
                    f.setVisible(false);
                    loginPage lp = new loginPage();
                } catch(Exception j) {
    		      j.printStackTrace();
    	        }

                try {
                    fw.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

                try {
                    bw.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        f.setLayout(null);
        f.setSize(360,400);
        f.setVisible(true);
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
