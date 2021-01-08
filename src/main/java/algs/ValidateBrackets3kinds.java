package algs;

public class ValidateBrackets3kinds

{
    public String replaceInnerBrackets(String str)
    {
        int lastIndex = str.lastIndexOf('(');
        int lastIndex1 = str.lastIndexOf('[');
        int lastIndex2 = str.lastIndexOf('{');
        char left;
        if (lastIndex > lastIndex1 && lastIndex > lastIndex2)
        {
            left = ')';
        }
        else if (lastIndex1 > lastIndex && lastIndex1 > lastIndex2)
        {
            left = ']';
            lastIndex = lastIndex1;
        }
        else
        {
            left = '}';
            lastIndex = lastIndex2;
        }
        int firstIndex;
        if (lastIndex != -1)
        {
            String leftStr = str.substring(lastIndex);
            firstIndex = leftStr.indexOf(left);
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
        return replaceInnerBrackets(str);
    }

    public boolean inputStr(String str)
    {
        if (str == null || str.isEmpty() || str.isBlank())
        {
            return false;
        }
        String result = replaceInnerBrackets(str);
        if (result.isEmpty() || result.isBlank() || (result.indexOf('(') == -1 && result.indexOf(')') == -1
        && result.indexOf('[') == -1 && result.indexOf(']') == -1
        && result.indexOf('{') == -1 && result.indexOf('}') == -1))
        {
            return true;
        }
        return false;
    }

    public static void main(String[] args)
    {
        String string1 = "(1(2(3)4(5)6(7)8)9)";
        String string12 = "(1(2(3)4(5)6(7)8)9)[]{}([{}])";
        String string2 = "(1(2(3)4(5)6(7)8)9))";
        String string = "(1(2(3)4(5)6(7))8)9)";
        String string4 = "(()";
        ValidateBrackets3kinds validateBrackets = new ValidateBrackets3kinds();
        boolean bu = validateBrackets.inputStr(string4);
        System.out.println(bu);
    }
}
