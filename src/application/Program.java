package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.TaxPayer;

public class Program {
	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner scanner = new Scanner(System.in);

		List<TaxPayer> list = new ArrayList<>();

		System.out.print("Quantos contribuintes você vai digitar? ");
		int n = scanner.nextInt();

		for (int i = 0; i < n; i++) {
			System.out.println();
			System.out.printf("Digite os dados do %do contribuinte: %n", i + 1);
			System.out.print("Renda anual com salário: ");
			Double salary = scanner.nextDouble();

			System.out.print("Renda anual com prestação de serviço: ");
			Double service = scanner.nextDouble();

			System.out.print("Renda anual com ganho de capital: ");
			Double capit = scanner.nextDouble();

			System.out.print("Gastos médicos: ");
			Double health = scanner.nextDouble();

			System.out.print("Gastos educacionais: ");
			Double education = scanner.nextDouble();

			list.add(new TaxPayer(salary, service, capit, health, education));
		}

		int pos = 1;
		for (TaxPayer tax : list) {
			System.out.println();
			System.out.printf("Resumo do %do contribuinte: %n", pos);
			System.out.println(tax);
			pos++;
		}

		scanner.close();
	}
}
