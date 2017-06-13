package profile;

import java.util.Iterator;
import java.util.Vector;

import graphix_backend.ProfileToText;
import storage.Match;
import profile_data.*;

public class Profile {
	private String firstName;
	private String lastName;
	private String email;
	private Gender gender;
	private int age;
	private int height;
	private EyeColor eyeColor;
	private HairColor hairColor;
	private Hairstyle hairstyle;
	private BodyType body;
	private int kids;
	// This variable is differently interpreted according to its value:
	// kids > 0 means the person has this many kids
	// kids = 0 means the person does not have kids, but wants to
	// kids < 0 means the person does not have or want kids
	private ReligiousBeliefs religion;
	private Occupation occupation;
	private Vector<Hobbies> hobbies;
	private Preferences matchPref;

	private boolean isFundamentallyIncompatibleWith(Profile p) {
		if (this.kids < 0 && p.kids >= 0)
			return true;
		if (this.kids >= 0 && p.kids < 0)
			return true;
		if (this.matchPref.getGenderPref().contains(p.gender))
			if (p.matchPref.getGenderPref().contains(this.gender))
				return false;
		return true;
	}

	private int intersection(Vector<?> arg0, Vector<?> arg1) {
		int found = 0;
		if ((arg0 != null) && (arg1 != null)) {
			Iterator<?> i = arg0.iterator();
			while (i.hasNext())
				if (arg1.contains(i.next()))
					++found;
		}
		return found;
	}

	private double computePScore(Profile p) {
		double score = 0;
		int intersectionResult;
		Preferences pref = this.matchPref;
		if (pref.getAgePref().matters())
			if (pref.getAgePref().getTrait().between(p.age))
				score += pref.ageScore();
		if (pref.getHeightPref().matters())
			if (pref.getHeightPref().getTrait().between(p.height))
				score += pref.heightScore();
		if (pref.getEyeColorPref().matters())
			if (pref.getEyeColorPref().getTrait().contains(p.eyeColor))
				score += pref.eyeColorScore();
		if (pref.getHairColorPref().matters())
			if (pref.getHairColorPref().getTrait().contains(p.hairColor))
				score += pref.hairColorScore();
		if (pref.getHairstylePref().matters())
			if (pref.getHairstylePref().getTrait().contains(p.hairstyle))
				score += pref.hairstyleScore();
		if (pref.getBodyTypePref().matters())
			if (pref.getBodyTypePref().getTrait().contains(p.body))
				score += pref.bodyTypeScore();
		if (pref.getReligionPref().matters())
			if (pref.getReligionPref().getTrait().contains(p.religion))
				score += pref.religionScore();
		if (pref.getOccupationPref().matters())
			if (pref.getOccupationPref().getTrait().contains(p.occupation))
				score += pref.occupationScore();
		if (pref.getHobbiesPref().matters()) {
			intersectionResult = intersection(pref.getHobbiesPref().getTrait(), p.hobbies);
			score += ((double) intersectionResult / pref.getHobbiesPref().getTrait().size()) * pref.hobbiesScore();
		}
		return score;
	}

	public Match computeMatch(Profile p) {
		Match m = new Match();
		double pScore;
		double scoreMax;
		double p1, p2;
		m.setProfile(p);
		if (this.isFundamentallyIncompatibleWith(p)) {
			m.setPercentage(0);
			return m;
		}
		scoreMax = this.matchPref.maxScore();
		if (scoreMax == 0)
			p1 = 1;
		else {
			pScore = computePScore(p);
			p1 = pScore / scoreMax;
		}
		scoreMax = p.matchPref.maxScore();
		if (scoreMax == 0)
			p2 = 1;
		else {
			pScore = p.computePScore(this);
			p2 = pScore / scoreMax;
		}
		m.setPercentage(Math.sqrt(p1 * p2));
		return m;
	}

	@Override
	public String toString() {
		return ProfileToText.write(this);
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public EyeColor getEyeColor() {
		return eyeColor;
	}

	public void setEyeColor(EyeColor eyeColor) {
		this.eyeColor = eyeColor;
	}

	public HairColor getHairColor() {
		return hairColor;
	}

	public void setHairColor(HairColor hairColor) {
		this.hairColor = hairColor;
	}

	public Hairstyle getHairstyle() {
		return hairstyle;
	}

	public void setHairstyle(Hairstyle hairstyle) {
		this.hairstyle = hairstyle;
	}

	public BodyType getBody() {
		return body;
	}

	public void setBody(BodyType body) {
		this.body = body;
	}

	public int getKids() {
		return kids;
	}

	public void setKids(int kids) {
		this.kids = kids;
	}

	public ReligiousBeliefs getReligion() {
		return religion;
	}

	public void setReligion(ReligiousBeliefs religion) {
		this.religion = religion;
	}

	public Occupation getOccupation() {
		return occupation;
	}

	public void setOccupation(Occupation occupation) {
		this.occupation = occupation;
	}

	public Preferences getMatchPref() {
		return matchPref;
	}

	public void setMatchPref(Preferences matchPref) {
		this.matchPref = matchPref;
	}

	public Vector<Hobbies> getHobbies() {
		return hobbies;
	}

	public void setHobbies(Vector<Hobbies> hobbies) {
		this.hobbies = hobbies;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
