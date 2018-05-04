package task.strategy;

import lombok.SneakyThrows;

import java.lang.reflect.Method;
import java.math.BigDecimal;

public class BigDecimalStrategy implements CalculateTwoNumbersStrategy
{
    @Override
    public double calculateTwoNumbers(double firstNumber, double secondNumber, String operator)
    {
        BigDecimal bigDecimal = new BigDecimal(firstNumber);
        
        return invokeMethod(bigDecimal, secondNumber, operator).doubleValue();
    }
    
    @SneakyThrows
    private BigDecimal invokeMethod(BigDecimal bigDecimal, double number, String operator)
    {
        Method methodName = bigDecimal.getClass().getMethod(operator, BigDecimal.class);
        return (BigDecimal) methodName.invoke(bigDecimal, BigDecimal.valueOf(number));
    }
}
