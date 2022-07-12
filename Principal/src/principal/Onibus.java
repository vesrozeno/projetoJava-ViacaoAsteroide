package principal;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author vesrozeno - Vitor Emanuel da Silva Rozeno
 */
public class Onibus {
    
    private String modelo;
    private int anoFab;
    private String marca;
    private float quilometragem; 
    private int[][] assentos = new int[10][4];
    
    private Motorista condutor;
    
    
    ArrayList<Passageiro>passageiros = new ArrayList<>();
    
    //CONSTRUTORES
    public Onibus(String modelo, int anoFab, String marca, float quilometragem, Motorista condutor, int[][] assentos) {
        this.modelo = modelo;
        this.anoFab = anoFab;
        this.marca = marca;
        this.quilometragem = quilometragem;
        this.condutor = condutor;
        this.assentos = assentos;
    }

    public Onibus(String modelo) {
        this.modelo = modelo;
    }

    public Onibus(String modelo, Motorista condutor) {
        this.modelo = modelo;
        this.condutor = condutor;
    }

    public Onibus(String modelo, int anoFab, String marca, float quilometragem, Motorista condutor) {
        this.modelo = modelo;
        this.anoFab = anoFab;
        this.marca = marca;
        this.quilometragem = quilometragem;
        this.condutor = condutor;
    }
    
    public Onibus() {
    }
    
