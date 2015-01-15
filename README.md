# Chess
![Chess Icon](http://www.pm-magazin.de/sites/www.pm-magazin.de/files/imagecache/lightbox/images/Wieso%2520ist%2520Schach%2520ein%2520Sport.JPG)

### 1. Motivation for this game
Create a game for Software Engeneering to improved programming skills and to learn some new tools to improve code style.

### 2. Rules of this game
You game is a player vs player game which means you need two people to play this game (or you like to play against yourself). The aim of this game is to beat the king of your opponent. As first the player with the white figures will start to make his move, then his opponent with the black figures will make his move and so on.

* Special Rules
  1.  If a pawn reaches the other side of the field you can exchange this pawn with a Queen, a Rook, a Knight or a Bishop.
  2.  With special conditions you can move your rook and your king at the same time.This move is called "castling". The conditions are:
      * King hasn`t moved.
      * Rook hasn`t moved.
      * King doesn`t stand in chess.
      * The position where the king will move to will not make him stand in chess.
      * The fields where the king will be moved about are not in chess.
      * The fields between king and rook are free.

### 3. Conditions to win the game
1. Opponents king is checkmate.
2. Standoff which can happen with the following conditions:
  * Both players only got their king left.
  * One players got a king and a bishop/knight left and the other player only got a king left.
  * Both player got a king and a bishop left with both bishops on a field with the same color.

### 4. Several Informations
For this game we used MVC-Architecture. To improve our code style we used Sonar, Maven and Jenkins. We also wrote a lot of tests to secure the functionality of our code, implemented design patterns, used OO-Principles. We are a team of 2 students so we used git and scrum to work together. We used scrum to coordinate our tasks and we used git for version control so every one could get the code all the time.

One more thing is that we implemented a Tui(Text user interface) and a Gui(Graphical user interface). Both can be used to play the game at the same time. The Tui is used as a logger to know what happened when you do something.

### 4. How to play the game
After you import the program to your locale git you can start the game by running Startgame.java. The gui and tui will start.
The Gui will look like this:
![Gui Icon](/chess/src/images/GuiBild.png)

The Tui(You will see it in the console of your editor) will look like this:
![Tui Icon](/chess/src/images/TuiBild.png)

As you can see we show you which figures can be moved.

After choosing a figure to move you can choose another figure if you want or choose the field you want to move to.
In our gui the field where you can move to are buttons and they will be enabled. It will look like this:
![GuiMove Icon](/chess/src/images/GuiBildBewegen.png)

In our tui the fields are printed out so you can see which fields you can move to. It will look like this:
![TuiMove Icon](/chess/src/images/TuiBildBewegen.png)

This steps will go one for each player until one of them win the game.

### 5. How it works
Let`s go one with our code handling to implement the game.

##### Model-Layer
In the model-layer we have implemented every figure, the field, the player, a class which get`s all possible fields for each figure and a class with some constants we need. Our field is a List with 8 Lists inside it so save the coordinates of each fields and the figure that stands on it.

##### View-Layer
In this layer we have placed our gui and tui. For playing the game you mainly use our gui but you can also play with the tui or play each single step with gui and tui. All of it will work.

##### Control-Layer
This layer is a really important part of the game. It handles the fields where a figure can move to, check if the game is at the end, checks the special rules and handles the game.

To find out where a figure can move to we check if a field of their possible fields colidates with a figure of the current player or with figures of his opponent. It removes the field and all fields that will follow the line or at the case of a opponent figure it will remove all fields following the line behind the figure.
