package graphic_interface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import graphix_backend.Main;
import profile.Profile;

public class ProfileButton extends JButton {
	private static final long serialVersionUID = 1L;
	private Profile p;

	public ProfileButton(Profile p) {
		super();
		this.p = p;
		String label = p.getFirstName() + " " + p.getLastName();
		this.setText(label);
	}

	public void makeActionListener() {
		this.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Main.onProfileButtonPress(p);
			}

		});
	}
}
