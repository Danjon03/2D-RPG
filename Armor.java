package newPackage;

public class Armor extends Item{

	String Name;
	String Description;
	int Defense;
	
	
	
	public Armor(String name, String description, int defense) 
	{
		super(name, description);
		
		Name=name;
		Description=description;
		Defense=defense;
		
	}

}
