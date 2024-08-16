/*********************************************************************************************************
This is to certify that this project is my own work, based on my personal efforts in studying and applying the concepts
learned. I have constructed the functions and their respective algorithms and corresponding code by myself. The
program was run, tested, and debugged by my own efforts. I further certify that I have not copied in part or whole or
otherwise plagiarized the work of other students and/or persons.

                                                                CRISOSTOMO, JOSH NEAL F., DLSU ID# 12305707
*********************************************************************************************************/
#include <conio.h>
#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define ADMIN_PASS "ccprog2_mp"  // Defined the password for the admin
#define PASS_LENGTH 21           // Defined Admin Password length

/* Struct with a variable name "Records" contains the ff:
    1. ID - id number of the record
    2. levels[7] - type of difficulty of the phrase [easy, medium, hard]
    3. countChar - phrases' number of characters [includes the space character]
    4. phrase[101] - phrase to be copied by the user [has amaximum of 100 characters only]
*/
typedef struct {
    int id;
    char levels[7];
    int countChar;
    char phrase[101];
} Records;

/* Struct with a variable name "Player" contains the ff:
    1. Player Name [21] - name of the current user/player [20 characters only]
    2. Score - score of the player.
*/
typedef struct {
    char playerName[21];
    int score;
} Player;

/* displayRecordCount displays the number of records currently in the table or records.

@param int *recordCount - pointer to the address of the recordCount value.

@return none.

Pre-condition: *recordCount is initialized with an integer 0.
*/
void displayRecordCount(int *recordCount) {
    printf("\n\t\t--------------------------------------------------------------\n\n");
    printf("RECORD COUNT: %d", *recordCount);  // Prints the current record count on top of the table of records.
}

/* displayHeader displays the name of the program/game through an ASCII art.

@param none

@return none

Pre-condition: none
*/
void displayHeader() {
    printf("\n\t\t--------------------------------------------------------------\n");
    printf("\n");
    printf("######## ##    ## ########  #### ##    ##  ######       ######      ###    ##     ## ######## \n");
    printf("   ##     ##  ##  ##     ##  ##  ###   ## ##    ##     ##    ##    ## ##   ###   ### ##       \n");
    printf("   ##      ####   ##     ##  ##  ####  ## ##           ##         ##   ##  #### #### ##       \n");
    printf("   ##       ##    ########   ##  ## ## ## ##   ####    ##   #### ##     ## ## ### ## ######   \n");
    printf("   ##       ##    ##         ##  ##  #### ##    ##     ##    ##  ######### ##     ## ##       \n");
    printf("   ##       ##    ##         ##  ##   ### ##    ##     ##    ##  ##     ## ##     ## ##       \n");
    printf("   ##       ##    ##        #### ##    ##  ######       ######   ##     ## ##     ## ######## \n");
    printf("\n");
}

/* displayMainMenu displays the options for the user in the main menu and accepts the user's choice
among the options.

@param int *menuChoice - pointer to the address of an integer in main.

@return none but updates the integer menuChoice value in main.

Pre-condition: int *menuChoice is initialized without a value in main and all inputs are just integers not other data types.
*/
void displayMainMenu(int *menuChoice) {
    // Displays the main menu options.
    printf("\t\t------------------------- MAIN MENU --------------------------\n\n");
    printf("\t\t\t[1]  Manage Data\n");
    printf("\t\t\t[2]  Play\n");
    printf("\t\t\t[3]  Exit\n\n");
    printf("\t\t--------------------------------------------------------------\n\n");
    printf("\t\t\tEnter choice: ");
    scanf("%d", menuChoice);  // Accepts the user input and stores it in the pointer menuChoice.
    printf("\n\t\t--------------------------------------------------------------\n\n");
}

/* displayPlayMenu displays the options for the user in the play menu and accepts the user's choice
among the options.

@param int *playChoice - pointer to the address of an integer in main.

@return none but updates the integer playChoice value in main.

Pre-condition: int *playhoice is initialized without a value in main and all inputs are just integers not other data types.
*/
void displayPlayMenu(int *playChoice) {
    // Displays the play menu options.
    printf("\t\t-------------------------- PLAY MENU -------------------------\n\n");
    printf("\t\t\t[1]  Play Game\n");
    printf("\t\t\t[2]  View Scores\n");
    printf("\t\t\t[3]  Return to Main Menu\n\n");
    printf("\t\t--------------------------------------------------------------\n\n");
    printf("\t\t\tEnter choice: ");
    scanf("%d", playChoice);  // Accepts the user input and stores it in the pointer playChoice.
    printf("\n\t\t--------------------------------------------------------------\n\n");
}

/* sortScores sorts the scores from highest to lowest.

@param Player playerRecords[] - a array of data with user-defined structure data type consisting of the player's name [playerName] and
the player's score [score].

@param int *playerCount - pointer to the address of an integer, which refers to the number of players that played the game.

@return none

Pre-condition: int *playerCount and playerRecords have values.
*/
void sortScores(Player playerRecords[], int playerCount) {
	Player temp;
	int i, j;
	
	// Selection sort
	for(i = 0; i < playerCount - 1; i++) {
		for(j = 0; j < playerCount - i - 1; j++) {
			if (playerRecords[j + 1].score > playerRecords[j].score) {
				temp = playerRecords[j];
				playerRecords[j] = playerRecords[j + 1];
				playerRecords[j + 1] = temp;
			}
		}
	}	
}

/* readScores scans the score.txt file to gather data.

@param Player playerRecords[] - a array of data with user-defined structure data type consisting of the player's name [playerName] and
the player's score [score].

@param int *playerCount - pointer to the address of an integer, which refers to the number of players that played the game.

@return none 

Pre-condition: int *playerCount is initialized with 0 and Player playerRecords[] is initialized with no stored values.
*/
void readScores(Player playerRecords[], int *playerCount) {
	FILE *fp;
	*playerCount = 0; // Initialized with 0 to prevent duplication.
	
	fp = fopen("score.txt", "r"); // Opens the score.txt file in read mode.
	
    if (fp == NULL) {  // Checks if the file exists.
        printf("\t\t\t\t! ! ! NO HIGH SCORES FOUND ! ! !\n");
    } else {
        // Scans the file until it reaches the end of the file (EOF).
        while (fscanf(fp, "%s %d", playerRecords[*playerCount].playerName, &playerRecords[*playerCount].score) != EOF) {
            (*playerCount)++;  // Increments every time there's a player scanned to get the total number of players.
        }
        
        fclose(fp); // Closes the score.txt file after scanning.
    }
}

