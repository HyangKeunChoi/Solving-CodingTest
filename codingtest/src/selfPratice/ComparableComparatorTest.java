package selfPratice;

import java.util.Arrays;
import java.util.Comparator;

// https://st-lab.tistory.com/243
// Arrays.sort와 Collections.sort()는 모두 오름차순으로 정렬된다.
// o1 : 선행 원소, o2, 후행 원소
// o1 - o2가 음수가 나오면 위치를 바꾸지 않는다.(오름차순일떄)
// 양수가 나오면 위치를 바꾼다.

// 좀더 읽어보기 좋은글 https://hianna.tistory.com/569
// https://jamesdreaming.tistory.com/162
public class ComparableComparatorTest {

    public static void main(String[] args) {

        TestClass[] testClass = new TestClass[10];
        for (int i = 0; i < 10; i++) {
            testClass[i] = new TestClass((int)(Math.random()*100));
        }

        // 정렬 전
        for(int i = 0; i < 10; i++) {
            System.out.print(testClass[i].value + " ");
        }

        System.out.println();

        // comparator로 구현할때는 두번째 인자로 comparator넘겨줘야 한다.
        Arrays.sort(testClass, comparator);

        // 이런식으로도 정렬 가능
        /*Arrays.sort(testClass, new Comparator<TestClass>() {
            @Override
            public int compare(TestClass testClass, TestClass t1) {
                return 0;
            }
        });*/

        // 정렬 이후
        System.out.print("정렬 후 : ");
        for(int i = 0; i < 10; i++) {
            System.out.print(testClass[i].value + " ");
        }
        System.out.println();

}

    // 익명 클래스로 구현
    static Comparator comparator = new Comparator<TestClass>() {
        @Override
        public int compare(TestClass o1, TestClass o2) {
            return o2.value - o1.value;
        }
    };
}

/*class TestClass implements Comparable<TestClass> {

    int value;

    public TestClass(int value) {
        this.value = value;
    }

    @Override
    public int compareTo(TestClass o) {
        // return this.value - o.value; // 오름차순
        return o.value - this.value ; // 바꾸면 내림차순 됨
    }
}*/

class TestClass {
    int value;

    public TestClass(int value) {
        this.value = value;
    }
}