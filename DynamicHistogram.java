

import java.io.*;
import java.util.*;

public class DynamicHistogram
{
 static final int INITIAL_CAPACITY = 10;
 public static void main (String[] args) throws Exception
 {

  if (args.length < 1 )
  {
   System.out.println("\nusage: C:\\> java Project3 <input filename>\n\n"); 
   System.exit(0);
  }
  int[] histogram = new int[0]; // histogram[i] == # of words of length n

  // With each word read in, examine it's length and update word length frequency histogram accordingly

  String[] wordList = new String[INITIAL_CAPACITY];
  int wordCount = 0;
  BufferedReader infile = new BufferedReader( new FileReader(args[0]) );
  while ( infile.ready() )
  {
   String word = infile.readLine();

    wordList[wordCount++]=word;
    if ( wordCount == wordList.length )  // an array's .length() is its CAPACITY, not count
    {
     wordList = upSizeArr( wordList );
    }

      if(word.length()+1 > histogram.length)
      {
        histogram=upSizeHisto(histogram, word.length()+1);
      }
      ++histogram[word.length()];

  } 
  infile.close();

  wordList = trimArr( wordList, wordCount );
  System.out.println( "After final trim: wordList length: " + wordList.length + " wordCount: " + wordCount );


  for ( int i = 0; i < histogram.length ; i++ )
   System.out.format("words of length %2d  %d\n", i,histogram[i] );

 } 

 static String[] upSizeArr( String[] fullArr )
 { 
   String[] newArr = new String[fullArr.length*2];
   for(int i = 0; i < fullArr.length; i++)
   {
     newArr[i]=fullArr[i];
   }
  return newArr;
 }
 static String[] trimArr( String[] oldArr, int count )
 {
   int missing = oldArr.length-count;
   String[] newArr = new String[oldArr.length-missing];
   for(int i = 0; i < count; i++)
   {
     newArr[i]=oldArr[i];
   }
  return newArr;
 }

 static int[] upSizeHisto( int[] oldArr, int newLength )
 {
   int[] biggerArr = new int[ newLength];
  for ( int i=0 ; i<oldArr.length ; ++i ) biggerArr[i] = oldArr[i];
  return biggerArr;
 }
} 