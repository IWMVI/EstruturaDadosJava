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
            int local = pessoa.getId() % maxPosicoes;
            while (estrutura[local] != null) {
                local = (local + 1) % maxPosicoes; // Tratamento de colisão linear
            }
            estrutura[local] = pessoa;
            qtdItens++;
        } else {
            System.out.println("A estrutura está cheia. Não é possível adicionar mais elementos.");
        }
    }

    public void pop(Pessoa pessoa) {
        int local = pessoa.getId() % maxPosicoes;
        while (estrutura[local] != null) {
            if (estrutura[local].getId() == pessoa.getId()) {
                estrutura[local] = null;
                qtdItens--;
                break;
            }
            local = (local + 1) % maxPosicoes; // Tratamento de colisão linear
        }
    }

    public Pessoa search(int id) {
        int local = id % maxPosicoes;
        while (estrutura[local] != null) {
            if (estrutura[local].getId() == id) {
                return estrutura[local];
            }
            local = (local + 1) % maxPosicoes; // Tratamento de colisão linear
        }
        return null; // Pessoa não encontrada
    }

    public boolean isFull() {
        return (qtdItens == maxItens);
    }

    public void print() {
        System.out.println("Tabela Hash: \n");
        for (int i = 0; i < maxPosicoes; i++) {
            if (estrutura[i] != null) {
                System.out.println("Posicao: " + i);
                System.out.println("ID: " + estrutura[i].getId());
                System.out.println("Nome: " + estrutura[i].getNome());
                System.out.println();
            }
        }
    }
}
