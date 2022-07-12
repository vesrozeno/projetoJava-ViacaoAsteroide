package principal;
import java.util.ArrayList;

/**
 *
 * @author vesrozeno - Vitor Emanuel da Silva Rozeno
 */
public class Viacao {
    
    private String nomeViacao;
    ArrayList<Rotas>rotas = new ArrayList<>();
    
    //CONSTRUTORES
    public Viacao(String nomeViacao) {
        this.nomeViacao = nomeViacao;
    }
    
    //GETTERS
    public String getNomeViacao() {
        return this.nomeViacao;
    }
    public ArrayList<Rotas> getRotas() {
        return this.rotas;
    }
    
    //SETTERS
    public void setNomeViacao(String nomeViacao) {
        this.nomeViacao = nomeViacao;
    }
    public void setRotas(ArrayList<Rotas> rotas) {
        this.rotas = rotas;
    }
    
    //Chama o metodo que seta a rota e depois a adiciona ao array
    public void addRota()
    {
        Rotas temp;
        temp  = new Rotas();
        temp = temp.setRota();
        rotas.add(temp);
    }
    public void exibirRotas()
    {
       int i;
       System.out.print("\n===========================ROTAS=====================================\n");
       //Exibira somente se existir alguma rota
       if(!rotas.isEmpty())
       {
           //For percorrendo o array de rotas printando dados relevantes
            for(i = 0;i<rotas.size();i++)
            {
                System.out.print("\n=====================================================================\n");

                 System.out.println("\t\t\t[ Rota "+(i+1)+" ]");
                 System.out.print("["+rotas.get(i).getOrigem()+"---->"+rotas.get(i).getParada()+"---->"+rotas.get(i).getDestino()+"]");

                 System.out.print("\nSaida: "+rotas.get(i).getDataSaida().getDataFormatada(rotas.get(i).getDataSaida())+" - "+rotas.get(i).getTempoSaida().getHoraFormatada(rotas.get(i).getTempoSaida()));

                 System.out.print("\nChegada: "+rotas.get(i).getDataChegada().getDataFormatada(rotas.get(i).getDataChegada())+" - "+rotas.get(i).getTempoChegada().getHoraFormatada(rotas.get(i).getTempoChegada()));

                 System.out.print("\nOnibus: "+rotas.get(i).getVeiculo().getMarca()+" - "+rotas.get(i).getVeiculo().getModelo()+" "+rotas.get(i).getVeiculo().getAnoFab()+" / "+rotas.get(i).getVeiculo().getQuilometragem()+ " km rodados.");

                 System.out.println("\nMotorista: "+rotas.get(i).getVeiculo().getCondutor().getNomeMoto()+" - CNH: "+rotas.get(i).getVeiculo().getCondutor().getCnh()+"("+rotas.get(i).getVeiculo().getCondutor().getDataAdmis().getDataFormatada(rotas.get(i).getVeiculo().getCondutor().getDataAdmis())+")");

                 rotas.get(i).getVeiculo().confereOcupacao();
            }
       }
       else
       {
           System.out.print("\n\t\t\tNAO HA ROTAS\n");
       }
       
       System.out.print("\n=====================================================================");
    }
    //Exclui a rota de indice i
    public void excluirRota(int i)
    {
        rotas.remove(i);
    }
    //Chama o metodo que irá alterar a rota de indice i
    public void alterarRota(int i)
    {
        rotas.get(i).setRotaParcial();
    }
    //Chama o metodo que irá alterar apenas o onibus de uma rota de indice i
    public void alterarOnibus(int i)
    {
        rotas.get(i).setVeiculo(rotas.get(i).getVeiculo().cadReturnOnibusParcial(rotas.get(i).getVeiculo().getCondutor(),rotas.get(i).getVeiculo().passageiros));
    }
    //Chama o metodo que irá alterar apenas o motorista do onibus da rota de indice i
    public void alterarMotorista(int i)
    {
        rotas.get(i).getVeiculo().setCondutor(rotas.get(i).getVeiculo().getCondutor().cadReturnMotorista());
    }
    //Método que verifica se existe o indice i no array de rotas
    public boolean verificaIndex(int i)
    {
        return i < rotas.size();//o índice deverá ser menor que o rotas.size
    }
    //Método para comprar a passagem para a rota de indice i
    public void comprarPassagem(int i)
    {
        System.out.print("\n==================CADASTRO====================\n");
        //Faz o cadastro do Passageiro.
        rotas.get(i).getVeiculo().passageiros.add(rotas.get(i).getVeiculo().addPassageiro());
        
        if(rotas.get(i).getVeiculo().passageiros.get(rotas.get(i).getVeiculo().passageiros.size()-1)!=null)
        {
            do
            {
                //Exibe e Seta o assento escolhido.
                rotas.get(i).getVeiculo().exibirAssentos();
                //passageiros.size()-1 pois se trata do último passageiro inserido no array.
                rotas.get(i).getVeiculo().passageiros.get(rotas.get(i).getVeiculo().passageiros.size()-1).setAssentos();

            }while(rotas.get(i).getVeiculo().verificaAssento(rotas.get(i).getVeiculo().passageiros.get(rotas.get(i).getVeiculo().passageiros.size()-1).getAssentoLinha(),rotas.get(i).getVeiculo().passageiros.get(rotas.get(i).getVeiculo().passageiros.size()-1).getAssentoColuna())==false);

            //Ocupa o assento setado.
            rotas.get(i).getVeiculo().ocupaAssento(rotas.get(i).getVeiculo().passageiros.get(rotas.get(i).getVeiculo().passageiros.size()-1).getAssentoLinha(),rotas.get(i).getVeiculo().passageiros.get(rotas.get(i).getVeiculo().passageiros.size()-1).getAssentoColuna());
            System.out.print("\n==============================================\n");
        }
        else
        {
            //Remove o passageiro null adicionado
            rotas.get(i).getVeiculo().passageiros.remove(rotas.get(i).getVeiculo().passageiros.size()-1);
            System.out.print("Voltando ao menu...");
        }
    }
    //Método para verificar se há passageiro com rg x na rota de indice i
    public int verificaRG(int i, int x)
    {
        int j;
        int pass;
        for(j=0;j<rotas.get(i).getVeiculo().passageiros.size();j++)
        {
            if(rotas.get(i).getVeiculo().passageiros.get(j).getId() == x)
            {
                pass = j;
                return pass; //retorna o indice do passageiro
                
            }
        }
        return -1;

    }
    //Método para mudar o assento do passageiro de indice pass na rota de indice i
    public void mudarAssento(int i, int pass)
    {
        System.out.print("\n====================MUDANCA DE ASSENTO===================\n");
        //Desocupa o assento atual
        rotas.get(i).getVeiculo().desocupaAssento(rotas.get(i).getVeiculo().localizaPass(pass).getAssentoLinha(),rotas.get(i).getVeiculo().localizaPass(pass).getAssentoColuna());
        do
            {
                //Exibe e Seta o assento escolhido.
                rotas.get(i).getVeiculo().exibirAssentos();
                //passageiros.size()-1 pois se trata do último passageiro inserido no array.
                rotas.get(i).getVeiculo().localizaPass(pass).setAssentos();
            
                //Enquanto o assento escolhido estiver ocupado
            }while(rotas.get(i).getVeiculo().verificaAssento(rotas.get(i).getVeiculo().localizaPass(pass).getAssentoLinha(),rotas.get(i).getVeiculo().localizaPass(pass).getAssentoColuna())==false);

        //Ocupa o assento escolhido
        rotas.get(i).getVeiculo().ocupaAssento(rotas.get(i).getVeiculo().localizaPass(pass).getAssentoLinha(),rotas.get(i).getVeiculo().localizaPass(pass).getAssentoColuna());
        System.out.print("\n=========================================================\n");
    }
    
