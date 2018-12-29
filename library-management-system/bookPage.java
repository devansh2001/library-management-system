import javax.swing.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.File;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import java.io.FileWriter;
import java.io.IOException;

public class bookPage {

    public bookPage(JFrame t) {
        gui_bookPage(t);
    }
    public String insertSpace(int length) {
        String retval = "";
        int rem = 40 - length;
        while(rem!=0){
            retval += " ";
            rem--;
        }
        retval += "  ";
        return retval;
    }
    public void gui_bookPage(JFrame t) {
        JFrame f = new JFrame("Create Book");

        JLabel l_code = new JLabel("Code: ");
        JLabel l_name = new JLabel("Name: ");
        JLabel l_author = new JLabel("Author: ");
        JLabel l_qty = new JLabel("Quantity: ");
        JLabel l_length = new JLabel("Length: ");
        JLabel l_genre = new JLabel("Genre: ");

        l_code.setBounds(50,50,75, 50);
        l_name.setBounds(50,100,75,50);
        l_author.setBounds(50,150,75,50);
        l_qty.setBounds(50,200,75,50);
        l_length.setBounds(50,250,75,50);
        l_genre.setBounds(50,300,75,50);

        f.add(l_code);
        f.add(l_name);
        f.add(l_author);
        f.add(l_qty);
        f.add(l_length);
        f.add(l_genre);

        JTextField tf_code = new JTextField();
        JTextField tf_name = new JTextField();
        JTextField tf_author = new JTextField();
        JTextField tf_qty = new JTextField();
        JTextField tf_length = new JTextField();

        tf_code.setBounds(130, 50, 150, 50);
        tf_name.setBounds(130, 100, 150, 50);
        tf_author.setBounds(130, 150, 150, 50);
        tf_qty.setBounds(130, 200, 150, 50);
        tf_length.setBounds(130, 250, 150, 50);

        f.add(tf_code);
        f.add(tf_name);
        f.add(tf_author);
        f.add(tf_qty);
        f.add(tf_length);

        JRadioButton rb1 = new JRadioButton("Horror");
        JRadioButton rb2 = new JRadioButton("Drama");
        JRadioButton rb3 = new JRadioButton("Action");
        JRadioButton rb4 = new JRadioButton("Fiction");
        JRadioButton rb5 = new JRadioButton("Romance");
        JRadioButton rb6 = new JRadioButton("Academic");

        ButtonGroup bg = new ButtonGroup();
        bg.add(rb1);
        bg.add(rb2);
        bg.add(rb3);
        bg.add(rb4);
        bg.add(rb5);
        bg.add(rb6);

        rb1.setBounds(130, 300, 100,30);
        rb2.setBounds(130, 330, 100,30);
        rb3.setBounds(130, 360, 100,30);
        rb4.setBounds(130, 390, 100,30);
        rb5.setBounds(130, 420, 100,30);
        rb6.setBounds(130, 450, 100,30);

        f.add(rb1);
        f.add(rb2);
        f.add(rb3);
        f.add(rb4);
        f.add(rb5);
        f.add(rb6);

        String genre;
        if(rb1.isSelected()){
            genre = rb1.getText();
        }
        else if(rb2.isSelected()){
            genre = rb2.getText();
        }
        else if(rb3.isSelected()){
            genre = rb3.getText();
        }
        else if(rb4.isSelected()){
            genre = rb4.getText();
        }
        else if(rb5.isSelected()){
            genre = rb5.getText();
        }
        else genre = rb6.getText();
        JButton b = new JButton("Create!");
        b.setBounds(100,500,75,35);
        f.add(b);

        f.setLayout(null);
        f.setSize(400,600);
        f.setVisible(true);
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BufferedWriter bw = null;
            	FileWriter fw = null;
                try {
                    File file = new File("LibProjBookData10.txt");
        		    fw = new FileWriter(file.getAbsoluteFile(), true);
                    bw = new BufferedWriter(fw);
                    bw.write(tf_code.getText() + insertSpace(tf_code.getText().length()) + tf_name.getText() + insertSpace(tf_name.getText().length()) + tf_author.getText() + insertSpace(tf_author.getText().length()) + tf_qty.getText() + insertSpace(tf_qty.getText().length()) + tf_length.getText() + insertSpace(tf_length.getText().length()) + genre);
                    bw.write('\n');
                    bw.close();
                    fw.close();
                    JOptionPane.showMessageDialog(f, "Book Successfully Created!");
                    t.setVisible(true);
                    f.setVisible(false);
                    fw.close();
                    bw.close();
                } catch(Exception j) {
			         j.printStackTrace();
                }
            }
        });
    }
}
