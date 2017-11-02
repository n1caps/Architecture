package CISC;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.Color;
import java.lang.Thread;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

import javax.swing.JFileChooser;
import java.io.*;
import javax.swing.SwingConstants;

public class Panel {

	private JFrame frame;
	private String InputData;
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
	private JButton StartBtn;
	private Thread progThread;
	int[] SwitchRegister = new int[16];
	private JTextField FR0;
	private JTextField FR1;
	private JTextField INPUT;
	private JTextArea PRINTER;

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
		
		StartBtn = new JButton("");
		StartBtn.setBounds(900, 383, 123, 29);
		frame.getContentPane().add(StartBtn);
		
		JButton Halt = new JButton("");
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
		
		//Renaming the label Run to align with instructions in the doc
		JLabel lblStart = new JLabel("Run");
		lblStart.setBounds(900, 359, 81, 21);
		frame.getContentPane().add(lblStart);
		
		JLabel lblHalt = new JLabel("Halt");
		lblHalt.setBounds(900, 421, 81, 21);
		frame.getContentPane().add(lblHalt);
		
		JLabel lblClear = new JLabel("Clear");
		lblClear.setBounds(900, 477, 81, 21);
		frame.getContentPane().add(lblClear);
		
		radioButton = new JRadioButton("");
		radioButton.setBounds(62, 284, 34, 29);
		frame.getContentPane().add(radioButton);
		
		radioButton_1 = new JRadioButton("");
		radioButton_1.setBounds(111, 284, 34, 29);
		frame.getContentPane().add(radioButton_1);
		
		radioButton_2 = new JRadioButton("");
		radioButton_2.setBounds(159, 284, 29, 29);
		frame.getContentPane().add(radioButton_2);
		
		radioButton_3 = new JRadioButton("");
		radioButton_3.setBounds(205, 284, 34, 29);
		frame.getContentPane().add(radioButton_3);
		
		radioButton_4 = new JRadioButton("");
		radioButton_4.setBounds(250, 284, 29, 29);
		frame.getContentPane().add(radioButton_4);
		
		radioButton_5 = new JRadioButton("");
		radioButton_5.setBounds(297, 284, 34, 29);
		frame.getContentPane().add(radioButton_5);
		
		radioButton_6 = new JRadioButton("");
		radioButton_6.setBounds(344, 284, 34, 29);
		frame.getContentPane().add(radioButton_6);
		
		radioButton_7 = new JRadioButton("");
		radioButton_7.setBounds(389, 284, 34, 29);
		frame.getContentPane().add(radioButton_7);
		
		radioButton_8 = new JRadioButton("");
		radioButton_8.setBounds(440, 284, 29, 29);
		frame.getContentPane().add(radioButton_8);
		
		radioButton_9 = new JRadioButton("");
		radioButton_9.setBounds(488, 284, 34, 29);
		frame.getContentPane().add(radioButton_9);
		
		radioButton_10 = new JRadioButton("");
		radioButton_10.setBounds(534, 284, 34, 29);
		frame.getContentPane().add(radioButton_10);
		
		radioButton_11 = new JRadioButton("");
		radioButton_11.setBounds(583, 284, 29, 29);
		frame.getContentPane().add(radioButton_11);
		
		radioButton_12 = new JRadioButton("");
		radioButton_12.setBounds(630, 284, 34, 29);
		frame.getContentPane().add(radioButton_12);
		
		radioButton_13 = new JRadioButton("");
		radioButton_13.setBounds(679, 284, 29, 29);
		frame.getContentPane().add(radioButton_13);
		
		radioButton_14 = new JRadioButton("");
		radioButton_14.setBounds(728, 284, 29, 29);
		frame.getContentPane().add(radioButton_14);
		
		radioButton_15 = new JRadioButton("");
		radioButton_15.setBounds(776, 284, 29, 29);
		frame.getContentPane().add(radioButton_15);
		
