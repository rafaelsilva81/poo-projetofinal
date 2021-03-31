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
			for (int i = 0; i < in.getProductList().size(); i++) {
				if (in.compare(in.getProductList().get(i), p) == 1) {
					System.out.println("Produto j� existente");
					return false;
				}
			}

			in.getProductList().add(p);

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
				System.out.println("PAINEL DE EDI��O DE PRODUTO : ");
				System.out.println("Produto editado : " + in.getProductList().get(index).getProductName());

				System.out.println(":.Digite o campo que deseja alterar e o novo valor desse campo.:");
				System.out.println(":.Ou digite \"parar\" para retornar ao painel principal.:");
				System.out.print("$");
				String line = sc.nextLine();
				String[] cmd = line.split(" ");
				String comando = cmd[0];

				switch (comando) {
				case "nome":
					for (int i = 0; i < in.getProductList().size(); i++) {
						if (in.getProductList().get(i).getProductName().equalsIgnoreCase(cmd[1])) {
							System.out.println("Nome de produto j� existente");
							break;
						} else {
							in.getProductList().get(index).setProductName(cmd[1]);
						}
					}
					break;
				case "categoria":
					try {
						in.getProductList().get(index).setCategory(cmd[1]);
					} catch (Exception e) {
						System.out.println("Argumento inv�lido");
					}

					break;
				case "quantidade":
					try {
						in.getProductList().get(index).setQuantity(Integer.parseInt(cmd[1]));
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
							in.getProductList().get(index).setCondition((cmd[1]));
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
			System.out.println("Produto n�o encontrado... Retornando");
		}
		//sc.close();
		return true;
	}

	public boolean removeProduct(int index, Inventory in) {
		try {
			String name = in.getProductList().get(index).getProductName();
			for (int i = 0; i < in.getProductList().size(); i++) {
				if (in.getProductList().get(i).getProductName().equalsIgnoreCase(name)) {
					in.getProductList().remove(index);
					return true;
				}
			}
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Produto n�o encontrado");
		}
		return true;

	}

}
