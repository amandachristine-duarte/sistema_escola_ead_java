import java.util.Scanner;

public class SistemaEscolaEAD {

    private static Scanner scanner = new Scanner(System.in);

    private static ListaDeAlunos listaAlunos =
        new ListaDeAlunos(75);

    // Matriz bidimensional de cursos
    private static Curso[][] matrizCursos =
        new Curso[5][5];


    // ==========================================
    // MÉTODO PRINCIPAL
    // ==========================================

    public static void main(String[] args) {

        cadastrarCursos();

        int opcao;

        do {

            exibirMenu();

            opcao = lerInteiro("Escolha uma opção: ");

            switch (opcao) {

                case 1:
                    listaAlunos.exibirLista();
                    break;

                case 2:
                    adicionarAluno();
                    break;

                case 3:
                    exibirCursosEAlunos();
                    break;

                case 4:
                    verificarNotas();
                    break;

                case 5:
                    verificarFinanceiro();
                    break;

                case 6:
                    System.out.println(
                        "Sistema encerrado. Até logo!"
                    );
                    break;

                default:
                    System.out.println(
                        "Opção inválida."
                    );
            }

        } while (opcao != 6);
    }


    // ==========================================
    // MENU
    // ==========================================

    private static void exibirMenu() {

        System.out.println(
            "\n================================"
        );

        System.out.println(
            "          ESCOLA EAD"
        );

        System.out.println(
            "================================"
        );

        System.out.println(
            "1 - Visualizar Lista de Alunos"
        );

        System.out.println(
            "2 - Adicionar Aluno"
        );

        System.out.println(
            "3 - Visualizar Cursos e Alunos"
        );

        System.out.println(
            "4 - Verificar Notas do Aluno"
        );

        System.out.println(
            "5 - Verificar Financeiro do Aluno"
        );

        System.out.println(
            "6 - Sair"
        );

        System.out.println(
            "================================"
        );
    }


    // ==========================================
    // PARTE 02 - CURSOS
    // ==========================================

    private static void cadastrarCursos() {

    System.out.println(
        "\n=== CADASTRO DE CURSOS ==="
    );

    int quantidade;

    do {

        quantidade = lerInteiro(
            "Quantos cursos deseja cadastrar? (1 a 5): "
        );

        if (quantidade < 1 || quantidade > 5) {

            System.out.println(
                "Digite uma quantidade entre 1 e 5."
            );
        }

    } while (quantidade < 1 || quantidade > 5);


    for (int i = 0; i < quantidade; i++) {

        System.out.println(
            "\nCadastro do curso " + (i + 1)
        );


        // ==============================
        // VERIFICAÇÃO DO CÓDIGO
        // ==============================

        int codigo;

        do {

            codigo = lerInteiro(
                "Código do curso: "
            );

            if (buscarCurso(codigo) != null) {

                System.out.println(
                    "ERRO: Esse código de curso já está cadastrado."
                );

                System.out.println(
                    "Digite outro código."
                );
            }

        } while (buscarCurso(codigo) != null);


        // ==============================
        // DADOS DO CURSO
        // ==============================

        String nome = lerTexto(
            "Nome do curso: "
        );

        int duracao = lerInteiro(
            "Duração em horas: "
        );


        Curso curso =
            new Curso(codigo, nome, duracao);


        // ==============================
        // MATRIZ BIDIMENSIONAL
        // ==============================

        int linha = i / 5;
        int coluna = i % 5;

        matrizCursos[linha][coluna] = curso;
    }


    System.out.println(
        "\nCursos cadastrados com sucesso!"
    );

    exibirCursos();
}

    // ==========================================
    // EXIBIR CURSOS
    // ==========================================

    private static void exibirCursos() {

        System.out.println(
            "\n=== CURSOS DISPONÍVEIS ==="
        );


        for (int i = 0; i < matrizCursos.length; i++) {

            for (int j = 0;
                 j < matrizCursos[i].length;
                 j++) {

                if (matrizCursos[i][j] != null) {

                    Curso curso = matrizCursos[i][j];

                    System.out.println(
                        "Código: " + curso.getCodigo()
                        + " | "
                        + curso.getNome()
                        + " | "
                        + curso.getDuracao()
                        + " horas"
                    );
                }
            }
        }
    }


