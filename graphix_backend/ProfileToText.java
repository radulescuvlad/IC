package graphix_backend;

import java.util.Iterator;
import java.util.Vector;
import profile.Profile;
import profile_data.Hobbies;

public class ProfileToText {
	private static final String newline = "<br>";
	private static final String tab = "         ";
	public static String write(Profile p) {
		String s = "<html>";
		s += p.getFirstName() + " " + p.getLastName() + newline;
		s += tab + EnumToText.convert(p.getGender()) + newline;
		s += tab + "email: " + p.getEmail() + newline;
		s += tab + "age: " + p.getAge() + newline;
		s += tab + "height: " + p.getHeight() + " cm" + newline;
		s += tab + "Eye color: " + EnumToText.convert(p.getEyeColor()) + newline;
		s += tab + "Hair style: " + EnumToText.convert(p.getHairstyle()) + newline;
		s += tab + "Hair color: " + EnumToText.convert(p.getHairColor()) + newline;
		s += tab + "Body type: " + EnumToText.convert(p.getBody()) + newline;
		s += tab;
		int kids = p.getKids();
		if (kids < 0)
			s += "Does not want kids";
		else if (kids == 0)
			s += "Wants kids";
		else
			s += "Kids: " + kids;
		s += newline;
		s += tab + "Religious beliefs: " + EnumToText.convert(p.getReligion()) + newline;
		s += tab + "Occupation: " + EnumToText.convert(p.getOccupation()) + newline;
		s += tab + "Hobbies: " + newline + tab + tab;
		Vector<Hobbies> h = p.getHobbies();
		if (h == null) System.out.println("Nothing here!");
		Iterator<Hobbies> i = h.iterator();
		while (i.hasNext()) {
			s += EnumToText.convert(i.next());
			if (i.hasNext())
				s += ", ";
		}
		s += "</html>";
		return s;
	}
}
