package models;

public abstract class Room {
	public abstract int getMinimumPrice();
	public abstract void facility();
	public abstract void breakfast();
	public void prepare() {
		facility();
		breakfast();
	}
}
