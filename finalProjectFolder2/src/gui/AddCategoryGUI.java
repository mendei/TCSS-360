package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.Category;
import service.FileModificationService;

public class AddCategoryGUI extends JFrame {

	private FileModificationService fileModifService = new FileModificationService();

	private JTextField categoryTxt;
	private HomeScreen parentFrame;
	/**
	 * @author Anh Tran 
	 * @param frame
	 * This allows us to add a category that already exists. 
	 */
	public AddCategoryGUI(HomeScreen frame) {
		this.parentFrame = frame;
		this.setTitle("Add Category");
		this.setLayout(new BorderLayout());
		this.setIconImage(new ImageIcon(getClass().getResource("/Icon/Icon.png")).getImage());

		JPanel categoryPnl = new JPanel();
		categoryPnl.setBackground(Color.BLACK);
		categoryTxt = new JTextField(15);
		JLabel categoryLbl = new JLabel("Category: ");
		categoryLbl.setForeground(new Color(238,95,12));
		categoryPnl.add(categoryLbl);
		categoryPnl.add(categoryTxt);

		JButton addBtn = new JButton("Add");
		addBtn.setBackground(new Color(238,95,12));
		addBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Category[] category = fileModifService.getCategories();
				for (Category ca : category) {
					if(ca.getCategoryName().equalsIgnoreCase(categoryTxt.getText())) {
						JOptionPane.showMessageDialog(null, "This category is already exists!");
						return;
					}
				}
				fileModifService.addCategory(categoryTxt.getText());
				JOptionPane.showMessageDialog(null, "The category is added successfully!");
				parentFrame.folderPnl.remove(parentFrame.folderLst);
				parentFrame.folderScrl = parentFrame.getFolderScrl("FileFolder");
				parentFrame.folderLst.setBackground(Color.BLACK);
				parentFrame.folderPnl.add(parentFrame.folderLst);
				parentFrame.folderPnl.setBackground(Color.BLACK);
				parentFrame.folderPnl.validate();
				parentFrame.folderPnl.repaint();
				
				
				parentFrame.folderLst.addListSelectionListener(new ListSelectionListener() {
					@Override
					public void valueChanged(ListSelectionEvent e) {
						parentFrame.filePnl.remove(parentFrame.fileScrl);
						parentFrame.fileScrl = parentFrame.getFileScrl(parentFrame.folderLst.getSelectedValue() + "");
						parentFrame.filePnl.add(parentFrame.fileScrl);
						parentFrame.filePnl.validate();
						parentFrame.filePnl.repaint();
					}
				});
				
				parentFrame.folderLst.setSelectedValue(parentFrame.folderLst.getModel().getElementAt(0), true);
			}
		});
		categoryPnl.add(addBtn);

		this.add(categoryPnl, BorderLayout.CENTER);

		this.setSize(170, 70);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}

}
