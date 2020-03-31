package com.agile.bowlingGameKata;

import java.util.HashMap;

public class BowlingGame {

	public HashMap<Integer,BowlingGameFrame> frameWiseRollScore = new HashMap<Integer,BowlingGameFrame>();

	public boolean getTotalFrames(int totalFrames) {
		if (totalFrames == 10) {
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

	public int sumOfTwoRollsInAFrame(int scoreOfFirstRoll, int scoreOfSecondRoll) {



		return scoreOfFirstRoll + scoreOfSecondRoll;
	}

	public int roll(Integer frame, int roll, int score) {
		
		BowlingGameFrame bowlingGameFrame = new BowlingGameFrame();
		bowlingGameFrame.setFrame(frame);
		if (roll == 1) {
			bowlingGameFrame.setScoreOfRollOne(score);
		} else {
			bowlingGameFrame.setScoreOfRollTwo(score);
		}

		frameWiseRollScore.put(frame, bowlingGameFrame);

		return score;
	}

}
