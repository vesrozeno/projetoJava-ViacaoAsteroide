package principal;
import java.util.Scanner;
/**
 *
 * @author vesrozeno - Vitor Emanuel da Silva Rozeno
 */
public class Rotas {
    
    private Data dataSaida;
    private Data dataChegada;
    private Tempo tempoSaida;
    private Tempo tempoChegada;
    
    private String origem;
    private String parada;
    private String destino;
    
    private Onibus veiculo;
    


    //CONSTRUTORES
    public Rotas(Data dataSaida, Data dataChegada, Tempo tempoSaida, Tempo tempoChegada, String origem, String parada, String destino, Onibus veiculo) {
        this.dataSaida = dataSaida;
        this.dataChegada = dataChegada;
        this.tempoSaida = tempoSaida;
        this.tempoChegada = tempoChegada;
        this.origem = origem;
        this.parada = parada;
        this.destino = destino;
        this.veiculo = veiculo;
    }

    public Rotas(String origem, String parada, String destino, Onibus veiculo) {
        this.origem = origem;
        this.parada = parada;
        this.destino = destino;
        this.veiculo = veiculo;
    }
    
    public Rotas() {
    }

    //GETTERS
    public Data getDataSaida() {
        return this.dataSaida;
    }
    public Data getDataChegada() {
        return this.dataChegada;
    }
    public Tempo getTempoSaida() {
        return this.tempoSaida;
    }
    public Tempo getTempoChegada() {
        return this.tempoChegada;
    }
    public String getOrigem() {
        return this.origem;
    }
    public String getParada() {
        return this.parada;
    }
    public String getDestino() {
        return this.destino;
    }
    public Onibus getVeiculo() {
        return this.veiculo;
    }
    

    //SETTERS
    public void setDataSaida(Data dataSaida) {
        this.dataSaida = dataSaida;
    }
    public void setDataChegada(Data dataChegada) {
        this.dataChegada = dataChegada;
    }
    public void setTempoSaida(Tempo tempoSaida) {
        this.tempoSaida = tempoSaida;
    }
    public void setTempoChegada(Tempo tempoChegada) {
        this.tempoChegada = tempoChegada;
    }
    public void setOrigem(String origem) {
        this.origem = origem;
    }
    public void setParada(String parada) {
        this.parada = parada;
    }
    public void setDestino(String destino) {
        this.destino = destino;
    }
    public void setVeiculo(Onibus veiculo) {
        this.veiculo = veiculo;
    }
    
    //Método que seta a rota e retorna o obejeto instanciado
    public Rotas setRota()
    {
        
        Rotas rota;
        
        String origem;
        String parada;
        String destino;
        
        Scanner sc = new Scanner(System.in);
        System.out.print("\n====================CADASTRO DE ROTA==================\n");
        System.out.println("Digite a origem: ");
        origem = sc.nextLine();
        
        System.out.println("Digite a parada: ");
        parada = sc.nextLine();
        
        System.out.println("Digite o destino: ");
        destino = sc.nextLine();
        System.out.print("\n============================================\n");
        
        Data dSaida;
        Tempo tSaida;
        
        Data dChegada;
        Tempo tChegada;
        
        System.out.println("\n============\nDigite a data de saida:\n============\n");
        dSaida = new Data();
        dSaida.setDataRota();
        
        do
        {
            System.out.println("\n============\nDigite a data de chegada:\n============\n");
            dChegada = new Data();
            dChegada.setDataRota();
        }while(dChegada.comparaDataViagem(dSaida,dChegada)==false);//Verificação da entrada
        do
        {
            System.out.println("\n============\nDigite a hora de saida:\n============\n");
            tSaida = new Tempo();
            tSaida.setHorario();

            System.out.println("\n============\nDigite a hora de chegada:\n============\n");
            tChegada = new Tempo();
            tChegada.setHorario();
        }while(tChegada.comparaHoras(dSaida, dChegada, tSaida, tChegada)==true);//Verificação da entrada
        Onibus temp;
        temp = new Onibus();
        rota = new Rotas(dSaida, dChegada, tSaida, tChegada, origem, parada, destino, temp);
        rota.setVeiculo(temp.cadReturnOnibus());//Chama o método que instancia e retorna o onibus e motorista, consequentemente
        
        return rota;
    }
    //Método para setar somente a Rota, deixando o onibus e motorista atuais
    public void setRotaParcial()
    {
        String origem;
        String parada;
        String destino;
        
        Scanner sc = new Scanner(System.in);
        System.out.print("\n====================CADASTRO DE ROTA==================\n");
        System.out.println("Digite a origem: ");
        origem = sc.nextLine();
        
        System.out.println("Digite a parada: ");
        parada = sc.nextLine();
        
        System.out.println("Digite o destino: ");
        destino = sc.nextLine();
        System.out.print("\n============================================\n");
        Data dSaida;
        Tempo tSaida;
        
        Data dChegada;
        Tempo tChegada;
        
        System.out.println("\n============\nDigite a data de saida:\n============\n");
        dSaida = new Data();
        dSaida.setDataRota();
        
        do
        {
            System.out.println("\n============\nDigite a data de chegada:\n============\n");
            dChegada = new Data();
            dChegada.setDataRota();
        }while(dChegada.comparaDataViagem(dSaida,dChegada)==false);//Verificação da entrada
        do
        {
            System.out.println("\n============\nDigite a hora de saida:\n============\n");
            tSaida = new Tempo();
            tSaida.setHorario();

            System.out.println("\n============\nDigite a hora de chegada:\n============\n");
            tChegada = new Tempo();
            tChegada.setHorario();
        }while(tChegada.comparaHoras(dSaida, dChegada, tSaida, tChegada)==true);//Verificação da entrada
        
        this.origem = origem;
        this.parada = parada;
        this.destino = destino;
        this.dataSaida = dSaida;
        this.tempoSaida = tSaida;
        this.dataChegada = dChegada;
        this.tempoChegada = tChegada;
    }
    
}
