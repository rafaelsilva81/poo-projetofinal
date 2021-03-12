package App;

import java.util.Scanner;

public class Controller {

	public boolean registerWorker(Worker w, WorkerRepository wr) throws InvalidArgument {
		if (w instanceof Worker) {
			for (int i = 0; i < wr.getWorkers().size(); i++) {
				if (wr.compare(wr.getWorkers().get(i), w) == 1) {
					System.out.println("funcion�rio j� existente");
				}
			}

			wr.getWorkers().add(w);

			return true;
		} else {
			throw new InvalidArgument("Fail: Objeto n�o � do tipo funcion�rio(worker)");
		}

	}

	public boolean registerProduct(Product p, Inventory in) throws InvalidArgument {
		if (p instanceof Product) {
			for (int i = 0; i < in.getInventories().size(); i++) {
				if (in.compare(in.getInventories().get(i), p) == 1) {
					System.out.println("Produto j� existente");
				}
			}

			in.getInventories().add(p);

			return true;
		} else {
			throw new InvalidArgument("Fail: Objeto n�o � do tipo funcion�rio(worker)");
		}
	}

	public boolean editProduct(int index, Inventory in) {
		Scanner sc = new Scanner(System.in);
		boolean noStop = true;
		try {
			while (noStop) {
				System.out.println("Voc� est� editando o produto:");
				// Mostrar o produto que ta sendo editado
				//
				// Mostrar poss�veis edi��es

				System.out.println("Digite um comando:");
				System.out.print("$");
				String line = sc.nextLine();
				String[] cmd = line.split(" ");
				String comando = cmd[0];

				switch (comando) {
				case "nome":
					for (int i = 0; i < in.getInventories().size(); i++) {
						if (in.getInventories().get(i).getProductName().equalsIgnoreCase(cmd[1])) {
							System.out.println("Nome de produto j� existente");
							break;
						} else {
							in.getInventories().get(index).setProductName(cmd[1]);
						}
					}
					break;
				case "categoria":
					try {
						in.getInventories().get(index).setCategory(cmd[1]);
					} catch (Exception e) {
						System.out.println("Argumento inv�lido");
					}

					break;
				case "quantidade":
					try {
						in.getInventories().get(index).setQuantity(Integer.parseInt(cmd[1]));
					} catch (Exception e) {
						System.out.println("Argumento inv�lido");
					}

					break;

				case "condicao":
					try {
						if (!cmd[1].equalsIgnoreCase("Novo") && !cmd[1].equalsIgnoreCase("Usado")) {
							System.out.println("Condi��o inv�lido");// Talvez um outro nome seja melhor no lugar de
																	// condi��o.
						} else {
							in.getInventories().get(index).setCondition((cmd[1]));
						}
					} catch (Exception e) {
						System.out.println("Argumento inv�lido");
					}

					break;
					
				case "parar":
					noStop = false;

					break;

				default:
					System.out.println("Comando n�o existente");
					break;
				}
			}
			
			
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Produto n�o encontrado");
		}
		sc.close();
		return true;
	}

	public boolean removeProduct(int index, Inventory in) {
		try {
			String name = in.getInventories().get(index).getProductName();
			for (int i = 0; i < in.getInventories().size(); i++) {
				if (in.getInventories().get(i).getProductName().equalsIgnoreCase(name)) {
					in.getInventories().remove(index);
					return true;
				}
			}
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Produto n�o encontrado");
		}
		return true;

	}

}
