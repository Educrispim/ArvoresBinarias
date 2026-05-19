public class ArvoreBinaria {
    No raiz;

    public ArvoreBinaria() {
        this.raiz = new No(null);
        System.out.println("Árvore Binária criada com sucesso!");
    }

//    public void inserir(Integer conteudo) {
//        No novoNo = new No(conteudo);
//
//        if(estaVazia()) {
//            this.raiz = novoNo;
//        } else {
//            No aux = this.raiz;
//            while(true) {
//                if (aux.getConteudo() > novoNo.getConteudo()) {
//                    if (aux.getEsquerda() == null) {
//                        aux.setEsquerda(novoNo);
//                        return;
//                    } else {
//                        aux = aux.getEsquerda();
//                    }
//                } else if (aux.getConteudo() == novoNo.getConteudo()) {
//                    System.out.println("Não é possível informar nós repetidos.");
//                    return;
//                } else {
//                    if (aux.getDireita() == null) {
//                        aux.setDireita(novoNo);
//                        return;
//                    } else {
//                        aux = aux.getDireita();
//                    }
//                }
//            }
//        }
//    }

    public void inserir(Integer conteudo) {
        No novoNo = new No(conteudo);

        if(estaVazia()) {
            this.raiz = novoNo;
        } else {
            inserirRecursivo(novoNo, this.raiz);
        }
    }

    public void inserirRecursivo(No novoNo, No atual) {
        if (atual.getConteudo() > novoNo.getConteudo()) {
            if (atual.getEsquerda() == null) {
                atual.setEsquerda(novoNo);
                System.out.println("O nó " + novoNo.getConteudo() + " foi inserido na Árvore.");
                return;
            } else {
                inserirRecursivo(novoNo, atual.getEsquerda());
            }
        } else if (atual.getConteudo() == novoNo.getConteudo()) {
            System.out.println("Não é possível informar nós repetidos.");
            return;
        } else {
            if (atual.getDireita() == null) {
                atual.setDireita(novoNo);
                System.out.println("O nó " + novoNo.getConteudo() + " foi inserido na Árvore.");
                return;
            } else {
                inserirRecursivo(novoNo, atual.getDireita());
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

    public void remover(Integer conteudo) {
        No noDesejado = new No(conteudo);
        No noEncontrado = procurarNo(this.raiz, noDesejado);

        if (noEncontrado == null ){
            System.out.println("Esse nó não existe");
            return;
        }

        No noPai = procurarNoPai(this.raiz, noEncontrado);

        if (noEncontrado.getEsquerda() != null && noEncontrado.getDireita() != null){
            removerDoisFilhos(noEncontrado, noPai);
        }
        else if(noEncontrado.getEsquerda() == null && noEncontrado.getDireita() == null ){
            removerFolha(noEncontrado, noPai);
        }
        else if (noEncontrado.getEsquerda() != null || noEncontrado.getDireita() != null) {
            removerFilho(noEncontrado, noPai);
        }
    }

    public No procurarNoPai(No atual, No desejado){
        if (atual == null ){
            return null;
        }
        if (atual.getEsquerda() == desejado || atual.getDireita() == null){
            return atual;
        }
        if (desejado.getConteudo() < atual.getConteudo()){
            return procurarNoPai(atual.getEsquerda(), desejado);
        } else {
            return procurarNoPai(atual.getDireita(), desejado);
        }
    };


    public No procurarNo(No atual, No desejado){
        if (atual == null){
            return desejado = null;
        }
        if (desejado.getConteudo().equals(atual.getConteudo())){
            return atual;
        } else if (desejado.getConteudo() > atual.getConteudo()) {
            return procurarNo(atual.getDireita(), desejado);
        }else {
            return procurarNo(atual.getEsquerda(), desejado);
        }
    }

    public void removerFolha(No desejado, No pai){
      if (pai.getEsquerda() == desejado){
          pai.setEsquerda(null);
      } else{
          pai.setDireita(null);
      }
    }

    public void removerFilho(No encontrado, No pai){
        if (encontrado.getEsquerda() != null) {
            pai.setEsquerda(encontrado.getEsquerda());
        } else{
            pai.setDireita(encontrado.getDireita());
        }
    };

    public void removerDoisFilhos(No encontrado, No pai){
        if ()
    };
    }


