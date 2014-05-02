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
            //Test1();

            try
            {
                string[] dataLines = File.ReadAllLines("../../data/test.txt");
                foreach (string dataLine in dataLines)
                {
                    string[] dataLineSplit = dataLine.Split(',');

                    //foreach (string datalineSplitLine in dataLineSplit)
                    //{
                    //    string = datalineSplitLine.Replace("\"", "");
                    //}

                    string name = FormatLine(dataLineSplit[0]);
                    DateTime time = ParseDateTime(FormatLine(dataLineSplit[1]));
                    int cost = int.Parse(FormatLine(dataLineSplit[2]));

                    model.Invoice invoice = new model.Invoice(name, time, cost);
                    Add(invoice.ToString());
                }

                //string line = lines[0];
                //string[] split1 = line.Split(',');

                //string unparsedDate = split1[1].Replace("\"", "");

                //String format = "yyyy-MM-dd_HH-mm";
                //DateTime dtParsed = DateTime.ParseExact(
                //    unparsedDate,
                //    format,
                //    new System.Globalization.CultureInfo("hr-HR"));

                //Add(dtParsed.ToString());
            }
            catch (Exception ex)
            {
                ErrorHandler(ex.Message, "Unable to load data");
            }
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

        private void Test1()
        {
            try
            {
                string[] lines = File.ReadAllLines("../../data/test.txt");

                //lboxMain.Items.Add(lines[0]);
                string line = lines[0];
                string[] split1 = line.Split(',');
                //foreach (var splitLine1 in split1)
                //{
                //    //lboxMain.Items.Add(splitLine1);
                //    string neww = splitLine1.Replace("\"", "");
                //    //Add(String.Format("[{0}]", neww));
                //    if (neww == "")
                //    {

                //    }
                //}

                string unparsedDate = split1[1].Replace("\"", "");
                Add(unparsedDate);
                //DateTime dt1 = DateTime.Parse(unparsedDate.Replace("_","T"));
                //Add(dt1.ToString());

                String format = "yyyy-MM-dd_HH-mm";
                DateTime dtParsed = DateTime.ParseExact(
                    unparsedDate,
                    format,
                    new System.Globalization.CultureInfo("hr-HR"));

                Add(dtParsed.ToString());
            }
            catch (Exception ex)
            {
                ErrorHandler(ex.Message, "Unable to load data");
            }
        }

        private void Add(string add)
        {
            lboxMain.Items.Add(add);
        }

        private void ErrorHandler(string text, string caption)
        {
            MessageBox.Show(text, caption, MessageBoxButtons.OK, MessageBoxIcon.Error);
        }
        
    }
}
