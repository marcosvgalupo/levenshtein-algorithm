public class Levenshtein {

    public static int max3(int a, int b, int c) {
        return 
            Math.max(0,
                Math.max(
                        Math.max(a, b), c)
            );
    }

    public static int compute_distance(String s1, String s2){

        String formula1[] = s1.split(" ");
		String formula2[] = s2.split(" ");

        if (formula1 == null || formula2 == null)
			return 0;

        int len1 = formula1.length;
        int len2 = formula2.length;

        if (len1 == 0 || len2 == 0) // strings vazias
			return 0;
        
        if(len1 > len2){
            String[] aux = formula1;
            formula1 = formula2;
            formula2 = aux;

            len1 = len2;
            len2 = formula1.length;
        }

        int max = Integer.MIN_VALUE;

        int linha_anterior[] = new int[len1 + 1];
        int linha_atual[] = new int[len1 + 1];

        int aux[];

        for(int i = 0; i <= len1; i++)
            linha_anterior[i] = 0;

        for(int j = 1; j <= len2; j++){

            linha_atual[0] = 0; // primeira coluna

            for(int i = 1; i <= len1; i ++){

                int up = linha_anterior[i];
                int left = linha_atual[i - 1];
                int diagonal = linha_anterior[i-1];

                linha_atual[i] = max3(up + 1, left + 1, diagonal + 1);

                if(linha_atual[i] > max) 
                    max = linha_atual[i];

                aux = linha_anterior;
                linha_anterior = linha_atual;
                linha_atual = aux;
            }
        }

        return max;
    }


    public static void main(String[] args) {

        String s1 = "BAD";
        String s2 = "BAD";
        int distance = compute_distance(s1, s2);

        System.out.println("The distance between \"" + s1 + "\" and \"" + s2 + "\" is: " + distance);
    }
}