/* displayScores displays High Scores of the players.

@param Player playerRecords[] - a array of data with user-defined structure data type consisting of the player's name [playerName] and
the player's score [score].

@param int *playerCount - pointer to the address of an integer, which refers to the number of players that played the game.

@return none but prints a table with the list of players and their corresponding high scores.

Pre-condition: int *playerCount is initialized with 0 and Player playerRecords[] is initialized with no stored values.
*/
void displayScores(Player playerRecords[], int *playerCount) {
    int i;  // Initialized with 1 for the "NO." in the table.

	readScores(playerRecords, playerCount);

	sortScores(playerRecords, *playerCount);

    printf("\n\t\t------------------------- HIGH SCORES -------------------------\n");

    if (playerCount == 0) {  // Checks if there are players.
        printf("\t\t\t\t! ! ! NO HIGH SCORES FOUND ! ! !\n");
    } else {
        printf("\n\t\t+------+----------------------+--------+\n");
        printf("\t\t| %-4s | %-20s | %-6s |\n", "RANK", "PLAYER NAME", "SCORES");
        printf("\t\t+------+----------------------+--------+\n");

        // Scans the file until it reaches the end of the file (EOF).
        for(i = 0; i < *playerCount; i++) {
            printf("\t\t| %-4d | %-20s | %-6d |\n", i + 1, playerRecords[i].playerName, playerRecords[i].score);
            printf("\t\t+------+----------------------+--------+\n");
        }
    }

    printf("\n");  // Newline for format purposes.
}


/* checkName checks if the name of the current user that is playing is listed in the score.txt file or in the record of players already by comparing
each names in the struct array to the passed string.

@param Player playerRecords[] - a array of data with user-defined structure data type consisting of the player's name [playerName] and
the player's score [score].

@param int playerCount - a non-zero and nonnegative integer value, which refers to the number of players that played the game.

@param char *playerName - a string which contains the current user's inputted name during the run.

@returns the index of the player name in the struct array, if it matches with the passed string. Otherwise, the function returns -1 when the name is
not the same with the names in the struct array.

Pre-condition: int *playerCount already has a value, Player playerRecords[] already have values, and *playerName contains a string.
*/
int checkName(Player playerRecords[], int playerCount, char *playerName) {
    int i;

    for (i = 0; i < playerCount; i++)  // Checks each player record in the file.
    {
        // Compares the current list of names stored in the playerRecords struct array to the current players name.
        if (strcmp(playerRecords[i].playerName, playerName) == 0)  // If strcmp returns 0, then it already exists.
        {
            return i;  // returns the index of the player record in the file with the current player's name.
        }
    }

    return -1;  // returns -1, if it is a new player.
}

/* updateScore function updates the scores in the score.txt file by manipulating the values in the structure array playerRecords[] and writing it back
into the score.txt file.

@param Player playerRecords[] - a array of data with user-defined structure data type consisting of the player's name [playerName] and
the player's score [score].

@param int *playerCount - pointer to the address of an integer, which refers to the number of players that played the game.

@param char *playerName - a string which contains the current user's inputted name during the run.

@param int currentScore - an integer value obtained after executing the playGame function.

@returns none but updates the values in the score.txt file, either by changing an already exisiting high score or by adding a new high score.

Pre-condition: *playerName contains a string and currentScore is a nonzero and nonnegative integer.
*/
void updateScore(Player playerRecords[], int *playerCount, char *playerName, int currentScore) {
    int i, j, indexCheck;
    FILE *fp;
    bool isDuplicate;

    indexCheck = checkName(playerRecords, *playerCount, playerName);  // Stores the return value of checkName to indexCheck.

    if (indexCheck != -1) {                                    // Checks if the name is already listed in the score.txt file.
        if (currentScore > playerRecords[indexCheck].score) {  // Checks if the current score is greater than the existing score of the same name.
            printf("\n\t\tNEW HIGH SCORE! Updating score...\n");
            playerRecords[indexCheck].score = currentScore;  // If the current score is greater, then it will replace the listed score of the player.
        }
    } else {                                                         // If the player is new and not yet listed in the score.txt file.
        strcpy(playerRecords[*playerCount].playerName, playerName);  // The player's name will be added following the last player in the score.txt file.
        playerRecords[*playerCount].score = currentScore;            // The player's score will be stored, as well.
        (*playerCount)++;                                            // The number of players will increment since there was an addition.
    }

    fp = fopen("score.txt", "w");  // Opens the score.txt file in write mode.

    // Loops through the stored list of players.
    for (i = 0; i < *playerCount; i++) {
        isDuplicate = false;  // Initalized with false.

        //  Compare the current player's name with the names of previously processed players.
        for (j = 0; j < i; j++) {
            // Checks for dumplication by comparing names.
            if (strcmp(playerRecords[i].playerName, playerRecords[j].playerName) == 0) {
                isDuplicate = true;  // If there's a duplicate, isDuplicate will become true.
                j = i;               // Terminates the loop
            }
        }

        if (!isDuplicate) {  // If there's no duplicate, then the function will continue to print in the score.txt file.
            fprintf(fp, "%s\n%d\n\n", playerRecords[i].playerName, playerRecords[i].score);
        }
    }

    fclose(fp);  // Closes the score.txt file.
}

/* verifyAdmin asks for a password to enter manage data and checks the input if it matches with the admin password. It also masks the input
by asterisks while typing through the use of the header file conio.h.

@param none

@returns 1 if the password is correct. Otherwise, returns 0.

Pre-condition: The input does not have any space.
*/
int verifyAdmin() {
    char inputPass[PASS_LENGTH];
    int i = 0, checker = 0;
    char character;

    // Asks for the input.
    printf("\t\t------------------------- ADMIN MENU -------------------------\n\n");
    printf("\t\t\tEnter password to manage data\n");
    printf("\t\t\tPASSWORD: ");

    // Loop to read characters until Enter key is pressed or the maximum length of 20 characters is reached.
    while (!checker && i < PASS_LENGTH) {
        character = getch();  // Reads a character without it being displayed, which means it will not show the character.

        if (character == '\r' || character == '\n')  // Checks when the user hit the enter key.
        {
            checker = 1;                        // checker becomes 1, which will terminate the while loop.
        } else if (character == '\b' && i > 0)  // Check when the user hit the backspace hey and if the number of characters is > 0.
        {
            printf("\b \b");  // Erase previous character from the console
            i--;              // Decrements the number of characters per backspace.
        } else {
            inputPass[i++] = character;  // Per character will be stored in the InputPass string.
            printf("*");                 // Displays the asterisk.
        }
    }

    inputPass[i] = '\0';  // Null-terminate the string.

    printf("\n\n\t\t--------------------------------------------------------------\n\n");

    // Compares entered password with the set admin password
    if (strcmp(inputPass, ADMIN_PASS) == 0) {
        return 1;  // Password matches
    } else {
        return 0;  // Password does not match.
    }
}

/* manageData displays the options for the user in the manage data menu and accepts the user's choice
among the options.

@param int *manageChoice - pointer to the address of an integer in main.

@return none but updates the integer manageChoice value in main.

Pre-condition: int *manageChoice is initialized without a value in main and all inputs are just integers not other data types.
*/
void manageData(int *manageChoice) {
    // Displays the manage data options.
    printf("\t\t------------------------ MANAGE DATA -------------------------\n\n");
    printf("\t\t\t[1]  Add Record\n");
    printf("\t\t\t[2]  Edit Record\n");
    printf("\t\t\t[3]  Delete Record\n");
    printf("\t\t\t[4]  Import Data\n");
    printf("\t\t\t[5]  Export Data\n");
    printf("\t\t\t[0]  Return to Main Menu\n\n");
    printf("\t\t--------------------------------------------------------------\n\n");
    printf("\t\t\tEnter choice: ");
    scanf("%d", manageChoice);  // Accepts the user input and stores it in the pointer manageChoice.
    printf("\n\t\t--------------------------------------------------------------\n\n");
}

