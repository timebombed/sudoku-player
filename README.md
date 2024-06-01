# Sudoku 305

# description
    This program offers a custom Sudoku experience on a classic 9x9 Sudoku board. Players must solve 
    the puzzle by entering digits 1 through 9 into their appropriate cells, ensuring that each digit
    only appears once per row, column, and 3x3 block. In other words, each row, column, and block will 
    contain exactly one occurence of digits 1 through 9.

    Players can select from three levels of difficulty: easy, medium, and hard. Upon choosing a difficulty
    level, a board is randomly selected from a large collection of Sudoku boards, and then the game begins.
    Successfully completing the puzzle will congratulate the player and prompt them to play another round.

# prerequisites 
    This program uses junit for testing purposes. Ensure you have the following dependencies in build.gradle 
    and build it by pressing the elephant in the right hand corner:

    dependencies {
        testImplementation platform('org.junit:junit-bom:5.10.0')
        testImplementation 'org.junit.jupiter:junit-jupiter'
    }

# installation
    Required Software. 
    To run this project, you should have the following software installed:

    1. IntelliJ IDE (preferred)
        Download and install from:
        https://www.jetbrains.com/idea/download/?section=mac
        Website will automatically recognize your OS type
        Follow instructions in wizard. When prompted, select Java and gradle

    2. Gradle
        Once IntelliJ is installed, click Plugins from the left hand menu and install Gradle version 6.0
            if not already installed

    3. Java Development Kit
        IntelliJ handles this, so no installation necessary

    Instructions:
    1. clone the repository:
        git clone https://github.com/usd-cs/comp305-final-project-sp24-s01s02-hreinsonmikey.git
    2. change to project directory:
        cd comp305-final-project-sp24-s01s02-hreinsonmikey
    3. run the program:
        ./gradlew run
    4. run the tests: 
        ./gradlew test

    Example in terminal:
        git clone https://github.com/usd-cs/comp305-final-project-sp24-s01s02-hreinsonmikey.git
        cd comp305-final-project-sp24-s01s02-hreinsonmikey
        ./gradlew run
        ./gradlew test

# contact
    For any questions or inquiries, please contact:
        Gianpaolo Tabora
        Hreinson Vanover
        Mikey Schneider