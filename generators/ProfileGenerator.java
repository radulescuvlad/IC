package generators;

import profile_data.*;
import java.util.Random;
import java.util.Vector;
import profile.Profile;

public class ProfileGenerator {
	static final String[] boyFirstNames = { "Alex", "Alin", "Alfred", "Avram", "Adrian", "Bogdan", "Barbu", "Banica",
			"Brad", "Ben", "Corin", "Claudiu", "Casian", "Corneliu", "Constantin", "Dorin", "Dumitru", "Demian",
			"Denis", "Dan", "Emil", "Ernest", "Emanuel", "Eugen", "Edgar", "Felix", "Ferdinand", "Fred", "Fane",
			"Florian", "Gabriel", "Grigore", "Gideon", "Gaston", "Graham", "Horatiu", "Haralambie", "Herman", "Horia",
			"Hector", "Ilie", "Isac", "Ivan", "Igor", "Ionut", "Jesse", "Jeremy", "Jean", "Jerry", "James", "Konrad",
			"Kevin", "Kyle", "Karol", "Kim", "Leon", "Lamar", "Lucretiu", "Laurentiu", "Lucas", "Marian", "Marcus",
			"Matei", "Mihai", "Martin", "Nicolae", "Norbert", "Nigel", "Noe", "Norman", "Oliver", "Oscar", "Oswald",
			"Owen", "Orson", "Petru", "Paul", "Pavel", "Puiu", "Pan", "Radu", "Raul", "Rica", "Ruben", "Relu", "Stefan",
			"Serban", "Saul", "Samuel", "Stelian", "Tod", "Teo", "Titus", "Trevor", "Tristan", "Vali", "Victor",
			"Viorel", "Virgil", "Valentin" };
	static final String[] girlFirstNames = { "Astrid", "Alina", "Andra", "Andreea", "Andrada", "Bianca", "Beatrice",
			"Bogdana", "Betina", "Bella", "Corina", "Casiana", "Carolina", "Clara", "Casandra", "Diana", "Daiana",
			"Dana", "Denisa", "Doris", "Elena", "Ela", "Elisabeta", "Emilia", "Elsa", "Florina", "Florentina", "Flora",
			"Felicia", "Frida", "Gina", "Gabriela", "Georgina", "Geta", "Gratiana", "Ilinca", "Ilona", "Irma", "Iris",
			"Ingrid", "Laura", "Lucretia", "Lina", "Linda", "Lavinia", "Maria", "Margareta", "Magdalena", "Magnolia",
			"Matilda", "Nineta", "Nora", "Nico", "Nicoleta", "Naomi", "Ofelia", "Otilia", "Ozana", "Olivia", "Octavia",
			"Pamela", "Paula", "Paulina", "Petra", "Poliana", "Raluca", "Raschela", "Ramona", "Roxana", "Ruxandra",
			"Stela", "Samanta", "Suzana", "Silvia", "Silvana", "Tita", "Teodora", "Tamara", "Tabita", "Tereza",
			"Valeria", "Victoria", "Valentina", "Viviana", "Violeta" };
	static final String[] lastNames = { "Avramescu", "Avramovici", "Ardelean", "Agache", "Argintaru", "Amariei",
			"Adomnitei", "Anton", "Anolache", "Antonet", "Barbulescu", "Bogdanovici", "Bogdanov", "Braileanu",
			"Bradean", "Budulan", "Badiu", "Balan", "Bucuriu", "Boschetaru", "Carnat", "Catavencu", "Corinteanu",
			"Cristici", "Cucurigu", "Cucuveanu", "Carlet", "Cordea", "Ciama", "Calistrat", "Dinea", "Dobrovan",
			"Domnitoru", "Dormea", "Dimineata", "Draghici", "Daniloiu", "Dima", "Dorinel", "Durici", "Epure", "Enescu",
			"Enea", "Emilovici", "Emanov", "Eritreu", "Eleaza", "Eminescu", "Eminovici", "Eleron", "Faur", "Fanica",
			"Favi", "Falusi", "Fuchsia", "Fara", "Feleac", "Feleu", "Fus", "Farad", "Ghinea", "Ghici", "Gramov",
			"Gaina", "Gaita", "Ghita", "Ghitea", "Gargamel", "Golban", "Giurgiu", "Haineala", "Hainov", "Hainu",
			"Holom", "Haiduc", "Hrisat", "Hodis", "Hangiu", "Halici", "Hutuian", "Ianc", "Ilici", "Iancovici",
			"Ianculescu", "Ilian", "Inimioara", "Iorgu", "Izvor", "Ilisor", "Iliuta", "Joian", "Jumara", "Jagger",
			"Juvete", "Jian", "Juvius", "Joni", "Jeleu", "Jambon", "Jean", "Lupu", "Lache", "Leonida", "Lamoly", "Lima",
			"Lica", "Livian", "Lonit", "Lupean", "Lupescu", "Marinov", "Marinescu", "Muntean", "Munteanu", "Muntenegru",
			"Maru", "Musca", "Medel", "Moma", "Mazilu", "Negru", "Negreanu", "Negrici", "Nomad", "Nitros", "Nitrache",
			"Nae", "Niceanu", "Noian", "Nuga", "Orinov", "Oreste", "Oceanu", "Orisan", "Oboian", "Oscior", "Oltean",
			"Olteanu", "Onescu", "Onor", "Pavelescu", "Paulescu", "Pacala", "Periam", "Ponor", "Pad", "Puiu", "Padiu",
			"Pascaru", "Pescaru", "Radovan", "Radovici", "Rad", "Remetean", "Romanu", "Roman", "Radu", "Raicu", "Ruvan",
			"Robot", "Sima", "Simulescu", "Somesean", "Sulea", "Saici", "Secundus", "Sclavu", "Sefu", "Stapanu",
			"Spinu", "Taurean", "Toma", "Tetian", "Taranu", "Tomescu", "Topor", "Terescu", "Troica", "Traila", "Tosan",
			"Vancea", "Vancica", "Vasilache", "Voian", "Visioc", "Vuian", "Vuia", "Vornic", "Vintila", "Veverita" };
	static final BodyType[] bodyType = BodyType.values();
	static final EyeColor[] eyeColor = EyeColor.values();
	static final Gender[] gender = Gender.values();
	static final HairColor[] hairColor = HairColor.values();
	static final Hairstyle[] hairstyle = Hairstyle.values();
	static final Hobbies[] hobbies = Hobbies.values();
	static final Occupation[] occupation = Occupation.values();
	static final ReligiousBeliefs[] religion = ReligiousBeliefs.values();
	static final int minHobbies = 2;
	static final int maxHobbies = 6;

