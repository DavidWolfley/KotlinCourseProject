class Tile(mark: String, row: Row, column: Int) {

    enum class Row {
        A, B, C
    }

    @JvmField
    var currentMark: Mark.Marks? = null
    val rowValue: Row
    var columnValue: Int

    init {
        if (mark == "X") {
            currentMark = Mark.Marks.X
        }
        if (mark == "O") {
            currentMark = Mark.Marks.O
        } else {
            currentMark = null
        }
        rowValue = row
        columnValue = column
    }


    fun markString(): String? {
        return if (currentMark == Mark.Marks.X) {
            "X"
        } else if (currentMark == Mark.Marks.O) {
            "O"
        } else {
            null
        }
    }
}
