package newPackage;

public class Player extends Main
{
	
	 String Name;
	 int Health;
	 int Defense;
	 int Weapon1;
	 int Weapon2;
	 int Armor;
	
	public Player(String name, int health, int defense, int weapon1, int weapon2, int armor) 
	{
		
		
		Name = name;
		Health = health;
		Defense = defense;
		Weapon1 = weapon1;
		Weapon2 = weapon2;
		Armor = armor;
				
		
		
		
		
		
		
		
		
	}
	
	
	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getHealth() {
		return Health;
	}

	public void setHealth(int health) {
		Health = health;
	}

	public int getDefense() {
		return Defense;
	}

	public void setDefense(int defense) {
		Defense = defense;
	}

	public int getWeapon1() {
		return Weapon1;
	}

	public void setWeapon1(int weapon1) {
		Weapon1 = weapon1;
	}

	public int getWeapon2() {
		return Weapon2;
	}

	public void setWeapon2(int weapon2) {
		Weapon2 = weapon2;
	}

	public int getArmor() {
		return Armor;
	}

	public void setArmor(int armor) {
		Armor = armor;
	}

	
	
	
	
}