/* displayRecords displays the current list of records in a tabulation format.

@param Records records[] - a array of data with user-defined structure data type consisting of integers [ID and countChar] and
strings [levels and phrase].

@param int *recordCount - pointer to the address of an integer in main.

@return none but prints the table with the current list of records

Pre-condition: int *recordCount is initialized with 0 and Records records[] is initialized with no stored values.
*/
void displayRecords(Records records[], int *recordCount) {
    displayRecordCount(recordCount);  // Displays the first or current list of records.

    printf("\n+-----+---------+-----+------------------------------------------------------------------------------------------------------+\n");
    printf("| ID# |  LEVEL  |  #  |                                                   PHRASE                                             |\n");
    printf("+-----+---------+-----+------------------------------------------------------------------------------------------------------+\n");

    int i;

    for (i = 0; i < *recordCount; i++)  // Loops the printing of records until it reaches the number of recordCount, then it stops.
    {
        // Prints the records in the order: ID - level/difficulty - # of characters - phrase
        /*
            Each column is formatted with a specific width to maintain the shape of the table.
            All columns are formatted to be left-justified.
                ID - width of 6 or a minimum of 6 integers to be printed.
                Levels - width of 10 or a minimum of 10 characters to be printed.
                countChar - width of 10 or a minimum of 10 integers to be printed.
                phrase - width of 100 or a minimum of 100 characters to be printed.
        */
        printf("| %-4d| %-7s | %-3d | %-100s |\n", records[i].id, records[i].levels, records[i].countChar, records[i].phrase);
    }

    printf("+-----+---------+-----+------------------------------------------------------------------------------------------------------+\n\n");
}

/* checkPhrase checks if the phrase is already listed in the records.

@param Records records[] - an array of data with user-defined structure data type consisting of integers [ID and countChar] and
strings [levels and phrase].

@param int recordCount - number of current records. [not a pointer since it will not be modified]

@param char *newPhrase - pointer to the address of the first character in a string from the function addRecord().

@returns 1 if the phrase is already listed or 0 if the phrase is new or not already listed.

Pre-condition: int recordCount is not 0 and char *newPhrase is from the user's input.
*/
int checkPhrase(Records records[], int recordCount, char *newPhrase) {
    int i;

    for (i = 0; i < recordCount; i++)  // Checks each phrase in the list of records.
    {
        // Compares each phrase in the records to the newPhrase or the phrase that the user added.
        if (strcmp(records[i].phrase, newPhrase) == 0)  // If strcmp returns 0, then it already exists.
        {
            // It will dsplay the information connected to the phrase, proving it was already listed.
            printf("\n\t\t--------------------------------------------------------------\n\n");
            printf("\t\t\t\t   >> RECORD ALREADY LISTED <<\n\n");
            printf("\t\tID: %d\n", records[i].id);
            printf("\t\tDifficulty: %s\n", records[i].levels);
            printf("\t\tCharacters: %d\n", records[i].countChar);
            printf("\t\tPhrase: %s\n", records[i].phrase);

            return 1;  // returns 1, means the added phrase already exists.
        }
    }

    return 0;  // returns 0, means the added phrase is new to the list of records.
}

/* addRecord adds a new phrase to the list of records with its corresponding ID, level of difficulty, and number of characters.

@param Records records[] - an array of data with user-defined structure data type consisting of integers [ID and countChar] and
strings [levels and phrase].

@param int *recordCount - pointer to the address of an integer in main.

@returns 0 if the user chose to be done with adding new phrase or 1 if the user prefer to continue adding more phrases.

Pre-condition: int *recordCount is only 0 when there are no records listed at first, but it will update corresponding to the
number of current listed records.

Pre-condition: If the user is asked for an integer then the input is also an integer not other data types. The same applies to when
the user is asked for a character.
*/
int addRecord(Records records[], int *recordCount) {
    Records newRecord;
    bool phraseExists = false;
    char addRecordChoice;
    int addAnother;

    displayRecords(records, recordCount);

    newRecord.id = *recordCount + 1;  // The IDs of the newly added record will always be one greater than the record before.

    printf("\t\t[0 - Return to Manage Data]\n");
    printf("\t\tENTER NEW PHRASE: ");
    scanf(" %[^\n]", newRecord.phrase);  // Asks for the new phrase

    // Checks if the phrase already exists or not and returns 1 or 0 [which is equivalent to true or false].
    phraseExists = checkPhrase(records, *recordCount, newRecord.phrase);

    // Checks if the input is 0. If it is, then it will go back to the manage data menu.
    if (strcmp(newRecord.phrase, "0") == 0) {
        addAnother = 0;
    }
    // The value of phraseExists is negated, which means true will be false, and vice versa
    else if (!phraseExists) {
        int length = strlen(newRecord.phrase);  // Gets the number of characters of the new phrase

        // The series of conditional statements determines the level of difficulty of the phrase
        if (length > 0 && length <= 20)  // If the length is between 1 and 20, it is easy
        {
            strcpy(newRecord.levels, "easy");
        } else if (length > 20 && length <= 50)  // If the length is between 21 and 50, it is medium
        {
            strcpy(newRecord.levels, "medium");
        } else  // If the length is more than 50, it is hard
        {
            strcpy(newRecord.levels, "hard");
        }

        newRecord.countChar = length;  // Assigns the length of the new phrase to be its number of characters in the list of records

        records[*recordCount] = newRecord;  // Assigns the value of newRecord to an element in the records array at the index [*recordCount]
        (*recordCount)++;                   // Increment the number of records listed by 1

        printf("\n\t\t\t       >> SUCCESSFULLY ADDED A RECORD! <<\n");
        displayRecords(records, recordCount);

        // Asks for the confirmation whether the user wants to continue adding records or not
        do {
            printf("\n\t\t--------------------------------------------------------------\n\n");
            printf("\t\t\t      Do you want to add another record?\n");
            printf("\t\t\t\t  [Y] - Yes   | |   [N] - No\n");
            printf("\n\t\t--------------------------------------------------------------\n\n");
            printf("\t\t\tEnter Choice: ");
            scanf(" %c", &addRecordChoice);

            if (addRecordChoice == 'Y' || addRecordChoice == 'y') {
                addAnother = 1;
            } else if (addRecordChoice == 'N' || addRecordChoice == 'n') {
                addAnother = 0;
            } else {
                printf("\n\t\t\t   Invalid Choice. Please choose Y or N.\n");
            }
        } while (addRecordChoice != 'Y' && addRecordChoice != 'y' && addRecordChoice != 'N' && addRecordChoice != 'n');
        // Continues to loop when the input is not the letters y or n. [not case-sensitive]
    }

    printf("\n");

    return addAnother;
}

