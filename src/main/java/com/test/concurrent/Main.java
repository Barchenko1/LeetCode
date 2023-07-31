package com.test.concurrent;

public class Main {
    public static void main(String[] args) {
//        Given a string composed of 2 words, and the first word’s length,
//        Implement a method to reverse the 2 words in the string.
//
//        For example:
//        str = “abc12345”
//        firstWordLength = 3
//        stringsSwap(str, firstWordLength) → "12345abc"
        String str = "abc12345";
        int firstWorkLength = 3;
        stringSwap(str, firstWorkLength);

    }

    private static void stringSwap(String str, int firstWorkLength) {
        char[] charArr = str.toCharArray();
        for (int i = 0; i < charArr.length; i++) {
            char tempHeadChar = 0;
            char tempTailChar = 0;
            if (i < firstWorkLength) {
                tempHeadChar = charArr[i];
                tempTailChar = charArr[charArr.length - firstWorkLength + i];

            }
        }

    }
}
