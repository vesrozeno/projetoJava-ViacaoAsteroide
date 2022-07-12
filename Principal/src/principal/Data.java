package principal;
import java.util.Scanner;
/**
 *
 * @author vesrozeno - Vitor Emanuel da Silva Rozeno
 */
public class Data {
    
    
    private int dia;
    private int mes;
    private int ano;

    public Data(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }
    public Data() {
    }
    public void setDia(int dia) {
        this.dia = dia;
    }
    public void setMes(int mes) {
        this.mes = mes;
    }
    public void setAno(int ano) {
        this.ano = ano;
    }
    public int getDia() {
        return this.dia;
    }
    public int getMes() {
        return this.mes;
    }
    public int getAno() {
        return this.ano;
    }
    
    //Método para setar datas regulares, como de nascimento, admissao,
    //entre outras em um período de 92 anos
    public void setDataRegular()    {
        int dia;
        int mes;
        int ano;
        int ok = 0;
                
        Scanner sc =  new Scanner (System.in);
        do
        {
            System.out.print("\nDigite o dia: ");
            dia = sc.nextInt();
            System.out.print("\nDigite o mes: ");
            mes = sc.nextInt();
            System.out.print("\nDigite o ano: ");
            ano = sc.nextInt();
            
            //Verificações de entrada
            if(mes<1||mes>12)
            {
                ok = 0;
                System.out.println("\n============\nData invalida : mes invalido.\n============\n");
            }
            else
            {
                if(ano<1930||ano>2022)
                {
                    ok = 0;
                    System.out.println("\n============\nData invalida : ano invalido.\n============\n");
                }
                else
                {
                    if(dia<1||dia>31)
                    {
                        ok = 0;
                        System.out.println("\n============\nData invalida : dia invalido.\n============\n");
                    }
                    //Ano bissexto
                    if((ano%4==0)&&(mes==2)&&(dia<1||dia>29))
                    {
                        ok = 0;
                        System.out.println("\n============\nData invalida : dia invalido.\n============\n");
                    }
                    //Ano não é bissexto
                    else if((ano%4!=0)&&(mes==2)&&(dia<1||dia>28))
                    {
                        ok = 0;
                        System.out.println("\n============\nData invalida : dia invalido.\n============\n");
                    }
                    //Qt de dias de determinados meses
                    else if(((mes==4)||(mes==6)||(mes==9)||(mes==11))&&(dia>30))
                    {
                        ok = 0;
                        System.out.println("\n============\nData invalida : dia invalido.\n============\n");
                    }
                    else
                    {
                        ok = 1;
                    }
                }
            }
        }while(ok == 0);
        
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }
    //Método para setar datas de rota,
    //sendo admitas datas no período de 1 ano: 2022-2023
    public void setDataRota()
    {
        int dia;
        int mes;
        int ano;
        int ok = 0;
                
        Scanner sc =  new Scanner (System.in);
        do
        {
            System.out.print("\nDigite o dia: ");
            dia = sc.nextInt();
            System.out.print("\nDigite o mes: ");
            mes = sc.nextInt();
            System.out.print("\nDigite o ano: ");
            ano = sc.nextInt();
            
            //Verificações de entrada
            if(mes<1||mes>12)
            {
                ok = 0;
                System.out.println("\n============\nData invalida : mes invalido.\n============\n");
            }
            else
            {
                if(ano<2022||ano>2023)
                {
                    ok = 0;
                    System.out.println("\n============\nData invalida : insira um ano entre 2022 e 2023.\n============\n");
                }
                else
                {
                    if(dia<1||dia>31)
                    {
                        ok = 0;
                        System.out.println("\n============\nData invalida : dia invalido.\n============\n");
                    }
                    //Ano bissexto
                    if((ano%4==0)&&(mes==2)&&(dia<1||dia>29))
                    {
                        ok = 0;
                        System.out.println("\n============\nData invalida : dia invalido.\n============\n");
                    }
                    //Ano não é bissexto
                    else if((ano%4!=0)&&(mes==2)&&(dia<1||dia>28))
                    {
                        ok = 0;
                        System.out.println("\n============\nData invalida : dia invalido.\n============\n");
                    }
                    //Qt de dias de determinados meses
                    else if(((mes==4)||(mes==6)||(mes==9)||(mes==11))&&(dia>30))
                    {
                        ok = 0;
                        System.out.println("\n============\nData invalida : dia invalido.\n============\n");
                    }
                    else
                    {
                        ok = 1;
                    }
                }
            }
        }while(ok == 0);
        
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }
    //Método que retorna a Data x no formato dd/mm/AAAA
    public String getDataFormatada(Data x)
    {
        return(this.dia + "/" + this.mes + "/" + this.ano);
    }
    //Método que compara e verifica as datas de saida (a) e chegada (b), 
    //acusando entradas invalidas
    public boolean comparaDataViagem(Data a, Data b)
    {
        if (a.getAno()!=b.getAno())
        {
            System.out.print("\n============\nData invalida: Ano invalido.\n============\n");
            return false;
        }
        else if(a.getMes()!=b.getMes())
        {
            System.out.print("\n============\nData invalida: Mes invalido.\n============\n");
            return false;
        }
        else if(a.getDia()>b.getDia())
        {
            System.out.print("\n============\nData invalida: Dia invalido.\n============\n");
            return false;
        }
        else
        {
            return true;
        }
    }
    //Método que verifica se data a e data b são iguais
    public boolean datasIguais(Data a, Data b)
    {
        if((a.getAno()==b.getAno())&&(a.getMes()==b.getMes())&&(a.getDia()==b.getDia()))
        {
            return true;
        }
        else
        {
            return false;
        }
    
    
    }
    
}
    
