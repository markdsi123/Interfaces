import java.util.ArrayList;

/**
 *
 * @author mark
 */
public class ShortWordFilter implements Filter
{


    private String word;

    ShortWordFilter(){}

    ShortWordFilter(String word)
    {
        this.word = word;
    }

    public void setWord(String word)
    {
        this.word = word;
    }

    public String getWord()
    {
        return word;
    }

    public boolean accept(Object arg)
    {
        if (( (String) arg ).length() < 5)  return true;
        return false;
    }

    public static  ArrayList<Object> collectAll(ArrayList<Object> inputString, Filter f)
    {
        ArrayList<Object> resultList = new ArrayList<>();
        for (Object word : inputString) if(f.accept(word)) resultList.add(word);
        return resultList;
    }
}