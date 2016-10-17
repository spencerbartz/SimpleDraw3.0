/* Driver Class for the whole app */

package com.spencerbartz.simpledraw;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class SimpleDraw 
{
	public static void main(String [] args)
	{
		try 
		{
	    UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
			//UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} 
		catch(UnsupportedLookAndFeelException e) 
		{
			e.printStackTrace();
		}
		catch(ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		catch(InstantiationException e) 
		{
			e.printStackTrace();
		}
		catch (IllegalAccessException e) 
		{
			e.printStackTrace();
		}
		
    javax.swing.SwingUtilities.invokeLater(new Runnable() 
    {
      public void run() 
      {
    		//Main Entry point to the app
    		new SimpleDrawUI();
      }
    });
	}
}