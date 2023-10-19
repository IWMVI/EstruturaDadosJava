package hash;

class HashAlfabetica extends Hash {
    public HashAlfabetica(int tamVet, int max) {
        super(tamVet, max);
    }

    public void printAlfabetico() {
        // Implementação para imprimir em ordem alfabética
        for (char letra = 'A'; letra <= 'Z'; letra++) {
            for (int i = 0; i < maxPosicoes; i++) {
                if (estrutura[i] != null && estrutura[i].getNome().toUpperCase().charAt(0) == letra) {
                    System.out.println("Posicao: " + i);
                    System.out.println("ID: " + estrutura[i].getId());
                    System.out.println("Nome: " + estrutura[i].getNome());
                    System.out.println();
                }
            }
        }
    }

    public void searchPorLetra(char letra, boolean[] busca) {
        letra = Character.toUpperCase(letra);
        for (int i = 0; i < maxPosicoes; i++) {
            if (estrutura[i] != null && estrutura[i].getNome().toUpperCase().charAt(0) == letra) {
                busca[0] = true;
                break;
            }
        }
        busca[0] = false;
    }

    public void verificarOrdemAlfabetica() {
        // Implementação para verificar a ordem alfabética
        boolean ordemCorreta = true;
        for (int i = 1; i < maxPosicoes; i++) {
            if (estrutura[i] != null && estrutura[i - 1] != null &&
                estrutura[i].getNome().compareToIgnoreCase(estrutura[i - 1].getNome()) < 0) {
                ordemCorreta = false;
                break;
            }
        }

        if (ordemCorreta) {
            System.out.println("A estrutura está em ordem alfabética.");
        } else {
            System.out.println("A estrutura não está em ordem alfabética.");
        }
    }

    @Override
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
}
