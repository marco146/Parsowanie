
package egz_parsowanie;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;


public class Parsowanie {
    
     public static int parsowanie(String plik, String fraza)
    {   
        int dlugosc= 0, liczbalinii=0;
        String linia;
        File pp = new File(plik);
        try{
        RandomAccessFile file = new RandomAccessFile(plik, "r");
        RandomAccessFile f = new RandomAccessFile
        ("c:/pliki/p_parsowanie.txt", "rw");
         if(pp.exists()==false)
        {
            f.writeBytes("Brak pliku wejściowego");
        }
        while((linia = file.readLine()) != null)
        {
            linia = linia.replaceFirst(fraza, fraza.toUpperCase());
            
            char tablica [] = linia.toCharArray();
            dlugosc += linia.length();
            liczbalinii ++;
            for (int i = 0; i < linia.length(); i++) {
                char c = tablica[i];
                if(Character.isDigit(c))
                {
                    if(c=='9')  
                    {
                        tablica[i] = '0';
                    }else{
                    tablica[i]=(char) (c+1);
                    }
                }
            }
            f.writeBytes(String.valueOf(tablica)+"\r\n");
        }
             return dlugosc/liczbalinii;     
    }catch(IOException e){System.out.println("brak pliku wejściowego");};
    return 0;
    }
    
}
