package racing.model

object CarMovingStrategy : MovingStrategy {
    private const val MOVABLE_MIN_NUMBER = 4

    override fun isMovable(): Boolean {
        return Number.random() >= MOVABLE_MIN_NUMBER
    }
}