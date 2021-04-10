package com.example.coctails;

import android.app.AlertDialog;
import android.content.Context;

import com.example.coctails.api.CoctailApi;
import com.example.coctails.api.CoctailClient;

public class Utils {
    public static CoctailApi getApi() {
        return CoctailClient.getCoctailClient().create(CoctailApi.class);
    }

    public static AlertDialog showDialogMessage(Context context, String title, String message) {
        AlertDialog alertDialog = new AlertDialog.Builder(context).setTitle(title).setMessage(message).show();
        if (alertDialog.isShowing()) {
            alertDialog.cancel();
        }
        return alertDialog;
    }
}
