using System;

namespace IP2C
{
    public class Record
    {
        public Record(uint ipFrom, uint ipTo, string registry, double assigned, string ctry, string cntry, string country)
        {
            this.ipFrom = ipFrom;
            this.ipTo = ipTo;
            this.registry = registry;
            this.assigned = new DateTime(1970, 1, 1, 0, 0, 0, DateTimeKind.Utc).AddSeconds(assigned);
            this.ctry = ctry;
            this.cntry = cntry;
            this.country = country;
        }
        public uint ipFrom { get; }
        public uint ipTo { get; }
        public string registry { get; }
        public DateTime assigned { get; }
        public string ctry { get; }
        public string cntry { get; }
        public string country { get; }

    }
}
