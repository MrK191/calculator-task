package task.calculations;

import lombok.SneakyThrows;
import task.strategy.CalculateTwoNumbersStrategy;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Calculator
{
    private final File file;
    private final CalculateTwoNumbersStrategy twoNumbersCalculator;
    
    public Calculator(File file, CalculateTwoNumbersStrategy calculateTwoNumbers)
    {
        this.file = file;
        this.twoNumbersCalculator = calculateTwoNumbers;
    }
    
    public double printResult()
    {
        return calculateStringArray();
    }
    
    @SneakyThrows
    private String[] convertFileIntoStringArray()
    {
        List<String> lines = Files.readAllLines(Paths.get(file.toURI()));
        return lines.get(0).split(" ");
    }
    
    private double calculateStringArray()
    {
        String[] numbersArray = convertFileIntoStringArray();
        double result = Double.valueOf(numbersArray[numbersArray.length - 1]);
        
        for(int i = 0; i < numbersArray.length - 2; i += 2)
        {
            result = twoNumbersCalculator.calculateTwoNumbers(result, Double.valueOf(numbersArray[i + 1]), numbersArray[i]);
        }
        return result;
    }
}
