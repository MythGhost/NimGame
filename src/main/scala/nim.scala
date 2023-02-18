
import scala.collection.mutable.ListBuffer
import scala.io.StdIn.readLine
import scala.util.control.Breaks.break
object nim {

    var state = ListBuffer(5, 4, 3, 2 , 1);

    private def drawBoard() = {
      for i <- state
          j <- 1 to i
        do
          if j == i then
            println("*")
          else
            print("*")
    }


    private def loop(): Unit = {
      val gameEnd = true
      while gameEnd
        do
        println("Player 1 enter a row: ")
        val rowStr = readLine();
        var row = Integer.parseInt(rowStr);
        //check if rowindex is out of Bounds
        row = checkRow(row)
        //remove a star from the list that represents the state of the playboard
        takeStar(row)
        //show the Gameboard on the console
        drawBoard()
        //check if all the stars are taken away
        if checkGameEnd() then
          println("Player 1 won!!!!!")
          break()

        println("Player 2 enter a row: ")
        val rowStr2 = readLine();
        var row2 = Integer.parseInt(rowStr2);
        row2 = checkRow(row2)
        takeStar(row2);
        drawBoard()
        if checkGameEnd() then
          println("Player 2 won!!!!!")
          break()
    }
    private def checkRow (row: Int) = {
      var newRow = row
      if row < 0 then
        newRow = 4
      if row > 4 then
        newRow = 0

      newRow
    }

    private def takeStar (row: Int) = {
       println(s"row: $row")

       val newValue = state.lift(row);
       state.remove(row)
       if newValue.get != 0 then
        state.insert(row, newValue.get - 1)
       else
         state.insert(row, 0)
       println(s"state: $state")
     }

    private def checkGameEnd(): Boolean = {
      var gameEnd = true
      for i <- state
        do
          if i != 0 then
            gameEnd = false
1
      gameEnd
    }

    @main def play() =
      println("The Nimgame")
      drawBoard()
      loop()

  }


