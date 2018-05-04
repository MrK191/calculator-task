package task;

import task.calculations.Calculator;
import task.files.FileLoader;
import task.strategy.FourOperatorsStrategy;

public class Main
{
    public static void main(String[] args)
    {
        FileLoader fileLoader = new FileLoader();
        Calculator calculator = new Calculator(fileLoader.loadFileFromResourcePath("math.txt"), new FourOperatorsStrategy());
        
        System.out.println(calculator.printResult());
    }
}
