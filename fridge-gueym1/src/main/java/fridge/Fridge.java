/*
 * Project and Training 1 - Computer Science, Berner Fachhochschule
 */

package fridge;

public class Fridge{
	int drinkCount;
	double milkLiters;
	
	public Fridge(int drinks,double milk) {
		this.drinkCount = drinks;
		this.milkLiters = milk;
	}
	
	public int getNumberOfDrinks() {
		return this.drinkCount;
	}
	
	public double getLitersOfMilk() {
		return this.milkLiters;
	}
	
	public String takeADrink() {
		if(this.drinkCount>=1) {
			this.drinkCount=this.drinkCount-1;
			return "Here is your drink.";
		}
		return "Not enough drinks!";
	}
	
	public String takeMilk (double milk) {
		if(this.milkLiters>=milk) {
			this.milkLiters=this.milkLiters-milk;
			return "Here is your milk.";
		}
		return "Not enough milk!";
	}
	
	public void fillMilk(double milk) {
		this.milkLiters=this.milkLiters+milk;
	}
	
	public void fillDrinks(int number) {
		this.drinkCount=this.drinkCount+number;
	}
	
}