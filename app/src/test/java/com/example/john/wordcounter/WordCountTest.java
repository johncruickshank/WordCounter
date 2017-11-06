package com.example.john.wordcounter;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by John on 06/11/2017.
 */

public class WordCountTest {


    WordCount wordCount = new WordCount();
    String testText;
    String testWord;

    @Before
    public void setUp() throws Exception {
        testText = "This is a test for the word count class which has the means to count given words. test test test is a test word count count for the given for a is.";
        testWord = "test";
    }

    @Test
    public void canGetListOfWords() {
        ArrayList<String> result = wordCount.list(testText);
        assertEquals(32, result.size());
    }

    @Test
    public void canCountAllWords() {
        assertNotNull(wordCount.countAllWords(testText));
    }

    @Test
    public void canCountWord() {
        ArrayList<String> words = wordCount.list(testText);
        int result = wordCount.countWord(testWord, words);
        assertEquals(5, result);
    }

    @Test
    public void testListValues() throws Exception {
        ArrayList<Integer> result = wordCount.listValues(testText);
        assertEquals(32, result.size());
    }

//    @Test
//    public void returnSortedValues() throws Exception {
//
//    }
}
