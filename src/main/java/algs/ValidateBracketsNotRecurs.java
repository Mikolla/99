package algs;

import java.util.LinkedList;
import java.util.List;

/**
 * Валидация строки со скобками "(()())", ((()))() - валидные, "()(", "((()" или (() - не валидные, скобки должны быть
 * парными
 * @author Артур Садреев https://vk.com/sadreevartur
 */
public class ValidateBracketsNotRecurs
{
    public static boolean checkTheBrackets(String s)
    {
        int count = 0;
        for (char charAt : s.toCharArray())
        {
            if (count == 0 && charAt == ')')
            {
                return false;
            }
            if (charAt == '(')
            {
                count++;
            }
            else
            {
                count--;
            }
        }
        return count == 0;
    }

    public static void main(String[] args)
    {
        List<String> strings = new LinkedList<>();
        strings.add("((()))"); //true
        strings.add("()()()"); //true
        strings.add("(()())"); //true
        strings.add("))((");
        strings.add("())");
        strings.add("())(");
        for (String string : strings)
        {
            System.out.println(checkTheBrackets(string));
        }
    }
}