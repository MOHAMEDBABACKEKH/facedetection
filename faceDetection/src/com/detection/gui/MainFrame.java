package com.detection.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import com.facedetection.algorithme.FaceDetection;
import com.facedetection.constants.Constants;

public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ImagePanel imagePanel;
    private JFileChooser fileChooser;
    private FaceDetection facedetection;
    private File file;
    
    public MainFrame() {
    	
    	super(Constants.APPLICATION_NAME);
    	
    	setJMenuBar(createMenuBar());
    	
    	this.imagePanel=new ImagePanel();
    	this.fileChooser= new JFileChooser();
    	this.facedetection=new FaceDetection();
    	
    	add(imagePanel,BorderLayout.CENTER);
    	
    	setSize(Constants.FRAME_WIDTH,Constants.FRAME_HEIGTH);
    	setVisible(true);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    	setLocationRelativeTo(this);
    }

	public JMenuBar createMenuBar() {
		
		JMenuBar menuBar=new JMenuBar();
		
		JMenu fileMenu =new JMenu("File");
		JMenuItem loadMenuItem=new JMenuItem("Load image");
		JMenuItem detectMenuItem=new JMenuItem("Detect Faces");
		JMenuItem exitMenuItem=new JMenuItem("EXIT");
		fileMenu.add(loadMenuItem);
		fileMenu.add(detectMenuItem);
		fileMenu.add(exitMenuItem);
		
		loadMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if(fileChooser.showOpenDialog(MainFrame.this)==JFileChooser.APPROVE_OPTION) {
					MainFrame.this.file=fileChooser.getSelectedFile();
					//Load image :-D;
					System.out.println(MainFrame.this.file);
					MainFrame.this.imagePanel.loadImage(MainFrame.this.file); 
				}
			}
		} );
		
		detectMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				//detect algo;
				MainFrame.this.facedetection.detectfaces(MainFrame.this.file, MainFrame.this.imagePanel);
			}
		});
		
		JMenu aboutMenu=new JMenu("About");
		JMenu helpMenu=new JMenu("Help");
		menuBar.add(fileMenu);
		menuBar.add(aboutMenu);
		menuBar.add(helpMenu);
		exitMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int action= JOptionPane.showConfirmDialog(MainFrame.this,Constants.EXIT_WARNNING,"WARRNING",JOptionPane.YES_NO_OPTION);
				if(action==JOptionPane.OK_OPTION) {
					System.gc();
					System.exit(0);
				}
				
			}
			
		});
		
		
			
	return menuBar;
	}
    
}
