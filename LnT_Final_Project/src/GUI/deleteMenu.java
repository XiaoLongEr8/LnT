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

public class deleteMenu extends JFrame implements ActionListener, MouseListener{
	
	private static final long serialVersionUID = 1L;

	Font titlefont = new Font("Serif", Font.BOLD, 30);
	
	private JButton cancelButton = new JButton("Cancel");
	private JButton deleteButton = new JButton("Delete");
	
	JTable table;
	JButton btnDelete;
	String code ="";
	String menu ="";
	
	
	public deleteMenu() {
		initDeleteFrame();
	}
	
	private void initDeleteFrame() {
		setTitle("BobaCool");
		setSize(600,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setResizable(false);
		
		initDeleteMenuTitle();
		initData();
		initDeleteComponent();
		
		setLocation(450,150);
		setVisible(true);
	}
	
	private void initDeleteMenuTitle() {
		JLabel deleteMenuTittleLabel = new JLabel("Delete Menu");
		deleteMenuTittleLabel.setHorizontalAlignment(JLabel.CENTER);
		deleteMenuTittleLabel.setFont(titlefont);
		add(deleteMenuTittleLabel, BorderLayout.NORTH);
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
	
	private void initDeleteComponent() {
		JPanel deleteButtonPanel = new JPanel();
		deleteButtonPanel.setLayout(new GridLayout(1,2));
		
		deleteButtonPanel.add(cancelButton);
		deleteButtonPanel.add(deleteButton);
		
		cancelButton.addActionListener(this);
		deleteButton.addActionListener(this);
		
		add(deleteButtonPanel, BorderLayout.SOUTH);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(deleteButton)) {
			if(code.equals("")) {
				JOptionPane.showMessageDialog(null, "Pilih menu yang akan di-delete ");
			}
			else {
				databaseController controller = new databaseController();
				controller.deleteElementDatabase(code);
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
