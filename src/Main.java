package main;

import java.util.Scanner;

public class Main {

    static Predio predios[] = new Predio[2];
    static Scanner ent = new Scanner(System.in);

    public static void main(String[] args) {
        exibirMenu();

    }

    public static void exibirMenu() {
        while (true) {
            System.out.println("1) CADASTRAR PRÉDIO");
            System.out.println("2) CADASTRAR MORADOR");
            System.out.println("3) QUANTIDADE DE APARTAMENTOS OCUPADOS EM CADA ANDAR");
            System.out.println("4) O ANDAR COM MAIOR E MENOR NÚMERO DE MORADORES");
            System.out.println("5) A QUANTIDADE DE MORADORES COM IDADE INFERIOR A 30 ANOS");
            System.out.println("6) A PORCENTAGEM DE OCUPAÇÃO DE CADA ANDAR");
            System.out.println("7) A QUANTIDADE DE MORADORES DO SEXO FEMININO EM TODO O PRÉDIO");
            System.out.println("8) PESQUISAR MORADOR POR NOME");
            System.out.print("DIGITE SUA OPÇÃO: ");
            int opçao = Integer.parseInt(ent.nextLine());

            switch (opçao) {
                case 1:
                    cadastrarPredio();
                    break;
                case 2:
                    cadastrarMorador();
                    break;
                case 3:
                    quantOcupadosAndar();
                    break;
                case 4:
                    andarMaiorMenor();
                    break;
                case 5:
                    idadeInferior();
                    break;
                case 6:
                    porcentagemAndar();
                    break;
                case 7:
                    femininoPredio();
                    break;
                case 8:
                    pesquisarNome();
                    break;

            }
        }
    }

    public static void cadastrarPredio() {
        boolean cheio = false;

        for (int i = 0; i < predios.length; i++) {

            if (predios[i] == null) {

                System.out.println("\nCADASTRAR PRÉDIO\n");

                System.out.print("DIGITE O NOME DO PRÉDIO: ");
                String nome = ent.nextLine();

                System.out.print("DIGITE O ENDEREÇO DO PRÉDIO: ");
                String endereco = ent.nextLine();

                predios[i] = new Predio(nome, endereco);
                System.out.println("\nPRÉDIO CADASTRADO COM SUCESSO\n");
                break;
            }
            if (cheio == true) {
                System.out.println("\nVETOR CHEIO\n");
            }
        }
    }

    public static void cadastrarMorador() {
        for (int i = 0; i < predios.length; i++) {

            if (predios[i] != null) {

                System.out.println("DIGITE O NOME DO PREDIO: ");
                String nomePredio = ent.nextLine();
                if (predios[i].getNome().equals(nomePredio)) {

                    System.out.println("INFORME O ANDAR: ");
                    int andar = Integer.parseInt(ent.nextLine());

                    System.out.println("INFORME O APARTAMENTO: ");
                    int apartamento = Integer.parseInt(ent.nextLine());

                    if (predios[i].getAndares()[andar - 1].getApartamentos()[apartamento - 1].getMorador() == null) {
                        System.out.println("\nCADASTRAR NOVO MORADOR\n");

                        System.out.println("DIGITE O NOME DO MORADOR: ");
                        String nome = ent.nextLine();

                        System.out.println("DIGITE A IDADE DO MORADOR:");
                        int idade = Integer.parseInt(ent.nextLine());

                        System.out.println("DIGITE O SEXO DO MORADOR:");
                        char sexo = ent.nextLine().charAt(0);

                        System.out.println("DIGITE O TELEFONE DO MORADOR:");
                        String telefone = ent.nextLine();

                        Morador morador = new Morador(nome, idade, sexo, telefone);

                        morador.setAndar(andar - 1);
                        morador.setApartamento(apartamento - 1);
                        predios[i].getAndares()[andar - 1].getApartamentos()[apartamento - 1].setMorador(morador);

                        System.out.println("\nMORADOR CADASTRADO COM SUCESSO\n");
                        break;
                    } else {
                        System.out.println("\nAPARTAMENTO OCUPADO\n");
                    }

                } else {
                    System.out.println("\nAPARTAMENTO NÃO ENCONTRADO\n");
                }
            }
        }
    }

    //A quantidade de apartamentos ocupados em cada um dos andares;
    public static void quantOcupadosAndar() {
        int quantidade = 0;
        int quantidadeUm = 0;
        int quantidadeDois = 0;
        int quantidadeTres = 0;
        int quantidadeQuatro = 0;

        boolean existe = false;

        System.out.println("DIGITE O NOME DO PRÉDIO: ");
        String nomePredio = ent.nextLine();

        for (int i = 0; i < predios.length; i++) {

            if (predios[i] != null && predios[i].getNome().equals(nomePredio)) {

                System.out.println("\nQUANTIDADE DE APARTAMENTOS OCUPADOS PARA O PRÉDIO " + nomePredio + "\n");

                for (int j = 0; j < predios[i].getAndares().length; j++) {
                    for (int k = 0; k < predios[i].getAndares()[j].getApartamentos().length; k++) {

                        if (predios[i].getAndares()[j].getApartamentos()[k].getMorador() != null) {

                            existe = true;

                            if (predios[i].getAndares()[j].getApartamentos()[k].getMorador().getAndar() == 0) {
                                quantidade++;

                            } else if (predios[i].getAndares()[j].getApartamentos()[k].getMorador().getAndar() == 1) {
                                quantidadeUm++;

                            } else if (predios[i].getAndares()[j].getApartamentos()[k].getMorador().getAndar() == 2) {
                                quantidadeDois++;

                            } else if (predios[i].getAndares()[j].getApartamentos()[k].getMorador().getAndar() == 3) {
                                quantidadeTres++;

                            } else if (predios[i].getAndares()[j].getApartamentos()[k].getMorador().getAndar() == 4) {
                                quantidadeQuatro++;

                            }
                        }
                    }
                }
            }
        }
        System.out.println("QUANTIDADE DE AP OCUPADO 1º " + quantidade);
        System.out.println("QUANTIDADE DE AP OCUPADO 2º " + quantidadeUm);
        System.out.println("QUANTIDADE DE AP OCUPADO 3º " + quantidadeDois);
        System.out.println("QUANTIDADE DE AP OCUPADO 4º " + quantidadeTres);
        System.out.println("QUANTIDADE DE AP OCUPADO 5º " + quantidadeQuatro);

        if (existe == false) {
            System.out.println("\nNENHUM APARTAMENTO OCUPADO/n");
        }
    }

