package first.exam;

/**
 * Fizz Buzz Plus
 * 
 *  @author Daniel Santanilla
 */
public class FizzBuzzPlus {
    
    private String result;

    public String doFizzBuzzPlus(int number) {
        result = String.valueOf(number); // String with value of number
        if (isFizz(number)) {
            result = "Fizz";
        }
        if (isBuzz(number))  {
            result = "Buzz";
        }
        if (isFizzBuzzByMultipled(number) || isFizzBuzzByContainedValues(number) ) {
            result = "FizzBuzz";
        }
        return result;
    }

    private boolean isFizzBuzzByMultipled(int number) {
        return (isMultipleOfThree(number) && isMultipleOfFive(number));
    }

    private boolean isFizzBuzzByContainedValues(int number) {
        return (containsThree(number) && containsFive(number));
    }

    private boolean isFizz(int number) {
        return (isMultipleOfThree(number) || containsThree(number));
    }

    private boolean isBuzz(int number) {
        return (isMultipleOfFive(number) || containsFive(number));
    }

    private boolean containsThree(int number) {
        String numString = String.valueOf(number);
        return numString.contains(String.valueOf(3));
    }

    private boolean containsFive(int number) {
        String numString = String.valueOf(number);
        return numString.contains(String.valueOf(5));
    }

    private boolean isMultipleOfThree(int number) {
        return number % 3 == 0;
    }

    private boolean isMultipleOfFive(int number) {
        return number % 5 == 0;
    }

    public void playFizzBuzzPlus() {
        for (int i = 1; i<101; i++) {
            System.out.println(doFizzBuzzPlus(i));
        }
    }

    public static void main( String[] args ) {
        FizzBuzzPlus fizzBuzz = new FizzBuzzPlus();
        fizzBuzz.playFizzBuzzPlus();
    }

}
