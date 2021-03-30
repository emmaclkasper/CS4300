package shopping;

import java.util.List;

public class Beans {
	@Override
	public String toString() {
		return "Beans [username=" + username + ", password=" + password + "]";
	}
	String username;
	String password;
	String itemName;

	
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Beans> getUsernames()
	{
		
		return null;	
	}
}
