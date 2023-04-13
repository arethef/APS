package lv3.깊이너비우선탐색DFSBFS.단어변환;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";
        String[] words = new String[]{"hot", "dot", "dog", "lot", "log", "cog"};
        System.out.println(solution(begin, target, words));
    }

    public static int solution(String begin, String target, String[] words) {
        int answer = 0;
        if (Arrays.stream(words).noneMatch(s -> s.equals(target))) {
            return answer;
        }
        Queue<Word> q = new ArrayDeque<>();
        q.offer(new Word(begin, 0));
        while (!q.isEmpty()) {
            Word curr = q.poll();
            if (curr.str.equals(target)) {
                answer = curr.stage;
                break;
            }
            Arrays.stream(words).forEach(s -> {
                int diff = 0;
                for (int i=0; i<s.length(); i++) {
                    if (curr.str.charAt(i)!=s.charAt(i)) {
                        diff++;
                    }
                }
                if (diff<=1) {
                    q.offer(new Word(s, curr.stage+1));
                }
            });
        }
        return answer;
    }

    static class Word {
        String str;
        int stage;
        Word(String str, int stage) {
            this.str = str;
            this.stage = stage;
        }
    }
}
