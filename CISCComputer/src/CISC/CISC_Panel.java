package CISC;

import javax.swing.*;
import java.awt.event.*;

public class CISC_Panel {
	
	public static void main(String[] args) {
		
		JFrame f=new JFrame();//The panel
		f.setSize(1000,600);
		
		final JTextArea tf=new JTextArea();
		tf.setBounds(700,0,300,1000);
		
		JButton AL=new JButton("OFF");//Button of Address Load
		AL.setBounds(500,400,60,80);
		JLabel ALL=new JLabel("AL");
		ALL.setBounds(500,360,60,60);
		
		JButton DEP=new JButton("OFF");//Button of Deposit
		DEP.setBounds(560,400,60,80);
		JLabel DEPL=new JLabel("DEP");
		DEPL.setBounds(560,360,60,60);
		
		JButton HLT=new JButton("OFF");//Button of Deposit
		HLT.setBounds(620,400,60,80);
		JLabel HLTL=new JLabel("HLT");
		HLTL.setBounds(620,360,60,60);
		
		
		AL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tf.append("Address Load\n");
				if(AL.getText()=="ON") {
						AL.setText("OFF");
				}
				else {
					AL.setText("ON");
				}
			}
		});
		
		DEP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tf.append("Deposit\n");
				if(DEP.getText()=="ON") {
						AL.setText("OFF");
				}
				else {
					DEP.setText("ON");
				}
			}
		});
		
		HLT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tf.append("Halt\n");
				if(HLT.getText()=="ON") {
						HLT.setText("OFF");
				}
				else {
					HLT.setText("ON");
				}
			}
		});
		
		f.add(AL);
		f.add(ALL);
		f.add(DEP);
		f.add(DEPL);
		f.add(HLT);
		f.add(HLTL);
		f.add(tf);
		
		
		
		f.setLayout(null);
		f.setVisible(true);
		
	}

}
