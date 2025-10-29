package lotto;

import java.util.List;
import java.util.Map;

public class OutputView {

    public OutputView(int cnt, UserLotto userLotto)
    {
        printPurchase(cnt);
        printLotto(userLotto.getUserNumbers());
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

    public void printResult(Map<LottoRank,Integer> resultMap)
    {
        for(LottoRank rank : resultMap.keySet())
        {
            if(rank.equals(LottoRank.NONE))
                continue;

            System.out.println(rank.getMatchCount()+"개 일치 ("+String.format("%,d", rank.getPrize()) +"원) - "+resultMap.get(rank)+"개");
        }
    }

    public void printPricePercent(double percent)
    {
        System.out.println("총 수익률은 "+percent+"%입니다.");
    }
}
