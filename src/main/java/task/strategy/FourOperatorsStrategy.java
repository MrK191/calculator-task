package task.strategy;

public class FourOperatorsStrategy implements CalculateTwoNumbersStrategy
{
    @Override
    public double calculateTwoNumbers(double firstNumber, double secondNumber, String operator)
    {
        double result = 0;
        switch(operator)
        {
            case "add":
                result = firstNumber + secondNumber;
                break;
            case "subtract":
                result = firstNumber - secondNumber;
                break;
            case "divide":
                result = firstNumber / secondNumber;
                break;
            case "multiply":
                result = firstNumber * secondNumber;
                break;
        }
        return result;
    }
}
