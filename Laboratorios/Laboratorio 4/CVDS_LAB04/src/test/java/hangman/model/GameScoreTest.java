package hangman.model;

import org.junit.Assert;
import org.junit.Test;

/** Clases de equivalencia para OriginalScore
 * 
 * 1. Numeros negativos con frontera en 0, cualquier numero
 * en este rango equivale a 0.
 * 2. Numeros positivos no tienen cambio.
 */

/** Clases de equivalencia para BonusScore
 * 
 * 1. Numeros negativos con frontera en 0, cualquier numero
 * en este rango equivale a 0.
 * 2. Numeros positivos no tienen cambio.
 */

/** Clases de equivalencia para PowerScore.
 * 
 * 1. Numeros negativos con frontera en 0, cualquier numero
 * en este rango equivale a 0.
 * 2. Numeros en el rango [1, 500) no tienen cambio.
 * 3. Numeros mayores a 500 con frontera en 500 equivalen a 500.
 */

public class GameScoreTest {
    
    // Test for Original Score
    @Test
    public void givenOriginalScoreShouldBeZeroWhenScoreIsNegative() {
        // Arrange
        GameScore score = new OriginalScore();
        int expected = 0;
        // Act
        int actual = score.calculateScore(0, 15);
        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void givenOriginalScoreShouldNotDoAnythingWhenScoreIsMoreThanZero() {
        // Arrange
        GameScore score = new OriginalScore();
        int expected = 100;
        // Act
        int actual = score.calculateScore(0, 0);
        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void givenOriginalScoreShouldBeZeroWhenScoreIsZero() {
        // Arrange
        GameScore score = new OriginalScore();
        int expected = 0;
        // Act
        int actual = score.calculateScore(0, 10);
        // Assert
        Assert.assertEquals(expected, actual);
    }

    // Test for BonusScore
    @Test
    public void givenBonusScoreShouldBeZeroWhenScoreIsNegative() {
        // Arrange
        GameScore score = new BonusScore();
        int expected = 0;
        // Act
        int actual = score.calculateScore(0, 1);
        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void givenBonusScoreShouldNotDoAnythingWhenScoreIsMoreThanZero() {
        // Arrange
        GameScore score = new BonusScore();
        int expected = 10;
        // Act
        int actual = score.calculateScore(1, 0);
        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void givenBonusScoreSshouldBeZeroWhenScoreIsZero() {
        // Arrange
        GameScore score = new BonusScore();
        int expected = 0;
        // Act
        int actual = score.calculateScore(0, 0);
        // Assert
        Assert.assertEquals(expected, actual);
    }

    // Test for PowerScore
    @Test
    public void givenPowerScoreShouldBeZeroWhenScoreIsNegative() {
        // Arrange
        GameScore score = new PowerScore();
        int expected = 0;
        // Act
        int actual = score.calculateScore(0, 1);
        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void givenPowerScoreShouldBeZeroWhenScoreIsZero() {
        // Arrange
        GameScore score = new PowerScore();
        int expected = 1;
        // Act
        int actual = score.calculateScore(0, 0);
        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void givenPowerScoreShouldNotDoAnythingWhenScoreIsBetween1And500() {
        // Arrange
        GameScore score = new PowerScore();
        int expected = 125;
        // Act
        int actual = score.calculateScore(3, 0);
        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void givenPowerScoreShouldBe500WhenScoreIs500() {
        // Arrange
        GameScore score = new PowerScore();
        int expected = 500;
        // Act
        int actual = score.calculateScore(4, 15);
        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void givenPowerScoreShouldBe500WhenScoreIsMoreThan500() {
        // Arrange
        GameScore score = new PowerScore();
        int expected = 500;
        // Act
        int actual = score.calculateScore(6, 0);
        // Assert
        Assert.assertEquals(expected, actual);
    }

}
