/*
 * Author: Neumann Davila
 * Date:   Oct 20, 2022
 * Description:
 *
 *
 * 
 */

package finalProject.CharacterObjects;

import java.util.Random;

public class Stat {
	private Random rand = new Random();
	
	private String name;
	private int statValue;
	
	/*
	 * Opposing stat + Your stat -> succes/failure
	 * 
	 * The process I go through to calculate succes/failure
	 * 	- If I add 5 t the opposing stat then when challenging 
	 * 		the stat the 100% success rate is now 5 over the base stat 
	 * 
	 */
	public boolean rolllStat(Stat opposingStat) {
		int stat = opposingStat.getStat() + 10;
		
		if(this.statValue < stat) {
			int percChance  = 100 * this.statValue / stat;
			
			if(rand.nextInt(100) < percChance) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return true;
		}
	}
	
	public String toString() {
		return this.name + ": " + statValue;
	}

	public void setStat(int statValue) {
		this.statValue = statValue;
	}
	
	public void adjustStat(int adjustValue) {
		statValue += adjustValue;
	}
	
	public int getStat() {
		return statValue;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Stat(String name) {
		this.name = name;
	}
}

