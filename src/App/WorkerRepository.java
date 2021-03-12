package App;

import java.util.ArrayList;
import java.util.Comparator;

public class WorkerRepository implements Comparator<Worker> {
	private ArrayList<Worker> Workers;

	public WorkerRepository() {
		super();
		this.Workers = new ArrayList<Worker>();
	}

	public ArrayList<Worker> getWorkers() {
		return Workers;
	}

	@Override
	public int compare(Worker w1, Worker w2) {
		if (w1.getUsername().equalsIgnoreCase(w2.getUsername())) {
			return 1;
		} else {
			return 0;
		}

	}

}
