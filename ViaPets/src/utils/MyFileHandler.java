package utils;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class MyFileHandler
{
   // Reads all lines from the file with the given file name and returns it as a String[]
   public static String[] readArrayFromTextFile(String fileName) throws FileNotFoundException
   {
      Scanner readFromFile = null;
      ArrayList<String> strs = new ArrayList<String>();

      try
      {
         FileInputStream fileInStream = new FileInputStream(fileName);
         readFromFile = new Scanner(fileInStream);

         while (readFromFile.hasNext())
         {
            strs.add(readFromFile.nextLine());
         }
      }
      finally
      {
         if (readFromFile != null)
         {
            readFromFile.close();
         }
      }

      String[] strsArray = new String[strs.size()];
      return strs.toArray(strsArray);
   }
 }
