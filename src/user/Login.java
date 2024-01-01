package user;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class Login extends JFrame {
    private int frameWidth = 420;
    private int frameHeight = 300;

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField usernameField;
    private JPasswordField passwordField;

    // Launch the application.
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Login frame = new Login();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    // Create the frame.
    public Login() {
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, frameWidth, frameHeight);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setBounds(55, 47, 116, 13);
        contentPane.add(usernameLabel);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(55, 86, 116, 13);
        contentPane.add(passwordLabel);

        usernameField = new JTextField();
        usernameField.setBounds(181, 44, 139, 19);
        contentPane.add(usernameField);
        usernameField.setColumns(10);

        passwordField = new JPasswordField();
        passwordField.setBounds(181, 83, 139, 19);
        contentPane.add(passwordField);

        JLabel userTypeLabel = new JLabel("User Type");
        userTypeLabel.setBounds(56, 132, 115, 13);
        contentPane.add(userTypeLabel);

        JComboBox<String> userTypeComboBox = new JComboBox<>();
        userTypeComboBox.setModel(new DefaultComboBoxModel<>(new String[] { "Resident", "Tourist" }));
        userTypeComboBox.setBounds(181, 128, 139, 21);
        contentPane.add(userTypeComboBox);

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String username = usernameField.getText();
                String password = String.valueOf(passwordField.getPassword());
                String userType = userTypeComboBox.getSelectedItem().toString();
                String loginDetails = username + " " + password + " " + userType;
                int loginSuccessFlag = 0;

                try {
                    File userFile = new File("usernames.txt");
                    Scanner fileScanner = new Scanner(userFile);
                    while (fileScanner.hasNextLine()) {
                        String storedData = fileScanner.nextLine();
                        if (storedData.equals(loginDetails)) {
                            loginSuccessFlag = 1;
                        }
                    }
                    fileScanner.close();
                } catch (FileNotFoundException e) {
                    JOptionPane.showMessageDialog(null, "File not found.");
                    e.printStackTrace();
                }

                if (loginSuccessFlag == 1 && userType.equals("Resident")) {
                    ResidentMenu residentMenu = new ResidentMenu();
                    residentMenu.setVisible(true);
                    dispose();
                } else if (loginSuccessFlag == 1 && userType.equals("Tourist")) {
                    TouristMenu touristMenu = new TouristMenu();
                    touristMenu.setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Username or Password!");
                }
            }
        });
        loginButton.setBounds(181, 187, 68, 21);
        contentPane.add(loginButton);

        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                dispose();
            }
        });
        closeButton.setBounds(259, 187, 68, 21);
        contentPane.add(closeButton);

        JLabel background = new JLabel();
        ImageIcon icon = new ImageIcon("img/user.jpg");
        Image image = icon.getImage().getScaledInstance(frameWidth, frameHeight, Image.SCALE_SMOOTH);
        background.setIcon(new ImageIcon(image));
        background.setBounds(0, 0, frameWidth, frameHeight);
        contentPane.add(background);

        contentPane.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                int newWidth = contentPane.getWidth();
                int newHeight = contentPane.getHeight();
				Image scaledImage = icon.getImage().getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
				background.setIcon(new ImageIcon(scaledImage));
				background.setBounds(0, 0, newWidth, newHeight);
			}
		});
	}
}