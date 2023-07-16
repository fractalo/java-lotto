package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoRankTest {
    @Test
    void getFirstRankByNumberMatchResult() {
        assertThat(LottoRank.getRank(6, true))
                .isEqualTo(LottoRank.FIRST);
        assertThat(LottoRank.getRank(6, false))
                .isEqualTo(LottoRank.FIRST);
    }

    @Test
    void getSecondRankByNumberMatchResult() {
        assertThat(LottoRank.getRank(5, true))
                .isEqualTo(LottoRank.SECOND);
    }

    @Test
    void getThirdRankByNumberMatchResult() {
        assertThat(LottoRank.getRank(5, false))
                .isEqualTo(LottoRank.THIRD);
    }

    @Test
    void getFourthRankByNumberMatchResult() {
        assertThat(LottoRank.getRank(4, true))
                .isEqualTo(LottoRank.FOURTH);
        assertThat(LottoRank.getRank(4, false))
                .isEqualTo(LottoRank.FOURTH);
    }

    @Test
    void getFifthRankByNumberMatchResult() {
        assertThat(LottoRank.getRank(3, true))
                .isEqualTo(LottoRank.FIFTH);
        assertThat(LottoRank.getRank(3, false))
                .isEqualTo(LottoRank.FIFTH);
    }

    @Test
    void getNoRankByNumberMatchResult() {
        assertThat(LottoRank.getRank(2, false))
                .isEqualTo(LottoRank.NO_RANK);
        assertThat(LottoRank.getRank(1, true))
                .isEqualTo(LottoRank.NO_RANK);
    }
}
