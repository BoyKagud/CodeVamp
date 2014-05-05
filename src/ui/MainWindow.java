package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;
import javax.swing.JScrollPane;

public class MainWindow extends JFrame {

	private JPanel contentPane;
	JPanel panel;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
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
	public MainWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.controlHighlight);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		panel_3.setBackground(SystemColor.controlHighlight);
		contentPane.add(panel_3, BorderLayout.NORTH);
		
		JButton btnAddNewProject = new JButton("Add New Project");
		panel_3.add(btnAddNewProject);
		
		scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setBackground(SystemColor.controlHighlight);
		panel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		
		panel.addContainerListener(new ContainerListener() {
			
			@Override
			public void componentRemoved(ContainerEvent e) {
				panel.invalidate();				
			}
			
			@Override
			public void componentAdded(ContainerEvent e) {
				panel.invalidate();
			}
		});

		panel.add(new ProjectDiv("MP1-CS1DAY", "Jan 10, 2014", constants.SupportedLanguages.C, true));
		panel.add(new ProjectDiv("MP2-CS1DAY", "Jan 22, 2014", constants.SupportedLanguages.C, false));
		panel.add(new ProjectDiv("MP1-CS2DAY", "Jan 22, 2014", constants.SupportedLanguages.JAVA, false));
		panel.add(new ProjectDiv("MP1-CS2EVE", "Jan 28, 2014", constants.SupportedLanguages.JAVA, false));
		panel.add(new ProjectDiv("MP1-CS1DAY", "Jan 10, 2014", constants.SupportedLanguages.C, true));
		panel.add(new ProjectDiv("MP2-CS1DAY", "Jan 22, 2014", constants.SupportedLanguages.C, false));
		panel.add(new ProjectDiv("MP1-CS2DAY", "Jan 22, 2014", constants.SupportedLanguages.JAVA, false));
		panel.add(new ProjectDiv("MP1-CS2EVE", "Jan 28, 2014", constants.SupportedLanguages.JAVA, false));
		panel.add(new ProjectDiv("MP1-CS1DAY", "Jan 10, 2014", constants.SupportedLanguages.C, true));
		panel.add(new ProjectDiv("MP2-CS1DAY", "Jan 22, 2014", constants.SupportedLanguages.C, false));
		panel.add(new ProjectDiv("MP1-CS2DAY", "Jan 22, 2014", constants.SupportedLanguages.JAVA, false));
		panel.add(new ProjectDiv("MP1-CS2EVE", "Jan 28, 2014", constants.SupportedLanguages.JAVA, false));
	}
		
	class ProjectDiv extends JPanel implements MouseListener {
		ProjectDiv cur;
		int projectID;
		String projectTitle;
		String projectDeadline;
		String language;
		LineBorder lineBorder = null;

		class PopUp extends JPopupMenu{
		    JMenuItem edit;
		    JMenuItem delete;
		    public PopUp(){
		    	// add 2 items in the menu, rename, delete
		    	edit = new JMenuItem("Edit");
			    delete = new JMenuItem("Delete");
		        add(edit);
		        add(delete);		
		    }
		}
		
		ProjectDiv(String title, String dueDate, String lang, boolean isDue) {
			projectTitle = title;
			projectDeadline = dueDate;
			language = lang;
			cur = this;
	        setCursor(new Cursor(Cursor.HAND_CURSOR));
	        addMouseListener(this);
	        
	        if(isDue)
	        	lineBorder = new LineBorder(new Color(238, 100, 100), 3, true);
	        setBorder(lineBorder);	        
        	setBackground(new Color(238, 238, 238));
			
			setBounds(0, 0, 100, 200);
			setPreferredSize(new Dimension(100, 200));
			setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
			
			ImageIcon ii1 = new ImageIcon("img/x.png");
			int logoWidth1 = 15;
			int logoHeight1 = (int) Math.ceil(((double)logoWidth1 / ii1.getIconWidth()) * (ii1.getIconHeight()));
			
			final JPanel panel_6 = new JPanelWithBgImage(ii1);
			panel_6.setOpaque(false);
			panel_6.setBounds(0, 0, logoWidth1, logoHeight1);
			panel_6.setPreferredSize(new Dimension(logoWidth1, logoHeight1));
			
			panel_6.addMouseListener(new MouseAdapter() {
				@Override
			    public void mouseReleased(java.awt.event.MouseEvent e) {
					int selectedOption = JOptionPane.showConfirmDialog(null, 
                            "Are you sure you want to delete this project?", 
                            "Confirm", 
                            JOptionPane.YES_NO_OPTION); 
							if (selectedOption == JOptionPane.YES_OPTION) {
								//TODO: ADD LISTENER
								panel.setEnabled(false);
								panel.remove(cur);
								panel.setEnabled(true);
							}
				}
			});
			
			JPanel panelo = new JPanel();
			FlowLayout flowLayout_1 = (FlowLayout) panelo.getLayout();
			flowLayout_1.setAlignment(FlowLayout.RIGHT);
			add(panelo);
			panelo.add(panel_6);
			

			ImageIcon ii = new ImageIcon("img/"+language+".png");
			int logoWidth = 100;
			int logoHeight = (int) Math.ceil(((double)logoWidth / ii.getIconWidth()) * (ii.getIconHeight()));
			
			JPanel panel_5 = new JPanel();
			add(panel_5);
			final JPanel logoOnFrame = new JPanelWithBgImage(ii);
			FlowLayout flowLayout = (FlowLayout) logoOnFrame.getLayout();
			flowLayout.setAlignOnBaseline(true);
			
			logoOnFrame.setOpaque(false);
			logoOnFrame.setBounds(0, 0, logoWidth, logoHeight);
			logoOnFrame.setPreferredSize(new Dimension(logoWidth, logoHeight));
			panel_5.add(logoOnFrame);
			
			JPanel panel_2 = new JPanel();
			panel_2.setBackground(new Color(238, 238, 238));
			add(panel_2);
			panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.Y_AXIS));
			
			JPanel panel_4 = new JPanel();
			panel_2.add(panel_4);
			
			JLabel lblNewLabel = new JLabel(projectTitle);
			panel_2.add(lblNewLabel);
			
			JLabel lblNewLabel_1 = new JLabel(projectDeadline);
			panel_2.add(lblNewLabel_1);
		}

		@Override
		public void mouseClicked(MouseEvent e) {			
		}

		@Override
		public void mousePressed(MouseEvent e) {
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			new ProjectWindow(language, projectTitle, projectDeadline).setVisible(true);
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		}

		@Override
		public void mouseExited(MouseEvent e) {
			setBorder(lineBorder);
		}
	}
}
