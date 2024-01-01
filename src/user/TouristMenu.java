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

public class TouristMenu extends JFrame {
    private int menuWidth = 720;
    private int menuHeight = 540;

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TouristMenu menuFrame = new TouristMenu();
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
    public TouristMenu() {        
        setTitle("TouristMenu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, menuWidth, menuHeight);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel hotelLabel = new JLabel("View Hotels");
        hotelLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        hotelLabel.setBounds(29, 23, 175, 23);
        hotelLabel.setForeground(Color.RED);
        contentPane.add(hotelLabel);

        List<String> hotelList = new ArrayList<String>();
        try {
            File placesFile = new File("places.txt");
            Scanner myReader = new Scanner(placesFile);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if (data.equals("Hotel")) {
                    hotelList.add(myReader.nextLine());
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        String[] hotelArray = hotelList.toArray(new String[] {});

        JComboBox<String> hotelComboBox = new JComboBox<>();
        hotelComboBox.setModel(new DefaultComboBoxModel<>(hotelArray));
        hotelComboBox.setBounds(29, 66, 536, 21);
        contentPane.add(hotelComboBox);

        JButton viewHotelsButton = new JButton("View Hotels");
        viewHotelsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String place, name;
                name = hotelComboBox.getSelectedItem().toString();
                place = "Hotel";
                DisplayPlaces dp = new DisplayPlaces(place, name);
                dp.setVisible(true);
            }
        });
        viewHotelsButton.setBounds(29, 110, 123, 21);
        contentPane.add(viewHotelsButton);

        JLabel attractionLabel = new JLabel("View Attractions");
        attractionLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        attractionLabel.setBounds(29, 178, 175, 23);
        attractionLabel.setForeground(Color.RED);
        contentPane.add(attractionLabel);

        List<String> attractionList = new ArrayList<String>();
        try {
            File placesFile = new File("places.txt");
            Scanner myReader = new Scanner(placesFile);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if (data.equals("Tourist Attraction")) {
                    attractionList.add(myReader.nextLine());
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        String[] attractionArray = attractionList.toArray(new String[] {});
        JComboBox<String> attractionComboBox = new JComboBox<>();
        attractionComboBox.setModel(new DefaultComboBoxModel<>(attractionArray));
        attractionComboBox.setBounds(29, 225, 536, 21);
        contentPane.add(attractionComboBox);

        JButton viewAttractionsButton = new JButton("View Attractions");
        viewAttractionsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String place, name;
                name = attractionComboBox.getSelectedItem().toString();
                place = "Tourist Attraction";
                DisplayPlaces dp = new DisplayPlaces(place, name);
                dp.setVisible(true);
            }
        });
        viewAttractionsButton.setBounds(28, 269, 124, 21);
        contentPane.add(viewAttractionsButton);

        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                dispose();
            }
        });
        closeButton.setBounds(177, 269, 99, 21);
        contentPane.add(closeButton);

        JLabel imageLabel = new JLabel();
        ImageIcon icon = new ImageIcon("img/tourist.jpg");
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
