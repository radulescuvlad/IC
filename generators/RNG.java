package generators;

/*
 * Random Number Generator
 */

import java.time.LocalTime;
import java.util.Random;

public class RNG {
	private static Random rand = new Random(LocalTime.now().toNanoOfDay());

	public static Random getRand() {
		return rand;
	}
	
	public static void reseed() {
		rand.setSeed(LocalTime.now().toNanoOfDay());
	}
}
