package lotto;

import java.util.Arrays;

public enum LottoRank {
    FIRST(2_000_000_000, 6),
    SECOND(30_000_000, 5, true),
    THIRD(1_500_000, 5),
    FOURTH(50000, 4),
    FIFTH(5000, 3),
    NO_RANK(0, 0);

    private final int prize;
    private final int requiredMatchCount;
    private final boolean bonusNumberMatchRequired;

    LottoRank(int prize, int requiredMatchCount) {
        this(prize, requiredMatchCount, false);
    }
    LottoRank(int prize, int requiredMatchCount, boolean bonusNumberMatchRequired) {
        this.prize = prize;
        this.requiredMatchCount = requiredMatchCount;
        this.bonusNumberMatchRequired = bonusNumberMatchRequired;
    }

    public int getPrize() {
        return prize;
    }

    public int getRequiredMatchCount() {
        return requiredMatchCount;
    }

    public boolean isBonusNumberMatchRequired() {
        return bonusNumberMatchRequired;
    }

    public static LottoRank getRank(long matchCount, boolean isBonusNumberMatched) {
        return Arrays.stream(values())
                .filter((rank) -> {
                    return rank.requiredMatchCount == matchCount &&
                            (!rank.bonusNumberMatchRequired || isBonusNumberMatched);
                })
                .findFirst()
                .orElse(LottoRank.NO_RANK);
    }
}
