/******************************************************************
Description: This program is a Shuttle Service Ticket Booking for a 14-seater bus wherein the user will
be first prompted to a Menu for them to select their desired action. In the menu, the user can choose to
either book a reservation, cancel a reservation (if and only if there is already a booked reservation),
display the trips, routes, and schedule times of the Shuttle Service, update the departure time
(as well as the Schedule Table), and exit the program.

Programmed by: CRISOSTOMO, JOSH NEAL F.
*/

#include <stdbool.h>
#include <stdio.h>

/*  This function takes an integer input of seat (nSeatNum) and the pointers to integers (*nSeat(One-Fourteen)). After it
    receives an integer, it will use conditional statements to know which pointer corresponds to the integer seat input (nSeatNum).
    It then assigns the memory address of the integer variable to *pickSeat and then returns it. If nSeatNum is not within
    the range of 1-14, then the value of pickSeat will be NULL.

    Precondition: *nSeat(One-Fourteen) are initialized as 0 and nSeatNum is a positive integer pointer that
                  ranges from 1 to 14.

    @param <int nSeatNum> -- a positive integer input from 1-14.

    @param <int *nSeat(One-Fourteen)> -- pointers to integers representing the reservation status of each individual seat.

    @return This function returns the integer value of pickSeat.
*/
int *getSeat(int nSeatNum, int *nSeatOne, int *nSeatTwo, int *nSeatThree, int *nSeatFour, int *nSeatFive, int *nSeatSix,
             int *nSeatSeven, int *nSeatEight, int *nSeatNine, int *nSeatTen, int *nSeatEleven, int *nSeatTwelve,
             int *nSeatThirteen, int *nSeatFourteen)
{
    int *pickSeat;

    // Series of conditional statements that assigns the seat number to pickSeat depending on the input nSeatnum.
    if (nSeatNum == 1)
        pickSeat = nSeatOne;

    else if (nSeatNum == 2)
        pickSeat = nSeatTwo;

    else if (nSeatNum == 3)
        pickSeat = nSeatThree;

    else if (nSeatNum == 4)
        pickSeat = nSeatFour;

    else if (nSeatNum == 5)
        pickSeat = nSeatFive;

    else if (nSeatNum == 6)
        pickSeat = nSeatSix;

    else if (nSeatNum == 7)
        pickSeat = nSeatSeven;

    else if (nSeatNum == 8)
        pickSeat = nSeatEight;

    else if (nSeatNum == 9)
        pickSeat = nSeatNine;

    else if (nSeatNum == 10)
        pickSeat = nSeatTen;

    else if (nSeatNum == 11)
        pickSeat = nSeatEleven;

    else if (nSeatNum == 12)
        pickSeat = nSeatTwelve;

    else if (nSeatNum == 13)
        pickSeat = nSeatThirteen;

    else if (nSeatNum == 14)
        pickSeat = nSeatFourteen;

    else
        pickSeat = NULL; /* The pointer pickSeat will not point to any memory location when nSeatNum is not
                            within the seats 1-14. */

    return pickSeat; // Returns the a pointer, which is pickSeat.
}

/*  The function displayHeader() displays the menu header of the program and only acts
    as a design.

    Precondition: N/A

    @param N/A

    @return This function does not return any value rather it displays the header design of the menu of the
            program.
*/
void displayHeader()
{
    printf("\n-------------------------------------------------------------------------\n");
    printf("\t\t\tDLSU-LAGUNA SHUTTLE SERVICE\n");
    printf("-------------------------------------------------------------------------\n");
    printf("\t\t\t\t  MENU\n\n");
}

/*  This function prints the menu of the program, which contains the 5 options (Booking, Cancel Booking, Schedule,
    Update Departure Time, and Close Application). The function will then ask the user to input an integer from
    1 to 5 for the desired option.

    Precondition: *nMenu is positive and will range only from 1 to 5.

    @param <int *nMenu> -- stores memory address of the value of the user's input and passes it to the main function.

    @return It will not return any value rather it will pass the input *nMenu to the main function, and it will
            print a message if the input is less than 1 or greater than 5.
*/
void displayMenu(int *nMenu)
{
    printf("\t\t\t[1]\tBook a Seat\n\t\t\t[2]\tCancel Booking\n\t\t\t[3]\tShow Schedule\n\t\t\t[4]\tUpdate Departure "
           "Time\n\t\t\t[5]\tClose Application\n\n");
    printf("\t\t\tMENU: ");
    scanf("%d", nMenu); // Scans the input and stores it at the memory location pointed to by nMenu.
}

/*  This function shows the route of the shuttle/bus depending on the departure time. If the value of
    *nCurrentTime is even, then the function will print "ROUTE: Manila --> Laguna". But, if the value
    of *nCurrentTime is odd, then the function will print "ROUTE: Laguna --> Manila".

    Precondition: *nCurrentTime is only between 4 to 19, but not 12 and 13.

    @param <int *nCurrentTime> -- the memory address (value) of the default departure time, if the user does not
           update the departure time, or it can also be the input of the user to update the departure time.

    @return It does not return any value but it will print a message depending on the met conditional statement.
*/
void showRoute(int *nCurrentTime)
{
    int nTime;

    // Extracts the remainder of *nCurrentTime when divided to 2, and assigns it to nTime.
    nTime = *nCurrentTime % 2;

    // Checks nCurrentTime, whether it is even or odd, to determine the place of departure.
    if (nTime == 0)
    {
        printf("\n\t ROUTE: Manila --> Laguna\n"); // If the remainder is equal to 0, then the place of departure is Manila.
    }
    else
    {
        printf("\n\t ROUTE: Laguna --> Manila\n"); // If the remainder is not equal to 0, then the place of departure is Laguna.
    }

    printf("\n**---------------------------------------------------------------------**\n\n");
}

