package user;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class ResidentMenu extends JFrame {
    private static final long serialVersionUID = 1L;
    private int menuWidth = 720;
    private int menuHeight = 540;

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ResidentMenu menuFrame = new ResidentMenu();
                    menuFrame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public ResidentMenu() {
        setTitle("ResidentMenu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, menuWidth, menuHeight);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel collegeLabel = new JLabel("College");
        collegeLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        collegeLabel.setBounds(29, 23, 175, 23);
        collegeLabel.setForeground(Color.RED);
        contentPane.add(collegeLabel);

        List<String> collegeList = new ArrayList<String>();
        try {
            File placesFile = new File("places.txt");
            Scanner myReader = new Scanner(placesFile);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if (data.equals("College")) {
                    collegeList.add(myReader.nextLine());
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        String[] collegeArray = collegeList.toArray(new String[] {});

        JComboBox<String> collegeComboBox = new JComboBox<>();
        collegeComboBox.setModel(new DefaultComboBoxModel<String>(collegeArray));
        collegeComboBox.setBounds(29, 66, 536, 21);
        contentPane.add(collegeComboBox);

        JButton viewCollegesButton = new JButton("View Colleges");
        viewCollegesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String place, name;
                name = collegeComboBox.getSelectedItem().toString();
                place = "College";
                DisplayPlaces dp = new DisplayPlaces(place, name);
                dp.setVisible(true);
            }
        });
        viewCollegesButton.setBounds(29, 110, 123, 21);
        contentPane.add(viewCollegesButton);

        JLabel libraryLabel = new JLabel("View Libraries");
        libraryLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        libraryLabel.setBounds(29, 178, 175, 23);
        libraryLabel.setForeground(Color.RED);
        contentPane.add(libraryLabel);

        List<String> libraryList = new ArrayList<String>();
        try {
            File placesFile = new File("places.txt");
            Scanner myReader = new Scanner(placesFile);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if (data.equals("Library")) {
                    libraryList.add(myReader.nextLine());
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        String[] libraryArray = libraryList.toArray(new String[] {});
        JComboBox<String> libraryComboBox = new JComboBox<>();
        libraryComboBox.setModel(new DefaultComboBoxModel<String>(libraryArray));
        libraryComboBox.setBounds(29, 225, 536, 21);
        contentPane.add(libraryComboBox);

        JButton viewLibraryButton = new JButton("View Library");
        viewLibraryButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String place, name;
                name = libraryComboBox.getSelectedItem().toString();
                place = "Library";
                DisplayPlaces dp = new DisplayPlaces(place, name);
                dp.setVisible(true);
            }
        });
        viewLibraryButton.setBounds(28, 269, 124, 21);
        contentPane.add(viewLibraryButton);

        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                dispose();
            }
        });
        closeButton.setBounds(177, 269, 99, 21);
        contentPane.add(closeButton);

        JLabel imageLabel = new JLabel();
        ImageIcon icon = new ImageIcon("img/resident.jpg");
        Image image = icon.getImage().getScaledInstance(menuWidth, menuHeight, Image.SCALE_SMOOTH);
        imageLabel.setIcon(new ImageIcon(image));
        imageLabel.setBounds(0, 0, menuWidth, menuHeight);
        contentPane.add(imageLabel);

        contentPane.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                int newWidth = contentPane.getWidth();
                int newHeight = contentPane.getHeight();
                Image scaledImage = icon.getImage().getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
                imageLabel.setIcon(new ImageIcon(scaledImage));
                imageLabel.setBounds(0, 0, newWidth, newHeight);
            }
        });
    }
}
