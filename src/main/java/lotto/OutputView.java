package lotto;

import java.util.List;

public class OutputView {

    private UserLotto userLotto;

    public OutputView(int cnt)
    {
        printPurchase(cnt);
        userLotto = new UserLotto(cnt);
        printLotto(userLotto.getUserLottos());
    }

    private void printPurchase(int cnt)
    {
        System.out.println(cnt+"개 구매했습니다.");
    }

    private void printLotto(List<List<Integer>> userLottos)
    {
        for(List<Integer> lotto : userLottos)
        {
            System.out.println(lotto.toString());
        }
    }

    public void printResult()
    {

    }

}
