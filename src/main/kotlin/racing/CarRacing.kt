package racing

import racing.domain.Car
import racing.domain.CarNameParser
import racing.domain.CarCollection
import racing.view.inputCarName
import racing.view.inputTryCount
import racing.view.printResult
import racing.view.printWinner

fun main() {
    val carNameLine = inputCarName()
    val tryCount = inputTryCount()

    val carCollection = CarNameParser.parse(carNameLine)
    val carRacing = CarRacing(carCollection, tryCount)
    carRacing.execute()

    println("실행 결과")
    val recordsPerCarName = carCollection.cars.associateBy({ it.name }, { it.getRecords() })
    printResult(recordsPerCarName, tryCount)
    printWinner(carRacing.getWinners())
}

class CarRacing(private val carCollection: CarCollection, private val tryCount: Int) {

    fun execute() {
        repeat(tryCount) {
            executeCarGo()
        }
    }

    private fun executeCarGo() {
        carCollection.cars.forEach {
            it.tryGo()
        }
    }

    fun getWinners(): List<Car> {
        val maxPosition = carCollection.cars.map { it.position }.max()
        require(maxPosition != null) { "car name이 입력되었다면, maxPosition은 null이 될수 없습니다." }

        return carCollection.cars.filter { it.position == maxPosition }
    }
}