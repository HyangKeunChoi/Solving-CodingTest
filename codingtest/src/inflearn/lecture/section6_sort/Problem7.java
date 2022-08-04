package inflearn.lecture.section6_sort;

// 좌표 정렬(compareTO)
// (x,y)
// x가 같으면 y를 기준으로 정렬
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Problem7 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Point> arrayList = new ArrayList();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            arrayList.add(new Point(x, y));
        }

        // 정렬
        Collections.sort(arrayList);
        for (Point o: arrayList) {
            System.out.println(o.x + " " + o.y);
        }
    }
}

class Point implements Comparable<Point>{

    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point o) {
        if(o.x == this.x) {

            // 음수가 나와야 오름차순 정렬
          return this.y-o.y;
        }
        else {
            return this.x- o.x;
        }
    }
}