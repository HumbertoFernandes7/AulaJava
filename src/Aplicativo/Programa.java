package Aplicativo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import entities.Produto;
import entities.ProdutoImportado;
import entities.ProdutoUsado;

public class Programa {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);

		List<Produto> lista = new ArrayList<>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("Digite o numero de Produtos: ");
		int numeroProdutos = sc.nextInt();

		for (int i = 1; i <= numeroProdutos; i++) {
			System.out.println("Produto #" + i + ": ");
			System.out.println("O produto é comum, usado ou importado? : (c/u/i)?");
			char ch = sc.next().charAt(0);

			System.out.println("Nome: ");
			String nome = sc.next();

			System.out.println("Preço");
			Double preco = sc.nextDouble();

			if (ch == 'c') {
				Produto produto = new Produto(nome, preco);
				lista.add(produto);

			} else if (ch == 'u') {
				System.out.println("Data de fabricação");
				Date dataFabricação = sdf.parse(sc.next());
				Produto produtoUsado = new ProdutoUsado(nome, preco, dataFabricação);
				lista.add(produtoUsado);

			} else if (ch == 'i') {
				System.out.println("Qual a taxa da anfandega? : ");
				double taxaAlfandega = sc.nextDouble();
				Produto produtoImportado = new ProdutoImportado(nome, preco, taxaAlfandega);
				lista.add(produtoImportado);
			}
		}
		
		System.out.println("Etiqueta do Produto: ");
		for (Produto produto : lista ) {
			System.out.println(produto.etiquetaProduto());
		}

		sc.close();
	}
}
