package GUI;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Database.databaseController;

public class viewMenu extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	Font titlefont = new Font("Serif", Font.BOLD, 30);
	
	JButton backButton = new JButton("Back"); 
	
	public viewMenu(){
		initViewFrame();
	}
	
	private void initViewFrame() {
		setTitle("BobaCool");
		setSize(600,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setResizable(false);
		
		initViewMenuTitle();
		initData();
		initButton();
		
		setLocation(450,150);
		setVisible(true);
	}
	
	private void initViewMenuTitle() {
		JLabel viewMenuTitleLabel = new JLabel("View Data");
		viewMenuTitleLabel.setHorizontalAlignment(JLabel.CENTER);
		viewMenuTitleLabel.setFont(titlefont);
		add(viewMenuTitleLabel, BorderLayout.NORTH);
	}
	
	private void initData() {
		databaseController data = new databaseController();
		Vector<String> columns = new Vector<>();
		
		columns.add("ID");
		columns.add("Nama");
		columns.add("Harga");
		columns.add("Stok");
		
		DefaultTableModel tableModel = new DefaultTableModel(data.getMenuData(), columns) {
			private static final long serialVersionUID = 1L;

		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
			}
		};
		JTable table = new JTable(tableModel);
		table.isCellEditable(0,0);
		JScrollPane sp = new JScrollPane(table);
		add(sp);
	}
	
	private void initButton() {
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(1,1));
		buttonPanel.add(backButton);
		add(buttonPanel, BorderLayout.SOUTH);
		backButton.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(backButton)){
			new mainMenu();
			setVisible(false);
		}
	}
}
