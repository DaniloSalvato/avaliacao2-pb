import java.util.Scanner;

public class Analise {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String olho = ":";
        String nariz = "-";
        String bocaDivertido = ")";
        String bocaChateado = "(";

        System.out.println("\nInsira sua mensagem: ");
        String[] respostaUsuario = sc.nextLine().split("");
        int tamanhoFrase = respostaUsuario.length;

        int RostoDivertido = 0;
        int RostoChateado = 0;

        for (int i = 0; i < tamanhoFrase; i++) {

            if (olho.equals(respostaUsuario[i])) {

                try{
                    if (nariz.equals(respostaUsuario[i + 1])) {

                        try{
                            if (bocaDivertido.equals(respostaUsuario[i + 2])) {
                                RostoDivertido++;
                            } else if (bocaChateado.equals(respostaUsuario[i + 2])) {
                                RostoChateado++;
                            }

                        }catch (ArrayIndexOutOfBoundsException e){}
                    }
                }catch(ArrayIndexOutOfBoundsException e){}
            }
        }

        if (RostoDivertido > RostoChateado) {
            System.out.println("Divertido");
        } else if (RostoChateado > RostoDivertido) {
            System.out.println("Chateado");
        } else {
            System.out.println("Neutro");
        }
    }

}
