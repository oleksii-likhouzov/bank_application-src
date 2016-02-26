package org.test;

public class StaticMethodList {

    public static void printDelimeter(String commentValue) {

        System.out.println("===========================================================================\n" +
                commentValue + '\n' +
                "---------------------------------------------------------------------------");
    }

    /**
     * 1. принимает массив чаров, выводит его на экра
     *
     * @param array список символов
     */
    public static void print(char[] array) {
        if (array != null) {
            System.out.println(array);
        }
    }

    /**
     * 2. принимает 2м массив строк, выводит его на экран
     *
     * @param array двумерный массив строк
     */
    public static void print(String[][] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print("[" + (i + 1) + "]|");
            if (array[i] != null) {
                for (int j = 0; j < array[i].length; j++) {
                    System.out.print("[" + i + "][" + j + "]" + array[i][j] + ',');
                }
            }
            System.out.println("");
        }
    }

    /**
     * 3. принимает 2м массив интов, возвращает 2мерный массив чаров,
     * каждый символ в позиции массива соответствует коду символа передаваемого инта
     *
     * @param array - массив целых чисел
     * @return - массив символов
     */
    static public char[][] convertIntArrayToCharArray(int[][] array) {
        char resultArray[][];

        resultArray = new char[array.length][];
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                resultArray[i] = new char[array[i].length];
                for (int j = 0; j < array[i].length; j++) {
                    resultArray[i][j] = (char) array[i][j];
                }
            } else {
                resultArray[i] = null;
            }
        }
        return resultArray;
    }

    /**
     * 3. принимает 2м массив char, выводит его на экран
     *
     * @param array двумерный массив строк
     */
    public static void print(char[][] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print("[" + i + "]|");
            if (array[i] != null) {
                for (int j = 0; j < array[i].length; j++) {
                    System.out.print("[" + i + "][" + j + "]" + "code =" + (int) array[i][j] + "(0x" + Integer.toHexString(array[i][j]) + ')' + ',');
                }
            }
            System.out.println("");
        }
    }

    /**
     * 3. принимает 2м массив int, выводит его на экран
     *
     * @param array двумерный массив строк
     */
    public static void print(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print("[" + i + "]|");
            if (array[i] != null) {
                for (int j = 0; j < array[i].length; j++) {
                    System.out.print("[" + i + "][" + j + "]" + array[i][j] + ',');
                }
            }
            System.out.println("");
        }
    }

    /**
     * 4. принимает 2м массив интов,  ивертирует массив интов (каждое значение в передаваемом массиве меняет знак)
     *
     * @param array - data array for invert action
     */
    public static void invertIntArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; array[i] != null && j < array[i].length; j++) {
                array[i][j] = -array[i][j];
            }
        }
    }

    /**
     * 5. приминает 2 инта, а и б, возвращает большее их этих 2х чисел
     *
     * @param a - fist int value
     * @param b - second int value
     * @return max value
     */
    public static int maxInt(int a, int b) {
        return Math.max(a, b);
    }

    /**
     * 6. принимает 3 инта, возвращает большее из них
     *
     * @param a - fist int value
     * @param b - second int value
     * @param c - third int value
     * @return max value
     */
    public static int maxInt(int a, int b, int c) {
        return maxInt(maxInt(a, b), c);
    }

    /**
     * 7. принимает 3 инта, возвращает большее из них
     *
     * @param a - fist int value
     * @param b - second int value
     * @param c - third int value
     * @return max value
     */
    public static int maxInt(int a, int b, int c, int d, int e) {
        return maxInt(maxInt(a, b, c), maxInt(d, e));
    }

    /**
     * 5-7. принимает >= 2 инта, возвращает большее из них
     *
     * @param a    - fist int value
     * @param b    - second int value
     * @param list - third int value
     * @return max value
     */
    public static int maxListInt(int a, int b, int... list) {
        int result = maxInt(a, b);
        for (int value:list) {
            result = maxInt(result, value);
        }
        return result;
    }

    /**
     * 8. принимает массив чаров, возвращает строку состоящую из символов массива
     *
     * @param array - массив символов
     * @return - результирующий набор символов или пустую строку если входной набор не определен (null) или содержит 0 символов
     */
    public static String convertCharacterArray(char[] array) {
        String result = "";
        for (int i = 0; array != null && i < array.length; i++) {
            result = result + String.valueOf(array[i]);
        }
        return result;
    }

    /**
     * принимает 2 массива чаров, проверяет есть ли в 1 массиве, такая же последовательность символов которую представляет собой второй массив.
     * Возвращает булеан
     *
     * @param sourceArray  - последовательность символов
     * @param patternArray - искомая последовательность символов
     * @return - если одна из последовтельностей не определена - возвращает false
     */
    public static boolean isCharacterArrayPresent(char[] sourceArray, char[] patternArray) {
        boolean result = false;
        if (sourceArray != null && patternArray != null) {
            result = convertCharacterArray(sourceArray).contains(convertCharacterArray(patternArray));
        }
        return result;
    }

    /**
     * 10. принимает массив интов, и значение типа инт, возвращает индекс массива в котором значение совпадает с передаваемым,
     * начиная с начала массива.
     * Если значения в массиве нет возвращает -1.
     *
     * @param array - массив
     * @param value - поисковое значение
     * @return - результат поиска, если массив не определен, возвращает -1
     */
    public static int isValuePresentinArrayAsc(int array[], int value) {
        int result = -1;

        for (int i = 0; (array != null) && (result == -1) && (i < array.length); i++) {
            if (array[i] == value) {
                result = i - 1;
            }
        }
        return result;
    }

    /**
     * 10. выводит одномерный массив на екран
     *
     * @param array двумерный массив строк
     */
    public static void print(int[] array) {
        for (int value:array) {
            System.out.print(value + ", ");
        }
        System.out.println("");
    }

    /**
     * 11. принимает массив интов, и значение типа инт, возвращает индекс массива в котором значение совпадает с передаваемым,
     * начиная с конца массива.
     * Если значения в массиве нет возвращает -1.
     *
     * @param array - массив
     * @param value - поисковое значение
     * @return - результат поиска, если массив не определен, возвращает -1
     */
    public static int isValuePresentInArrayDesc(int array[], int value) {
        int result = -1;

        for (int i = array.length - 1; (result == -1) && (i >= 0); i--) {
            if (array[i] == value) {
                result = i;
            }
        }
        return result;
    }

    /**
     * 12. метод принимает инт, и возвращает факториал от заданого инта
     *
     * @param value - число для вычисления факториала
     * @return Факториал числа.
     */
    public static int factorial(int value) {
        if (value <= 1) {
            return 1;
        } else {
            return factorial(value - 1) * value;
        }
    }

    /**
     * 13 принимает инт год, и возвращает тру если год высокосный
     *
     * @param year - значение года
     * @return Признак высокосности года. true - высокостный год
     */
    public static boolean isLeapYear(int year) {
        return ((((year % 4) == 0) && ((year % 100) != 0)) || (year % 400) == 0);
    }

    /**
     * 14 служебный, добавляет строку в массив строк
     *
     * @param list  массив строк
     * @param value строка
     * @return новый массив
     */
    public static String[] addString(String[] list, String value) {
        String newList[];
        if (list == null) {
            newList = new String[1];
            newList[0] = value;
        } else {
            newList = new String[list.length + 1];
            System.arraycopy(list, 0, newList, 0, list.length);
            newList[list.length] = value;
        }
        return newList;
    }

    /**
     * 14 Принимает массив строк и просто строку,
     * возвращает массив строк которые содержат данную подстроку.
     * т.е. отфильтрованый из первого
     *
     * @param array   string array for analysis
     * @param pattern pattern string
     * @return filtered source array
     */
    public static String[] stringArrayFilter(String[] array, String pattern) {
        String[] result = null;

        for (String value:array) {
            if ((value != null) &&
                    value.contains(pattern)) {
                result = addString(result, value);
            }
        }
        return result;
    }

    /**
     * 14. принимает массив строк, выводит его на экран
     *
     * @param array массив строк
     */
    public static void printSimpleStringArray(String[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println("[" + i + "]|" + array[i]);
        }
    }

    /**
     * 15. приминает массив интов и число, выводит на екран только елементы массива которые
     * кратны этому числу
     *
     * @param array -  массив значений для выборка кратных
     * @param value -  число для которого подыскиваются кратные из массива
     */
    public static void printMultipleIntArrayValues(int[] array, int value) {
        if (value == 0) {
            throw new RuntimeException("printMultipleIntArrayValues:  0 value  detected...");
        } else if (array != null) {
            for (int i = 0; i < array.length; i++) {
                if ((array[i] % value) == 0) {
                    System.out.print("[" + i + "] " + array[i] + ',');
                }
            }
        }
        System.out.println("");
    }

    /**
     * 16. метод приминает дабл, выводит на екран этот дабл с точностью не больше чем 3 знака после точки
     *
     * @param value     - double value
     * @param precision - number of numbers after dot
     */
    public static void printDoubleValue(double value, int precision) {
        System.out.printf("%." + precision + "f\n", value);
    }

    /**
     * 17 метод принимает массив интов сортирует его по возрастанию
     *
     * @param array - массив
     */
    public static void sortIntArrayAsc(int[] array) {
        for (int i = 0; array != null && i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int tmpValue = array[j];
                    array[j] = array[i];
                    array[i] = tmpValue;
                }
            }
        }
    }

    /**
     * 18 метод принимает массив интов сортирует его по убыванию
     *
     * @param array - массив
     */
    public static void sortIntArrayDesc(int[] array) {
        for (int i = 0; array != null && i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] < array[j]) {
                    int tmpValue = array[j];
                    array[j] = array[i];
                    array[i] = tmpValue;
                }
            }
        }
    }

    /**
     * 19. метод принимает массив интов и булен, если булен тру то сортирует по убываниию,
     * иначе по возрастанию
     *
     * @param array - массив
     */
    public static void sortIntArray(int[] array, boolean isAscSorting) {

        for (int i = 0; array != null && i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                int tmpValue;
                if (
                        (isAscSorting && (array[i] > array[j])) ||
                                (!isAscSorting && (array[i] < array[j]))
                        ) {
                    tmpValue = array[j];
                    array[j] = array[i];
                    array[i] = tmpValue;
                }
            }
        }
    }

    /**
     * 20. выводит одномерный массив на екран
     *
     * @param array двумерный массив строк
     */
    public static void print(byte[] array) {
            for (byte value :array) {
                System.out.print(value + ", ");
            }
            System.out.println("");
    }

    /**
     * 20. принимает массив байт, если в массиве есть повторяющиеся елементы, возвращает тру
     *
     * @param array - массим с байтами
     * @return - true еслиь есть дубликаты, иначе false.
     */
    public static boolean isByteDuplicatePresnt(byte[] array) {
        boolean result = false;

        for (int i = 0; array != null && !result && i < array.length; i++) {
            for (int j = i + 1; !result && j < array.length; j++) {
                result = (array[i] == array[j]);
            }
        }
        return result;
    }

    /**
     * 21. принимает два массива интов одинаковых по длинне, возращает массив интов который состоит из перемноженных
     * елементов входящих массивов
     *
     * @param firstArray  первый массив
     * @param secondArray второй массив
     * @return результат умножения
     */
    public static int[] multiplicateIntArray(int[] firstArray, int[] secondArray) {
        int[] result = null;

        if (firstArray != null && secondArray != null) {
            if (firstArray.length != secondArray.length) {
                throw new RuntimeException("multiplicateIntArray:firstArray.length <> secondArray.length. ...");
            } else {
                result = new int[firstArray.length];
                for (int i = 0; i < firstArray.length; i++) {
                    result[i] = firstArray[i] * secondArray[i];
                }
            }
        }
        return result;
    }

    /**
     * 22 служебный, добавляет  в масс int в массив
     *
     * @param list  массив строк
     * @param value строка
     * @return новый массив
     */
    public static int[] addInt(int[] list, int value) {
        int newList[];
        if (list == null) {
            newList = new int[1];
            newList[0] = value;
        } else {
            newList = new int[list.length + 1];
            System.arraycopy(list, 0, newList, 0, list.length);
            newList[list.length] = value;
        }
        return newList;
    }

    /**
     * 22. Служебная выполняет вычитание множеств
     *
     * @param firstArray  - первое множество
     * @param secondArray - второе множество
     * @return firstArray-secondArray
     */
    public static int[] differenceIntArray(int[] firstArray, int[] secondArray) {
        int[] result = null;

        for (int i = 0; firstArray != null && i < firstArray.length; i++) {
            boolean isPresent;
            isPresent = false;
            for (int j = 0; secondArray != null && !isPresent && j < secondArray.length; j++) {
                isPresent = (firstArray[i] == secondArray[j]);
            }
            if (!isPresent) {
                result = addInt(result, firstArray[i]);
            }
        }
        return result;
    }

    /**
     * 22. принимает два массива интов, возвращает массив из елементов которые не совпадают в массивах
     *
     * @param firstArray  первый массив
     * @param secondArray второй массив
     * @return массив не совпадающих элементов
     */
    public static int[] symmetricDifferenceIntArray(int[] firstArray, int[] secondArray) {
        int[] firstDifference = differenceIntArray(firstArray, secondArray);
        int[] secondDifference = differenceIntArray(secondArray, firstArray);
        return addIntArray(firstDifference, secondDifference);
    }

    /**
     * 23. принимает масив интов, возвращает его же но в реверсном порядке
     *
     * @param array - исходный массив
     * @return массив в реверсном порядке
     */
    public static int[] reverseIntArray(int[] array) {

        for (int i = 0; array != null && i < array.length / 2; i++) {
            int tmpValue = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = tmpValue;
        }
        return array;
    }

    /**
     * 24 возвращает массив интов заданой длинный, который содержит случайные числа от нуля до верхней границы"
     *
     * @param length   размер выходного массива
     * @param maxValue верхняя граница
     * @return массив элементов
     */
    public static int[] generateRandomIntArray(int length, int maxValue) {
        int[] result;
        if (length < 0) {
            throw new RuntimeException("generateRandomIntArray:length < 0...");
        } else {
            result = new int[length];
            for (int i = 0; i < length; i++) {
                result[i] = (int) (Math.random() * maxValue);
            }
        }
        return result;
    }

    /**
     * 24 возвращает массив интов заданой длинный, который содержит случайные числа от нижней границы до верхней границы"
     *
     * @param length   размер выходного массива
     * @param minValue нижняя граница
     * @param maxValue верхняя граница
     * @return массив элементов
     */
    public static int[] generateRandomIntArray(int length, int minValue, int maxValue) {
        int[] result;

        if (length < 0) {
            throw new RuntimeException("generateRandomIntArray:length < 0...");
        } else {
            result = new int[length];
            for (int i = 0; i < length; i++) {
                result[i] = (int) (Math.random() * (maxValue - minValue) + minValue);
            }
        }
        return result;
    }

    /**
     * 26. принимает строку, возвращает тру если в строка содержит однин символ @, и хотя бы одну точку
     *
     * @param array - Строка с набором символов
     * @return результат поиска, true если условие верно.
     */
    public static boolean isStringContainedSpecialChars(String array) {
        boolean result = false;

        if (array != null &&
                array.indexOf('.') != -1 &&
                array.indexOf('@') != -1 &&
                array.indexOf('.') != array.lastIndexOf('.')) {
            result = true;
        }
        return result;
    }

    /**
     * 27. принимает строку, возращает эту же строку, но символы в ней расположены задом-наперед
     *
     * @param array - Строка с набором символов
     * @return результат реверса символов в строке
     */
    public static String reverseString(String array) {
        StringBuilder newArray = new StringBuilder();
        for (int i = 0; array != null && i < array.length(); i++) {
            newArray.append(array.charAt(array.length() - i - 1));
        }
        return newArray.toString();
    }

    /**
     * 28. принимает два массива интов, возвращает массив состоящий из всех
     * елементов входящих массивов
     *
     * @param firstArray  - первое множество
     * @param secondArray - второе множество
     * @return firstArray+secondArray
     */
    public static int[] addIntArray(int[] firstArray, int[] secondArray) {
        int[] result;
        if (firstArray == null) {
            result = secondArray;
        } else if (secondArray == null) {
            result = firstArray;
        } else {
            result = new int[firstArray.length + secondArray.length];
            System.arraycopy(firstArray, 0, result, 0, firstArray.length);
            System.arraycopy(secondArray, 0, result, firstArray.length, secondArray.length);
        }
        return result;
    }

    /**
     * 29. принимает массив интов, возвращает больший из них
     *
     * @param array массив
     * @return значение наибольшего элемента
     */
    public static int maxArrayInt(int array[]) {
        int maxValue;
        if (array == null) {
            throw new RuntimeException("maxArrayInt:array  is null...");
        } else {
            maxValue = array[0];
            for (int i = 1; i < array.length; i++) {
                if (maxValue < array[i]) {
                    maxValue = array[i];
                }
            }
        }
        return maxValue;
    }

    public static void main(String[] args) {
        String[][] stringArray = new String[4][7];
        System.out.println("Start...");
        printDelimeter("Exersize : 1.");
        // 1. Exersize:  принимает массив чаров, выводит его на экран
        print("abcdef".toCharArray());
        printDelimeter("Exersize : 2.");
        // 2. Exersize:  принимает 2м массив строк, выводит его на экран
        print(stringArray);
        System.out.println("");
        for (int i = 0; i < stringArray.length; i++) {
            for (int j = 0; stringArray[i] != null && j < stringArray[i].length; j++) {
                stringArray[i][j] = "test{" + i + "}{" + j + "}text";
            }
        }
        stringArray[2] = null;
        print(stringArray);
        printDelimeter("Exersize : 3.");
        //3 Exersize. принимает 2м массив интов, возвращает 2мерный массив чаров,
        // каждый символ в позиции массива соответствует коду символа передаваемого инта
        int intArray[][] = {{1, 2, 3}, {4, 5, 'a'}};
        char charArray[][] = convertIntArrayToCharArray(intArray);
        print(charArray);
        printDelimeter("Exersize : 4.");
        // 4 Exersize: принимает 2м массив интов,  ивертирует массив интов (каждое значение в передаваемом массиве меняет знак
        invertIntArray(intArray);
        print(intArray);
        printDelimeter("Exersize : 5.");
        //5. Exersize : приминает 2 инта, а и б, возвращает большее их этих 2х чисел
        System.out.println("max value of 5 and 6: " + maxInt(5, 6));
        System.out.println("max value of 6 and 5: " + maxInt(6, 5));
        // 6. Exersize : принимает 3 инта, возвращает большее из них
        System.out.println("max value of 5 and 6 and 7: " + maxInt(5, 6, 7));
        System.out.println("max value of 7 and 6 and 5: " + maxInt(7, 6, 5));
        //7. Exersize : 7. приминает 5 интов, возвращает большее из них
        System.out.println("max value of 5 and 6,7,8,9: " + maxInt(5, 6, 7, 8, 9));
        System.out.println("max value of 9 and 8,7,6,5: " + maxInt(9, 8, 7, 6, 5));
        //5-7. Exersize : приминает 2 и более интов, возвращает большее из них
        System.out.println("Variable length args");
        System.out.println("max value of 5 and 6,7,8,9: " + maxListInt(5, 6, 7, 8, 9));
        System.out.println("max value of 9 and 8,7,6,5: " + maxListInt(9, 8, 7, 6, 5));
        System.out.println("max value of 5 and 6,7,8: " + maxListInt(5, 6, 7, 8));
        System.out.println("max value of 8 and 8,7,6: " + maxListInt(8, 7, 6, 5));
        System.out.println("max value of 5 and 6: " + maxListInt(5, 6));
        // Exersize : 8. принимает массив чаров, возвращает строку состоящую из символов массива
        printDelimeter("Exersize : 8.");
        System.out.println(convertCharacterArray(null));
        System.out.println(convertCharacterArray("".toCharArray()));
        System.out.println(convertCharacterArray("12345".toCharArray()));
        // Exersize : 9. принимает 2 массива чаров, проверяет есть ли в 1 массиве,
        //такая же последовательность символов которую представляет собой второй массив.
        //Возвращает булеан
        printDelimeter("Exersize : 9.");
        System.out.println("isCharacterArrayPresent(null, null):" + isCharacterArrayPresent(null, null));
        System.out.println("isCharacterArrayPresent(123456, null): " + isCharacterArrayPresent("123456".toCharArray(), null));
        System.out.println("isCharacterArrayPresent(123456, 34): " + isCharacterArrayPresent("123456".toCharArray(), "34".toCharArray()));
        System.out.println("isCharacterArrayPresent(123456, 84): " + isCharacterArrayPresent("123456".toCharArray(), "84".toCharArray()));
        printDelimeter("Exersize : 10.");
        System.out.println("isValuePresentinArrayAsc(null, 1):" + isValuePresentinArrayAsc(null, 1));
        System.out.println("isValuePresentinArrayAsc(XXX, 1):" + isValuePresentinArrayAsc(intArray[0], 1));
        intArray[0][0] = 2;
        intArray[0][1] = 1;
        intArray[0][2] = 1;
        System.out.println("isValuePresentinArrayAsc({2,1,1}, 1):" + isValuePresentinArrayAsc(intArray[0], 1));
        printDelimeter("Exersize : 11.");
        System.out.println("isValuePresentinArrayDesc(2,1,1}l, 1):" + isValuePresentInArrayDesc(intArray[0], 1));
        printDelimeter("Exersize : 12.");
        for (int i = 0; i <= 8; i++) {
            System.out.println(i + "!:=" + factorial(i));
        }
        printDelimeter("Exersize : 13.");
        int[] yearArray = {2000, 2001, 2002, 2004, 2005, 1990, 1600, 2100, 2200, 2300};
        for (int year:yearArray) {
            System.out.println("isLeapYear(" +year + "]=" + isLeapYear(year));
        }
        printDelimeter("Exersize : 14.");
        //14. Принимает массив строк и просто строку,
        //возвращает массив строк которые содержат данную подстроку.
        //т.е. отфильтрованый из первого
        String[] simpleStringArray = {"test123test", "test234test", "tput123put", null, "get123get"};
        String[] fileredStringArray;
        fileredStringArray = stringArrayFilter(simpleStringArray, "123");
        printSimpleStringArray(fileredStringArray);
        printDelimeter("Exersize : 15.");
        // 15. приминает массив интов и число, выводит на екран только елементы массива которые
        //кратны этому числу
        printMultipleIntArrayValues(null, 2);
        printMultipleIntArrayValues(yearArray, 2);
        // 16. метод приминает дабл, выводит на екран этот дабл с точностью не больше чем 3 знака после точки
        printDelimeter("Exersize : 16.");
        printDoubleValue(1. / 3., 3);
        printDoubleValue(1. / 300., 3);
        printDoubleValue(0.0009, 3);
        printDelimeter("Exersize : 17.");
        //17. метод принимает массив интов сортирует его по возрастанию
        int[] unsortedArray = {2500, 2001, 2002, 2004, 2005, 1990, 1600, 2100, 2200, 2300};
        sortIntArrayAsc(unsortedArray);
        print(unsortedArray);
        printDelimeter("Exersize : 18.");
        //18. метод приминимает массив интов сортирует его по убыванию
        //(нельзя использовать методы сторонних классов)
        sortIntArrayDesc(unsortedArray);
        print(unsortedArray);
        printDelimeter("Exersize : 19.");
        //19. метод принимает массив интов и булен, если булен тру то сортирует по убываниию,
        //иначе по возрастанию
        sortIntArray(unsortedArray, false);
        print(unsortedArray);
        sortIntArray(unsortedArray, true);
        print(unsortedArray);
        sortIntArray(unsortedArray, false);
        print(unsortedArray);
        byte[] arrayButes = {10, 12, 13, 16};
        // 20. принимает массив байт, если в массиве есть повторяющиеся елементы, возвращает тру
        printDelimeter("Exersize : 20.");
        print(arrayButes);
        System.out.println("Check duplicates:" + isByteDuplicatePresnt(arrayButes));
        arrayButes[2] = (byte) 10;
        print(arrayButes);
        System.out.println("Check duplicates:" + isByteDuplicatePresnt(arrayButes));
        //21. принимает два массива интов одинаковых по длинне, возращает массив интов который состоит из перемноженных
        // елементов входящих массивов
        printDelimeter("Exersize : 21.");
        int firstArray[] = {1, 2, 3, 4, 5};
        int secondArray[] = {10, 20, 30, 40, 50};
        int multiplicationArray[];
        multiplicationArray = multiplicateIntArray(firstArray, secondArray);
        print(multiplicationArray);
        printDelimeter("Exersize : 22.");
        int firstIntArray[] = {1, 2, 3, 4, 5};
        int secondIntArray[] = {1, 20, 30, 40, 50};
        int diffArray[];
        diffArray = symmetricDifferenceIntArray(firstIntArray, secondIntArray);
        print(diffArray);
        printDelimeter("Exersize : 23.");
        diffArray = reverseIntArray(diffArray);
        print(diffArray);
        printDelimeter("Exersize : 24.");
        print(generateRandomIntArray(10, -10));
        printDelimeter("Exersize : 25.");
        print(generateRandomIntArray(10, 70, 80));
        printDelimeter("Exersize : 26.");
        System.out.println("Check isStringContainedSpecialChars(null):" + isStringContainedSpecialChars(null));
        System.out.println("Check isStringContainedSpecialChars(123):" + isStringContainedSpecialChars("123"));
        System.out.println("Check isStringContainedSpecialChars(1.23):" + isStringContainedSpecialChars("1.23"));
        System.out.println("Check isStringContainedSpecialChars(1.2.3):" + isStringContainedSpecialChars("1.2.3"));
        System.out.println("Check isStringContainedSpecialChars(1.2.3@):" + isStringContainedSpecialChars("1.2.3@"));
        System.out.println("Check isStringContainedSpecialChars(12.3@):" + isStringContainedSpecialChars("12.3@"));
        System.out.println("Check isStringContainedSpecialChars(123@):" + isStringContainedSpecialChars("123@"));
        printDelimeter("Exersize : 27.");
        System.out.println("Check reverseString(123456_):" + reverseString("123456_"));
        System.out.println("Check reverseString(null):" + reverseString(null));
        printDelimeter("Exersize : 28.");
        print(firstIntArray);
        print(secondArray);
        diffArray = addIntArray(firstIntArray, secondArray);
        print(diffArray);
        printDelimeter("Exersize : 29.");
        diffArray = generateRandomIntArray(10, 70, 80);
        print(diffArray);
        System.out.println("Check maxArrayInt(diffArray):" + maxArrayInt(diffArray));
        System.out.println("Stop...");
    }
}
