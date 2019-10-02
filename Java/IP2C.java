import java.util.LinkedList;
import java.io.*;

class IP2C{
    private LinkedList<Record> records = new LinkedList<Record>();

    public IP2C(String path){
        try{
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line;
            while((line = br.readLine()) != null){
                if(line.startsWith("#")){
                    continue;
                }
                String[] splitted = line.replace("\"","").split(",");
                records.add(new Record(splitted[0], splitted[1], splitted[2], splitted[3], splitted[4], splitted[5], splitted[6]));
            }
        }
        catch(IOException e){
            throw new RuntimeException("Error reading the file " + path);
        }
    }

    public Record getRecord(String ip){
        long ipDec = getIpDec(ip);
        for(Record record : records){
            if(record.getIpFrom() <= ipDec && ipDec <= record.getIpTo()){
                return record;
            }
        }
        return null;
    }

    private long getIpDec(String ip){
        String[] splitted = ip.split("\\.");
        return Long.parseLong(splitted[3]) + (Long.parseLong(splitted[2])*256) 
        + (Long.parseLong(splitted[1])*256*256) + (Long.parseLong(splitted[0])*256*256*256);
    }
}