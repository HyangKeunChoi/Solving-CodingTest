package programmers.withDayoung.week11;


import java.util.*;

// BFS/DFS
// 여행경로
public class Problem_1_fail {

    static boolean[] checked;
    static List<Ticket> ticketList;
    static Queue<Ticket> queue;
    static List<String> answer;

    public static void main(String[] args) {

        String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};

        checked = new boolean[tickets.length + 1];
        ticketList = new ArrayList();
        answer = new ArrayList();

        for (int i = 0; i < tickets.length; i++) {
            ticketList.add(new Ticket(tickets[i]));
        }

        Problem_1_fail problem1 = new Problem_1_fail();

        queue = new LinkedList<>();
        for (int i = 0; i < ticketList.size(); i++) {
            if ("ICN".equals(ticketList.get(i))) {
                // ICN으로 시작하는것을 넣는다
                queue.offer(ticketList.get(i));
                checked[i + 1] = true;
                answer.add(ticketList.get(i).a);
                answer.add(ticketList.get(i).b);

                problem1.solution(tickets);

                // 다시 복귀
                checked[i + 1] = false;
            }
        }

        System.out.println(answer);
    }

    public String[] solution(String[][] tickets) {

        while (!queue.isEmpty()) {
            Ticket poll = queue.poll();
            for (int i = 0; i < tickets.length; i++) {

                // 정답의 길이가 아닐떄 까지
                if (answer.size() != (tickets.length * 2) - 2) {
                    if (poll.b.equals(tickets[i][0]) && checked[i + 1] == false) {
                        checked[i + 1] = true;
                        queue.offer(new Ticket(tickets[i]));
                        answer.add(tickets[i][0]);
                        answer.add(tickets[i][1]);
                    } else if(!poll.b.equals(tickets[i][0])){
                        checked[i + 1] = false;
                        answer.remove(tickets[i][0]);
                        answer.remove(tickets[i][1]);
                    }
                } else {
                    return answer.toArray(new String[(tickets.length * 2) - 2]);
                }
            }
        }

        // return new String[0];
        return answer.toArray(new String[(tickets.length * 2) - 2]);
    }
}

class Ticket {
    String a;
    String b;

    public Ticket(String[] a) {
        this.a = a[0];
        this.b = a[1];
    }
}