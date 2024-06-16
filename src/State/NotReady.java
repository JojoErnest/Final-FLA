package State;

import models.Reservation;

public class NotReady extends State{

	public NotReady(Reservation reserve) {
		super(reserve);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getState() {
		// TODO Auto-generated method stub
		String state = "Not Ready";
		return state;
	}

	@Override
	public void changeState() {
		// TODO Auto-generated method stub
		reserve.setState(new Ready(reserve));
	}

}
