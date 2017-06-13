package profile;

import profile_data.*;
import java.util.Vector;

import graphix_backend.PrefToText;
import storage.*;

public class Preferences {

	private Vector<Gender> genderPref;
	private Pref<Range> agePref;
	private Pref<Range> heightPref;
	private Pref<Vector<EyeColor>> eyeColorPref;
	private Pref<Vector<HairColor>> hairColorPref;
	private Pref<Vector<Hairstyle>> hairstylePref;
	private Pref<Vector<BodyType>> bodyTypePref;
	private Pref<Vector<ReligiousBeliefs>> religionPref;
	private Pref<Vector<Occupation>> occupationPref;
	private Pref<Vector<Hobbies>> hobbiesPref;

	@Override
	public String toString() {
		return PrefToText.write(this);
	}

	public double maxScore() {
		double score = 0;
		score += agePref.score();
		score += heightPref.score();
		score += eyeColorPref.score();
		score += hairColorPref.score();
		score += hairstylePref.score();
		score += bodyTypePref.score();
		score += religionPref.score();
		score += occupationPref.score();
		score += hobbiesPref.score();
		return score;
	}

	public double ageScore() {
		return agePref.score();
	}

	public double heightScore() {
		return heightPref.score();
	}

	public double eyeColorScore() {
		return eyeColorPref.score();
	}

	public double hairColorScore() {
		return hairColorPref.score();
	}

	public double hairstyleScore() {
		return hairstylePref.score();
	}

	public double bodyTypeScore() {
		return bodyTypePref.score();
	}

	public double religionScore() {
		return religionPref.score();
	}

	public double occupationScore() {
		return occupationPref.score();
	}

	public double hobbiesScore() {
		return hobbiesPref.score();
	}

	public Vector<Gender> getGenderPref() {
		return genderPref;
	}

	public void setGenderPref(Vector<Gender> genderPref) {
		this.genderPref = genderPref;
	}

	public Pref<Range> getAgePref() {
		return agePref;
	}

	public void setAgePref(Pref<Range> agePref) {
		this.agePref = agePref;
	}

	public Pref<Range> getHeightPref() {
		return heightPref;
	}

	public void setHeightPref(Pref<Range> heightPref) {
		this.heightPref = heightPref;
	}

	public Pref<Vector<EyeColor>> getEyeColorPref() {
		return eyeColorPref;
	}

	public void setEyeColorPref(Pref<Vector<EyeColor>> eyeColorPref) {
		this.eyeColorPref = eyeColorPref;
	}

	public Pref<Vector<HairColor>> getHairColorPref() {
		return hairColorPref;
	}

	public void setHairColorPref(Pref<Vector<HairColor>> hairColorPref) {
		this.hairColorPref = hairColorPref;
	}

	public Pref<Vector<Hairstyle>> getHairstylePref() {
		return hairstylePref;
	}

	public void setHairstylePref(Pref<Vector<Hairstyle>> hairstylePref) {
		this.hairstylePref = hairstylePref;
	}

	public Pref<Vector<BodyType>> getBodyTypePref() {
		return bodyTypePref;
	}

	public void setBodyTypePref(Pref<Vector<BodyType>> bodyTypePref) {
		this.bodyTypePref = bodyTypePref;
	}

	public Pref<Vector<ReligiousBeliefs>> getReligionPref() {
		return religionPref;
	}

	public void setReligionPref(Pref<Vector<ReligiousBeliefs>> religionPref) {
		this.religionPref = religionPref;
	}

	public Pref<Vector<Occupation>> getOccupationPref() {
		return occupationPref;
	}

	public void setOccupationPref(Pref<Vector<Occupation>> occupationPref) {
		this.occupationPref = occupationPref;
	}

	public Pref<Vector<Hobbies>> getHobbiesPref() {
		return hobbiesPref;
	}

	public void setHobbiesPref(Pref<Vector<Hobbies>> hobbiesPref) {
		this.hobbiesPref = hobbiesPref;
	}
}
