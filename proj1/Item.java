package nachos.proj1;

public class Item implements Runnable{
	private int user;
	private String name, q;
	public Item(int user, String q, String name) {
		this.user = user;
		this.q = q;
		this.name = name;
	}
	public int getUser() {
		return user;
	}
	public void setUser(int user) {
		this.user = user;
	}
	public String getQ() {
		return q;
	}
	public void setQ(String q) {
		this.q = q;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		
	}

}
