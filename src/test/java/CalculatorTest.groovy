import spock.lang.Shared
import spock.lang.Specification
import task.calculations.Calculator
import task.files.FileLoader
import task.strategy.FourOperatorsStrategy

class CalculatorTest extends Specification
{
   @Shared private FileLoader fileLoader

    def setupSpec()
    {
        fileLoader = new FileLoader()
    }

    void "test multiple numbers and operators"()
    {
        given:
        Calculator calculator = new Calculator(
            fileLoader.loadFileFromResourcePath("math.txt"),
            new FourOperatorsStrategy()
        )

        when:
        calculator.printResult()

        then:
        calculator.printResult() == 36
    }

    void "test single number and operator"()
    {
        given:
        Calculator calculator = new Calculator(
            fileLoader.loadFileFromResourcePath("oneNumber.txt"),
            new FourOperatorsStrategy()
        )

        when:
        calculator.printResult()

        then:
        calculator.printResult() == 20
    }
}
