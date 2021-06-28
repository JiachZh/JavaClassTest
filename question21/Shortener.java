/*
 * Name: 
 * Student number:
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Shortener {
    // This class is only a starting point. You should complete all members
    // below, but you may also need to add other fields and methods to
    // finish the implementation as per the question on the assignment sheet.
    private HashMap<String, String> abbreviationMap;
    /*
     * Default constructor that will load a default abbreviations text file.
     */
    public Shortener() {
        // to be completed
    	abbreviationMap = new HashMap<String, String>();
    	try {
			FileReader fileReader = new FileReader("abbreviations.txt");
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line = null;
			while((line = bufferedReader.readLine())!=null) {
				if(line.isEmpty()) {
					continue;
				}
				String[] infos = line.split(",");
				abbreviationMap.put(infos[0], infos[1]);	
			}
			fileReader.close();
			bufferedReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    /*
     * Constructor that will load the abbreviations file represented by the
     * File parameter.
     */
    public Shortener( File inAbbreviationsFile ) {
        // to be completed
    	if(inAbbreviationsFile != null) {
    		try {
				FileReader fileReader = new FileReader(inAbbreviationsFile);
				BufferedReader bufferedReader = new BufferedReader(fileReader);
				String line = null;
				while((line = bufferedReader.readLine())!=null) {
					if(line.isEmpty()) {
						continue;
					}
					String[] infos = line.split(",");
					abbreviationMap.put(infos[0], infos[1]);
				}
				fileReader.close();
				bufferedReader.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
    	}
    }
    
    /*
     * Constructor that will load the abbreviations file that the String 
     * parameter is a file path for.
     */
    public Shortener( String inAbbreviationsFilePath ) {
        // to be completed
    	try {
			FileReader fileReader = new FileReader(inAbbreviationsFilePath);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line = null;
			while((line = bufferedReader.readLine())!=null) {
				if(line.isEmpty()) {
					continue;
				}
				String[] infos = line.split(",");
				abbreviationMap.put(infos[0], infos[1]);	
			}
			fileReader.close();
			bufferedReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    /*
     * This method attempts to shorten a word by finding its abbreviation. If 
     * no abbreviation exists for this word, then this method will return the 
     * original (i.e., unshortened) word.
     * 
     * You may assume that words are always lower case.
     *
     * `inWord` should be a single word (no spaces). It may optionally be
     * followed by one of the five following punctuation characters:
     *   ,
     *   ?
     *   .
     *   !
     *   ;
     * If one of these characters is at the end of the word this method will
     * shorten the word (ignoring the punctuation) and return the shortened
     * word with the punctuation character at the end.
     * For example,
     *     shortenerObject.shortenWord( "hello?" )
     * should return
     *     "lo?"
     *
     * You may assume that words are always lower case.
     */
    public String shortenWord( String inWord ) {
    	if(inWord.endsWith(",") || inWord.endsWith("?") || inWord.endsWith(".") || inWord.endsWith("!")|| inWord.endsWith(";")) {
    		String symbol = String.valueOf(inWord.charAt(inWord.length()-1));
    		String s = abbreviationMap.get(inWord.substring(0, inWord.length()));
    		if(s != null) {
    			return s+symbol;
    		}
    		return inWord;
    	}else {
    		String s = abbreviationMap.get(inWord);
    		if(s == null) {
    			return inWord;
    		}else {
    			return s;
    		}
    	}
    }
    
    /*
     * Attempts to shorten a message by replacing words with their 
     * abbreviations. 
     *
     * You may assume that messages are always lower case.
     *
     * Punctuation characters (,?.!;) should be retained after shortening. See
     * `shortenWord( String inWord )` for more information.
     */
    public String shortenMessage( String inMessage ) {
    	if(inMessage.isEmpty()) {
    		return null;
    	}else {
    		String[] words = inMessage.split(" ");
    		StringBuilder stringBuilder = new StringBuilder();
    		for(int i = 0;i<words.length;i++) {
    			String word = words[i];
    			if(i == words.length-1) {
    				stringBuilder.append(shortenWord(word));
    			}else {
    				stringBuilder.append(shortenWord(word) + " ");
    			}
    		}
    		return stringBuilder.toString();
    	}
    }
}
