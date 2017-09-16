package CISC;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import java.awt.Font;

public class Panel {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	public Register_Set RegisterSet;
	private JRadioButton radioButton;
	private JRadioButton radioButton_1;
	private JRadioButton radioButton_2;
	private JRadioButton radioButton_3;
	private JRadioButton radioButton_4;
	private JRadioButton radioButton_5;
	private JRadioButton radioButton_6;
	private JRadioButton radioButton_7;
	private JRadioButton radioButton_8;
	private JRadioButton radioButton_9;
	private JRadioButton radioButton_10;
	private JRadioButton radioButton_11;
	private JRadioButton radioButton_12;
	private JRadioButton radioButton_13;
	private JRadioButton radioButton_14;
	private JRadioButton radioButton_15;
	private JTextArea textArea;
	int[] SwitchRegister = new int[16];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Panel window = new Panel();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Panel() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1082, 753);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//Initialize the Register
		RegisterSet= new Register_Set();
		//
		
		JButton AL = new JButton("");
		
		AL.setBounds(900, 263, 123, 29);
		frame.getContentPane().add(AL);
		
		JButton DP = new JButton("");
		DP.setBounds(900, 323, 123, 29);
		frame.getContentPane().add(DP);
		
		JButton Start = new JButton("OFF");
		Start.setBounds(900, 383, 123, 29);
		frame.getContentPane().add(Start);
		
		JButton Halt = new JButton("OFF");
		Halt.setBounds(900, 444, 123, 29);
		frame.getContentPane().add(Halt);
		
		JButton Clear = new JButton("");
		Clear.setBounds(900, 500, 123, 29);
		frame.getContentPane().add(Clear);
		
		JLabel lblAddressLoad = new JLabel("Address Load");
		lblAddressLoad.setBounds(900, 242, 123, 21);
		frame.getContentPane().add(lblAddressLoad);
		
		JLabel lblDeposit = new JLabel("Deposit");
		lblDeposit.setBounds(900, 299, 81, 21);
		frame.getContentPane().add(lblDeposit);
		
		JLabel lblStart = new JLabel("Start");
		lblStart.setBounds(900, 359, 81, 21);
		frame.getContentPane().add(lblStart);
		
		JLabel lblHalt = new JLabel("Halt");
		lblHalt.setBounds(900, 421, 81, 21);
		frame.getContentPane().add(lblHalt);
		
		JLabel lblClear = new JLabel("Clear");
		lblClear.setBounds(900, 477, 81, 21);
		frame.getContentPane().add(lblClear);
		
		radioButton = new JRadioButton("");
		radioButton.setBounds(62, 383, 34, 29);
		frame.getContentPane().add(radioButton);
		
		radioButton_1 = new JRadioButton("");
		radioButton_1.setBounds(111, 383, 34, 29);
		frame.getContentPane().add(radioButton_1);
		
		radioButton_2 = new JRadioButton("");
		radioButton_2.setBounds(159, 383, 29, 29);
		frame.getContentPane().add(radioButton_2);
		
		radioButton_3 = new JRadioButton("");
		radioButton_3.setBounds(205, 383, 34, 29);
		frame.getContentPane().add(radioButton_3);
		
		radioButton_4 = new JRadioButton("");
		radioButton_4.setBounds(250, 383, 29, 29);
		frame.getContentPane().add(radioButton_4);
		
		radioButton_5 = new JRadioButton("");
		radioButton_5.setBounds(297, 383, 34, 29);
		frame.getContentPane().add(radioButton_5);
		
		radioButton_6 = new JRadioButton("");
		radioButton_6.setBounds(344, 383, 34, 29);
		frame.getContentPane().add(radioButton_6);
		
		radioButton_7 = new JRadioButton("");
		radioButton_7.setBounds(389, 383, 34, 29);
		frame.getContentPane().add(radioButton_7);
		
		radioButton_8 = new JRadioButton("");
		radioButton_8.setBounds(440, 383, 29, 29);
		frame.getContentPane().add(radioButton_8);
		
		radioButton_9 = new JRadioButton("");
		radioButton_9.setBounds(488, 383, 34, 29);
		frame.getContentPane().add(radioButton_9);
		
		radioButton_10 = new JRadioButton("");
		radioButton_10.setBounds(534, 383, 34, 29);
		frame.getContentPane().add(radioButton_10);
		
		radioButton_11 = new JRadioButton("");
		radioButton_11.setBounds(583, 383, 29, 29);
		frame.getContentPane().add(radioButton_11);
		
		radioButton_12 = new JRadioButton("");
		radioButton_12.setBounds(630, 383, 34, 29);
		frame.getContentPane().add(radioButton_12);
		
		radioButton_13 = new JRadioButton("");
		radioButton_13.setBounds(679, 383, 29, 29);
		frame.getContentPane().add(radioButton_13);
		
		radioButton_14 = new JRadioButton("");
		radioButton_14.setBounds(728, 383, 29, 29);
		frame.getContentPane().add(radioButton_14);
		
		radioButton_15 = new JRadioButton("");
		radioButton_15.setBounds(776, 383, 29, 29);
		frame.getContentPane().add(radioButton_15);
		
		JLabel lblSWI = new JLabel("S W I T C H        R E G I S T E R");
		lblSWI.setFont(new Font("Adobe Garamond Pro", Font.PLAIN, 26));
		lblSWI.setBounds(250, 334, 369, 44);
		frame.getContentPane().add(lblSWI);
		
		
		textArea = new JTextArea();
		textArea.setBounds(33, 541, 988, 141);
		frame.getContentPane().add(textArea);
		textArea.setLineWrap(true);
		
		JScrollPane scroll=new JScrollPane(textArea);
		scroll.setBounds(33,541,988,141);
		frame.getContentPane().add(scroll);
		
		textField = new JTextField();
		textField.setBounds(111, 37, 190, 27);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(111, 79, 190, 27);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(111, 121, 190, 27);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(111, 163, 190, 27);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(362, 37, 206, 27);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(362, 79, 206, 27);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(362, 121, 206, 27);
		frame.getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblR = new JLabel("R0");
		lblR.setBounds(62, 40, 29, 21);
		frame.getContentPane().add(lblR);
		
		JLabel lblR_1 = new JLabel("R1");
		lblR_1.setBounds(62, 79, 81, 21);
		frame.getContentPane().add(lblR_1);
		
		JLabel lblR_2 = new JLabel("R2");
		lblR_2.setBounds(62, 124, 81, 21);
		frame.getContentPane().add(lblR_2);
		
		JLabel lblR_3 = new JLabel("R3");
		lblR_3.setBounds(62, 166, 81, 21);
		frame.getContentPane().add(lblR_3);
		
		JLabel lblX = new JLabel("X1");
		lblX.setBounds(331, 40, 34, 21);
		frame.getContentPane().add(lblX);
		
		JLabel lblNewLabel = new JLabel("X2");
		lblNewLabel.setBounds(331, 82, 29, 21);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblX_1 = new JLabel("X3");
		lblX_1.setBounds(331, 124, 34, 21);
		frame.getContentPane().add(lblX_1);
		
		textField_7 = new JTextField();
		textField_7.setBounds(362, 166, 206, 27);
		frame.getContentPane().add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblPc = new JLabel("PC");
		lblPc.setBounds(331, 166, 81, 21);
		frame.getContentPane().add(lblPc);
		
		textField_8 = new JTextField();
		textField_8.setBounds(643, 37, 190, 27);
		frame.getContentPane().add(textField_8);
		textField_8.setColumns(10);
		
		JLabel lblIr = new JLabel("IR");
		lblIr.setBounds(607, 40, 29, 21);
		frame.getContentPane().add(lblIr);
		
		textField_9 = new JTextField();
		textField_9.setBounds(643, 79, 190, 27);
		frame.getContentPane().add(textField_9);
		textField_9.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("MAR");
		lblNewLabel_1.setBounds(607, 82, 81, 21);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField_10 = new JTextField();
		textField_10.setBounds(643, 121, 190, 27);
		frame.getContentPane().add(textField_10);
		textField_10.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("MBR");
		lblNewLabel_2.setBounds(607, 124, 81, 21);
		frame.getContentPane().add(lblNewLabel_2);
		
		textField_11 = new JTextField();
		textField_11.setBounds(643, 166, 190, 27);
		frame.getContentPane().add(textField_11);
		textField_11.setColumns(10);
		
		JLabel lblMsr = new JLabel("MSR");
		lblMsr.setBounds(607, 166, 81, 21);
		frame.getContentPane().add(lblMsr);
		
		textField_12 = new JTextField();
		textField_12.setBounds(643, 208, 190, 27);
		frame.getContentPane().add(textField_12);
		textField_12.setColumns(10);
		
		JLabel lblMfr = new JLabel("MFR");
		lblMfr.setBounds(607, 208, 81, 21);
		frame.getContentPane().add(lblMfr);
		
		AL.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				doAL();
			}
		});
		
		DP.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				doDP();
			}
		});
		
		Start.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				textArea.append("Start\n");
				if(Start.getText()=="OFF") {
					Start.setText("ON");
				}
				else {
					Start.setText("OFF");
				}
			}
		});
		
		Halt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				textArea.append("Halt\n");
				if(Halt.getText()=="OFF") {
					Halt.setText("ON");
				}
				else {
					Halt.setText("OFF");
				}
			}
		});
		
		Clear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				doClear();
			}
		});
				
		updateFields();
	}
	
	public void updateFields(){
		textField.setText(RegisterSet.R0.OutputAsString());
		textField_1.setText(RegisterSet.R1.OutputAsString());
		textField_2.setText(RegisterSet.R2.OutputAsString());
		textField_3.setText(RegisterSet.R3.OutputAsString());
		textField_4.setText(RegisterSet.X1.OutputAsString());
		textField_5.setText(RegisterSet.X2.OutputAsString());
		textField_6.setText(RegisterSet.X3.OutputAsString());
		textField_7.setText(RegisterSet.PC.OutputAsString());
		textField_8.setText(RegisterSet.IR.OutputAsString());
		textField_9.setText(RegisterSet.MAR.OutputAsString());
		textField_10.setText(RegisterSet.MBR.OutputAsString());
		textField_11.setText(RegisterSet.MSR.OutputAsString());
		textField_12.setText(RegisterSet.MFR.OutputAsString());
	}
	
	public void updateSwitchRegisterVal() {
		if(radioButton.isSelected()) {
			SwitchRegister[0]=1;
		}
		else {
			SwitchRegister[0]=0;
		}
		if(radioButton_1.isSelected()) {
			SwitchRegister[1]=1;
		}
		else {
			SwitchRegister[1]=0;
		}
		if(radioButton_2.isSelected()) {
			SwitchRegister[2]=1;
		}
		else {
			SwitchRegister[2]=0;
		}
		if(radioButton_3.isSelected()) {
			SwitchRegister[3]=1;
		}
		else {
			SwitchRegister[3]=0;
		}
		if(radioButton_4.isSelected()) {
			SwitchRegister[4]=1;
		}
		else {
			SwitchRegister[4]=0;
		}
		if(radioButton_5.isSelected()) {
			SwitchRegister[5]=1;
		}
		else {
			SwitchRegister[5]=0;
		}
		if(radioButton_6.isSelected()) {
			SwitchRegister[6]=1;
		}
		else {
			SwitchRegister[6]=0;
		}
		if(radioButton_7.isSelected()) {
			SwitchRegister[7]=1;
		}
		else {
			SwitchRegister[7]=0;
		}
		if(radioButton_8.isSelected()) {
			SwitchRegister[8]=1;
		}
		else {
			SwitchRegister[8]=0;
		}
		if(radioButton_9.isSelected()) {
			SwitchRegister[9]=1;
		}
		else {
			SwitchRegister[9]=0;
		}
		if(radioButton_10.isSelected()) {
			SwitchRegister[10]=1;
		}
		else {
			SwitchRegister[10]=0;
		}
		if(radioButton_11.isSelected()) {
			SwitchRegister[11]=1;
		}
		else {
			SwitchRegister[11]=0;
		}
		if(radioButton_12.isSelected()) {
			SwitchRegister[12]=1;
		}
		else {
			SwitchRegister[12]=0;
		}
		if(radioButton_13.isSelected()) {
			SwitchRegister[13]=1;
		}
		else {
			SwitchRegister[13]=0;
		}
		if(radioButton_14.isSelected()) {
			SwitchRegister[14]=1;
		}
		else {
			SwitchRegister[14]=0;
		}
		if(radioButton_15.isSelected()) {
			SwitchRegister[15]=1;
		}
		else {
			SwitchRegister[15]=0;
		}
	}
	
	public void doClear() {
		textArea.setText("");
		radioButton.setSelected(false);
		radioButton_1.setSelected(false);
		radioButton_2.setSelected(false);
		radioButton_3.setSelected(false);
		radioButton_4.setSelected(false);
		radioButton_5.setSelected(false);
		radioButton_6.setSelected(false);
		radioButton_7.setSelected(false);
		radioButton_8.setSelected(false);
		radioButton_9.setSelected(false);
		radioButton_10.setSelected(false);
		radioButton_11.setSelected(false);
		radioButton_12.setSelected(false);
		radioButton_13.setSelected(false);
		radioButton_14.setSelected(false);
		radioButton_15.setSelected(false);
	}
	
	public void doAL() {
		//Get the data of Memory.
		updateSwitchRegisterVal();
		//int -> string
		String text="";
		for(int i=0;i<16;i++) {
			text=text+SwitchRegister[i];
		}
		
		int[] Data=RegisterSet.Memory.Output(SwitchRegister);
		String text2="";
		if (Data != null) {
			for(int i=0;i<16;i++) {
				text2=text2+Data[i];
			}
			textArea.append("The Memory at Address:["+text+"] is ["+text2+"]\n");
		}else {
			textArea.append("Address Out of range\n");
		}
	}

	public void doDP() {
		//get the input from Switch Register
		updateSwitchRegisterVal();
		//int -> string
		String text="";
		for(int i=0;i<16;i++) {
			text=text+SwitchRegister[i];
		}
		textArea.append("The Data Insert to Memory is:["+text+"]\n");
		
		
		//insert to memory
		RegisterSet.Memory.Insert(SwitchRegister);
		
		/**
		 *We can add Fault Diagnose   
		*/
		textArea.append("The Data:["+text+"] Successfully inserted to Memory.\n");
	}
}
