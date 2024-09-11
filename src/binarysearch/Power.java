package binarysearch;

public class Power {
    public static void main(String[] args) {
        double ans = new Power().calculate(3, -4);
        System.out.println(ans);
    }

    double calculate(int x, int y) {
        System.out.println("x " + x + "y" + y);
        if (y == 0) return 1;
        if (y == 1) return y < 0 ? 1 / x : x;
        if (y == 2) return y < 0 ? 1 / (x * x) : x * x;
        double temp = calculate(x, y / 2);
        return y % 2 == 0 ? temp * temp : temp * temp * (1 / x);
    }
}
