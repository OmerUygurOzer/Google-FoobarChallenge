import java.util.HashSet;
import java.util.Set;

/**
 * Created by Omer on 3/13/2016.
 */

/*
Spy snippets
============

You've been recruited by the team building Spy4Rabbits, a highly advanced search engine used to help fellow agents discover files and intel needed to continue the operations against Dr. Boolean's evil experiments. The team is known for recruiting only the brightest rabbit engineers, so there's no surprise they brought you on board. While you're elbow deep in some important encryption algorithm, a high-ranking rabbit official requests a nice aesthetic feature for the tool called "Snippet Search." While you really wanted to tell him how such a feature is a waste of time in this intense, fast-paced spy organization, you also wouldn't mind getting kudos from a leader. How hard could it be, anyway?

When someone makes a search, Spy4Rabbits shows the title of the page. Your commander would also like it to show a short snippet of the page containing the terms that were searched for.

Write a function called answer(document, searchTerms) which returns the shortest snippet of the document, containing all of the given search terms. The search terms can appear in any order.

The length of a snippet is the number of words in the snippet. For example, the length of the snippet "tastiest color of carrot" is 4. (Who doesn't like a delicious snack!)

The document will be a string consisting only of lower-case letters [a-z] and spaces. Words in the string will be separated by a single space. A word could appear multiple times in the document.
searchTerms will be a list of words, each word comprised only of lower-case letters [a-z]. All the search terms will be distinct.

Search terms must match words exactly, so "hop" does not match "hopping".

Return the first sub-string if multiple sub-strings are shortest. For example, if the document is "world there hello hello where world" and the search terms are ["hello", "world"], you must return "world there hello".

The document will be guaranteed to contain all the search terms.

The number of words in the document will be at least one, will not exceed 500, and each word will be 1 to 10 letters long. Repeat words in the document are considered distinct for counting purposes.
The number of words in searchTerms will be at least one, will not exceed 100, and each word will not be more than 10 letters long.

Languages
=========

To provide a Python solution, edit solution.py
To provide a Java solution, edit solution.java

Test cases
==========

Inputs:
    (string) document = "many google employees can program"
    (string list) searchTerms = ["google", "program"]
Output:
    (string) "google employees can program"

Inputs:
    (string) document = "a b c d a"
    (string list) searchTerms = ["a", "c", "d"]
Output:
    (string) "c d a"
 */
public class SpySnippets {

    public static String answer(String document, String[] searchTerms) {
        String s = "";

        String [] wordsAll = document.split(" ");
        int worldsAllLen = wordsAll.length;
        int searchTermsLen = searchTerms.length;

        Set<String> searchTermsSet = new HashSet<>();
        for(String st: searchTerms){
            searchTermsSet.add(st);
        }

        boolean flag = true;

        int currentIndex = 0;
        int startOffset  = -1;//cant be zero since we don't know if we need the first index

        int bestCurrentSize  = 501; //cant be greater than 500;
        int bestCurrentOffset = 0;


        Set<String> currentTerms = new HashSet<>();

        while(flag){

            String currentWord = wordsAll[currentIndex];

            if (searchTermsSet.contains(currentWord)){
                if(currentTerms.size() == 0){
                    startOffset = currentIndex;
                }

                currentTerms.add(currentWord);

                if(currentTerms.size()==searchTermsLen){
                    int currentSize = currentIndex - startOffset +1;
                    if(currentSize < bestCurrentSize){
                        bestCurrentSize = currentSize;
                        bestCurrentOffset = startOffset;
                    }
                    currentIndex = startOffset;
                    currentTerms = new HashSet<>();
                }

            }
            currentIndex++;
            flag = currentIndex != worldsAllLen;

        }


        //Append all words to the returning string
        s+= wordsAll[bestCurrentOffset];
       for(int i = bestCurrentOffset+1 ; i < bestCurrentOffset+bestCurrentSize; i++){s+= " " + wordsAll[i];}

        return s;
    }




}
