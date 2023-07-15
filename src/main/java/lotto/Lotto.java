package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또는 6개의 번호로 구성되어야 합니다.");
        }

        Set<Integer> numberSet = new HashSet<>();
        for (int number : numbers) {
            if (!isLottoNumber(number)) {
                throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
            if (!numberSet.add(number)) {
                throw new IllegalArgumentException("로또의 번호들은 중복되면 안됩니다.");
            }
        }
    }

    public static boolean isLottoNumber(int number) {
        return number >= 1 && number <= 45;
    }
}
