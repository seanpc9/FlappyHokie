------------------------------------------------------------------------
This is the project README file. Here, you should describe your project.
Tell the reader (someone who does not know anything about this project)
all he/she needs to know. The comments should usually include at least:
------------------------------------------------------------------------

PROJECT TITLE: Flappy Bird 2.0
PURPOSE OF PROJECT: Final Program for CS 1114
VERSION or DATE: 2014.04.30
HOW TO START THIS PROJECT: Must use inheritance, polymorphism, a
container, and a nested for loop.
AUTHOR: Sean Crenshaw
USER INSTRUCTIONS: First, choose your difficulty. Then, the game will
start and you will have to tap the screen to keep the bird up in the
air. The game speed changes based on the difficulty that you use.

HOW I MET THE REQUIREMENTS:
    Inheritance - There is a general FlappyHokie class that all of the
        birds derive from.
    Polymorphism - Each FlappyHokie subclass overrides the wrapAround()
        method to increase the speed at which the FlappyHokie moves.
    Container - There will be a container of pipes that contains all
        of the pipes in the FlappyWorld. This container will be cycled
        through to remove all of the pipes in the world.
    Nested loop - A nested loop is used to create three sets of top
        pipes and bottom pipes.
    Game ends - The game ends when you hit one of the pipes or one of
        the edges of the world.
