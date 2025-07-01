class Player(mark: String, title: String) {
    @JvmField
    var playerMark: Mark.Marks? = null
    val playerTitle: String

    init {
        playerMark = if (mark == "X") {
            Mark.Marks.X
        } else if (mark == "O") {
            Mark.Marks.O
        } else {
            null
        }
        playerTitle = title
    }

    fun mark(tile: Tile) {
        tile.currentMark = playerMark
    }
}
