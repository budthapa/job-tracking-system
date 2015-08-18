package com.budthapa.jts.view.main;

import com.budthapa.jts.helpers.Property;
import javax.swing.SwingUtilities;

public class Application {
	public static void main(String []args){
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
                            new Property().getProperties();
				new LoginPanel().setVisible(true);
			}
		});
	}
}
