package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckLottoTest {

    @Test
    @DisplayName("로또 수익률 계산")
    void 수익률_계산() {
        // given
        CheckLotto checkLotto = new CheckLotto(null, null);
        Map<LottoRank, Integer> resultMap = checkLotto.getResultMap();

        resultMap.put(LottoRank.FIFTH, 1);
        int amount = 8000;

        double result = checkLotto.getPricePercent(amount);

        assertEquals(62.5, result);
    }

    @Test
    @DisplayName("CheckLotto 생성 시 resultMap 초기값 검증")
    void 초기화_검증() {
        CheckLotto checkLotto = new CheckLotto(null, null);
        Map<LottoRank, Integer> resultMap = checkLotto.getResultMap();

        for (LottoRank rank : LottoRank.values()) {
            assertTrue(resultMap.containsKey(rank));
            assertEquals(0, resultMap.get(rank));
        }
    }

}
