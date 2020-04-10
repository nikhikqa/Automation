package utilities.pdf;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;

import java.io.IOException;

public class PdfRead {

//	private static final String FILE_NAME = ".//json//b4e43987-7276-4788-9ba4-51f88fb061e9.pdf";
	private static final String FILE_NAME = "C:\\Users\\Nitin.kumar\\Desktop\\RC.pdf";

	public static void readPDF() {

		PdfReader reader;

		try {

			reader = new PdfReader(FILE_NAME);

			// pageNumber = 1
			String textFromPage = PdfTextExtractor.getTextFromPage(reader, 1);

			System.out.println(textFromPage);

			reader.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