    static void andarMaiorMenor() {

    }

    public static void idadeInferior() {

    }

    //A porcentagem de ocupação de cada andar.
    public static void porcentagemAndar() {

        int max = 0;
        float porZero = 0;
        float porUm = 0;
        float porDois = 0;
        float porTres = 0;
        float porQuatro = 0;
        boolean existe = false;

        boolean encontrado = false;
        for(int i =0;i < predios.length;i++){
            
            if(predios[i] != null){
                
                System.out.print("DIGITE O NOME DO EDIFÍCIO: ");
                String nomeP = ent.nextLine();
            
                if(predios[i].getNome().equalsIgnoreCase(nomeP)){          
                        
                        for(int y = 0; y < predios[i].getAndares().length;y++){
                                               
                            for(int j = 0; j < predios[i].getAndares()[y].getApartamentos().length;j++){ 
                                
                                max = predios[i].getAndares()[y].getApartamentos().length;
                                
                                if(predios[i].getAndares()[y].getApartamentos()[j].getMorador() != null){ 

                                    if(predios[i].getAndares()[y].getApartamentos()[j].getMorador().getAndar() == 0){
                                        
                                        porZero++;
                                    }else{
                                        if(predios[i].getAndares()[y].getApartamentos()[j].getMorador().getAndar() == 1){
                                            
                                            porUm++;
                                        }else{
                                            if(predios[i].getAndares()[y].getApartamentos()[j].getMorador().getAndar() == 2){
                                                
                                                porDois++;
                                            }else{
                                                if(predios[i].getAndares()[y].getApartamentos()[j].getMorador().getAndar() == 3){
                                                    
                                                    porTres++;
                                                }else{
                                                    if(predios[i].getAndares()[y].getApartamentos()[j].getMorador().getAndar() == 4){
                                                        
                                                        porQuatro++;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }    
                            }
                        } 
                
            
                    
        System.out.println("ANDAR 1º PORCENTAGEM É: "+(porZero * 100) / max+"%");      
        System.out.println("ANDAR 2º PORCENTAGEM É: "+(porUm * 100) / max+"%");
        System.out.println("ANDAR 3º PORCENTAGEM É: "+(porDois * 100) / max+"%");
        System.out.println("ANDAR 4º PORCENTAGEM É: "+(porTres * 100) / max+"%");
        System.out.println("ANDAR 5º PORCENTAGEM É: "+(porQuatro * 100) / max+"%");
                }else{
                    System.out.println("\nEDIFÍCIO NÃO ENCONTRADO\n");
                    break;
                }                
            }else{
                System.out.println("\nNENHUM EDIFÍCIO CADASTRADO\n");
            }
        }


        if (encontrado == false) {
            System.out.println("\nNENHUM APARTAMENTO OCUPADO/n");
        }

    }

    public static void femininoPredio() {

    }

    //Uma opção para pesquisar um morador por nome. Se o morador existir, retorne o andar e o apartamento no qual o mesmo reside.
    private static void pesquisarNome() {
        boolean encontrado = false;

        for (int i = 0; i < predios.length; i++) {
            if (predios[i] != null) {
                System.out.println("DIGITE O NOME DO PRÉDIO: ");
                String nomePredio = ent.nextLine();

                if (predios[i].getNome().equals(nomePredio)) {
                    System.out.println("DIGITE O NOME DO MORADOR: ");
                    String nomeMorador = ent.nextLine();

                    for (int j = 0; j < predios[i].getAndares().length; j++) {
 
                            for (int k = 0; k < predios[i].getAndares()[j].getApartamentos().length; k++) {

                                if (predios[i].getAndares()[j].getApartamentos()[k].getMorador() != null
                                        && predios[i].getAndares()[j].getApartamentos()[k].getMorador().getNome().equals(nomeMorador)) {

                                    System.out.println("\nLISTAR MORADOR POR NOME\n");
                                    System.out.println("NOME DO MORADOR: " + predios[i].getAndares()[j].getApartamentos()[k].getMorador().getNome() + "  ");
                                    System.out.println("NÚMERO DO APARTAMENTO: " + predios[i].getAndares()[j].getApartamentos()[k].getNumero());
                                    System.out.println("NÚMERO DO ANDAR: " + predios[i].getAndares()[j].getAndar());

                                    encontrado = true;

                                }
                            }
                    }
                } else {
                    System.out.println("\nPREDIO NAO ENCONTRADO\n");
                }
            } else {
                System.out.println("\nNENHUM PRÉDIO CADASTRADO\n");
            }
        }
        if (encontrado == false) {
            System.out.println("\nNENHUM APARTAMENTO OCUPADO/n");
        }
    }
}
