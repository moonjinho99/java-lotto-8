package lotto;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        inputView.retryUntilVaild(inputView::getLottoAmount);
        inputView.retryUntilVaild(inputView::getWinningNumbers);
        inputView.retryUntilVaild(inputView::getBonusNumber);
    }
}
