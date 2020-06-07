package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.EventQueue;
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

import service.SearchFileService;
import utilities.Constants;

/**
 * Searching GUI providing the user interface for user to searching files.
 * 
 * @author Anh Tran
 */
public class HomeScreen extends JFrame {

	public static SearchFileService searchFileService = new SearchFileService();

	private JTextField hashTagTxt;
	private JButton searchBtn;
	private JButton openFileBtn;
	private JPanel folderPnl;
	private JScrollPane folderScrl;
	private JList folderLst;
	private JPanel filePnl;
	private JScrollPane fileScrl;
	private JList fileLst;

	private JScrollPane getFolderScrl(String filePath) {
		File[] files = searchFileService.getListOfFileByFolder(filePath);
		folderLst = new JList(files);
		folderLst.setCellRenderer(new FileRenderer(true));
		folderLst.setVisibleRowCount(9);
		return new JScrollPane(folderLst);
	}

	private JScrollPane getFileScrl(String filePath) {
		File[] files = searchFileService.getListOfFileByFolder(filePath);
		fileLst = new JList(files);
		fileLst.setCellRenderer(new FileRenderer(true));
		fileLst.setVisibleRowCount(9);
		return new JScrollPane(fileLst);
	}

	public HomeScreen() {

	}

	public void start() {
		// WE are the tigers, so naturally we want a tiger icon!!!!:)
		setIconImage(new ImageIcon(getClass().getResource("/Icon/Icon.png")).getImage());
		this.setTitle("Searching Files");
		this.setLayout(new BorderLayout());

		JPanel taskbarPanel = new JPanel();

		ImageIcon addFileIcon = new ImageIcon("src\\Icon\\AddFile.png");
		Image img = addFileIcon.getImage();
		Image newimg = img.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		addFileIcon = new ImageIcon(newimg);
		JButton addButton = new JButton(addFileIcon);
		addButton.setBackground(Color.WHITE);
		addButton.setOpaque(true);
		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new AddFileGUI().start();
			}
		});

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

		taskbarPanel.add(addButton);
		taskbarPanel.add(aboutButton);
		taskbarPanel.add(importExportButton);

		JPanel wrapPnl = new JPanel();
		wrapPnl.setLayout(new GridLayout(3, 1));

		JPanel searchPnl = new JPanel();
		searchPnl.setLayout(new FlowLayout(FlowLayout.LEFT));
		hashTagTxt = new JTextField(18);
		searchBtn = new JButton("Search");

		openFileBtn = new JButton("Open file");
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

		searchPnl.add(new JLabel("Key to search:   "));
		searchPnl.add(hashTagTxt);
		searchPnl.add(searchBtn);
		searchPnl.add(openFileBtn);
		
		wrapPnl.add(taskbarPanel);
		wrapPnl.add(new JSeparator());
		wrapPnl.add(searchPnl);
		
		this.add(wrapPnl, BorderLayout.NORTH);

		folderPnl = new JPanel();
		folderScrl = getFolderScrl("FileFolder");
		folderPnl.add(folderLst);

		filePnl = new JPanel();
		filePnl.setLayout(new BorderLayout(1, 1));
		fileScrl = getFileScrl("FileFolder");
		filePnl.add(fileScrl);

		seActionForComponents();

		this.add(folderPnl, BorderLayout.WEST);
		this.add(filePnl, BorderLayout.CENTER);
		this.setSize(700, 500);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void seActionForComponents() {

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

	public static void main(final String[] theArgs) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				new HomeScreen().start();
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
