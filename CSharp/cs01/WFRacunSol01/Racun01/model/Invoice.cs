using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Racun01.model
{
    public class Invoice
    {
        public string Name { get; set; }
        public DateTime Time { get; set; }
        public int Cost { get; set; }

        public Invoice(string name, DateTime time, int cost)
        {
            this.Name = name;
            this.Time = time;
            this.Cost = cost;
        }

        public override string ToString()
        {
            //return base.ToString();
            return String.Format("{0}, {1}, {2}", Name, Time, Cost);
        }
    }
}
