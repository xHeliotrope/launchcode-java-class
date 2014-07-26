
package com.rmoore8869.mario4.marioOutputs;

import java.io.*;

import com.rmoore8869.mario4.MarioFileWriter;


<<<<<<< HEAD:pset4/src/main/java/com/rmoore8869/mario4/marioOutputs/MToFile.java
public final class MToFile implements MarioFileWriter {
=======
public class MToFile implements MarioFileWriter {
>>>>>>> 8eedf18818db5f034549b38afe33474f7af36ae9:pset3/marioOutputs/mToFile.java

    @Override
    public void outputTriangle(String pyramid) {
        while (true) {
            System.out.println("Please enter a valid filepath with filename.");
            try {
                BufferedReader br =
                        new BufferedReader(new InputStreamReader(System.in));
                File textFile = new File(br.readLine());
<<<<<<< HEAD:pset4/src/main/java/com/rmoore8869/mario4/marioOutputs/MToFile.java
                try (PrintWriter out = new PrintWriter(textFile.getAbsoluteFile())) {
                    out.println(pyramid);
=======
                try (PrintWriter out = new PrintWriter(textFile.getAbsoluteFile());) {
                    System.out.println(pyramid);
>>>>>>> 8eedf18818db5f034549b38afe33474f7af36ae9:pset3/marioOutputs/mToFile.java
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
