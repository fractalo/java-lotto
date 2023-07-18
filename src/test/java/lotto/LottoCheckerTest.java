package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoCheckerTest {
    private static final Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    private static final LottoChecker manager = new LottoChecker(winningLotto, 7);

    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다.")
    @Test
    void createLottoManagerByDuplicatedBonusNumber() {
        assertThatThrownBy(() -> new LottoChecker(winningLotto, 6))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 로또 번호의 범위를 벗어난 경우 예외가 발생한다.")
    @Test
    void createLottoManagerByInvalidRangeBonusNumber() {
        assertThatThrownBy(() -> new LottoChecker(winningLotto, 60))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void getRankOfFirstPrizeLotto() {
        assertThat(manager.checkLottoRank(new Lotto(List.of(1, 2, 3, 4, 5, 6))))
                .isEqualTo(LottoRank.FIRST);
    }

    @Test
    void getRankOfSecondPrizeLotto() {
        assertThat(manager.checkLottoRank(new Lotto(List.of(1, 2, 3, 4, 5, 7))))
                .isEqualTo(LottoRank.SECOND);
    }

    @Test
    void getRankOfThirdPrizeLotto() {
        assertThat(manager.checkLottoRank(new Lotto(List.of(1, 2, 3, 4, 5, 8))))
                .isEqualTo(LottoRank.THIRD);
    }

    @Test
    void getRankOfFourthPrizeLotto() {
        assertThat(manager.checkLottoRank(new Lotto(List.of(1, 2, 3, 4, 9, 10))))
                .isEqualTo(LottoRank.FOURTH);
    }

    @Test
    void getRankOfFifthPrizeLotto() {
        assertThat(manager.checkLottoRank(new Lotto(List.of(1, 2, 3, 10, 11, 12))))
                .isEqualTo(LottoRank.FIFTH);
    }

    @Test
    void getRankOfNoPrizeLotto() {
        assertThat(manager.checkLottoRank(new Lotto(List.of(1, 7, 12, 13, 14, 15))))
                .isEqualTo(LottoRank.NO_RANK);
    }
}
