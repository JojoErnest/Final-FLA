package models;

public class Regular extends Room{

	@Override
	public int getMinimumPrice() {
		int minPrice = 1000000;
		return minPrice;
	}

	@Override
	public void facility() {
		// TODO Auto-generated method stub
		System.out.println("Mini Fridge inside Bedroom");
	}

	@Override
	public void breakfast() {
		// TODO Auto-generated method stub
		System.out.println("Free breakfast for 2");
	}
}
