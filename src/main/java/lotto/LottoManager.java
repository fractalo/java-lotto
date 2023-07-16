package lotto;

import java.util.HashSet;
import java.util.Set;

public class LottoManager {
    private final Set<Integer> winningNumbers;
    private final int bonusNumber;

    public LottoManager(Lotto winningLotto, int bonusNumber) {
        validate(winningLotto, bonusNumber);
        this.winningNumbers = new HashSet<>(winningLotto.getNumbers());
        this.bonusNumber = bonusNumber;
    }

    private void validate(Lotto winningLotto, int bonusNumber) {
        if (!Lotto.isLottoNumber(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        if (winningLotto.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복되면 안됩니다.");
        }
    }

    private long getMatchCount(Lotto lotto) {
        return lotto.getNumbers().stream()
                .filter(winningNumbers::contains)
                .count();
    }

    private boolean isBonusNumberMatched(Lotto lotto) {
        return lotto.getNumbers().contains(bonusNumber);
    }

    public LottoRank getLottoRank(Lotto lotto) {
        return LottoRank.getRank(getMatchCount(lotto), isBonusNumberMatched(lotto));
    }
}
