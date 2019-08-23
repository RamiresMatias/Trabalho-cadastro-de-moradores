package main;

public class Predio {

    private String nome; // nome do prÃ©dio
    private String endereco; // endereÃ§o do prÃ©dio
    private Andar andares[]; // matriz de andares

    // construtor cheio recebe o nome e endereÃ§o do prÃ©dio
    public Predio(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;

        // vamos inicializar os objetos da classe Andar e numerÃ¡-los de 1 atÃ© 5
        andares = new Andar[5];
        for (int i = 0; i < andares.length; i++) {
            andares[i] = new Andar(i + 1);
        }
    }

    // construtor vazio
    public Predio() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Andar[] getAndares() {
        return andares;
    }

    public void setAndares(Andar[] andares) {
        this.andares = andares;
    }

}
