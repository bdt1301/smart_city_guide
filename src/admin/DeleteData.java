package admin;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class DeleteData extends JFrame {
	private int menuWidth = 470;
	private int menuHeight = 496;

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private String[] placeCategories = { "Health Facility", "Tourist Attraction", "Public Utilities",
			"Hotel - Restaurant" };

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteData frame = new DeleteData();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void deleteData(String category, String name) {
		try {
			File file = new File("places.txt");
			Scanner scanner = new Scanner(file);
			String currentLine = scanner.nextLine();
			while (scanner.hasNextLine()) {
				String placeCategory = currentLine;
				String placeName = scanner.nextLine();
				String placeAddress = scanner.nextLine();
				String placeContact = scanner.nextLine();
				String placeAbout = "";
				while (scanner.hasNextLine()) {
					currentLine = scanner.nextLine();
					if (Arrays.asList(placeCategories).contains(currentLine)) {
						break;
					}
					placeAbout += currentLine + "\n";
				}
				if (!(placeCategory.equals(category) && placeName.equals(name))) {
					try {
						FileWriter writer = new FileWriter("temp.txt", true);
						writer.write(placeCategory + "\n" + placeName + "\n" + placeAddress + "\n" + placeContact + "\n"
								+ placeAbout);
						writer.close();
						System.out.println("Successfully wrote to the file.");
					} catch (IOException e) {
						System.out.println("An error occurred.");
						e.printStackTrace();
					}
				}
			}
			scanner.close();
			File originalFile = new File("places.txt");
			File newFile = new File("temp.txt");
			originalFile.delete();
			newFile.renameTo(originalFile);
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	public DeleteData() {
		setTitle("Delete Data");

		List<String> healthFacilitiesList = new ArrayList<String>();
		try {
			File file = new File("places.txt");
			Scanner scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				String data = scanner.nextLine();
				if (data.equals("Health Facility")) {
					healthFacilitiesList.add(scanner.nextLine());
				}
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		String[] healthFacilitiesArray = healthFacilitiesList.toArray(new String[] {});

		List<String> publicUtilitiesList = new ArrayList<String>();
		try {
			File file = new File("places.txt");
			Scanner scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				String data = scanner.nextLine();
				if (data.equals("Public Utilities")) {
					publicUtilitiesList.add(scanner.nextLine());
				}
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		String[] publicUtilitiesArray = publicUtilitiesList.toArray(new String[] {});

		List<String> touristAttractionsList = new ArrayList<String>();
		try {
			File file = new File("places.txt");
			Scanner scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				String data = scanner.nextLine();
				if (data.equals("Tourist Attraction")) {
					touristAttractionsList.add(scanner.nextLine());
				}
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		String[] touristAttractionsArray = touristAttractionsList.toArray(new String[] {});

		List<String> hotelRestaurantsList = new ArrayList<String>();
		try {
			File file = new File("places.txt");
			Scanner scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				String data = scanner.nextLine();
				if (data.equals("Hotel - Restaurant")) {
					hotelRestaurantsList.add(scanner.nextLine());
				}
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		String[] hotelRestaurantsArray = hotelRestaurantsList.toArray(new String[] {});

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 427, 476);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel healthFacilityLabel = new JLabel("Health Facility");
		healthFacilityLabel.setBounds(24, 22, 80, 13);
		contentPane.add(healthFacilityLabel);

		JComboBox<String> healthFacilityComboBox = new JComboBox<>();
		healthFacilityComboBox.setModel(new DefaultComboBoxModel<String>(healthFacilitiesArray));
		healthFacilityComboBox.setBounds(24, 45, 356, 21);
		contentPane.add(healthFacilityComboBox);

		JButton healthFacilityDeleteButton = new JButton("Delete");
		healthFacilityDeleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				deleteData("Health Facility", healthFacilityComboBox.getSelectedItem().toString());
			}
		});
		healthFacilityDeleteButton.setBounds(24, 76, 85, 21);
		contentPane.add(healthFacilityDeleteButton);

		JLabel publicUtilitiesLabel = new JLabel("Public Utilities");
		publicUtilitiesLabel.setBounds(24, 121, 90, 13);
		contentPane.add(publicUtilitiesLabel);

		JComboBox<String> publicUtilitiesComboBox = new JComboBox<>();
		publicUtilitiesComboBox.setModel(new DefaultComboBoxModel<String>(publicUtilitiesArray));
		publicUtilitiesComboBox.setBounds(24, 144, 349, 21);
		contentPane.add(publicUtilitiesComboBox);

		JButton publicUtilitiesDeleteButton = new JButton("Delete");
		publicUtilitiesDeleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				deleteData("Public Utilities", publicUtilitiesComboBox.getSelectedItem().toString());
			}
		});
		publicUtilitiesDeleteButton.setBounds(24, 175, 85, 21);
		contentPane.add(publicUtilitiesDeleteButton);

		JLabel touristAttractionLabel = new JLabel("Tourist Attractions");
		touristAttractionLabel.setBounds(24, 219, 105, 13);
		contentPane.add(touristAttractionLabel);

		JComboBox<String> touristAttractionComboBox = new JComboBox<>();
		touristAttractionComboBox.setModel(new DefaultComboBoxModel<String>(touristAttractionsArray));
		touristAttractionComboBox.setBounds(24, 242, 349, 21);
		contentPane.add(touristAttractionComboBox);

		JButton touristAttractionDeleteButton = new JButton("Delete");
		touristAttractionDeleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				deleteData("Tourist Attraction", touristAttractionComboBox.getSelectedItem().toString());
			}
		});
		touristAttractionDeleteButton.setBounds(24, 273, 85, 21);
		contentPane.add(touristAttractionDeleteButton);

		JLabel hotelRestaurantLabel = new JLabel("Hotel - Restaurant");
		hotelRestaurantLabel.setBounds(24, 317, 120, 13);
		contentPane.add(hotelRestaurantLabel);

		JComboBox<String> hotelRestaurantComboBox = new JComboBox<>();
		hotelRestaurantComboBox.setModel(new DefaultComboBoxModel<String>(hotelRestaurantsArray));
		hotelRestaurantComboBox.setBounds(24, 340, 349, 21);
		contentPane.add(hotelRestaurantComboBox);

		JButton hotelRestaurantDeleteButton = new JButton("Delete");
		hotelRestaurantDeleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				deleteData("Hotel - Restaurant", hotelRestaurantComboBox.getSelectedItem().toString());
			}
		});
		hotelRestaurantDeleteButton.setBounds(24, 371, 85, 21);
		contentPane.add(hotelRestaurantDeleteButton);

		JButton closeButton = new JButton("Close");
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		closeButton.setBounds(119, 371, 83, 21);
		contentPane.add(closeButton);

		JLabel backgroundLabel = new JLabel();
		ImageIcon icon = new ImageIcon("img/data.jpg");
		Image image = icon.getImage().getScaledInstance(menuWidth, menuHeight, Image.SCALE_SMOOTH);
		backgroundLabel.setIcon(new ImageIcon(image));
		backgroundLabel.setBounds(0, 0, menuWidth, menuHeight);
		contentPane.add(backgroundLabel);

		contentPane.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				int newWidth = contentPane.getWidth();
				int newHeight = contentPane.getHeight();
				Image scaledImage = icon.getImage().getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
				backgroundLabel.setIcon(new ImageIcon(scaledImage));
				backgroundLabel.setBounds(0, 0, newWidth, newHeight);
			}
		});
	}
}
