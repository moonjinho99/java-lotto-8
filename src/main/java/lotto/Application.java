package lotto;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        int lottoCnt = inputView.retryUntilVaild(inputView::getLottoCnt);
        OutputView outputView = new OutputView(lottoCnt);

        inputView.retryUntilVaild(inputView::getWinningNumbers);
        inputView.retryUntilVaild(inputView::getBonusNumber);
    }
}