    // ==========================================
    // BUSCAR CURSO PELO CÓDIGO
    // ==========================================

    private static Curso buscarCurso(int codigo) {

        for (int i = 0; i < matrizCursos.length; i++) {

            for (int j = 0;
                 j < matrizCursos[i].length;
                 j++) {

                if (matrizCursos[i][j] != null &&
                    matrizCursos[i][j].getCodigo() == codigo) {

                    return matrizCursos[i][j];
                }
            }
        }

        return null;
    }


    // ==========================================
    // PARTE 03 - ADICIONAR ALUNO
    // ==========================================

    private static void adicionarAluno() {

        System.out.println(
            "\n=== NOVO ALUNO ==="
        );


        int codigo = lerInteiro(
            "Código do aluno: "
        );


        String nome = lerTexto(
            "Nome: "
        );


        String dataNascimento = lerTexto(
            "Data de nascimento: "
        );


        String email = lerTexto(
            "E-mail: "
        );


        String senha = lerTexto(
            "Senha: "
        );


        System.out.println(
            "\nTipo de aluno:"
        );

        System.out.println(
            "1 - Aluno comum"
        );

        System.out.println(
            "2 - Aluno bolsista"
        );


        int tipo = lerInteiro(
            "Escolha: "
        );


        Aluno aluno;


        if (tipo == 2) {

            String tipoBolsa = lerTexto(
                "Tipo de bolsa: "
            );


            aluno = new AlunoBolsista(
                codigo,
                nome,
                dataNascimento,
                email,
                senha,
                tipoBolsa
            );

        } else {

            aluno = new Aluno(
                codigo,
                nome,
                dataNascimento,
                email,
                senha
            );
        }


        // ======================================
        // ESCOLHA DO CURSO
        // ======================================

        exibirCursos();

        int codigoCurso = lerInteiro(
            "Digite o código do curso: "
        );


        Curso curso = buscarCurso(codigoCurso);


        if (curso != null) {

            aluno.setCursoMatriculado(curso);

        } else {

            System.out.println(
                "Curso não encontrado."
            );
        }


        // ======================================
        // CADASTRO DAS 12 MENSALIDADES
        // ======================================

        double[] valores = new double[12];

        System.out.println(
            "\n=== MENSALIDADES ==="
        );


        for (int i = 0; i < valores.length; i++) {

            valores[i] = lerDouble(
                "Valor da parcela "
                + (i + 1)
                + ": R$ "
            );
        }


        aluno.adicionarMensalidades(valores);


        // ======================================
        // ADICIONA O ALUNO NA LISTA
        // ======================================

        if (listaAlunos.adicionarAluno(aluno)) {

            System.out.println(
                "\nAluno cadastrado com sucesso!"
            );

        } else {

            System.out.println(
                "\nNão foi possível cadastrar o aluno."
            );
        }
    }


    // ==========================================
    // EXIBIR CURSOS E ALUNOS
    // ==========================================

