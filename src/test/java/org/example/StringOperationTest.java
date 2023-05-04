package org.example;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class StringOperationTest {

    @Test
    void testTruePalindrome() {
        assertTrue(StringOperation.palindrome("madam"));
    }

    @Test
    void testPalindromeWithSpace() {
        assertTrue(StringOperation.palindrome("nurses run"));
    }

    @Test
    void testFalsePalindrome() {
        assertFalse(StringOperation.palindrome("Zenas"));
    }

    @Test
    void testTrueUniqueCharacters() {
        assertTrue(StringOperation.hasUniqueCharactersUsingLastIndexOf("Calvin"));
    }

    @Test
    void tesFalseUniqueCharacters() {
        assertFalse(StringOperation.hasUniqueCharactersUsingLastIndexOf("Devine"));
    }

    @Test
    void testCommonWordsOverThree() {
        Map<String, List<String>> freq = StringOperation.commonWords("Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of \"de Finibus Bonorum et Malorum\" (The Extremes of Good and Evil) by Cicero, written in 45 BC. This book is a treatise on the theory of ethics, very popular during the Renaissance. The first line of Lorem Ipsum, \"Lorem ipsum dolor sit amet..\", comes from a line in section 1.10.32.\n" +
                "The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested. Sections 1.10.32 and 1.10.33 from \"de Finibus Bonorum et Malorum\" by Cicero are also reproduced in their exact original form, accompanied by English versions from the 1914 translation by H. Rackham.");


        assertEquals(3, freq.get("top").size());
        assertEquals(3, freq.get("bottom").size());

        assertEquals(Map.of("top", List.of("the", "of", "lorem"), "bottom", List.of("interested", "simply", "consectetur")), freq);
    }

    @Test
    void testCommonWordsUnderThree() {
        Map<String, List<String>> freq = StringOperation.commonWords("Hello World!");

        assertEquals(2, freq.get("top").size());
        assertEquals(2, freq.get("bottom").size());

        assertEquals(Map.of("top", List.of("world","hello"), "bottom", List.of("world","hello")), freq);
    }
}