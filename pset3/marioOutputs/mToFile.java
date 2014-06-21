
package pset3.marioOutputs;

import java.io.*;

import pset3.MarioFileWriter;


public class MToFile implements MarioFileWriter {

    @Override
    public void outputTriangle(String pyramid) {
        while (true) {
            System.out.println("Please enter a valid filepath with filename.");
            try {
                BufferedReader br =
                        new BufferedReader(new InputStreamReader(System.in));
                File textFile = new File(br.readLine());
                try (PrintWriter out = new PrintWriter(textFile.getAbsoluteFile());) {
                    System.out.println(pyramid);
                    if (textFile.isFile() && textFile.canRead()) {
                        break;
                    }
                } catch (IOException e) {
                    System.out.println("Sorry, filepath not valid.");
                }
            } catch (IOException e) {
                System.out.println("Could not get input");
            }
        }
    }
}