/*  This function displays the seats, number of available seats, and its reservation status using a for-loop starting from 1 and
    ends with 14 (*seat). Initially, the list will not contain anything aside from the seat numbers. The loop will call an external
    function, which is getSeat, to get the reservation status for the current seat number. If the seat is reserved, "RESERVED" + the
    *studentID associated with the seat will be displayed together.

    Precondition: *studentID is an 8-digit integer pointer and *nSeat(One-Fourteen) is a positive integer pointer that
                  ranges from 1 to 14.

    @param <int *seat> -- stores the memory address (value) of the maximum number of seats.

    @param <int *studentID> -- pointer to an integer of the student ID input of the user.

    @param <int *nSeat(One-Fourteen)> -- pointers to integers representing the reservation status of each individual seat.

    @param <int *nCount> -- pointer to an integer of the number of reserved seat/s during a specific schedule.

    @return This function will not return any value. It will just print the updated seat reservation status.
*/
void displaySeats(int *seat, int *nSeatOne, int *nSeatTwo, int *nSeatThree, int *nSeatFour, int *nSeatFive, int *nSeatSix,
                  int *nSeatSeven, int *nSeatEight, int *nSeatNine, int *nSeatTen, int *nSeatEleven, int *nSeatTwelve,
                  int *nSeatThirteen, int *nSeatFourteen, int *studentID, int *nCount)
{
    int seatNumber;
    int *pickSeat;

    printf("\n**---------------------------------------------------------------------**\n");
    printf("\nAvailable Seats: %d\n\n", *seat - *nCount);
    printf("SEAT RESERVATION STATUS\n\n");

    for (seatNumber = 1; seatNumber <= *seat; seatNumber++) // For-loop that displays the seat numbers.
    {
        pickSeat = getSeat(seatNumber, nSeatOne, nSeatTwo, nSeatThree, nSeatFour, nSeatFive, nSeatSix, nSeatSeven, nSeatEight,
                           nSeatNine, nSeatTen, nSeatEleven, nSeatTwelve, nSeatThirteen, nSeatFourteen);

        printf("\tSeat %02d: ", seatNumber);

        if (*pickSeat != 0) // Checks if *pickSeat has a value, which is the student ID.
        {
            printf("RESERVED [%d]\n", *pickSeat); // If it has a value, it will display that the seat is reserved for that ID.
        }
        else
        {
            printf("\n"); // If not, it will just leave it blank.
        }
    }

    printf("\n**---------------------------------------------------------------------**\n\n");
}

