package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JMenuBar;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProjectWindow extends JFrame {

	private JPanel contentPane;
	private String language;
	private String title;
	private String dueDate;
	private JTable table;
	
	/**
	 * Create the frame.
	 */
	public ProjectWindow(String lang, String name, String deadline) {
		language = lang; title = name; dueDate = deadline;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		ImageIcon ii = new ImageIcon("img/"+language+".png");
		int logoWidth = 100;
		int logoHeight = (int) Math.ceil(((double)logoWidth / ii.getIconWidth()) * (ii.getIconHeight()));
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JPanel panel_5 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_5.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel.add(panel_5);
		
		JPanelWithBgImage panel_2 = new JPanelWithBgImage(ii);
		panel_5.add(panel_2);
		
		panel_2.setOpaque(false);
		panel_2.setBounds(0, 0, logoWidth, logoHeight);
		panel_2.setPreferredSize(new Dimension(logoWidth, logoHeight));
		
		Component rigidArea = Box.createRigidArea(new Dimension(80, 80));
		panel_5.add(rigidArea);
		
		JPanel panel_3 = new JPanel();
		panel_5.add(panel_3);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.Y_AXIS));
		
		JPanel panel_4 = new JPanel();
		panel_3.add(panel_4);
		panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.Y_AXIS));
		
		JLabel pTitle = new JLabel("Project Title: "+title);
		pTitle.setHorizontalAlignment(SwingConstants.LEFT);
		pTitle.setFont(new Font("Dialog", Font.BOLD, 14));
		panel_4.add(pTitle);
		
		JLabel pDueDate = new JLabel("Project Deadline: "+deadline);
		panel_4.add(pDueDate);
		
		Component rigidArea_1 = Box.createRigidArea(new Dimension(40, 40));
		panel_5.add(rigidArea_1);
		
		JPanel panel_1 = new JPanel();
		panel_5.add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
		
		JButton btnEditInputs = new JButton("Edit Inputs");
		btnEditInputs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_1.add(btnEditInputs);
		
		JButton btnEditOutput = new JButton("Edit Output");
		panel_1.add(btnEditOutput);
		
		JPanel panel_6 = new JPanel();
		panel.add(panel_6);
		panel_6.setLayout(new BoxLayout(panel_6, BoxLayout.X_AXIS));
		
		JLabel lblNewLabel = new JLabel("Current Submissions");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 16));
		panel_6.add(lblNewLabel);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		panel_6.add(horizontalStrut);
		
		JButton btnStartEvaluation = new JButton("Start Evaluation");
		panel_6.add(btnStartEvaluation);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column"
			}
		));
		scrollPane.setViewportView(table);
	}

}
