package sistemacontato.Interface;

import java.util.Scanner;

//carregando pacotes
import sistemacontato.Classes.ContatoPessoal;
import sistemacontato.Classes.Fornecedor;
import sistemacontato.Classes.Outros;
import sistemacontato.Classes.PessoaFisica;
import sistemacontato.Classes.PessoaJuridica;
import sistemacontato.Controle.ControleContatoPessoal;
import sistemacontato.Controle.ControleFornecedor;
import sistemacontato.Controle.ControleOutros;
import sistemacontato.Controle.ControlePessoaFisica;
import sistemacontato.Controle.ControlePessoaJuridica;
import sistemacontato.Controle.ValidarCNPJ;
import sistemacontato.Controle.ValidarCPF;

public class InterfacePrincipal {
    private final Scanner input;

    private final ControlePessoaFisica controlePessoaFisica;
    private final ControlePessoaJuridica controlePessoaJuridica;
    private final ControleFornecedor controleFornecedor;
    private final ControleContatoPessoal controleContatoPessoal;
    private final ControleOutros controleOutros;

    public InterfacePrincipal(){
        input = new Scanner(System.in);

        controlePessoaFisica = new ControlePessoaFisica();
        controlePessoaJuridica = new ControlePessoaJuridica();
        controleFornecedor = new ControleFornecedor();
        controleContatoPessoal = new ControleContatoPessoal();
        controleOutros = new ControleOutros();
    }

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
                        case 4:
                            cadastrarOutros();
                            break;
                    }
                    break;
		case 2:
                    switch (menuSecundario()) {
			case 1:
                            listarCliente();
                            break;
			case 2:
                            listarFornecedor();
                            break;
			case 3:
                            listarContatoPessoal();
                            break;
                        case 4:
                            listarOutros();
                            break;
                    }
                    break;
		case 3:
                    switch (menuSecundario()) {
                        case 1:
                            editarCliente();
                            break;
			case 2:
                            editarFornecedor();
                            break;
			case 3:
                            editarContatoPessoal();
                            break;
                        case 4:
                            editarOutros();
                            break;
                    }
                    break;
		case 4:
                    switch (menuSecundario()) {
                        case 1:
                            excluirCliente();
                            break;
                        case 2:
                            excluirFornecedor();
                            break;
                        case 3:
                            excluirContatoPessoal();
                            break;
                        case 4:
                            excluirOutros();
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
            System.out.print("\n");
            System.out.print("4 - Outros");
            System.out.print("\n");
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

                /* Usando os metodos isCPF() e imprimeCPF() da classe "ValidarCPF" */
                if (ValidarCPF.isCPF(CPF) == true) {
                    /* System.out.printf("%s\n", ValidarCPF.imprimeCPF(CPF)); */

                    PessoaFisica pessoaFisica;
                    pessoaFisica = new PessoaFisica();
                    pessoaFisica.setNome(nome);
                    pessoaFisica.setEmail(email);
                    pessoaFisica.setTelefoneResidencial(telefoneResidencial);
                    pessoaFisica.setTelefoneTrabalho(telefoneTrabalho);
                    pessoaFisica.setTelefoneCelular(telefoneCelular);
                    pessoaFisica.setFAX(FAX);
                    pessoaFisica.setCPF(CPF);
                    controlePessoaFisica.cadastrarPessoaFisica(pessoaFisica);

                    System.out.print("\nCliente - Pessoa Fisica cadastrada com sucesso!\n");

                } else {
                    System.out.printf("\nCPF inválido, tente novamente!\n");
                    menu();
                }
                break;
            case 2:
                System.out.print("CNPJ: ");
                CNPJ = input.next();

                /* Usando os métodos isCNPJ() e imprimeCNPJ() da classe "ValidarCNPJ" */
                if (ValidarCNPJ.isCNPJ(CNPJ) == true) {
                    /* System.out.printf("%s\n", ValidarCNPJ.imprimeCNPJ(CNPJ)); */

                    PessoaJuridica pessoaJuridica;
                    pessoaJuridica = new PessoaJuridica();
                    pessoaJuridica.setNome(nome);
                    pessoaJuridica.setEmail(email);
                    pessoaJuridica.setTelefoneResidencial(telefoneResidencial);
                    pessoaJuridica.setTelefoneTrabalho(telefoneTrabalho);
                    pessoaJuridica.setTelefoneCelular(telefoneCelular);
                    pessoaJuridica.setFAX(FAX);
                    pessoaJuridica.setCNPJ(CNPJ);
                    controlePessoaJuridica.cadastrarPessoaJuridica(pessoaJuridica);

                    System.out.print("\nCliente - Pessoa Juridica cadastrada com sucesso!\n");
                } else {
                    System.out.printf("\nCNPJ inválido, tente novamente!\n");
                    menu();
                }
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
        String nome;
        String email;
        String CNPJ;
        String telefoneFixo;
        String FAX;

        System.out.print("Cadastro de Fornecedor:");
        System.out.print("\n");

        System.out.print("Nome: ");
        nome = input.next();
        System.out.print("E-mail: ");
        email = input.next();
        System.out.print("CNPJ: ");
        CNPJ = input.next();

        /* Usando os métodos isCNPJ() e imprimeCNPJ() da classe "ValidarCNPJ" */
        if (ValidarCNPJ.isCNPJ(CNPJ) == true) {
            /* System.out.printf("%s\n", ValidarCNPJ.imprimeCNPJ(CNPJ)); */
        } else {
            System.out.printf("\nCNPJ inválido, tente novamente!\n");
            menu();
        }

        System.out.print("Telefone Fixo: ");
        telefoneFixo = input.next();
        System.out.print("FAX: ");
        FAX = input.next();

        Fornecedor fornecedor;
        fornecedor = new Fornecedor();
        fornecedor.setNome(nome);
        fornecedor.setEmail(email);
        fornecedor.setCNPJ(CNPJ);
        fornecedor.setTelefoneFixo(telefoneFixo);
        fornecedor.setFAX(FAX);
        controleFornecedor.cadastrarFornecedor(fornecedor);

        System.out.print("\nFornecedor cadastrado com sucesso!\n");
    }

    public void cadastrarContatoPessoal(){
        String nome;
        String email;
        String telefoneFixo;
        String telefoneCelular;

        System.out.print("Cadastro de Contato Pessoal:");
        System.out.print("\n");

        System.out.print("Nome: ");
        nome = input.next();
        System.out.print("E-mail: ");
        email = input.next();
        System.out.print("Telefone fixo: ");
        telefoneFixo = input.next();
        System.out.print("Telefone celular: ");
        telefoneCelular = input.next();

        ContatoPessoal contatoPessoal;
        contatoPessoal = new ContatoPessoal();
        contatoPessoal.setNome(nome);
        contatoPessoal.setEmail(email);
        contatoPessoal.setTelefoneFixo(telefoneFixo);
        contatoPessoal.setTelefoneCelular(telefoneCelular);
        controleContatoPessoal.cadastrarContatoPessoal(contatoPessoal);

        System.out.print("\nContato Pessoal cadastrado com sucesso!\n");
    }

    public void cadastrarOutros(){
        String nome;
        String email;
        String telefone;

        System.out.print("Cadastro de Outro contato:");
        System.out.print("\n");

        System.out.print("Nome: ");
        nome = input.next();
        System.out.print("E-mail: ");
        email = input.next();
        System.out.print("Telefone: ");
        telefone = input.next();

        Outros outro;
        outro = new Outros();
        outro.setNome(nome);
        outro.setEmail(email);
        outro.setTelefone(telefone);
        controleOutros.cadastrarOutros(outro);

        System.out.print("\nOutro contato cadastrado com sucesso!\n");
    }

    public void listarCliente(){
        int tipoPessoa;
        
        System.out.print("Digite o tipo de Cliente que você deseja listar - (1 - Pessoa Fisica ou 2 - Pessoa Juridica): ");
        tipoPessoa = input.nextInt();

        switch (tipoPessoa) {
            case 1:
                if(!controlePessoaFisica.getListPessoaFisica().isEmpty()){
                    System.out.print("Lista de Clientes - Pessoas Fisicas:");
                    System.out.print("\n");

                    for(int i = 0; i < controlePessoaFisica.getListPessoaFisica().size(); i++){
                        System.out.println("ID: " + (i+1));
                        System.out.println("Nome: " + controlePessoaFisica.getListPessoaFisica().get(i).getNome());
                        System.out.println("E-mail: " + controlePessoaFisica.getListPessoaFisica().get(i).getEmail());
                        System.out.println("Telefone residencial: " + controlePessoaFisica.getListPessoaFisica().get(i).getTelefoneResidencial());
                        System.out.println("Telefone de trabalho: " + controlePessoaFisica.getListPessoaFisica().get(i).getTelefoneTrabalho());
                        System.out.println("Telefone celular: " + controlePessoaFisica.getListPessoaFisica().get(i).getTelefoneCelular());
                        System.out.println("FAX: " + controlePessoaFisica.getListPessoaFisica().get(i).getFAX());
                        System.out.println("CPF: " + controlePessoaFisica.getListPessoaFisica().get(i).getCPF());
                    }
                } else {
                    System.out.print("\nNão existe nenhum contato 'Cliente - Pessoa Fisica' cadastrada!\n");
                }
                break;
            case 2:
                if(!controlePessoaJuridica.getListPessoaJuridica().isEmpty()){
                    System.out.print("Lista de Clientes - Pessoas Fisicas:");
                    System.out.print("\n");

                    for(int i = 0; i < controlePessoaJuridica.getListPessoaJuridica().size(); i++){
                        System.out.println("ID: " + (i+1));
                        System.out.println("Nome: " + controlePessoaJuridica.getListPessoaJuridica().get(i).getNome());
                        System.out.println("E-mail: " + controlePessoaJuridica.getListPessoaJuridica().get(i).getEmail());
                        System.out.println("Telefone residencial: " + controlePessoaJuridica.getListPessoaJuridica().get(i).getTelefoneResidencial());
                        System.out.println("Telefone de trabalho: " + controlePessoaJuridica.getListPessoaJuridica().get(i).getTelefoneTrabalho());
                        System.out.println("Telefone celular: " + controlePessoaJuridica.getListPessoaJuridica().get(i).getTelefoneCelular());
                        System.out.println("FAX: " + controlePessoaJuridica.getListPessoaJuridica().get(i).getFAX());
                        System.out.println("CNPJ: " + controlePessoaJuridica.getListPessoaJuridica().get(i).getCNPJ());
                    }
                } else {
                    System.out.print("\nNão existe nenhum contato 'Cliente - Pessoa Juridica' cadastrada!\n");
                }
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

    public void listarFornecedor(){
        if(!controleFornecedor.getListFornecedor().isEmpty()){
            System.out.print("Lista de Fornecedores:");
            System.out.print("\n");

            for(int i = 0; i < controleFornecedor.getListFornecedor().size(); i++){
                System.out.println("ID: " + (i+1));
                System.out.println("Nome: " + controleFornecedor.getListFornecedor().get(i).getNome());
                System.out.println("E-mail: " + controleFornecedor.getListFornecedor().get(i).getEmail());
                System.out.println("CNPJ: " + controleFornecedor.getListFornecedor().get(i).getCNPJ());
                System.out.println("Telefone fixo: " + controleFornecedor.getListFornecedor().get(i).getTelefoneFixo());
                System.out.println("FAX: " + controleFornecedor.getListFornecedor().get(i).getFAX());
            }
        } else {
            System.out.print("\nNão existe nenhum contato 'Fornecedor' cadastrado!\n");
        }
    }

    public void listarContatoPessoal(){
        if(!controleContatoPessoal.getListContatoPessoal().isEmpty()){
            System.out.print("Lista de Contatos Pessoais:");
            System.out.print("\n");

            for(int i = 0; i < controleContatoPessoal.getListContatoPessoal().size(); i++){
                System.out.println("ID: " + (i+1));
                System.out.println("Nome: " + controleContatoPessoal.getListContatoPessoal().get(i).getNome());
                System.out.println("E-mail: " + controleContatoPessoal.getListContatoPessoal().get(i).getEmail());
                System.out.println("Telefone fixo: " + controleContatoPessoal.getListContatoPessoal().get(i).getTelefoneFixo());
                System.out.println("Telefone celular: " + controleContatoPessoal.getListContatoPessoal().get(i).getTelefoneCelular());
            }
        } else {
            System.out.print("\nNão existe nenhum contato 'Contato Pessoal' cadastrado!\n");
        }
    }

    public void listarOutros(){
        if(!controleOutros.getListOutros().isEmpty()){
            System.out.print("Lista de Outros contatos:");
            System.out.print("\n");

            for(int i = 0; i < controleOutros.getListOutros().size(); i++){
                System.out.println("ID: " + (i+1));
                System.out.println("Nome: " + controleOutros.getListOutros().get(i).getNome());
                System.out.println("E-mail: " + controleOutros.getListOutros().get(i).getEmail());
                System.out.println("Telefone: " + controleOutros.getListOutros().get(i).getTelefone());
            }
        } else {
            System.out.print("\nNão existe nenhum contato 'Outros' cadastrado!\n");
        }
    }

    public void editarCliente(){
        int tipoPessoa;
        
        String nome;
        String email;
        String telefoneResidencial;
        String telefoneTrabalho;
        String telefoneCelular;
        String FAX;
        String CPF;
        String CNPJ;
        
        System.out.print("Digite o tipo de Cliente que você deseja editar - (1 - Pessoa Fisica ou 2 - Pessoa Juridica): ");
        tipoPessoa = input.nextInt();

        /* Pessoa Fisica */
        switch (tipoPessoa) {
            case 1:
                try{
                    System.out.print("Para realizar a alteração, informe o nome do Cliente - Pessoa Fisica: ");
                    nome = input.next();

                    System.out.print("\n");

                    PessoaFisica pessoaFisica = controlePessoaFisica.selecionarPessoaFisica(nome);

                    if(pessoaFisica != null){
                        System.out.print("Realize a alteração:");
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
                        System.out.print("CPF: ");
                        CPF = input.next();

                        /* Usando os métodos isCPF() e imprimeCPF() da classe "ValidarCPF" */
                        if (ValidarCPF.isCPF(CPF) == true) {
                            /* System.out.printf("%s\n", ValidarCPF.imprimeCPF(CPF)); */
                        } else {
                            System.out.printf("\nCNPJ inválido, tente novamente!\n");
                            menu();
                        }

                        pessoaFisica.setNome(nome);
                        pessoaFisica.setEmail(email);
                        pessoaFisica.setTelefoneResidencial(telefoneResidencial);
                        pessoaFisica.setTelefoneTrabalho(telefoneTrabalho);
                        pessoaFisica.setTelefoneCelular(telefoneCelular);
                        pessoaFisica.setFAX(FAX);
                        pessoaFisica.setCPF(CPF);

                        controlePessoaFisica.salvarArquivo();

                        System.out.print("\nCliente - Pessoa Fisica alterado com sucesso!\n");
                    }

                } catch(Exception e){
                    System.out.print(e.getMessage());
                }
                break;
            case 2:
                try{
                    System.out.print("Para realizar a alteração, informe o nome do Cliente - Pessoa Juridica: ");
                    nome = input.next();

                    System.out.print("\n");

                    PessoaJuridica pessoaJuridica = controlePessoaJuridica.selecionarPessoaJuridica(nome);

                    if(pessoaJuridica != null){
                        System.out.print("Realize a alteração:");
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
                        System.out.print("CNPJ: ");
                        CNPJ = input.next();

                        /* Usando os métodos isCNPJ() e imprimeCNPJ() da classe "ValidarCNPJ" */
                        if (ValidarCNPJ.isCNPJ(CNPJ) == true) {
                            /* System.out.printf("%s\n", ValidarCNPJ.imprimeCNPJ(CNPJ)); */
                        } else {
                            System.out.printf("\nCNPJ inválido, tente novamente!\n");
                            menu();
                        }

                        pessoaJuridica.setNome(nome);
                        pessoaJuridica.setEmail(email);
                        pessoaJuridica.setTelefoneResidencial(telefoneResidencial);
                        pessoaJuridica.setTelefoneTrabalho(telefoneTrabalho);
                        pessoaJuridica.setTelefoneCelular(telefoneCelular);
                        pessoaJuridica.setFAX(FAX);
                        pessoaJuridica.setCNPJ(CNPJ);

                        controlePessoaJuridica.salvarArquivo();

                        System.out.print("\nCliente - Pessoa Juridica alterado com sucesso!\n");
                    }

                } catch(Exception e){
                    System.out.print(e.getMessage());
                }
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

    public void editarFornecedor(){
        String nome;
        String email;
        String CNPJ;
        String telefoneFixo;
        String FAX;

        try{
            System.out.print("Para realizar a alteração, informe o nome do fornecedor: ");
            nome = input.next();

            System.out.print("\n");

            Fornecedor fornecedor = controleFornecedor.selecionarFornecedor(nome);

            if(fornecedor != null){
                System.out.print("Realize a alteração:");
                System.out.print("\n");

                System.out.print("Nome: ");
                nome = input.next();
                System.out.print("E-mail: ");
                email = input.next();
                System.out.print("CNPJ: ");
                CNPJ = input.next();

                /* Usando os métodos isCNPJ() e imprimeCNPJ() da classe "ValidarCNPJ" */
                if (ValidarCNPJ.isCNPJ(CNPJ) == true) {
                    /* System.out.printf("%s\n", ValidarCNPJ.imprimeCNPJ(CNPJ));*/
                } else {
                    System.out.printf("\nCNPJ inválido, tente novamente!\n");
                    menu();
                }

                System.out.print("Telefone Fixo: ");
                telefoneFixo = input.next();
                System.out.print("FAX: ");
                FAX = input.next();

                fornecedor.setNome(nome);
                fornecedor.setEmail(email);
                fornecedor.setCNPJ(CNPJ);
                fornecedor.setTelefoneFixo(telefoneFixo);
                fornecedor.setFAX(FAX);

                controleFornecedor.salvarArquivo();

                System.out.print("\nFornecedor alterado com sucesso!\n");
            }

        } catch(Exception e){
            System.out.print(e.getMessage());
        }
    }

    public void editarContatoPessoal(){
        String nome;
        String email;
        String telefoneFixo;
        String telefoneCelular;

         try{
            System.out.print("Para realizar a alteração, informe o nome do Contato Pessoal: ");
            nome = input.next();

            System.out.print("\n");

            ContatoPessoal contatoPessoal = controleContatoPessoal.selecionarContatoPessoal(nome);

            if(contatoPessoal != null){
                System.out.print("Realize a alteração:");
                System.out.print("\n");

                System.out.print("Nome: ");
                nome = input.next();
                System.out.print("E-mail: ");
                email = input.next();
                System.out.print("Telefone fixo: ");
                telefoneFixo = input.next();
                System.out.print("Telefone celular: ");
                telefoneCelular = input.next();

                contatoPessoal.setNome(nome);
                contatoPessoal.setEmail(email);
                contatoPessoal.setTelefoneFixo(telefoneFixo);
                contatoPessoal.setTelefoneCelular(telefoneCelular);

                controleContatoPessoal.salvarArquivo();

                System.out.print("\nContato Pessoal alterado com sucesso!\n");
            }

        } catch(Exception e){
            System.out.print(e.getMessage());
        }
    }

    public void editarOutros(){
        String nome;
        String email;
        String telefone;

        try{
            System.out.print("Para realizar a alteração, informe o nome do contato: ");
            nome = input.next();

            System.out.print("\n");

            Outros outro = controleOutros.selecionarOutros(nome);

            if(outro != null){
                System.out.print("Realize a alteração:");
                System.out.print("\n");

                System.out.print("Nome: ");
                nome = input.next();
                System.out.print("E-mail: ");
                email = input.next();
                System.out.print("Telefone: ");
                telefone = input.next();

                outro.setNome(nome);
                outro.setEmail(email);
                outro.setTelefone(telefone);

                controleOutros.salvarArquivo();

                System.out.print("\nOutro contato alterado com sucesso!\n");
            }

        } catch(Exception e){
            System.out.print(e.getMessage());
        }
    }

    public void excluirCliente(){
        int tipoPessoa;

        String nome;

        System.out.print("Digite o tipo de Cliente que você deseja excluir - (1 - Pessoa Fisica ou 2 - Pessoa Juridica): ");
        tipoPessoa = input.nextInt();

        switch (tipoPessoa) {
            case 1:
                try{
                    System.out.print("Para realizar a exclusão, informe o nome do Cliente - Pessoa Fisica: ");
                    nome = input.next();

                    System.out.print("\n");

                    PessoaFisica pessoaFisica = controlePessoaFisica.selecionarPessoaFisica(nome);

                    if(pessoaFisica != null){
                        controlePessoaFisica.excluirPessoaFisica(pessoaFisica);
                        System.out.println("Cliente - Pessoa Fisica excluida com sucesso!");
                    }
                } catch(Exception e){
                System.out.println(e.getMessage());
                }
                break;
            case 2:
                try{
                    System.out.print("Para realizar a exclusão, informe o nome do Cliente - Pessoa Juridica: ");
                    nome = input.next();

                    System.out.print("\n");

                    PessoaJuridica pessoaJuridica = controlePessoaJuridica.selecionarPessoaJuridica(nome);

                    if(pessoaJuridica != null){
                        controlePessoaJuridica.excluirPessoaJuridica(pessoaJuridica);
                        System.out.println("Cliente - Pessoa Juridica excluida com sucesso!");
                    }
                } catch(Exception e){
                System.out.println(e.getMessage());
                }
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

    public void excluirFornecedor(){
        String nome;

        try{
            System.out.print("Para realizar a exclusão, informe o nome do Fornecedor: ");
            nome = input.next();

            System.out.print("\n");

            Fornecedor fornecedor = controleFornecedor.selecionarFornecedor(nome);

            if(fornecedor != null){
                controleFornecedor.excluirFornecedor(fornecedor);
                System.out.println("Fornecedor excluido com sucesso!");
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void excluirContatoPessoal(){
        String nome;

        try{
            System.out.print("Para realizar a exclusão, informe o nome do Contato Pessoal: ");
            nome = input.next();

            System.out.print("\n");

            ContatoPessoal contatoPessoal = controleContatoPessoal.selecionarContatoPessoal(nome);

            if(contatoPessoal != null){
                controleContatoPessoal.excluirContatoPessoal(contatoPessoal);
                System.out.println("Contato Pessoal excluido com sucesso!");
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void excluirOutros(){
        String nome;

        try{
            System.out.print("Para realizar a exclusão, informe o nome do contato: ");
            nome = input.next();

            System.out.print("\n");

            Outros outro = controleOutros.selecionarOutros(nome);

            if(outro != null){
                controleOutros.excluirOutros(outro);
                System.out.println("Outro contato excluido com sucesso!");
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

}