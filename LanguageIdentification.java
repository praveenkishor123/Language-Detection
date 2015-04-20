import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.sax.BodyContentHandler;
import org.apache.tika.language.*;
import org.xml.sax.SAXException;

public class LanguageIdentification {

/**
 * @param args
 * @throws IOException
 * @throws SAXException
 * @throws TikaException
 */
public static void main(final String[] args) throws IOException, SAXException, TikaException {

	
/**************************** Apache Tika and N-gram Algorithm ********************************************

Here, we are using Apache Tika which internally uses N-gram algorithm for detecting the input text language.

Apache Tika is a library that is used for document type detection and content extraction from various file formats.
Internally, Tika uses various existing document parsers and document type detection techniques to detect and extract data.
Tika can be used as content extractor to extract both structured text as well as metadata from different types of 
documents such as spreadsheets, text documents, images, PDFs and even multimedia input formats to a certain extent.

N-gram algorithm is an effective approach for language detection. This algorithm works fine with short texts.

The n-grams typically are collected from a text or speech corpus. 

An n-gram model is a type of probabilistic language model for predicting the next item in such a sequence in the 
form of a (n âˆ’ 1)â€“order Markov model. 

n-gram models are now widely used in probability, communication theory, computational linguistics (for instance, 
statistical natural language processing), computational biology (for instance, biological sequence analysis), 
and data compression. 

An n-gram of size 1 is referred to as a "unigram", size 2 is a "bigram", size 3 is a "trigram". 
Tika uses the 3-grams algorithm.

***************************************************************************************************************/

	// Instantiating a File object
	// Provide the input text
	  File file = new File("input_english.txt");

	  
	// Parser method parameters for parsing the documents
	  Parser parser = new AutoDetectParser();      
      BodyContentHandler handler = new BodyContentHandler();
      Metadata metadata = new Metadata();
      FileInputStream content = new FileInputStream(file);
      
/**************************************************************************************************    
*     Parsing the input file :-
*     parse() method is used to parses the content and stores it in the handler object, 
*     which is passed to the LanguageIdentifier as the argument 
**************************************************************************************************/ 

      parser.parse(content, handler, metadata, new ParseContext());
      
      
/**************************************************************************************************
*     getLanguage() is the method of LanguageIdentifier class in Apache Tika which is 
*     used to find the language of text. 
*     This method returns the code name of the language in String format.
***************************************************************************************************/
      
      LanguageIdentifier object = new LanguageIdentifier(handler.toString());
      
      System.out.println("Detected Language is :" + object.getLanguage());
   }
}
