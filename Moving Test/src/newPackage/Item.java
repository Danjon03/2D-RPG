package newPackage;

public class Item extends Main
{
	
	String Name;
	String Description;
	int Id, LocationX, LocationY;
	boolean InInventory, Draw;
	
	
	public Item(String name, int id, String description, int locationX, int locationY, boolean inInventory, boolean draw)
	{
		Name=name;
		Description=description;
		Id = id;
		LocationX = locationX;
		LocationY = locationY;
		InInventory = inInventory;
		Draw = draw;
	}

	public boolean isDraw() {
		return Draw;
	}

	public void setDraw(boolean draw) {
		Draw = draw;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public int getLocationX() {
		return LocationX;
	}

	public void setLocationX(int locationX) {
		LocationX = locationX;
	}

	public int getLocationY() {
		return LocationY;
	}

	public void setLocationY(int locationY) {
		LocationY = locationY;
	}

	public boolean isInInventory() {
		return InInventory;
	}

	public void setInInventory(boolean inInventory) {
		InInventory = inInventory;
	}

	@Override
	public String getName() {
		return Name;
	}

	@Override
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
