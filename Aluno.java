public class Aluno {

    // Atributos básicos
    private int codigo;
    private String nome;
    private String dataNascimento;
    private String email;
    private String senha;

    // Curso em que o aluno está matriculado
    private Curso cursoMatriculado;

    // Notas
    private double[] notas = new double[3];
    private boolean[] lancada = new boolean[3];

    // Mensalidades
    private Mensalidade[] mensalidades = new Mensalidade[12];
    private int numParcelas = 12;


    // Construtor
    public Aluno(int codigo, String nome, String dataNascimento,
                 String email, String senha) {

        this.codigo = codigo;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.senha = senha;
    }


    // GETTERS

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public Curso getCursoMatriculado() {
        return cursoMatriculado;
    }


    // SETTERS

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setCursoMatriculado(Curso cursoMatriculado) {
        this.cursoMatriculado = cursoMatriculado;
    }


    // Exibe os dados do aluno
    public void exibeDados() {

        System.out.println("Código: " + codigo);
        System.out.println("Nome: " + nome);
        System.out.println("Data de nascimento: " + dataNascimento);
        System.out.println("E-mail: " + email);

        if (cursoMatriculado != null) {
            System.out.println("Curso: " + cursoMatriculado.getNome());
        } else {
            System.out.println("Curso: Não matriculado");
        }
    }


    // =========================
    // PARTE 04 - NOTAS
    // =========================

    public void lancarNotas(double nota1, double nota2, double nota3) {

        notas[0] = nota1;
        notas[1] = nota2;
        notas[2] = nota3;

        lancada[0] = true;
        lancada[1] = true;
        lancada[2] = true;
    }


    public double calcularMedia() {

        return (notas[0] + notas[1] + notas[2]) / 3;
    }


    public void exibirNotas() {

        System.out.println("Notas do aluno: " + nome);

        for (int i = 0; i < notas.length; i++) {

            System.out.println("Nota " + (i + 1) + ": " + notas[i]);
        }

        System.out.printf("Média: %.2f%n", calcularMedia());
    }


    public boolean possuiNotasLancadas() {

        return lancada[0] && lancada[1] && lancada[2];
    }


// =========================
// PARTE 05 - MENSALIDADES
// =========================

public void adicionarMensalidades(double[] valores) {

    for (int i = 0; i < 12; i++) {

        mensalidades[i] = new Mensalidade(valores[i]);
    }
}


public void exibirMensalidades() {

    if (mensalidades == null) {

        System.out.println("Nenhuma mensalidade cadastrada.");
        return;
    }

    System.out.println("Mensalidades de " + nome);

    for (int i = 0; i < 12; i++) {

        String status;

        if (mensalidades[i].isPago()) {
            status = "PAGO";
        } else {
            status = "PENDENTE";
        }

        System.out.printf(
            "Parcela %d - R$ %.2f - %s%n",
            i + 1,
            mensalidades[i].getValor(),
            status
        );
    }
}


public void pagarMensalidade(int indice) {

    if (mensalidades == null) {

        System.out.println("Nenhuma mensalidade cadastrada.");
        return;
    }

    if (indice < 0 || indice >= 12) {

        System.out.println("Número de parcela inválido.");
        return;
    }

    mensalidades[indice].darBaixa();

    System.out.println("Parcela paga com sucesso!");
}
}