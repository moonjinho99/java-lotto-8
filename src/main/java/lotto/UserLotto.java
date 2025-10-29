package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserLotto {

    private List<List<Integer>> userLottos;

    public UserLotto(int cnt)
    {
        userLottos = new ArrayList<>();
        createUserLottos(cnt);
    }

    private void createUserLottos(int cnt)
    {
        for(int i=0; i<cnt; i++)
        {
            List<Integer> lottoList = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(lottoList);
            userLottos.add(new ArrayList<>(lottoList));
        }
    }

    public List<List<Integer>> getUserLottos()
    {
        return this.userLottos;
    }
}
