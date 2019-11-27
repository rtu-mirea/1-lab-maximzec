package com.company;

import java.io.*;
import java.util.List;

public class FileManager {
    private File file;
    FileManager(String fileName) throws IOException {
        this.file = new File(fileName + ".txt");
        file.createNewFile();
    }

    boolean isFileExists()
    {
        return this.file.exists();
    }

    void write(Doll doll)
    {
        try (DataOutputStream os = new DataOutputStream(new FileOutputStream(this.file))){
            os.writeUTF(doll.toString());
            os.flush();
            os.close();
        } catch (IOException e) {
            e.getMessage();
        }
    }

    void read(List<Doll> dolls , String producer){
        Doll doll = new Doll();
        try (DataInputStream ds = new DataInputStream(new FileInputStream(this.file))){
            while(ds.available() > 0)
            {
                String[] a = ds.readUTF().split(".");
                if(a[0].equals(producer))
                {
                    dolls.add(new Doll(a[1] , Integer.parseInt(a[2]) , Integer.parseInt(a[3]) , Integer.parseInt(a[4])));
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    void randomAccess(List<Doll> dolls) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile("randAccess.txt", "rw");
        String temp = "";
        for (Doll doll : dolls) {
            temp = doll.toString();
            randomAccessFile.writeBytes(temp);
        }

        while ((temp = randomAccessFile.readLine()) != null){
            int count = 0;
            String[] a = temp.split(".");
            if(Integer.parseInt(a[4]) < 8){
                count++;
                randomAccessFile.seek(temp.getBytes().length * count - (7 + a[3].getBytes().length));
                randomAccessFile.writeBytes(String.valueOf(Integer.parseInt(a[3])/2));
            }
        }
    }


}
