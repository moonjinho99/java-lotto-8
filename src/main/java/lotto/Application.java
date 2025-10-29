package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        int lottoCnt = inputView.retryUntilVaild(inputView::getLottoCnt);
        OutputView outputView = new OutputView(lottoCnt);
        Lotto lotto = inputView.retryUntilVaild(inputView::getWinningLotto);
        lotto.setBonusNum(inputView.retryUntilVaild(inputView::getBonusNumber));
    }
}
