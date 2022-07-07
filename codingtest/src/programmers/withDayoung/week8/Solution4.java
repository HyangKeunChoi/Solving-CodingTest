package programmers.withDayoung.week8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/*
 * 세개의 수 비교
 */
public class Solution4 {

    public static void main(String[] args) {
        
        Solution4 solution4 = new Solution4();
        System.out.println(solution4.solution(new int[]{1, 2, 3, 4, 5}));
        System.out.println(solution4.solution(new int[]{1, 3, 2, 4, 2}));
    }

    public int[] solution(int[] answers) {
        int answerLength = answers.length;

        List<Integer> oneSuPo = createOneSuPo(answerLength);
        List<Integer> twoSuPo = createTwoSuPo(answerLength);
        List<Integer> threeSuPo = createThreeSuPo(answerLength);

        // TO DO  - 매칭되는 카운트 수가 맞지 않음
        AtomicInteger index = new AtomicInteger();
        AtomicInteger index2 = new AtomicInteger();
        AtomicInteger index3 = new AtomicInteger();
        int oneCount = (int) Arrays.stream(answers).filter(i -> i == oneSuPo.get(index.getAndIncrement())).count();
        int twoCount = (int) Arrays.stream(answers).filter(i -> i == twoSuPo.get(index2.getAndIncrement())).count();
        int threeCount = (int) Arrays.stream(answers).filter(i -> i == threeSuPo.get(index3.getAndIncrement())).count();
                
        Integer[] answertemp = {oneCount, twoCount, threeCount};
        answertemp = Arrays.stream(answertemp).filter(i -> i != 0 ).toArray(Integer[]::new);
        int[] answer = new int[answertemp.length];
        Arrays.sort(answertemp, Collections.reverseOrder());
        for(int j =0; j<answertemp.length; j++) {
            if(answertemp[j] != 0) {
                if (answertemp[j] == oneCount) {
                    answer[j] = 1;
                }else if (answertemp[j] == twoCount) {
                    answer[j] = 2;
                }else if (answertemp[j] == threeCount) {
                    answer[j] = 3;
                }
            }
        }
        
        return answer;
    }

    private List<Integer> createThreeSuPo(int answerLength) {
        List<Integer> supo3 = new ArrayList<>();
        for(int i = 1; i<=answerLength; i++) {
            if(i % 10 == 1 || i % 10 == 2) {
                supo3.add(3);
            }
            if(i % 10 == 3 || i % 10 == 4) {
                supo3.add(1);
            }
            if(i % 10 == 5 || i % 10 == 6) {
                supo3.add(2);
            }
            if(i % 10 == 7 || i % 10 == 8) {
                supo3.add(4);
            }
            if(i % 10 == 9 || i % 10 == 0) {
                supo3.add(5);
            }
        }
        
        return supo3;
    }

    private List<Integer> createTwoSuPo(int answerLength) {
        List<Integer> supo2 = new ArrayList<>();

        for(int i = 1; i<=answerLength; i++) {
            
            if(i % 2 == 1) {
                supo2.add(2);
            }
            if(i % 2 == 0) {
                if( i % 8 == 2) {
                    supo2.add(1);
                }
                if( i % 8 == 4) {
                    supo2.add(3);
                }
                if( i % 8 == 6) {
                    supo2.add(4);
                }
                if( i % 8 == 0) {
                    supo2.add(5);
                }
            }
            
        }
        
        return supo2;
    }

    private List<Integer> createOneSuPo(int answerLength) {
        List<Integer> supo1 = new ArrayList<>();
        for(int i = 1; i<=answerLength; i++) {
            if(i % 5 == 1) {
                supo1.add(1);    
            }
            if(i % 5 == 2) {
                supo1.add(2);
            }
            if(i % 5 == 3) {
                supo1.add(3);
            }
            if(i % 5 == 4) {
                supo1.add(4);
            }
            if(i % 5 == 0) {
                supo1.add(5);
            }
        }
        return supo1;        
    }
}
