package GUI;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Database.databaseController;

public class updateSubmitProgress extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;

	Font titlefont = new Font("Serif", Font.BOLD, 30);

	JLabel codeMenuLabel = new JLabel("Code menu: ");
	JTextField codeMenuTextField = new JTextField();
	
	JLabel namaMenuLabel = new JLabel("Nama menu: ");
	JTextField namaMenuTextField = new JTextField();

	JLabel hargaMenuLabel = new JLabel("Harga menu: ");
	JTextField hargaMenuTextField = new JTextField();

	JLabel stokMenuLabel = new JLabel("Stok menu: ");
	JTextField stokMenuTextField = new JTextField();

	JButton submitButton = new JButton("Submit");
	JButton backButton = new JButton("Back");

	public updateSubmitProgress() {
		updateSubmitProgressFrame();
	}
	
	public void initForm(String codeMenu, String namaMenu, String hargaMenu, String stockMenu) {
		codeMenuTextField.setText(codeMenu);
		namaMenuTextField.setText(namaMenu);
		hargaMenuTextField.setText(hargaMenu);
		stokMenuTextField.setText(stockMenu);
	}
	
	private void updateSubmitProgressFrame() {
		setTitle("BobaCool");
		setSize(600,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setResizable(false);
		
		updateSubmitProgressTitle();
		initUpdateSubmitProgressComponent();
		
		setLocation(450,150);
		setVisible(true);
	}
	
	private void updateSubmitProgressTitle() {
		JLabel updateSubmitProgressMenuTittleLabel = new JLabel("Insert New Menu");
		updateSubmitProgressMenuTittleLabel.setHorizontalAlignment(JLabel.CENTER);
		updateSubmitProgressMenuTittleLabel.setFont(titlefont);
		add(updateSubmitProgressMenuTittleLabel, BorderLayout.NORTH);
	}
	
	private void initUpdateSubmitProgressComponent() {
		JPanel insertComponentPanel = new JPanel();
		insertComponentPanel.setLayout(new GridLayout(4,2));
		

		insertComponentPanel.add(namaMenuLabel);
		insertComponentPanel.add(namaMenuTextField);
		
		insertComponentPanel.add(hargaMenuLabel);
		insertComponentPanel.add(hargaMenuTextField);
		
		insertComponentPanel.add(stokMenuLabel);
		insertComponentPanel.add(stokMenuTextField);
		
		insertComponentPanel.add(backButton);
		insertComponentPanel.add(submitButton);
		
		
		add(insertComponentPanel);
		
		submitButton.addActionListener(this);
		backButton.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(submitButton)) {
			databaseController controller = new databaseController();
			controller.updateElementDatabase(namaMenuTextField.getText(), namaMenuTextField.getText(), hargaMenuTextField.getText(), stokMenuTextField.getText());
		}
		else if(e.getSource().equals(backButton)){
			new mainMenu();
			setVisible(false);
		}
	}

}