/* editRecord edits an existing phrase in the current list of records.

@param Records records[] - an array of data with user-defined structure data type consisting of integers [ID and countChar] and
strings [levels and phrase].

@param int *recordCount - pointer to the address of an integer in main.

@returns 0 if the user chooses to be done with editing phrases or 1 if the user prefers to continue to edit more phrases.

Pre-condition: int *recordCount is only 0 when there are no records listed at first, but it will update corresponding to the
number of current listed records.

Pre-condition: If the user is asked for an integer then the input is also an integer not other data types. The same applies to when
the user is asked for a character.
*/
int editRecord(Records records[], int *recordCount) {
    // Declare and initialize local variables for this function.
    int editId, i, editAgain;
    char updatedPhrase[101], editAgainChoice;

	// Displays the current list of records to determine the ID number of a phrase that the user wants to edit.
   	displayRecords(records, recordCount);

	if (*recordCount == 0) { // If there are no records, the program will bring the user back to the manage data menu.
    	printf("\n\t\t--------------------------------------------------------------\n");
		printf("\n\t\t\t\t! ! ! NO RECORDS FOUND ! ! !\n");
		editAgain = 0;
	}
	else {
	    printf("\t\t[0 - Return to Manage Data]\n");
	    printf("\t\tEnter the Record ID you want to edit: ");
	    scanf("%d", &editId);  // Asks and stores the value of the ID in editId
	
	    // Checks if the input is 0. If it is, then it will go back to the manage data menu.
	    if (editId == 0) {
	        editAgain = 0;
	    } else if (editId > *recordCount || editId < 0)  // Checks if the input ID is within the record count.
	    {
	        printf("\n\t\t--------------------------------------------------------------\n");
	        printf("\n\t\t\t\t  ! ! ! ID DOES NOT EXIST ! ! !");
	    } else {
	        // Loops through the list of records to find the specified ID number
	        for (i = 0; i < *recordCount; i++) {
	            if (records[i].id == editId)  // Checks if the input matches with an ID in the current list
	            {
	                do {
	                    printf("\n\t\t--------------------------------------------------------------\n\n");
	                    printf("\t\t[0 - Return to Manage Data]\n");
	                    printf("\t\tNEWLY UPDATED PHRASE: ");
	                    scanf(" %[^\n]", updatedPhrase);  // Asks for the new phrase to replace the currently stored phrase
	                } while (checkPhrase(records, *recordCount, updatedPhrase) != 0);  // Continues to loop when the entered phrase already exists.

	                if (strcmp(updatedPhrase, "0") == 0) { // If the user wants to go back and entered the number 0, then the program goes back to manage data.
	                    editAgain = 0;
					}
					else {
						// Assigns the updated phrase to the currently stored phrase through strcpy
		                strcpy(records[i].phrase, updatedPhrase);
		
		                // Gets the number of characters of the updated phrase
		                int length = strlen(updatedPhrase);
		
		                // The series of conditional statements determines the level of difficulty of the phrase
		                if (length > 0 && length <= 20) {
		                    strcpy(records[i].levels, "easy");
		                } else if (length > 20 && length <= 50) {
		                    strcpy(records[i].levels, "medium");
		                } else {
		                    strcpy(records[i].levels, "hard");
		                }
		
		                records[i].countChar = length;  // Updates the phrase’s number of characters to display
		
		                printf("\n\t\t--------------------------------------------------------------\n");
		                printf("\n\t\t\t     >> SUCCESSFULLY EDITED A RECORD! <<\n");
		                displayRecords(records, recordCount);
		
		                // Asks for the confirmation whether the user wants to continue editing records or not
		                do {
		                    printf("\n\t\t--------------------------------------------------------------\n\n");
		                    printf("\t\t\t\t Do you want to edit again?\n");
		                    printf("\t\t\t\t [Y] - Yes   | |   [N] - No\n");
		                    printf("\n\t\t--------------------------------------------------------------\n\n");
		                    printf("\t\t\tEnter Choice: ");
		                    scanf(" %c", &editAgainChoice);
		
		                    if (editAgainChoice == 'Y' || editAgainChoice == 'y') {
		                        editAgain = 1;
		                    } else if (editAgainChoice == 'N' || editAgainChoice == 'n') {
		                        editAgain = 0;
		                    } else {
		                        printf("\n\t\t\t   Invalid Choice. Please choose Y or N.\n");
		                    }
		                } while (editAgainChoice != 'Y' && editAgainChoice != 'y' && editAgainChoice != 'N' && editAgainChoice != 'n');
		                // Continues to loop when the input is not the letters y or n. [not case-sensitive]
					}
	            }
	        }
	    }
	}

    printf("\n");

    return editAgain;
}

