package storage;

public class Pref<T> {
	private T trait;
	private int importance;

	public double score() {
		switch (importance) {
		case 0:
			return 0;
		case 1:
			return 10;
		case 2:
			return 25;
		case 3:
			return 50;
		case 4:
			return 75;
		case 5:
			return 100;
		default:
			throw new IllegalStateException();
		}
	}

	public Pref(T trait, int importance) {
		this.trait = trait;
		this.importance = importance;
	}

	public T getTrait() {
		return trait;
	}

	public int getImportance() {
		return importance;
	}
	
	public boolean matters() {
		return importance > 0;
	}
}
