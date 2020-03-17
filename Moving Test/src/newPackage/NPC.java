package newPackage;

public class NPC{
	
	
	String Name;
	int Id;
	String Diologe;
	String Image;
	int XCoor, YCoor;
	String questDialogue = "Hey, Can You Get Me An Apple";
	
	public NPC (String name, int id, String diologe, String image, int xCoor, int yCoor)
	{
		Name=name;
		Id=id;
		Diologe=diologe;
		Image=image;
		XCoor = xCoor;
		YCoor = yCoor;
		
	}

	public String getQuestDialogue()
	{
		return questDialogue;
	}
	
	public int getXCoor() {
		return XCoor;
	}


	public void setXCoor(int xCoor) {
		XCoor = xCoor;
	}


	public int getYCoor() {
		return YCoor;
	}


	public void setYCoor(int yCoor) {
		YCoor = yCoor;
	}


	public String getName() {
		return Name;
	}


	public void setName(String name) {
		Name = name;
	}


	public int getId() {
		return Id;
	}


	public void setId(int id) {
		Id = id;
	}


	public String getDiologe() {
		return Diologe;
	}


	public void setDiologe(String diologe) {
		Diologe = diologe;
	}


	public String getImage() {
		return Image;
	}


	public void setImage(String image) {
		Image = image;
	}
	
	
	
	

}