		JLabel lblSWI = new JLabel("S W I T C H        R E G I S T E R");
		lblSWI.setFont(new Font("Adobe Garamond Pro", Font.PLAIN, 26));
		lblSWI.setBounds(250, 242, 386, 44);
		frame.getContentPane().add(lblSWI);
		
		
		textArea = new JTextArea();
		textArea.setBounds(33, 541, 988, 141);
		frame.getContentPane().add(textArea);
		textArea.setLineWrap(true);
		
		JScrollPane scroll=new JScrollPane(textArea);
		scroll.setBounds(93,541,928,141);
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
		
		JButton btnIpl = new JButton("IPL");
		btnIpl.setBackground(Color.RED);
		btnIpl.setBounds(900, 38, 123, 44);
		btnIpl.setOpaque(true);
		frame.getContentPane().add(btnIpl);
		
		JButton singleStepButton = new JButton("Single Step");
		singleStepButton.setBounds(900, 94, 123, 29);
		frame.getContentPane().add(singleStepButton);
		
		JLabel lblLoadProgramFrom = new JLabel("Load Program From File");
		lblLoadProgramFrom.setBounds(900, 186, 157, 21);
		frame.getContentPane().add(lblLoadProgramFrom);
		
		JButton Load = new JButton("");
		Load.setBounds(900, 209, 123, 29);
		frame.getContentPane().add(Load);
		
		JLabel lblFr = new JLabel("FR0");
		lblFr.setBounds(62, 202, 34, 21);
		frame.getContentPane().add(lblFr);
		
		FR0 = new JTextField();
		FR0.setText("0000000000000000");
		FR0.setBounds(111, 205, 190, 27);
		frame.getContentPane().add(FR0);
		FR0.setColumns(10);
		
		FR1 = new JTextField();
		FR1.setText("0000000000000000");
		FR1.setBounds(362, 208, 206, 27);
		frame.getContentPane().add(FR1);
		FR1.setColumns(10);
		
		JLabel lblFr_1 = new JLabel("FR1");
		lblFr_1.setBounds(331, 211, 34, 21);
		frame.getContentPane().add(lblFr_1);
		
		INPUT = new JTextField();
		INPUT.setBounds(93, 323, 295, 35);
		frame.getContentPane().add(INPUT);
		INPUT.setColumns(10);
		
		JLabel lblInput = new JLabel("INPUT");
		lblInput.setBounds(40, 331, 51, 21);
		frame.getContentPane().add(lblInput);
		
		JLabel lblDevCosole = new JLabel("DEV COSOLE");
		lblDevCosole.setBounds(6, 544, 90, 35);
		frame.getContentPane().add(lblDevCosole);
		
		JLabel lblPrinter = new JLabel("PRINTER");
		lblPrinter.setBounds(30, 383, 61, 21);
		frame.getContentPane().add(lblPrinter);
		
		JButton btnEnterInput = new JButton("ENTER");
		btnEnterInput.setBounds(399, 327, 117, 29);
		frame.getContentPane().add(btnEnterInput);
		
		PRINTER = new JTextArea();
		PRINTER.setEditable(false);
		PRINTER.setLineWrap(true);
		PRINTER.setBounds(95, 383, 738, 141);
		frame.getContentPane().add(PRINTER);
		
