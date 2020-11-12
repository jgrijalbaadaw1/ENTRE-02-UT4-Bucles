
/**
 *  Representa a una calcualdora que hace sumas octales
 * 
 * @author - Javier Grijalba Azpiroz 
 * 
 */
public class CalculadoraOctal
{
    
    /**
     * sumar dos nºs supuestos en base 8 y con el mismo
     * nº de cifras
     * Asumimos positivos
     */
    public int sumarEnOctal(int n1, int n2)
    {
        int cifraN1 = 0;
        int cifraN2 = 0;
        int suma = 0;
        int arrastre = 0;
        int resultado = 0;
        int vueltas = Utilidades.contarCifras(n1);
        
        for(int i = 0; i <= vueltas; i++)
        {
            cifraN1 = n1 % 10;
            cifraN2 = n2 % 10;
            suma = cifraN1 + cifraN2 + arrastre;
            arrastre = 0;
            n1 = n1 / 10;
            n2 = n2 / 10;
            
            if(suma > 7)
            {
                suma = suma - 8;
                arrastre = 1;
            }
            
            resultado = resultado + (suma * potencias10(i));
        }
        
        return resultado;
    }
    
    private int potencias10(int potencia)
    {
       return (int)Math.pow(10, potencia); 
    }
}
