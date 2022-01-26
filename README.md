# BlackJack
Este programa consiste en la última fase de la partida de Black Jack, en la cual crupier deberá coger cartas del montón hasta que su mano tenga 17 puntos o más siempre sacando la primera carta del montón. En nuestras partidas, habrán 3 jugadores que juegan de forma individual contra el crupier. Las cartas Jack, Queen y King tiene valor 10, y el As podrá tener valor 1 u 11. Por otra parte, unas reglas importantes son que si un jugador excede de 21 puntos o más pierde. Asimismo, si un crupier tiene Black Jack ganará a otros jugadores, inclusive si tienen Black Jack. Tener Black Jack es cuando se tiene 2 cartas, una con valor 10 y la otra es un As. Cabe destacar, que si el crupier y el jugador tienen la misma suma de la mano, en ese caso ganará el crupier. Concretamente, tenemos una función a la que le pasamos los jugadores, el crupier y las cartas del montón, esta función devuelve un array con los jugadores que ganan. Hay que tener en cuenta que si no aparece ningún jugador en la lista, es decir la lista vacía, significa que el crupier ha ganado a los 3 jugadores individualmente. Estos casos clarifican el funcionamiento del programa:
### Caso 1
Player 1: "J", "A" (21, Black Jack)

Player 2: "10", "5", "6" (21)

Player 3: "3", "6", "A", "3", "A", "K" (24) 

Croupier: "9", "7" (16)

Deck: "5", "4", "K", "2" 

getWinners(...) -----> [Player1] 

### Caso 2
Player 1: "10", "K" (20) 

Player 2: "10", "2", "6" (18) 

Player 3: "8", "8", "5" (21) 

Croupier: "5", "10" (15) 

Deck: "A" , "3" , "K" , "2" 

getWinners(...) -----> [Player1, Player3]


Se cuenta con una serie de tests de prueba Junit realizados a todas las clases de este proyecto. Concretamente, el estilo arquitectónico es TDD.

Se adjunta el diagrama de clases se ha realizado con el programa StarUML versión 4.1.6.
