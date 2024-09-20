package Game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;

public class TicTacToe implements ActionListener {
	//make UI
	JFrame frame=new JFrame();
	JPanel title_panel=new JPanel();
	JPanel control_panel=new JPanel();
	JLabel title=new JLabel();
	JButton[] buttons=new JButton[9];
	JButton reset=new JButton("Reset");
	JButton quit=new JButton("Quit");
	JPanel body_panel=new JPanel();
	Random random=new Random();
	Boolean First_Player=true;

	
	
	
TicTacToe(){
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setSize(500, 500);
       frame.getContentPane().setBackground(new Color(12, 12, 12));
       frame.setLayout(new BorderLayout());
       frame.setVisible(true);
       frame.setResizable(false);
       frame.setTitle("TictacToe");

       title.setBackground(Color.gray);
       title.setForeground(Color.white);
       title.setText("Welcome to TicTacToe");
       title.setFont(new Font("Int Free", Font.BOLD, 30));
       title.setHorizontalAlignment(JLabel.CENTER);
       title.setOpaque(true);

       title_panel.setLayout(new BorderLayout());
       title_panel.setBounds(0, 0, 500, 100);

       body_panel.setLayout(new GridLayout(3, 3));
       for (int i = 0; i < 9; i++) {
           buttons[i] = new JButton();
           body_panel.add(buttons[i]);
           buttons[i].setFont(new Font("MV Boli", Font.BOLD, 80));
           buttons[i].setFocusable(false);
           buttons[i].addActionListener(this);
       }

       // Add Reset and Quit buttons
       reset.setFont(new Font("Arial", Font.BOLD, 20));
       quit.setFont(new Font("Arial", Font.BOLD, 20));

       reset.addActionListener(this);
       reset.setFocusable(false);
       reset.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
       quit.addActionListener(this);
       quit.setFocusable(false);
       quit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

       control_panel.setLayout(new GridLayout(1, 2));
       control_panel.add(reset);
       control_panel.add(quit);

       title_panel.add(title);
       frame.add(title_panel, BorderLayout.NORTH);
       frame.add(body_panel);
       frame.add(control_panel, BorderLayout.SOUTH); // Add control panel to the bottom

	first_Turn();
	
}
	private void first_Turn() {
	if(random.nextInt()==2) {
		First_Player=true;
		title.setText("X's Turn");
	}else {
		First_Player=false;
		title.setText("O's Turn");
	}
}	
	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < 9; i++) {
			if(e.getSource()==buttons[i]) {	
			if(buttons[i].getText().equals("")) {
			if(First_Player) {
				    title.setText("O's turn");
					buttons[i].setForeground(Color.green);
					buttons[i].setText("X");
			        First_Player=false;
			        check();
			        
				}else{
					title.setText("X's turn");
					buttons[i].setForeground(Color.red);
					buttons[i].setText("O");
			        First_Player=true;
			        check();
			        
				}
				}
			}
		}
		
		if(e.getSource()==reset) {
			for (int i = 0; i < buttons.length; i++) {
				buttons[i].setText("");
				buttons[i].setEnabled(true);
				
			}
			first_Turn();
		
		}
		if (e.getSource()==quit) {
			System.exit(0);
			
		}
		
		
		
	}
	
	private void check() {
	    if (
	            (buttons[0].getText().equals("X") && buttons[1].getText().equals("X") && buttons[2].getText().equals("X")) ||
	            (buttons[3].getText().equals("X") && buttons[4].getText().equals("X") && buttons[5].getText().equals("X")) ||
	            (buttons[6].getText().equals("X") && buttons[7].getText().equals("X") && buttons[8].getText().equals("X")) ||
	            (buttons[0].getText().equals("X") && buttons[3].getText().equals("X") && buttons[6].getText().equals("X")) ||
	            (buttons[1].getText().equals("X") && buttons[4].getText().equals("X") && buttons[7].getText().equals("X")) ||
	            (buttons[2].getText().equals("X") && buttons[5].getText().equals("X") && buttons[8].getText().equals("X")) ||
	            (buttons[0].getText().equals("X") && buttons[4].getText().equals("X") && buttons[8].getText().equals("X")) ||
	            (buttons[2].getText().equals("X") && buttons[4].getText().equals("X") && buttons[6].getText().equals("X"))
	        ) {
	            xWins();
	        }
	        else if (
	            (buttons[0].getText().equals("O") && buttons[1].getText().equals("O") && buttons[2].getText().equals("O")) ||
	            (buttons[3].getText().equals("O") && buttons[4].getText().equals("O") && buttons[5].getText().equals("O")) ||
	            (buttons[6].getText().equals("O") && buttons[7].getText().equals("O") && buttons[8].getText().equals("O")) ||
	            (buttons[0].getText().equals("O") && buttons[3].getText().equals("O") && buttons[6].getText().equals("O")) ||
	            (buttons[1].getText().equals("O") && buttons[4].getText().equals("O") && buttons[7].getText().equals("O")) ||
	            (buttons[2].getText().equals("O") && buttons[5].getText().equals("O") && buttons[8].getText().equals("O")) ||
	            (buttons[0].getText().equals("O") && buttons[4].getText().equals("O") && buttons[8].getText().equals("O")) ||
	            (buttons[2].getText().equals("O") && buttons[4].getText().equals("O") && buttons[6].getText().equals("O"))
	        ) {
	            oWins();
	        }
		
	}

	
	
	private void xWins() {
		title.setText("X Win");
	    disableButtons();
		
	}
	private void oWins() {
		title.setText("O Win");
	    disableButtons();
	}
	private void disableButtons() {
		for (int i = 0; i < buttons.length; i++) {
			buttons[i].setEnabled(false);
		}
	
		
	}


	public static void main(String[] args) {
		new TicTacToe();
	}
}
