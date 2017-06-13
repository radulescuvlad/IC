package graphix_backend;

import profile_data.*;

public class EnumToText {
	public static String convert(Hobbies arg) {
		switch (arg) {
		case Baking:
			return "Baking";
		case BoardGames:
			return "Board Games";
		case Canoeing:
			return "Canoeing";
		case Cars:
			return "Cars";
		case Carving:
			return "Carving";
		case ComicBooks:
			return "Comic Books";
		case Cooking:
			return "Cooking";
		case DIY:
			return "DIY";
		case Drawing:
			return "Drawing";
		case Football:
			return "Football";
		case Hiking:
			return "Hiking";
		case Kayaking:
			return "Kayaking";
		case LARPing:
			return "Larping";
		case Motorcycles:
			return "Motorcycles";
		case Movies:
			return "Movies";
		case Music:
			return "Music";
		case Painting:
			return "Painting";
		case Pottery:
			return "Pottery";
		case Programming:
			return "Programming";
		case RPGs:
			return "RPGs";
		case Reading:
			return "Reading";
		case Skiing:
			return "Skiing";
		case Swimming:
			return "Swimming";
		case Tennis:
			return "Tennis";
		case Traveling:
			return "Traveling";
		case VideoGames:
			return "Video Games";
		case Vlogging:
			return "Vlogging";
		case Volunteering:
			return "Volunteering";
		case Woodworking:
			return "Woodworking";
		case Writing:
			return "Writing";
		default:
			throw new IllegalStateException();
		}
	}

	public static String convert(ReligiousBeliefs arg) {
		switch (arg) {
		case Agnosticism:
			return "Agnosticism";
		case Atheism:
			return "Atheism";
		case Budhist:
			return "Budhist";
		case Christian:
			return "Christian";
		case Hindu:
			return "Hindu";
		case Islam:
			return "Islam";
		case Other:
			return "Other";
		default:
			throw new IllegalStateException();
		}
	}

	public static String convert(Occupation arg) {
		switch (arg) {
		case Academia:
			return "Academia";
		case Corporate:
			return "Corportate";
		case Education:
			return "Education";
		case Entertainment:
			return "Entertainment";
		case Food:
			return "Food";
		case Health:
			return "Health";
		case Law:
			return "Law";
		case Politics:
			return "Politics";
		case STEM:
			return "STEM";
		case Student:
			return "Student";
		case Tourism:
			return "Tourism";
		case Military:
			return "Military";
		case Other:
			return "Unspecified";
		default:
			throw new IllegalStateException();
		}
	}

	public static String convert(Hairstyle arg) {
		switch (arg) {
		case Bald:
			return "Bald";
		case Buzzed:
			return "Buzzed";
		case Long:
			return "Long";
		case Medium:
			return "Medium length";
		case Messy:
			return "Messy";
		case Other:
			return "Other";
		case Short:
			return "Short";
		default:
			throw new IllegalStateException();
		}
	}

	public static String convert(HairColor arg) {
		switch (arg) {
		case Black:
			return "Black";
		case Blonde:
			return "Blonde";
		case Brown:
			return "Brown";
		case Dyed:
			return "Dyed";
		case Red:
			return "Red";
		default:
			throw new IllegalStateException();
		}
	}

	public static String convert(Gender arg) {
		switch (arg) {
		case Female:
			return "Female";
		case Male:
			return "Male";
		default:
			throw new IllegalStateException();
		}
	}

	public static String convert(EyeColor arg) {
		switch (arg) {
		case Black:
			return "Black";
		case Blue:
			return "Blue";
		case Brown:
			return "Brown";
		case Green:
			return "Green";
		case Heterochromatic:
			return "Heterochromatic";
		default:
			throw new IllegalStateException();

		}
	}

	public static String convert(BodyType arg) {
		switch (arg) {
		case Athletic:
			return "Athletic";
		case Average:
			return "Average";
		case Bodybuilder:
			return "Bodybuilder";
		case Fit:
			return "Fit";
		case Overweight:
			return "Overweight";
		case Stocky:
			return "Stocky";
		case Thin:
			return "Thin";
		default:
			throw new IllegalStateException();
		}
	}
}
