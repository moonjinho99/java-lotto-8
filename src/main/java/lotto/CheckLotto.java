package lotto;

import java.util.*;

public class CheckLotto {

    private Lotto lotto;
    private UserLotto userLotto;
    private Map<LottoRank,Integer> resultMap;

    public CheckLotto(Lotto lotto, UserLotto userLotto)
    {
        this.lotto = lotto;
        this.userLotto = userLotto;
        resultMap =  new TreeMap<>(Comparator.comparing(LottoRank::ordinal).reversed());
        resultMap.put(LottoRank.FIRST,0);
        resultMap.put(LottoRank.SECOND,0);
        resultMap.put(LottoRank.THIRD,0);
        resultMap.put(LottoRank.FOURTH,0);
        resultMap.put(LottoRank.FIFTH,0);
        resultMap.put(LottoRank.NONE,0);
    }

    public void check()
    {
        List<Integer> winningNumbers = lotto.getNumbers();
        int bonusNum = lotto.getBonusNum();
        List<List<Integer>> userNumbers = userLotto.getUserNumbers();

        for(List<Integer> userNumber : userNumbers)
        {
            int winCnt = 0;
            int bonusCnt = 0;
            for(int num : userNumber)
            {
                if(winningNumbers.contains(num))
                    winCnt++;

                if(num == bonusNum)
                    bonusCnt++;
            }

            inputRank(winCnt, bonusCnt);
        }

    }

    private void inputRank(int winCnt, int bonusCnt)
    {
        int total = winCnt + bonusCnt;
        boolean bonusMatch = false;
        if(bonusCnt != 0)
            bonusMatch = true;

        LottoRank lottoRank = LottoRank.valueOf(total, bonusMatch);
        resultMap.put(lottoRank,resultMap.get(lottoRank)+1);

    }

    public double getPricePercent(int amount)
    {
        int sum = 0;
        for(LottoRank rank : resultMap.keySet())
        {
            sum += rank.getPrize() * resultMap.get(rank);
        }

        double percent = (double) sum / amount * 100;

        return Math.round(percent*10) / 10.0;
    }

    public Map<LottoRank,Integer> getResultMap()
    {
        return this.resultMap;
    }
}
