public class Levenshtein {

    public static int min3(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }

    public static int compute_distance(String s1, String s2){

        int len1 = s1.length();
        int len2 = s2.length();

        int[][] table = new int[len1 + 1][len2 + 1];

        for(int i = 0; i <= len1; i++){
            for(int j = 0; j <= len2; j++){

                if(i == 0){
                    table[0][j] = j;
                }
                else if(j == 0){
                    table[i][0] = i;
                }

                else{

                    int up = table[i -1][j];
                    int left = table[i][j - 1];
                    int diagonal = table[i - 1][j - 1];

                    if(s1.charAt(i - 1) == s2.charAt(j - 1)){
                        table[i][j] = diagonal;
                    } else{
                        table[i][j] = min3(up + 1, left + 1, diagonal + 1);
                    }
                }
            }
        }

        return table[len1][len2];
    }


    public static void main(String[] args) {

        String s1 = "bad";
        String s2 = "bed";
        int distance = compute_distance(s1, s2);

        System.out.println("The distance between \"" + s1 + "\" and \"" + s2 + "\" is: " + distance);
    }
}
