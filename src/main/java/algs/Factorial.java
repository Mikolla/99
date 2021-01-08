package algs;

public class Factorial
{
    public int factorial(int num) {
        int fact = 1;
        for (; num > 0; fact *= num--);
        return fact;
    }


    public long factorialCycle(long n)
    {
        long a = 1;
        for (int i = 1; i <= n; i++)
        {
            a = a * i;
        }
        return a;
    }

    public long factorialRecursion(long n)
    {
        if (n < 1)
        {
            return 1;
        }
        return factorialCycle(n - 1) * n;
    }

    public int factorial1(int num) {
        int fact = 1;
        for (int i = 1; i <= num; fact *= i++);
        return fact;
    }

    public static void main(String[] args)
    {
        Factorial fac = new Factorial();
        System.out.println(fac.factorialCycle(4));
        System.out.println(fac.factorialRecursion(4));
        System.out.println(fac.factorial1(4));
    }

}
