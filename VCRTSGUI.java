import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
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
   private final String MAIN_PAGE_NAME = "Main Page";
   private final String CREATE_JOB_REQUEST_PAGE_NAME = "Create Job Request Page";
   private final String CREATE_CAR_RENTAL_PAGE_NAME = "Create Job Request Page";
   private ArrayList<Button> pageSwitchButtons = new ArrayList<Button>();
   private ArrayList<String> screens = new ArrayList<String>();
   private PageSwitcher switcher = new PageSwitcher();
   private UserVerifier verifier = new UserVerifier();
   private JobRequestListener jobRequestListener = new JobRequestListener();
   private CarRentalRequestListener carRequestListener = new CarRentalRequestListener() ;
   private User currentUser;
   private Database database = new Database();
   
   public VCRTSGUI() {
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setLayout(new CardLayout());
      frame.setTitle("Vehicular Cloud Real Time System");
      frame.setSize(APP_WIDTH, APP_HEIGHT);
      frame.setResizable(false);

      startApp();
      frame.setVisible(true);
   }

   public static void main(String[] args) {
      new VCRTSGUI();
   }

   public void startApp() {
      // createIntroScreen();
      // createLoginScreen();
      // createSignUpScreen();
      // createMainPage();
      // createJobRequestPage();
      createCarRentalPage();
   }


   public void createIntroScreen() {
      JPanel welcomePanel = new JPanel();
      JLabel welcomeMessage = new JLabel("Welcome to this Vehicular Cloud Real Time System!");
      JTextArea explanation = new JTextArea("If you already have an account with us, select \"Login\" below. If this is your first time using this vehicular cloud system, click the \"Sign Up\" button.");
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

      username.addKeyListener(verifier);

      passwordSubpanel.setLayout(new BorderLayout(5, 0));
      passwordSubpanel.add(passwordLabel, BorderLayout.WEST);
      passwordSubpanel.add(password, BorderLayout.EAST);

      password.addKeyListener(verifier);

      login.addActionListener(verifier);

      back.addActionListener(switcher); //back button
      pageSwitchButtons.add(new Button(INTRO_PAGE_NAME, back));

      loginPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 50));

      loginPanel.add(message);
      loginPanel.add(usernameSubpanel);
      loginPanel.add(passwordSubpanel);
      loginPanel.add(login);
      loginPanel.add(back);
      frame.add(loginPanel, LOGIN_PAGE_NAME);
      screens.add(LOGIN_PAGE_NAME);
   }

   public void createSignUpScreen() {
      JPanel signUpPanel = new JPanel();
      JLabel header = new JLabel("Welcome, Please Enter The Following Information");
      JPanel usernameSubpanel = new JPanel();
      JLabel usernameLabel = new JLabel("Enter Username: ");
      JTextField username = new JTextField(20);
      JPanel passwordSubpanel = new JPanel();
      JLabel passwordLabel = new JLabel("Enter Password: ");
      JPasswordField password = new JPasswordField(20);
      JButton signup = new JButton("Sign Up");
      JButton back = new JButton("Back");

      usernameSubpanel.setLayout(new BorderLayout(5, 0));
      usernameSubpanel.add(usernameLabel, BorderLayout.WEST);
      usernameSubpanel.add(username, BorderLayout.EAST);
      username.addKeyListener(verifier);

      passwordSubpanel.setLayout(new BorderLayout(5, 0));
      passwordSubpanel.add(passwordLabel, BorderLayout.WEST);
      passwordSubpanel.add(password, BorderLayout.EAST);
      password.addKeyListener(verifier);
      
      signup.addActionListener(verifier);
 
      back.addActionListener(switcher);
      pageSwitchButtons.add(new Button(INTRO_PAGE_NAME, back));
      
      signUpPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 50));

      signUpPanel.add(header);
      signUpPanel.add(usernameSubpanel);
      signUpPanel.add(passwordSubpanel);
      signUpPanel.add(signup);
      signUpPanel.add(back);
      frame.add(signUpPanel, SIGNUP_PAGE_NAME);
      screens.add(SIGNUP_PAGE_NAME);
   }

   public void createMainPage() {
      JPanel mainPanel = new JPanel();
      JPanel headerSubPanel = new JPanel();
      JLabel header = new JLabel("Select whether you would like to rent out your car as an owner or");
      JLabel header2 = new JLabel("submit a job request as a client below.");
      JButton owner = new JButton("Rent Car As Owner");
      JButton client = new JButton("Request Job As Client");
      JButton signout = new JButton("Sign Out");

      header2.setHorizontalAlignment(JLabel.CENTER);

      client.addActionListener(switcher);
      pageSwitchButtons.add(new Button(CREATE_JOB_REQUEST_PAGE_NAME, client));

      signout.addActionListener(switcher);
      pageSwitchButtons.add(new Button(INTRO_PAGE_NAME, signout));

      headerSubPanel.setLayout(new BorderLayout());
      headerSubPanel.add(header, BorderLayout.NORTH);
      headerSubPanel.add(header2, BorderLayout.SOUTH);

      mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 150, 75));

      mainPanel.add(headerSubPanel);
      mainPanel.add(owner);
      mainPanel.add(client);
      mainPanel.add(signout);
      frame.add(mainPanel, MAIN_PAGE_NAME);
      screens.add(MAIN_PAGE_NAME);
   }

   public void createJobRequestPage() {
      JPanel jobRequestPanel = new JPanel();
      JLabel header = new JLabel("Fill in the following information to submit a job request");
      JPanel jobTitleSubPanel = new JPanel();
      JLabel jobTitleLabel = new JLabel("Job Title: ");
      JTextField jobTitle = new JTextField(20);
      JPanel jobDescriptionSubPanel = new JPanel();
      JLabel jobDescriptionLabel = new JLabel("Job Description: ");
      JTextArea jobDescription = new JTextArea(10, 30);
      JPanel approximateJobDurationSubPanel = new JPanel();
      JLabel approximateJobDurationLabel = new JLabel("Job Duration Time: ");
      JTextField approximateJobDuration = new JTextField(1);
      String[] timeOptions = {"hours", "minutes"};
      JComboBox<String> jobDurationTimes = new JComboBox<String>(timeOptions);
      JPanel jobDeadlineSubPanel = new JPanel();
      JLabel jobDeadlineLabel = new JLabel("Job Deadline (mm/dd/yyyy)");
      JPanel dateSubPanel = new JPanel(new GridLayout(1, 5));
      JTextField month = new JTextField(2);
      JTextField day = new JTextField(2);
      JTextField year = new JTextField(4);
      JLabel divider = new JLabel("/");
      JLabel divider2 = new JLabel("/");
      JButton submit = new JButton("Submit Job");
      JButton back = new JButton("Back");

      jobTitle.setName("Job Title");
      jobTitle.addKeyListener(jobRequestListener);

      jobTitleSubPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
      jobTitleSubPanel.add(jobTitleLabel);
      jobTitleSubPanel.add(jobTitle);

      jobDescription.setName("Job Description");
      jobDescription.addKeyListener(jobRequestListener);
      
      jobDescriptionSubPanel.setLayout(new BorderLayout());
      jobDescriptionSubPanel.add(jobDescriptionLabel, BorderLayout.NORTH);
      jobDescriptionSubPanel.add(jobDescription, BorderLayout.SOUTH);

      approximateJobDuration.setName("Job Duration Time");
      approximateJobDuration.addKeyListener(jobRequestListener);

      jobDurationTimes.addItemListener(jobRequestListener);
      
      approximateJobDurationSubPanel.setLayout(new GridLayout(1, 3, 10, 0));
      approximateJobDurationSubPanel.add(approximateJobDurationLabel);
      approximateJobDurationSubPanel.add(approximateJobDuration);
      approximateJobDurationSubPanel.add(jobDurationTimes);

      month.setName("Month");
      month.addKeyListener(jobRequestListener);
      day.setName("Day");
      day.addKeyListener(jobRequestListener);
      year.setName("Year");
      year.addKeyListener(jobRequestListener);
      
      divider.setHorizontalAlignment(JLabel.CENTER);
      divider.setPreferredSize(new Dimension(1, 1));

      divider2.setHorizontalAlignment(JLabel.CENTER);
      divider2.setPreferredSize(new Dimension(1, 1));

      dateSubPanel.add(month);
      dateSubPanel.add(divider);
      dateSubPanel.add(day);
      dateSubPanel.add(divider2);
      dateSubPanel.add(year);

      submit.addActionListener(jobRequestListener);

      back.addActionListener(switcher);
      pageSwitchButtons.add(new Button(MAIN_PAGE_NAME, back));

      jobDeadlineSubPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 0));
      jobDeadlineSubPanel.setSize(40, 40);
      jobDeadlineSubPanel.add(jobDeadlineLabel);
      jobDeadlineSubPanel.add(dateSubPanel);

      jobRequestPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 30));
      jobRequestPanel.add(header);
      jobRequestPanel.add(jobTitleSubPanel);
      jobRequestPanel.add(jobDescriptionSubPanel);
      jobRequestPanel.add(approximateJobDurationSubPanel);
      jobRequestPanel.add(jobDeadlineSubPanel);
      jobRequestPanel.add(submit);
      jobRequestPanel.add(back);
      frame.add(jobRequestPanel, CREATE_JOB_REQUEST_PAGE_NAME);
      screens.add(CREATE_JOB_REQUEST_PAGE_NAME);
   }
   
 public void createCarRentalPage() { //page for owners of vehicles to give their cars up for rent
      JPanel carRentalPanel = new JPanel();

      JLabel header = new JLabel("Fill in the following information to lend your car");

      JPanel makeSubPanel = new JPanel();
      JLabel makeLable = new JLabel("Enter Make of Vehicle");
      JTextField make = new JTextField(20);

      makeSubPanel.setLayout(new BorderLayout(5,0));
      makeSubPanel.add(makeLable, BorderLayout.WEST);
      makeSubPanel.add(make, BorderLayout.EAST);

      JButton submit = new JButton("Submit Job");
      submit.addActionListener(verifier);

      carRentalPanel.add(header);
      carRentalPanel.add(makeSubPanel);
      carRentalPanel.add(submit);
      frame.add(carRentalPanel, CREATE_CAR_RENTAL_PAGE_NAME);
      screens.add(CREATE_CAR_RENTAL_PAGE_NAME);

      carRentalPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 50));
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
               // verifier.setUsername("");
               // verifier.setPassword("");
               ((CardLayout)frame.getContentPane().getLayout()).show(frame.getContentPane(), screens.get(i));
            }
         }
      }
   }

   class UserVerifier implements ActionListener, KeyListener {
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
         if(((JButton)e.getSource()).getText().equals("Sign Up")) {
            if(!username.equals("") && !password.equals("") && !database.isUser(username)) {
               currentUser = new User(username, password);
               database.addUser(currentUser);
               showMainPage();
            }
            else
               System.out.println("An error occurred, please try again.");
         }
         else if(((JButton)e.getSource()).getText().equals("Login")) {
            if(database.accountFound(username, password)) {
               currentUser = database.getUser(username);
               showMainPage();
            }
            else {
               System.out.println("Account not found. Please try again or create a new account.");
            }
         }
      }

      public void showMainPage() {
         ((CardLayout)frame.getContentPane().getLayout()).show(frame.getContentPane(), MAIN_PAGE_NAME);
      }

      @Override
      public void keyTyped(KeyEvent e) {
         //Currently Unneeded        
      }

      @Override
      public void keyPressed(KeyEvent e) {
         //Currently Unneeded
      }

      @Override
      public void keyReleased(KeyEvent e) {
         if(e.getSource().getClass().getSimpleName().equals("JTextField")) {  
            username = ((JTextField)e.getSource()).getText();
         }
         if(e.getSource().getClass().getSimpleName().equals("JPasswordField")) {
            password = String.valueOf(((JPasswordField)e.getSource()).getPassword());
         }
      }

   }

   class JobRequestListener extends Job implements KeyListener, ActionListener, ItemListener {
      private String timeChoice = "hours";
      private String month;
      private String day;
      private String year;

      @Override
      public void actionPerformed(ActionEvent e) {
         if(timeChoice.equals("hours"))
            this.setDurationTime(this.getDurationTime() * 60);

         if(!this.getTitle().equals("") && !this.getDescription().equals("") && this.getDurationTime() >= 0 && 
         !month.equals("") && !day.equals("") && !year.equals("")) {
            System.out.println("Job submitted successfully");
            this.setDeadline(month + "/" + day + "/" + year);

            Client thisClient;
            if(database.isClient(currentUser)) {
               thisClient = database.getClient(currentUser.getUsername());
            }
            else {
               thisClient = new Client(currentUser.getUsername(), currentUser.getPassword());
            }

            Job newJob = new Job(this.getTitle(), this.getDescription(), this.getDurationTime(), this.getDeadline());
            thisClient.addJobToQueue(newJob);
            if(!database.isClient(thisClient)) {
               database.addClient(thisClient);
            }
            for(Client c: database.getClients()) {
               System.out.println(c);
            }
         }
         else {
            System.out.println("An error occurred. Please ensure you filled out all of the text boxes correctly.");
         }
      }

      @Override
      public void keyTyped(KeyEvent e) {
         //Currently Unneeded
      }

      @Override
      public void keyPressed(KeyEvent e) {
         //Currently Unneeded
      }

      @Override
      public void keyReleased(KeyEvent e) {
         switch(e.getSource().getClass().getSimpleName()) {
            
            case "JTextArea": {
               this.setDescription(((JTextArea)e.getSource()).getText());
               break;
            }

            case "JTextField": {
               switch(((JTextField)e.getSource()).getName()) {
                  
                  case "Job Title": {
                     this.setTitle(((JTextField)e.getSource()).getText());
                     break;
                  }
                  case "Job Duration Time": {
                     try {
                        int time = Integer.parseInt(((JTextField)e.getSource()).getText());
                        this.setDurationTime(time);
                     } 
                     catch(NumberFormatException n) {
                        this.setDurationTime(-1);
                     }
                     break;
                  }
                  case "Month": {
                     month = ((JTextField)e.getSource()).getText();
                     break;
                  }
                  case "Day": {
                     day = ((JTextField)e.getSource()).getText();
                     break;
                  }
                  case "Year": {
                     year = ((JTextField)e.getSource()).getText();
                     break;
                  }
               }
               break;
            }
         }
      }

      @Override
      public void itemStateChanged(ItemEvent e) {
         timeChoice = (String)((JComboBox)e.getSource()).getSelectedItem();
      }

   }
   class CarRentalRequestListener extends Car implements KeyListener, ActionListener, ItemListener {

      @Override
      public void actionPerformed(ActionEvent e) {
      }

      @Override
      public void keyTyped(KeyEvent e) {
      }

      @Override
      public void keyPressed(KeyEvent e) {
      }

      @Override
      public void keyReleased(KeyEvent e) {
      }

      @Override
      public void itemStateChanged(ItemEvent e) {
      }

   }
}