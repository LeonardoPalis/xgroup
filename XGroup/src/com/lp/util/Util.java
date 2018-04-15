package com.lp.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.Toast;

/**
 * Created by Leonardo on 16/04/2015.
 */
public class Util {

    public void addMensage(Activity activity, String msg) {
        Toast.makeText(activity, msg, Toast.LENGTH_SHORT).show();
    }

    public void addDialog(Activity activity, String title, String msg, int icon, DialogInterface.OnClickListener listener2) {

        AlertDialog.Builder ad = new AlertDialog.Builder(activity);
        ad.setMessage(msg);
        ad.setTitle(title);
        ad.setNegativeButton("Não", null);
        ad.setPositiveButton("Sim", listener2);
        ad.show();
    }
}
