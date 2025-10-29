package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        int amount = inputView.retryUntilVaild(inputView::getAmount);

        int lottoCnt = amount/1000;
        UserLotto userLotto = new UserLotto(lottoCnt);
        OutputView outputView = new OutputView(lottoCnt, userLotto);

        Lotto lotto = inputView.retryUntilVaild(inputView::getWinningLotto);
        lotto.setBonusNum(inputView.retryUntilVaild(inputView::getBonusNumber));

        CheckLotto checkLotto = new CheckLotto(lotto,userLotto);
        checkLotto.check();

        outputView.printResult(checkLotto.getResultMap());
        outputView.printPricePercent(checkLotto.getPricePercent(amount));
    }
}
