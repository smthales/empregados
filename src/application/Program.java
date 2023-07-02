package application;

import java.util.Locale;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import entities.Employee;


public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("Quantos empregados serão registrados? ");
		int n;
		n = sc.nextInt();
		sc.nextLine();

		List<Employee> empregados = new ArrayList<>();
		Integer id;
		double percentage;

		for (int i = 0; i < n; i++) {
			System.out.printf("Employee %d%n", i + 1);

			String name;
			Double salary;
			System.out.print("Id: ");
			id = sc.nextInt();
			sc.nextLine();
			while (hasId(empregados, id)) {
				System.out.print("Id já escolhido, escolha outro: ");
				id = sc.nextInt();
				sc.nextLine();
			}
			System.out.print("Nome: ");
			name = sc.nextLine();
			System.out.print("Salário: ");
			salary = sc.nextDouble();
			empregados.add(new Employee(id, name, salary));

		}

		System.out.print("Digite o id do empregado que receberá aumento: ");
		Integer id2;
		id2 = sc.nextInt();
		
		while(existId(empregados, id2) == false) {
			
			System.out.println("Esse id não existe, olha outro: ");
			id2 = sc.nextInt();
		}
		
		final Integer finalId = id2;
		
		System.out.print("Digite o percentual de aumento: ");
		percentage = sc.nextDouble();

		Employee empregado = empregados.stream().filter(x -> x.getId() == finalId).findFirst().orElse(null);
		empregado.raise(percentage);

		System.out.println("Lista de empregados: ");
		for (Employee x : empregados) {
			System.out.println(x);
		}

		sc.close();
	}

	public static boolean hasId(List<Employee> list, Integer id) {
		
		for(Employee x : list) {
			if(x.getId() == id) {
				return true;
			}	
		}
		return false;
	}

	public static boolean existId(List<Employee> list, Integer id) {
		
		for(Employee x : list) {
			if(x.getId() == id) {
				return true;
			}
		}
		
		return false;
	}


}