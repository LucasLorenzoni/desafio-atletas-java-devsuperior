package estrutura_repetitiva;

import java.util.Locale;
import java.util.Scanner;

/*
	Fazer um programa para ler uma quantidade N (supor N > 0), depois ler os dados de N atletas (nome,
sexo, altura, peso). Depois, mostrar um relatório contendo:

	- Peso médio dos atletas;
	- Nome do atleta mais alto;
	- Porcentagem de homens;
	- Altura média das mulheres;

Caso não sejam digitadas mulheres, a altura média não poderá ser calculada (pois divisão por zero não
existe). Neste caso, apenas mostrar a mensagem "Não há mulheres cadastradas".
Fazer validações de dados para altura e peso, não permitindo digitar valores não positivos para esses
dados. Faça também a validação do sexo, não permitindo valores diferentes de F e M.
Dica: para validar o sexo, a lógica é: tem que pedir para o usuário digitar novamente enquanto o valor
digitado for diferente de "F" E diferente de "M"
*/
public class DesafioAtletas {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		// Declaração de variáveis para captação de valores inseridos pelo usuário;
		int i, quantidadeAtletas, contadorAtletasMasculinos = 0, contadorAtletasFemininas = 0;
		String nomeAtleta, atletaMaisAlto = "";
		char sexoAtleta;
		double alturaAtleta, maiorAlturaAtleta = 0.0, pesoAtleta;
		double somaPesoAtletas = 0.0, pesoMedioAtletas;
		double somaAlturasFemininas = 0.0, alturaMediaFeminina;
		double porcentagemAtletasMasculinos;
		
		// Neste trecho, o usuário irá inserir os valores referentes a:
		// Quantidade de atletas que serão cadastrados; 
		// Nome do atleta;
		// Sexo do atleta;
		// Altura do atleta;
		// Peso do atleta;
		
		System.out.printf("Qual a quantidade de atletas? ");
		quantidadeAtletas = sc.nextInt();
		sc.nextLine();
		
		for (i = 0; i < quantidadeAtletas; i++) {
			
			System.out.println("Digite os dados do atleta número " + (i + 1) + ": ");
			System.out.print("Nome: ");
			nomeAtleta = sc.nextLine();
			
			System.out.print("Sexo: ");
			sexoAtleta = sc.next().charAt(0);
			
			// Estrutura de repetição responsável por garantir que um valor válido seja inserido pelo usuário; 
			while (sexoAtleta != 'F' && sexoAtleta != 'M') {
				System.out.print("Valor inválido! Favor digitar F ou M: ");
				sexoAtleta = sc.next().charAt(0);
			}
			
			System.out.print("Altura: ");
			alturaAtleta = sc.nextDouble();
			
			// Estrutura de repetição responsável por garantir que um valor válido seja inserido pelo usuário;
			while (alturaAtleta <= 0) {
				System.out.print("Valor inválido! Favor digitar um valor positivo: ");
				alturaAtleta = sc.nextDouble();
			}
			
			System.out.print("Peso: ");
			pesoAtleta = sc.nextDouble();

			// Estrutura de repetição responsável por garantir que um valor válido seja inserido pelo usuário;
			while (pesoAtleta <= 0) {
				System.out.print("Valor inválido! Favor digitar um valor positivo: ");
				pesoAtleta = sc.nextDouble();
			}
			sc.nextLine();
			
			// Estrutura condicional responsável por:
			// contadorAtletasMasculinos é utilizado no cálculo da porcentagem de atletas masculinos cadastrados;
			// contadorAtletasFemininas é utilizado no cálculo da altura média de atletas femininas cadastradas;
			if (sexoAtleta == 'M') {
				contadorAtletasMasculinos += 1;
			} else {
				contadorAtletasFemininas += 1;
				somaAlturasFemininas = somaAlturasFemininas + alturaAtleta;
			}
			
			// Estrutura condicional responsável por:
			// Atribuir a altura de um atleta a uma variável que será utilizada para exibir a maior altura cadastrada;
			// Atribuir o nome de um atleta a uma variável que será utilizada para exibir o nome do atleta de maior altura;
			if (alturaAtleta > maiorAlturaAtleta) {
				maiorAlturaAtleta = alturaAtleta;
				atletaMaisAlto = nomeAtleta;
			}
			
			somaPesoAtletas = somaPesoAtletas + pesoAtleta;
			
		}
		
		// Neste trecho, serão realizadas as seguintes operações:
		// Cálculo do peso médio dos atletas cadastrados, sendo atribuído a variável 'pesoMedioAtletas';
		// Cálculo da porcentagem de atletas masculinos cadastrados, sendo atribuído a variável 'porcentagemAtletasMasculinos';
		pesoMedioAtletas = somaPesoAtletas / quantidadeAtletas;
		porcentagemAtletasMasculinos = (contadorAtletasMasculinos * 100) / (double) quantidadeAtletas;
		
		System.out.println();
		System.out.println("RELATÓRIO:");
		System.out.printf("Peso médio dos atletas: %.2f%n", pesoMedioAtletas);
		System.out.printf("Atleta mais alto: %s%n", atletaMaisAlto);
		System.out.printf("Porcentagem de homens: %.1f%%%n", porcentagemAtletasMasculinos);
		
		// Estrutura condicional responsável por verificar se:
		// 'contadorAtletasFemininas' é maior do que 0;
		// Caso 'contadorAtletasFemininas' > 0, imprime na tela a mensagem referente a altura média das atletas femininas cadastradas;
		if (contadorAtletasFemininas > 0) {
			alturaMediaFeminina = somaAlturasFemininas / contadorAtletasFemininas;
			System.out.printf("Altura média das mulheres: %.2f%n", alturaMediaFeminina);
		} else {
			System.out.println("Não há mulheres cadastradas.");
		}
		
		sc.close();
	}
}
