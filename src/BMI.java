import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;


public class BMI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BMI frame = new BMI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**Handle the Compute Payment button*/
	private class ButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e){
			//Get values from text fields
			double height = Double.parseDouble(textField_2.getText());
			double weight = Double.parseDouble(textField_3.getText());
			//Calculate BMI value
			double bmi = weight / ((height * 0.01) * (height * 0.01));
			//print BMI on the Your BMI text field
			textField_4.setText(String.format("%.2f", bmi));
		}
	}

	/**
	 * Create the frame.
	 */
	public BMI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 394, 271);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLayeredPane layeredPane = new JLayeredPane();
		contentPane.add(layeredPane, BorderLayout.CENTER);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(95, 37, 46, 15);
		layeredPane.add(lblName);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setBounds(95, 69, 46, 15);
		layeredPane.add(lblAge);
		
		JLabel lblHeightcm = new JLabel("Height(cm)");
		lblHeightcm.setBounds(80, 101, 77, 15);
		layeredPane.add(lblHeightcm);
		
		JLabel lblWeightkg = new JLabel("Weight(kg)");
		lblWeightkg.setBounds(80, 133, 77, 15);
		layeredPane.add(lblWeightkg);
		
		JLabel lblBmiTest = new JLabel("BMI Test");
		lblBmiTest.setFont(new Font("·s²Ó©úÅé", Font.PLAIN, 20));
		lblBmiTest.setBounds(145, 10, 77, 21);
		layeredPane.add(lblBmiTest);
		
		JLabel lblYourBmi = new JLabel("Your BMI");
		lblYourBmi.setBounds(80, 165, 61, 15);
		layeredPane.add(lblYourBmi);
		
		textField = new JTextField();
		textField.setBounds(175, 34, 96, 21);
		layeredPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(175, 66, 96, 21);
		layeredPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(175, 98, 96, 21);
		layeredPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(175, 130, 96, 21);
		layeredPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(175, 162, 96, 21);
		layeredPane.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.setBounds(145, 194, 87, 23);
		layeredPane.add(btnCalculate);
		
		btnCalculate.addActionListener(new ButtonListener());
	}
}
