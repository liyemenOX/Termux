//file writer
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class p7{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true)
        {
            System.out.println("enter 1 for read operation");
            System.out.println("enter 2 for write(only overwrite) operation");
            System.out.println("enter 3 for write(no overwrite) operation");
            System.out.println("enter 4 for delete operation");
            System.out.println("enter 5 for reading .png, .jpg, .mp3, .mp4, .pdf, .exe");
            
            int x = Integer.parseInt(br.readLine());

            switch (x)
            {
                case 1  ->
                {//use this to read the entire file at once

                   System.out.println("read address: ");
                   String addr = br.readLine();
                   FileReader fr = new FileReader(addr);
                    int ch;
                    while((ch = fr.read()) != -1)
                    {
                        System.out.print((char)ch);
                    }
                    
                System.out.println();
                }

                case 2 ->
                {
                    //use this to write the entire file at once
                    System.out.println("write address: ");
                    String addr = br.readLine();

                    System.out.println("enter the data: ");
                    String data = br.readLine();

                    FileWriter fw = new FileWriter(addr);
                    fw.write(data);
                    fw.close();
                    
                 System.out.println();
                }

                case 3 ->
                {
                    //use this to write new contents without overwriting
                    System.out.println("write address: ");
                    String addr = br.readLine();

                    System.out.println("enter the data: ");
                    String data = br.readLine();

                    FileWriter fa = new FileWriter(addr,true);
                    fa.write(data);
                    fa.close();

                 System.out.println();
                }

                case 5 ->
                {
                    //use this to write new contents without overwriting
                    //also write the file type at the last of file name at the time of execution
                    System.out.println("read address: ");
                    String addr = br.readLine();

                    FileInputStream fis = new FileInputStream(addr);
                    int ch;

                    while((ch = fis.read()) != -1)
                    {
                        System.out.println((char)ch);
                    }
                 System.out.println();
                }


                default ->
                {
                    System.exit(0);
                }
            }

        }
        

    }
}