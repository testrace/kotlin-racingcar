package stringcalculator

import stringcalculator.domain.Operator
import stringcalculator.ui.InputView

fun main() {
    Application().run()
}

private const val INDEX_OF_NUMBER = 0
private const val INDEX_OF_SIGN = 1

class Application {

    fun run() {
        val inputFormula = InputView.inputFormula()
        val result = calculate(inputFormula)
        print(result)
    }

    private fun calculate(inputFormula: List<String>): Int {
        val numbers = getNumbers(inputFormula)
        val signs = getSigns(inputFormula)

        return calculateInternal(numbers, signs)
    }

    private fun calculateInternal(numbers: List<Int>, signs: List<String>): Int {
        var total = numbers[0]
        for (i in signs.indices) {
            val operator = Operator.of(signs[i])

            val left = total
            val right = numbers[i + 1]
            total = operator.calculate(left, right)
        }

        return total
    }

    private fun getSigns(stringFormula: List<String>) =
        stringFormula.filterIndexed { index, _ -> index % 2 == INDEX_OF_SIGN }

    private fun getNumbers(stringFormula: List<String>) =
        stringFormula.filterIndexed { index, _ -> index % 2 == INDEX_OF_NUMBER }.map { it.toInt() }
}
