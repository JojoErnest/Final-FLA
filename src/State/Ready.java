package State;

import models.Reservation;

public class Ready extends State{

	public Ready(Reservation reserve) {
		super(reserve);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getState() {
		// TODO Auto-generated method stub
		String state = "Ready";
		return state;
	}

	@Override
	public void changeState() {
		// TODO Auto-generated method stub
	}

}
