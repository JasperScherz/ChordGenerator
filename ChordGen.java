public class ChordGen{

    private static final int C = 1, Cs = 2, D = 3, Ds = 4, E = 5, F = 6, Fs = 7, G = 8, Gs = 9, A = 10, As = 11, B = 12;

    public static void main(String[] args){
        generateMajorScale(C);
        generateMinorScale(C);

        int[][] twodArrayTest = {{0, 1}, {2, 3}};
        //System.out.println(twodArrayTest[0][0]);
    }

    private static void generateMajorScale(int rootNote){
        String majorScale = "";
        String musicalNumberAssignment = "";
        for(int i = 1; i < 13; i += 2){
            int note = rootNote - 1 + i;
            if(note > 12){
                note -= 12;
            }
            majorScale += noteIntToString(note) + " ";
            musicalNumberAssignment += note + " ";
            if(i == 5){
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
        for(int i = 1; i < 13; i += 2){
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
}