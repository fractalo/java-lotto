package lotto;

import java.util.EnumMap;
import java.util.Map;

public class LottoResult {
    private final Map<LottoRank, Long> rankCounter = new EnumMap<>(LottoRank.class);

    public void addRank(LottoRank rank) {
        rankCounter.merge(rank, 1L, Long::sum);
    }

    public Long getRankCount(LottoRank rank) {
        return rankCounter.getOrDefault(rank, 0L);
    }

    public Long calculateTotalPrize() {
        return rankCounter.entrySet().stream()
                .mapToLong(entry -> entry.getKey().getPrize() * entry.getValue())
                .reduce(0, Long::sum);
    }
}