/*  This function displays the seats for the user to see and then, asks the user to choose a seat to reserve and if
    it is not within the number of seats, not an integer, or if the ID number is not 8-digits, then the function will then print a
    message that it is invalid and will ask the user to input a seat again. However, if the inputs satisfied the requirements, the
    function will print a message that it was successfully booked and the *pickSeat = *studentID is essentially storing the value of
    the student ID in the occupancy status variable of a specific seat, making it occupied. The values of *studentID and
    *nSeat(One-Fourteen) will be passed to displaySeats.

    Precondition: *studentID is an 8-digit integer pointer, *nSeat(One-Fourteen) is a positive integer pointer that
                  ranges from 1 to 14, and *seat has a fixed value of 14.

    @param <int *seat> -- stores the memory address (value) of the maximum number of seats.

    @param <int *studentID> -- pointer to an integer of the student ID input of the user.

    @param <int *nSeat(One-Fourteen)> -- pointers to integers representing each individual seat and if it is already
                                         reserved.

    @param <int *nCount> -- pointer to an integer of the number of reserved seat/s during a specific schedule.

    @return This function will not return any value. It will just print a message or a chain of messages depending on the
            met conditional statement/s, and will just update another function, which is displaySeats(), by passing the
            values.

*/
void bookSeat(int *seat, int *nSeatOne, int *nSeatTwo, int *nSeatThree, int *nSeatFour, int *nSeatFive, int *nSeatSix,
              int *nSeatSeven, int *nSeatEight, int *nSeatNine, int *nSeatTen, int *nSeatEleven, int *nSeatTwelve,
              int *nSeatThirteen, int *nSeatFourteen, int *studentID, int *nCount)
{
    int nSeatNumber;

    printf("**---------------------------------------------------------------------**\n");
    printf("*                              BOOKING MENU                             *");

    displaySeats(seat, nSeatOne, nSeatTwo, nSeatThree, nSeatFour, nSeatFive, nSeatSix, nSeatSeven, nSeatEight, nSeatNine, nSeatTen,
                 nSeatEleven, nSeatTwelve, nSeatThirteen, nSeatFourteen, studentID, nCount);

    if (*nSeatOne != 0 && *nSeatTwo != 0 && *nSeatThree != 0 && *nSeatFour != 0 && *nSeatFive != 0 && *nSeatSix != 0 &&
        *nSeatSeven != 0 && *nSeatEight != 0 && *nSeatNine != 0 && *nSeatTen != 0 && *nSeatEleven != 0 && *nSeatTwelve != 0 &&
        *nSeatThirteen != 0 && *nSeatFourteen != 0)
    {
        printf("All seats are booked for this schedule. Please see other schedules in the Menu.\n");
    }
    else
    {
        printf("What seat would you like to BOOK? (1-14): ");
        scanf("%d", &nSeatNumber);

        // Checks if the inpur for the seat is a non-integer or an an integer not in between 1-14.
        if (!(nSeatNumber == 1) && !(nSeatNumber == 2) && !(nSeatNumber == 3) && !(nSeatNumber == 4) && !(nSeatNumber == 5) &&
            !(nSeatNumber == 5) && !(nSeatNumber == 6) && !(nSeatNumber == 7) && !(nSeatNumber == 8) && !(nSeatNumber == 9) &&
            !(nSeatNumber == 10) && !(nSeatNumber == 11) && !(nSeatNumber == 12) && !(nSeatNumber == 13) && !(nSeatNumber == 14))
        {
            getchar(); // Gets or reads the non-integer input of the user.
            printf("\n\nInvalid. Please input an integer between 1-14.\n\n");
            bookSeat(seat, nSeatOne, nSeatTwo, nSeatThree, nSeatFour, nSeatFive, nSeatSix, nSeatSeven, nSeatEight, nSeatNine,
                     nSeatTen, nSeatEleven, nSeatTwelve, nSeatThirteen, nSeatFourteen, studentID, nCount);
        }
        else
        {
            printf("Student ID number (12345678): ");
            scanf("%d", studentID);

            if (*studentID < 10000000 || *studentID > 99999999) // Checks if the value of studentID is not an 8-digit integer.
            {
                printf("\nInvalid ID number.\n\n");

                // Calls bookSeat() to ask the user to input again until the user inputs the correct input.
                bookSeat(seat, nSeatOne, nSeatTwo, nSeatThree, nSeatFour, nSeatFive, nSeatSix, nSeatSeven, nSeatEight, nSeatNine,
                         nSeatTen, nSeatEleven, nSeatTwelve, nSeatThirteen, nSeatFourteen, studentID, nCount);
            }
            else
            {
                // Calls getSeat() to check for each seat's reservation status (if it has a value or not).
                int *pickSeat = getSeat(nSeatNumber, nSeatOne, nSeatTwo, nSeatThree, nSeatFour, nSeatFive, nSeatSix, nSeatSeven,
                                        nSeatEight, nSeatNine, nSeatTen, nSeatEleven, nSeatTwelve, nSeatThirteen, nSeatFourteen);

                if (*pickSeat == 0) // Checks if the seat is not yet booked.
                {
                    // Assigns the ID of the user to *pickSeat.
                    *pickSeat = *studentID;
                    printf("\n\t  You successfully reserved your booking for Seat %02d.\n\t\t\t       Thank you!\n", nSeatNumber);
                    (*nCount)++; // The number of reserved seats will increment by 1.
                }
                else
                {
                    printf("\nSorry, Seat %02d is already taken.\n\n", nSeatNumber);

                    // Calls bookSeat() until the user puts the correct input.
                    bookSeat(seat, nSeatOne, nSeatTwo, nSeatThree, nSeatFour, nSeatFive, nSeatSix, nSeatSeven, nSeatEight,
                             nSeatNine, nSeatTen, nSeatEleven, nSeatTwelve, nSeatThirteen, nSeatFourteen, studentID, nCount);
                }
            }
        }
    }
}