		btnIpl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(btnIpl.getBackground().equals(Color.RED)) {
					btnIpl.setBackground(Color.GREEN);
					//Moving as much code out of the initialize method as possible so that we dont
					//Have to look through as much code to find what we need
					doIPL();
				}else {
					btnIpl.setBackground(Color.RED);
				}
			}
		});
		
		singleStepButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				doSingleStep();
			}
		});
		
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
		
		Load.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				doLoad();
			}
		});
		
		StartBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				textArea.append("Running Program in memory...\n");
				StartBtn.setText("Running");
				//Prevent multiple presses of the start button
				StartBtn.setEnabled(false);
				//Set running paramater to true to all the thread to run until halt condiiton occurs
				RegisterSet.isRunning=true;
				progThread = new Thread() {
					public void run() {
						try {
							while(RegisterSet.isRunning)
							{
								doSingleStep();
							}
							StartBtn.setEnabled(true);
							StartBtn.setText("");
						}catch(Exception e) {
							
						}
					}
				};
				progThread.start();
			}
		});
		
		Halt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				textArea.append("Halting Program Execution\n");
				//Halts a running program and reenables the start button
				RegisterSet.isRunning = false;
				StartBtn.setText("");
				StartBtn.setEnabled(true);
				try {
					progThread.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		Clear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				doClear();
			}
		});
		
		btnEnterInput.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				doSubmitInput();
			}
		});
		//Update all the register fields after intialization		
		updateFields();
	}
	
	/**
	 * Update all the display fields with the corresponding data
	 */
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
		PRINTER.setText(RegisterSet.PRINTER.Output());
	}
	
	/**
	 * Updates the switch register variable with the current value of the switch variable
	 */
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
	
	/**
	 * Bit Array to Integer converter helper function
	 * @param array
	 * @return
	 */
	public int bitToInt (int[] array) {
		int result = 0;
		for(int i=0;i<array.length;i++) {
			int exp = (int) Math.pow(2,(array.length-1-i));
			result += array[i] * (exp);
		}
		return result;
	}
	
	/**
	 * The Initial program load method
	 * Sets the Program Counter (PC) to the starting point in memory where the first program instruction should be (word 6 because 0-5 are reserved)
	 * Moves the PC valued to the Memory Address Register (MAR)
	 * Loads the contents of memory at the location in the MAR to the Memory Buffer Register (MBR)
	 * Then loads the contents of the MBR to the Instruction Register
	 * Finally initializes the thread that will be used to Run programs to completion
	 */
	public void doIPL() {
		textArea.append("Initializing initial program.\n");
		RegisterSet.PC.Insert((new int[] {0,0,0,0,0,0,0,0,0,1,1,0}), 0);
		RegisterSet.MAR.Insert(RegisterSet.PC.OutputAsInt(),0);
		RegisterSet.MBR.Insert(RegisterSet.Memory.Output(RegisterSet.MAR.Output), 0);
		RegisterSet.IR.Insert(RegisterSet.MBR.OutputAsInt(), 0);
		//RegisterSet.INPUT.filter("Hello");
		//RegisterSet.INPUT.filter("1234");
		updateFields();
		//textArea.append(InputData);//test
	}

	/**
	 * Loads A Program into Memory
	 */
	public void doLoad() {
		JFileChooser fileChooser = new JFileChooser();
		int retVal = fileChooser.showOpenDialog(null);
		if(retVal == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileChooser.getSelectedFile();
			Scanner input;
			try {
				input = new Scanner(selectedFile);
				int iter = 6;
				int[] parsedLineAsArray = new int[16];
				while(input.hasNext()) {
					String parsedLine = input.nextLine();
					for(int i = 0; i<16; i++) {
						parsedLineAsArray[i] = parsedLine.charAt(i) == '1'? 1:0;
					}
					RegisterSet.Memory.Insert(parsedLineAsArray, iter);
					iter++;
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		return;
	}
	
	/**
	 * Perform a single instruction
	 * To execute an instruction the MAR is loaded with the content of PC
	 * The MBR is then loaded with the contents of Memory pointed to by the MAR
	 * The IR is loaded with the contents of the MBR
	 * and the decoder takes the value from the IR, decodes it, and performs the instruction
	 */
 	public void doSingleStep() {
 		String Information;
 		textArea.append("Executing Instruction at PC " + RegisterSet.PC.OutputAsInt() + "\n");
 		//I capsulate the action of MAR,MBR,IR into decoder, because I set the Output Method with remove the data in memory.
 		Information=RegisterSet.decoder(Get_Instruction());//maybe return some String.
 		textArea.append(Information);
 		updateSwitchRegisterVal();
 		updateFields();
 	}

	/**
	 * Clears the text area and deselects the switch register buttons
	 */
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
	
	//Not sure if this method is needed
	/**
	 * Loads the data to the MBR at the address indicated in the switch register
	 * loads the MAR with the value in the switch register
	 * loads the MBR with the contents of memory at the location indicated by the MAR
	 */
	public void doAL() {
		//Get the data of Memory.
		updateSwitchRegisterVal();
		//int -> string
		String text="";
		for(int i=0;i<16;i++) {
			text=text+SwitchRegister[i];
		}
		RegisterSet.MAR.Insert(SwitchRegister,0);
		RegisterSet.MBR.Insert(RegisterSet.Memory.Output(RegisterSet.MAR.Output), 0);
		int[] Data= RegisterSet.MBR.Output;
		String text2="";
		if (Data != null) {
			for(int i=0;i<16;i++) {
				text2=text2+Data[i];
			}
			textArea.append("The Memory at Address:["+text+"] is ["+text2+"]\n");
		}else {
			textArea.append("Address Out of range\n");
		}
		updateFields();
	}

	/**
	 * Stores the value of the Switch register to memory at the location indicated by the MAR 
	 */
	public void doDP() {
		//get the input from Switch Register
		updateSwitchRegisterVal();
		//int -> string
		String text="";
		for(int i=0;i<16;i++) {
			text=text+SwitchRegister[i];
		}
		textArea.append("The Data Insert to Memory is:["+text+"]\n");
		
		/*
		 * As the document said. Only when the word is fetched we need the MBR and MAR.	
		 */
		//insert to MBR
		//RegisterSet.MBR.Insert(SwitchRegister,0);
		//textArea.append("MBR<-Input.\n");
		//updateFields();
		//insert to Memory
		
		RegisterSet.Memory.Insert(SwitchRegister, RegisterSet.Memory.Pointer);
		textArea.append("Memory<-Input.\n");
		
		//when we insert instruction, we need to judge whether can insert instruction to cashe too.
		//if(RegisterSet.Cache.Pointer!=15) {
			//RegisterSet.Cache.Insert(SwitchRegister, RegisterSet.Cache.Pointer);
		//}
		/*
		 *We can add Fault Diagnose   
		*/
		textArea.append("The Data:["+text+"] Successfully inserted to Memory ["+(RegisterSet.Memory.Pointer-1)+"].\n");
		updateFields();
	}
	
	/**
	 * Submits the input
	 */
	public void doSubmitInput() {
		RegisterSet.isWaitingForInput = false;
		RegisterSet.INPUT.filter(INPUT.getText());
		INPUT.setText("");
	}
	
	public int[] Get_Instruction() {//Get the Instruction to decoder.
		//Because I think will fetch data from memory repeatedly, I make it a individual function. 
		//MAR<-PC
		RegisterSet.MAR.Insert(RegisterSet.PC.OutputAsInt(),0);
		textArea.append("MAR<-PC.\n");
		updateFields();
		//MBR<-Memory(MAR)
		RegisterSet.MBR.Insert(RegisterSet.Memory.Output(RegisterSet.MAR.Output), 0);
		textArea.append("MBR<-Memory(MAR).\n");
		updateFields();
		//update the PC++
		int tPC=RegisterSet.PC.OutputAsInt();
		if(tPC>RegisterSet.Memory.Height) {
			tPC=6;//start at 6 in memory
		}
		else {
			tPC=tPC+1;
		}
		RegisterSet.PC.Insert(tPC, 0);
		textArea.append("PC++.\n");
		updateFields();
		//IR<-MBR
		RegisterSet.IR.Insert(RegisterSet.MBR.Output(0), 0);
		textArea.append("IR<-MBR.\n");
		updateFields();
		return RegisterSet.IR.Output(0);
		
	}
}
