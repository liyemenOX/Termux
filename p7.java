    //file writer
    import java.io.BufferedReader;
    import java.io.File;
    import java.io.FileInputStream;
    import java.io.FileReader;
    import java.io.FileWriter;
    import java.io.IOException;
    import java.io.InputStreamReader;

    class FileNotAvailable extends Exception
    {
        FileNotAvailable(String msg)
        {
            super(msg);
        }
    }

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

                System.out.println("enter the address: ");
                String addr = br.readLine();

                try{
        
                    File file = new File(addr);
                    if(!file.exists())
                    {
                        throw new FileNotAvailable("the file is not present ");
                    }
                    else{
                        switch (x)
                        {
                            case 1  ->
                            {//use this to read the entire file at once
                            
                            FileReader fr = new FileReader(addr);
                                int ch;
                                while((ch = fr.read()) != -1)
                                {
                                    System.out.print((char)ch);
                                }
                                System.out.println();
                                fr.close();

                            
                            }
                            

                            case 2 ->
                            {
                                //use this to write the entire file at once

                                System.out.println("enter the data: ");
                                String data = br.readLine();
                                    
                                FileWriter fw = new FileWriter(addr);
                                fw.write(data);
                                fw.close();
                                
                                
                                
                            }

                            case 3 ->
                            {
                                //use this to write new contents without overwriting
                
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
                                
                                FileInputStream fis = new FileInputStream(addr);
                                int ch;
                                while((ch = fis.read()) != -1)
                                {
                                    System.out.println((char)ch);
                                }
                                System.out.println();
                                fis.close();
                            
                            }


                            default ->
                            {
                                System.exit(0);
                            }
                        }
                }
            }
                catch(FileNotAvailable e)
                {
                    System.out.println("an unexpected exception occured: "+e.getMessage() + e.getClass().getSimpleName());
                }

                catch(IOException e)
                {
                    System.out.println("an ioexception has occured ");
                }
            }
            

        }
    }