/* This function will first check if the seats in *nSeat(One-Fourteen) has a value. If it has none, then it will print a
   message saying so, and will redirect the user to the bookSeat() function for he/she to book first before being able to cancel a
   reservation. Otherwise, the function will ask the user which seat reservation the user wish to cancel. This function will check
   like in bookSeat(), if the value is within the range of 1 to 14 (*seat) or if it is a valid integer. It then calls for getSeat()
   to get the status of the chosen seat. It will now check if the seat number is invalid or not booked, if it is, then the function
   will call itself repeatedly until it gets a valid input. Otherwise, if there is/are seat/s booked, then it cancels the booking by
   reseting the seat status back to 0 and will print a message that it is successful.

    Precondition: *studentID is an 8-digit integer pointer, *nSeat(One-Fourteen) is a positive integer pointer that
                  ranges from 1 to 14, and *seat has a fixed value of 14.

    @param <int *seat> -- stores the memory address (value) of the maximum number of seats.

    @param <int *studentID> -- pointer to an integer of the student ID input of the user.

    @param <int *nSeat(One-Fourteen)> -- pointers to integers representing each individual seat and if it is already
                                         reserved.

    @param <int *nCount> -- pointer to an integer of the number of reserved seat/s during a specific schedule.

    @return This function will not return any value. It will just print a message or a chain of messages depending on the
            met conditional statement/s, and will just update displaySeats() by reseting the value of *pickSeat to 0, if cancelled.
*/
void cancelBook(int *seat, int *nSeatOne, int *nSeatTwo, int *nSeatThree, int *nSeatFour, int *nSeatFive, int *nSeatSix,
                int *nSeatSeven, int *nSeatEight, int *nSeatNine, int *nSeatTen, int *nSeatEleven, int *nSeatTwelve,
                int *nSeatThirteen, int *nSeatFourteen, int *studentID, int *nCount)
{
    int nSeatNumber = 0;

    printf("**---------------------------------------------------------------------**\n");
    printf("*                         BOOK CANCELLATION MENU                        *");

    displaySeats(seat, nSeatOne, nSeatTwo, nSeatThree, nSeatFour, nSeatFive, nSeatSix, nSeatSeven, nSeatEight, nSeatNine, nSeatTen,
                 nSeatEleven, nSeatTwelve, nSeatThirteen, nSeatFourteen, studentID, nCount);

    // Checks if there are any reservations in each seat.
    if (*nSeatOne == 0 && *nSeatTwo == 0 && *nSeatThree == 0 && *nSeatFour == 0 && *nSeatFive == 0 && *nSeatSix == 0 &&
        *nSeatSeven == 0 && *nSeatEight == 0 && *nSeatNine == 0 && *nSeatTen == 0 && *nSeatEleven == 0 && *nSeatTwelve == 0 &&
        *nSeatThirteen == 0 && *nSeatFourteen == 0)
    {
        // If there are no booked seats, it redirects the user to the bookSeat() function for them to book a seat first.
        printf("There are no booked seats yet. The program will direct you to the booking \nmenu.\n\n");
        bookSeat(seat, nSeatOne, nSeatTwo, nSeatThree, nSeatFour, nSeatFive, nSeatSix, nSeatSeven, nSeatEight, nSeatNine, nSeatTen,
                 nSeatEleven, nSeatTwelve, nSeatThirteen, nSeatFourteen, studentID, nCount);
    }
    else
    {
        // If there is at least one booked seat, it will ask the user which seat to cancel.
        printf("What seat would you like to CANCEL? (1-14): ");
        scanf("%d", &nSeatNumber);

        int *pickSeat = getSeat(nSeatNumber, nSeatOne, nSeatTwo, nSeatThree, nSeatFour, nSeatFive, nSeatSix, nSeatSeven, nSeatEight,
                                nSeatNine, nSeatTen, nSeatEleven, nSeatTwelve, nSeatThirteen, nSeatFourteen);

        // Checks if the inpur for the seat is a non-integer or an an integer not in between 1-14.
        if (!(nSeatNumber == 1) && !(nSeatNumber == 2) && !(nSeatNumber == 3) && !(nSeatNumber == 4) && !(nSeatNumber == 5) &&
            !(nSeatNumber == 5) && !(nSeatNumber == 6) && !(nSeatNumber == 7) && !(nSeatNumber == 8) && !(nSeatNumber == 9) &&
            !(nSeatNumber == 10) && !(nSeatNumber == 11) && !(nSeatNumber == 12) && !(nSeatNumber == 13) && !(nSeatNumber == 14))
        {
            getchar(); // Gets or reads the non-integer input of the user.
            printf("\n\nInvalid. Please input an integer between 1-14.\n\n");
            cancelBook(seat, nSeatOne, nSeatTwo, nSeatThree, nSeatFour, nSeatFive, nSeatSix, nSeatSeven, nSeatEight, nSeatNine,
                       nSeatTen, nSeatEleven, nSeatTwelve, nSeatThirteen, nSeatFourteen, studentID, nCount);
        }
        else if (*pickSeat != 0)
        {
            // If *pickSeat has a value, then that value will reset to 0.
            printf("\n\t           Seat Booking [Seat %02d] is cancelled.\n", nSeatNumber);
            printf("\t\t\t        Thank you!\n");
            *pickSeat = 0;
            (*nCount)--; // The number of reserved seats will decrement by 1.
        }
        else
        {
            printf("\nSeat is not booked.\n\n"); /* If the input does not match the the seat in *pickSeat, then the seat does not
                                                    have any bookings. */
            cancelBook(seat, nSeatOne, nSeatTwo, nSeatThree, nSeatFour, nSeatFive, nSeatSix, nSeatSeven, nSeatEight, nSeatNine,
                       nSeatTen, nSeatEleven, nSeatTwelve, nSeatThirteen, nSeatFourteen, studentID, nCount);
        }
    }
}

