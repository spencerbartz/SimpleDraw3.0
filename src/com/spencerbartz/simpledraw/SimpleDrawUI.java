package com.spencerbartz.simpledraw;

import javax.swing.JFrame;

public class SimpleDrawUI extends JFrame
{
	private static final long serialVersionUID = 1L;

	public SimpleDrawUI()
	{
		setSize(500,500);
		setVisible(true);
	}
}

/*
package com.spencerbartz.simpledraw;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.filechooser.FileNameExtensionFilter;

public class SimpleDrawUI extends JFrame
{
	private static final long serialVersionUID = 1L;
	private JDesktopPane desktop;

	public SimpleDrawUI()
	{
		// 50 pixel border on each side
		int inset = 50;
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(inset, inset, screenSize.width - inset * 2, screenSize.height - inset * 2);

		//Top Menu Bar
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		//File Menu
		JMenu fileMenu = new JMenu("File");
		
		//File New
		JMenuItem newItem = new JMenuItem("New");
		newItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				MenuFrame menuFrame = new MenuFrame();
				menuFrame.setVisible(true);
				desktop.add(menuFrame);
			}
		});
		
		//File > Open
		JMenuItem openItem = new JMenuItem("Open");
		openItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				JFileChooser chooser = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF Images", "jpg", "gif");
				chooser.setFileFilter(filter);
				int returnVal = chooser.showOpenDialog(SimpleDrawUI.this);
				if(returnVal == JFileChooser.APPROVE_OPTION) 
					System.out.println("You chose to open this file: " + chooser.getSelectedFile().getName());
			}
		});
		
		// File > Exit
		JMenuItem exitItem = new JMenuItem("Exit");
		exitItem.addActionListener(new ActionListener()
		{	
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
			}
		});
		
		fileMenu.add(newItem);
		fileMenu.add(openItem);
		fileMenu.add(exitItem);
		
		//Edit Menu
		JMenu editMenu = new JMenu("Edit");
		
		//Select Menu
		JMenu selectMenu = new JMenu("Select");
		JMenuItem allItem = new JMenuItem("All");
		
		//Attach menus to Top Menu Bar
		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		menuBar.add(selectMenu);
			
		// Set up the GUI.
		desktop = new JDesktopPane(); // a specialized layered pane
		setContentPane(desktop);

		// Make dragging a little faster but perhaps uglier.
		desktop.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
*/