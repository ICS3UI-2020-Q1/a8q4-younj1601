import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main implements Runnable, ActionListener{

  // Class Variables  
  JPanel mainPanel;

  JLabel n;
  JLabel factorial;

  JTextField input;
  JTextField output;

  JButton calculate;


  // Method to assemble our GUI
  public void run(){
    // Creats a JFrame that is 800 pixels by 600 pixels, and closes when you click on the X
    JFrame frame = new JFrame("Title");
    // Makes the X button close the program
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // makes the windows 800 pixel wide by 600 pixels tall
    frame.setSize(800,600);
    // shows the window
    frame.setVisible(true);

    //initialize main panel;
    mainPanel = new JPanel();
    //disable layout helpers
    mainPanel.setLayout(null);

    //create labels
    n = new JLabel("n");
    factorial = new JLabel("Factorial(n)");

    //set location and size of labels
    n.setBounds(170,150,20,20);
    factorial.setBounds(310,150,100,20);

    //create text fields
    input = new JTextField();
    output = new JTextField();

    //set location and size of text fields
    input.setBounds(200,150,100,20);
    output.setBounds(400,150,100,20);

    //create button
    calculate = new JButton("CALC");

    //set location and size of button
    calculate.setBounds(520,150,100,20);

    //add action listener to button
    calculate.addActionListener(this);

    //set action command to button
    calculate.setActionCommand("math");
    
    //add labels to the panel
    mainPanel.add(n);
    mainPanel.add(factorial);

    //add text fields to the panel
    mainPanel.add(input);
    mainPanel.add(output);

    //add button to the panel
    mainPanel.add(calculate);

    //add panel to frame
    frame.add(mainPanel);

  }

  // method called when a button is pressed
  public void actionPerformed(ActionEvent e){
    // get the command from the action
    String command = e.getActionCommand();

    if(command.equals("math")){
      //get the text from input
      String firstText = input.getText();
      //convert text to integer
      int answer = Integer.parseInt(firstText);

      int factorial = 1;

      //calculate factorial
      for(int count = 1; count <= answer; count++){
        factorial = count*factorial;
      }

      //put answer into output
      output.setText("" + factorial);
    
    }
  }

  // Main method to start our program
  public static void main(String[] args){
    // Creates an instance of our program
    Main gui = new Main();
    // Lets the computer know to start it in the event thread
    SwingUtilities.invokeLater(gui);
  }
}
