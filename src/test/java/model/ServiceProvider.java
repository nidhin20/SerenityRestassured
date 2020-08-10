package model;

public class ServiceProvider {
	private String Name;

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}
	public ServiceProvider(String name){
		this.Name=name;
	}
}
