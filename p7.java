    //file writer
    import java.io.*;

    class FileNotAvailable extends Exception
    {
        FileNotAvailable(String msg)
        {
            super(msg);
        }
    }

    public class p7 extends Thread{

         static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         static String addr;
         static String addr1;
         static FileInputStream fis;
        static FileOutputStream fos;

         synchronized public void read() throws IOException
                    {
                        System.out.println("enter address 2: ");
                            addr1 = br.readLine();
                        fis = new FileInputStream(addr);  
                    }
        
        synchronized public void write(){
                            try
                                {
                                    FileOutputStream fos = new FileOutputStream(addr1);

                                    fis.transferTo(fos);

                                    fis.close();
                                    fos.close();
                                    System.out.println("copy finished");
                                }
                            catch(IOException e)
                            {
                                System.out.println("error occured");
                            }
                        }
        
        public static void main(String[] args) throws IOException
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            while(true)
            {
                System.out.println("enter 1 for file creation operation");
                System.out.println("enter 2 for read operation");
                System.out.println("enter 3 for write(only overwrite) operation");
                System.out.println("enter 4 for write(no overwrite) operation");
                System.out.println("enter 5 for delete operation");
                System.out.println("enter 6 for reading .png, .jpg, .mp3, .mp4, .pdf, .exe");
                System.out.println("enter 7 for copying the data: ");
                System.out.println("Press any other key to terminate. ");

                int x = Integer.parseInt(br.readLine());

                if (x < 1 || x > 6) 
                {
                System.out.println("Terminating Program!!\n");
                System.exit(0);    
            }
          
                System.out.println("enter the address: ");
                String addr = br.readLine();

                try{
                    File file = new File(addr);
                    
                    if(x==1)
                    {
                        if(file.createNewFile())
                            {
                                System.out.printf("file has been created "+file.getName());
                            }
                        else
                            {
                                System.out.printf("file already exists");
                            }
                            System.out.println("\n");
                        continue;       
                    }
                    if(!file.exists())
                    {
                        throw new FileNotAvailable("the file is not present ");
                    }

                    else{
                        switch (x)
                        {
    

                            case 2  ->
                            {//use this to read the entire file at once
                            
                            FileReader fr = new FileReader(addr);
                                int ch;
                                while((ch = fr.read()) != -1)
                                {
                                    System.out.print((char)ch);
                                }
                                System.out.println("\n");
                                fr.close();

                            }
                            

                            case 3 ->
                            {
                                //use this to write the entire file at once

                                System.out.println("enter the data: ");
                                String data = br.readLine();
                                    
                                FileWriter fw = new FileWriter(addr);
                                fw.write(data);
                                fw.close();

                                
                            }

                            case 4 ->
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
                                try
                                {
                                    if(file.delete()){
                                    System.out.println("the file has been deleted");}
                                    else
                                    {
                                        throw new IOException();
                                    }
                                }
                                catch(IOException e)
                                {
                                    System.out.println("an io error occured during the deletion " + e.getMessage() );
                                }
                            }


                            case 6 ->
                            {
                                //use this to write new contents without overwriting
                                //also write the file type at the last of file name at the time of execution
                                
                                FileInputStream fis = new FileInputStream(addr);
                                byte[] buffer = new byte[4096];
                                int ch;
                                while((ch = fis.read(buffer)) != -1)
                                {
                                    System.out.println((char)ch);
                                }
                                System.out.println();
                                fis.close();
                            
                            }

                            case 7 ->
                            {
    
                                p7 p = new p7();
                                Thread t1 = new Thread(() ->{
                                    try
                                    {
                                        p.read();
                                        p.write();
                                    }
                                    catch(IOException e)
                                    {
                                        System.out.println("the file is not present");
                                    }
                                });
                                t1.start();

                            }
                            
                            default ->
                            {
                                System.out.print("invalid");
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