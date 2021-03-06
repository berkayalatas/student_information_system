import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.lang.String;

public class Rapor {


        int  i = 0,counter=0;
        String[] ad = new String[500];
        String[] soyad = new String[500];
        String[] ogrenciNo = new String[500];
        float[] vizeNot = new float[500];
        float[] finalNot = new float[500];
        float[] basariNotu = new float[500];
        String line;
        String[] harfNotu = new String[500];
        String[] parcalar = new String[500];

        float vizeOrt ;
        float finalOrt ;
        float basariNotOrt;
        float toplam = 0;


        //BM201Hesap.txt den dosya okunup ilgili değişkenlere atma
        public void raporlama (){

            File file =new File("C:\\Users\\berka\\Desktop\\BM201Hesap.txt");
            try {
                Scanner reader = new Scanner(file);
                i=0;
                while (reader.hasNextLine()){
                    line =  reader.nextLine();
                    parcalar = line.split(" ");

                    Arrays.toString(parcalar);
                    ogrenciNo[i] =parcalar[0];
                    ad[i] = parcalar[1];
                    soyad[i] = parcalar[2];
                    vizeNot[i] =  Float.parseFloat(parcalar[3]);
                    finalNot[i]=  Float.parseFloat(parcalar[4]);
                    basariNotu[i] = Float.parseFloat(parcalar[5]);
                    harfNotu[i] = parcalar[6];
                    i++;
                    counter++;
                }

                reader.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }



    public void writeToRapor(){
        File file =new File("C:\\Users\\berka\\Desktop\\BM201Rapor.txt");
        try {
            FileWriter filewr = new FileWriter(file);
            System.out.println("BM201Rapor.txt  Dosyası");

            //Ekrana BM201Hesap.txt den alınan verileri yazma
            for (i=0 ; i<counter ; i++){

                filewr.write( ogrenciNo[i]+ " " +ad[i]+ " " + soyad[i] +" " + vizeNot[i]
                        + " " + finalNot[i] + " " + basariNotu[i] + " " + harfNotu[i] + "\n");
            }


            //vize not ortlaması hesaplama
            for (int j = 0; j < counter; j++) {

                toplam = vizeNot[j] + toplam;

            }
            vizeOrt = (toplam / counter);


            //final not ortalaması hesaplama
            toplam=0;
            for (int j =0; j<counter; j++) {

                toplam = finalNot[j] + toplam;

            }
            finalOrt = (toplam / counter);

            toplam=0;
            //genel başarı notu ortalaması hesaplama
            for (int j = 0;  j<counter; j++) {

                toplam = basariNotu[j] + toplam;

            }
            basariNotOrt = (toplam / counter);


            filewr.write("\n");
            filewr.write("Sınıfın Vize Ortalaması : " + vizeOrt + "\n");
            filewr.write("Sınıfın Final Ortalaması : " + finalOrt + "\n");
            filewr.write("Sınıfın Genel Başarı Ortalaması : " + basariNotOrt + "\n");


            filewr.close();
        } catch (
                IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}
