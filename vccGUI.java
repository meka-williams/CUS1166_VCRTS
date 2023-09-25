import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.*;
import java.awt.event.*;


public class vccGUI extends JFrame implements ActionListener {
  private JLabel labelQuestion;
  private JLabel labelName;
  private JTextField fieldFirstName;
  private JTextField fieldLastName;

  private JButton buttonTellMe;

  public vccGUI() {
    super("User Information");

    initComponents();

    setSize(480, 300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    private void initComponents() {
      labelQuestion = new JLabel("Please register the following information.");
      labelName = new JLabel("Please enter your first and last name.");
      fieldFirstName = new JTextField(5);
      fieldLastName = new JTextField(6);
      buttonTellMe = new JButton("Sign up!");

      setLayout(new FlowLayout());

      add(labelQuestion);
      add(labelName);
      add(fieldFirstName);
      add(fieldLastName);
      add(buttonTellMe);

        buttonTellMe.addActionListener(this);

    }
    
  
 

 

    public static void main(String[] args) {
      new vccGUI().setVisible(true);
  }

    @Override
    public void actionPerformed(ActionEvent e) {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }

   
}
