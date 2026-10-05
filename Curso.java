public class Curso {

    private int codigo;
    private String nome;
    private int duracao;


    // Construtor
    public Curso(int codigo, String nome, int duracao) {

        this.codigo = codigo;
        this.nome = nome;
        this.duracao = duracao;
    }


    // Getters

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public int getDuracao() {
        return duracao;
    }


    // Setters

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }


    // Exibe os dados do curso

    public void exibeDados() {

        System.out.println("Código: " + codigo);
        System.out.println("Curso: " + nome);
        System.out.println("Duração: " + duracao + " horas");
    }
}