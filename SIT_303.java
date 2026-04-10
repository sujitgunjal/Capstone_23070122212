public class SIT_303 {
    public static void main(String[] args) {
        int n = 40;
        boolean[] isPrime = new boolean[n + 1];

        seive(n, isPrime);
    }
    static void seive(int num, boolean[] isPrime){
        for(int i = 2; i * i <= num; i++) {
            if(!isPrime[i]) {
                for(int j = i * 2; j <= num; j += i) {
                    isPrime[j] = true;
                }
            }
        }
        for(int i = 2; i <= num; i++){
            if(!isPrime[i]) {
                System.out.println(i);
            }
        }
    }
}