package ter.tom;


/**
 * {@code ValidRomanChars} is an enum that represents valid roman characters and their values.
 */
enum ValidRomanChars {
    I('I'), V('V'), X('X'), L('L'), C('C'), D('D'), M('M');

    private final char romanAsChar;

    /** Returns a roman char as a {@code char}
     * @return {@code char} roman character
     */
    public char asChar() {
        return romanAsChar;
    }

    /** Returns a roman character as a integer value
     * @return {@code int} roman characters value
     */
    public int asNumber() {
        if (romanAsChar == 'I') return 1;
        else if (romanAsChar == 'V') return 5;
        else if (romanAsChar == 'X') return 10;
        else if (romanAsChar == 'L') return 50;
        else if (romanAsChar == 'C') return 100;
        else if (romanAsChar == 'D') return 500;
        else return 1000;
    }

    private ValidRomanChars(char romanAsChar) {
        this.romanAsChar = romanAsChar;
    }
}

/**
 * {@code RomanNumberConverter} class represents a converter from roman numbers to positive integers.
 */
public class RomanNumberConverter {

    /** Converts roman numbers to positive integer
     * @param   romanNumber
     *          Roman numbers as a string
     * @return {@code -1} if string is null, empty, incorrect order or has invalid characters.<br />
     *          {@code int} roman numbers as a positive integer
     */
    public int convertRomanToInteger(String romanNumber) {
        // Check if we have null string, empty string,
        // invalid order or some illegals characters (ex. A, B, J, K etc.)
        if (romanNumber == null || romanNumber.isEmpty()
                || !testValidRomanNumbersAndOrder(romanNumber))
            return -1;

        // Roman numbers is a valid string now. Lets proceed and return a valid integer
        // Enum is not necessary at all. I just like that enum in Java is a class
        int returnValue = 0;
        int index = 0;
        char[] romanNumberAsCharArray = romanNumber.toCharArray();
        boolean working = true;
        while (working) {
            char currentCharAtIndex = romanNumberAsCharArray[index];

            // Check for pretty straightforward values. Thousands
            if (currentCharAtIndex == ValidRomanChars.M.asChar()) {
                returnValue += ValidRomanChars.M.asNumber();
            }
            else if (currentCharAtIndex == ValidRomanChars.D.asChar()) { // five hundreds
                returnValue += ValidRomanChars.D.asNumber();
            }
            else if (currentCharAtIndex == ValidRomanChars.L.asChar()) { // five tens
                returnValue += ValidRomanChars.L.asNumber();
            }
            else if (currentCharAtIndex == ValidRomanChars.V.asChar()) { // only five
                returnValue += ValidRomanChars.V.asNumber();
            }
            // Now checking harder situations.
            else if (currentCharAtIndex == ValidRomanChars.C.asChar()) { // One hundred
                if ((index + 1) != romanNumber.length()) {
                    // Lets check if One Hundred is before One Thousand or Five Hundreds
                    char nextChar = romanNumberAsCharArray[index + 1];
                    //  One Hundred is before One Thousand
                    if (nextChar == ValidRomanChars.M.asChar()) {
                        returnValue += ValidRomanChars.M.asNumber() - ValidRomanChars.C.asNumber();
                        index++;
                    }
                    //  One Hundred is before Five hundreds
                    else if (nextChar == ValidRomanChars.D.asChar()) {
                        returnValue += ValidRomanChars.D.asNumber() - ValidRomanChars.C.asNumber();
                        index++;
                    }
                    else {
                        returnValue += ValidRomanChars.C.asNumber();
                    }
                }
                else returnValue += ValidRomanChars.C.asNumber(); //  One Hundred is not before M or D
            }
            else if (currentCharAtIndex == ValidRomanChars.X.asChar()) { // Ten
                if ((index + 1) != romanNumber.length()) {
                    // Lets check if Ten is before One hundred or Five Tens
                    char nextChar = romanNumberAsCharArray[index + 1];
                    // Ten is before One hundred
                    if (nextChar == ValidRomanChars.L.asChar()) {
                        returnValue += ValidRomanChars.L.asNumber() - ValidRomanChars.X.asNumber();
                        index++;
                    }
                    // Ten is before Five Tens
                    else if (nextChar == ValidRomanChars.C.asChar()) {
                        returnValue += ValidRomanChars.C.asNumber() - ValidRomanChars.X.asNumber();
                        index++;
                    }
                    else {
                        returnValue += ValidRomanChars.X.asNumber();
                    }
                }
                else returnValue += ValidRomanChars.X.asNumber(); // // Ten not before L or C
            }
            else if (currentCharAtIndex == ValidRomanChars.I.asChar()) { // One
                if ((index + 1) != romanNumber.length()) {
                    // Lets check if One  is before Ten or Five
                    char nextChar = romanNumberAsCharArray[index + 1];
                    // One is before Ten
                    if (nextChar == ValidRomanChars.X.asChar()) {
                        returnValue += ValidRomanChars.X.asNumber() - ValidRomanChars.I.asNumber();
                        index++;
                    }
                    // One is before Five
                    else if (nextChar == ValidRomanChars.V.asChar()) {
                        returnValue += ValidRomanChars.V.asNumber() - ValidRomanChars.I.asNumber();
                        index++;
                    }
                    else {
                        returnValue += ValidRomanChars.I.asNumber();
                    }
                }
                else returnValue += ValidRomanChars.I.asNumber(); // One is not before X or V
            }


            index++;
            // Exiting loop.
            if (index == romanNumber.length())
                working = false;
        }

        return returnValue;
    }


    /**
     * Tests if roman numbers are in correct order or if the string has some illegal numbers
     * @param   romanNumber
     *          roman numbers as a string
     * @return {@code false} if the order is incorrect or has illegal numbers, {@code true} if everything is ok
     */
    private boolean testValidRomanNumbersAndOrder(String romanNumber) {
        String validOrderPattern = "^M*(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$";

        return romanNumber.matches(validOrderPattern);
    }

    /**
     * Function tests romanNumbers as a string for illegal characters
     * p.s. Not used at all. Just showing how enum could be used.
     * Look  {@code RomanNumberConverter.testValidRomanNumbersAndOrder} for a better and shorter solution.
     * @param   romanNumber
     *          roman numbers as a string
     * @return  {@code false} if illegal characters found, {@code true} if no illegal characters
     */
    private boolean testIfValidRomanNumbers(String romanNumber) {
        for (char romanChar : romanNumber.toCharArray()) {
            if (romanChar != ValidRomanChars.I.asChar() &&
                    romanChar != ValidRomanChars.V.asChar() &&
                    romanChar != ValidRomanChars.X.asChar() &&
                    romanChar != ValidRomanChars.L.asChar() &&
                    romanChar != ValidRomanChars.C.asChar() &&
                    romanChar != ValidRomanChars.D.asChar() &&
                    romanChar != ValidRomanChars.M.asChar())
                return false;
        }
        return true;
    }

}
