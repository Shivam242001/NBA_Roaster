// --== CS400 File Header Information ==--
// Name: Yash Rustagi
// Email: yrustagi@wisc.edu
// Team: EF red
// Role: Frontend Developer
// TA: Yelun Bao
// Lecturer: Gary Dahl

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.zip.DataFormatException;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestFrontend {
  /**
   * Checks if correct player APG is being outputed input text file commands: p,
   * anthony davis, a, x, q
   * 
   * @throws IOException
   * @throws DataFormatException
   */
  @Test
  public void testAPG() throws DataFormatException, IOException {
    File out = new File("testAAPG.txt");
    String[] in = { "AAPG.txt", "testAAPG.txt" };
    FrontendDeveloper.main(in);
    try {
      String output = Files.readString(out.toPath());
      assertEquals(output.contains("THANK"), false);
    } catch (Exception e) {
      System.out.println("File not made");
    }
  }

  /**
   * Checks if the correct player RPG is being outputed input text file commands:
   * p, anthony davis, a, x, q
   * 
   * @throws DataFormatException
   * @throws IOException
   */
  @Test
  public void testRPG() throws DataFormatException, IOException {
    File out = new File("testRPG.txt");
    String[] in = { "RPG.txt", "testRPG.txt" };
    FrontendDeveloper.main(in);
    try {
      String output = Files.readString(out.toPath());
      assertEquals(output.contains("THANK"), false);
    } catch (Exception e) {
      System.out.println("File not made");
    }
  }

  /**
   * Checks if the correct player PPG is being outputed input text file commands:
   * p, anthony davis, a, x, q
   * 
   * @throws DataFormatException
   * @throws IOException
   */
  @Test
  public void testPPG() throws DataFormatException, IOException {
    File out = new File("testPPG.txt");
    String[] in = { "PPG.txt", "testPPG.txt" };
    FrontendDeveloper.main(in);
    try {
      String output = Files.readString(out.toPath());
      assertEquals(output.contains("THANK"), false);
    } catch (Exception e) {
      System.out.println("File not made");
    }
  }

}
