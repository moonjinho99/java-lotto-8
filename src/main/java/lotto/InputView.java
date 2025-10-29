package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import camp.nextstep.edu.missionutils.Console;


public class InputView {

    private Lotto lotto;

    public int getAmount()
    {
        System.out.println("구입금액을 입력해 주세요.");
        int amount = Integer.parseInt(Console.readLine());

        if(amount % 1000 != 0)
        {
            throw new IllegalArgumentException("[ERROR] 금액은 1000단위로 입력해야 합니다.");
        }

        return amount;
    }

    public Lotto getWinningLotto()
    {
        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> winningNumbers = new ArrayList<>();
        String[] inputs = Console.readLine().split(",");

        for(String input : inputs) {
            int num = Integer.parseInt(input);

            if(num < 1 || num > 45)
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");

            if(winningNumbers.contains(num))
                throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");

            winningNumbers.add(num);

        }
        lotto = new Lotto(winningNumbers);

        return lotto;
    }

    public int getBonusNumber()
    {
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine());
        if(bonusNumber < 1 || bonusNumber > 45)
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");

        if(lotto.checkDuplicationBonusNum(bonusNumber))
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");

        return bonusNumber;
    }

    public <T> T retryUntilVaild(Supplier<T> action)
    {
        while(true) {
            try{
                return action.get();
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            } catch (IllegalStateException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
