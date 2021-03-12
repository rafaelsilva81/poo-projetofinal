package App;

public class Worker extends User implements Comparable<Worker> {

	public Worker(String username, String password) {
		super(username, password);
	}

	public String show() {

		return this.getUsername() + " - " + this.getPassword();

	}

	@Override
	public int compareTo(Worker o) {
		return this.getUsername().compareTo(o.getUsername());
	}
}
