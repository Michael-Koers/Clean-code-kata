package _01_If_Statements;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {

    @Test
    void testNullString(){
        StringUtils utils = new StringUtils();
        assertEquals("", utils.transform(null));

    }
    @Test
    void testEmptyString() {
        StringUtils utils = new StringUtils();
        assertEquals("", utils.transform(""));
    }

    @Test
    void testStringLengthLessThan5() {
        StringUtils utils = new StringUtils();
        assertEquals("abcd", utils.transform("ABCD"));
        assertEquals("test", utils.transform("TEST"));
    }

    @Test
    void testStringLengthBetween5And10() {
        StringUtils utils = new StringUtils();
        assertEquals("example", utils.transform("EXAMPLE"));
        assertEquals("testing", utils.transform("TESTING"));
    }

    @Test
    void testStringLengthGreaterThan10() {
        StringUtils utils = new StringUtils();
        assertEquals("LONGSTRINGEXAMPLE", utils.transform("longstringexample"));
        assertEquals("ANOTHERLONGSTRING", utils.transform("anotherlongstring"));
    }
}
