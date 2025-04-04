public class Main {
    static class MaxHeap {
        private int[] heap;
        private int size;

        // Construtor que inicializa o heap com um array dado
        public MaxHeap(int[] arr) {
            this.size = arr.length;
            this.heap = arr;
            construirMaxHeap();
        }

        // Função para retornar o índice do filho à esquerda
        private int esquerda(int i) {
            return 2 * i + 1;
        }

        // Função para retornar o índice do filho à direita
        private int direita(int i) {
            return 2 * i + 2;
        }

        // Função que maximiza o heap, garantindo a propriedade de heap máximo
        private void maximizaHeap(int i) {
            int l = esquerda(i);
            int r = direita(i);
            int maior = i;

            // Verifica se o filho da esquerda é maior que o nó atual
            if (l < size && heap[l] > heap[maior]) {
                maior = l;
            }

            // Verifica se o filho da direita é maior que o maior nó
            if (r < size && heap[r] > heap[maior]) {
                maior = r;
            }

            // Se o maior não for o nó atual, troca e chama recursivamente
            if (maior != i) {
                trocar(i, maior);
                maximizaHeap(maior);
            }
        }

        // Função para trocar dois elementos no heap
        private void trocar(int i, int j) {
            int temp = heap[i];
            heap[i] = heap[j];
            heap[j] = temp;
        }

        // Função que constrói o heap máximo
        private void construirMaxHeap() {
            // Começa do último nó não-folha até o nó raiz
            for (int i = size / 2 - 1; i >= 0; i--) {
                maximizaHeap(i);
            }
        }

        // Função para obter o heap
        public int[] getHeap() {
            return heap;
        }
    }

    public static void main(String[] args) {
        // Exemplo de array para o Max Heap
        int[] arr = {4, 10, 3, 5, 1, 18};

        // Criação do objeto MaxHeap
        MaxHeap maxHeap = new MaxHeap(arr);

        // Exibe o heap antes da construção do max-heap
        System.out.println("Antes de construir o max-heap:");
         {
            System.out.print("4 10 3 5 1 18");
        }
        System.out.println();

        // Constrói o max-heap
        maxHeap.construirMaxHeap();

        // Exibe o heap depois da construção do max-heap
        System.out.println("Depois de construir o max-heap:");
        for (int num : maxHeap.getHeap()) {
            System.out.print(num + " ");
        }
    }
}
