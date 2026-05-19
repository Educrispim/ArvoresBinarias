public class Main {
    public static void main(String[] args) {
        System.out.println("=== INÍCIO DOS TESTES DA ÁRVORE BINÁRIA ===\n");

        testarRemocaoNoInexistente();
        testarRemocaoFolha();
        testarRemocaoComUmFilho();
        testarRemocaoComDoisFilhosMenorDosMaiores();
        testarRemocaoDaRaizComDoisFilhos();

        System.out.println("=== FIM DOS TESTES ===");
    }

    private static void inserirValoresPadrao(ArvoreBinaria arvore) {
        System.out.println("Inserindo valores: 7, 2, 9, 11, 10, 0, 3");
        arvore.inserir(7);
        arvore.inserir(2);
        arvore.inserir(9);
        arvore.inserir(11);
        arvore.inserir(10);
        arvore.inserir(0);
        arvore.inserir(3);
    }

    public static void testarRemocaoNoInexistente() {
        System.out.println("--- Teste 1: Remover nó que não existe ---");
        ArvoreBinaria arvore = new ArvoreBinaria();
        inserirValoresPadrao(arvore);

        System.out.println("\nTentando remover o nó 99...");
        arvore.remover(99);
        System.out.println("Árvore inalterada");
        arvore.exibir("Em");
        System.out.println();
    }

    public static void testarRemocaoFolha() {
        System.out.println("--- Teste 2: Remover um nó folha ---");
        ArvoreBinaria arvore = new ArvoreBinaria();
        inserirValoresPadrao(arvore);

        // As folhas dessa árvore são 0, 3 e 10. Vou remover o 10.
        System.out.println("\nRemovendo o nó folha 10...");
        arvore.remover(10);

        System.out.println("Árvore após a remoção:");
        arvore.exibir("Em");
        System.out.println();
    }

    public static void testarRemocaoComUmFilho() {
        System.out.println("--- Teste 3: Remover nó com apenas 1 filho ---");
        ArvoreBinaria arvore = new ArvoreBinaria();
        inserirValoresPadrao(arvore);

        // O nó 11 possui apenas o 10 na esquerda. Vou remover o 11.
        System.out.println("\nRemovendo o nó 11 ");
        arvore.remover(11);

        System.out.println("Árvore após a remoção:");
        arvore.exibir("Em");
        System.out.println();
    }

    public static void testarRemocaoComDoisFilhosMenorDosMaiores() {
        System.out.println("--- Teste 4: Remover nó com 2 filhos (Menor dos Maiores) ---");
        ArvoreBinaria arvore = new ArvoreBinaria();
        inserirValoresPadrao(arvore);

        // O nó 2 possui os filhos 0 e 3.
        // Pelo 'Menor dos Maiores' (menor da subárvore direita), o 3 deverá substituir o 2.
        System.out.println("\nRemovendo o nó 2 (Substituirá pelo 'Menor dos Maiores': nó 3)...");
        arvore.remover(2);

        System.out.println("Árvore após a remoção:");
        arvore.exibir("Em");
        System.out.println();
    }

    public static void testarRemocaoDaRaizComDoisFilhos() {
        System.out.println("--- Teste 5: Remover nó raiz que possui 2 filhos ---");
        ArvoreBinaria arvore = new ArvoreBinaria();
        inserirValoresPadrao(arvore);

        // A raiz é o nó 7.
        // O menor dos maiores da direita completa da raiz é o nó 9 (pois 9 não tem filho esquerdo).
        // Logo, 9 deve virar a nova raiz.
        System.out.println("\nRemovendo a raiz 7 (Substituirá pelo 'Menor dos Maiores': nó 9)...");
        arvore.remover(7);

        System.out.println("Árvore após a remoção da raiz (Em Ordem - Esperado: 0, 2, 3, 9, 10, 11):");
        arvore.exibir("Em");

        System.out.println("\nValidando a nova raiz em Pré-Ordem (Esperado ver o 9 ocupando o 1º lugar):");
        // Pré-Ordem esperado: 9, 2, 0, 3, 11, 10
        arvore.exibir("Pre");
        System.out.println();
    }
}