public class ChordGen{

    private static final int C = 1, Cs = 2, D = 3, Ds = 4, E = 5, F = 6, Fs = 7, G = 8, Gs = 9, A = 10, As = 11, B = 12;
    public static void main(String[] args){
        generateMajorScale(C);
    }

    private static void generateMajorScale(int rootNote){
        String majorScale = "";
        String musicalNumberAssignment = "";
        for(int i = 0; i < 13; i++){
            int note = rootNote + i;
            if(note > 12){
                note -= 12;
            }
            majorScale += noteIntToString(note) + " ";
            musicalNumberAssignment += note + " ";
            if(i != 4){
                i++;
            }
        }
        //String majorScale = noteIntToString(rootNote) + noteIntToString(rootNote + 2) + noteIntToString(rootNote + 4) + noteIntToString(rootNote + 5) + noteIntToString(rootNote + 7) + noteIntToString(rootNote + 9) + noteIntToString(rootNote + 11);
        System.out.println(noteIntToString(rootNote) + "Major Scale: " + majorScale);
        System.out.println("MNA: " + musicalNumberAssignment);
        System.out.println("1 2 3 4 5 6 7");
    }

    private static String noteIntToString(int note){
        switch (note) {
            case 1 :
                return "C ";
            case 2 :
                return "C# ";
            case 3 :
                return "D ";
            case 4 :
                return "D# ";
            case 5 : 
                return "E ";
            case 6 : 
                return "F ";
            case 7 :
                return "F# ";
            case 8 :
                return "G ";
            case 9 :
                return "G# ";
            case 10 :
                return "A ";
            case 11 : 
                return "A# ";
            case 12 : 
                return "B ";            
        }
        return "Error in converting to String";
    }
}