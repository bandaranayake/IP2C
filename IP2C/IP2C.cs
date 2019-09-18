using System;
using System.Collections.Generic;
using System.IO;
using System.Net;

namespace IP2C
{
    public class IP2C
    {
        private LinkedList<Record> records = new LinkedList<Record>();

        public IP2C(string path)
        {
            foreach (var line in File.ReadAllLines(path))
            {
                if (line.StartsWith("#"))
                {
                    continue;
                }
                else
                {
                    string[] splitted = line.Replace("\"", "").Split(',');
                    records.AddLast(new Record(uint.Parse(splitted[0]), uint.Parse(splitted[1]), splitted[2],
                        double.Parse(splitted[3]), splitted[4], splitted[5], splitted[6]));
                }
            }
        }

        public uint GetDecIP(string ipv4)
        {
            byte[] bytes = IPAddress.Parse(ipv4).GetAddressBytes();
            Array.Reverse(bytes);
            return BitConverter.ToUInt32(bytes, 0);
        }

        public Record GetDetails(string ipv4)
        {
            uint ipv4Dec = GetDecIP(ipv4);
            foreach (Record record in records)
            {
                if (record.ipFrom <= ipv4Dec && ipv4Dec <= record.ipTo)
                {
                    return record;
                }
            }
            return null;
        }
    }
}
