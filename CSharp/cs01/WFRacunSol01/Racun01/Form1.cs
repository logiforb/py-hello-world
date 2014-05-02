﻿using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
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
        
    }
}