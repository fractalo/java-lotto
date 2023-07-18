package lotto;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {
    private static final LottoResult lottoResult = new LottoResult();
    
    @BeforeAll
    static void init() {
        lottoResult.addRank(LottoRank.FOURTH);
        lottoResult.addRank(LottoRank.FOURTH);
        lottoResult.addRank(LottoRank.FIFTH);
    }

    @Test
    void getRankCount() {
        assertThat(lottoResult.getRankCount(LottoRank.FOURTH))
                .isEqualTo(2L);
        assertThat(lottoResult.getRankCount(LottoRank.FIFTH))
                .isEqualTo(1L);
    }

    @Test
    void calculateTotalPrize() {
        assertThat(lottoResult.calculateTotalPrize())
                .isEqualTo(105000L);
    }
}
