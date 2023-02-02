package studio2;

import java.util.Scanner;

import javax.swing.AbstractSpinnerModel;

public class Ruin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("Start Amount: ");
		double startAmount = in.nextDouble();
		System.out.println("win chance: ");
		double winChance = in.nextDouble();
		System.out.println("win limit: ");
		double winLimit = in.nextDouble();
		System.out.println("total simulation time: ");
		int simTime = in.nextInt();
		int round = 0;
		int day = 0;
		double expectedRuin = 0;
		boolean outcome = false;
		double wins = 0; 
		double losses = 0; 
		for (day = 0; day < simTime; day++) {
			double money = startAmount;
			while (money > 0 && money < winLimit) {
				round++;
				if (Math.random() <= winChance) {
					money++;
				} else {
					money--;
				}
				System.out.println("Round: " + round + ". Money: " + money);
			}
			if (money == 0) {
				System.out.println("you lose");
				outcome = true;
				losses++; 
			} else {
				System.out.println("you win");
				outcome = false;
				wins++; 
			}
		} 
		if (winChance == 0.5) {
			double math = startAmount/winLimit;
			expectedRuin = (1 - math);
		} else {
			double a = ((1-winChance)/winChance);
			expectedRuin = (Math.pow(a, startAmount) - Math.pow(a, winLimit))/(1-Math.pow(a, winLimit));
		}
		System.out.println("Losses: " + losses + "/" + (losses + wins)); 
		System.out.println("Expected Ruin Rate: " + expectedRuin);
		
		double actualRuinRate = losses/(wins+losses); 
		System.out.println("Actual Ruin Rate: " + actualRuinRate); 
	}
	
}