import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class BigRectLister {
    public static void main(String[] args)
    {
        ArrayList<Rectangle> rectangles = new ArrayList<>();
        BigRectangleFilter filter = new BigRectangleFilter();

        //Add rectangle value
        rectangles.add(new Rectangle(1, 2));
        rectangles.add(new Rectangle(4, 5));
        rectangles.add(new Rectangle(3, 7));
        rectangles.add(new Rectangle(1, 2));
        rectangles.add(new Rectangle(1, 2));
        rectangles.add(new Rectangle(2, 5));
        rectangles.add(new Rectangle(7, 9));
        rectangles.add(new Rectangle(1, 7));
        rectangles.add(new Rectangle(3, 6));
        rectangles.add(new Rectangle(2, 7));

        //Check if rectangle's perimeter bigger than 10
        for(Rectangle rec : rectangles)
        {
            if(filter.accept(rec))
            {
                System.out.println(rec);
            }
        }
    }
}