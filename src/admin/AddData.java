package admin;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

class College {
	String name;
	String about;
	String contactInfo;
	String address;

	public College() {

	}

	public College(String name, String about, String contactInfo, String address) {
		this.name = name;
		this.about = about;
		this.contactInfo = contactInfo;
		this.address = address;
	}
}

class TouristAttraction {
	String name;
	String about;
	String contactInfo;
	String address;

	public TouristAttraction() {

	}

	public TouristAttraction(String name, String about, String contactInfo, String address) {
		this.name = name;
		this.about = about;
		this.contactInfo = contactInfo;
		this.address = address;
	}
}

class Library {
	String name;
	String about;
	String contactInfo;
	String address;

	public Library() {

	}

	public Library(String name, String about, String contactInfo, String address) {
		this.name = name;
		this.about = about;
		this.contactInfo = contactInfo;
		this.address = address;
	}
}

class Hotel {
	String name;
	String about;
	String contactInfo;
	String address;

	public Hotel() {

	}

	public Hotel(String name, String about, String contactInfo, String address) {
		this.name = name;
		this.about = about;
		this.contactInfo = contactInfo;
		this.address = address;
	}
}

public class AddData extends JFrame {
	private int widthMenu = 470;
	private int heightMenu = 496;

	private static final long serialVersionUID = 1L;

	public ArrayList<Hotel> hotels = new ArrayList<Hotel>();
	public ArrayList<Library> libraries = new ArrayList<Library>();
	public ArrayList<TouristAttraction> touristAttractions = new ArrayList<TouristAttraction>();
	public ArrayList<College> colleges = new ArrayList<College>();

	private JPanel contentPane;
	private JTextField nameTextField;
	private JTextField contactInfoTextField;

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {

				try {
					AddData frame = new AddData();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	public AddData() {
		setTitle("AddData");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 470, 496);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel nameLabel = new JLabel("Name");
		nameLabel.setBounds(46, 41, 45, 13);
		contentPane.add(nameLabel);

		nameTextField = new JTextField();
		nameTextField.setColumns(10);
		nameTextField.setBounds(139, 38, 271, 19);
		contentPane.add(nameTextField);

		JLabel addressLabel = new JLabel("Address");
		addressLabel.setBounds(46, 69, 50, 13);
		contentPane.add(addressLabel);

		JTextArea addressTextArea = new JTextArea();
		addressTextArea.setWrapStyleWord(true);
		addressTextArea.setLineWrap(true);
		JScrollPane addressScrollPane = new JScrollPane(addressTextArea);
		addressScrollPane.setBounds(46, 90, 364, 36);
		contentPane.add(addressScrollPane);

		JLabel contactInfoLabel = new JLabel("Contact Info");
		contactInfoLabel.setBounds(46, 146, 79, 13);
		contentPane.add(contactInfoLabel);

		contactInfoTextField = new JTextField();
		contactInfoTextField.setColumns(10);
		contactInfoTextField.setBounds(139, 143, 271, 19);
		contentPane.add(contactInfoTextField);

		JLabel aboutLabel = new JLabel("About");
		aboutLabel.setBounds(46, 183, 65, 13);
		contentPane.add(aboutLabel);

		JTextArea aboutTextArea = new JTextArea();
		aboutTextArea.setWrapStyleWord(true);
		aboutTextArea.setLineWrap(true);
		JScrollPane aboutScrollPane = new JScrollPane(aboutTextArea);
		aboutScrollPane.setBounds(46, 205, 364, 148);
		contentPane.add(aboutScrollPane);

		JComboBox<String> placeComboBox = new JComboBox<>();
		placeComboBox.setModel(
				new DefaultComboBoxModel<>(new String[] { "College", "Tourist Attraction", "Library", "Hotel" }));
		placeComboBox.setBounds(46, 7, 136, 21);
		contentPane.add(placeComboBox);

		JButton addDataButton = new JButton("Add Data");
		addDataButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String place;
				String name, about, contact, address;
				about = aboutTextArea.getText();
				contact = contactInfoTextField.getText();

				name = nameTextField.getText();
				address = addressTextArea.getText();
				place = placeComboBox.getSelectedItem().toString();
				if (address.length() > 100) {
					JOptionPane.showMessageDialog(null, "Address should not exceed 100 characters!");
				} else if (about.equals("") || contact.equals("") || name.equals("") || address.equals("")) {
					JOptionPane.showMessageDialog(null, "Invalid Input!");
				} else {
					try {
						FileWriter myWriter = new FileWriter("places.txt", true);
						myWriter.write(place + "\n" + name + "\n" + about + "\n" + contact + "\n" + address + "\n");
						myWriter.close();
						System.out.println("Successfully wrote to the file.");
					} catch (IOException e) {
						System.out.println("An error occurred.");
						e.printStackTrace();
					}

					if (place.equals("College")) {
						College coll = new College(name, about, contact, address);
						colleges.add(coll);
						JOptionPane.showMessageDialog(null, "College Added!");
					}
					if (place.equals("Tourist Attraction")) {
						TouristAttraction coll = new TouristAttraction(name, about, contact, address);
						touristAttractions.add(coll);
						JOptionPane.showMessageDialog(null, "Tourist Attraction Added!");
					}
					if (place.equals("Library")) {
						Library coll = new Library(name, about, contact, address);
						libraries.add(coll);
						JOptionPane.showMessageDialog(null, "Library Added!");
					}
					if (place.equals("Hotel")) {
						Hotel coll = new Hotel(name, about, contact, address);
						hotels.add(coll);
						JOptionPane.showMessageDialog(null, "Hotel Added!");
					}
				}
			}
		});
		addDataButton.setBounds(46, 381, 85, 21);
		contentPane.add(addDataButton);

		JButton closeButton = new JButton("Close");
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		closeButton.setBounds(146, 381, 79, 19);
		contentPane.add(closeButton);

		JLabel background = new JLabel();
		ImageIcon icon = new ImageIcon("img/data.jpg");
		Image image = icon.getImage().getScaledInstance(widthMenu, heightMenu, Image.SCALE_SMOOTH);
		background.setIcon(new ImageIcon(image));
		background.setBounds(0, 0, widthMenu, heightMenu);
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
