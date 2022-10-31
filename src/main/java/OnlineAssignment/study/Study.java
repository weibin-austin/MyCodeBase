package OnlineAssignment.study;

import lombok.Getter;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Weibin Sun
 * @create 10/29/22 11:28 PM
 */
public class Study {

    public static void main(String[] args) {
        List<Ball> list = new ArrayList<>();
        list.add(new Ball("blue", 1));
        list.add(new Ball("blue",2));
        list.add(new Ball("green",3));
        list.add(new Ball("green",4));
        list.add(new Ball("green",5));
        list.add(new Ball("green",6));
//        System.out.println(find(list));
        System.out.println(BS(list));
    }

    private static int find(List<Ball> list) {
        for(Ball ball : list) {
            if(ball.getColor().equals("green")) return ball.getId();
        }
        return -1;
    }

    private static int BS(List<Ball> list) {
        int left = 0, right = list.size() - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(list.get(mid).getColor().equals("green")) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(list.get(left).getId());
        return left;

    }
}

@Getter
class Ball {
    private String color;
    private int id;

    public Ball(String color, int id) {
        this.color = color;
        this.id = id;
    }
}


class test{
    /**
     * Test:
     */
    @Test
    public void test(){
        List<Ball> list = new ArrayList<>();
        list.add(new Ball("yellow", 1));
        list.add(new Ball("blue",2));
        list.add(new Ball("red",3));
        list.add(new Ball("pink",4));
        list.add(new Ball("green",5));
        list.add(new Ball("black",6));

    }
}