	public static Profile get() {
		float prob;
		Profile p = new Profile();
		Random rand = RNG.getRand();
		p.setLastName(lastNames[rand.nextInt(lastNames.length)]);
		p.setGender(gender[rand.nextInt(gender.length)]);
		switch (p.getGender()) {
		case Female:
			p.setFirstName(girlFirstNames[rand.nextInt(girlFirstNames.length)]);
			break;
		case Male:
			p.setFirstName(boyFirstNames[rand.nextInt(boyFirstNames.length)]);
			break;
		}
		String email = p.getFirstName().toLowerCase() + "." + p.getLastName().toLowerCase() + "@somemail.com";
		p.setEmail(email);
		p.setAge(rand.nextInt(60) + 18);
		prob = rand.nextFloat();
		if (prob <= 0.5)
			p.setAge(rand.nextInt(18) + 18);
		else if (prob <= 0.8)
			p.setAge(rand.nextInt(16) + 35);
		else
			p.setAge(rand.nextInt(26) + 45);
		prob = rand.nextFloat();
		if (prob <= 0.4)
			p.setKids(-1);
		else if (prob <= 0.9)
			p.setKids(0);
		else
			p.setKids(rand.nextInt(6) + 1);
		prob = rand.nextFloat();
		switch (p.getGender()) {
		case Female:
			if (prob <= 0.3)
				p.setHeight(rand.nextInt(26) + 120);
			else if (prob <= 0.8)
				p.setHeight(rand.nextInt(26) + 145);
			else
				p.setHeight(rand.nextInt(51) + 170);
			break;
		case Male:
			if (prob <= 0.15)
				p.setHeight(rand.nextInt(26) + 120);
			else if (prob <= 0.8)
				p.setHeight(rand.nextInt(26) + 145);
			else
				p.setHeight(rand.nextInt(51) + 170);
			break;
		}
		p.setEyeColor(eyeColor[rand.nextInt(eyeColor.length)]);
		p.setHairstyle(hairstyle[rand.nextInt(hairstyle.length)]);
		if (p.getHairstyle() == Hairstyle.Bald)
			do
				p.setHairColor(hairColor[rand.nextInt(hairColor.length)]);
			while (p.getHairColor() == HairColor.Dyed);
		else
			p.setHairColor(hairColor[rand.nextInt(hairColor.length)]);
		p.setBody(bodyType[rand.nextInt(bodyType.length)]);
		p.setReligion(religion[rand.nextInt(religion.length)]);
		p.setOccupation(occupation[rand.nextInt(occupation.length)]);
		{
			int numberOfHobbies = rand.nextInt(maxHobbies - minHobbies) + minHobbies;
			Vector<Hobbies> localHobbies = new Vector<Hobbies>();
			int i = 0;
			while (i < numberOfHobbies) {
				Hobbies hobby = hobbies[rand.nextInt(hobbies.length)];
				if (!localHobbies.contains(hobby)) {
					localHobbies.add(hobby);
					++i;
				}
			}
			p.setHobbies(localHobbies);
		}
		p.setMatchPref(PreferenceGenerator.get(p));
		return p;
	}
}
