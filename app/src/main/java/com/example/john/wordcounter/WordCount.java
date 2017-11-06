package com.example.john.wordcounter;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import static android.R.id.list;

/**
 * Created by John on 06/11/2017.
 */

public class WordCount {



    public WordCount() {

    }

    // get text as arraylist of words
    public ArrayList<String> list(String text) {
        String newText = text.replaceAll("[\\-\\+\\.\\^:,]","");
        return new ArrayList<>(Arrays.asList(newText.toLowerCase().split(" ")));
    }

    public String countAllWords(String text) {
        return "Total word count is: " + list(text).size();
    }

    // for given text in list, return times a word is used
    public int countWord(String word, ArrayList<String> text) {
        int counter = 0;
        for (String words : text) {
            if (words.equals(word)) {
                counter++;
            }
        }
        return counter;
    }

    public ArrayList<Integer> listValues(String text) {
        ArrayList<Integer> nums = new ArrayList<>();
        ArrayList<String> words = list(text);
        for (String word : words) {
            int num = countWord(word, words);
            nums.add(num);
        }
        return nums;
    }

    // hashmap num and word arrays and get string with ordered results
    public ArrayList<String> returnSortedValues(ArrayList<String> words, ArrayList<Integer> nums) {
        // bung it all in a hashmap
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.size(); i++) {
            map.put(words.get(i), nums.get(i));
        }

        // now put this into an array
        Object[] array = map.entrySet().toArray();
        Arrays.sort(array, new Comparator() {

            // order the array, ditch multiples
            public int compare(Object o1, Object o2) {
            return ((Map.Entry<String, Integer>) o2).getValue()
                    .compareTo(((Map.Entry<String, Integer>) o1).getValue());
            }
        });

        // make the results strings and put them in an array list
        ArrayList<String> results = new ArrayList<>();
        for (Object entry : array) {
            results.add(((Map.Entry<String, Integer>) entry).getKey() + " : "
                    + ((Map.Entry<String, Integer>) entry).getValue());
        }
        return results;
    }

    public String getFinalString(ArrayList<String> list) {
        String[] array = {};
        array = list.toArray(array);
        return Arrays.toString(array);
    }

    public String doItAll(String text) {
        ArrayList<String> words = list(text);
        ArrayList<Integer> nums = listValues(text);
        ArrayList<String> sorted = returnSortedValues(words, nums);
        return countAllWords(text) +"\nThe most used words, in order, are: " + getFinalString(sorted);
    }

}
