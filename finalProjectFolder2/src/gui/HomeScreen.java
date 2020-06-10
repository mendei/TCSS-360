package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListCellRenderer;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileSystemView;

import model.UserProfile;
import service.SearchFileService;
import utilities.Constants;

/**
 * Searching GUI providing the user interface for user to searching files.
 * 
 * @author Anh Tran
 * @author Austin Tiger them Color Effects and Log out Button. 
 * @author Ivan Mendez , HomeScreen shell
 */
public class HomeScreen extends JFrame implements ActionListener {

	public static SearchFileService searchFileService = new SearchFileService();

	private UserProfile user;
	private JTextField hashTagTxt;
	private JButton searchBtn;
	private JButton openFileBtn;
	private JButton categoryBtn;
	public JPanel folderPnl;
	public JScrollPane folderScrl;
	public JList folderLst;
	public JPanel filePnl;
	public JScrollPane fileScrl;
	public JList fileLst;

	public JScrollPane getFolderScrl(String filePath) {
		File[] files = searchFileService.getListOfFileByFolder(filePath);
		folderLst = new JList(files);
		folderLst.setCellRenderer(new FileRenderer(true));
		folderLst.setVisibleRowCount(9);
		folderLst.setForeground(new Color(238, 95, 12));
		return new JScrollPane(folderLst);
	}

	public JScrollPane getFileScrl(String filePath) {
		File[] files = searchFileService.getListOfFileByFolder(filePath);
		fileLst = new JList(files);
		fileLst.setCellRenderer(new FileRenderer(true));
		fileLst.setVisibleRowCount(9);
		return new JScrollPane(fileLst);
	}

	public HomeScreen(UserProfile user) {
		this.user = user;
	}

