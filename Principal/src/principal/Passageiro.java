
package principal;
import java.util.Scanner;
/**
 *
 * @author vesrozeno - Vitor Emanuel da Silva Rozeno
 */
public class Passageiro {
    
    private String nomePass;
    private int id;
    private Data birth;
    private String end;
    private int assentoLinha;
    private int assentoColuna;
    
    //CONSTRUTORES
    
    public Passageiro(String nomePass, int id, Data birth, String end, int assentoLinha, int assentoColuna) {
        this.nomePass = nomePass;
        this.id = id;
        this.birth = birth;
        this.end = end;
        this.assentoLinha = assentoLinha;
        this.assentoColuna = assentoColuna;
    }
    public Passageiro(String nomePass, int id, Data birth, String end) {
        this.nomePass = nomePass;
        this.id = id;
        this.birth = birth;
        this.end = end;
    }
    
    //GETTERS
    public String getNomePass()   {
        return this.nomePass;
    }
    public int getId()    {
        return this.id;
    }
    public Data getBirth()   {
        return this.birth;
    }
    public String getEnd()
    {
        return this.end;
    }
    public int getAssentoLinha() {
        return this.assentoLinha;
    }
    public int getAssentoColuna() {
        return this.assentoColuna;
    }
    
    
    //SETTERS
    public void setDados(String nomePass, int id, Data birth, String end)    {
        this.nomePass = nomePass;
        this.id = id;
        this.birth = birth;
        this.end = end;
    }
    public void setNomePass(String nomePass) {
        this.nomePass = nomePass;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setBirth(Data birth) {
        this.birth = birth;
    }
    public void setEnd(String end) {
        this.end = end;
    }
    
    //Método para setar os assentos
    public void setAssentos()
    {
        int assentoLinha;
        int assentoColuna;
        
        Scanner sc = new Scanner(System.in);
        do
        {
            System.out.print("\nDigite a linha: ");
            assentoLinha = sc.nextInt();
            
            System.out.print("\nDigite a coluna: ");
            assentoColuna = sc.nextInt();
            //Verifica se as entradas sao validas
        }while(verificaIndiceAssento(assentoLinha,assentoColuna)==false);
       
        
        
        
        this.assentoLinha = assentoLinha;
        this.assentoColuna = assentoColuna;
    
    }
    //Método para verificar as entradas de linha(l) e coluna(c) dos assentos
    public boolean verificaIndiceAssento(int l, int c)
    {
        if((l<0||l>9)||c<0||c>3)
        {
            System.out.print("\n==============\nEntrada invalida\nDigite linha e coluna validas\n==============\n");
            return false;
        }
        else
        {
            return true;
        }
    }
}
