import java.awt.*;
import java.util.ArrayList;

public class BigRectangleFilter implements Filter{

    @Override
    public boolean accept(Object x) {

        Rectangle rec=(Rectangle)x;
        double perimeter=2*(rec.height+rec.width); // calculate perimeter
        if(perimeter>10)
            return true;
        return false;
    }

    public static ArrayList<Object> collectAll(ArrayList<Object> rects, Filter f){

        ArrayList<Object> all=new ArrayList<Object>();
        f=new BigRectangleFilter();
        for(Object x:rects)
        {
            if(f.accept(x))
                all.add(x);
        }
        return all;
    }

}
