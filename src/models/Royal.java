package models;

public class Royal extends Room{

	@Override
	public int getMinimumPrice() {
		int minPrice = 4000000;
		return minPrice;
	}

	@Override
	public void facility() {
		// TODO Auto-generated method stub
		System.out.println("Private jacuzzi");
		System.out.println("Private pool");
	}

	@Override
	public void breakfast() {
		// TODO Auto-generated method stub
		System.out.println("Free breakfast for 4");
		System.out.println("Eligible to request menu (all day serve)");
	}

}
