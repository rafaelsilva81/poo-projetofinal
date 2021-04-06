package App;

import java.util.ArrayList;
import java.util.Scanner;

public class Application {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		View view = new View();
		Controller controller = new Controller();
		int loginFlag = 0;
		Inventory estoque = new Inventory(new ArrayList<Product>());
		
		WorkerRepository wr = controller.wr;
		
		while (loginFlag == 0) {
			loginFlag = controller.loginRoutine();
		}
				
		try {
			System.out.println("-------- CARFIX -----------\n"
					+ "Digite um comando: ");
			while(true) {		
				System.out.print("$");
				
				String line = sc.nextLine();
				String[] cmd = line.split(" ");
				String comando = cmd[0];
				
				switch(comando) {
				case "addProduct" :
					if (loginFlag == 2) {
						try {
							Product addedProduct = new Product(cmd[1], Integer.parseInt(cmd[2]), cmd[3], cmd[4]);
							if (controller.registerProduct(addedProduct, estoque)) {
								System.out.println("Produto adicionado com Sucesso");
							}
						} catch (Exception e) {
							System.out.println("Parametros passados incorretamente, verifique os dados enviados");
						}
					} else {
						System.out.println("Apenas administradores podem realizar essa função");
					}	
					break;
				case "removeProduct" :
					if (loginFlag == 2) {
						try {
							if (controller.removeProduct(Integer.parseInt(cmd[1]), estoque)) {
								System.out.println("Produto Removido com Sucesso!");
							}
						} catch (Exception e) {
							System.out.println("Parametros passados incorretamente, verifique os dados enviados");
						}
					} else {
						System.out.println("Apenas administradores podem realizar essa função");
					}
					break;
				case "show" :
					try {
						view.show(estoque);
					} catch(Exception e) {
						System.out.println("Parametros passados incorretamente, verifique os dados enviados");
					}
					break;
				case "editProduct" :
					try {
						controller.editProduct(Integer.parseInt(cmd[1]), estoque);
					} catch (Exception e) {
						System.out.println("Parametros passados incorretamente, verifique os dados enviados");
					}
					break;
				case "exit" :
					System.out.println("Aplicação Finalizando...");
					System.exit(0);
					break;
				case "logoff" :
					System.out.println("\n\n");
					loginFlag = controller.loginRoutine();
					break;
				case "addWorker" :
					if (loginFlag == 2) {
						try {
							Worker addedWorker = new Worker(cmd[1], cmd[2]);
							if (controller.registerWorker(addedWorker, wr)) {
								System.out.println("Funcionário Cadastrado com Sucesso");
							}
						} catch (Exception e) {
							System.out.println("Parametros passados incorretamente, verifique os dados enviados");
						}
					} else {
						System.out.println("Apenas administradores podem realizar essa função");
					}
					break;
				case "showWorkers" :
					if (loginFlag == 2) {
						try {
							view.show(wr);
						} catch (Exception e) {
							System.out.println("Parametros passados incorretamente, verifique os dados enviados");
						}
					} else {
						System.out.println("Apenas administradores podem realizar essa função");
					}
					break;
				case "removeWorker" :
					if (loginFlag == 2) {
						try {
							Worker removedWorker = new Worker(cmd[1], cmd[2]);
							if (controller.removeWorker(removedWorker, wr)) {
								System.out.println("Funcionário Removido com Sucesso");
							}
						} catch (Exception e) {
							System.out.println("Parametros passados incorretamente, verifique os dados enviados");
						}
					} else {
						System.out.println("Apenas administradores podem realizar essa função");
					}
					break;
				default :
					System.out.println("Comando não reconhecido, tente novamente");
				}
			}
		} catch (Exception e) {
			System.out.println("Houve um erro não identificado : \n");
			e.printStackTrace();
		}
		
		sc.close();
	}
}
