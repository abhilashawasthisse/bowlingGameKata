package com.agile.bowlingGameKata;

import java.util.HashMap;

public class BowlingGame {

	public HashMap<Integer,BowlingGameFrame> frameWiseRollScore = new HashMap<Integer,BowlingGameFrame>();

	public boolean checkIfFrameIsValid(int currentFrame) {
		if (currentFrame > 0 && currentFrame <= 10) {
			return true;
		}
		return false;
	}

	public boolean checkIfRollsPerFrameAreValid(int rolls) {
		if (rolls == 2) {
			return true;
		}
		return false;
	}

	public boolean isRollScoreValid(int score) {
		if (score <= 10) {
			return true;
		}
		return false;
	}

	public int roll(Integer frame, int roll, int score) {
		
		if (checkIfFrameIsValid(frame) && isRollScoreValid(score)) {

			
			if (roll == 1) {

				BowlingGameFrame bowlingGameFrame = new BowlingGameFrame();
				bowlingGameFrame.setFrame(frame);
				bowlingGameFrame.setScoreOfRollOne(score);
				
				frameWiseRollScore.put(frame, bowlingGameFrame);

			} else if(roll == 2) {

				BowlingGameFrame bowlingGameFrame = frameWiseRollScore.get(frame);
				bowlingGameFrame.setScoreOfRollTwo(score);

				frameWiseRollScore.put(frame, bowlingGameFrame);
			} else if(roll == 3){

				BowlingGameFrame bowlingGameFrame = frameWiseRollScore.get(frame);
				bowlingGameFrame.setScoreOfRollThreeForLastFrame(score);

				frameWiseRollScore.put(frame, bowlingGameFrame);

			}

		}

		return score;
	}

	public int sumOfTwoRollsInAFrame(int frame) {

		BowlingGameFrame bowlingGameFrame = frameWiseRollScore.get(frame);

		int scoreOfFirstRoll = bowlingGameFrame.getScoreOfRollOne();
		
		int scoreOfSecondRoll = bowlingGameFrame.getScoreOfRollTwo();
		
		int totalScore = scoreOfFirstRoll + scoreOfSecondRoll;
		
		return totalScore;
	}

	public int getTotalScoreForNormalPlay(Integer totalFrames) {

		int totalSum = 0;

		for (Integer frame = 1; frame <= totalFrames; frame++) {
			
			if(isValidSpare(frame) ){
				int bonus=0;
				if(frame == 10){
					 bonus= frameWiseRollScore.get(frame).getScoreOfRollThreeForLastFrame();
				}else{
					bonus = frameWiseRollScore.get(frame+1).getScoreOfRollOne();
				}
				totalSum += sumOfTwoRollsInAFrame(frame) + bonus ;
				

			}else{

			totalSum += sumOfTwoRollsInAFrame(frame);
			}
			
		}
		return totalSum;
	}

	public boolean isValidSpare(int i) {
		int sumOfScore = sumOfTwoRollsInAFrame(i);
		
		
		if(sumOfScore==10){

		return true;
		}else
		return false;
	}

	
}
