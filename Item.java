package newPackage;

public class Item extends Main
{
	
	String Name;
	String Description;
	
	public Item(String name, String description)
	{
		Name=name;
		Description=description;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}
	
	
	
}
