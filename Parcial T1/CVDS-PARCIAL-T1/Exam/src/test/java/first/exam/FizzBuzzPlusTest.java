package first.exam;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for simple FizzBuzzPlus.
 * 
 * @author Daniel Santanilla
 */
public class FizzBuzzPlusTest {
    
    @Test
    public void shouldBeValueWhenTheNunberIsNotMultipleOfThreeOrFiveAndNotContainsThreeOrFive() {
        // Arrage
        FizzBuzzPlus fizzBuzz = new FizzBuzzPlus();
        String expected = "98";
        // Action
        String actual = fizzBuzz.doFizzBuzzPlus(98);
        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldBeFizzWhenTheNunberIsMultipleOfThree() {
        // Arrage
        FizzBuzzPlus fizzBuzz = new FizzBuzzPlus();
        String expected = "Fizz";
        // Action
        String actual = fizzBuzz.doFizzBuzzPlus(3);
        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldBeBuzzWhenTheNunberIsMultipleOfFive() {
        // Arrage
        FizzBuzzPlus fizzBuzz = new FizzBuzzPlus();
        String expected = "Buzz";
        // Action
        String actual = fizzBuzz.doFizzBuzzPlus(5);
        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldBeFizzBuzzWhenTheNunberIsMultipleOfThreeAndFive() {
        // Arrage
        FizzBuzzPlus fizzBuzz = new FizzBuzzPlus();
        String expected = "FizzBuzz";
        // Action
        String actual = fizzBuzz.doFizzBuzzPlus(15);
        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldBeFizzWhenTheNunberIsContainsThree() {
        // Arrage
        FizzBuzzPlus fizzBuzz = new FizzBuzzPlus();
        String expected = "Fizz";
        // Action
        String actual = fizzBuzz.doFizzBuzzPlus(13);
        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldBeBuzzWhenTheNunberIsContainsFive() {
        // Arrage
        FizzBuzzPlus fizzBuzz = new FizzBuzzPlus();
        String expected = "Buzz";
        // Action
        String actual = fizzBuzz.doFizzBuzzPlus(52);
        // Assert
        Assert.assertEquals(expected, actual);
    }

}
