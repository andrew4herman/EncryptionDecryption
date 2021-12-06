package encryptdecrypt.View;

public class ConsoleOutput implements Output {

    @Override
    public void output(String text) {
        System.out.println(text);
    }
}
