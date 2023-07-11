import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class ChordGen{

    private static final int C = 1, Cs = 2, D = 3, Ds = 4, E = 5, F = 6, Fs = 7, G = 8, Gs = 9, A = 10, As = 11, B = 12;

    public static void main(String[] args){
        //generateMajorScale(C);
        //generateMinorScale(C);

        int[] chordPattern = {3, 2};
        int[] scalePattern = {2,1,2,2,2,1,2};
        System.out.println(generateScale(C, scalePattern)[0] + "\n" + generateScale(C, scalePattern)[1]);
        System.out.println(generateChord(C, chordPattern, scalePattern)[0] + "\n" + generateChord(C, chordPattern, scalePattern)[1]);
        generateMajorChord(C);
        generateMinorChord(C);
       /* 
        int[] notes = {C, Cs, D, Ds, E, F, Fs, G, Gs, A, As, B};
        int[] pattern = {2, 2, 1, 2, 2, 2, 1};
        int[][] pattern2D = {{1,1,2,2,2,2,2},
                             {1,2,1,2,2,2,2},
                             {1,2,2,1,2,2,2},
                             {1,2,2,2,1,2,2},
                             {1,2,2,2,2,1,2},
                             {1,2,2,2,2,2,1},
                             {2,1,1,2,2,2,2},
                             {2,1,2,1,2,2,2},
                             {2,1,2,2,1,2,2},
                             {2,1,2,2,2,1,2},
                             {2,1,2,2,2,2,1},
                             {2,2,1,1,2,2,2},
                             {2,2,1,2,1,2,2},
                             {2,2,1,2,2,1,2},
                             {2,2,1,2,2,2,1},
                             {2,2,2,1,1,2,2},
                             {2,2,2,1,2,1,2},
                             {2,2,2,1,2,2,1},
                             {2,2,2,2,1,1,2},
                             {2,2,2,2,1,2,1},
                             {2,2,2,2,2,1,1},
                             {1,1,1,2,2,2,3},
                             {1,1,2,1,2,2,3},
                             {1,1,2,2,1,2,3},
                             {1,1,2,2,2,1,3},
                             {1,}};
        String patternStr = "";
        ArrayList<int[]> patterns = generatePatterns();
        
        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream("Chords2.txt");
            for (int[] is : patterns) {
                for (int i : is) {
                    patternStr += i;
                }
                for (int i : notes) {
                    System.out.println(generateScale(i, pattern)[0]);
                    System.out.println(generateScale(i, pattern)[1]);
                    System.out.println("1 2 3 4 5 6 7");

                    String fileContent = "This is the pattern: " + patternStr + "\n" + generateScale(i, is)[0] + "\n" + generateScale(i, is)[1] + "\n";
                    
                
        
                // Try block to check if exception occurs
                
        
                    // Step 1:  Create an object of FileOutputStream
                    
        
                    // Step 2: Store byte content from string
                    byte[] strToBytes = fileContent.getBytes();
        
                    // Step 3: Write into the file
                    outputStream.write(strToBytes);
        
                    // Print the success message (Optional)
                    System.out.print(
                        "File is created successfully with the content.");
                }
                patternStr = "";
            }
        }
    
        // Catch block to handle the exception
        catch (IOException e) {

            // Display the exception/s
            System.out.print(e.getMessage());
        }

        // finally keyword is used with in try catch block
        // and this code will always execute whether
        // exception occurred or not
        finally {

            // Step 4: Close the object
            if (outputStream != null) {

                // Note: Second try catch block ensures that
                // the file is closed even if an error
                // occurs
                try {

                    // Closing the file connections
                    // if no exception has occurred
                    outputStream.close();
                }

                catch (IOException e) {

                    // Display exceptions if occurred
                    System.out.print(e.getMessage());
                }
            }
             
        */
    }

    private static String[] generateScale(int rootNote, int[] pattern){
        String scale = "";
        String musicalNumberAssignment = "";
        int note = rootNote;
        for(int i = 0; i < pattern.length + 1; i++){
            if(i != 0){
                note += pattern[i-1];
                if(note > 12){
                    note -= 12;
                }
            }
            scale += noteIntToString(note) + " ";
            musicalNumberAssignment += note + " ";
        }
        String[] output = {"Requested Scale: " + scale, "MNA: " + musicalNumberAssignment};
        return output;
    }

    private static String[] generateChord(int rootNote, int[] chordPattern, int[] scalePattern){
        String chord = "";
        String musicalNumberAssignment = "";
        int note = rootNote;
        int counter = 0;
        for (int i = 0; i < chordPattern.length + 1; i++) {
            if(i != 0){
                for (int j = 0; j < chordPattern[i - 1]; j++) {
                    if(counter != 0){
                        note += scalePattern[counter - 1];
                        if(note > 12) note -= 12;  
                    }
                    counter++;
                }
            }
            chord += noteIntToString(note) + " ";
            musicalNumberAssignment += note + " ";
        }
        String[] output = {"Requested Chord: " + chord, "MNA: " + musicalNumberAssignment};
        return output;
    }

    private static void generateMajorChord(int rootNote){
        String scale = "";
        String musicalNumberAssignment = "";
        int[] pattern = {0,4,3};
        int note = rootNote;
        
        for(int i = 0; i < pattern.length; i++){
            note += pattern[i];
            if(note > 12){
                note -= 12;
            }
            scale += noteIntToString(note);
            musicalNumberAssignment += note + " ";
        }
        
        System.out.println(noteIntToString(rootNote) + "Major Chord: " + scale);
        System.out.println("MNA : " + musicalNumberAssignment);
    }

    private static void generateMinorChord(int rootNote){
        String scale = "";
        String musicalNumberAssignment = "";
        int[] pattern = {0,3,4};
        int note = rootNote;
        
        for(int i = 0; i < pattern.length; i++){
            note += pattern[i];
            if(note > 12){
                note -= 12;
            }
            scale += noteIntToString(note);
            musicalNumberAssignment += note + " ";
        }
        
        System.out.println(noteIntToString(rootNote) + "Minor Chord: " + scale);
        System.out.println("MNA : " + musicalNumberAssignment);
    }

    private static void generateMajorScale(int rootNote){
        String majorScale = "";
        String musicalNumberAssignment = "";
        for(int i = 1; i < 14; i += 2){
            int note = rootNote - 1 + i;
            if(note > 12){
                note -= 12;
            }
            majorScale += noteIntToString(note) + " ";
            musicalNumberAssignment += note + " ";
            if(i == 5 || i == 12){
                i--;
            }
        }
        System.out.println(noteIntToString(rootNote) + "Major Scale: " + majorScale);
        System.out.println("MNA: " + musicalNumberAssignment);
        System.out.println("1 2 3 4 5 6 7");
    }

    private static void generateMinorScale(int rootNote){
        String minorScale = "";
        String musicalNumberAssignment = "";
        for(int i = 1; i < 14; i += 2){
            int note = rootNote - 1 + i;
            if(note > 12){
                note -= 12;
            }
            minorScale += noteIntToString(note) + " ";
            musicalNumberAssignment += note + " ";
            if(i == 3 || i == 8){
                i--;
            }
        }
        System.out.println(noteIntToString(rootNote) + "Minor Scale: " + minorScale);
        System.out.println("MNA: " + musicalNumberAssignment);
        System.out.println("1 2 3 4 5 6 7");
    }

    private static String noteIntToString(int note){
        switch (note) {
            case 1 :
                return "C ";
            case 2 :
                return "C#(Db) ";
            case 3 :
                return "D ";
            case 4 :
                return "D#(Eb) ";
            case 5 : 
                return "E ";
            case 6 : 
                return "F ";
            case 7 :
                return "F#(Gb) ";
            case 8 :
                return "G ";
            case 9 :
                return "G#(Ab) ";
            case 10 :
                return "A ";
            case 11 : 
                return "A#(Bb) ";
            case 12 : 
                return "B ";            
        }
        return "Error in converting to String";
    }

    private static ArrayList<int[]> generatePatterns(){
        ArrayList<int[]> chordPatterns = new ArrayList<>();
        int[] basePattern = {1,1,2,2,2,2,2};
        int index1 = 0;
        int index2 = 1;
    
        while(index2 < basePattern.length){
            int[] patternCPY = new int[7];
            for (int i = 0; i < patternCPY.length; i++) {
                patternCPY[i] = basePattern[i];
            }
            chordPatterns.add(patternCPY);
            basePattern[index2] = 2;
            index2++;
            if(index2 == basePattern.length){
                if(index1 >= basePattern.length - 2){
                    break;
                }
                basePattern[index1] = 2;
                index1++;
                basePattern[index1] = 1;
                index2 = index1 + 1;
            }
            basePattern[index2] = 1;
        }
        
        return chordPatterns;
    }

    
    private static int factorial(int number){
        if(number == 1 || number == 0){
            return 1;
        }
        return number * factorial(number - 1);
    }
}