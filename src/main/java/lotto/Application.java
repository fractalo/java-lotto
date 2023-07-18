package lotto;

public class Application {
    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame();
        try {
            lottoGame.play();
        } catch(Exception e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
    }
}