/* deleteRecord deletes an existing phrase in the list of records

@param Records records[] - an array of data with user-defined structure data type consisting of integers [ID and countChar] and
strings [levels and phrase].

@param int *recordCount - pointer to the address of an integer in main.

@returns 0 if the user chooses to be done with deleting phrases or 1 if the user prefers to continue deleting phrases.

Pre-condition: int *recordCount is only 0 when there are no records listed at first, but it will update corresponding to the
number of current listed records.

Pre-condition: If the user is asked for an integer then the input is also an integer not other data types. The same applies to when
the user is asked for a character.
*/
int deleteRecord(Records records[], int *recordCount) {
    // Declare and initialize local variables to be used in this function.
    int deleteId, i, deleteAnother;
    char deleteChoice, deleteAnotherChoice;

    // Displays the current list of records to determine the ID number of a phrase that the user wants to delete.
    displayRecords(records, recordCount);

	if (*recordCount == 0) { // If there are no records, the program will bring the user back to the manage data menu.
    	printf("\n\t\t--------------------------------------------------------------\n");
		printf("\n\t\t\t\t! ! ! NO RECORDS FOUND ! ! !\n");
		deleteAnother = 0;
	}
	else {
	    printf("\t\t[0 - Return to Manage Data]\n");
	    printf("\t\tEnter the Record ID you want to delete: ");
	    scanf("%d", &deleteId);  // Asks and stores the value of the ID in deletetId
	
	    // Checks if the input is 0. If it is, then it will go back to the manage data menu.
	    if (deleteId == 0) {
	        deleteAnother = 0;
	    } else if (deleteId > *recordCount || deleteId < 0)  // Checks if the input ID is within the record count.
	    {
	        printf("\n\t\t--------------------------------------------------------------\n");
	        printf("\n\t\t\t\t  ! ! ! ID DOES NOT EXIST ! ! !");
	    } else {
	        // Loops through the list of records to find the specified ID number
	        for (i = 0; i < *recordCount; i++) {
	            if (records[i].id == deleteId)  // Checks if the input matches with an ID in the current list
	            {
	                // Asks for the confirmation whether the user wants to delete the specified record
	                do {
	                    printf("\n\t\t--------------------------------------------------------------\n\n");
	                    printf("\t\t\tAre you sure you want to delete a record [ID: %d]?\n", records[i].id);
	                    printf("\t\t\t\t  [Y] - Yes  | |  [N] - No\n");
	                    printf("\n\t\t--------------------------------------------------------------\n\n");
	                    printf("\t\t\tEnter Choice: ");
	                    scanf(" %c", &deleteChoice);
	
	                    int j;
	
	                    if (deleteChoice == 'Y' || deleteChoice == 'y') {
	                        for (j = i; j < *recordCount - 1; j++) {
	                            // The records will move upward in the tabulation starting from the deleted record
	                            records[j] = records[j + 1];
	                            records[j].id--;  // The ID numbers starting from the deleted record will decrement by 1
	                        }
	                        (*recordCount)--;  // The number of records will decrement by 1
	
	                        printf("\n\t\t--------------------------------------------------------------\n");
	                        printf("\n\t\t\t     >> SUCCESSFULLY DELETED A RECORD <<\n");
	                        displayRecords(records, recordCount);
	
	                        // Asks for the confirmation whether the user wants to continue deleting records or not
	                        do {
	                            printf("\n\t\t--------------------------------------------------------------\n\n");
	                            printf("\t\t\t    Do you want to delete another record?\n");
	                            printf("\t\t\t\t  [Y] - Yes   | |   [N] - No\n");
	                            printf("\n\t\t--------------------------------------------------------------\n\n");
	                            printf("\t\t\tEnter Choice: ");
	                            scanf(" %c", &deleteAnotherChoice);
	
	                            if (deleteAnotherChoice == 'Y' || deleteAnotherChoice == 'y') {
	                                deleteAnother = 1;
	                            } else if (deleteAnotherChoice == 'N' || deleteAnotherChoice == 'n') {
	                                deleteAnother = 0;
	                            } else {
	                                printf("\n\t\t\tInvalid Choice. Please choose Y or N.\n");
	                            }
	                        } while (deleteAnotherChoice != 'Y' && deleteAnotherChoice != 'y' && deleteAnotherChoice != 'N' && deleteAnotherChoice != 'n');
	                        // Continues to loop when the input is not the letters y or n. [not case-sensitive]
	                    } else if (deleteChoice == 'N' || deleteChoice == 'n') {
	                        printf("\n\t\t--------------------------------------------------------------\n");
	                        printf("\n\t\t\t\t   >> RECORD NOT DELETED <<");
	                    } else {
	                        printf("\n\t\t\t   Invalid Choice. Please choose Y or N.\n");
	                    }
	                } while (deleteChoice != 'Y' && deleteChoice != 'y' && deleteChoice != 'N' && deleteChoice != 'n');
	                // Continues to loop when the input is not the letters y or n. [not case-sensitive]
	            }
	        }
	    }
	}

    printf("\n");

    return deleteAnother;
}

/* importData imports a text file with the appropriate data for the records to the program.

@param Records records[] - an array of data with user-defined structure data type consisting of integers [ID and countChar] and
strings [levels and phrase].

@param int *recordCount - pointer to the address of an integer in main.

@returns none

Pre-condition: int *recordCount is only 0 when there are no records listed at first, but it will update corresponding to the
number of current listed records.
*/
void importData(Records records[], int *recordCount) {
    // Declare and initialize local variables to be used in this function.
    char fileName[31];
    FILE *fp;
    int length;
    bool importLoop = true;
    bool found = false;

	displayRecords(records, recordCount); // Displays the table for reference.

    printf("\t\t------------------------ IMPORT DATA -------------------------\n\n");

    // Asks for the file name of the text file the user wants to import.
    do {
        printf("\t\t[0 - Return to Manage Data]\n");
        printf("\t\tEnter the filename to import data from: ");
        scanf("%30s", fileName);

        // Checks if the string stored in fileName is "0"
        if (strcmp(fileName, "0") == 0) {
            importLoop = false;  // The loop stops and will return to the manage data menu
        } else {
            length = strlen(fileName) - 4;  // Gets the length of the name of the file without the .txt

            fp = fopen(fileName, "r");  // Opens the file in read mode

            // Checks if the file pointer point to nothing or if the file name has the key phrase ".txt"
            if (fp == NULL || strcmp(fileName + length, ".txt") != 0) {
                printf("\n\t\t--------------------------------------------------------------\n");
                printf("\n\t\t\t\t! ! ! FILE NOT FOUND ! ! !\n");
                printf("\n\t\t--------------------------------------------------------------\n\n");
                importLoop = true;
            } else  // if it has .txt at the end and it exists then found will be true and the loop will stop
            {
                importLoop = false;
                found = true;
            }
        }
    } while (importLoop);

    // If the file was found
    if (found) {
        // Continues to scan the data inside the text file until it reaches the end of the file (EOF)
        while (fscanf(fp, "%d %s %d %[^\n]", &records[*recordCount].id, records[*recordCount].levels, &records[*recordCount].countChar, records[*recordCount].phrase) != EOF) {
            if (checkPhrase(records, *recordCount, records[*recordCount].phrase) == 0)  // If the phrase is new to the list, then it will import.
            {
                records[*recordCount].id = *recordCount + 1;  // The IDs of the newly added record will always be one greater than the record before.
                (*recordCount)++;                             // Increment the number of records listed.
            }
        }

        printf("\n\t\t--------------------------------------------------------------\n");
        printf("\n\t\t\t        >> DATA IMPORT SUCCESSFUL! <<\n");
        fclose(fp);
    }

    displayRecords(records, recordCount);
}

/* exportData exports the data in the current list of records to an external text file for it to be saved.

@param Records records[] - an array of data with user-defined structure data type consisting of integers [ID and countChar] and
strings [levels and phrase].

@param int *recordCount - pointer to the address of an integer in main.

@returns none

Pre-condition: int *recordCount is only 0 when there are no records listed at first, but it will update corresponding to the
number of current listed records.
*/
void exportData(Records records[], int *recordCount) {
    // Declare and initialize local variables to be used in this function.
    char fileName[31];
    FILE *fp2;
    int i, length;
    bool exportLoop = true;
    bool found = false;

	displayRecords(records, recordCount); // Displays the table for reference.

    printf("\t\t------------------------ EXPORT DATA -------------------------\n\n");

    // Asks for the file name of the text file the user wants to export to.
    do {
        printf("\t\t[0 - Return to Manage Data]\n");
        printf("\t\tEnter the filename to export data to [include \".txt\"]: ");
        scanf("%30s", fileName);

        // Checks if the string stored in fileName is "0"
        if (strcmp(fileName, "0") == 0) {
            exportLoop = false;  // The loop stops and will return to the manage data menu
        } else {
            length = strlen(fileName) - 4;  // Gets the length of the name of the file without the .txt

            fp2 = fopen(fileName, "w");  // Opens the file in read mode
            // Overwrites the previous data in the file if the file already exists

            // Checks if the file pointer point to nothing or if the file name has the key phrase ".txt"
            if (fp2 == NULL || strcmp(fileName + length, ".txt") != 0) {
                printf("\n\t\t--------------------------------------------------------------\n");
                printf("\n\t\t\t\t! ! ! FILE NOT FOUND ! ! !\n");
                printf("\n\t\t--------------------------------------------------------------\n\n");
                exportLoop = true;
            } else  // if it has .txt at the end and it exists then found will be true and the loop will stop
            {
                exportLoop = false;
                found = true;
            }
        }
    } while (exportLoop);

    // If the file was found or created
    if (found) {
        // Continues to print the data inside the text file until it reaches number of records
        for (i = 0; i < *recordCount; i++) {
            fprintf(fp2, "%d\n%s\n%d\n%s\n\n", records[i].id, records[i].levels, records[i].countChar, records[i].phrase);
        }
        printf("\n\t\t--------------------------------------------------------------\n");
        printf("\n\t\t\t       >> DATA EXPORT SUCCESSFUL! <<\n");
        fclose(fp2);
    }

    printf("\n\t\t--------------------------------------------------------------\n\n");
}

