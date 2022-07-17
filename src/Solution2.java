import java.util.List;
import java.util.ArrayList;


public class Solution2 {


    public static int solution(int total_lambs) {
        List<Integer> stingy = new ArrayList<Integer>();
        List<Integer> generous = new ArrayList<Integer>();
        stingy.add(1);
        generous.add(1);

        while(true){
            if(stingy.size()==1){
                stingy.add(stingy.get(stingy.size()-1));
            }else{
                stingy.add(stingy.get(stingy.size()-1)+stingy.get(stingy.size()-2));
            }

            if(sumUp(stingy)>total_lambs){
                stingy.remove(stingy.size()-1);
                break;
            }
        }
        while(true){
            generous.add(generous.get(generous.size()-1)*2);

            if(sumUp(generous)>total_lambs){
                generous.remove(generous.size()-1);
                break;
            }
        }

        return (stingy.size()-generous.size());

    }

    public static int sumUp(List<Integer> list){
        int total=0;
        for (int i=0; i<list.size(); i++){
            total = total +list.get(i);
        }
        return total;
    }


}
