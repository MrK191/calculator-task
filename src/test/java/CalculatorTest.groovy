import spock.lang.Shared
import spock.lang.Specification
import task.calculations.Calculator
import task.files.FileLoader
import task.strategy.BigDecimalStrategy
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
        Calculator fourOperatorsCalculator = new Calculator(
            fileLoader.loadFileFromResourcePath("math.txt"),
            new FourOperatorsStrategy()
        )
        Calculator bigDecimalCalculator = new Calculator(
            fileLoader.loadFileFromResourcePath("math.txt"),
            new BigDecimalStrategy()
        )

        when:
        fourOperatorsCalculator.printResult()
        bigDecimalCalculator.printResult()

        then:
        fourOperatorsCalculator.printResult() == 36
        bigDecimalCalculator.printResult() == 36
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