/* playGame function is where the main game happens.

@param Records records[] - an array of data with user-defined structure data type consisting of integers [ID and countChar] and
strings [levels and phrase].

@param int *recordCount - pointer to the address of the recordCount value.

@param Player playerRecords[] - a array of data with user-defined structure data type consisting of the player's name [playerName] and
the player's score [score].

@param int *playerCount - pointer to the address of an integer, which refers to the number of players that played the game.

@returns none

Pre-condition: Parameters may or may not have values stored in them. Player's name does not have any space.
*/
void playGame(Records records[], int recordCount, Player playerRecords[], int *playerCount) {
    int lifeCount = 3, currentScore = 0, countHard = 0;
    char tempName[21], playerName[21], input[101];
    int i, random;
    bool continuePlay = true;
    bool usedHardPhrase[recordCount];

    // Loops through the records
    for (i = 0; i < recordCount; i++) {
        if (records[i].countChar > 50) {
            countHard++;  // Increments if the phrase has more than 50 characters, so that the function will know how many hard phrases are stored.
            usedHardPhrase[i] = false; // Initializes all hard phrase with false since they are not yet used.
        }
    }

	// Prints the game rules
    printf("\t\t[RULES]\n\n");
    printf("\t\t   (1) Points per difficulty:\n");
    printf("\t\t		Easy   - 1\n");
    printf("\t\t		Medium - 2\n");
    printf("\t\t		Hard   - 3\n\n");
    printf("\t\t   (2) Input is not the same with the phrase = -1 life.\n");
    printf("\n\t\t--------------------------------------------------------------\n\n");

	printf("\t\t[0 - Return to Play Menu]\n");
    printf("\t\tPLAYER NAME [max. 20 characters]: ");
    scanf("%20s", tempName);  // Asks for the name of the player

    printf("\n\t\t--------------------------------------------------------------\n\n");

	if (strcmp(tempName, "0") == 0) { // If the user inputs "0" then the user goes back to the play menu.
		continuePlay = false;
	} else {
		strcpy(playerName, tempName);
		
	    // Loops three times for the first 3 easy phrases
	    for (i = 0; i < 3 && continuePlay; i++) {
	        random = rand() % recordCount;  // Randomizes among the recordCount
	
	        while (strlen(records[random].phrase) == 0 || strlen(records[random].phrase) > 20) {
	            random = rand() % recordCount;  // Retry randomization until an "easy" phrase is found.
	        }
	
	        Records currentRecord = records[random];  // If an easy phrase is found, then it will be stored into a local Record struct variable.
	
	        // Displays the name and stats of the player, which automatically updates.
	        printf("\t\t>> press \"0\" to quit <<\n\n");
	        printf("\t\t[PLAYER]: %s\n", playerName);
	        printf("\t\t[LIVES] : %d\n", lifeCount);
	        printf("\t\t[SCORE] : %d\n\n", currentScore);
	
	        printf("\t\tPHRASE (easy): %s\n\n", currentRecord.phrase);  // Displays the easy phrase for the user to copy.
	
	        printf("\t\tINPUT: ");
	        scanf(" %[^\n]", input); // Asks for the input, which will be compared to the given phrase.
	
	        if (strcmp(input, currentRecord.phrase) == 0) { // Checks if the input is exactly the same as the phrase.
	            printf("\n\t\t--------------------------------------------------------------\n\n");
	            printf("\t\tCORRECT!\n");
	            printf("\n\t\t--------------------------------------------------------------\n\n");
	            currentScore += 1; // Every time the user matches the phrase, one point will be added to the user's score.
	        } else {
	            lifeCount--; // Every time the fails to match the phrase, a life will be deducted to the user's lives.
	            printf("\n\t\t--------------------------------------------------------------\n\n");
	            printf("\t\tINCORRECT!\n");
	            printf("\t\t-1 LIFE\n");
	            printf("\n\t\t--------------------------------------------------------------\n\n");
	        }
	
			// The games stops when the user inputs "0" to quit in the input or if the user ran out of lives.
	        if (strcmp(input, "0") == 0 || lifeCount == 0) {
	            continuePlay = false;
	        }
	    }
	
		// Loops two times for the first 2 medium phrases
	    for (i = 0; i < 2 && continuePlay; i++) {
	        random = rand() % recordCount; // Randomizes among the recordCount
	
	        while (strlen(records[random].phrase) < 21 || strlen(records[random].phrase) > 50) {
	            random = rand() % recordCount;  // Retry randomization until a "medium" phrase is found
	        }
	
	        Records currentRecord = records[random]; // If a medium phrase is found, then it will be stored into a local Record struct variable.
	
	        printf("\t\t>> press \"0\" to quit <<\n\n");
	        printf("\t\t[PLAYER]: %s\n", playerName);
	        printf("\t\t[LIVES] : %d\n", lifeCount);
	        printf("\t\t[SCORE] : %d\n\n", currentScore);
	
	        printf("\t\tPHRASE (medium): %s\n\n", currentRecord.phrase); // Displays the medium phrase for the user to copy.
	
	        printf("\t\tINPUT: ");
	        scanf(" %[^\n]", input);
	
	        if (strcmp(input, currentRecord.phrase) == 0) {
	            printf("\n\t\t--------------------------------------------------------------\n\n");
	            printf("\t\tCORRECT!\n");
	            printf("\n\t\t--------------------------------------------------------------\n\n");
	            currentScore += 2; // Every time the user matches the phrase, two points will be added to the user's score.
	        } else {
	            lifeCount--;
	            printf("\n\t\t--------------------------------------------------------------\n\n");
	            printf("\t\tINCORRECT!\n");
	            printf("\t\t-1 LIFE\n");
	            printf("\n\t\t--------------------------------------------------------------\n\n");
	        }
	
			// The games stops when the user inputs "0" to quit in the input or if the user ran out of lives.
	        if (strcmp(input, "0") == 0 || lifeCount == 0) {
	            continuePlay = false;
	        }
	    }
	
	    for (i = 0; i < 1 && continuePlay; i++) {
	        random = rand() % recordCount;
	
	        while (strlen(records[random].phrase) < 50 || usedHardPhrase[random] == true) {
	            random = rand() % recordCount;  // Retry randomization until a "hard" phrase is found or if the phrase is already used.
	        }
	
	        Records currentRecord = records[random]; // If a medium phrase is found, then it will be stored into a local Record struct variable.
	        usedHardPhrase[random] = true; // Once a hard phrase is used, it will become true and can't be used anymore.
	
	        printf("\t\t>> press \"0\" to quit <<\n\n");
	        printf("\t\t[PLAYER]: %s\n", playerName);
	        printf("\t\t[LIVES] : %d\n", lifeCount);
	        printf("\t\t[SCORE] : %d\n\n", currentScore);
	
	        printf("\t\tPHRASE (hard): %s\n\n", currentRecord.phrase); // Displays the hard phrase for the user to copy.
	
	        printf("\t\tINPUT: ");
	        scanf(" %[^\n]", input);
	
	        if (strcmp(input, currentRecord.phrase) == 0) {
	            printf("\n\t\t--------------------------------------------------------------\n\n");
	            printf("\t\tCORRECT!\n");
	            printf("\n\t\t--------------------------------------------------------------\n\n");
	            currentScore += 3; // Every time the user matches the phrase, three points will be added to the user's score.
	            countHard--; // The number of hard phrases decreases by 1, since a phrase was already used.
	        } else {
	            lifeCount--;
	            printf("\n\t\t--------------------------------------------------------------\n\n");
	            printf("\t\tINCORRECT!\n");
	            printf("\t\t-1 LIFE\n");
	            printf("\n\t\t--------------------------------------------------------------\n\n");
	            countHard--; // The number of hard phrases decreases by 1, since a phrase was already used.
	        }
	
			
			// The games stops when the user inputs "0" to quit in the input or if the user ran out of lives or if there are no hard phrases left.
	        if (strcmp(input, "0") == 0 || lifeCount == 0 || countHard == 0) {
	            continuePlay = false;
	        }
	    }
	
	    while (!(lifeCount == 0) && continuePlay) {
		        random = rand() % recordCount;
		
		        while (strlen(records[random].phrase) < 50 || usedHardPhrase[random] == true) {
		            random = rand() % recordCount;  // Retry randomization until a "hard" phrase is found or if the phrase is already used.
		        }
		
		        Records currentRecord = records[random]; // If a medium phrase is found, then it will be stored into a local Record struct variable.
		        usedHardPhrase[random] = true; // Once a hard phrase is used, it will become true and can't be used anymore.
				
		        printf("\t\t>> press \"0\" to quit <<\n\n");
		        printf("\t\t[PLAYER]: %s\n", playerName);
		        printf("\t\t[LIVES] : %d\n", lifeCount);
		        printf("\t\t[SCORE] : %d\n\n", currentScore);
		
		        printf("\t\tPHRASE: %s\n\n", currentRecord.phrase); // Displays the hard phrase for the user to copy.
		
		        printf("\t\tINPUT: ");
		        scanf(" %[^\n]", input);
		
		        if (strcmp(input, currentRecord.phrase) == 0) {
		            printf("\n\t\t--------------------------------------------------------------\n\n");
		            printf("\t\tCORRECT!\n");
		            printf("\n\t\t--------------------------------------------------------------\n\n");
		            currentScore += 3; // Every time the user matches the phrase, three points will be added to the user's score.
		            countHard--; // The number of hard phrases decreases by 1, since a phrase was already used.
		        } else {
		            lifeCount--;
		            printf("\n\t\t--------------------------------------------------------------\n\n");
		            printf("\t\tINCORRECT!\n");
		            printf("\t\t-1 LIFE\n");
		            printf("\n\t\t--------------------------------------------------------------\n\n");
		            countHard--; // The number of hard phrases decreases by 1, since a phrase was already used.
		        }
				
				// The games stops when the user inputs "0" to quit in the input or if the user ran out of lives or if there are no hard phrases left.
		        if (strcmp(input, "0") == 0 || lifeCount == 0 || countHard == 0) {
		            continuePlay = false;
		        }
	    	}
	    	
	    if (!(continuePlay)) { // When the game is done, scores will be updated and displayed.
	        printf("\t\t\t\t   ! ! ! GAME OVER ! ! !\n");
	        printf("\n\t\t--------------------------------------------------------------\n\n");
	        printf("\t\tFINAL SCORE: %d\n", currentScore);
	        updateScore(playerRecords, playerCount, playerName, currentScore);
	        displayScores(playerRecords, playerCount);
	    }
	}
}

