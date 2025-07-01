import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.ui.tooling.preview.Preview


@OptIn(ExperimentalResourceApi::class)
@Composable
@Preview
fun App() { // First, initialize Tiles and Players
    val tile1 = Tile("", Tile.Row.A, 1)
    val tile2 = Tile("", Tile.Row.A, 2)
    val tile3 = Tile("", Tile.Row.A, 3)
    val tile4 = Tile("", Tile.Row.B, 1)
    val tile5 = Tile("", Tile.Row.B, 2)
    val tile6 = Tile("", Tile.Row.B, 3)
    val tile7 = Tile("", Tile.Row.C, 1)
    val tile8 = Tile("", Tile.Row.C, 2)
    val tile9 = Tile("", Tile.Row.C, 3)
    val tilelist = listOf(tile1,tile2,tile3,tile4,tile5,tile6,tile7,tile8,tile9)

    val player1 = Player("X", "Player 1")
    val player2 = Player("O", "Player 2")
    val blankPlayer = Player(" ", "No one")

    var currentPlayer = player1
    var winningPlayer = Player(" ", " ")

    // Determines if the three given Tiles all have the same mark
    fun adjacent(first: Tile, second: Tile, third: Tile): Boolean {
        return if (first.currentMark?.equals(second.currentMark) == true && second.currentMark?.equals(third.currentMark) == true) {
            return true
        } else false
    }

    // Counts how many tiles are marked. Used to check for draws
    fun markCount(list: List<Tile>): Int {
        var i = 0
        for(tile in list) {
            if(tile.currentMark != null) {
                i++
            }
        }
        return i
    }


    MaterialTheme {
        fun swapTurn() = if(currentPlayer == player1) {
            currentPlayer = player2
        }
        else if(currentPlayer == player2){
            currentPlayer = player1
        }
        else {

        }


        // showContent allows for the page to be updated live, while gameEnd contains elements
        // of the screen that are only shown after the game is over
        var showContent by remember { mutableStateOf(false) }
        var gameEnd by remember { mutableStateOf(false) }

        Column() { // Column establishes vertically aligned UI elements in Jetpack Compose, while
                                 // Row is horizontal
            if(gameEnd) { // Checks if the game is over, either normally or by draw
                if(markCount(tilelist) == 9) {
                    BasicText(text = "Draw, no one wins!", modifier = Modifier.padding(10.dp))
                }
                else {
                    BasicText(text = "${winningPlayer.playerTitle} Wins!", modifier = Modifier.padding(10.dp))
                }
            }
            else {
                BasicText(text = "${currentPlayer.playerTitle}'s Turn", modifier = Modifier.padding(10.dp))
            }
            Row() {
                // Each button is the same, first the tile is marked with the current player's mark,
                // then checks all possible win conditions involving that tile
                //
                  val button1 = Button(onClick = {
                    if (tile1.currentMark == null) {
                        currentPlayer.mark(tile1); showContent = !showContent;
                        if(adjacent(tile1, tile2, tile3) or adjacent(tile1, tile4, tile7) or adjacent(tile1, tile5, tile9)) {
                            print(markCount(tilelist))
                            winningPlayer = currentPlayer
                            currentPlayer = blankPlayer
                            gameEnd = !gameEnd
                        }
                        if(markCount(tilelist) == 9) {
                            gameEnd = !gameEnd
                        }
                        swapTurn()
                    } else {
                        showContent = !showContent
                    }
                }, modifier = Modifier.padding(1.dp))
                {
                    tile1.markString()?.let { Text(it) }

                }
                val button2 = Button(onClick = {
                    if (tile2.currentMark == null) {
                        currentPlayer.mark(tile2); showContent = !showContent;
                        if(adjacent(tile1, tile2, tile3) or adjacent(tile2, tile5, tile8)) {
                            winningPlayer = currentPlayer
                            currentPlayer = blankPlayer
                            gameEnd = !gameEnd
                        }
                        if(markCount(tilelist) == 9) {
                            gameEnd = !gameEnd
                        }
                        swapTurn()
                    } else {
                        showContent = !showContent
                    }
                }, modifier = Modifier.padding(1.dp))
                {
                    tile2.markString()?.let { Text(it) }
                }
                val button3 = Button(onClick = {
                    if (tile3.currentMark == null) {
                        currentPlayer.mark(tile3); showContent = !showContent;
                        if(adjacent(tile1, tile2, tile3) or adjacent(tile3, tile5, tile7) or adjacent(tile3, tile6, tile9)) {
                            winningPlayer = currentPlayer
                            currentPlayer = blankPlayer
                            gameEnd = !gameEnd
                        }
                        if(markCount(tilelist) == 9) {
                            gameEnd = !gameEnd
                        }
                        swapTurn()
                    } else {
                        showContent = !showContent
                    }
                }, modifier = Modifier.padding(1.dp))
                {
                    tile3.markString()?.let { Text(it) }

                }
            }
            Column() {
                Row() {
                    val button4 = Button(onClick = {
                        if (tile4.currentMark == null) {
                            currentPlayer.mark(tile4); showContent = !showContent;
                            if(adjacent(tile4, tile5, tile6) or adjacent(tile1, tile4, tile7)) {
                                winningPlayer = currentPlayer
                                currentPlayer = blankPlayer
                                gameEnd = !gameEnd
                            }
                            if(markCount(tilelist) == 9) {
                                gameEnd = !gameEnd
                            }
                            swapTurn()
                        } else {
                            showContent = !showContent
                        }
                    }, modifier = Modifier.padding(1.dp))
                    {
                        tile4.markString()?.let { Text(it) }

                    }
                    val button5 = Button(onClick = {
                        if (tile5.currentMark == null) {
                            currentPlayer.mark(tile5); showContent = !showContent;
                            if(adjacent(tile4, tile5, tile6) or adjacent(tile2, tile5, tile8) or adjacent(tile1, tile5, tile9) or adjacent(tile3, tile5, tile7)) {
                                winningPlayer = currentPlayer
                                currentPlayer = blankPlayer
                                gameEnd = !gameEnd
                            }
                            if(markCount(tilelist) == 9) {
                                gameEnd = !gameEnd
                            }
                            swapTurn()
                        } else {
                            showContent = !showContent
                        }
                    }, modifier = Modifier.padding(1.dp))
                    {
                        tile5.markString()?.let { Text(it) }

                    }
                    val button6 = Button(onClick = {
                        if (tile6.currentMark == null) {
                            currentPlayer.mark(tile6); showContent = !showContent;
                            if(adjacent(tile4, tile5, tile6) or adjacent(tile3, tile6, tile9)) {
                                winningPlayer = currentPlayer
                                currentPlayer = blankPlayer
                                gameEnd = !gameEnd
                            }
                            if(markCount(tilelist) == 9) {
                                gameEnd = !gameEnd
                            }
                            swapTurn()
                        } else {
                            showContent = !showContent
                        }
                    }, modifier = Modifier.padding(1.dp))
                    {
                        tile6.markString()?.let { Text(it) }

                    }
                }
                Column() {
                    Row() {
                        val button7 = Button(onClick = {
                            if (tile7.currentMark == null) {
                                currentPlayer.mark(tile7); showContent = !showContent;
                                if (adjacent(tile7, tile8, tile9) or adjacent(tile1, tile4, tile7) or adjacent(
                                        tile3,
                                        tile5,
                                        tile7
                                    )
                                ) {
                                    winningPlayer = currentPlayer
                                    currentPlayer = blankPlayer
                                    gameEnd = !gameEnd
                                }
                                if (markCount(tilelist) == 9) {
                                    gameEnd = !gameEnd
                                }
                                swapTurn()
                            } else {
                                showContent = !showContent
                            }
                        }, modifier = Modifier.padding(1.dp))
                        {
                            tile7.markString()?.let { Text(it) }

                        }
                        val button8 = Button(onClick = {
                            if (tile8.currentMark == null) {
                                currentPlayer.mark(tile8); showContent = !showContent;
                                if (adjacent(tile7, tile8, tile9) or adjacent(tile2, tile5, tile8)) {
                                    winningPlayer = currentPlayer
                                    currentPlayer = blankPlayer
                                    gameEnd = !gameEnd
                                }
                                if (markCount(tilelist) == 9) {
                                    gameEnd = !gameEnd
                                }
                                swapTurn()
                            } else {
                                showContent = !showContent
                            }
                        }, modifier = Modifier.padding(1.dp))
                        {
                            tile8.markString()?.let { Text(it) }
                        }
                        val button9 = Button(onClick = {
                            if (tile9.currentMark == null) {
                                currentPlayer.mark(tile9); showContent = !showContent;
                                if (adjacent(tile7, tile8, tile9) or adjacent(tile3, tile6, tile9) or adjacent(
                                        tile1,
                                        tile5,
                                        tile9
                                    )
                                ) {
                                    winningPlayer = currentPlayer
                                    currentPlayer = blankPlayer
                                    gameEnd = !gameEnd
                                }
                                if (markCount(tilelist) == 9) {
                                    gameEnd = !gameEnd
                                }
                                swapTurn()
                            } else {
                                showContent = !showContent
                            }
                        }, modifier = Modifier.padding(1.dp))
                        {
                            tile9.markString()?.let { Text(it) }

                        }
                        AnimatedVisibility(gameEnd) {
                            // When the game ends, a reset button appears that returns the program to its
                            // default state.
                            Row(){
                                val resetbutton = Button(onClick = {
                                    currentPlayer = player1
                                    for (tile in tilelist) {
                                        tile.currentMark = null
                                    }
                                    gameEnd = !gameEnd
                                }, modifier = Modifier.padding(1.dp))
                                {
                                    Text("Reset Game")

                                }
                            }
                        }
                    }
                    // showContent does nothing, however the UI only updates when using AnimatedVisibility,
                    // So it is present on all buttons
                    AnimatedVisibility(showContent) {
                        }

                    }
                }
            }
        }
    }

