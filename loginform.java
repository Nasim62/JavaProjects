package classwork;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class loginform {
    private static int attemptCount = 0; // Track the number of attempts
    private static final int MAX_ATTEMPTS = 3; // Max allowed attempts
    
    public static void main(String[] args) {
        // Create the frame (window)
        JFrame frame = new JFrame("Login Form");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new GridLayout(4, 2)); // Use GridLayout for form-like structure

        // Create form elements
        JLabel userLabel = new JLabel("User ID:");
        JTextField userTextField = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField();
        JButton loginButton = new JButton("Login");
        JLabel messageLabel = new JLabel("", SwingConstants.CENTER); // Message area
        
        // Add elements to the frame
        frame.add(userLabel);
        frame.add(userTextField);
        frame.add(passwordLabel);
        frame.add(passwordField);
        frame.add(loginButton);
        frame.add(messageLabel);
        
        // Predefined user ID and password
        String correctUserId = "admin";
        String correctPassword = "password123";
        
        // Add action listener to the login button
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String enteredUserId = userTextField.getText();
                String enteredPassword = new String(passwordField.getPassword());
                
                if (attemptCount < MAX_ATTEMPTS) {
                    // Check if user ID and password are correct
                    if (enteredUserId.equals(correctUserId) && enteredPassword.equals(correctPassword)) {
                        JOptionPane.showMessageDialog(frame, "Login successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                        frame.dispose(); // Close the window after successful login
                    } else {
                        attemptCount++;
                        if (attemptCount < MAX_ATTEMPTS) {
                            messageLabel.setText("Invalid credentials. Attempts left: " + (MAX_ATTEMPTS - attemptCount));
                        } else {
                            JOptionPane.showMessageDialog(frame, "You ran out of chances. Exiting program.", "Failed", JOptionPane.ERROR_MESSAGE);
                            frame.dispose(); // Close the window after 3 failed attempts
                        }
                    }
                }
            }
        });
        
        // Set frame to visible
        frame.setVisible(true);
    }
}

