package lotto;

import java.util.HashSet;
import java.util.Set;

public class LottoManager {
    private final Set<Integer> winningNumbers;
    private final int bonusNumber;

    public LottoManager(Lotto winningLotto, int bonusNumber) {
        this.winningNumbers = new HashSet<>(winningLotto.getNumbers());
        this.bonusNumber = bonusNumber;
    }

    private long getMatchCount(Lotto lotto) {
        return lotto.getNumbers().stream()
                .filter(winningNumbers::contains)
                .count();
    }

    private boolean isBonusNumberMatched(Lotto lotto) {
        return lotto.getNumbers().contains(bonusNumber);
    }


}
