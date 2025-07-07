import java.util.Arrays;
import java.util.List;

public class Stream {
    public static void main(String[] args) {
        List<Integer> list =Arrays.asList(null,2,8,4,5,6,7,8,9,1,10);
        list.stream()
        .filter(i->i!=null)
        .map(n->n*2)
        .sorted()
        .forEach(n -> System.out.print(n + " "));
       

        
    }
}
