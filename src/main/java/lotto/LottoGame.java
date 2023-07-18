package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
public class LottoGame {
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
