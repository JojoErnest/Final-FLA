package facade;

import java.util.ArrayList;
import java.util.Scanner;

import State.NotReady;
import models.Regular;
import models.Reservation;
import models.Royal;

public class MenuFacade {
	Scanner scan = new Scanner(System.in);
	ArrayList<Reservation> list = new ArrayList<>();
	Reservation reserve = new Reservation();
	Royal Royal = new Royal();
	models.Family Family = new models.Family();
	Regular Regular = new Regular();
	
	public void MainMenuFacade() {
		int input = 0;
		while(input != 4)
		{
			System.out.println("1. Insert new reservation");
			System.out.println("2. Prepare reservation");
			System.out.println("3. Manage reservation");
			System.out.println("4. Exit");
			System.out.print(">>");
			input = scan.nextInt();
			if(input == 1)
			{
				newReserve();
			}
			else if(input == 2)
			{
				prepareReserve();
			}
			else if(input == 3)
			{
				manageReserve();
			}
		}
	}
	
	public void newReserve() {
		String name, type;
		int price;
		do {
			System.out.print("Input customer name [cannot be empty]: ");
			name = scan.next();
		}while(name.length()<1);
		do {
			System.out.print("Input reservation type [Royal | Family | Regular]:  ");
			type = scan.next();
		}while(!type.equals("Royal") && !type.equals("Family") && !type.equals("Regular"));
		if(type.equals("Royal"))
		{
			do {
				System.out.print("Insert reservation price: ");
				price = scan.nextInt();
			}while(price < Royal.getMinimumPrice());
			reserve.setRoom(Royal);
		}
		else if(type.equals("Family"))
		{
			do {
				System.out.print("Insert reservation price: ");
				price = scan.nextInt();
			}while(price < Family.getMinimumPrice());
			reserve.setRoom(Family);
		}
		else
		{
			do {
				System.out.print("Insert reservation price: ");
				price = scan.nextInt();
			}while(price < Regular.getMinimumPrice());
			reserve.setRoom(Regular);
		}
		reserve.setName(name);
		reserve.setType(type);
		reserve.setPrice(price);
		reserve.setState(new NotReady(reserve));
		list.add(reserve);
	}
	
	public void viewList() {
		if(list.isEmpty()) {
			System.out.println("There are no reservation!");
		}
		else
		{
			System.out.println("Reservation List");
			System.out.println("==================");
			System.out.println("No   Customer Name   Room Type   Price   Room State");
			int idx = 1;
			for(Reservation reserve : list) {
				System.out.println(idx + "   " + reserve.getName() + "   " + reserve.getType() + "   " 
									+ reserve.getPrice() + "   " + reserve.getState().getState());
				idx++;
			}
		}
	}
	
	public void prepareReserve() {
		viewList();
		if(!list.isEmpty()) {
			int input = 0;
			do {
				System.out.print("Which room would you like to prepare?");
				input = scan.nextInt();
			}while(input > list.size() || input < list.size());
			if(list.get(input-1).getState().getState().equals("Ready"))
			{
				System.out.println("Room is already prepared!");
			}
			else
			{
				list.get(input-1).getState().changeState();
				list.get(input-1).getRoom().prepare();
			}
		}
	}
	
	public void manageReserve() {
		int input = 0;
		do {
			System.out.println("1. Cancel reservation");
			System.out.println("2. Upgrade reservation");
			System.out.print(">>"); input = scan.nextInt();
		}while(input < 1 || input > 2);
		viewList();
		int manage = 0;
		if(input == 1)
		{
			do {
				System.out.print("Which reservation would you like to cancel?");
				manage = scan.nextInt();
			}while(manage > list.size() || manage < list.size());
			list.remove(manage-1);
			System.out.println("Reservation has been succeessfully cancelled");
			System.out.println("We have sent a pdf file regarding the cancellation to your email!");
		}
		else
		{
			do {
				System.out.print("Which reservation would you like to upgrade?");
				manage = scan.nextInt();
			}while(manage > list.size() || manage < list.size());
			if(list.get(manage-1).getType().equals("Royal"))
			{
				System.out.println("Room type cannot be upgrade anymore!");
			}
			else if(list.get(manage-1).getType().equals("Family"))
			{
				System.out.println("Room type has been upgraded to Royal");
				list.get(manage-1).setPrice(Royal.getMinimumPrice());
				list.get(manage-1).setType("Royal");
			}
			else
			{
				System.out.println("Room type has been upgraded to Family");
				list.get(manage-1).setPrice(Family.getMinimumPrice());
				list.get(manage-1).setType("Regular");
			}
			System.out.println("We have sent a pdf file regarding the room upgrade to your email!");
		}
	}

}
