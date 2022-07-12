package principal;
import java.util.Scanner;

/**
 *
 * @author vesrozeno - Vitor Emanuel da Silva Rozeno
 */
public class Tempo {
    
    private int hora;
    private int minuto;

    //CONSTRUTORES
    public Tempo(int hora, int minuto) {
        this.hora = hora;
        this.minuto = minuto;
    }
    public Tempo() {
    }
    
    //SETTERS
    public void setHora(int hora) {
        this.hora = hora;
    }
    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }

    //GETTERS
    public int getHora() {
        return this.hora;
    }
    public int getMinuto() {
        return this.minuto;
    }   
    
    //Método para setar Horario
    public void setHorario()   {
        int hora;
        int minuto;
        int ok = 0;
        
        Scanner sc = new Scanner(System.in);
        
        do
        {
            System.out.print("\nDigite a hora: ");
            hora = sc.nextInt();
            System.out.print("\nDigite os minutos: ");
            minuto = sc.nextInt();
            //Verificação da entrada
            if(hora<0||hora>23)
            {
                ok = 0;
                System.out.println("\n============\nHora invalida\n============\n");
            }
            else if(minuto<0||minuto>59)
            {
                ok = 0;
                System.out.println("\n============\nMinuto invalido\n============\n");
            }
            else
            {
                ok = 1;
            }
        
        }while(ok == 0);
        
        this.hora = hora;
        this.minuto = minuto;
    }  
    //Método que retorna o Tempo x no formado HH"h"mm
    public String getHoraFormatada(Tempo x)
    {
        return(this.hora+"h"+this.minuto);
    
    }
    //Método de verificação - acusa se o horario de chegada é antes do de saída
    public boolean comparaHoras(Data x, Data y, Tempo a, Tempo b)
    {
        //Vê se as datas são iguais
        if(x.datasIguais(x,y)==true)
        {
            if((a.getHora()==b.getHora())&&(a.getMinuto()==b.getMinuto()))
            {
                System.out.print("\n====================\nHoras invalidas: Mesma hora de chegada e saida\n======================\n");
                return true;
            }
            else if((a.getHora()==b.getHora())&&(a.getMinuto()>b.getMinuto()))
            {
                System.out.print("\n====================\nHoras invalidas: Chegada antes da Saida\n======================\n");
                return true;
            }
            else if(a.getHora()>b.getHora())
            {
                System.out.print("\n====================\nHoras invalidas: Chegada antes da Saida\n======================\n");
                return true;
            }
            else
            {
                return false;
            }
        }
        return false;
    }
    
}