    private static void exibirCursosEAlunos() {

        System.out.println(
            "\n================================"
        );

        System.out.println(
            "      CURSOS E ALUNOS"
        );

        System.out.println(
            "================================"
        );


        for (int i = 0; i < matrizCursos.length; i++) {

            for (int j = 0;
                 j < matrizCursos[i].length;
                 j++) {

                Curso curso = matrizCursos[i][j];

                if (curso != null) {

                    System.out.println(
                        "\nCurso: "
                        + curso.getNome()
                        + " | Duração: "
                        + curso.getDuracao()
                        + "h"
                    );

                    System.out.println(
                        "Código do curso: "
                        + curso.getCodigo()
                    );

                    System.out.println(
                        "Alunos matriculados:"
                    );


                    boolean encontrou = false;

                    Aluno[] alunos =
                        listaAlunos.getAlunos();


                    for (int k = 0;
                         k < listaAlunos.getTotalAlunos();
                         k++) {

                        if (alunos[k].getCursoMatriculado()
                            != null
                            &&
                            alunos[k]
                                .getCursoMatriculado()
                                .getCodigo()
                            ==
                            curso.getCodigo()) {

                            System.out.println(
                                "- "
                                + alunos[k].getNome()
                                + " (código "
                                + alunos[k].getCodigo()
                                + ")"
                            );

                            encontrou = true;
                        }
                    }


                    if (!encontrou) {

                        System.out.println(
                            "- Nenhum aluno matriculado."
                        );
                    }

                    System.out.println(
                        "--------------------------------"
                    );
                }
            }
        }
    }


    // ==========================================
    // PARTE 04 - NOTAS
    // ==========================================

    private static void verificarNotas() {

        System.out.println(
            "\n=== NOTAS DO ALUNO ==="
        );


        int codigo = lerInteiro(
            "Digite o código do aluno: "
        );


        Aluno aluno =
            listaAlunos.buscarAluno(codigo);


        if (aluno == null) {

            System.out.println(
                "Aluno não encontrado."
            );

            return;
        }


        if (!aluno.possuiNotasLancadas()) {

            System.out.println(
                "Nenhuma nota foi lançada."
            );

            System.out.println(
                "Vamos cadastrar as três notas."
            );


            double nota1 = lerNota(
                "Nota 1: "
            );

            double nota2 = lerNota(
                "Nota 2: "
            );

            double nota3 = lerNota(
                "Nota 3: "
            );


            aluno.lancarNotas(
                nota1,
                nota2,
                nota3
            );
        }


        aluno.exibirNotas();
    }


    // ==========================================
    // PARTE 05 - FINANCEIRO
    // ==========================================

    private static void verificarFinanceiro() {

        System.out.println(
            "\n=== FINANCEIRO DO ALUNO ==="
        );


        int codigo = lerInteiro(
            "Digite o código do aluno: "
        );


        Aluno aluno =
            listaAlunos.buscarAluno(codigo);


        if (aluno == null) {

            System.out.println(
                "Aluno não encontrado."
            );

            return;
        }


        aluno.exibirMensalidades();


        System.out.println(
            "\nDeseja pagar alguma parcela?"
        );

        System.out.println(
            "1 - Sim"
        );

        System.out.println(
            "2 - Não"
        );


        int opcao = lerInteiro(
            "Escolha: "
        );


        if (opcao == 1) {

            int parcela = lerInteiro(
                "Digite o número da parcela que deseja pagar: "
            );


            aluno.pagarMensalidade(
                parcela - 1
            );


            System.out.println(
                "\nSituação atual:"
            );

            aluno.exibirMensalidades();
        }
    }


    // ==========================================
    // MÉTODOS AUXILIARES DE ENTRADA
    // ==========================================

    private static int lerInteiro(String mensagem) {

        while (true) {

            try {

                System.out.print(mensagem);

                return Integer.parseInt(
                    scanner.nextLine()
                );

            } catch (NumberFormatException e) {

                System.out.println(
                    "Digite um número inteiro válido."
                );
            }
        }
    }


    private static double lerDouble(String mensagem) {

        while (true) {

            try {

                System.out.print(mensagem);

                String valor =
                    scanner.nextLine().replace(",", ".");

                return Double.parseDouble(valor);

            } catch (NumberFormatException e) {

                System.out.println(
                    "Digite um número válido."
                );
            }
        }
    }


    private static double lerNota(String mensagem) {

        while (true) {

            double nota = lerDouble(mensagem);

            if (nota >= 0 && nota <= 10) {

                return nota;
            }

            System.out.println(
                "A nota deve estar entre 0 e 10."
            );
        }
    }


    private static String lerTexto(String mensagem) {

        System.out.print(mensagem);

        return scanner.nextLine();
    }
}