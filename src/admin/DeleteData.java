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
import java.util.List;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class DeleteData extends JFrame {
	private int menuWidth = 470;
	private int menuHeight = 496;

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
	public DeleteData() {
		setTitle("Delete Data");

		List<String> colleges = new ArrayList<String>();
		try {
			File myObj = new File("places.txt");
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				if (data.equals("College")) {
					colleges.add(myReader.nextLine());
				}
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		String[] collegeArray = colleges.toArray(new String[] {});

		List<String> libraries = new ArrayList<String>();
		try {
			File myObj = new File("places.txt");
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				if (data.equals("Library")) {
					libraries.add(myReader.nextLine());
				}
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		String[] libraryArray = libraries.toArray(new String[] {});

		List<String> attractions = new ArrayList<String>();
		try {
			File myObj = new File("places.txt");
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				if (data.equals("Tourist Attraction")) {
					attractions.add(myReader.nextLine());
				}
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		String[] attractionArray = attractions.toArray(new String[] {});

		List<String> hotels = new ArrayList<String>();
		try {
			File myObj = new File("places.txt");
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				if (data.equals("Hotel")) {
					hotels.add(myReader.nextLine());
				}
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		String[] hotelArray = hotels.toArray(new String[] {});

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 427, 476);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel collegeLabel = new JLabel("College");
		collegeLabel.setBounds(24, 22, 65, 13);
		contentPane.add(collegeLabel);

		JComboBox<String> collegeComboBox = new JComboBox<>();
		collegeComboBox.setModel(new DefaultComboBoxModel<String>(collegeArray));
		collegeComboBox.setBounds(24, 45, 356, 21);
		contentPane.add(collegeComboBox);

		JButton collegeDeleteButton = new JButton("Delete");
		collegeDeleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String name = collegeComboBox.getSelectedItem().toString();
					String place = "College";
					File myObj = new File("places.txt");
					Scanner myReader = new Scanner(myObj);
					while (myReader.hasNextLine()) {
						String plc = myReader.nextLine();
						String nm = myReader.nextLine();
						String abt = myReader.nextLine();
						String ctc = myReader.nextLine();
						String addr = myReader.nextLine();
						if (!(plc.equals(place) && name.equals(nm))) {
							try {
								FileWriter myWriter = new FileWriter("places2.txt", true);
								myWriter.write(plc + "\n" + nm + "\n" + abt + "\n" + ctc + "\n" + addr + "\n");
								myWriter.close();
								System.out.println("Successfully wrote to the file.");
							} catch (IOException e) {
								System.out.println("An error occurred.");
								e.printStackTrace();
							}
						}
					}
					myReader.close();
					File originalFile = new File("places.txt");
					File newFile = new File("places2.txt");
					originalFile.delete();
					newFile.renameTo(originalFile);
				} catch (FileNotFoundException e) {
					System.out.println("An error occurred.");
					e.printStackTrace();
				}
			}
		});
		collegeDeleteButton.setBounds(24, 76, 85, 21);
		contentPane.add(collegeDeleteButton);

		JLabel libraryLabel = new JLabel("Library");
		libraryLabel.setBounds(24, 121, 45, 13);
		contentPane.add(libraryLabel);

		JComboBox<String> libraryComboBox = new JComboBox<>();
		libraryComboBox.setModel(new DefaultComboBoxModel<String>(libraryArray));
		libraryComboBox.setBounds(24, 144, 349, 21);
		contentPane.add(libraryComboBox);

		JButton libraryDeleteButton = new JButton("Delete");
		libraryDeleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String name = libraryComboBox.getSelectedItem().toString();
					String place = "Library";
					File myObj = new File("places.txt");
					Scanner myReader = new Scanner(myObj);
					while (myReader.hasNextLine()) {
						String plc = myReader.nextLine();
						String nm = myReader.nextLine();
						String abt = myReader.nextLine();
						String ctc = myReader.nextLine();
						String addr = myReader.nextLine();
						if (!(plc.equals(place) && name.equals(nm))) {
							try {
								FileWriter myWriter = new FileWriter("places2.txt", true);
								myWriter.write(plc + "\n" + nm + "\n" + abt + "\n" + ctc + "\n" + addr + "\n");
								myWriter.close();
								System.out.println("Successfully wrote to the file.");
							} catch (IOException e) {
								System.out.println("An error occurred.");
								e.printStackTrace();
							}
						}
					}
					myReader.close();
					File originalFile = new File("places.txt");
					File newFile = new File("places2.txt");
					originalFile.delete();
					newFile.renameTo(originalFile);
				} catch (FileNotFoundException e) {
					System.out.println("An error occurred.");
					e.printStackTrace();
				}
			}
		});
		libraryDeleteButton.setBounds(24, 175, 85, 21);
		contentPane.add(libraryDeleteButton);

		JLabel attractionLabel = new JLabel("Tourist Attractions");
		attractionLabel.setBounds(24, 219, 105, 13);
		contentPane.add(attractionLabel);

		JComboBox<String> attractionComboBox = new JComboBox<>();
		attractionComboBox.setModel(new DefaultComboBoxModel<String>(attractionArray));
		attractionComboBox.setBounds(24, 242, 349, 21);
		contentPane.add(attractionComboBox);

		JButton attractionDeleteButton = new JButton("Delete");
		attractionDeleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String name = attractionComboBox.getSelectedItem().toString();
					String place = "Tourist Attraction";
					File myObj = new File("places.txt");
					Scanner myReader = new Scanner(myObj);
					while (myReader.hasNextLine()) {
						String plc = myReader.nextLine();
						String nm = myReader.nextLine();
						String abt = myReader.nextLine();
						String ctc = myReader.nextLine();
						String addr = myReader.nextLine();
						if (!(plc.equals(place) && name.equals(nm))) {
							try {
								FileWriter myWriter = new FileWriter("places2.txt", true);
								myWriter.write(plc + "\n" + nm + "\n" + abt + "\n" + ctc + "\n" + addr + "\n");
								myWriter.close();
								System.out.println("Successfully wrote to the file.");
							} catch (IOException e) {
								System.out.println("An error occurred.");
								e.printStackTrace();
							}
						}
					}
					myReader.close();
					File originalFile = new File("places.txt");
					File newFile = new File("places2.txt");
					originalFile.delete();
					newFile.renameTo(originalFile);
				} catch (FileNotFoundException e) {
					System.out.println("An error occurred.");
					e.printStackTrace();
				}
			}
		});
		attractionDeleteButton.setBounds(24, 273, 85, 21);
		contentPane.add(attractionDeleteButton);

		JLabel hotelLabel = new JLabel("Hotels");
		hotelLabel.setBounds(24, 317, 45, 13);
		contentPane.add(hotelLabel);

		JComboBox<String> hotelComboBox = new JComboBox<>();
		hotelComboBox.setModel(new DefaultComboBoxModel<String>(hotelArray));
		hotelComboBox.setBounds(24, 340, 349, 21);
		contentPane.add(hotelComboBox);

		JButton hotelDeleteButton = new JButton("Delete");
		hotelDeleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String name = hotelComboBox.getSelectedItem().toString();
					String place = "Hotel";
					File myObj = new File("places.txt");
					Scanner myReader = new Scanner(myObj);
					while (myReader.hasNextLine()) {
						String plc = myReader.nextLine();
						String nm = myReader.nextLine();
						String abt = myReader.nextLine();
						String ctc = myReader.nextLine();
						String addr = myReader.nextLine();
						if (!(plc.equals(place) && name.equals(nm))) {
							try {
								FileWriter myWriter = new FileWriter("places2.txt", true);
								myWriter.write(plc + "\n" + nm + "\n" + abt + "\n" + ctc + "\n" + addr + "\n");
								myWriter.close();
								System.out.println("Successfully wrote to the file.");
							} catch (IOException e) {
								System.out.println("An error occurred.");
								e.printStackTrace();
							}
						}
					}
					myReader.close();
					File originalFile = new File("places.txt");
					File newFile = new File("places2.txt");
					originalFile.delete();
					newFile.renameTo(originalFile);
				} catch (FileNotFoundException e) {
					System.out.println("An error occurred.");
					e.printStackTrace();
				}
			}
		});
		hotelDeleteButton.setBounds(24, 371, 85, 21);
		contentPane.add(hotelDeleteButton);

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