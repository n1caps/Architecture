package CISC;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class FrontPanel extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrontPanel frame = new FrontPanel();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrontPanel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel lblPC = new JLabel("PC");
		contentPane.add(lblPC, "2, 2");
		
		JRadioButton radioButton = new JRadioButton("");
		contentPane.add(radioButton, "4, 2");
		
		JRadioButton radioButton_1 = new JRadioButton("");
		contentPane.add(radioButton_1, "6, 2");
		
		JRadioButton radioButton_2 = new JRadioButton("");
		contentPane.add(radioButton_2, "8, 2");
		
		JRadioButton radioButton_3 = new JRadioButton("");
		contentPane.add(radioButton_3, "10, 2");
		
		JRadioButton radioButton_4 = new JRadioButton("");
		contentPane.add(radioButton_4, "12, 2");
		
		JRadioButton radioButton_5 = new JRadioButton("");
		contentPane.add(radioButton_5, "14, 2");
		
		JRadioButton radioButton_6 = new JRadioButton("");
		contentPane.add(radioButton_6, "16, 2");
		
		JRadioButton radioButton_7 = new JRadioButton("");
		contentPane.add(radioButton_7, "18, 2");
		
		JRadioButton radioButton_8 = new JRadioButton("");
		contentPane.add(radioButton_8, "20, 2");
		
		JRadioButton radioButton_9 = new JRadioButton("");
		contentPane.add(radioButton_9, "22, 2");
		
		JRadioButton radioButton_10 = new JRadioButton("");
		contentPane.add(radioButton_10, "24, 2");
		
		JRadioButton radioButton_11 = new JRadioButton("");
		contentPane.add(radioButton_11, "26, 2");
		
		JLabel lblMar = new JLabel("MAR");
		contentPane.add(lblMar, "2, 4");
		
		JRadioButton radioButton_20 = new JRadioButton("");
		contentPane.add(radioButton_20, "4, 4");
		
		JRadioButton radioButton_21 = new JRadioButton("");
		contentPane.add(radioButton_21, "6, 4");
		
		JRadioButton radioButton_22 = new JRadioButton("");
		contentPane.add(radioButton_22, "8, 4");
		
		JRadioButton radioButton_23 = new JRadioButton("");
		contentPane.add(radioButton_23, "10, 4");
		
		JRadioButton radioButton_24 = new JRadioButton("");
		contentPane.add(radioButton_24, "12, 4");
		
		JRadioButton radioButton_25 = new JRadioButton("");
		contentPane.add(radioButton_25, "14, 4");
		
		JRadioButton radioButton_26 = new JRadioButton("");
		contentPane.add(radioButton_26, "16, 4");
		
		JRadioButton radioButton_27 = new JRadioButton("");
		contentPane.add(radioButton_27, "18, 4");
		
		JRadioButton radioButton_28 = new JRadioButton("");
		contentPane.add(radioButton_28, "20, 4");
		
		JRadioButton radioButton_29 = new JRadioButton("");
		contentPane.add(radioButton_29, "22, 4");
		
		JRadioButton radioButton_30 = new JRadioButton("");
		contentPane.add(radioButton_30, "24, 4");
		
		JRadioButton radioButton_31 = new JRadioButton("");
		contentPane.add(radioButton_31, "26, 4");
		
		JRadioButton radioButton_35 = new JRadioButton("");
		contentPane.add(radioButton_35, "28, 4");
		
		JRadioButton radioButton_32 = new JRadioButton("");
		contentPane.add(radioButton_32, "30, 4");
		
		JRadioButton radioButton_33 = new JRadioButton("");
		contentPane.add(radioButton_33, "32, 4");
		
		JRadioButton radioButton_34 = new JRadioButton("");
		contentPane.add(radioButton_34, "34, 4");
		
		JLabel lblMbr = new JLabel("MBR");
		contentPane.add(lblMbr, "2, 6");
		
		JRadioButton radioButton_36 = new JRadioButton("");
		contentPane.add(radioButton_36, "4, 6");
		
		JRadioButton radioButton_37 = new JRadioButton("");
		contentPane.add(radioButton_37, "6, 6");
		
		JRadioButton radioButton_38 = new JRadioButton("");
		contentPane.add(radioButton_38, "8, 6");
		
		JRadioButton radioButton_39 = new JRadioButton("");
		contentPane.add(radioButton_39, "10, 6");
		
		JRadioButton radioButton_40 = new JRadioButton("");
		contentPane.add(radioButton_40, "12, 6");
		
		JRadioButton radioButton_41 = new JRadioButton("");
		contentPane.add(radioButton_41, "14, 6");
		
		JRadioButton radioButton_42 = new JRadioButton("");
		contentPane.add(radioButton_42, "16, 6");
		
		JRadioButton radioButton_43 = new JRadioButton("");
		contentPane.add(radioButton_43, "18, 6");
		
		JRadioButton radioButton_44 = new JRadioButton("");
		contentPane.add(radioButton_44, "20, 6");
		
		JRadioButton radioButton_45 = new JRadioButton("");
		contentPane.add(radioButton_45, "22, 6");
		
		JRadioButton radioButton_46 = new JRadioButton("");
		contentPane.add(radioButton_46, "24, 6");
		
		JRadioButton radioButton_47 = new JRadioButton("");
		contentPane.add(radioButton_47, "26, 6");
		
		JRadioButton radioButton_48 = new JRadioButton("");
		contentPane.add(radioButton_48, "28, 6");
		
		JRadioButton radioButton_49 = new JRadioButton("");
		contentPane.add(radioButton_49, "30, 6");
		
		JRadioButton radioButton_50 = new JRadioButton("");
		contentPane.add(radioButton_50, "32, 6");
		
		JRadioButton radioButton_51 = new JRadioButton("");
		contentPane.add(radioButton_51, "34, 6");
		
		JLabel lblCc = new JLabel("CC");
		contentPane.add(lblCc, "2, 8");
		
		JRadioButton radioButton_12 = new JRadioButton("");
		contentPane.add(radioButton_12, "4, 8");
		
		JRadioButton radioButton_13 = new JRadioButton("");
		contentPane.add(radioButton_13, "6, 8");
		
		JRadioButton radioButton_14 = new JRadioButton("");
		contentPane.add(radioButton_14, "8, 8");
		
		JRadioButton radioButton_15 = new JRadioButton("");
		contentPane.add(radioButton_15, "10, 8");
		
		JLabel lblMfr = new JLabel("MFR");
		contentPane.add(lblMfr, "2, 10");
		
		JRadioButton radioButton_16 = new JRadioButton("");
		contentPane.add(radioButton_16, "4, 10");
		
		JRadioButton radioButton_17 = new JRadioButton("");
		contentPane.add(radioButton_17, "6, 10");
		
		JRadioButton radioButton_18 = new JRadioButton("");
		contentPane.add(radioButton_18, "8, 10");
		
		JRadioButton radioButton_19 = new JRadioButton("");
		contentPane.add(radioButton_19, "10, 10");
		
		JLabel lblIr = new JLabel("IR");
		contentPane.add(lblIr, "2, 12");
		
		JRadioButton radioButton_52 = new JRadioButton("");
		contentPane.add(radioButton_52, "4, 12");
		
		JRadioButton radioButton_53 = new JRadioButton("");
		contentPane.add(radioButton_53, "6, 12");
		
		JRadioButton radioButton_54 = new JRadioButton("");
		contentPane.add(radioButton_54, "8, 12");
		
		JRadioButton radioButton_55 = new JRadioButton("");
		contentPane.add(radioButton_55, "10, 12");
		
		JRadioButton radioButton_56 = new JRadioButton("");
		contentPane.add(radioButton_56, "12, 12");
		
		JRadioButton radioButton_57 = new JRadioButton("");
		contentPane.add(radioButton_57, "14, 12");
		
		JRadioButton radioButton_58 = new JRadioButton("");
		contentPane.add(radioButton_58, "16, 12");
		
		JRadioButton radioButton_59 = new JRadioButton("");
		contentPane.add(radioButton_59, "18, 12");
		
		JRadioButton radioButton_60 = new JRadioButton("");
		contentPane.add(radioButton_60, "20, 12");
		
		JRadioButton radioButton_61 = new JRadioButton("");
		contentPane.add(radioButton_61, "22, 12");
		
		JRadioButton radioButton_62 = new JRadioButton("");
		contentPane.add(radioButton_62, "24, 12");
		
		JRadioButton radioButton_63 = new JRadioButton("");
		contentPane.add(radioButton_63, "26, 12");
		
		JRadioButton radioButton_64 = new JRadioButton("");
		contentPane.add(radioButton_64, "28, 12");
		
		JRadioButton radioButton_65 = new JRadioButton("");
		contentPane.add(radioButton_65, "30, 12");
		
		JRadioButton radioButton_66 = new JRadioButton("");
		contentPane.add(radioButton_66, "32, 12");
		
		JRadioButton radioButton_67 = new JRadioButton("");
		contentPane.add(radioButton_67, "34, 12");
	}

}
