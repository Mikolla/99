package algs;

public class ValidateBrackets

{
    public String replaceInnerBrackets(String str, char left, char right)
    {
        int lastIndex = str.lastIndexOf(left);
        int firstIndex;
        if (lastIndex != -1)
        {
            String leftStr = str.substring(lastIndex);
            firstIndex = leftStr.indexOf(right);
            if (firstIndex != -1)
            {
                str = str.substring(0, lastIndex) + leftStr.substring(firstIndex + 1);
            }
            else
            {
                return str;
            }
            System.out.println(str);
            System.out.println();
        }
        else
        {
            return str;
        }
        if (str.isEmpty() && str.isBlank())
        {
            return str;
        }
        return replaceInnerBrackets(str, left, right);
    }

    public boolean inputStr(String str, char left, char right)
    {
        if (str == null || str.isEmpty() || str.isBlank())
        {
            return false;
        }
        String result = replaceInnerBrackets(str, left, right);
        if (result.isEmpty() || result.isBlank() || (result.indexOf(left) == -1 && result.indexOf(right) == -1))
        {
            return true;
        }
        return false;
    }

    public static void main(String[] args)
    {
        String string1 = "(1(2(3)4(5)6(7)8)9)";
        String string2 = "(1(2(3)4(5)6(7)8)9))";
        String string = "(1(2(3)4(5)6(7))8)9)";
        ValidateBrackets validateBrackets = new ValidateBrackets();
        boolean bu = validateBrackets.inputStr(string1, '(', ')');
        System.out.println(bu);
    }
}
