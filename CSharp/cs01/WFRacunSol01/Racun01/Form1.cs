using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using Racun01.business;
using Racun01.model;

namespace Racun01
{
    public partial class FormMain : Form
    {
        public FormMain()
        {
            InitializeComponent();
        }

        private List<Invoice> invoices;

        #region Menu and Tool items
        private void exitToolStripMenuItem_Click(object sender, EventArgs e)
        {
            CloseThis();
        }

        private void toolStripButtonClose_Click(object sender, EventArgs e)
        {
            CloseThis();
        } 
        #endregion

        #region Implementations
        private void CloseThis()
        {
            this.Close();
        } 
        #endregion

        #region Main etc.
        private void FormMain_Load(object sender, EventArgs e)
        {
            try
            {
                //PopulateListBoxWithInvoices();

                invoices = loadInvoices();
            }
            catch (Exception ex)
            {
                ErrorHandler(ex.Message, "Unable to load data");
            }
        }

        private void PopulateListBoxWithInvoices()
        {
            List<Invoice> invoices = loadInvoices();

            invoices.Sort(new business.InvoiceCompareByDate());

            //IEnumerable<string> strings = invoices.Select(x => x.Name);

            //foreach (string s in strings)
            //{
            //    Add(s);
            //}

            foreach (Invoice invoice in invoices)
            {
                Add(invoice.ToString());
            }
        }

        private List<Invoice> loadInvoices()
        {
            List<Invoice> invoices = new List<Invoice>();

            string dataDir = System.Configuration.ConfigurationManager.AppSettings["datadir"];
            string[] dataLines = File.ReadAllLines(dataDir);

            foreach (string dataLine in dataLines)
            {
                string[] dataLineSplit = dataLine.Split(',');

                string name = FormatLine(dataLineSplit[0]);
                DateTime time = ParseDateTime(FormatLine(dataLineSplit[1]));
                int cost = int.Parse(FormatLine(dataLineSplit[2]));

                model.Invoice invoice = new model.Invoice(name, time, cost);

                invoices.Add(invoice);
            }

            return invoices;
        }

        private String FormatLine(string line)
        {
            return line.Replace("\"", "");
        }

        private DateTime ParseDateTime(string unparsedDateTime)
        {
            String format = "yyyy-MM-dd_HH-mm";
            DateTime dtParsed = DateTime.ParseExact(
                unparsedDateTime,
                format,
                new System.Globalization.CultureInfo("hr-HR"));

            return dtParsed;
        }

        private void Add(string add)
        {
            lboxMain.Items.Add(add);
        }

        private void ErrorHandler(string text, string caption)
        {
            MessageBox.Show(text, caption, MessageBoxButtons.OK, MessageBoxIcon.Error);
        } 
        #endregion

        private void pnlMain_Paint(object sender, PaintEventArgs e)
        {
            Graphics g = e.Graphics;

            invoices.Sort(new InvoiceCompareByDate());

            Size size = pnlMain.Size;
            int xYLine = 40;
            int yYLineHigh = 40;
            int yYLineLow = size.Height - 40;
            Point p1YLine = new Point(xYLine, yYLineHigh);
            Point p2YLine = new Point(xYLine, yYLineLow);
            Brush axisBrush = Brushes.DarkBlue;
            g.DrawLine(new Pen(axisBrush, 2), p1YLine, p2YLine);

            Brush axisInfoBrush = Brushes.Maroon;
            string fontPrototype = "Arial";
            Font axisInfoFont = new Font(fontPrototype, 12);

            g.DrawString("0", axisInfoFont, axisInfoBrush, new PointF(xYLine - 20, yYLineLow - 5));
            for (int i = 50; i <= 500; i += 50)
            {
                g.DrawString(i.ToString(), axisInfoFont, axisInfoBrush, new PointF(xYLine - 45, yYLineLow - i));
            }

            Font invoiceFont = new Font(fontPrototype, 8);
            Pen invoiceLinePen = new Pen(Brushes.LightGray, 20);
            Invoice invoice;
            for (int i = 0; i < invoices.Count; i++)
            {
                invoice = invoices[i];
                int xInvoice = 40 + i * 40 + (int)(invoiceLinePen.Width/2);
                int yInvoiceHigh = size.Height - 40 - Math.Min(invoice.Cost, 525);
                int yInvoiceLow = size.Height - 40;
                Point p1Invoice = new Point(xInvoice, yInvoiceHigh);
                Point p2Invoice = new Point(xInvoice, yInvoiceLow);
                g.DrawLine(invoiceLinePen, p1Invoice, p2Invoice);
                
            }
            for (int i = 0; i < invoices.Count; i++)
            {
                invoice = invoices[i];
                int xInvoice = 40 + i * 40;
                int yInvoiceHigh = size.Height - 40 - Math.Min(invoice.Cost, 525);
                DrawInvoiceString(g, axisInfoBrush, invoiceFont, invoice, xInvoice, yInvoiceHigh);
            }
        }

        private static void DrawInvoiceString(Graphics g, Brush axisInfoBrush, Font invoiceFont, Invoice invoice, int xInvoice, int yInvoiceHigh)
        {
            g.DrawString(invoice.Name, invoiceFont, axisInfoBrush, new PointF(xInvoice, yInvoiceHigh));
        }
        
    }
}
