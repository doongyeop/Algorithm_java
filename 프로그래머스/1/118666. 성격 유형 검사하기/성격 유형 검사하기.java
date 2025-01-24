class Solution {
    public String solution(String[] survey, int[] choices) {
        // RT, CF, JM, AN
        int[][] score = new int[4][2];

        for (int i = 0; i < survey.length; i++) {
            String type = survey[i];
            int choice = choices[i];
            int point = Math.abs(choice - 4);

            if (choice < 4) {
                addScore(score, type.charAt(0), point);
            } else {
                addScore(score, type.charAt(1), point);
            }
        }

        StringBuilder answer = new StringBuilder();
        answer.append(score[0][0] >= score[0][1] ? 'R' : 'T');
        answer.append(score[1][0] >= score[1][1] ? 'C' : 'F');
        answer.append(score[2][0] >= score[2][1] ? 'J' : 'M');
        answer.append(score[3][0] >= score[3][1] ? 'A' : 'N');

        return answer.toString();
    }


    void addScore(int[][] score, char c, int point) {
        switch (c) {
            case 'R': score[0][0] += point; break;
            case 'T': score[0][1] += point; break;
            case 'C': score[1][0] += point; break;
            case 'F': score[1][1] += point; break;
            case 'J': score[2][0] += point; break;
            case 'M': score[2][1] += point; break;
            case 'A': score[3][0] += point; break;
            case 'N': score[3][1] += point; break;
        }
    }
}