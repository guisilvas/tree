/*
 * Nome: Guilherme Soares Silva
 * Matrícula: 863485
 * Atividade: JAVA [PROVA 02] Sistema Bonito para Celulares
 */

import java.util.*; // importando bibliotecas

public class Main
{
    public static void main(String args[])
    {
        // Declarando variaveis
        Scanner scan = new Scanner(System.in);
        int n, t, c;
        int sum = 0;

        try {
            n = scan.nextInt(); // Lendo quantidade de entradas

            while (n != 0) {
                for(int i = 1; i < n; i++) // Lendo entradas
                {
                    t = scan.nextInt();
                    c = scan.nextInt();
                    sum = sum + c;
                }
                System.out.println(sum); // Printando resultado
                n = 0;
                n = scan.nextInt();
            }

            scan.close(); // Fechando Scanner
        } catch (Exception e) {
            System.out.println(0);
        }
    }
}