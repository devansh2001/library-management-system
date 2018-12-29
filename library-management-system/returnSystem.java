import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
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

public class returnSystem {
    JFrame f;

    public void pressedReturn(String input) throws IOException {
        BufferedReader br = null;
        int flag = 0;
        int recCounter = 0, recFound = 0;
        ArrayList<String> list = new ArrayList<String>();

        String details = new String();
        String content = new String();


        try {
            br = new BufferedReader(new FileReader("LibProjBookData10.txt"));
            content = br.readLine();
            while (content != null) {
                list.add(content);
                recCounter++;
                if ((content.substring(0, 4)).equals(input)) {
                    flag = 1;
                    details = content;
                    recFound = recCounter;
                }
                content = br.readLine();

            }
            if(flag == 1){
                int x = 0;
                String qty = new String();
                qty = details.substring(126, 169);
                int i = qty.indexOf(" ");
                qty = qty.substring(0,i);
                i = Integer.parseInt(qty);
                if(true) {
                    i++;
                    qty = ""+i;
                    qty = qty + insertSpace(qty.length());
                    details = details.substring(0,126) + qty + details.substring(170);
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
                        bw.close();
                        fw.close();
                        JOptionPane.showMessageDialog(f, "Book Returned!");
                        f.setVisible(false);
                    }
                    catch (Exception l) {
                        l.printStackTrace();
                    }
                }
            } else JOptionPane.showMessageDialog(f,"Incorrect Code Number!");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public returnSystem(JFrame t) {
        f = new JFrame("Return Book");

        JLabel l = new JLabel("Enter Book Code: ");
        l.setBounds(50,50,100,50);
        f.add(l);

        JTextField tf = new JTextField();
        tf.setBounds(175,50,100,50);
        f.add(tf);

        JButton b = new JButton("Return");
        b.setBounds(180, 125, 120, 50);
        f.add(b);

        JButton view = new JButton("View Books");
        view.setBounds(40,125,120,50);
        f.add(view);

        view.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                trial();
            }
        });

        b.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String userInput = tf.getText();
                try {
                    pressedReturn(userInput);
                } catch (IOException ex) {
                    //Logger.getLogger(returnSystem3.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
        f.setLayout(null);
        f.setSize(350,250);
        f.setVisible(true);
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void trial() throws HeadlessException {
        BufferedReader br = null;
        String msg = "";
        try {
            br = new BufferedReader(new FileReader("LibProjBookData10.txt"));
            ArrayList<String> list = new ArrayList<String>();
            String content = br.readLine();
            int k = 0;
            while(content != null) {
                list.add(content);
                content = br.readLine();
                k++;
            }
            JLabel l[] = new JLabel[list.size()];
            for(int i = 0; i<list.size();i++) {
                msg += list.get(i);
                msg += '\n';
            }
            JOptionPane.showMessageDialog(f, msg);
            br.close();
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    public String insertSpace(int length){
        String retval = "";
        int rem = 40 - length;
        while(rem != 0){
            retval += " ";
            rem--;
        }
        retval += "  ";
        return retval;
    }
}
