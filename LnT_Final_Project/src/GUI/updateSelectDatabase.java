package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Database.databaseController;

public class updateSelectDatabase extends JFrame implements ActionListener, MouseListener{
	
	private static final long serialVersionUID = 1L;

	Font titlefont = new Font("Serif", Font.BOLD, 30);
	
	private JButton cancelButton = new JButton("Cancel");
	private JButton updateButton = new JButton("Update");
	
	JTable table;
	String code ="";
	String menu ="";
	String harga ="";
	String stok ="";
	
	public updateSelectDatabase() {
		updateSelectDatabaseFrame();
	}
	
	private void updateSelectDatabaseFrame() {
		setTitle("BobaCool");
		setSize(600,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setResizable(false);
		
		updateSelectDatabaseTitle();
		initData();
		updateSelectDatabaseComponent();
		
		setLocation(450,150);
		setVisible(true);
	}
	
	private void updateSelectDatabaseTitle() {
		JLabel updateSelectDatabaseMenuTittleLabel = new JLabel("Update Menu");
		updateSelectDatabaseMenuTittleLabel.setHorizontalAlignment(JLabel.CENTER);
		updateSelectDatabaseMenuTittleLabel.setFont(titlefont);
		add(updateSelectDatabaseMenuTittleLabel, BorderLayout.NORTH);
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
		table = new JTable(tableModel);
		table.isCellEditable(0,0);
		table.addMouseListener(this);
		JScrollPane sp = new JScrollPane(table);
		add(sp);
	}
	
	private void updateSelectDatabaseComponent() {
		JPanel deleteButtonPanel = new JPanel();
		deleteButtonPanel.setLayout(new GridLayout(1,2));
		
		deleteButtonPanel.add(cancelButton);
		deleteButtonPanel.add(updateButton);
		
		cancelButton.addActionListener(this);
		updateButton.addActionListener(this);
		
		add(deleteButtonPanel, BorderLayout.SOUTH);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(updateButton)) {
			if(code.equals("")) {
				JOptionPane.showMessageDialog(null, "Pilih menu yang akan di-update ");
			}
			else {
				updateSubmitProgress nextStep = new updateSubmitProgress();
				nextStep.initForm(code, menu, harga, stok);
				setVisible(false);
				nextStep.setVisible(true);
			}
		}
		else if(e.getSource().equals(cancelButton)){
			new mainMenu();
			setVisible(false);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int targetIdx = table.getSelectedRow();
		System.out.println("Selected row Idx ==> " + targetIdx);
		code = table.getValueAt(targetIdx, 0).toString();
		menu = table.getValueAt(targetIdx, 1).toString();
		harga = table.getValueAt(targetIdx, 2).toString();
		stok = table.getValueAt(targetIdx, 3).toString();
		JOptionPane.showMessageDialog(null, "Selected "+ menu);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