/*  This function displays the time and trips. The default value of nCurrentTime is 4 and will change
    depending on the value that it will receive from the user input in the function updateSchedule().
    This function displays different symbols to make a distinction if the time is current, past, or
    one of the next trips. This function uses a series of conditional statements, which checks if the
    value of nCurrentTime is greater than (if), equal (else if), or less than (else) the number. NOTE:
    Each of the numbers between 4-19, except 12 and 13, was put into a conditional statement.

    Precondition: nCurrentTime is a positive integer between 4 and 19, but not 12 and 13.

    @param <int nCurrentTime> -- variable that holds the integer 4 as default (which is from nDefaultTime) and
                           will change depending on the updateSchedule() function (value passed to nDefaultTime).

    @return This function will not return any value. It will just print the schedule with the default time of 4 or
            an updated schedule with a value from the user input.
*/
void displaySchedule(int nCurrentTime)
{
    printf("*-----------------------------------------------------------------------*\n");
    printf("|                             BUS SCHEDULE                              |\n");
    printf("|-----------------------------------------------------------------------|\n");
    printf("|     \"<##>\" = Current    |     \"|XX|\" = Past    |     \"[##]\" = Next    |\n");
    printf("|-----------------------------------------------------------------------|\n");
    printf("|-----------------------------------------------------------------------|\n");
    printf("| TRIP | Depart Manila | Arrive Laguna || Depart Laguna | Arrive Manila |\n");
    printf("|------|---------------|---------------||---------------|---------------|\n");

    /* These series of conditional statements check whether integer values of time from 4-19 (excluding 12 and 13)
       is less than, equal to, or greater than nCurrentTime. */

    // There will be unique distinctions for past, current, and future times.
    if (nCurrentTime > 4)
    {
        printf("|  01  |   |X:XX AM|   |   |X:XX AM|   ||");
    }
    else if (nCurrentTime == 4)
    {
        printf("|  01  |  < 4:00 AM >  |  < 5:00 AM >  ||");
    }
    else
    {
        printf("   [4:00 AM]   |   [5:00 AM]   |");
    }

    if (nCurrentTime > 5)
    {
        printf("   |X:XX AM|   |   |X:XX AM|   |");
    }
    else if (nCurrentTime == 5)
    {
        printf("  < 5:00 AM >  |  < 6:00 AM >  |");
    }
    else
    {
        printf("   [5:00 AM]   |   [6:00 AM]   |");
    }

    if (nCurrentTime > 6)
    {
        printf("\n|  02  |   |X:XX AM|   |   |X:XX AM|   ||");
    }
    else if (nCurrentTime == 6)
    {
        printf("\n|  02  |  < 6:00 AM >  |  < 7:00 AM >  ||");
    }
    else
    {
        printf("\n|  02  |   [6:00 AM]   |   [7:00 AM]   ||");
    }

    if (nCurrentTime > 7)
    {
        printf("   |X:XX AM|   |   |X:XX AM|   |");
    }
    else if (nCurrentTime == 7)
    {
        printf("  < 7:00 AM >  |  < 8:00 AM >  |");
    }
    else
    {
        printf("   [7:00 AM]   |   [8:00 AM]   |");
    }

    if (nCurrentTime > 8)
    {
        printf("\n|  03  |   |X:XX AM|   |   |X:XX AM|   ||");
    }
    else if (nCurrentTime == 8)
    {
        printf("\n|  03  |  < 8:00 AM >  |  < 9:00 AM >  ||");
    }
    else
    {
        printf("\n|  03  |   [8:00 AM]   |   [9:00 AM]   ||");
    }

    if (nCurrentTime > 9)
    {
        printf("   |XX:XXAM|   |   |XX:XXAM|   |");
    }
    else if (nCurrentTime == 9)
    {
        printf("  < 9:00 AM >  |  < 10:00AM >  |");
    }
    else
    {
        printf("   [9:00 AM]   |   [10:00AM]   |");
    }

    if (nCurrentTime > 10)
    {
        printf("\n|  04  |   |XX:XXAM|   |   |XX:XXAM|   ||");
    }
    else if (nCurrentTime == 10)
    {
        printf("\n|  04  |  < 10:00AM >  |  < 11:00AM >  ||");
    }
    else
    {
        printf("\n|  04  |   [10:00AM]   |   [11:00AM]   ||");
    }

    if (nCurrentTime > 11)
    {
        printf("   |XX:XXAM|   |   |XX:XXPM|   |");
    }
    else if (nCurrentTime == 11)
    {
        printf("  < 11:00AM >  |  < 12:00PM >  |");
    }
    else
    {
        printf("   [11:00AM]   |   [12:00PM]   |");
    }

    if (nCurrentTime > 14)
    {
        printf("\n|  05  |   |X:XX PM|   |   |X:XX PM|   ||");
    }
    else if (nCurrentTime == 14)
    {
        printf("\n|  05  |  < 2:00 PM >  |  < 3:00 PM >  ||");
    }
    else
    {
        printf("\n|  05  |   [2:00 PM]   |   [3:00 PM]   ||");
    }

    if (nCurrentTime > 15)
    {
        printf("   |X:XX PM|   |   |X:XX PM|   |");
    }
    else if (nCurrentTime == 15)
    {
        printf("  < 3:00 PM >  |  < 4:00 PM >  |");
    }
    else
    {
        printf("   [3:00 PM]   |   [4:00 PM]   |");
    }

    if (nCurrentTime > 16)
    {
        printf("\n|  06  |   |X:XX PM|   |   |X:XX PM|   ||");
    }
    else if (nCurrentTime == 16)
    {
        printf("\n|  06  |  < 4:00 PM >  |  < 5:00 PM >  ||");
    }
    else
    {
        printf("\n|  06  |   [4:00 PM]   |   [5:00 PM]   ||");
    }

    if (nCurrentTime > 17)
    {
        printf("   |X:XX PM|   |   |X:XX PM|   |");
    }
    else if (nCurrentTime == 17)
    {
        printf("  < 5:00 PM >  |  < 6:00 PM >  |");
    }
    else
    {
        printf("   [5:00 PM]   |   [6:00 PM]   |");
    }

    if (nCurrentTime > 18)
    {
        printf("\n|  07  |   |X:XX PM|   |   |X:XX PM|   ||");
    }
    else if (nCurrentTime == 18)
    {
        printf("\n|  07  |  < 6:00 PM >  |  < 7:00 PM >  ||");
    }
    else
    {
        printf("\n|  07  |   [6:00 PM]   |   [7:00 PM]   ||");
    }

    if (nCurrentTime > 19)
    {
        printf("   |X:XX PM|   |   |X:XX PM|   |");
    }
    else if (nCurrentTime == 19)
    {
        printf("  < 7:00 PM >  |  < 8:00 PM >  |");
    }
    else
    {
        printf("   [7:00 PM]   |   [8:00 PM]   |");
    }

    printf("\n*-----------------------------------------------------------------------*\n");
}

