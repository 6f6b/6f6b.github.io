import javax.sound.midi.MidiMessage;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Scanner;
import java.util.Vector;
public class Hello {
    public static void main(String[] args) {

        Vector<String> dayNames = new Vector<String>();
        dayNames.add("monday");
        dayNames.add("friday");
        dayNames.add("saturday");
        dayNames.add("sunday");
        dayNames.add("thurthday");
        Enumeration<String> days = dayNames.elements();
        while (days.hasMoreElements()){
            System.out.println(days.nextElement());
        }
    }
    // 比较三个值并返回最大值
    public static <T extends Comparable<T>> T maximum(T x, T y, T z)
    {
        T max = x; // 假设x是初始最大值
        if ( y.compareTo( max ) > 0 ){
            max = y; //y 更大
        }
        if ( z.compareTo( max ) > 0 ){
            max = z; // 现在 z 更大
        }
        return max; // 返回最大对象
    }
}
