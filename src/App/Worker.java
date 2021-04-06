package App;

public class Worker extends User implements Comparable<Worker> {

	public Worker(String username, String password) {
		super(username, password);
	}

	public String show() {

		return "Nome de usuário : " + this.getUsername() + " - Senha : " + this.getPassword() + "\n";

	}

	@Override
	public int compareTo(Worker o) {
		return this.getUsername().compareTo(o.getUsername());
	}
}
