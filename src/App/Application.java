package App;

import java.util.ArrayList;
import java.util.Scanner;

public class Application {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		View view = new View();
		Controller controller = new Controller();
		Inventory estoque = new Inventory(new ArrayList<Product>());
		
		try {
			System.out.println("-------- CARFIX -----------\n"
					+ "Digite um comando: \n");
			
			while(true) {				
				System.out.print("$");
				
				String line = sc.nextLine();
				String[] cmd = line.split(" ");
				String comando = cmd[0];
				
				switch(comando) {
				case "addProduct" :
					try {
						Product addedProduct = new Product(cmd[1], Integer.parseInt(cmd[2]), cmd[3], cmd[4]);
						if (controller.registerProduct(addedProduct, estoque)) {
							System.out.println("Produto adicionado com Sucesso");
						}
					} catch (Exception e) {
						System.out.println("Parametros passados incorretamente, verifique os dados enviados");
					}
					break;
				case "removeProduct" :
					try {
						if (controller.removeProduct(Integer.parseInt(cmd[1]), estoque)) {
							System.out.println("Produto Removido com Sucesso!");
						}
					} catch (Exception e) {
						System.out.println("Parametros passados incorretamente, verifique os dados enviados");
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
