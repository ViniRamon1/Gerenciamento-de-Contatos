import java.util.Scanner;
public class Interface {
    Scanner input = new Scanner(System.in);

    public int menu() {
        int opcao;
	    boolean loopMenu = true;

	    while (loopMenu) {
            System.out.print("\nControle de Contato - Menu Principal:\n");
            System.out.print("\n");
            System.out.print("1 - Cadastrar");
            System.out.print("\n");
            System.out.print("2 - Listar");
            System.out.print("\n");
            System.out.print("3 - Editar");
            System.out.print("\n");
            System.out.print("4 - Excluir");
            System.out.print("\n");
            System.out.print("0 - Sair\n");
            System.out.print("\n");

            System.out.print("Digite a opção: ");
            opcao = input.nextInt();

            System.out.print("\n");

            switch(opcao) {
                case 0:
                    loopMenu = false;
                    break;
                case 1:
                    switch (menuSecundario()) {
                        case 1:
                            cadastrarCliente();
                            break;
                        case 2:
                            cadastrarFornecedor();
                            break;
                        case 3:
                            cadastrarContatoPessoal();
                            break;
                    }
                    break;
		case 2:
                    switch (menuSecundario()) {
			case 1:
                            //listarCliente();
                            break;
			case 2:
                            //listarFornecedor();
                            break;
			case 3:
                            //listarContatoPessoal();
                            break;
                    }
                    break;
		case 3:
                    switch (menuSecundario()) {
                        case 1:
                            //editarCliente();
                            break;
			case 2:
                            //editarFornecedor();
                            break;
			case 3:
                            //editarContatoPessoal();
                            break;
                    }
                    break;
		case 4:
                    switch (menuSecundario()) {
                        case 1:
                            //excluirCliente();
                            break;
                        case 2:
                            //excluirFornecedor();
                            break;
                        case 3:
                            //excluirContatoPessoal();
                            break;
                    }
                    break;
		default:
                    System.out.print("\nOpção incorreta!\n");
                    System.out.print("\n");
                    break;
            }
        }
        return 0;
    }

    public int menuSecundario() {
	    int opcao;
	    boolean loopMenuSecundario = true;
	    while (loopMenuSecundario) {
                System.out.print("Menu Secundario:\n");
                System.out.print("\n");
                System.out.print("1 - Cliente");
                System.out.print("\n");
                System.out.print("2 - Fornecedor");
                System.out.print("\n");
                System.out.print("3 - Contato Pessoal");
                System.out.print("\n");;
                System.out.print("0 - Voltar para o Menu Principal\n");
                System.out.print("\n");

                System.out.print("Digite a opção: ");
                opcao = input.nextInt();

                System.out.print("\n");

                if (opcao > 4) {
                    System.out.print("\nOpção incorreta!\n");
                    System.out.print("\n");
                } else {
                    return opcao;
                }
	    }
        return 0;
    }

