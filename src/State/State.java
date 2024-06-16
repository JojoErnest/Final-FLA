package State;

import models.Reservation;

public abstract class State {
	protected Reservation reserve;

	public State(Reservation reserve) {
		super();
		this.reserve = reserve;
	}
	
	public abstract String getState();
	public abstract void changeState();
}
