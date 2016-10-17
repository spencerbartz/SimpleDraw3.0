/* Initializes all GUI components and adds event listeners */

package com.spencerbartz.simpledraw;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.*;

public class SimpleDrawUI extends JFrame
{
	private static final long serialVersionUID = 5166745444359188627L;
	private JDesktopPane desktop;
	private String extensions[] = new	String[] { "gif", "GIF", "jpg", "JPG", "jpeg", "JPEG", "png", "PNG" };

	
	public SimpleDrawUI()
	{
		super("Simple Draw 3.0");
		
		//Our Desktop lives inside this JFrame
		desktop = new JDesktopPane();
		desktop.setBackground(Color.gray);
		getContentPane().add(desktop);
		
		JMenuBar menuBar 			 = new JMenuBar();
		
		JMenu fileMenu 				 = new JMenu("File");
		JMenuItem newMenuItem  = new JMenuItem("New");
		JMenuItem openMenuItem = new JMenuItem("Open");
		JMenuItem exitMenuItem = new JMenuItem("Exit");
		fileMenu.add(newMenuItem);
		fileMenu.add(openMenuItem);
		fileMenu.add(exitMenuItem);
		
		JMenu editMenu	    		= new JMenu("Edit");
		JMenuItem copyMenuItem  = new JMenuItem("Copy");
		JMenuItem cutMenuItem		= new JMenuItem("Cut");
		JMenuItem pasteMenuItem = new JMenuItem("Copy");
		JMenuItem undoMenuItem  = new JMenuItem("Undo");
		JMenuItem redoMenuItem  = new JMenuItem("Redo");
		editMenu.add(copyMenuItem);
		editMenu.add(cutMenuItem);
		editMenu.add(pasteMenuItem);
		editMenu.add(undoMenuItem);
		editMenu.add(redoMenuItem);
		
		JMenu selectMenu = new JMenu("Select");
		JMenuItem allMenuItem = new JMenuItem("All");
		selectMenu.add(allMenuItem);	
		
		JMenu imageMenu = new JMenu("Image");
		JMenuItem rotateCW = new JMenuItem("Rotate 90 degrees clockwise");
		JMenuItem rotateCCW = new JMenuItem("Rotate 90 degrees counter clockwise");
		imageMenu.add(rotateCW);
		imageMenu.add(rotateCCW);
		
		JMenu helpMenu = new JMenu("Help");
		JMenuItem aboutMenuItem = new JMenuItem("About");
		helpMenu.add(aboutMenuItem);
		
		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		menuBar.add(selectMenu);
		menuBar.add(imageMenu);
		menuBar.add(helpMenu);
		setJMenuBar(menuBar);

		// User Clicks File > New
		newMenuItem.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				JInternalFrame frame = new JInternalFrame("Internal Frame", true, true, true, true);
				Container container  = frame.getContentPane();
				InternalPanel panel  = new InternalPanel(400, 400);
				
				JInternalFrame frames[] = desktop.getAllFrames();
				JInternalFrame selected = null;
				
				// Find the top most JInternal frame and offset as to not cover it up
				for(int i = 0; i < frames.length; i++)
					if(frames[i].isSelected())
						frame.setLocation(frames[i].getX() + 20, frames[i].getY() + 20);
				
				container.add(panel);
				frame.pack();
				desktop.add(frame);
				frame.setVisible(true);
			}
		});
		
		// User Clicks File > Open
		openMenuItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				JFileChooser chooser = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files", extensions);
				chooser.setFileFilter(filter);				
				chooser.setDialogTitle("Open Image File");
				int returnVal = chooser.showOpenDialog(SimpleDrawUI.this);
				
				if(returnVal == JFileChooser.APPROVE_OPTION)
				{	
					String filePath = chooser.getSelectedFile().getAbsolutePath();
					File f = new File(filePath);
					
					if(f.exists() && !f.isDirectory() && isImageFile(f))
					{
						BufferedImage openedImage = null;
						
						try
						{
							openedImage = ImageIO.read(new File(filePath));
						}
						catch(IOException IOex)
						{
							JOptionPane.showMessageDialog(null, IOex.toString(), "The file specified could not be read or no longer exists.",
									JOptionPane.ERROR_MESSAGE);
						}
						
						// these guys are still not attacked to desktop
						JInternalFrame frame = new JInternalFrame("" + f.getName(), true, true, true, true);
						Container container  = frame.getContentPane();
						ImageIcon icon = new ImageIcon(openedImage);
						InternalPanel panel  = new InternalPanel(icon.getIconWidth(), icon.getIconHeight());
						JLabel imageLabel = new JLabel(icon);
						panel.add(imageLabel);
						
						// Attach to main app
						container.add(panel);
						frame.pack();
						desktop.add(frame);
						frame.setVisible(true);						
					}
				}
			}	
		});
		
		// User Clicks File > Exit
		exitMenuItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				System.out.println("Exiting...");
				System.exit(0);
			}
		});
		
		// User Clicks Edit > Copy
		copyMenuItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				
			}
		});

		// User Clicks Edit > Cut
		cutMenuItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				
			}
		});
		
		// User Clicks Edit > Paste
		pasteMenuItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				
			}
		});

		// User Clicks Edit > Undo
		undoMenuItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				
			}
		});
		
		// User Clicks Edit > Redo
		redoMenuItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				
			}
		});
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1024, 768);
		setVisible(true);
	}
	
	private boolean isImageFile(File f)
	{
		String filePath = f.getPath();
		String pathParts[] = filePath.split("\\.");
		String extension = pathParts[pathParts.length - 1];
		for(String s : extensions)
			if(s.equals(extension))
				return true;

		System.out.println("NOT AN IMAGE");
		return false;
	}
	
}