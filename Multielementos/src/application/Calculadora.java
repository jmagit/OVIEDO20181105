package application;

/**
 * Clase simple para realizar calculos acumulados.
 *
 * @author Javier
 */
public class Calculadora {

    /**
     * Lista de las operaciones soportadas
     */
    public static final String OPERACIONES_SOPORTADAS = "+-*/=";
    private double acumulado = 0;
    private char operacion = '+';

    /**
     * Constructor por defecto
     */
    public Calculadora() {
        inicializa();
    }

	/**
	 * Restaura la calculadora
	 * 
	 * @param acumulado
	 * @param operacion
	 */
    public Calculadora(double acumulado, char operacion) {
        this.acumulado=acumulado;
        this.operacion=operacion;
    }

    /**
     * Restaura el valor inicial para calcular la siguiente secuencia
     */
    public void inicializa() {
        acumulado = 0;
        operacion = '+';
    }

    /**
     * Obtiene el total acumulado hasta el momento.
     * @return Valor acumulado
     */
    public double getAcumulado() {
        return acumulado;
    }

    /**
     * Obtiene la operaci�n pendiente.
     * @return Operaci�n pendiente
     */
    public char getOperacion() {
        return operacion;
    }
    
    /**
     * Cambia el signo del acumulado para continuar la operaci�n
     */
    public void cambiaSigno() {
    	acumulado = -acumulado;
    }

    /**
     * Realiza la operacion pendiente una vez obtenido el segundo operador y 
     * guarda la nueva operaci�n pendiente
     * @param operando2 segundo operador
     * @param nuevaOperacion la nueva operaci�n pendiente
     * @return el total acumulado hasta el momento
     * @throws Exception Cuando el simbolo de operacion no esta soportado
     */
    public double calcula(double operando2, char nuevaOperacion) throws CalculadoraException{
        if (OPERACIONES_SOPORTADAS.indexOf(nuevaOperacion) == -1) {
            throw new CalculadoraException("Operaci�n no soportada.");
        }
        switch (operacion) {
            case '+':
                acumulado += operando2;
                break;
            case '-':
                acumulado -= operando2;
                break;
            case '*':
                acumulado *= operando2;
                break;
            case '/':
                acumulado /= operando2;
                break;
            case '=':
                acumulado = operando2;
                break;
            default:
                throw new CalculadoraException("Operaci�n no soportada.");
        }
        this.operacion = nuevaOperacion;
        return acumulado;
    }

    /**
     * Sobrecarga
     * @see Calculadora#calcula(double, char) 
     * @param operando2 segundo operador
     * @param nuevaOperacion la nueva operaci�n pendiente
     * @return el total acumulado hasta el momento
     * @throws Exception Cuando el simbolo de operacion no esta soportado
     */
    public double calcula(String operando2, char nuevaOperacion) throws CalculadoraException {
        if (operando2.endsWith(",")) {
            operando2 += "0";
        }
        try {
            return calcula(
                    Double.parseDouble(operando2.replace(',', '.')),
                    nuevaOperacion);
        } catch (NumberFormatException ex) {
            throw new CalculadoraException(
                    "El operando no tienen un formato n�merico valido.", 
                    ex);
        }
    }
}