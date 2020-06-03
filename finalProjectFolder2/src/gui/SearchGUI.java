package gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileSystemView;

import service.SearchFileService;
import utilities.Constants;

public class SearchGUI extends JFrame {
	
	public static SearchFileService searchFileService = new SearchFileService();
	
	private JTextField hashTagTxt;
	private JButton searchBtn;
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

	public SearchGUI() {

	}

	public void start() {
		this.setTitle("Searching Files");
		this.setLayout(new BorderLayout());
		JPanel searchPnl = new JPanel();

		hashTagTxt = new JTextField(18);
		searchBtn = new JButton("Search");
		searchPnl.add(new JLabel("Key to search: "));
		searchPnl.add(hashTagTxt);
		searchPnl.add(searchBtn);
		this.add(searchPnl, BorderLayout.NORTH);

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
		this.pack();
		this.setLocationByPlatform(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

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
				new SearchGUI().start();
			}
		});
	}

}

class TextFileFilter implements FileFilter {

	public boolean accept(File file) {
		// implement the logic to select files here..
		String name = file.getName().toLowerCase();
		// return name.endsWith(".java") || name.endsWith(".class");
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