    //SETTERS
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public void setAnoFab(int anoFab) {
        this.anoFab = anoFab;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public void setQuilometragem(float quilometragem) {
        this.quilometragem = quilometragem;
    }
    public void setAssentos(int[][] assentos) {
        this.assentos = assentos;
    }
    public void setCondutor(Motorista condutor) {
        this.condutor = condutor;
    }
    public void setPassageiros(ArrayList<Passageiro> passageiros) {
        this.passageiros = passageiros;
    }
    
    //GETTERS
    public String getModelo() {
        return this.modelo;
    }
    public int getAnoFab() {
        return this.anoFab;
    }
    public String getMarca() {
        return this.marca;
    }
    public float getQuilometragem() {
        return quilometragem;
    }
    public int[][] getAssentos() {
        return this.assentos;
    }
    public Motorista getCondutor() {
        return this.condutor;
    }
    public ArrayList<Passageiro> getPassageiros() {
        return this.passageiros;
    }
    
    //Método para cadastrar novo onibus e retornar o objeto instanciado
    public Onibus cadReturnOnibus()
    {
        Scanner sc = new Scanner(System.in);
        Onibus oni;
        
        String modelo;
        int anoFab;
        String marca;
        float quilometragem; 
        int[][] assentos = new int[10][4];
        Motorista temp;
        System.out.print("\n==================ONIBUS====================\n");        
        System.out.print("\nModelo do onibus: ");
        modelo = sc.nextLine();
        
        int ok;
        //Verificação da data colocada
        do
        { 
            System.out.print("\nAno de fabricacao: ");
            anoFab = sc.nextInt();
            sc.nextLine();
            if(anoFab<1960||anoFab>2022)//Datas para verificação
            {
                System.out.print("\n============\nAno Invalido.\nTente Novamente\n============\n");
                ok=0;
            }
            else
                ok=1;
        }while(ok==0);
        
        System.out.print("\nMarca: ");
        marca = sc.nextLine();
        
        do
        {
            ok=0;
            System.out.print("\nQuilometragem: ");
            quilometragem = sc.nextFloat();
            if(quilometragem<0)//Deverá ser maior que 0
            {
                System.out.print("\n============\nQuilometragem Invalida.\nTente Novamente\n============\n");
                ok=0;
            }
            else
                ok=1;
        }while(ok==0);
        
        System.out.print("\n============================================\n");
        temp = new Motorista();
        oni  = new Onibus(modelo, anoFab,marca,quilometragem,temp,assentos);
        //Chama a Método para setar o Motorista, retornando o objeto instanciado
        oni.setCondutor(temp.cadReturnMotorista());
        
        return oni;
    }
    //Método para setar apenas os dados do onibus, deixando o motorista atual(moto), transferindo os dados dos passageiros (passageirosOutroOnibus) e retornando o obejto instanciado
    public Onibus cadReturnOnibusParcial(Motorista moto, ArrayList<Passageiro> passageirosOutroOnibus)
    {
        Scanner sc = new Scanner(System.in);
        Onibus oni;
        
        String modelo;
        int anoFab;
        String marca;
        float quilometragem; 
        int[][] assentos = new int[10][4];
        Motorista temp;
        System.out.print("\n==================ONIBUS====================\n");        
        System.out.print("\nModelo do onibus: ");
        modelo = sc.nextLine();
        int ok;
        //Verificação da data colocada para Ano de Fabricacao
        do
        { 
            ok=0;
            System.out.print("\nAno de fabricacao: ");
            anoFab = sc.nextInt();
            sc.nextLine();
            if(anoFab<1960||anoFab>2022)//Datas para verificação
            {
                System.out.print("\n============\nAno Invalido.\nTente Novamente\n============\n");
                ok=0;
            }
            else
                ok=1;
        }while(ok==0);
        
        
        System.out.print("\nMarca: ");
        marca = sc.nextLine();
        //Verificacao para Quilometragem
        do
        {
            ok=0;
            System.out.print("\nQuilometragem: ");
            quilometragem = sc.nextFloat();
            if(quilometragem<0)//Deverá ser maior que 0
            {
                System.out.print("\n============\nQuilometragem Invalida.\nTente Novamente\n============\n");
                ok=0;
            }
            else
                ok=1;
        }while(ok==0);
        
        System.out.print("\n============================================\n");
        oni  = new Onibus(modelo, anoFab,marca,quilometragem,moto,assentos);
        //Transferindo os dados do ArrayList do outro onibus para este
        if(!passageirosOutroOnibus.isEmpty())
        {
            oni.passageiros = passageirosOutroOnibus;
            oni.transfereAssentos();
        }
        
        
        return oni;
    }
    
    //Método para fazer o cadastro do passageiro, retornando o objeto instanciado
    public Passageiro addPassageiro()
    {
        
        //Cadastro padrão para os passageiros
        Scanner sc = new Scanner(System.in);
        
        String nomePass;
        int id;
        Data birth;
        String end;
        
        Passageiro temp;
        
        System.out.print("\nDigite seu nome: ");
        nomePass = sc.nextLine();
        int ok = 0;
        if(passageiros.isEmpty())
        {
            ok = 1;
        }
        //Verificação de RG - nao permitindo iguais
        do
        {
            System.out.print("\nDigite seu RG: ");
            id = sc.nextInt();
            sc.nextLine();
            int i;
            for(i=0;i<passageiros.size();i++)
            {
                if(passageiros.get(i).getId() == id)
                {
                    System.out.print("Esse RG ja esta cadastrado...\nO que deseja fazer?\n[1]Alterar RG inserido\n[2]Cancelar\n-----> ");
                    ok = 0;
                    do{
                        ok = sc.nextInt();
                        if(ok<1||ok>2)
                        {
                            System.out.println("Entrada Invalida. Tente novamente...");
                        }
                    }while(ok<1||ok>2);
                    if(ok == 1)
                    {
                    
                        System.out.print("Recomecando...");
                        ok = 0;
                    }
                    else
                    {
                        System.out.print("Cancelando...");
                        ok = 2;
                        return null;//retornará um objeto null que será removido posteriormente
                    
                    }

                }
                else
                {
                    ok = 1;
                }
            }
        }while(ok == 0);
            System.out.print("\nDigite sua data de nascimento:\n");
            birth = new Data();
            birth.setDataRegular();

            System.out.print("\nDigite seu endereco: ");
            end = sc.nextLine();
           
            temp = new Passageiro(nomePass, id, birth, end);

            return temp;//Retorna o passageiro a ser adicionado no veiculo especificado
    }
    //Método para exibir os assentos do onibus, mostrando as linhas e colunas a serem escolhidas
    public void exibirAssentos()
    {
        int i;
        int j;
        System.out.print("\n=======ASSENTOS===================================\n");
        System.out.print("   0  1     2  3");
        for(i=0;i<10;i++)
        {
           
            System.out.print("\n");
            System.out.print(i+"-");
         
            for(j=0;j<4;j++)
            {
                
                if(i==0&&j==0)
                {
                    //System.out.print("  "+j+"\n");
                }
                else if(j==2)
                {
                    System.out.print("   ");
                }
                
                System.out.print("["+assentos[i][j]+"]");
            }
        }
         System.out.print("\n==============================================\n");
    }
    //Método para conferir se o onibus está lotado
    public boolean confereOcupacao()
    {
        int i;
        int j;
        int aux=0;
        for(i=0;i<10;i++)
        {
         
            for(j=0;j<4;j++)
            {
                
                if(assentos[i][j]==0)
                {
                    aux+=1;
                }
 
            }
        }
        if(aux>0)
        {
            System.out.print("\n"+aux+" lugares disponiveis no onibus!");
            return true;
        }
        else
        {
            System.out.print("\nDesculpe, mas o onibus se encontra lotado...");
            return false;
        }
    }
    //Método para verificar se o assento linha l e coluna c está ocupado
    public boolean verificaAssento(int l, int c)
    {
        if(assentos[l][c]==0)
        {
            return true;
        }
        else
        {
            System.out.print("\n==============\nAssento Ocupado\n===============\n");
            return false;
        }
    }
    //Método para ocupar o assento linha l coluna c
    public void ocupaAssento(int l, int c)
    {
        assentos[l][c] = 1;
    }
    //Método para desocupar o assento linha l coluna c
    public void desocupaAssento(int l, int c)
    {
        assentos[l][c] = 0;
    }
    //Método para localizar o passageiro de indice x, retornando o objeto
    public Passageiro localizaPass(int x)
    {
        
        return passageiros.get(x);
            
    }
    //Método para transferir a ocupação dos assentos de um onibus para outro,
    //considerando que o array antigo já foi copiado para o atual
    public void transfereAssentos()
    {
        for(int i=0;i<passageiros.size();i++)
        {
            int l;
            int c;
            l = passageiros.get(i).getAssentoLinha();
            c = passageiros.get(i).getAssentoColuna();
            
            assentos[l][c] = 1;
        }
    
    }

}
