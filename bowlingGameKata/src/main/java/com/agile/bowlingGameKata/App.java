package com.agile.bowlingGameKata;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        BowlingGame bowlingGame = new BowlingGame();

        Scanner scanner =  new Scanner(System.in);

        // System.out.print("Enter Total Players/Participants: ");
        // scanner.nextInt();

        System.out.print("Enter Total Frames: ");
        int totalFrames = scanner.nextInt();

        for (int frame = 1; frame <= totalFrames; frame++) {
            if (bowlingGame.checkIfFrameIsValid(frame)) {
                System.out.println("Frame " + frame + "Started");
                int totalPinsDownPerFrame = 0;
                System.out.println("Enter Pins Down for Roll One for Frame " + frame);
                int pinsDownRollOne = scanner.nextInt();
                bowlingGame.roll(frame, 1, pinsDownRollOne);
                totalPinsDownPerFrame = totalPinsDownPerFrame + pinsDownRollOne;
                if (pinsDownRollOne < 10) {
                    System.out.println("Enter Pins Down for Roll Two for Frame " + frame);
                    int pinsDownRollTwo = scanner.nextInt();
                    bowlingGame.roll(frame, 2, pinsDownRollTwo);
                    totalPinsDownPerFrame = totalPinsDownPerFrame + pinsDownRollTwo;
                }
                if (bowlingGame.isRollScoreValid(totalPinsDownPerFrame)) {
                    if (frame == 10 && (bowlingGame.isValidStrike(frame) || bowlingGame.isValidSpare(frame))) {
                        System.out.println("Enter Pins Down for Roll Three for Frame " + frame);
                        int pinsDownRollThree = scanner.nextInt();
                        bowlingGame.roll(frame, 3, pinsDownRollThree);
                    } 
                    System.out.println("Total Score for Frame " + frame + ":" + bowlingGame.getTotalScoreForFrame(frame));
                    System.out.println("Total Cumulative Score: " + bowlingGame.getTotalScore());
                } else {
                    System.out.println("Total PinsDown can't be more than 10 per frame. Please provide valid inputs!");
                }
            } else {
                System.out.println("Please enter valid number of Frames!");
            }
        }


    }
}
