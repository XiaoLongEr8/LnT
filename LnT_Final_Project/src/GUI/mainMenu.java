package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class mainMenu extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;

	Font titlefont = new Font("Serif", Font.BOLD, 30);
	
	JButton insertButton = new JButton("Insert Menu");
	JButton viewButton = new JButton("View Menu");
	JButton updateButton = new JButton("Update Menu");
	JButton deleteButton = new JButton("Delete Menu");
	JButton exitButton = new JButton("Exit Menu");
	
	
	
	public mainMenu() {
		createMainMenuFrame();
	}
	
	private void createMainMenuFrame() {
		setTitle("BobaCool");
		setSize(600,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setResizable(false);
		
		createMainMenuTitle();
		createMainMenuElement();
		
		setLocation(450,150);
		setVisible(true);
	}
	
	private void createMainMenuTitle() {
		JLabel mainMenuTittleLabel = new JLabel("BobaCool");
		mainMenuTittleLabel.setHorizontalAlignment(JLabel.CENTER);
		mainMenuTittleLabel.setFont(titlefont);
		add(mainMenuTittleLabel, BorderLayout.NORTH);
	}
	
	private void createMainMenuElement() {
		JPanel mainMenuElementPanel = new JPanel();
		mainMenuElementPanel.setLayout(new GridLayout(3,1));
		
		JPanel mainMenuFirstElementPanel = new JPanel();
		mainMenuFirstElementPanel.setLayout(new GridLayout(1,2));
		mainMenuFirstElementPanel.add(insertButton);
		mainMenuFirstElementPanel.add(viewButton);
		
		JPanel mainMenuSecondElementPanel = new JPanel();
		mainMenuSecondElementPanel.setLayout(new GridLayout(1,2));
		mainMenuSecondElementPanel.add(updateButton);
		mainMenuSecondElementPanel.add(deleteButton);
		
		JPanel mainMenuThridElementPanel = new JPanel();
		mainMenuThridElementPanel.setLayout(new GridLayout(1,0));
		mainMenuThridElementPanel.add(exitButton);
		
		mainMenuElementPanel.add(mainMenuFirstElementPanel);
		mainMenuElementPanel.add(mainMenuSecondElementPanel);
		mainMenuElementPanel.add(mainMenuThridElementPanel);
		
		insertButton.addActionListener(this);
		viewButton.addActionListener(this);
		updateButton.addActionListener(this);
		deleteButton.addActionListener(this);
		exitButton.addActionListener(this);
		
		
		add(mainMenuElementPanel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(insertButton)){
			new insertMenu();
			setVisible(false);
		}
		else if(e.getSource().equals(viewButton)){
			new viewMenu();
			setVisible(false);
		}
		else if(e.getSource().equals(updateButton)){
			new updateSelectDatabase();
			setVisible(false);
		}
		else if(e.getSource().equals(deleteButton)){
			new deleteMenu();
			setVisible(false);
		}
		else if(e.getSource().equals(exitButton)){
			System.exit(0);
		}
	}
	
}
