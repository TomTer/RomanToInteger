package ter.tom;


import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;


public class TestingRomanNumbers {

    private static RomanNumberConverter romanNumberConverter;

    // Inits before starting the testing
    @BeforeClass
    public static void setup() {
        romanNumberConverter = new RomanNumberConverter();
    }

    // Testing begins
    @Test
    public void testBadRomanValue() {
        String badRomanValue = "MMMDCLXVIA";
        int answer = romanNumberConverter.convertRomanToInteger(badRomanValue);

        Assert.assertEquals("Testing a bad roman value", -1, answer);
    }

    @Test
    public void testRomanValueI() {
        String goodRomanValue = "MMXV";
        int answer = romanNumberConverter.convertRomanToInteger(goodRomanValue);

        Assert.assertEquals("Testing roman value 2015", 2015, answer);
    }

    @Test
    public void testRomanValueII() {
        String goodRomanValue = "I";
        int answer = romanNumberConverter.convertRomanToInteger(goodRomanValue);

        Assert.assertEquals("Testing roman value 1", 1, answer);
    }

    @Test
    public void testRomanValueIII() {
        String goodRomanValue = "IX";
        int answer = romanNumberConverter.convertRomanToInteger(goodRomanValue);

        Assert.assertEquals("Testing roman value 9", 9, answer);
    }

    @Test
    public void testRomanValueIV() {
        String goodRomanValue = "IV";
        int answer = romanNumberConverter.convertRomanToInteger(goodRomanValue);

        Assert.assertEquals("Testing roman value 4", 4, answer);
    }

    @Test
    public void testRomanValueV() {
        String goodRomanValue = "CMXLIX";
        int answer = romanNumberConverter.convertRomanToInteger(goodRomanValue);

        Assert.assertEquals("Testing roman value 949", 949, answer);
    }

    @Test
    public void testRomanValueVI() {
        String goodRomanValue = "CDXVIII";
        int answer = romanNumberConverter.convertRomanToInteger(goodRomanValue);

        Assert.assertEquals("Testing roman value 418", 418, answer);
    }

    @Test
    public void testRomanValueVII() {
        String goodRomanValue = "IV";
        int answer = romanNumberConverter.convertRomanToInteger(goodRomanValue);

        Assert.assertEquals("Testing roman value 4", 4, answer);
    }

    @Test
    public void testRomanValueVIII() {
        String goodRomanValue = "XLIII";
        int answer = romanNumberConverter.convertRomanToInteger(goodRomanValue);

        Assert.assertEquals("Testing roman value 43", 43, answer);
    }

    @Test
    public void testInvalidOrderI() {
        String invalidOrder = "MMMDDIII";
        int answer = romanNumberConverter.convertRomanToInteger(invalidOrder);

        Assert.assertEquals("Testing roman invalid order I", -1, answer);
    }
    @Test

    public void testInvalidOrderII() {
        String invalidOrder = "MDCCCC";
        int answer = romanNumberConverter.convertRomanToInteger(invalidOrder);

        Assert.assertEquals("Testing roman invalid order II", -1, answer);
    }

    public void testInvalidOrderIII() {
        String invalidOrder = "CCCD";
        int answer = romanNumberConverter.convertRomanToInteger(invalidOrder);

        Assert.assertEquals("Testing roman invalid order III", -1, answer);
    }

    @Test
    public void testEmptyString() {
        String emptyString = "";
        int answer = romanNumberConverter.convertRomanToInteger(emptyString);

        Assert.assertEquals("Testing an empty string", -1, answer);
    }

    @Test
    public void testNullString() {
        String nullString = null;
        int answer = romanNumberConverter.convertRomanToInteger(nullString);

        Assert.assertEquals("Testing a null string", -1, answer);
    }

}
