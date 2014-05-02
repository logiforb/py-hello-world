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
using Racun01.model;

namespace Racun01
{
    public partial class FormMain : Form
    {
        public FormMain()
        {
            InitializeComponent();
        }

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

        private void FormMain_Load(object sender, EventArgs e)
        {
            try
            {
                //PopulateListBoxWithInvoices();

                Graphics g = pnlMain.CreateGraphics();
                //g.DrawString("Test", 
                //    new Font("Arial", 12f, FontStyle.Regular), 
                //    Brushes.Black, 
                //    new PointF(20, 20));

                g.DrawLine(Pens.Black, new Point(20, 20), new Point(600, 120));
            }
            catch (Exception ex)
            {
                ErrorHandler(ex.Message, "Unable to load data");
            }
        }

        private void PopulateListBoxWithInvoices()
        {
            List<Invoice> invoices = loadInvoices();

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
                //Add(invoice.ToString());
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
            //throw new NotImplementedException();

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

        private void pnlMain_Paint(object sender, PaintEventArgs e)
        {
            Graphics g = e.Graphics;

            g.DrawLine(Pens.Black, new Point(20, 20), new Point(600, 120));
        }
        
    }
}
