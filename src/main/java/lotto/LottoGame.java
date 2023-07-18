package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

public class LottoGame {
    public void play() {
        final long purchaseAmount = readPurchaseAmount();
        final List<Lotto> purchasedLottoList = LottoStore.issueLottos(purchaseAmount);
        printPurchasedLottoList(purchasedLottoList);

        final LottoChecker lottoChecker = createLottoChecker();
        final LottoResult result = lottoChecker.checkLottoRanks(purchasedLottoList);
        printWinningStatistics(result, purchaseAmount);
    }

    private void printPurchasedLottoList(List<Lotto> lottoList) {
        System.out.printf("%d개를 구매했습니다.\n", lottoList.size());
        lottoList.forEach(lotto -> System.out.println(lotto.toString()));
        System.out.println();
    }

    private LottoChecker createLottoChecker() {
        Lotto winningLotto = readWinningLotto();
        int bonusNumber = readBonusNumber();
        return new LottoChecker(winningLotto, bonusNumber);
    }

    private void printWinningStatistics(LottoResult result, long purchaseAmount) {
        System.out.println("당첨 통계");
        System.out.println("---");
        printRankCounts(result);
        printTotalRateOfReturn(result, purchaseAmount);
    }

    private void printRankCounts(LottoResult result) {
        Arrays.stream(LottoRank.values())
                .filter(rank -> rank != LottoRank.NO_RANK)
                .sorted(Comparator.comparing(LottoRank::getPrize))
                .forEach(rank -> {
                    System.out.printf("%s - %d개\n", lottoRankToString(rank), result.getRankCount(rank));
                });
    }

    private String lottoRankToString(LottoRank rank) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(rank.getRequiredMatchCount()).append("개 일치");
        if (rank.isBonusNumberMatchRequired()) {
            stringBuilder.append(", 보너스 볼 일치");
        }
        String prize = NumberFormat.getNumberInstance().format(rank.getPrize());
        stringBuilder.append(" (").append(prize).append("원)");
        return stringBuilder.toString();
    }

    private void printTotalRateOfReturn(LottoResult result, long purchaseAmount) {
        long totalPrize = result.calculateTotalPrize();
        double totalRateOfReturn = calculateTotalRateOfReturn(totalPrize, purchaseAmount);
        System.out.printf("총 수익률은 %.1f%%입니다.\n", totalRateOfReturn);
    }

    private double calculateTotalRateOfReturn(double totalPrize, long purchaseAmount) {
        if (purchaseAmount <= 0) {
            return 0;
        }
        return (totalPrize / purchaseAmount) * 100;
    }

    private long readPurchaseAmount() {
        String line = prompt("구입 금액을 입력해 주세요.");
        try {
            return Long.parseLong(line);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("구입 금액이 숫자가 아닙니다.");
        }
    }

    private Lotto readWinningLotto() {
        String line = prompt("당첨 번호를 입력해 주세요.");
        List<Integer> numbers = new ArrayList<>();
        for (String token : line.split(",")) {
            try {
                numbers.add(Integer.parseInt(token.trim()));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("당첨 번호가 숫자가 아닙니다.");
            }
        }
        return new Lotto(numbers);
    }

    private int readBonusNumber() {
        String line = prompt("보너스 번호를 입력해 주세요.");
        try {
            return Integer.parseInt(line);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("보너스 번호가 숫자가 아닙니다.");
        }
    }

    private String prompt(String message) {
        System.out.println(message);
        String line = Console.readLine();
        System.out.println();
        return line;
    }
}
