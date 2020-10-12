package com.spencerbartz.simpledraw;

import javax.swing.JPanel;

public class InternalPanel extends JPanel {
    private static final long serialVersionUID = 1L;
    private int length;
    private int width;

    public InternalPanel(int length, int width) {
	this.length = length;
	this.width = width;
	this.setSize(this.length, this.width);
	setVisible(true);
    }
}
