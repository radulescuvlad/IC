package graphix_backend;

import java.util.Iterator;
import java.util.Vector;
import profile.Preferences;
import profile_data.Hobbies;
import storage.Range;
import profile_data.*;

public class PrefToText {
	private static final String newline = "<br>";
	private static final String tab = "         ";

	public static String importanceMeaning(int importance) {
		switch (importance) {
		case 0:
			return "Irrelevant";
		case 1:
			return "Minimally relevant";
		case 2:
			return "Somewhat relevant";
		case 3:
			return "Moderately relevant";
		case 4:
			return "Highly relevant";
		case 5:
			return "Mandatory";
		default:
			throw new IllegalStateException();
		}
	}

	public static String write(Preferences p) {
		String s = "<html>";
		Vector<Gender> genderPref = p.getGenderPref();
		Range agePref = p.getAgePref().getTrait();
		Range heightPref = p.getHeightPref().getTrait();
		Vector<EyeColor> eyeColorPref = p.getEyeColorPref().getTrait();
		Vector<HairColor> hairColorPref = p.getHairColorPref().getTrait();
		Vector<Hairstyle> hairstylePref = p.getHairstylePref().getTrait();
		Vector<BodyType> bodyTypePref = p.getBodyTypePref().getTrait();
		Vector<ReligiousBeliefs> religionPref = p.getReligionPref().getTrait();
		Vector<Occupation> occupationPref = p.getOccupationPref().getTrait();
		Vector<Hobbies> hobbiesPref = p.getHobbiesPref().getTrait();
		int ageImportance = p.getAgePref().getImportance();
		int heightImportance = p.getHeightPref().getImportance();
		int eyeColorImportance = p.getEyeColorPref().getImportance();
		int hairColorImportance = p.getHairColorPref().getImportance();
		int hairstyleImportance = p.getHairstylePref().getImportance();
		int bodyTypeImportance = p.getBodyTypePref().getImportance();
		int religionImportance = p.getReligionPref().getImportance();
		int occupationImportance = p.getOccupationPref().getImportance();
		int hobbiesImportance = p.getHobbiesPref().getImportance();
		s += "Interested in: ";
		Iterator<Gender> gi = genderPref.iterator();
		s += EnumToText.convert(gi.next()) + "s";
		if (gi.hasNext())
			s += " or " + EnumToText.convert(gi.next()) + "s";
		s += newline + "Age: " + importanceMeaning(ageImportance);
		if (ageImportance != 0)
			s += newline + tab + agePref.getMin() + " - " + agePref.getMax();
		s += newline + "Height: " + importanceMeaning(heightImportance);
		if (heightImportance != 0)
			s += newline + tab + heightPref.getMin() + " - " + heightPref.getMax();
		s += newline + "Eye color: " + importanceMeaning(eyeColorImportance);
		if (eyeColorImportance != 0) {
			Iterator<EyeColor> eci = eyeColorPref.iterator();
			s += newline + tab;
			while (eci.hasNext()) {
				s += EnumToText.convert(eci.next());
				if (eci.hasNext())
					s += ", ";
			}
			s += ".";
		}
		s += newline + "Hair color: " + importanceMeaning(hairColorImportance);
		if (hairColorImportance != 0) {
			Iterator<HairColor> hci = hairColorPref.iterator();
			s += newline + tab;
			while (hci.hasNext()) {
				s += EnumToText.convert(hci.next());
				if (hci.hasNext())
					s += ", ";
			}
			s += ".";
		}
		s += newline + "Hair style: " + importanceMeaning(hairstyleImportance);
		if (hairstyleImportance != 0) {
			Iterator<Hairstyle> hsi = hairstylePref.iterator();
			s += newline + tab;
			while (hsi.hasNext()) {
				s += EnumToText.convert(hsi.next());
				if (hsi.hasNext())
					s += ", ";
			}
			s += ".";
		}
		s += newline + "Body type: " + importanceMeaning(bodyTypeImportance);
		if (bodyTypeImportance != 0) {
			Iterator<BodyType> bti = bodyTypePref.iterator();
			s += newline + tab;
			while (bti.hasNext()) {
				s += EnumToText.convert(bti.next());
				if (bti.hasNext())
					s += ", ";
			}
			s += ".";
		}
		s += newline + "Religious beliefs: " + importanceMeaning(religionImportance);
		if (religionImportance != 0) {
			Iterator<ReligiousBeliefs> ri = religionPref.iterator();
			s += newline + tab;
			while (ri.hasNext()) {
				s += EnumToText.convert(ri.next());
				if (ri.hasNext())
					s += ", ";
			}
			s += ".";
		}
		s += newline + "Occupation: " + importanceMeaning(occupationImportance);
		if (occupationImportance != 0) {
			Iterator<Occupation> oi = occupationPref.iterator();
			s += newline + tab;
			while (oi.hasNext()) {
				s += EnumToText.convert(oi.next());
				if (oi.hasNext())
					s += ", ";
			}
			s += ".";
		}
		s += newline + "Hobbies: " + importanceMeaning(hobbiesImportance);
		if (hobbiesImportance != 0) {
			Iterator<Hobbies> hi = hobbiesPref.iterator();
			s += newline + tab;
			while (hi.hasNext()) {
				s += EnumToText.convert(hi.next());
				if (hi.hasNext())
					s += ", ";
			}
			s += ".";
		}
		s += "</html>";
		return s;
	}
}
