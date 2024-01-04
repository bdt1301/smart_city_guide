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

public class PlaceMenu extends JFrame {
    private static final long serialVersionUID = 1L;
    private int menuWidth = 960;
    private int menuHeight = 720;

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    PlaceMenu menuFrame = new PlaceMenu("admin");
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
    public PlaceMenu(String name) {
        setTitle("PlaceMenu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 50, menuWidth, menuHeight);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel welcomeLabel = new JLabel("Xin chào " + name);
        welcomeLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        welcomeLabel.setForeground(Color.RED);
        welcomeLabel.setBounds(700, 14, 200, 23);
        contentPane.add(welcomeLabel);

        JLabel healthFacilityLabel = new JLabel("Health Facility");
        healthFacilityLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        healthFacilityLabel.setBounds(29, 23, 175, 23);
        healthFacilityLabel.setForeground(Color.RED);
        contentPane.add(healthFacilityLabel);

        List<String> healthFacilityList = new ArrayList<String>();
        try {
            File placesFile = new File("places.txt");
            Scanner myReader = new Scanner(placesFile);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if (data.equals("Health Facility")) {
                    healthFacilityList.add(myReader.nextLine());
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        String[] healthFacilityArray = healthFacilityList.toArray(new String[] {});

        JComboBox<String> healthFacilityComboBox = new JComboBox<>();
        healthFacilityComboBox.setModel(new DefaultComboBoxModel<String>(healthFacilityArray));
        healthFacilityComboBox.setBounds(29, 66, 536, 21);
        contentPane.add(healthFacilityComboBox);

        JButton viewHealthFacilityButton = new JButton("View Information");
        viewHealthFacilityButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String place, name;
                name = healthFacilityComboBox.getSelectedItem().toString();
                place = "Health Facility";
                DisplayPlaces dp = new DisplayPlaces(place, name);
                dp.setVisible(true);
            }
        });
        viewHealthFacilityButton.setBounds(29, 110, 128, 21);
        contentPane.add(viewHealthFacilityButton);

        JLabel publicUtilitiesLabel = new JLabel("Public Utilities");
        publicUtilitiesLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        publicUtilitiesLabel.setBounds(29, 178, 175, 23);
        publicUtilitiesLabel.setForeground(Color.RED);
        contentPane.add(publicUtilitiesLabel);

        List<String> publicUtilitiesList = new ArrayList<String>();
        try {
            File placesFile = new File("places.txt");
            Scanner myReader = new Scanner(placesFile);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if (data.equals("Public Utilities")) {
                    publicUtilitiesList.add(myReader.nextLine());
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        String[] publicUtilitiesArray = publicUtilitiesList.toArray(new String[] {});
        JComboBox<String> publicUtilitiesComboBox = new JComboBox<>();
        publicUtilitiesComboBox.setModel(new DefaultComboBoxModel<String>(publicUtilitiesArray));
        publicUtilitiesComboBox.setBounds(29, 225, 536, 21);
        contentPane.add(publicUtilitiesComboBox);

        JButton viewPublicUtilitiesButton = new JButton("View Information");
        viewPublicUtilitiesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String place, name;
                name = publicUtilitiesComboBox.getSelectedItem().toString();
                place = "Public Utilities";
                DisplayPlaces dp = new DisplayPlaces(place, name);
                dp.setVisible(true);
            }
        });
        viewPublicUtilitiesButton.setBounds(28, 269, 128, 21);
        contentPane.add(viewPublicUtilitiesButton);
        
        JLabel hotelLabel = new JLabel("Hotel - Restaurant");
        hotelLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        hotelLabel.setBounds(29, 323, 175, 23);
        hotelLabel.setForeground(Color.RED);
        contentPane.add(hotelLabel);

        List<String> hotelOptions = new ArrayList<String>();
        try {
            File placesFile = new File("places.txt");
            Scanner myReader = new Scanner(placesFile);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if (data.equals("Hotel - Restaurant")) {
                    hotelOptions.add(myReader.nextLine());
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        String[] hotelArray = hotelOptions.toArray(new String[] {});

        JComboBox<String> hotelComboBox = new JComboBox<>();
        hotelComboBox.setModel(new DefaultComboBoxModel<>(hotelArray));
        hotelComboBox.setBounds(29, 366, 536, 21);
        contentPane.add(hotelComboBox);

        JButton viewHotelsButton = new JButton("View Information");
        viewHotelsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String place, name;
                name = hotelComboBox.getSelectedItem().toString();
                place = "Hotel - Restaurant";
                DisplayPlaces dp = new DisplayPlaces(place, name);
                dp.setVisible(true);
            }
        });
        viewHotelsButton.setBounds(29, 410, 128, 21);
        contentPane.add(viewHotelsButton);

        JLabel attractionLabel = new JLabel("Tourist Attraction");
        attractionLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        attractionLabel.setBounds(29, 478, 175, 23);
        attractionLabel.setForeground(Color.RED);
        contentPane.add(attractionLabel);

        List<String> attractionOptions = new ArrayList<String>();
        try {
            File placesFile = new File("places.txt");
            Scanner myReader = new Scanner(placesFile);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if (data.equals("Tourist Attraction")) {
                    attractionOptions.add(myReader.nextLine());
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        String[] attractionArray = attractionOptions.toArray(new String[] {});
        JComboBox<String> attractionComboBox = new JComboBox<>();
        attractionComboBox.setModel(new DefaultComboBoxModel<>(attractionArray));
        attractionComboBox.setBounds(29, 525, 536, 21);
        contentPane.add(attractionComboBox);

        JButton viewAttractionsButton = new JButton("View Information");
        viewAttractionsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String place, name;
                name = attractionComboBox.getSelectedItem().toString();
                place = "Tourist Attraction";
                DisplayPlaces dp = new DisplayPlaces(place, name);
                dp.setVisible(true);
            }
        });
        viewAttractionsButton.setBounds(28, 569, 128, 21);
        contentPane.add(viewAttractionsButton);

        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                dispose();
            }
        });
        closeButton.setBounds(177, 569, 99, 21);
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
