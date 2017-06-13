package generators;

import profile.*;
import storage.*;
import profile_data.*;
import java.util.Random;
import java.util.Vector;

public class PreferenceGenerator {
	@SuppressWarnings("unused")
	private static final int genderLen = Gender.values().length;
	private static final int eyeColorLen = EyeColor.values().length;
	private static final int bodyTypeLen = BodyType.values().length;
	private static final int hairColorLen = HairColor.values().length;
	private static final int hairstyleLen = Hairstyle.values().length;
	private static final int hobbiesLen = Hobbies.values().length;
	private static final int occupationLen = Occupation.values().length;

	static Preferences get(Profile p) {
		Random rand = RNG.getRand();
		Preferences prefer = new Preferences();
		Vector<Gender> genderPref = new Vector<Gender>();
		Range agePref = new Range(p.getAge() / 2 + 9, (p.getAge() - 9) * 2);
		Range heightPref = new Range(p.getHeight() / 2 + 60, (p.getHeight() - 60) * 2);
		Vector<EyeColor> eyeColorPref = new Vector<EyeColor>();
		Vector<HairColor> hairColorPref = new Vector<HairColor>();
		Vector<Hairstyle> hairstylePref = new Vector<Hairstyle>();
		Vector<BodyType> bodyTypePref = new Vector<BodyType>();
		Vector<ReligiousBeliefs> religionPref = new Vector<ReligiousBeliefs>();
		Vector<Occupation> occupationPref = new Vector<Occupation>();
		Vector<Hobbies> hobbiesPref = new Vector<Hobbies>();
		// Setting up age preference
		int importance = rand.nextInt(6);
		if (importance != 0)
			prefer.setAgePref(new Pref<Range>(agePref, importance));
		else
			prefer.setAgePref(new Pref<Range>(null, 0));
		// Setting up height preference
		importance = rand.nextInt(6);
		if (importance != 0)
			prefer.setHeightPref(new Pref<Range>(heightPref, importance));
		else
			prefer.setHeightPref(new Pref<Range>(null, 0));
		// Setting up gender preferences
		{
			float orient = rand.nextFloat();
			if (orient <= 0.1) {
				genderPref.add(Gender.Male);
				genderPref.add(Gender.Female);
			} else if (orient <= 0.2)
				genderPref.add(p.getGender());
			else if (p.getGender() == Gender.Male)
				genderPref.add(Gender.Female);
			else
				genderPref.add(Gender.Male);
		}
		prefer.setGenderPref(genderPref);
		// Setting up eye color preferences
		importance = rand.nextInt(6);
		if (importance != 0) {
			int arrLen = rand.nextInt(eyeColorLen - 2) + 1;
			int i = 0;
			while (i < arrLen) {
				EyeColor color = ProfileGenerator.eyeColor[rand.nextInt(eyeColorLen)];
				if (!eyeColorPref.contains(color)) {
					eyeColorPref.add(color);
					++i;
				}
			}
			prefer.setEyeColorPref(new Pref<Vector<EyeColor>>(eyeColorPref, importance));
		} else
			prefer.setEyeColorPref(new Pref<Vector<EyeColor>>(null, 0));
		// Setting up hair style preference
		boolean baldiesOnly = false;
		importance = rand.nextInt(6);
		if (importance != 0) {
			int arrLen = rand.nextInt(hairstyleLen - 3) + 1;
			int i = 0;
			while (i < arrLen) {
				Hairstyle style = ProfileGenerator.hairstyle[rand.nextInt(hairstyleLen)];
				if (style != Hairstyle.Other) {
					if (!hairstylePref.contains(style)) {
						hairstylePref.add(style);
						++i;
					}
				}
			}
			baldiesOnly = (arrLen == 1) && hairstylePref.contains(Hairstyle.Bald);
			prefer.setHairstylePref(new Pref<Vector<Hairstyle>>(hairstylePref, importance));
		} else
			prefer.setHairstylePref(new Pref<Vector<Hairstyle>>(null, 0));
		// Setting up hair color preference
		if (baldiesOnly == false) {
			importance = rand.nextInt(6);
			if (importance != 0) {
				int arrLen = rand.nextInt(hairColorLen - 1) + 1;
				int i = 0;
				while (i < arrLen) {
					HairColor color = ProfileGenerator.hairColor[rand.nextInt(hairColorLen)];
					if (!hairColorPref.contains(color)) {
						hairColorPref.add(color);
						++i;
					}
				}
				prefer.setHairColorPref(new Pref<Vector<HairColor>>(hairColorPref, importance));
			} else
				prefer.setHairColorPref(new Pref<Vector<HairColor>>(null, 0));
		} else {
			prefer.setHairColorPref(new Pref<Vector<HairColor>>(null, 0));
		}
		// Setting up body type preference
		importance = rand.nextInt(6);
		if (importance != 0) {
			int arrLen = rand.nextInt(bodyTypeLen - 3) + 1;
			int i = 0;
			while (i < arrLen) {
				BodyType body = ProfileGenerator.bodyType[rand.nextInt(bodyTypeLen)];
				if (!bodyTypePref.contains(body)) {
					bodyTypePref.add(body);
					++i;
				}
			}
			prefer.setBodyTypePref(new Pref<Vector<BodyType>>(bodyTypePref, importance));
		} else
			prefer.setBodyTypePref(new Pref<Vector<BodyType>>(null, 0));
		// Setting occupation preference
		importance = rand.nextInt(6);
		if (importance != 0) {
			int arrLen = rand.nextInt(5) + 1;
			int i = 0;
			while (i < arrLen) {
				Occupation occupation = ProfileGenerator.occupation[rand.nextInt(occupationLen)];
				if (occupation != Occupation.Other) {
					if (!occupationPref.contains(occupation)) {
						occupationPref.add(occupation);
						++i;
					}
				}
			}
			prefer.setOccupationPref(new Pref<Vector<Occupation>>(occupationPref, importance));
		} else
			prefer.setOccupationPref(new Pref<Vector<Occupation>>(null, 0));
		// Setting religion preference
		importance = rand.nextInt(6);
		if (importance != 0) {
			if ((p.getReligion() == ReligiousBeliefs.Atheism) || (p.getReligion() == ReligiousBeliefs.Agnosticism)) {
				religionPref.add(ReligiousBeliefs.Agnosticism);
				religionPref.add(ReligiousBeliefs.Atheism);
			} else if (p.getReligion() == ReligiousBeliefs.Other) {
				importance = 0;
				prefer.setReligionPref(new Pref<Vector<ReligiousBeliefs>>(null, 0));
			} else
				religionPref.add(p.getReligion());
			prefer.setReligionPref(new Pref<Vector<ReligiousBeliefs>>(religionPref, importance));
		} else
			prefer.setReligionPref(new Pref<Vector<ReligiousBeliefs>>(null, 0));
		// Setting hobbies preference
		importance = rand.nextInt(6);
		if (importance != 0) {
			boolean own = rand.nextBoolean();
			if (own)
				prefer.setHobbiesPref(new Pref<Vector<Hobbies>>(p.getHobbies(), importance));
			else {
				int numberOfHobbies = rand.nextInt(ProfileGenerator.maxHobbies - ProfileGenerator.minHobbies)
						+ ProfileGenerator.minHobbies;
				int i = 0;
				while (i < numberOfHobbies) {
					Hobbies hobby = ProfileGenerator.hobbies[rand.nextInt(hobbiesLen)];
					if (!hobbiesPref.contains(hobby)) {
						hobbiesPref.add(hobby);
						++i;
					}
				}
				prefer.setHobbiesPref(new Pref<Vector<Hobbies>>(hobbiesPref, importance));
			}
		} else
			prefer.setHobbiesPref(new Pref<Vector<Hobbies>>(null, 0));
		return prefer;
	}
}
