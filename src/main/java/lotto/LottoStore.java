package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoStore {
    private static final int PRICE = 1000;

    private static Lotto generateLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers);
    }

    public static List<Lotto> issueLottos(long purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);
        List<Lotto> lottoList = new ArrayList<>();
        for (long i = 0; i < purchaseAmount / PRICE; ++i) {
            lottoList.add(generateLotto());
        }
        return lottoList;
    }

    private static void validatePurchaseAmount(long purchaseAmount) {
        if (purchaseAmount < 0) {
            throw new IllegalArgumentException("구입 금액은 음수일 수 없습니다.");
        }
        if (purchaseAmount % PRICE != 0) {
            throw new IllegalArgumentException("구입 금액은 1,000원 단위여야 합니다.");
        }
    }
}
