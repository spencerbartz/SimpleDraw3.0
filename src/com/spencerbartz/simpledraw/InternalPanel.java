package com.spencerbartz.simpledraw;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JPanel;

public class InternalPanel extends JPanel
{
	private static final long serialVersionUID = 1L;
	private int length;
	private int width;
	private Component component;
	
	public InternalPanel(int length, int width)
	{
		this.length 	 = length;
		this.width 		 = width;
		this.setSize(this.length, this.width);
		setVisible(true);
	}
}
