import java.awt.*;
public class ShortWordFilter implements Filter {
    @Override
    public boolean accept(String word)
    {
        //Accept words with a length <5
        return word.length() < 5;
    }
    @Override
    public boolean accept(Rectangle x) {
        return false;
    }
}