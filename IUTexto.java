import java.util.Scanner;
/**
 * Modela el interfaz para interactuar con el usuario
 * @author - 
 */
public class IUTexto
{
    private Scanner teclado;
    private CalculadoraOctal calculadora;
    private PintorFiguras pintor;

    /**
     * Constructor  
     */
    public IUTexto(CalculadoraOctal calculadora, PintorFiguras pintor)
    {
        this.teclado = new Scanner(System.in);
        this.calculadora = calculadora;
        this.pintor = pintor;
    }

    /**
     * Controla la lógica de la aplicación
     */
    public void iniciar()
    {
        hacerSumasOctales();
        dibujarFiguras();

    }

    /**
     *  - borrar la pantalla
     *  - pedir al usuario un par de números
     *  - si los números no están en octal mostrar un mensaje
     *  - si los números no tienen el mismo número de cifras mostrar un mensaje
     *  - si son correctos calcular su suma octal y mostrar el resultado en pantalla
     *  - los pasos anteriores se repiten mientras el usuario quiera (pulsa 'S' o 's')
     *  
     */
    private void hacerSumasOctales()
    {
        int numero1 = 0;
        int numero2 = 0;
        String error = "";
        String otraSuma = "";
        
        Pantalla.borrarPantalla();
       
        do
        {
            error = "";
            System.out.println("\n\nIntroduce un numero en octal: ");
            numero1 = teclado.nextInt();
            System.out.println("Introduce otro numero en octal: ");
            numero2 = teclado.nextInt();
            
            if( !(Utilidades.estaEnOctal(numero1)) || !(Utilidades.estaEnOctal(numero2)) )
            {
                error = "Alguno de los numeros no esta en octal";
            }
        
            if( Utilidades.contarCifras(numero1) != Utilidades.contarCifras(numero2) )
            {
                error = "No tienen el mismo numero de cifras";
            }
            
            if(error != "")
            {
                System.out.println("\n\n\n" + error);
            }
            else
            {
                System.out.println("\n------------------------------");
                System.out.printf("\n%30d", numero1);
                System.out.printf("\n%30d", numero1);
                System.out.printf("\n%15s%15d", "Suma Octal", calculadora.sumarEnOctal(numero1, numero2));
            }
            
            do
            {
                System.out.print("\n\nQuiere hacer otra suma en octal? (S / N): ");
                otraSuma = teclado.next();
            }
            while(! (otraSuma.equals("S") || otraSuma.equals("N")));
            
        }
        while(otraSuma.equals("S"));
        
    }

    /**
     *  Pide al usuario un valor de altura, 
     *  valida que sea correcto (un valor entre 1 y 10)
     *  y muestra la figura en pantalla
     */

    private void dibujarFiguras()
    {
        int altura = 0;
        boolean mal = false;
        Pantalla.borrarPantalla();
        
        do
        {
            if(mal == true)
            {
                System.out.println("Error. Altura de la figura? (1-10)");
            }
            else
            {
                System.out.println("Altura de la figura? (1-10)");
            }
            
            altura = teclado.nextInt();
            mal = true;
            
        }
        while((altura < 1) || (altura > 10));
        
        pintor.dibujarFigura(altura);
    }

}