    //Remove o passageiro de indice pass da rota de indice i
    public void removerPassageiro(int i, int pass)
    {
        rotas.get(i).getVeiculo().passageiros.remove(rotas.get(i).getVeiculo().localizaPass(pass));
    
    }
    
    //Exibe a passagem do passageiro de indice pass da rota de indice i
    public void exibePassagem(int i, int pass)
    {
        System.out.print("\n==========================SUA ROTA================================\n");
           
        //Printa dados relevantes da rota
            System.out.println("\t\t\t[ Rota "+(i+1)+" ]");
            System.out.print("["+rotas.get(i).getOrigem()+"---->"+rotas.get(i).getParada()+"---->"+rotas.get(i).getDestino()+"]");
            
            System.out.print("\nSaida: "+rotas.get(i).getDataSaida().getDataFormatada(rotas.get(i).getDataSaida())+" - "+rotas.get(i).getTempoSaida().getHoraFormatada(rotas.get(i).getTempoSaida()));
            
            System.out.print("\nChegada: "+rotas.get(i).getDataChegada().getDataFormatada(rotas.get(i).getDataChegada())+" - "+rotas.get(i).getTempoChegada().getHoraFormatada(rotas.get(i).getTempoChegada()));
            
            System.out.print("\nOnibus: "+rotas.get(i).getVeiculo().getMarca()+" - "+rotas.get(i).getVeiculo().getModelo()+" "+rotas.get(i).getVeiculo().getAnoFab()+" / "+rotas.get(i).getVeiculo().getQuilometragem()+ " km rodados.");

            System.out.println("\nMotorista: "+rotas.get(i).getVeiculo().getCondutor().getNomeMoto()+" - CNH: "+rotas.get(i).getVeiculo().getCondutor().getCnh()+"("+rotas.get(i).getVeiculo().getCondutor().getDataAdmis().getDataFormatada(rotas.get(i).getVeiculo().getCondutor().getDataAdmis())+")");
        //Printa dados relevantes do passageiro
        System.out.print("===========DADOS DA PASSAGEM =============\n");
        System.out.print("Nome do Passageiro: "+rotas.get(i).getVeiculo().localizaPass(pass).getNomePass());
        System.out.print("\nRG: "+rotas.get(i).getVeiculo().localizaPass(pass).getId());
        System.out.print("\nData de nascimento: "+rotas.get(i).getVeiculo().localizaPass(pass).getBirth().getDataFormatada(rotas.get(i).getVeiculo().localizaPass(pass).getBirth()));
        System.out.print("\nEndereco: "+rotas.get(i).getVeiculo().localizaPass(pass).getEnd());
        System.out.print("\nAssento:["+rotas.get(i).getVeiculo().localizaPass(pass).getAssentoLinha()+"]["+rotas.get(i).getVeiculo().localizaPass(pass).getAssentoColuna()+"]");
        System.out.print("\n===========================================\n\n");
    }
}
