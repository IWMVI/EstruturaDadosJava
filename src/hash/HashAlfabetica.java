package hash;

import java.util.TreeSet;
class HashAlfabetica extends Hash {
    private TreeSet<Pessoa> pessoasOrdenadas;

    public HashAlfabetica(int tamVet, int max) {
        super(tamVet, max);
        pessoasOrdenadas = new TreeSet<>((p1, p2) -> p1.getNome().compareToIgnoreCase(p2.getNome()));
    }

    @Override
    public void push(Pessoa pessoa) {
        super.push(pessoa);
        pessoasOrdenadas.add(pessoa);
    }

    @Override
    public void pop(Pessoa pessoa) {
        super.pop(pessoa);
        pessoasOrdenadas.remove(pessoa);
    }

    @Override
    public void print() {
        for (Pessoa pessoa : pessoasOrdenadas) {
            System.out.println("Posicao: " + (pessoa.getId() % maxPosicoes));
            System.out.println("ID: " + pessoa.getId());
            System.out.println("Nome: " + pessoa.getNome());
            System.out.println();
        }
    }

    public void verificarOrdemAlfabetica() {
        boolean ordemCorreta = true;
    
        Pessoa[] pessoasArray = pessoasOrdenadas.toArray(new Pessoa[0]);
    
        for (int i = 0; i < pessoasArray.length - 1; i++) {
            if (pessoasArray[i].getNome().compareToIgnoreCase(pessoasArray[i + 1].getNome()) > 0) {
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
    
}
