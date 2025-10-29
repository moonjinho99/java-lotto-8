package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
public class UserLottoTest {

    @Test
    @DisplayName("입력된 개수만큼 로또 번호 리스트가 생성된다.")
    void 로또번호_초기화_테스트()
    {
        UserLotto userLotto = new UserLotto(3);
        List<List<Integer>> userLottoList = userLotto.getUserLottos();

        assertThat(userLottoList.size()).isEqualTo(3);
        for(List<Integer> lotto : userLottoList)
        {
            assertThat(lotto.size()).isEqualTo(6);
        }
    }
}
