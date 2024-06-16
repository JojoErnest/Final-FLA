package models;

import State.State;

public class Reservation {
	private String name, type;
	private State state;
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
	private Room room;
	
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
	private int price;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

}
