package graphic_interface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import graphix_backend.Main;

public class BackButton extends JButton {
	private static final long serialVersionUID = 1L;

	public BackButton() {
		super();
		this.setText("Back");
	}

	public void makeActionListener() {
		this.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Main.onBackButtonPress();
			}
		});
	}
}
