package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoStoreTest {
    @Test
    void issueLottosByNonDivisiblePurchaseAmount() {
        assertThatThrownBy(() -> LottoStore.issueLottos(7500))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void issueLottosByNegativePurchaseAmount() {
        assertThatThrownBy(() -> LottoStore.issueLottos(-5000))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
