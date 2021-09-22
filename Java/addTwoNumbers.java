package demo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class addTwoNumbers  {

	public static void main(String[] args) {
		add obj = new add();

	}
	
	
}

class add extends JFrame implements ActionListener{
	JTextField num1, num2;
	JButton button;
	JLabel l;
	public add() {
//		JPanel panel = new JPanel();
		setLayout(null);
//		add(panel);
		JLabel firstNum = new JLabel("First Number :");
		firstNum.setBounds(10, 20, 80, 25);
		add(firstNum);
		
		num1 = new JTextField(5);
		num1.setBounds(120, 20, 50, 25);
		add(num1);
		
		JLabel secondNumber = new JLabel("Second Number:");
		secondNumber.setBounds(10, 50, 100, 25);
		add(secondNumber);
		
		num2 = new JTextField(5);
		num2.setBounds(120, 50, 50, 25);
		add(num2);
		
		button = new JButton("ADD");
		button.addActionListener(this);
		button.setBounds(10, 80, 80, 25);
		add(button);
		
		l = new JLabel("Result: ");
		l.setBounds(10, 110, 90, 25);
		add(l);
		
		setVisible(true);
		setSize(250, 250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	public void actionPerformed(ActionEvent e) {
		int n1 = Integer.parseInt(num1.getText());
		int n2 = Integer.parseInt(num2.getText());
		// If we want to use two button simeltaneously then use code:-
		/*if(e.getSource() == b1)
		 * 	
		 * else
		 */
		int sum;
		sum = n1 + n2;
		
		l.setText("Result : "+sum +"");
	}
}