/*  This function asks the user to input the desired future departure time. However, they can't pick the time(s) before the
    updated departure time. If the input is either 12 [12] or 13 [1], an invalid message wil print since either are not included
    in the schedule. User can't also input non-integer values. The new input will become the new default time, until the program
    stops. Once they update the departure time, previous bookings will be deleted and the seat values of *nSeat(One-Fourteen) and
    make the *nCount will reset to 0.

    Precondition: *nCurrentTime has a default value of 4 when first executed.

    Precondition: A seat or seats in *nSeat(One-Fourteen) has a value aside from 0.

    @param <int *nCurrentTime> -- holds the value of 4 (first execution) or a new value from the user input in
                                  this function.

    @param <int *nSeat(One-Fourteen)> -- pointers to integers representing each individual seat and if it is already
                                         reserved.

    @return This function will not return any value. It will just print a message of the newly updated departure and
            arrival time. It will also pass the input value to displaySchedule() function and showRoute() function.
*/
void updateSchedule(int *nCurrentTime, int *seat, int *nSeatOne, int *nSeatTwo, int *nSeatThree, int *nSeatFour, int *nSeatFive,
                    int *nSeatSix, int *nSeatSeven, int *nSeatEight, int *nSeatNine, int *nSeatTen, int *nSeatEleven,
                    int *nSeatTwelve, int *nSeatThirteen, int *nSeatFourteen, int *nCount)
{
    int nTime;

    printf("\n**---------------------------------------------------------------------**\n\n");

    displaySchedule(*nCurrentTime);

    printf("\n** PREVIOUS BOOKINGS WILL BE DELETED AFTER UPDATING THE DEPARTURE TIME. **\n\n");

    printf("Select your desired time of departure.");
    printf(" [EX: 16 --> 4:00 PM]\n\n");
    printf("Departure Time (Military Time): "); // Asks for the desired new departure time.
    scanf("%d", &nTime);

    // Checks if the inpur for the time is a non-integer or an an integer not in between 4-11 and 14-19.
    if (!(nTime == 4) && !(nTime == 5) && !(nTime == 6) && !(nTime == 7) && !(nTime == 8) && !(nTime == 9) && !(nTime == 10) &&
        !(nTime == 11) && !(nTime == 14) && !(nTime == 15) && !(nTime == 16) && !(nTime == 17) && !(nTime == 18) && !(nTime == 19))
    {
        getchar(); // Gets or reads the non-integer input of the user.
        printf("\n**---------------------------------------------------------------------**\n\n");
        printf("Invalid. Please input an integer between 5-11 and 14-19.\n");
        updateSchedule(nCurrentTime, seat, nSeatOne, nSeatTwo, nSeatThree, nSeatFour, nSeatFive, nSeatSix, nSeatSeven, nSeatEight,
                       nSeatNine, nSeatTen, nSeatEleven, nSeatTwelve, nSeatThirteen, nSeatFourteen, nCount);
    }
    else // If the input are correct, it will proceed.
    {
        if (nTime > *nCurrentTime) // Checks if the input is greater than the recent value of *nCurrentTime.
        {
            *nCurrentTime = nTime; // If it is, the input will be the new value of *nCurrentTime.

            // After updating the time, the values of each seat will be reset to 0. Therefore, making the number of reserved seats
            // also reset to 0.
            *nSeatOne = 0;
            *nSeatTwo = 0;
            *nSeatThree = 0;
            *nSeatFour = 0;
            *nSeatFive = 0;
            *nSeatSix = 0;
            *nSeatSeven = 0;
            *nSeatEight = 0;
            *nSeatNine = 0;
            *nSeatTen = 0;
            *nSeatEleven = 0;
            *nSeatTwelve = 0;
            *nSeatThirteen = 0;
            *nSeatFourteen = 0;
            *nCount = 0;
            // Deletes all booked seats from the previous time.

            printf("\n**---------------------------------------------------------------------**\n");

            // Displays the newly updated departure time and its arrival time.
            // For inputs less than 12, it will display the nTime and nTime + 1 for the arrival.

            if (nTime < 12)
            {
                printf("\n\t\t\t\t  [UPDATED]\n");
                printf("\t Departure Time: %d:00 AM     ||     Arrival Time: %d:00 AM\n", nTime, nTime + 1);
            }
            else if (nTime == 11)
            {
                // Since the arrival of dparture time 11 is 12 pm, this will print specifically for this hour.
                printf("\n\t\t\t\t  [UPDATED]\n");
                printf("\t Departure Time: %d:00 AM     ||     Arrival Time: %d:00 PM\n", nTime, nTime + 1);
            }
            else
            {
                // Since the inputs are in military time, it will be subtracted by 12 to get the regular time.
                printf("\n\t\t\t\t  [UPDATED]\n");
                printf("\t Departure Time: %d:00 PM     ||     Arrival Time: %d:00 PM\n", (nTime - 12), (nTime - 12) + 1);

                // The nCurrentTime will then be passed to showRoute() to show the places of departure and arrival.
                showRoute(nCurrentTime);
                displaySchedule(*nCurrentTime);
            }
        }
        else
        {
            printf("\n**---------------------------------------------------------------------**\n\n");
            printf("Invalid. New input can only be future time/s, not previous time/s.\n");
            updateSchedule(nCurrentTime, seat, nSeatOne, nSeatTwo, nSeatThree, nSeatFour, nSeatFive, nSeatSix, nSeatSeven,
                           nSeatEight, nSeatNine, nSeatTen, nSeatEleven, nSeatTwelve, nSeatThirteen, nSeatFourteen, nCount);
        }
    }
}