    public void cadastrarCliente() {
        int tipoPessoa;

        String nome;
        String email;
        String telefoneResidencial;
        String telefoneTrabalho;
        String telefoneCelular;
        String FAX;
        String CPF;
        String CNPJ;

        System.out.print("Cadastro de Cliente (Pessoa Fisica/Pessoa Juridica):");
        System.out.print("\n");

        System.out.print("Nome: ");
        nome = input.next();
        System.out.print("E-mail: ");
        email = input.next();
        System.out.print("Telefone residencial: ");
        telefoneResidencial = input.next();
        System.out.print("Telefone de trabalho: ");
        telefoneTrabalho = input.next();
        System.out.print("Telefone celular: ");
        telefoneCelular = input.next();
        System.out.print("FAX: ");
        FAX = input.next();

        System.out.print("Digite o tipo de Cliente - (1 - Pessoa Fisica ou 2 - Pessoa Juridica): ");
        tipoPessoa = input.nextInt();
        
        switch (tipoPessoa) {
            case 1:
                System.out.print("CPF: ");
                CPF = input.next();
                PessoaFisica pessoaFisica;
                pessoaFisica = new PessoaFisica();
                pessoaFisica.setNome(nome);
                pessoaFisica.setEmail(email);
                pessoaFisica.setTelefoneFixoResidencial(telefoneResidencial);
                pessoaFisica.setTelefoneFixoTrabalho(telefoneTrabalho);
                pessoaFisica.setTelefoneFixoCelular(telefoneCelular);
                pessoaFisica.setFAX(FAX);
                pessoaFisica.setCPF(CPF);

                System.out.print("\nCliente - Pessoa Fisica cadastrada com sucesso!\n");
                break;
            case 2:
                System.out.print("CNPJ: ");
                CNPJ = input.next();
                Juridica pessoaJuridica;
                pessoaJuridica = new Juridica();
                pessoaJuridica.setNome(nome);
                pessoaJuridica.setEmail(email);
                pessoaJuridica.setTelefoneFixoResidencial(telefoneResidencial);
                pessoaJuridica.setTelefoneFixoTrabalho(telefoneTrabalho);
                pessoaJuridica.setTelefoneFixoCelular(telefoneCelular);
                pessoaJuridica.setFAX(FAX);
                pessoaJuridica.setCNPJ(CNPJ);

                System.out.print("\nCliente - Pessoa Juridica cadastrada com sucesso!\n");
                break;
            default:
                System.out.print("\nOpcao incorreta!\n");
                System.out.print("\n");
                System.out.print("Cancelando o cadastro...\n");
                System.out.print("\n");
                menu();
                break;
        }
    }
    public void cadastrarFornecedor(){
        String nomeFornecedor;
        String emailFornecedor;
        String CNPJFornecedor;
        String telefoneFornecedor;
        String FAXFornecedor;

        System.out.print("Cadastro de Fornecedor:");
        System.out.print("\n");

        System.out.print("Nome: ");
        nomeFornecedor = input.next();
        System.out.print("E-mail: ");
        emailFornecedor = input.next();
        System.out.print("CNPJ: ");
        CNPJFornecedor = input.next();
        System.out.print("Telefone Fixo: ");
        telefoneFornecedor = input.next();
        System.out.print("FAX: ");
        FAXFornecedor = input.next();

        Fornecedor fornecedor;
        fornecedor = new Fornecedor();
        fornecedor.setNome(nomeFornecedor);
        fornecedor.setEmail(emailFornecedor);
        fornecedor.setCNPJ(CNPJFornecedor);
        fornecedor.setTelefoneFixo(telefoneFornecedor);
        fornecedor.setFAX(FAXFornecedor);
        System.out.print("\nFornecedor cadastrado com sucesso!\n");
    }

    public void cadastrarContatoPessoal(){
        String nomePessoal;
        String emailPessoal;
        String telefonePessoal;
        String telefoneCelularPessoal;

        System.out.print("Cadastro de Contato Pessoal:");
        System.out.print("\n");
        System.out.print("Nome: ");
        nomePessoal = input.next();
        System.out.print("E-mail: ");
        emailPessoal = input.next();
        System.out.print("Telefone fixo: ");
        telefonePessoal = input.next();
        System.out.print("Telefone celular: ");
        telefoneCelularPessoal = input.next();

        ContatoPessoal contatoPessoal;
        contatoPessoal = new ContatoPessoal();
        contatoPessoal.setNome(nomePessoal);
        contatoPessoal.setEmail(emailPessoal);
        contatoPessoal.setTelefoneFixo(telefonePessoal);
        contatoPessoal.setTelefoneFixoCelular(telefoneCelularPessoal);
        System.out.print("\nContato Pessoal cadastrado com sucesso!\n");
        }   
    //public void editarCliente()
    //public void editarFornecedor()
    //public void editarContatoPessoal()
    //public void editarOutros()
    //public void excluirCliente()
    //public void excluirFornecedor()
    //public void excluirContatoPessoal()
    //public void excluirOutros()
}