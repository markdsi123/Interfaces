import java.awt.*;

public interface Filter {
    boolean accept(String word);
    boolean accept(Rectangle x);
}