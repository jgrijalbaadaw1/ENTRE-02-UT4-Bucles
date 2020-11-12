
/**
 *  Clase que dibuja una figura 
 * 
 * @author - 
 *  
 */
public class PintorFiguras
{
    private static final int ANCHO_BLOQUE = 4;
    private static final char ESPACIO = ' ';
    private static final char CAR1 = 'B';
    private static final char CAR2 = '=';


    /**
     * Dibuja una figura (ver enunciado) de altura
     * indicada (se asume la altura un valor correcto)
     * 
     * (usa bucles for)
     */
    public  void dibujarFigura(int altura)
    {
        char caracter = ' ';
        
        for(int fila = 1; fila <= altura; fila ++)
        {
            
            escribirEspacios(ESPACIO, (altura - fila) * 2);
            
            for(int a = 1; a <= fila; a++)
            {
               
               caracter = CAR1;
               
               if(par(a))
               {
                   caracter = CAR2;
               }
               
               escribirEspacios(caracter, ANCHO_BLOQUE);
            }
            
            System.out.println();
        }
    }

    /**
     * Método privado de ayuda que escribe n espacios en la misma línea
     */
    private  void escribirEspacios(char caracter, int n)
    {
        for(int i = 0; i < n; i ++)
        {
            System.out.print(caracter);
        }
    }
    
    private boolean par(int fila)
    {
        return fila % 2 == 0;
    }
}
