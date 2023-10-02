import java.awt.CardLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class VCRTSGUI {
   private JFrame frame = new JFrame();
   private final int APP_WIDTH = 480;
   private final int APP_HEIGHT = 600;
   
   public VCRTSGUI() {
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLayout(new CardLayout());
    frame.setTitle("Vehicular Cloud Real Time System");
    frame.setSize(APP_WIDTH, APP_HEIGHT);

    createIntroScreen();
    frame.setVisible(true);
   }

   public static void main(String[] args) {
    new VCRTSGUI();
   }

   public void createIntroScreen() {
    JPanel welcomePanel = new JPanel();
    JLabel welcomeMessage = new JLabel("Welcome to this Vehicular Cloud Real Time System!");
    JTextArea explanation = new JTextArea("Enter Explanation Here. As a test, I'm going to put a long piece of text in here and see how it shows on the GUI. Using this test, I will be able to judge");
    JButton signUp = new JButton("Sign Up");
    JButton login = new JButton("Login");

    explanation.setEditable(false);
    explanation.setLineWrap(true);
    explanation.setWrapStyleWord(true);
    explanation.setSize(APP_WIDTH - 50, APP_HEIGHT - 50);

    welcomePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 50));
    welcomePanel.setBounds(0, 0, APP_WIDTH, APP_HEIGHT);

    welcomePanel.add(welcomeMessage);
    welcomePanel.add(explanation);
    welcomePanel.add(signUp);
    welcomePanel.add(login);
    frame.add(welcomePanel, "Intro Screen");
   }
}
