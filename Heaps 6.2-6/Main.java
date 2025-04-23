import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a quantidade de elementos no heap: ");
        int quantidade = scanner.nextInt();
        MaxHeap maxHeap = new MaxHeap(quantidade);

        System.out.println("Digite os valores um por um:");
        for (int i = 0; i < quantidade; i++) {
            System.out.print("Elemento " + (i + 1) + ": ");
            int valor = scanner.nextInt();
            maxHeap.insert(valor);
        }

        System.out.println("Heap construído:");
        maxHeap.printHeap();

        System.out.println("\nDeseja extrair o máximo? (s/n)");
        String resposta = scanner.next();

        while (resposta.equalsIgnoreCase("s") && maxHeap.getSize() > 0) {
            System.out.println("Máximo extraído: " + maxHeap.extractMax());
            System.out.println("Heap após remoção:");
            maxHeap.printHeap();

            if (maxHeap.getSize() > 0) {
                System.out.println("\nDeseja extrair outro máximo? (s/n)");
                resposta = scanner.next();
            } else {
                System.out.println("Heap está vazio!");
                break;
            }
        }

        System.out.println("Programa encerrado.");
        scanner.close();
    }
}
