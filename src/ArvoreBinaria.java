public class ArvoreBinaria {
    No raiz;

    public ArvoreBinaria() {
        this.raiz = new No(null);
        System.out.println("Árvore Binária criada com sucesso!");
    }

    public void inserir(Integer conteudo) {
        No novoNo = new No(conteudo);

        if(estaVazia()) {
            this.raiz = novoNo;
        } else {
            No aux = this.raiz;
            while(true) {
                if (aux.getConteudo() > novoNo.getConteudo()) {
                    if (aux.getEsquerda() == null) {
                        aux.setEsquerda(novoNo);
                        return;
                    } else {
                        aux = aux.getEsquerda();
                    }
                } else if (aux.getConteudo() == novoNo.getConteudo()) {
                    System.out.println("Não é possível informar nós repetidos.");
                    return;
                } else {
                    if (aux.getDireita() == null) {
                        aux.setDireita(novoNo);
                        return;
                    } else {
                        aux = aux.getDireita();
                    }
                }
            }
        }
    }

    public boolean estaVazia() {
        if(this.raiz.getConteudo() == null) {
            return true;
        } else {
            return false;
        }
    }

    private void preOrdem(No no) {
        if(no == null) {
            return;
        }
        System.out.println(no.getConteudo());
        preOrdem(no.getEsquerda());
        preOrdem(no.getDireita());
    }

    private void emOrdem(No no) {
        if(no == null) {
            return;
        }
        emOrdem(no.getEsquerda());
        System.out.println(no.getConteudo());
        emOrdem(no.getDireita());
    }

    private void posOrdem(No no) {
        if(no == null) {
            return;
        }
        posOrdem(no.getEsquerda());
        posOrdem(no.getDireita());
        System.out.println(no.getConteudo());
    }

    public void exibir(String percurso) {
        switch (percurso){
            case("Pre"):
                preOrdem(this.raiz);
                break;
            case("Em"):
                emOrdem(this.raiz);
                break;
            case("Pos"):
                posOrdem(this.raiz);
                break;
        }
    }


}
