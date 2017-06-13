package graphix_backend;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Collections;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import generators.ProfileGenerator;
import graphic_interface.BackButton;
import graphic_interface.FindMatchesButton;
import graphic_interface.MatchButton;
import graphic_interface.ProfileButton;
import graphic_interface.ShowPrefButton;
import profile.Profile;
import storage.Match;

public class Main {
	private static final int number = 200;
	private static final int profilesShared = 5;
	private static final int matchesShown = 10;
	
	private static Vector<Profile> profiles;
	private static Vector<Match> matches;
	
	private static JFrame frame;
	
	private static JPanel profilesPanel = null;
	private static JPanel matchPanel=null;
	
	private static JPanel profileButtons = null;
	private static ProfileButton[] pbs;
	
	private static JPanel profileText = null;
	private static JLabel textLabel;
	
	private static JPanel prefAndMatch = null;
	private static BackButton back;
	private static FindMatchesButton find;
	private static ShowPrefButton pref;
	
	private static JPanel matchList = null;
	private static MatchButton[] mb;
	
	public static void main(String[] args) {
		setup();
	}
	
	private static void setup() {
		makeProfiles();
		
		Iterator<Profile> itr = profiles.iterator();
		pbs = new ProfileButton[profilesShared];
		profileButtons = new JPanel(new GridLayout());
		for (int i = 0; i < profilesShared; ++i) {
			pbs[i] = new ProfileButton(itr.next());
			pbs[i].makeActionListener();
			profileButtons.add(pbs[i]);
		}
		
		profileText = new JPanel(new BorderLayout());
		textLabel = new JLabel("Select a Profile");
		profileText.add(textLabel);
		
		frame = new JFrame("The Match Maker");
		
		profilesPanel = new JPanel(new GridLayout(3, 0));
		profilesPanel.add(profileButtons);
		profilesPanel.add(profileText);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(profilesPanel);
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void onMatchPress(Profile p) {
		JOptionPane.showMessageDialog(frame, p.toString());
	}
	
	public static void onBackButtonPress() {
		frame.getContentPane().removeAll();
		frame.getContentPane().add(profilesPanel);
		mb = null;
		matchList = null;
		matchPanel = null;
		back = null;
		frame.pack();
	}
	
	public static void onFindMatchesPress(Profile p) {
		makeMatchesFor(p);
		shareMatches();
		back = new BackButton();
		back.makeActionListener();
		matchPanel = new JPanel();
		matchPanel.add(matchList);
		matchPanel.add(back);
		frame.getContentPane().removeAll();
		frame.getContentPane().add(matchPanel);
		frame.pack();
	}
	
	public static void onShowPreferencesPress(Profile p) {
		JOptionPane.showMessageDialog(frame, p.getMatchPref().toString());
	}
	
	public static void onProfileButtonPress(Profile p) {
		profileText.remove(textLabel);
		textLabel = new JLabel(p.toString());
		profileText.add(textLabel);
		if (prefAndMatch != null) {
			profilesPanel.remove(prefAndMatch);
			prefAndMatch.removeAll();
			find = null;
			pref = null;
		}
		find = new FindMatchesButton(p);
		find.makeActionListener();
		pref = new ShowPrefButton(p);
		pref.makeActionListener();
		prefAndMatch = new JPanel(new GridLayout());
		prefAndMatch.add(pref);
		prefAndMatch.add(find);
		profilesPanel.add(prefAndMatch);
		frame.getContentPane().add(profilesPanel);
		frame.pack();
	}
	
	private static void makeMatchesFor(Profile p) {
		matches = new Vector<Match>();
		Iterator<Profile> i = profiles.iterator();
		while (i.hasNext()) {
			Profile r = i.next();
			if (p != r) {
				Match m = p.computeMatch(r);
				if (m.getPercentage() >= 0.1)
				matches.addElement(m);
			}
		}
		Collections.sort(matches);
		// The Comparator of Match is set so that the sorting of this collection.
	}

	private static void makeProfiles() {
		profiles = new Vector<Profile>();
		for (int i = 0; i < number; ++i) {
			profiles.add(ProfileGenerator.get());
		}
	}

	private static void shareMatches() {
		Iterator<Match> itr = matches.iterator();
		mb = new MatchButton[matchesShown];
		matchList = new JPanel(new GridLayout(10, 0));
		for (int i = 0; i < matchesShown; ++i) {
			Match m = itr.next();
			Profile p = m.getProfile();
			String s = p.getFirstName() + " " + p.getLastName() + ": ";
			s += Math.floor(m.getPercentage() * 1000) / 10;
			s += "% match";
			mb[i] = new MatchButton(p);
			mb[i].setText(s);
			mb[i].makeActionListener();
			matchList.add(mb[i]);
		}
	}
}
