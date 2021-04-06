package App;

import java.util.Collections;

public class View {

	public void show(WorkerRepository f) {
		Collections.sort(f.getWorkers());
		String res = "";

		for (int i = 0; i < f.getWorkers().size(); i++) {
			res += f.getWorkers().get(i).show();
		}

		if (res.equalsIgnoreCase("")) {
			System.out.println("Nenhum funcionário cadastrado");
		} else {
			System.out.println(res);
		}

	}

	public void show(Manager a) {
		System.out.println(a.getUsername() + " - " + a.getPassword());

	}

	public void show(Inventory e) {
		Collections.sort(e.getProductList());
		String res = "\nNOME | CONDIÇÃO | CATEGORIA | QTD |\n"
				+ "-------------------------------------------\n";
		
		for (int i = 0; i < e.getProductList().size(); i++) {
			res += e.getProductList().get(i).show();
		}

		if (res.equalsIgnoreCase("")) {
			System.out.println("Nenhum produto cadastrado no estoque");
		} else {
			System.out.println(res);
		}

	}
}
