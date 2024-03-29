package baseball.controller;

import baseball.model.Referee;
import baseball.model.baseballnumber.BaseballNumbers;
import baseball.model.baseballnumber.RandomNumbersFactory;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballController {
    private static final int THREE_STRIKE_CONDITION = 3;
    private static final int STANDARD = 0;

    private final OutputView outputView;
    private final InputView inputView;
    private final Referee referee;

    private RandomNumbersFactory randomNumbers;

    public BaseballController() {
        outputView = new OutputView();
        randomNumbers = new RandomNumbersFactory();
        inputView = new InputView();
        referee = new Referee();
    }

    public void start() {
        boolean isPlaying = true;
        outputView.printStartGameMessage();
        while (isPlaying) {
            BaseballNumbers computerNumbersList = new BaseballNumbers(randomNumbers.create());
            BaseballNumbers userNumbersList = new BaseballNumbers(inputView.printNumbersMessage());
            int ballCountNumber = referee.ballCount(computerNumbersList, userNumbersList);
            int strikeCountNumber = referee.strikeCount(computerNumbersList, userNumbersList);
            printResult(ballCountNumber, strikeCountNumber);
            if (strikeCountNumber == THREE_STRIKE_CONDITION) {
                outputView.printInputGameRestartMessage();
                isPlaying = inputView.isPlaying();
                randomNumbers = new RandomNumbersFactory();
                randomNumbers.create();
            }
        }
    }

    private void printResult(int countBall, int countStrike) {
        ballAndStrikeNothing(countBall, countStrike);
        ballOrStrike(countBall, countStrike);
        threeStrike(countStrike);
    }

    private void ballAndStrikeNothing(int ballCount, int strikeCount) {
        if (ballCount == STANDARD && strikeCount == STANDARD) {
            outputView.printNothing();
        }
    }

    private void ballOrStrike(int ballCount, int strikeCount) {
        if (ballCount > STANDARD && strikeCount == STANDARD) {
            outputView.printBall(ballCount);
        }
        if (strikeCount > STANDARD && ballCount == STANDARD) {
            outputView.printStrike(strikeCount);
        }
        if (ballCount > STANDARD && strikeCount > STANDARD) {
            outputView.printBallAndStrike(ballCount, strikeCount);
        }
    }

    private void threeStrike(int strikeCount) {
        if (strikeCount == THREE_STRIKE_CONDITION) {
            outputView.printThreeStrike();
        }
    }
}