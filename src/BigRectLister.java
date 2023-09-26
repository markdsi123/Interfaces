import java.awt.*;
import java.util.ArrayList;

public class BigRectLister {

    public static void main(String[] args) {
        ArrayList<Object> rects=new ArrayList<Object> ();

        rects.add(new Rectangle(2,1));
        rects.add(new Rectangle(2,2));
        rects.add(new Rectangle(3,6));
        rects.add(new Rectangle(4,4));
        rects.add(new Rectangle(1,2));
        rects.add(new Rectangle(1,3));
        rects.add(new Rectangle(8,4));
        rects.add(new Rectangle(2,3));
        rects.add(new Rectangle(2,4));
        rects.add(new Rectangle(6,5));
        System.out.println(" List of the Rectangles:");
        for(Object o:rects)
        {
            Rectangle r=(Rectangle)o;
            System.out.println(r);
        }
        Filter f = null;
        rects=BigRectangleFilter.collectAll(rects,f);

        System.out.println("List of the rectangles that have big perimeter: ");
        for(Object o:rects)
        {
            Rectangle r=(Rectangle)o;
            System.out.println(r);
        }

    }

}