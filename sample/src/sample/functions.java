package sample;

import java.util.Arrays;

public class functions {

    public static String[] append(String[] StringArray, String StringVar) {
        int c = StringArray.length;
        String[] finalString = new String[c + 1];
        for (int i = 0; i < c; i++)
            finalString[i] = StringArray[i];
        finalString[c] = StringVar;
        return finalString;
    }

    public static String[][] append(String[][] StringArray, String[] StringVar) {
        int c = StringArray.length;
        String[][] finalString = new String[c + 1][];
        for (int i = 0; i < c; i++)
            finalString[i] = StringArray[i];
        finalString[c] = StringVar;
        return finalString;
    }

    public static Integer[] append(Integer[] IntegerArray, Integer IntegerVar) {
        int c = IntegerArray.length;
        Integer[] finalInteger = new Integer[c + 1];
        for (int i = 0; i < c; i++)
            finalInteger[i] = IntegerArray[i];
        finalInteger[c] = IntegerVar;
        return finalInteger;
    }

    public static double[] append(double[] doubleArray, double doubleVar) {
        int c = doubleArray.length;
        double[] finalDouble = new double[c + 1];
        for (int i = 0; i < c; i++)
            finalDouble[i] = doubleArray[i];
        finalDouble[c] = doubleVar;
        return finalDouble;
    }

    public static int[] range(int end) {
        int[] rangeArray = new int[end];
        for (int i = 0; i < rangeArray.length; i++) {
            rangeArray[i] = i;
        }
        return rangeArray;
    }

    public static String[] extend(String[] stringVar1, String[] stringVar2) {
        int length1 = stringVar1.length;
        int length2 = stringVar2.length;
        String[] extendedVar = new String[length1 + length2];
        for(int i = 0; i < length1; i++) {
            extendedVar[i] = stringVar1[i];
        }
        for(int b = 0; b < length2; b++) {
            extendedVar[b + length1] = stringVar2[b];
        }
        return extendedVar;
    }

    public static void displayArrays (String[][] arrayPass) {
        String finalReturn = "[";
        for (int b = 0; b < arrayPass.length; b++) {
            if (b != arrayPass.length - 1) {
                finalReturn += Arrays.toString(arrayPass[b]) + ", ";
            }
            else {
                finalReturn += Arrays.toString(arrayPass[b]);
            }
        }
        finalReturn += "]";
        System.out.println(finalReturn);
    }
}


