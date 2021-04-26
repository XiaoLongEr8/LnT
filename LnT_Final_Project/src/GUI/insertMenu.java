package GUI;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;

import Database.databaseController;

public class insertMenu extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 2L;
	
	Font titlefont = new Font("Serif", Font.BOLD, 30);
	
	JLabel namaMenuLabel = new JLabel("Nama menu: ");
	JTextField namaMenuTextField = new JTextField();
	
	JLabel hargaMenuLabel = new JLabel("Harga menu: ");
	JTextField hargaMenuTextField = new JTextField();
	
	JLabel stokMenuLabel = new JLabel("Stok menu: ");
	JTextField stokMenuTextField = new JTextField();
	
	JButton submitButton = new JButton("Submit");
	JButton cancelButton = new JButton ("Cancel");
	
	public insertMenu() {
		initInsertFrame();
	}
	
	private void initInsertFrame() {
		setTitle("BobaCool");
		setSize(600,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setResizable(false);
		
		initInsertMenuTitle();
		initInsertComponent();
		
		setLocation(450,150);
		setVisible(true);
	}
	
	private void initInsertMenuTitle() {
		JLabel InsertMenuTittleLabel = new JLabel("Insert New Menu");
		InsertMenuTittleLabel.setHorizontalAlignment(JLabel.CENTER);
		InsertMenuTittleLabel.setFont(titlefont);
		add(InsertMenuTittleLabel, BorderLayout.NORTH);
	}
	
	private void initInsertComponent() {
		JPanel insertComponentPanel = new JPanel();
		insertComponentPanel.setLayout(new GridLayout(4,2));
		
		insertComponentPanel.add(namaMenuLabel);
		insertComponentPanel.add(namaMenuTextField);
		
		insertComponentPanel.add(hargaMenuLabel);
		insertComponentPanel.add(hargaMenuTextField);
		
		insertComponentPanel.add(stokMenuLabel);
		insertComponentPanel.add(stokMenuTextField);
		
		insertComponentPanel.add(cancelButton);
		insertComponentPanel.add(submitButton);
		
		add(insertComponentPanel);
		
		submitButton.addActionListener(this);
		cancelButton.addActionListener(this);
		
	}
	
	private String createRandomCode(JTextField namaMenuTextField2) {
		
		Random randInt = new Random();
		
		String casterTextFieldtoString ="";
		casterTextFieldtoString = namaMenuTextField2.getText();
		
		int ranCode1 = randInt.nextInt(9);
		int ranCode2 = randInt.nextInt(9);
		int ranCode3 = randInt.nextInt(9);
		
		String code = casterTextFieldtoString.substring(0,2);
		code = code.toUpperCase();
		code = code + "-"+ranCode1 + ranCode2 + ranCode3;
//		System.out.println("Code ==> "+ code);
		return code;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(submitButton)) {
			databaseController controller = new databaseController();
			controller.createNewElementDatabase(createRandomCode(namaMenuTextField), namaMenuTextField.getText(), hargaMenuTextField.getText(), stokMenuTextField.getText());
			namaMenuTextField.setText(null);
			hargaMenuTextField.setText(null);
			stokMenuTextField.setText(null);
		}
		else if(e.getSource().equals(cancelButton)){
			new mainMenu();
			setVisible(false);
		}
	}

}
