public class ListaDeAlunos {

    private Aluno[] alunos;
    private int totalAlunos;


    // Construtor

    public ListaDeAlunos(int capacidade) {

        alunos = new Aluno[capacidade];
        totalAlunos = 0;
    }


    // Adiciona aluno verificando duplicidade

    public boolean adicionarAluno(Aluno a) {

        if (a == null) {
            return false;
        }


        // Verifica se o código já existe

        for (int i = 0; i < totalAlunos; i++) {

            if (alunos[i].getCodigo() == a.getCodigo()) {

                System.out.println(
                    "Já existe um aluno com esse código."
                );

                return false;
            }
        }


        // Verifica se existe espaço

        if (totalAlunos >= alunos.length) {

            System.out.println(
                "A lista de alunos está cheia."
            );

            return false;
        }


        alunos[totalAlunos] = a;
        totalAlunos++;

        return true;
    }


    // Exibe todos os alunos

    public void exibirLista() {

        if (totalAlunos == 0) {

            System.out.println(
                "Nenhum aluno cadastrado."
            );

            return;
        }


        for (int i = 0; i < totalAlunos; i++) {

            System.out.println(
                "\n----------------------------"
            );

            alunos[i].exibeDados();
        }
    }


    // Busca aluno pelo código

    public Aluno buscarAluno(int codigo) {

        for (int i = 0; i < totalAlunos; i++) {

            if (alunos[i].getCodigo() == codigo) {

                return alunos[i];
            }
        }

        return null;
    }


    // Getter do array

    public Aluno[] getAlunos() {

        return alunos;
    }


    // Getter da quantidade

    public int getTotalAlunos() {

        return totalAlunos;
    }
}