/* isPlayValid verifies if the input for playChoice is a valid integer.

@param int input - an integer variable that stores the value of playChoice.

@returns true if valid, false if not.

Pre-condition: int input is always an integer and not other data types.
*/
bool isPlayValid(int input) {
    if (input >= 1 && input <= 3) { // Checks if the input is within the range of 1-3.
        return true; // returns true if valid.
    } else {
        return false; // returns false if invalid.
    }
}

/* isManageValid verifies if the input for manageChoice is a valid integer.

@param int input - an integer variable that stores the value of playChoice.

@returns true if valid, false if not.

Pre-condition: int input is always an integer and not other data types.
*/
bool isManageValid(int input) {
    if (input >= 0 && input <= 5) { // Checks if the input is within the range of 0-5.
        return true; // returns true if valid.
    } else {
        return false; // returns false if invalid.
    }
}

/* isMenuValid verifies if the input for menuChoice is a valid integer.

@param int input - an integer variable that stores the value of playChoice.

@returns true if valid, false if not.

Pre-condition: int input is always an integer and not other data types.
*/
bool isMenuValid(int input) {
	if(input >= 1 && input <= 3) {  // Checks if the input is within the range of 1-3.
		return true; // returns true if valid.
	} else {
		return false; // returns false if invalid.
	}
}

