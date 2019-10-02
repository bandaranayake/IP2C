import java.util.Date;

class Record{
    private long ipFrom;
    private long ipTo;
    private String registry;
    private Date assigned;
    private String ctry;
    private String cntry;
    private String country;

    public Record(long ipFrom, long ipTo, String registry, Date assigned, String ctry, String cntry, String country){
        this.ipFrom = ipFrom;
        this.ipTo = ipTo;
        this.registry = registry;
        this.assigned = assigned;
        this.ctry = ctry;
        this.cntry = cntry;
        this.country = country;
    }

    public Record(String ipFrom, String ipTo, String registry, String assigned, String ctry, String cntry, String country){
        this(Long.parseLong(ipFrom), Long.parseLong(ipTo), registry, new Date(Long.parseLong(assigned)), ctry, cntry, country);
    }

    public long getIpFrom(){
        return ipFrom;
    }

    public long getIpTo(){
        return ipTo;
    }

    public String getRegistry(){
        return registry;
    }

    public Date getAssigned(){
        return assigned;
    }

    public String getCtry(){
        return registry;
    }

    public String getCntry(){
        return cntry;
    }

    public String getCountry(){
        return country;
    }

    public void setIpFrom(long ipFrom){
        this.ipFrom = ipFrom;
    }

    public void setIpTo(long ipTo){
        this.ipTo = ipTo;
    }

    public void setRegistry(String registry){
        this.registry = registry;
    }

    public void setAssigned(Date assigned){
        this.assigned = assigned;
    }

    public void setCtry(String ctry){
        this.ctry = ctry;
    }

    public void setCntry(String cntry){
        this.cntry = cntry;
    }

    public void setCountry(String country){
        this.country = country;
    }
}