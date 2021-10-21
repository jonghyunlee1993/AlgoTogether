package programmers;

public class Country124 {

    private static String[] word124 = {"4", "1", "2"};

    public static void main(String[] args) {
        int n = 41;
        String answer = solution(n);
        System.out.println("answer = " + answer);
    }

    public static String solution(int n) {
        String answer = "";

        while(n > 0){
            answer = word124[n % 3] + answer;
            n = (n - 1) / 3;
        }
        return answer;
    }


    //1	1	6	14
    //2	2	7	21
    //3	4	8	22
    //4	11	9	24
    //5	12	10	41
    //11 -> 42
    //12 -> 44
    //13 -> 111
    //14 -> 112
    //15 -> 114
    //16 -> 121
    //17 -> 122
    //18 -> 124
    //19 -> 141
    //20 -> 142
    //21 -> 144
    //22 -> 211
    //23 -> 212
    //24 -> 214
    //25 -> 221
    //26 -> 222
    //27 -> 224
    //28 -> 241
    //29 -> 242
    //30 -> 244
    //31 -> 411
    //32 -> 412
    //33 -> 414
    //34 -> 421
    //35 -> 422
    //36 -> 424
    //37 -> 441
    //38 -> 442
    //39 -> 444
    //40 -> 1111
    //41 -> 1112



}
