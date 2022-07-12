package principal;
import java.util.Scanner;

/**
 *
 * @author vesrozeno - Vitor Emanuel da Silva Rozeno
 */
public class Motorista {
    
    private String nomeMoto;
    private Data dataAdmis;
    private String cnh;
    
    //CONSTRUTORES
    public Motorista(String nomeMoto, Data dataAdmis, String cnh) {
        this.nomeMoto = nomeMoto;
        this.dataAdmis = dataAdmis;
        this.cnh = cnh;
    }

    public Motorista(String nomeMoto) {
        this.nomeMoto = nomeMoto;
    }
    
    public Motorista() {
    }
    
    //SETTERS
    public void setNomeMoto(String nomeMoto) {
        this.nomeMoto = nomeMoto;
    }
    public void setDataAdmis(Data dataAdmis) {
        this.dataAdmis = dataAdmis;
    }
    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    //GETTERS
    public String getNomeMoto() {
        return this.nomeMoto;
    }
    public Data getDataAdmis() {
        return this.dataAdmis;
    }
    public String getCnh() {
        return this.cnh;
    }
    
    //Método para cadastrar o motorista, retornando o objeto instanciado
    public Motorista cadReturnMotorista()
    {
        Scanner sc = new Scanner(System.in);
        
        Motorista moto;

        String nomeMoto;
        Data dataAdmis;
        String cnh;
        System.out.print("\n=====================MOTORISTA==================\n");
        System.out.print("\nNome do motorista: ");
        nomeMoto = sc.nextLine();

        System.out.print("\nData de admissao:\n");
        dataAdmis = new Data();
        dataAdmis.setDataRegular();

        System.out.print("\nNumero da CNH: ");
        cnh = sc.nextLine();
        System.out.print("\n================================================\n");
        moto = new Motorista(nomeMoto,dataAdmis,cnh);
        
        return moto;
        
    }    
}
