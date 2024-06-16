package models;

public class Family extends Room{

	@Override
	public int getMinimumPrice() {
		int minPrice = 2000000;
		return minPrice;
	}

	@Override
	public void facility() {
		// TODO Auto-generated method stub
		System.out.println("Private Jacuzzi");
	}

	@Override
	public void breakfast() {
		// TODO Auto-generated method stub
		System.out.println("Free breakfast for 3");
		System.out.println("Eligible to request menu (dinner only)");
	}
}
