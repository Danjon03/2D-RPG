package newPackage;

public class Quest {

	
	String Name, NeededItem, Reward;
	int Id;
	boolean Completed, Started, HaveItem;
	
	public Quest (String name, int id, String neededItem, String reward, boolean completed, boolean started, boolean haveItem)
	{
		Name=name;
		Id=id;
		NeededItem=neededItem;
		Reward = reward;
		Completed = completed;
		Started = started;
		HaveItem = haveItem;
		
		
	}


	public String getName() {
		return Name;
	}


	public void setName(String name) {
		Name = name;
	}


	public String getNeededItem() {
		return NeededItem;
	}


	public void setNeededItem(String neededItem) {
		NeededItem = neededItem;
	}


	public String getReward() {
		return Reward;
	}


	public void setReward(String reward) {
		Reward = reward;
	}


	public int getId() {
		return Id;
	}


	public void setId(int id) {
		Id = id;
	}
	


	public boolean isCompleted() {
		return Completed;
	}


	public void setCompleted(boolean completed) {
		Completed = completed;
	}

	
	
	
	
}
