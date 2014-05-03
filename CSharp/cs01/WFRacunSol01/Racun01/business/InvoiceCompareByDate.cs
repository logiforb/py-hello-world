using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Racun01.model;

namespace Racun01.business
{
    public class InvoiceCompareByDate : Comparer<Invoice>
    {
        public override int Compare(Invoice x, Invoice y)
        {
            return x.Time.CompareTo(y.Time);
        }
    }
}