/*  This function displays the ASCII art of the arrangement of the shuttle/bus through the use of an iterative statement,
    specifically, a for-loop. Inside the for-loop are conditional statements which arranges the format of the seats, and updates
    the character inside the brackets to "[--]" by calling getSeat(), which determines the status of the seats.

    Precondition: *seat is a positive integer within the range of 4 to 19, but not 12 and 13.

    @param <int *seat> -- stores the memory address (value) of the maximum number of seats.

    @param <int *nSeat(One-Fourteen)> -- pointers to integers representing each individual seat and if it is already
                                         reserved.

    @return This function will not return any value. It will just print the ASCII art for thu bus and updates the status
            of the reserved seat.
*/
void displayBus(int *seat, int *nSeatOne, int *nSeatTwo, int *nSeatThree, int *nSeatFour, int *nSeatFive, int *nSeatSix,
                int *nSeatSeven, int *nSeatEight, int *nSeatNine, int *nSeatTen, int *nSeatEleven, int *nSeatTwelve,
                int *nSeatThirteen, int *nSeatFourteen)
{
    int nSeatNumber;
    int *pickSeat;

    printf("\n**---------------------------------------------------------------------**\n\n");
    printf("Bus Seating Arrangement\n");
    printf("----------------------\n\n");
    printf("[--] --> Reserved.\n\n");
    printf("  ___      ___\n");
    printf("/--------------\\\n");
    printf("| [DR] ||      |__\n");
    printf("|             \n");

    // For-loop to list the seat numbers and each seat's reservation status.
    for (nSeatNumber = 1; nSeatNumber <= *seat; nSeatNumber++)
    {
        pickSeat = getSeat(nSeatNumber, nSeatOne, nSeatTwo, nSeatThree, nSeatFour, nSeatFive, nSeatSix, nSeatSeven, nSeatEight,
                           nSeatNine, nSeatTen, nSeatEleven, nSeatTwelve, nSeatThirteen, nSeatFourteen);

        if (*pickSeat == nSeatNumber || *pickSeat != 0) // Checks if the value in *pickSeat is not 0 or equal to the nSeatNumber
        {
            printf("| [--] |");
        }
        else
        {
            printf("| [%02d] ", nSeatNumber);
            printf("|");
        }

        if (nSeatNumber % 2 == 1)
        {
            printf("\n");
        }
    }

    printf("\n|              ___");
    printf("\n|--------------|");
    printf("\n\\--------------/\n");
    printf("            ##\n");
    printf("          #  ##\n");
    printf("\n**---------------------------------------------------------------------**\n\n");
}

/*  This function displays the current number of reserved seats.

    Precondition: *nCount is initialized with 0.

    @param <int *nCount> -- stores the value of the increment in bookSeat() and the decrement in cancelBook().

    @return This function will not return any value. It will just print the count of reserved seats.
*/
void displayCount(int *nCount)
{
    printf("\n**---------------------------------------------------------------------**\n\n");
    printf("Currently reserved seats: %d\n", *nCount); // Prints the number of reserved seats for that schedule.
    printf("\n**---------------------------------------------------------------------**\n\n");
}

