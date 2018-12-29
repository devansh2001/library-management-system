import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class borrowSystem {
    JFrame f;
    public String insertSpace(int length) {
        String retval = "";
        int rem = 40 - length;
        while(rem != 0){
            retval  += " ";
            rem--;
        }
        retval  += "  ";
        return retval;
    }

    public borrowSystem(JFrame k) {
        f = new JFrame("Borrow Book");
        JLabel l = new JLabel("Enter Book Code: ");
        l.setBounds(50,100,150,50);
        f.add(l);

        JTextField tf = new JTextField();
        tf.setBounds(200,100,150,50);
        f.add(tf);


        JButton b = new JButton("View Books");
        b.setBounds(50,200,150,50);
        f.add(b);

        JButton submit = new JButton("Submit!");
        submit.setBounds(210, 200, 150, 50);
        f.add(submit);

        b.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent p) {
                trial();
            }
        });

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userInput;
                userInput = tf.getText();
                try {
                    pressedSubmit(userInput, k);
                } catch (Exception ex) {
                   ex.printStackTrace();
                }
            }
        });

        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
        f.setVisible(true);
        f.setLayout(null);
        f.setSize(400,400);
    }

    public void trial() throws HeadlessException {
        BufferedReader br = null;
        String msg = "";
        try {
            br = new BufferedReader(new FileReader("LibProjBookData10.txt"));
            ArrayList<String> list = new ArrayList<String>();
            String content = br.readLine();
            int k = 0;
            while(content != null){
                list.add(content);
                content = br.readLine();
                k++;
            }
            JLabel l[] = new JLabel[list.size()];
            for(int i = 0; i < list.size(); i++){
                msg += list.get(i);
                msg += '\n';
            }
            JOptionPane.showMessageDialog(f, msg);
            br.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
    public void pressedSubmit(String input, JFrame t) throws IOException {
        BufferedReader br = null;

        int flag = 0;
        int recCounter = 0, recFound = 0;
        ArrayList<String> list = new ArrayList<String>();
        String msg = "";
        String details = new String();

        try {
            br = new BufferedReader(new FileReader("LibProjBookData10.txt"));
            String content = new String();
            content = br.readLine();

            while(content != null){
                list.add(content);
                recCounter++;
                if((content.substring(0, 4)).equals(input)){
                    flag = 1;
                    details = content;
                    recFound = recCounter;

                }
                content = br.readLine();

            }
            if (flag == 1) {
                int x = 0;
                String qty = new String();
                qty = details.substring(126, 169);
                int i = qty.indexOf(" ");
                qty = qty.substring(0, i);
                i = Integer.parseInt(qty);
                if(i == 0){
                    JOptionPane.showMessageDialog(f, "Stock Empty!");
                }
                else {
                    i--;
                    qty = "" + i;
                    qty = qty  +  insertSpace(qty.length());
                    details = details.substring(0,126)  +  qty  +  details.substring(170);
                    list.remove(--recFound);
                    list.add(recFound ,details);
                    br.close();
                    FileWriter fw = null;
                    BufferedWriter bw = null;
                	try {
                		fw = new FileWriter("LibProjBookData10.txt");
                            bw = new BufferedWriter(fw);
                            for(int j = 0; j < recCounter; j++){
                                bw.write(list.get(j));
                                bw.write('\n');
                            }
                            JOptionPane.showMessageDialog(f, "Book Borrowed!");
                            bw.close();
                            fw.close();
                    } catch(Exception exc) {
                        exc.printStackTrace();
                    }
                }
            } else JOptionPane.showMessageDialog(f,"Incorrect Code Number!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        f.setVisible(false);
        t.setVisible(true);
    }
}
