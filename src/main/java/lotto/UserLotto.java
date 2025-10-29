package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserLotto {

    private List<List<Integer>> userNumbers;

    public UserLotto(int cnt)
    {
        userNumbers = new ArrayList<>();
        createUserLottos(cnt);
    }

    private void createUserLottos(int cnt)
    {
        for(int i=0; i<cnt; i++)
        {
            List<Integer> lottoList = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(lottoList);
            userNumbers.add(new ArrayList<>(lottoList));
        }
    }

    public List<List<Integer>> getUserNumbers()
    {
        return this.userNumbers;
    }
}
