package hangman.model;

public class PowerScore implements GameScore {
    
    private int score = 0;

    /** Calcula el puntaje de acuerdo a las letras correctas e incorrectas.
     * 
     * @pre Se inicia con 0 puntos.
     * @post El minimo puntaje es 0 y el maximo es 500.
     * @param correctCount Cantidad de letras correctas.
     * @param incorrectCount Cantidad de letras incorrectas.
     * @return Puntaje con bonificacion de 5^i puntos por la i-esima letra correcta
     * y penalizacion de 8 puntos por cada letra incorrecta.
     */
    public int calculateScore(int correctCount, int incorrectCount) {
        score = Math.pow(5, correctCount) - incorrectCount*8 >= 500 
        ? 500 : (int) Math.pow(5, correctCount) - incorrectCount*8;
        return score <= 0 ? 0 : score ;
    }

    public int initialScore() {
        score = 0;
        return score;
    }

}
