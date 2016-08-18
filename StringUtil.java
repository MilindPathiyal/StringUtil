//Milind Pathiyal

//StingUtil follows code in driver
public class StringUtil extends StringDriver
{
    //Pre:input must be valid
    //Post:reverses string
    public static String reverse(String input) 
    {
        String reverse = "";
        int length = input.length();
        for( int i = length - 1 ; i >= 0 ; i-- ) 
        {
            reverse = reverse + input.charAt(i);
        }
        return reverse;
    }
    //Pre:input must be valid
    //Post:ascii values will all become lower-case letters
    public static String clean(String input)
    {
        int y = 0;
        String answer = new String();
        while (y < input.length())
        {
            char x = input.charAt(y);
            if(x >= 'A' && 'Z' >= x)
            {
                x += 32;
                answer += x;
            }
            else if(x >= 'a' && 'z' >= x)
            {
                answer += x;
            }
            y++;
        }
        return answer;
    }
    //Pre:input must be valid
    //Post:reverses string index values
    public static boolean isPalindrome(String input)
    {
        return clean(input).equals(clean(reverse(input)));
    }
    //Pre:None
    //Post:returns the index number that contains the first vowel
    public static int findFirstVowel(String aString) 
    {
        for (int i = 0; i < aString.length(); i++) 
        {
            char c = aString.charAt(i);
            if (c == 'a' || c == 'e'||c == 'i' || c == 'o'||c == 'u') 
            {
                return i;
            }
        }
        return -1;
    }
    //Pre:input must be valid
    //Post:transforms regular english word into a pig latin word
    public static String piggify(String input)
    {
        String answer = new String();
        int englishWord = findFirstVowel(input);
        char c = input.charAt(0);
        if (englishWord == -1)
        {
            answer += input + "ay";
        }
        else if (c == 'a' || c == 'e'||c == 'i' || c == 'o'||c == 'u') 
        {
            answer += input + "yay";
        }
        else
        {
            int divide = findFirstVowel(input);
            return input.substring(divide) + input.substring(0, divide) +"ay";
        }
        return answer;
    }
    //Pre:None
    //Post:returns ascii code that is only part of the alphabet
    public static boolean isLetter(char c) 
    {
        return ((c >='a' && 'z' >= c)) || (c >='A' && 'Z'>= c);
    }
    //Pre:input must be valid
    //Post:returns a sentence in pig latin
    public static String piggifySentenceExtra(String input) 
    {
        String pigLatin = "";
        int i = 0;
        while (i<input.length()) 
        {
            while (i<input.length() && !isLetter(input.charAt(i))) 
            {
                pigLatin = input.charAt(i)+ pigLatin;
                i++;
            }
            int first = i;
            while (i<input.length() && isLetter(input.charAt(i))) 
            {
                i++;
            }
            int last = i;
            pigLatin = pigLatin + piggify(input.substring(first, last));
        }
        return pigLatin;
    }
}
/*
 * Enter a string to be reversed.
hello
The reversed string is olleh
Enter a string to be cleaned.
g.if
The cleaned string is gif
Enter a string to be checked for palindrominess.
Madam, I'm Adam
Madam, I'm Adam is a palindrome
Enter a string to find a vowel in.
love
The first vowel is at position 1
Enter a word to piggify
love
The piggified string is ovelay
Enter a sentence to piggify
Hasta la vista, baby!
The piggified sentence is astaHay alay istavay, abybay!     
 */