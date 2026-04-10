public class SIT_302 {
    public static void main(String[] args) {
        int n=5000;

        for(int i=2; i<=n; i++){
            System.out.println(i+" "+isPrime(i));
        }
    }

    static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}