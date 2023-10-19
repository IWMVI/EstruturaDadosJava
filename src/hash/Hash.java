package hash;

class Hash {
    protected int maxItens;
    protected int qtdItens;
    protected int maxPosicoes;
    protected Pessoa[] estrutura;

    public Hash(int tamVet, int max) {
        qtdItens = 0;
        maxItens = max;
        maxPosicoes = tamVet;
        estrutura = new Pessoa[tamVet];
    }

    public void push(Pessoa pessoa) {
        if (qtdItens < maxItens) {
            int local = findEmptyPosition(pessoa.getId());
            estrutura[local] = pessoa;
            qtdItens++;
        } else {
            System.out.println("A estrutura está cheia. Não é possível adicionar mais elementos.");
        }
    }

    public void pop(Pessoa pessoa) {
        int local = findPersonPosition(pessoa.getId());
        if (local != -1) {
            estrutura[local] = null;
            qtdItens--;
        }
    }

    public Pessoa search(int id) {
        int local = findPersonPosition(id);
        return (local != -1) ? estrutura[local] : null;
    }

    public boolean isFull() {
        return (qtdItens == maxItens);
    }

    public void print() {
        System.out.println("Tabela Hash: \n");
        for (int i = 0; i < maxPosicoes; i++) {
            if (estrutura[i] != null) {
                printPersonDetails(i, estrutura[i]);
            }
        }
    }

    private int findEmptyPosition(int id) {
        int local = id % maxPosicoes;
        while (estrutura[local] != null) {
            local = (local + 1) % maxPosicoes;
        }
        return local;
    }

    private int findPersonPosition(int id) {
        int local = id % maxPosicoes;
        while (estrutura[local] != null) {
            if (estrutura[local].getId() == id) {
                return local;
            }
            local = (local + 1) % maxPosicoes;
        }
        return -1; // Pessoa não encontrada
    }

    private void printPersonDetails(int position, Pessoa pessoa) {
        System.out.println("Posicao: " + position);
        System.out.println("ID: " + pessoa.getId());
        System.out.println("Nome: " + pessoa.getNome());
        System.out.println();
    }
}
