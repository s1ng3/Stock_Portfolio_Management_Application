package prj.StockPortofolio.Stocks_Portfolio_Management_Application.ui;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;
public class LoginJFrame extends JFrame {
    public static final Map<String, String> accounts = new HashMap<>();

    public LoginJFrame() {
        //setup the window
        this.setTitle("Login");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setBounds(200, 200, 300, 200);

        //create and add components
        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(20, 20, 100, 20);
        this.add(userLabel);

        JTextField userInputField = new JTextField();
        userInputField.setBounds(160, 20, 100, 20);
        this.add(userInputField);

        JLabel pwdLabel = new JLabel("Password:");
        pwdLabel.setBounds(20, 60, 100, 20);
        this.add(pwdLabel);

        JPasswordField pwdInputField = new JPasswordField();
        pwdInputField.setBounds(160, 60, 100, 20);
        this.add(pwdInputField);

        JButton button = new JButton("Login");
        button.setBounds(20, 100, 240, 20);
        this.add(button);

        // add event listener to button
        button.addActionListener(e -> verifyCredentials(userInputField, pwdInputField));

        //initialize accounts
        initAccounts();

        //display
        this.setVisible(true);
    }

    private void verifyCredentials(JTextField userInputField, JPasswordField pwdInputField) {
        String username = userInputField.getText();
        String password = new String(pwdInputField.getPassword());

        if (accounts.containsKey(username) && accounts.get(username).equals(password)) {
            LoginJFrame.this.setVisible(false);
            new StockMarketJFrame();
        } else {
            JDialog errDialog = new JDialog();
            errDialog.setTitle("Error");
            errDialog.setBounds(200, 200, 240, 100);
            errDialog.setLayout(new BorderLayout());
            JLabel errLabel = new JLabel("Incorrect username or password");
            errLabel.setHorizontalAlignment(JLabel.CENTER);
            errDialog.add(errLabel, BorderLayout.CENTER);
            JButton okButton = new JButton("OK");
            okButton.addActionListener(e -> errDialog.dispose());
            JPanel buttonPanel = new JPanel(new FlowLayout());
            buttonPanel.add(okButton);
            errDialog.add(buttonPanel, BorderLayout.SOUTH);
            errDialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            errDialog.setVisible(true);
        }
    }


    private void initAccounts() {
        accounts.put("user1", "password1");
    }
}
