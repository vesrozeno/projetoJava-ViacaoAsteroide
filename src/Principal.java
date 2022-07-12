package principal;
import java.util.Scanner;

/**
 *
 * @author vesrozeno - Vitor Emanuel da Silva Rozeno
 */
public class Principal {

    
    public static void main(String[] args) 
    {
        Viacao asteroide = new Viacao("Viacao Asteroide");
        
        int menu = 0;
        int index;
        int pass = 0;
        Scanner sc =  new Scanner(System.in);
        System.out.print("\n=================\nVIACAO ASTEROIDE\n=================\n");
        do
        {   //Menu Principal
            System.out.print("\n\tMENU\n1.ADMIN\n2.PASSAGEIRO\n3.SAIR\n-----> ");
            menu = sc.nextInt();
            switch(menu)
            {
                case 1:
                {
                    do
                    {   
                        //Menu Admin
                        System.out.print("\n\tADMIN\n1.CADASTRAR NOVA VIAGEM\n2.EXIBIR VIAGENS\n3.ALTERAR VIAGEM\n4.EXCLUIR VIAGEM\n5.VOLTAR\n-----> ");
                        menu = sc.nextInt();
                        switch(menu)
                        {
                            //Add Rota
                            case 1:
                            {
                                asteroide.addRota();
                                System.out.print("\n=================\nROTA CADASTRADA COM SUCESSO\n=================\n");
                            }
                                break;
                            //Exibir Rota
                            case 2:
                            {
                                asteroide.exibirRotas();
                                System.out.print("\nDigite ENTER para continuar...");
                                sc.nextLine();
                                sc.nextLine();
                            }
                                break;
                            //Alterar Viagem
                            case 3:
                            { 
                                //Verifica se há rotas
                                if(!asteroide.rotas.isEmpty())
                                {
                                    int ok = 0;
                                    do
                                    {
                                        asteroide.exibirRotas();                                   
                                        System.out.print("\nAlterar qual viagem? -----> ");
                                        index = sc.nextInt();
                                        //Verificação do indice inserido
                                        if(asteroide.verificaIndex(index-1) == false)
                                        {
                                            System.out.println("\n=================\nEntrada Invalida\nTente Novamente\n=================\n");
                                        }
                                        else
                                        {
                                            ok = 1;
                                        }
                                    }while(ok==0);

                                    do
                                    {
                                        //Menu do que alterar
                                        System.out.println("\tO que alterar?\n1.Rota\n2.Onibus\n3.Motorista\n4.Cancelar\n");
                                        menu = sc.nextInt();
                                        switch(menu)
                                        {
                                            //Alterar Rota
                                            case 1:
                                            {
                                                asteroide.alterarRota(index-1);
                                                System.out.print("\n=================\nROTA ALTERADA COM SUCESSO\n=================\n");
                                            }
                                                break;
                                            //Alterar Onibus
                                            case 2:
                                            {
                                                asteroide.alterarOnibus(index -1);
                                                System.out.print("\n=================\nONIBUS ALTERADO COM SUCESSO\n=================\n");
                                            }
                                                break;
                                            //Alterar Motorista
                                            case 3:
                                            {
                                                asteroide.alterarMotorista(index-1);
                                                System.out.print("\n=================\nMOTORISTA ALTERADO COM SUCESSO\n=================\n");
                                            }
                                                break;
                                            //Cancelar
                                            case 4:
                                            {System.out.print("\nCancelando . . .\n");}
                                                break;
                                            default:{System.out.println("\n=================\nEntrada Invalida\nTente Novamente\n=================\n");}
                                        }
                                    }while(menu<1||menu>4);
                                }
                                else
                                {
                                    System.out.print("\n======================\nIMPOSSIVEL ALTERAR ROTAS: NAO HA ROTAS\n======================\n");
                                }
                                

                            }
                                break;
                            //Excluir Viagem
                            case 4:
                            {
                                //Verifica se há rotas
                                if(!asteroide.rotas.isEmpty())
                                {
                                    int ok = 0;
                                    do
                                    {
                                        asteroide.exibirRotas();
                                        System.out.print("\nExcluir qual viagem? -----> ");
                                        index = sc.nextInt();
                                        //Verificação do indice inserido
                                        if(asteroide.verificaIndex(index-1) == false)
                                        {
                                            System.out.println("\n=================\nEntrada Invalida\nTente Novamente\n=================\n");
                                        }
                                        else
                                        {
                                            ok = 1;
                                        }
                                    }while(ok==0);
                                    ok = 0;
                                    //Confirmação de Exclusao
                                    do
                                    {
                                        System.out.print("\nRealmente deseja excluir a viagem "+index+"?\n[1]Sim\n[2]Nao\n------> ");
                                        ok = sc.nextInt();
                                        switch(ok)
                                        {
                                            case 1:
                                            {
                                                asteroide.excluirRota(index-1);
                                                System.out.print("\n=================\nROTA EXCLUIDA COM SUCESSO\n=================\n");

                                            }
                                                break;
                                            case 2:
                                            {
                                                System.out.print("\n=================\nOk. Voltando...\n=================\n");
                                            }
                                            break;
                                            default:
                                            {
                                                System.out.print("\n=================\nEntrada Invalida\nTente Novamente\n=================\n");
                                            }
                                        }
                                    //Verificação da entrada
                                    }while((ok<1)||(ok>2));
                                }
                                else
                                {
                                    System.out.print("\n======================\nIMPOSSIVEL EXCLUIR ROTAS: NAO HA ROTAS\n======================\n");
                                }
                                
                            }
                                break;
                            //Sair
                            case 5:
                            {
                                System.out.print("\nVoltando . . .\n");
                            }
                                break;
                            //Entrada Invalida
                            default:
                            {
                                System.out.print("\n=================\nEntrada Invalida\nTente Novamente\n=================\n");
                            }
                        }
                    }while(menu!=5);
                    
                }
                    break;
                case 2:
                {
                    do
                    {
                        //Menu Passageiro
                        System.out.print("\n\tPASSAGEIRO\n1.COMPRAR PASSAGEM\n2.ALTERAR PASSAGEM(MUDAR ASSENTO)\n3.EXIBIR PASSAGEM\n4.CANCELAR PASSAGEM\n5.VOLTAR\n-----> ");
                        menu = sc.nextInt();
                        switch(menu)
                        {
                            //Comprar Passagem
                            case 1:
                            {
                                //Verifica se há rotas
                                if(!asteroide.rotas.isEmpty())
                                {
                                    int ok = 0;
                                    do
                                    {
                                        do
                                        {

                                            asteroide.exibirRotas();
                                            System.out.print("\nComprar passagem para qual viagem?-------> ");
                                            index = sc.nextInt();
                                            //Verificacao de indice da rota
                                            if(asteroide.verificaIndex(index-1) == false)
                                            {
                                                System.out.print("\n=================\nEntrada Invalida\nTente Novamente\n=================\n");
                                            }
                                            else
                                            {
                                                ok = 1;
                                            }
                                        }while(ok==0);
                                        //Verifica se Onibus da Rota está lotado
                                        if(asteroide.rotas.get(index-1).getVeiculo().confereOcupacao() == false)
                                        {
                                            do{
                                                System.out.print("\nInfelizmente esse onibus esta lotado!\nO que deseja fazer?\n[0]Selecionar outra rota\n[1]Voltar ao Menu\n ---->");
                                                ok = sc.nextInt();
                                                if(ok<0||ok>1)
                                                {
                                                    System.out.println("\n=================\nEntrada Invalida\nTente Novamente\n=================\n");
                                                }
                                            }while(ok<0||ok>1);
                                        }
                                        //Compra a Passagem
                                        else
                                        {
                                            asteroide.comprarPassagem(index-1);
                                            System.out.print("\n=================\nPASSAGEM ADQUIRIDA COM SUCESSO\n=================\n");
                                            ok = 1;
                                        }
                                    }while(ok==0);
                                }
                                else
                                {
                                    System.out.print("\n======================\nIMPOSSIVEL COMPRAR PASSAGEM: NAO HA ROTAS\n======================\n");
                                }
                                
                            }
                                break;
                            //Alterar Passagem - Mudar o assento
                            case 2:
                            {
                                //Verifica se há rotas
                                if(!asteroide.rotas.isEmpty())
                                {
                                    int id;
                                    int ok;

                                    do
                                    {
                                        asteroide.exibirRotas();
                                        System.out.print("\nVoce tem passagem para qual viagem?-----> ");
                                        index = sc.nextInt();
                                        sc.nextLine();
                                        //Verifica indice de rota
                                        if(asteroide.verificaIndex(index-1) == false)
                                        {
                                            System.out.print("\n=================\nEntrada Invalida\nTente Novamente\n=================\n");
                                            ok = 0;
                                        }
                                        else
                                        {
                                            ok = 1;
                                        }
                                    }while(ok == 0);
                                    ok = 0;
                                    do
                                    {

                                        System.out.print("\nDigite seu RG: ");
                                        id = sc.nextInt();
                                        //Verifica se Passageiro portador deste rg está nessa viagem
                                        if(asteroide.verificaRG(index-1,id)>=0)
                                        {
                                            System.out.print("\n=================\nPassageiro encontrado! Prosseguindo...\n=================\n");
                                            ok = 2;
                                        }
                                        else
                                        {
                                            do{
                                                System.out.print("\n=================\nNao foi possivel encontrar o passageiro.\nO que deseja fazer?\n[0]Tentar novamente\n[1]Voltar ao Menu\n ---->");
                                                ok = sc.nextInt();
                                                if(ok<0||ok>1)
                                                {
                                                    System.out.print("\n=================\nEntrada Invalida\nTente Novamente\n=================\n");
                                                }
                                            }while(ok<0||ok>1);
                                        }
                                    }while(ok==0);
                                    if(ok==2)
                                    {
                                        //confirma a alteração
                                        do
                                        {
                                            System.out.print("\n=================\nRealmente deseja mudar seu assento?\n[0]Sim\n[1]Nao - Voltar ao Menu\n ---->");
                                            ok = sc.nextInt();
                                            if(ok<0||ok>1)
                                            {
                                                System.out.print("\n=================\nEntrada Invalida\nTente Novamente\n=================\n");
                                            }
                                        }while(ok<0||ok>1);
                                        if(ok == 0)
                                        {
                                            pass = asteroide.verificaRG(index-1,id);
                                            asteroide.mudarAssento(index-1, pass);
                                            System.out.print("\n=================\nASSENTO ALTERADO COM SUCESSO\n=================\n");
                                        }
                                        else
                                        {
                                            System.out.print("\nOk. Voltando ao menu ...\n");
                                        }
                                    }
                                    else
                                    {
                                        System.out.print("\nOk. Voltando ao menu ...\n");
                                    }
                                }
                                else
                                {
                                    System.out.print("\n======================\nIMPOSSIVEL ALTERAR ASSENTO: NAO HA ROTAS\n======================\n");
                                }
                                
                            }
                                break;
                            //Exibir Passagem
                            case 3:
                            {
                                //Verifica se há rotas
                                if(!asteroide.rotas.isEmpty())
                                {
                                    int id;
                                    int ok;
                                    do
                                    {

                                        do
                                            {
                                                asteroide.exibirRotas();
                                                System.out.print("\nVoce tem passagem para qual viagem? ----> ");
                                                index = sc.nextInt();
                                                sc.nextLine();
                                                //Verifica indice da rota
                                                if(asteroide.verificaIndex(index-1) == false)
                                                {
                                                    System.out.print("\n=================\nEntrada Invalida\nTente Novamente\n=================\n");
                                                    ok = 0;
                                                }
                                                else
                                                {
                                                    ok = 1;
                                                }
                                            }while(ok == 0);

                                        System.out.print("\nDigite seu RG: ");
                                        id = sc.nextInt();
                                        //Verifica se há passageiro com esse RG
                                        if(asteroide.verificaRG(index-1,id)>=0)
                                        {
                                            System.out.println("\n=================\nPassageiro encontrado! Prosseguindo...\n=================\n");
                                            pass = asteroide.verificaRG(index-1,id);
                                            asteroide.exibePassagem(index-1, pass);
                                            ok=2;
                                        }
                                        else
                                        {
                                            do{
                                                System.out.print("\n=================\nNao foi possivel encontrar o passageiro.\nO que deseja fazer?\n[0]Tentar novamente\n[1]Voltar ao Menu\n ---->");
                                                ok = sc.nextInt();
                                                if(ok<0||ok>1)
                                                {
                                                    System.out.print("\n=================\nEntrada Invalida\nTente Novamente\n=================\n");
                                                }
                                            }while(ok<0||ok>1);
                                        }
                                    }while(ok==0);
                                    if(ok==1)
                                    {
                                        System.out.print("\nOk. Voltando ao menu ...\n");
                                    }
                                }
                                else
                                {
                                    System.out.print("\n======================\nIMPOSSIVEL EXIBIR PASSAGEM: NAO HA ROTAS\n======================\n");
                                }
                            }
                                break;
                            //Cancelar Viagem
                            case 4:
                            {
                                //Verifica se há rotas
                                if(!asteroide.rotas.isEmpty())
                                {
                                    int id;
                                    int ok;
                                    do
                                        {
                                            asteroide.exibirRotas();
                                            System.out.print("\nVoce tem passagem para qual viagem? ----> ");
                                            index = sc.nextInt();
                                            sc.nextLine();
                                            if(asteroide.verificaIndex(index-1) == false)
                                            {
                                                System.out.print("\n=================\nEntrada Invalida\nTente Novamente\n=================\n");
                                                ok = 0;
                                            }
                                            else
                                            {
                                                ok = 1;
                                            }
                                        }while(ok == 0);
                                    ok = 0;
                                    do
                                    {

                                        System.out.print("\nDigite seu RG: ");
                                        id = sc.nextInt();
                                        if(asteroide.verificaRG(index-1,id)>=0)
                                        {
                                            System.out.print("\n=================\nPassageiro encontrado! Prosseguindo...\n=================\n");
                                            ok = 2;
                                        }
                                        else
                                        {
                                            do{
                                                System.out.print("\n=================\nNao foi possivel encontrar o passageiro.\nO que deseja fazer?\n[0]Tentar novamente\n[1]Voltar ao Menu\n ---->");
                                                ok = sc.nextInt();
                                                if(ok<0||ok>1)
                                                {
                                                    System.out.print("\n=================\nEntrada Invalida\nTente Novamente\n=================\n");
                                                }
                                            }while(ok<0||ok>1);
                                        }
                                    }while(ok==0);
                                    if(ok == 2)
                                    {
                                        System.out.print("\n=================\nRealmente deseja cancelar sua viagem?\n[1]Sim\n[0]Nao - Voltar ao Menu\n----> ");
                                        ok = sc.nextInt();
                                        if(ok == 1)
                                        {
                                            pass = asteroide.verificaRG(index-1,id);
                                            asteroide.removerPassageiro(index-1, pass);
                                            System.out.print("\n=================\nPASSAGEM CANCELADA COM SUCESSO\n=================\n");
                                        }
                                        else
                                        {
                                            System.out.print("Ok. Voltando ...\n");
                                        }
                                    }
                                    else
                                    {
                                        System.out.print("\nOk.Voltando...\n");

                                    }
                                }
                                else
                                {
                                    System.out.print("\n======================\nIMPOSSIVEL CANCELAR VIAGEM: NAO HA ROTAS\n======================\n");
                                }
                            }
                                break;
                           //Entrada Invalida
                            case 5:
                            {System.out.print("\nVoltando . . .\n");}
                                break;
                            default:
                            {
                                System.out.print("\n=================\nEntrada Invalida\nTente Novamente\n=================\n");
                            }
                        }
                    }while(menu!=5);
                }
                    break;
                case 3:{System.out.print("\n=================\nSAINDO...\nAGRADECEMOS A PREFERENCIA\n=================\n");}
                    break;
                default:{System.out.print("\n=================\nEntrada Invalida\nTente Novamente\n=================\n");}
            }
                 
        }while(menu!=3);
        
       
        
    }
    
}