/* This is where all the variables are initialized and where most of the user-defined functions were called.
    This also where the switch statement for the menu is at, and it is within a while-loop, which continuously
    loops until the boolean expression bContinue becomes false.
*/
int main()
{
    int seat = 14;
    int studentID = 0;
    int nDefaultTime = 4;
    int exitApp;

    // Initializes each seat to have a value of 0 at the beginning.
    int nSeatOne = 0, nSeatTwo = 0, nSeatThree = 0, nSeatFour = 0, nSeatFive = 0, nSeatSix = 0, nSeatSeven = 0;
    int nSeatEight = 0, nSeatNine = 0, nSeatTen = 0, nSeatEleven = 0, nSeatTwelve = 0, nSeatThirteen = 0, nSeatFourteen = 0;
    int nCount = 0;

    bool bContinue = true; // Initialized as true.

    while (bContinue) // This while-loop for displaying a menu, after the functions are done, will continue to display
    {                 // until bContinue equals to false, which is in case 5 or the exit function.
        int nChoice;

        displayHeader();
        displayMenu(&nChoice);

        // Checks if the input for the menu is not either of the integers 1, 2, 3, 4, or 5.
        if (!(nChoice == 1) && !(nChoice == 2) && !(nChoice == 3) && !(nChoice == 4) && !(nChoice == 5))
        {
            printf("\n**---------------------------------------------------------------------**\n\n");
            printf("\t\t\t      Invalid input.\n\n");
            printf("\t       Please choose from the [1-5] menu. Thank you!\n\n");
            printf("\t\t Please run the program again to continue.\n");
            printf("\n**---------------------------------------------------------------------**\n\n");
            bContinue = false; // If the input satisfies the if-statement, the program will terminate.
        }
        else
        {
            switch (nChoice) // The value from the displayMenu() function will be passed and will be the basis input of the switch
                             // statement.
            {
                // Book a Seat
                case 1:
                    displaySchedule(nDefaultTime);
                    displayBus(&seat, &nSeatOne, &nSeatTwo, &nSeatThree, &nSeatFour, &nSeatFive, &nSeatSix, &nSeatSeven,
                               &nSeatEight, &nSeatNine, &nSeatTen, &nSeatEleven, &nSeatTwelve, &nSeatThirteen, &nSeatFourteen);
                    bookSeat(&seat, &nSeatOne, &nSeatTwo, &nSeatThree, &nSeatFour, &nSeatFive, &nSeatSix, &nSeatSeven, &nSeatEight,
                             &nSeatNine, &nSeatTen, &nSeatEleven, &nSeatTwelve, &nSeatThirteen, &nSeatFourteen, &studentID,
                             &nCount);
                    displaySeats(&seat, &nSeatOne, &nSeatTwo, &nSeatThree, &nSeatFour, &nSeatFive, &nSeatSix, &nSeatSeven,
                                 &nSeatEight, &nSeatNine, &nSeatTen, &nSeatEleven, &nSeatTwelve, &nSeatThirteen, &nSeatFourteen,
                                 &studentID, &nCount);
                    displayBus(&seat, &nSeatOne, &nSeatTwo, &nSeatThree, &nSeatFour, &nSeatFive, &nSeatSix, &nSeatSeven,
                               &nSeatEight, &nSeatNine, &nSeatTen, &nSeatEleven, &nSeatTwelve, &nSeatThirteen, &nSeatFourteen);
                    break;

                // Cancel Booking
                case 2:
                    displaySchedule(nDefaultTime);
                    displayBus(&seat, &nSeatOne, &nSeatTwo, &nSeatThree, &nSeatFour, &nSeatFive, &nSeatSix, &nSeatSeven,
                               &nSeatEight, &nSeatNine, &nSeatTen, &nSeatEleven, &nSeatTwelve, &nSeatThirteen, &nSeatFourteen);
                    cancelBook(&seat, &nSeatOne, &nSeatTwo, &nSeatThree, &nSeatFour, &nSeatFive, &nSeatSix, &nSeatSeven,
                               &nSeatEight, &nSeatNine, &nSeatTen, &nSeatEleven, &nSeatTwelve, &nSeatThirteen, &nSeatFourteen,
                               &studentID, &nCount);
                    displaySeats(&seat, &nSeatOne, &nSeatTwo, &nSeatThree, &nSeatFour, &nSeatFive, &nSeatSix, &nSeatSeven,
                                 &nSeatEight, &nSeatNine, &nSeatTen, &nSeatEleven, &nSeatTwelve, &nSeatThirteen, &nSeatFourteen,
                                 &studentID, &nCount);
                    displayBus(&seat, &nSeatOne, &nSeatTwo, &nSeatThree, &nSeatFour, &nSeatFive, &nSeatSix, &nSeatSeven,
                               &nSeatEight, &nSeatNine, &nSeatTen, &nSeatEleven, &nSeatTwelve, &nSeatThirteen, &nSeatFourteen);
                    break;

                // Show Schedule
                case 3:
                    displaySchedule(nDefaultTime);
                    break;

                // Update Departure Time
                case 4:
                    updateSchedule(&nDefaultTime, &seat, &nSeatOne, &nSeatTwo, &nSeatThree, &nSeatFour, &nSeatFive, &nSeatSix,
                                   &nSeatSeven, &nSeatEight, &nSeatNine, &nSeatTen, &nSeatEleven, &nSeatTwelve, &nSeatThirteen,
                                   &nSeatFourteen, &nCount);
                    break;

                // Close Application
                case 5:
                    displayCount(&nCount); // Displays the current number of reserved seats before exiting.

                    // do-while loop continues if the input is neither 1 nor 0.
                    do
                    {
                        getchar();
                        // Asks for the exit confirmation of the user.
                        printf("    Upon closing the application, all unsaved changes will be deleted.\n");
                        printf("\n\t   Are you sure you want to exit? [1] Yes / [0] No - ");
                        scanf("%d", &exitApp);

                        if (exitApp == 1)
                        {
                            printf("\n**---------------------------------------------------------------------**\n\n");
                            printf("\t          Thank you for using the application!\n");
                            printf("\n**---------------------------------------------------------------------**\n\n");
                            bContinue = false; // If bContinue becomes false, the while-loop will stop and the program will exit.
                        }
                        else if (exitApp == 0)
                        {
                            // Do nothing, lets the loop continue.
                        }
                        else
                        {
                            printf("\n**---------------------------------------------------------------------**\n\n");
                            printf("Invalid choice. Please enter 1 for Yes or 0 for No.\n");
                        }
                        break;
                    }
                    while (!(exitApp == 1) && !(exitApp == 0));
            }
        }
    }

    return 0; // End of program.
}