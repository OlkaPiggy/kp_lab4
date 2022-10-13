import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        File f = new File("formula.txt");
        ArrayList<String> rows = new ArrayList<String>();
        try (FileReader reader = new FileReader(f)) {
            Scanner scan = new Scanner(reader);
            while (scan.hasNextLine()) {
                String tmp = scan.nextLine();
                String[] arr = tmp.split(" ");
                for (int i = 0; i < arr.length; i++) {
                    if (arr[i].contains("*") || arr[i].contains("=") || arr[i].contains("/") ||
                            arr[i].contains("+") || arr[i].contains("-") || arr[i].contains("(") || arr[i].contains(")"))
                        rows.add(arr[i]);
                }
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        //System.out.print(rows);
        Set<String> identificators = new HashSet<>();
        for (String c :
                rows) {
            char[] m = c.toCharArray();
            for (int i = 0; i < m.length; ++i) {
                if (m[i] != '*' && m[i] != '/' && m[i] != '+' && m[i] != '-' &&
                        m[i] != '(' && m[i] != ')' && m[i] != '1' && m[i] != '2' &&
                        m[i] != '3' && m[i] != '4' && m[i] != '5' && m[i] != '6' &&
                        m[i] != '7' && m[i] != '8' && m[i] != '9' && m[i] != '.' && m[i] != '=') {
                    String ident = "" + m[i];
                    identificators.add(ident);
                }
            }
        }
        //System.out.print(identificators);

        List<String> identificatorsL1 = identificators.stream().collect(Collectors.toList());
        //error
        List<String> identificatorsL2=identificatorsL1.stream().collect(Collectors.toList());
        Collections.shuffle(identificatorsL2);
        System.out.print(identificatorsL1);
        System.out.print(identificatorsL2);
        //shuffled

        ArrayList<String> rows2=new ArrayList<>();
        System.out.print("\n");
        //change letters in rows
        char[] curr_formula= new char[20];
        for(int i=0;i< rows.size();++i)
        {
            curr_formula=rows.get(i).toCharArray();

                    for(int c=0;c<curr_formula.length;c++)
                    {
                        for(int j=0;j< identificatorsL1.size();j++) {
                            if (curr_formula[c] == identificatorsL1.get(j).charAt(0)) {
                                curr_formula[c]=identificatorsL2.get(j).charAt(0);
                                break;
                            }
                        }
                    }
            String replaced = new String(curr_formula);
            rows2.add(replaced);
        }
        //System.out.print(rows2);

        //write in file
        f = new File("formula.txt");
        int formuls=0;
        String write="";
        // ArrayList<String> rows = new ArrayList<String>();
        try (FileReader reader = new FileReader(f)) {
            Scanner scan = new Scanner(reader);
            while (scan.hasNextLine()) {
                String tmp = scan.nextLine();
               if(tmp.contains(rows.get(formuls)))
               {
                   tmp=tmp.replace(rows.get(formuls),rows2.get(formuls));
                   formuls++;
               }
               //add to string
                write +=tmp+"\n";
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        System.out.print(write);


        /*try(FileWriter writer = new FileWriter("notes3.txt", false))
        {
            // запись всей строки
            String text = "Hello Gold!";
            writer.write(text);
            // запись по символам
            writer.append('\n');
            writer.append('E');

            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }*/
    }
}