	public void start() {
		// WE are the tigers, so naturally we want a tiger icon!!!!:)
		setIconImage(new ImageIcon(getClass().getResource("/Icon/Icon.png")).getImage());
		this.setTitle("Home Screen");
		this.setLayout(new BorderLayout());
		this.setBackground(Color.GREEN);

		JPanel taskbarPanel = new JPanel();
		taskbarPanel.setBackground(Color.DARK_GRAY);

		ImageIcon addFileIcon = new ImageIcon("src\\Icon\\AddFile.png");
		Image img = addFileIcon.getImage();
		Image newimg = img.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		addFileIcon = new ImageIcon(newimg);
		JButton addButton = new JButton(addFileIcon);
		addButton.setName("AddFile");
		addButton.setBackground(Color.WHITE);
		addButton.setOpaque(true);
		addButton.addActionListener(this);

		ImageIcon categoryIcon = new ImageIcon("src\\Icon\\AddCategory.png");
		img = categoryIcon.getImage();
		newimg = img.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		categoryIcon = new ImageIcon(newimg);
		categoryBtn = new JButton(categoryIcon);
		categoryBtn.setName("AddCategory");
		categoryBtn.setBackground(Color.WHITE);
		categoryBtn.setOpaque(true);
		categoryBtn.addActionListener(this);

		ImageIcon aboutIcon = new ImageIcon("src\\Icon\\AboutIcon.png");
		img = aboutIcon.getImage();
		newimg = img.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		aboutIcon = new ImageIcon(newimg);
		JButton aboutButton = new JButton(aboutIcon);
		aboutButton.setBackground(Color.WHITE);
		aboutButton.setOpaque(true);
		aboutButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new AboutScreenGUI().start();
			}
		});

		ImageIcon importExportIcon = new ImageIcon("src\\Icon\\ImportExportIcon.jpg");
		img = importExportIcon.getImage();
		newimg = img.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		importExportIcon = new ImageIcon(newimg);
		JButton importExportButton = new JButton(importExportIcon);
		importExportButton.setBackground(Color.WHITE);
		importExportButton.setOpaque(true);
		importExportButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ImportExportGUI().start();
			}
		});
		/**
		 * @author Austin Scott Creates a user profile button that is only for logging
		 *         out.
		 */
		ImageIcon userIcon = new ImageIcon("src\\Icon\\userIcon.png");
		img = userIcon.getImage();
		newimg = img.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		userIcon = new ImageIcon(newimg);
		JButton userBtn = new JButton(userIcon);
		userBtn.setBackground(Color.WHITE);
		userBtn.setOpaque(true);
		userBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "Would you like to Logout?", "Logout Pane",
						JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (result == JOptionPane.YES_OPTION) {
					dispose();
					new LoginGUI();
				} else {
					JOptionPane.showMessageDialog(null, "User will not be logged out.");
				}

			}
		});

		if (user.getUserName().equals("admin")) {
			taskbarPanel.add(categoryBtn);
			taskbarPanel.add(addButton);
		}

		taskbarPanel.add(aboutButton);
		taskbarPanel.add(importExportButton);
		taskbarPanel.add(userBtn);

		JPanel wrapPnl = new JPanel();
		wrapPnl.setLayout(new GridLayout(3, 1));
		wrapPnl.setBackground(Color.DARK_GRAY);

		JPanel searchPnl = new JPanel();
		searchPnl.setBackground(Color.DARK_GRAY);
		searchPnl.setLayout(new FlowLayout(FlowLayout.LEFT));
		hashTagTxt = new JTextField(18);
		searchBtn = new JButton("Search");
		searchBtn.setBackground(new Color(238, 95, 12));

		openFileBtn = new JButton("Open file");
		openFileBtn.setBackground(new Color(238, 95, 12));
		openFileBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (fileLst.getSelectedValue() == null) {
					JOptionPane.showMessageDialog(null, "Please choose the file to be opened");
					return;
				}
				Desktop desktop = Desktop.getDesktop();
				File file = new File(fileLst.getSelectedValue() + "");
				try {
					desktop.open(file);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "There is error, can not open file");
				}
			}
		});

		JButton deleteBtn = new JButton("Delete File");
		deleteBtn.setBackground(new Color(238, 95, 12));
		deleteBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (fileLst.getSelectedValue() == null) {
					JOptionPane.showMessageDialog(null, "Please select file to delete!");
					return;
				}
				File file = new File(fileLst.getSelectedValue() + "");
				file.delete();
				JOptionPane.showMessageDialog(null, "Delete Sucessfully!");
				filePnl.remove(fileScrl);
				fileScrl = getFileScrl(folderLst.getSelectedValue() + "");
				filePnl.add(fileScrl);
				filePnl.validate();
				filePnl.repaint();
			}
		});

		JButton deleteFolder = new JButton("Delete Folder");
		deleteFolder.setBackground(new Color(238, 95, 12));
		deleteFolder.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (folderLst.getSelectedValue() == null) {
					JOptionPane.showMessageDialog(null, "Please select folder to delete!");
					return;
				}
				File file = new File(folderLst.getSelectedValue() + "");
				for (File f : file.listFiles()) {
					f.delete();
				}
				file.delete();
				JOptionPane.showMessageDialog(null, "Delete Sucessfully!");
				folderPnl.remove(folderLst);
				folderScrl = getFolderScrl("FileFolder");
				folderLst.setBackground(Color.BLACK);
				folderPnl.add(folderLst);
				folderPnl.setBackground(Color.BLACK);
				folderPnl.validate();
				folderPnl.repaint();
				folderLst.addListSelectionListener(new ListSelectionListener() {
					@Override
					public void valueChanged(ListSelectionEvent e) {
						filePnl.remove(fileScrl);
						fileScrl = getFileScrl(folderLst.getSelectedValue() + "");
						filePnl.add(fileScrl);
						filePnl.validate();
						filePnl.repaint();
					}
				});
				filePnl.remove(fileScrl);
				fileScrl = new JScrollPane();
				filePnl.add(fileScrl);
				filePnl.validate();
				filePnl.repaint();
			}
		});
		JLabel searchLbl = new JLabel("Key to search:   ");
		searchLbl.setForeground(new Color(238, 95, 12));
		searchPnl.add(searchLbl);
		searchPnl.add(hashTagTxt);
		searchPnl.add(searchBtn);
		searchPnl.add(openFileBtn);

		if (user.getUserName().equals("admin")) {
			searchPnl.add(deleteBtn);
			searchPnl.add(deleteFolder);
		}

		wrapPnl.add(taskbarPanel);
		wrapPnl.add(new JSeparator()).setBackground(new Color(238, 95, 12));
		;
		wrapPnl.add(searchPnl);

		this.add(wrapPnl, BorderLayout.NORTH);

		folderPnl = new JPanel();
		folderScrl = getFolderScrl("FileFolder");
		folderLst.setBackground(Color.BLACK);
		folderPnl.add(folderLst);
		folderPnl.setBackground(Color.BLACK);

		filePnl = new JPanel();
		filePnl.setBackground(new Color(238, 95, 12));
		filePnl.setLayout(new BorderLayout(1, 1));
		fileScrl = getFileScrl("FileFolder");
		filePnl.add(fileScrl);

		setActionForComponents();

		this.add(folderPnl, BorderLayout.WEST);
		this.add(filePnl, BorderLayout.CENTER);
		this.setSize(700, 500);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		if (btn.getName().equals("AddCategory")) {
			new AddCategoryGUI(this);
		}
		if (btn.getName().equals("AddFile")) {
			new AddFileGUI(this).start();
		}

	}

	private void setActionForComponents() {

		folderLst.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				filePnl.remove(fileScrl);
				fileScrl = getFileScrl(folderLst.getSelectedValue() + "");
				filePnl.add(fileScrl);
				filePnl.validate();
				filePnl.repaint();
			}
		});

		folderLst.setSelectedValue(folderLst.getModel().getElementAt(0), true);

		searchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String hashTag = hashTagTxt.getText();
				if (!hashTag.trim().equalsIgnoreCase("")) {
					File[] files = searchFileService.getListOfFileByFolder(Constants.ROOT_PATH_OF_FILE);
					List<File> listOfFile = new ArrayList<>();
					for (File f : files) {
						if (f.getName().toLowerCase().contains(hashTag.toLowerCase())) {
							for (File subFile : f.listFiles()) {
								listOfFile.add(subFile);
							}
						} else {
							for (File subFile : f.listFiles()) {
								if (subFile.getName().toLowerCase().contains(hashTag.toLowerCase()))
									listOfFile.add(subFile);
							}
						}
					}
					fileLst = new JList(listOfFile.toArray());
					fileLst.setCellRenderer(new FileRenderer(true));
					fileLst.setVisibleRowCount(9);
					filePnl.remove(fileScrl);
					fileScrl = new JScrollPane(fileLst);
					filePnl.add(fileScrl);
					filePnl.validate();
					filePnl.repaint();
				}
			}
		});

	}

}

class TextFileFilter implements FileFilter {

	public boolean accept(File file) {
		String name = file.getName().toLowerCase();
		return name.length() < 20;
	}
}

class FileRenderer extends DefaultListCellRenderer {

	private boolean pad;
	private Border padBorder = new EmptyBorder(3, 3, 3, 3);

	FileRenderer(boolean pad) {
		this.pad = pad;
	}

	@Override
	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
			boolean cellHasFocus) {

		Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
		JLabel l = (JLabel) c;
		File f = (File) value;
		l.setText(f.getName());
		l.setIcon(FileSystemView.getFileSystemView().getSystemIcon(f));
		if (pad) {
			l.setBorder(padBorder);
		}
		return l;
	}
}