/*
Pre-condition: If the user is asked for an integer then the input is also an integer not other data types. The same applies to when
the user is asked for a character.
*/
int main() {
    Records records[1000];       // Assumed that there will be 1000 phrases.
    Player playerRecords[1000];  // Assumed that there will be 1000 players.

    // Declare variables.
    char exitChoice, exitPlayChoice, exitAdminChoice;
    int adminChoice;
    bool menuLoop = true, isAdmin = false;
    int recordCount = 0, playerCount = 0;
    int correct_input;

    while (menuLoop) {  // Continues to loop if the inputs are correct. However, the program will terminate if it is incorrect.
        int menuChoice;
        bool playLoop = true, manageLoop = true;

        displayHeader();               // Displays the title of the game.
        displayMainMenu(&menuChoice);  // Displays the options of the Main Menu.

		if(isMenuValid(menuChoice)) {
            switch (menuChoice) {
                case 1:
                    while (manageLoop) {                 // Continues to loop in the manage data until the user confirms his/her exit.
                        if (isAdmin || verifyAdmin()) {  // Checks if the user already entered the correct password.
                            isAdmin = true;

                            int manageChoice;
                            manageData(&manageChoice);  // Displays the options of manage data.

                            if (isManageValid(manageChoice)) {  // Checks if the value of manageChoice is a valid INTEGER input.
                                switch (manageChoice) {
                                    case 1:
                                        while (addRecord(records, &recordCount))
                                            ;  // Continues to stay or loop in the function addRecord until it returns 0, which means the user exited.
                                        break;
                                    case 2:
                                        while (editRecord(records, &recordCount))
                                            ;  // Continues to stay or loop in the function editRecord until it returns 0, which means the user exited.
                                        break;
                                    case 3:
                                        while (deleteRecord(records, &recordCount))
                                            ;  // Continues to stay or loop in the function deleteRecord until it returns 0, which means the user exited.
                                        break;
                                    case 4:
                                        importData(records, &recordCount);  // Continues to stay or loop in the function importData until it returns 0, which means the user exited.
                                        break;
                                    case 5:
                                        exportData(records, &recordCount);  // Continues to stay or loop in the function exportdata until it returns 0, which means the user exited.
                                        break;
                                    case 0:
                                        correct_input = 1;  // Initializes correct input.

                                        do {  // Asks the user to confirm if he/she wants to return to the main menu repeatedly until the user enters a valid input.
                                            getchar();
                                            printf("\t\t--------------------------------------------------------------\n\n");
                                            printf("\t\t       Are you sure you want to return to the main menu?\n");
                                            printf("\t\t\t\t  [Y] - Yes   | |   [N] - No\n");
                                            printf("\n\t\t--------------------------------------------------------------\n\n");
                                            printf("\t\t\tEnter Choice: \t");
                                            scanf(" %c", &exitAdminChoice);

                                            // If the user wants to return to the main menu, then the loop terminates and isAdmin will turn false
                                            // which means that the user needs to enter the password again to access manage data.
                                            if (exitAdminChoice == 'Y' || exitAdminChoice == 'y') {
                                                manageLoop = false;
                                                isAdmin = false;
                                                correct_input = 1;
                                                printf("\n");
                                            } else if (exitAdminChoice == 'N' || exitAdminChoice == 'n') {
                                                manageLoop = true;
                                                isAdmin = true;
                                                correct_input = 1;
                                                printf("\n");
                                            } else {
                                                correct_input = 0;
                                                printf("\n\t\t\t  Invalid Choice. Please choose 'Y' or 'N'.\n\n");
                                            }
                                        } while (!correct_input);  // Continues to loop when correct_input is 0 (1 when negated)
                                        break;
                                }
                            } else {
                                getchar();
                                printf("\t\t\t    Invalid Choice. Please try again.\n\n");
                            }
                        } else {
                            correct_input = 1;  // Initializes correct input

                            do {  // Asks the user to confirm if he/she wants to return to the main menu or wants to retry.
                                getchar();

                                printf("\t\t--------------------------------------------------------------\n\n");
                                printf("\t\t\t\t! ! ! INCORRECT PASSWORD ! ! !\n\n");
                                printf("\t\t\t[1] - Retry   | |   [0] - Return to Main Menu\n");
                                printf("\n\t\t--------------------------------------------------------------\n\n");
                                printf("\t\t\tEnter Choice: \t");
                                scanf(" %d", &adminChoice);

                                if (adminChoice == 1) {  // If the user wants to retry, then the loop continues
                                    manageLoop = true;
                                    correct_input = 1;
                                    printf("\n");
                                } else if (adminChoice == 0) {  // If the user wants to return to the main menu, then the loop terminates
                                    manageLoop = false;
                                    correct_input = 1;
                                    printf("\n");
                                } else {
                                    correct_input = 0;
                                    printf("\n\t\t\t  Invalid Choice. Please choose 1 or 0.\n\n");
                                }
                            } while (!correct_input);  // Continues to loop when correct_input is 0 (1 when negated)
                        }
                    }
                    break;
                case 2:
                    while (playLoop) {
                        int playChoice;
                        displayPlayMenu(&playChoice);  // Displays the options of play menu.

                        if (isPlayValid(playChoice)) {  // Checks if the value of playChoice is a valid INTEGER input.
                            switch (playChoice) {
                                case 1:
                                    if (recordCount == 0) {  // If there are no records yet, it will display a message.
                                        printf("\t\t\t\t ! ! ! NO EXISTING RECORDS ! ! !\n\n");
                                    } else {  // If there's at least one record, the game will execute.
                                        playGame(records, recordCount, playerRecords, &playerCount);
                                    }
                                    break;
                                case 2:
                                    displayScores(playerRecords, &playerCount);  // Displays the high scores of each player.
                                    break;
                                case 3:
                                    correct_input = 1;  // Initializes correct input.

                                    do {  // Asks the user to confirm if he/she wants to return to the main menu or not.
                                        getchar();

                                        printf("\t\t--------------------------------------------------------------\n\n");
                                        printf("\t\t       Are you sure you want to return to the main menu?\n");
                                        printf("\t\t\t\t  [Y] - Yes   | |   [N] - No\n");
                                        printf("\n\t\t--------------------------------------------------------------\n\n");
                                        printf("\t\t\tEnter Choice: \t");
                                        scanf(" %c", &exitPlayChoice);

                                        // If the user wants to return to the main menu, then the loop terminates
                                        if (exitPlayChoice == 'Y' || exitPlayChoice == 'y') {
                                            playLoop = false;
                                            correct_input = 1;
                                            printf("\n");
                                        } else if (exitPlayChoice == 'N' || exitPlayChoice == 'n') {
                                            playLoop = true;
                                            correct_input = 1;
                                            printf("\n");
                                        } else {
                                            correct_input = 0;
                                            printf("\n\t\t\t  Invalid Choice. Please choose 'Y' or 'N'.\n\n");
                                        }
                                    } while (!correct_input);  // Continues to loop when correct_input is 0 (1 when negated)
                                    break;
                            }
                        } else {
                            getchar();
                            printf("\t\t\t    Invalid Choice. Please try again.\n\n");
                        }
                    }
                    break;
                case 3:
                    correct_input = 1;  // Initializes correct input

                    do {  // Asks the user to confirm if he/she wants to terminate the program or not.
                        getchar();

                        printf("\t\t--------------------------------------------------------------\n\n");
                        printf("\t\t\t  Are you sure you want to exit the program?\n");
                        printf("\t\t\t\t  [Y] - Yes   | |   [N] - No\n");
                        printf("\n\t\t--------------------------------------------------------------\n\n");
                        printf("\t\t\tEnter Choice: \t");
                        scanf(" %c", &exitChoice);

                        // If the user wants to terminate the program, then the loop terminates.
                        if (exitChoice == 'Y' || exitChoice == 'y') {
                            menuLoop = false;
                            correct_input = 1;
                            printf("\n");
                        } else if (exitChoice == 'N' || exitChoice == 'n') {
                            menuLoop = true;
                            correct_input = 1;
                            printf("\n");
                        } else {
                            correct_input = 0;
                            printf("\n\t\t\t  Invalid Choice. Please choose 'Y' or 'N'.\n\n");
                        }
                    } while (!correct_input);  // Continues to loop when correct_input is 0 (1 when negated)
                    break;
            }
    	}
    	else {
    		printf("\t\t\t    Invalid Choice. Please try again.\n");
		}
    }

    return 0;
}