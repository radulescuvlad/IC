package storage;

import profile.Profile;

public class Match implements Comparable<Match> {
	private Profile profile;
	private double percentage;

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile p) {
		profile = p;
	}

	public double getPercentage() {
		return percentage;
	}

	public void setPercentage(double p) {
		percentage = p;
	}

	@Override
	public int compareTo(Match arg0) {
		if (this.profile == arg0.profile)
			return 0;
		if (this.percentage > arg0.percentage)
			return -1;
		if (this.percentage < arg0.percentage)
			return 1;
		return 0;
	}
}
