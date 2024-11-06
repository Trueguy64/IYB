import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BankLoginPage extends JFrame {

    // Declare components
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JLabel messageLabel;

    // Simulated data (username and password for simplicity)
    private static final String VALID_USERNAME = "user123";
    private static final String VALID_PASSWORD = "pass123";

    public BankLoginPage() {
        // Set up the JFrame
        setTitle("Bank Login Page");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);  // Center the window on the screen

        // Create a panel to hold the components
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        // Add components to the panel
        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();
        loginButton = new JButton("Login");
        messageLabel = new JLabel(" ", JLabel.CENTER);
        messageLabel.setForeground(Color.RED);

        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(new JLabel());  // Empty label for alignment
        panel.add(loginButton);
        panel.add(messageLabel);

        // Add the panel to the frame
        add(panel);

        // Add action listener for the login button
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleLogin();
            }
        });
    }

    private void handleLogin() {
        String username = usernameField.getText();
        char[] password = passwordField.getPassword();
        String passwordString = new String(password);

        // Check if the username and password match the hardcoded values
        if (username.equals(VALID_USERNAME) && passwordString.equals(VALID_PASSWORD)) {
            messageLabel.setText("Login successful!");
            messageLabel.setForeground(Color.GREEN);
            JOptionPane.showMessageDialog(this, "Welcome to your bank account!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            messageLabel.setText("Invalid username or password.");
            usernameField.setText("");  // Clear the username field
            passwordField.setText("");  // Clear the password field
        }
    }

    public static void main(String[] args) {
        // Create the login page and make it visible
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new BankLoginPage().setVisible(true);
            }
        });
    }
}
