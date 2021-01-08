package algs;

import javax.sound.midi.Soundbank;

public class Fibonacci
{
    public static int fi(int n)
    {// 0, 1, 1, 2, 3, 5, 8, 13
        int a = 0;
        int b = 1;
        int c = 0;
        for (int i = 0; i < n; i++)
        {
            c = a + b;
            a = b;
            b = c;
        }
        return a;
    }

    public static int fi1(int n)
    {
        int a = 0;
        if (n == 0)
        {
            return a;
        }
        int b = 1;
        if (n == 1)
        {
            return b;
        }
        int c = 1;
        for (int i = 2; i < n; i++)
        {
            a = b;
            b = c;
            c = a + b;
        }
        return c;
    }

    public static int fi2(int n)
    {
        if (n == 0 || n == 1)
        {
            return n;
        }
        return fi2(n - 2) + fi2(n - 1);
    }

    public static void main(String[] args)
    {
        for (int i = 0; i < 8; i++)
        {
            System.out.print(fi(i) + " ");
        }
        System.out.println();
        for (int i = 0; i < 8; i++)
        {
            System.out.print(fi1(i) + " ");
        }
        System.out.println();
        for (int i = 0; i < 8; i++)
        {
            System.out.print(fi2(i) + " ");
        }
    }
}
