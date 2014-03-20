import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class BMI extends JFrame {
	/**create text fields for name, age, height, weight, BMI*/
	  private JTextField jtfFrame = new JTextField();
	  private JTextField jtfAge = new JTextField();
	  private JTextField jtfHeight = new JTextField();
	  private JTextField jtfWeight = new JTextField();
	  private JTextField jtfBmi = new JTextField();
	  private JTextField jtfStatus = new JTextField();

	  // Create a Calculate button
	  private JButton jbtCalculate = new JButton("Calculate");

	  public BMI() {
	    // Panel p1 to hold labels and text fields
	    JPanel p1 = new JPanel(new GridLayout(6, 2));
	    p1.add(new JLabel("Name"));
	    p1.add(jtfFrame);
	    p1.add(new JLabel("Age"));
	    p1.add(jtfAge);
	    p1.add(new JLabel("Height(cm)"));
	    p1.add(jtfHeight);
	    p1.add(new JLabel("Weight(kg)"));
	    p1.add(jtfWeight);
	    p1.add(new JLabel("BMI"));
	    p1.add(jtfBmi);
	    p1.add(new JLabel("Status"));
	    p1.add(jtfStatus);
	    p1.setBorder(new
	      TitledBorder("BMI Test"));

	    // Panel p2 to hold the button
	    JPanel p2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
	    p2.add(jbtCalculate);

	    // Add the panels to the frame
	    add(p1, BorderLayout.CENTER);
	    add(p2, BorderLayout.SOUTH);

	    // Register listener
	    jbtCalculate.addActionListener(new ButtonListener());
	  }

	  /** Handle the Compute Payment button */
	  private class ButtonListener implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e){
				//Get values from text fields
				double height = Double.parseDouble(jtfHeight.getText());
				double weight = Double.parseDouble(jtfWeight.getText());
				//Calculate BMI value
				double bmi = weight / ((height * 0.01) * (height * 0.01));
				//Display BMI on the Your BMI text field
				jtfBmi.setText(String.format("%.2f", bmi));
				
				if(bmi < 18.5)
					jtfStatus.setText("Underweight");
				else if(bmi < 25)
					jtfStatus.setText("Normal");
				else if(bmi < 30)
					jtfStatus.setText("Overweight");
				else
					jtfStatus.setText("Obese");	
			}
		}
	  
	  public static void main(String[] args) {
	    BMI frame = new BMI();
	    frame.setSize(380 , 280);
	    frame.setTitle("BMI Test");
	    frame.setLocationRelativeTo(null); // Center the frame
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setVisible(true);
	  }
}
