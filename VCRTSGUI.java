import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class VCRTSGUI {
   private JFrame frame = new JFrame();
   private final int APP_WIDTH = 480;
   private final int APP_HEIGHT = 600;
   private final String INTRO_PAGE_NAME = "Intro Page";
   private final String SIGNUP_PAGE_NAME = "Sign Up Page";
   private final String LOGIN_PAGE_NAME = "Login Page";
   private ArrayList<Button> pageSwitchButtons = new ArrayList<Button>();
   private ArrayList<String> screens = new ArrayList<String>();
   private PageSwitcher switcher = new PageSwitcher();
   private UserVerifier verifier = new UserVerifier();
   private Database database = new Database();
   
   public VCRTSGUI() {
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setLayout(new CardLayout());
      frame.setTitle("Vehicular Cloud Real Time System");
      frame.setSize(APP_WIDTH, APP_HEIGHT);

      startApp();
      frame.setVisible(true);
   }

   public static void main(String[] args) {
      new VCRTSGUI();
   }

   public void startApp() {
      createIntroScreen();
      createLoginScreen();
      createSignUpScreen();
   }

   public void createIntroScreen() {
      JPanel welcomePanel = new JPanel();
      JLabel welcomeMessage = new JLabel("Welcome to this Vehicular Cloud Real Time System!");
      JTextArea explanation = new JTextArea("Enter Explanation Here. As a test, I'm going to put a long piece of text in here and see how it shows on the GUI. Using this test, I will be able to judge");
      JButton signUp = new JButton("Sign Up");
      JButton login = new JButton("Login");

      explanation.setEditable(false);
      explanation.setFocusable(false);
      explanation.setLineWrap(true);
      explanation.setWrapStyleWord(true);
      explanation.setSize(APP_WIDTH - 50, APP_HEIGHT - 50);

      login.addActionListener(switcher);
      pageSwitchButtons.add(new Button(LOGIN_PAGE_NAME, login));

      signUp.addActionListener(switcher);
      pageSwitchButtons.add(new Button(SIGNUP_PAGE_NAME, signUp));

      welcomePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 50));
      welcomePanel.setBounds(0, 0, APP_WIDTH, APP_HEIGHT);

      welcomePanel.add(welcomeMessage);
      welcomePanel.add(explanation);
      welcomePanel.add(signUp);
      welcomePanel.add(login);
      frame.add(welcomePanel, INTRO_PAGE_NAME);
      screens.add(INTRO_PAGE_NAME);
   }

   public void createLoginScreen() {
      JPanel loginPanel = new JPanel();
      JLabel message = new JLabel("Welcome Back User! Please Login Below");
      JPanel usernameSubpanel = new JPanel();
      JLabel usernameLabel = new JLabel("Username: ");
      JTextField username = new JTextField(20);
      JPanel passwordSubpanel = new JPanel();
      JLabel passwordLabel = new JLabel("Password: ");
      JPasswordField password = new JPasswordField(20);
      JButton login = new JButton("Login");
      JButton back = new JButton("Back");

      usernameSubpanel.setLayout(new BorderLayout(5, 0));
      usernameSubpanel.add(usernameLabel, BorderLayout.WEST);
      usernameSubpanel.add(username, BorderLayout.EAST);

      username.addActionListener(verifier);

      passwordSubpanel.setLayout(new BorderLayout(5, 0));
      passwordSubpanel.add(passwordLabel, BorderLayout.WEST);
      passwordSubpanel.add(password, BorderLayout.EAST);

      password.addActionListener(verifier);

      login.addActionListener(verifier);

      loginPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 50));

      loginPanel.add(message);
      loginPanel.add(usernameSubpanel);
      loginPanel.add(passwordSubpanel);
      loginPanel.add(login);
      frame.add(loginPanel, LOGIN_PAGE_NAME);
      screens.add(LOGIN_PAGE_NAME);

      back.addActionListener(switcher); //back button
      loginPanel.add(back);
   }

   public void createSignUpScreen() {

      JPanel signUpPanel = new JPanel();
      JLabel header = new JLabel("Welcome, Please Enter The Following Information");

      JPanel usernameSubpanel = new JPanel();
      JLabel usernameLabel = new JLabel("Enter Username: ");
      JTextField username = new JTextField(20);
      usernameSubpanel.setLayout(new BorderLayout(5, 0));
      usernameSubpanel.add(usernameLabel, BorderLayout.WEST);
      usernameSubpanel.add(username, BorderLayout.EAST);
      username.addActionListener(verifier);

      JPanel passwordSubpanel = new JPanel();
      JLabel passwordLabel = new JLabel("Password: ");
      JPasswordField password = new JPasswordField(20);
      passwordSubpanel.setLayout(new BorderLayout(5, 0));
      passwordSubpanel.add(passwordLabel, BorderLayout.WEST);
      passwordSubpanel.add(password, BorderLayout.EAST);
      password.addActionListener(verifier);

      JButton login = new JButton("Login");
      login.addActionListener(verifier);

      signUpPanel.add(header);
      signUpPanel.add(usernameSubpanel);
      signUpPanel.add(passwordSubpanel);
      signUpPanel.add(login);

      frame.add(signUpPanel, SIGNUP_PAGE_NAME);
      screens.add(SIGNUP_PAGE_NAME);

      JButton back = new JButton("Back");
      back.addActionListener(switcher);
      signUpPanel.add(back);

      signUpPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 50));



   }

   class Button {
      private JButton button;
      private String title;

      public Button(String title, JButton button) {
         this.title = title;
         this.button = button;
      }

      public JButton getButton() {
         return button;
      }

      public void setButton(JButton button) {
         this.button = button;
      }

      public String getTitle() {
         return title;
      }

      public void setTitle(String title) {
         this.title = title;
      }
   }

   class PageSwitcher implements ActionListener {
      @Override
      public void actionPerformed(ActionEvent e) {
         String requestedPage = "";

         for(int i = 0; i < pageSwitchButtons.size(); i++) {
            if(e.getSource().equals(pageSwitchButtons.get(i).getButton())) {
               requestedPage = pageSwitchButtons.get(i).getTitle();
            }
         }

         for(int i = 0; i < screens.size(); i++) {
            if(requestedPage.equals(screens.get(i))) {
               ((CardLayout)frame.getContentPane().getLayout()).show(frame.getContentPane(), screens.get(i));
            }
         }
      }
   }

   class UserVerifier implements ActionListener {
      private String username = "";
      private String password = "";

      public String getUsername() {
         return username;
      }

      public void setUsername(String username) {
         this.username = username;
      }

      public String getPassword() {
         return password;
      }

      public void setPassword(String password) {
         this.password = password;
      }

      @Override
      public void actionPerformed(ActionEvent e) {
         if(e.getClass().getName().equals("JTextField"))
            username = ((JTextField)e.getSource()).getText();
         if(e.getClass().getName().equals("JPasswordField"))
            password = String.valueOf(((JPasswordField)e.getSource()).getPassword());

         
      }

   }
}