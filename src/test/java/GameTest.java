import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    public void secondPlayerWin() {
        Player vasya = new Player(12, "Вася", 120);
        Player kolya = new Player(19, "Коля", 100);
        Player misha = new Player(25, "Миша", 150);
        Game game = new Game();

        game.register(vasya);
        game.register(kolya);
        game.register(misha);
        int actual = game.round("Коля", "Вася");
        int expected = 2;
        Assertions.assertEquals(expected, actual);
    }


    @Test
    public void firstPlayerWin() {
        Player vasya = new Player(12, "Вася", 120);
        Player kolya = new Player(19, "Коля", 100);
        Game game = new Game();

        game.register(vasya);
        game.register(kolya);
        int actual = game.round("Вася", "Коля");
        int expected = 1;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void strengthEqual() {
        Player vasya = new Player(12, "Вася", 100);
        Player kolya = new Player(19, "Коля", 100);
        Game game = new Game();

        game.register(vasya);
        game.register(kolya);
        int actual = game.round("Вася", "Коля");
        int expected = 0;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void firstPlayerNotExist() {
        Player vasya = new Player(12, "Вася", 100);
        Player kolya = new Player(19, "Коля", 100);
        Game game = new Game();

        game.register(kolya);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Антон", "Коля")
        );
    }

    @Test
    public void secondPlayerNotExist() {
        Player vasya = new Player(12, "Вася", 100);
        Player kolya = new Player(19, "Коля", 100);
        Game game = new Game();

        game.register(vasya);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Вася", "Толя")
        );
    }

    @Test
    public void PlayerNotExist() {
        Player vasya = new Player(12, "Вася", 100);
        Player kolya = new Player(19, "Коля", 100);
        Game game = new Game();

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Федя", "Толя")
        );
    }


}
