package com.pa.gumi.SMSManager;

import android.content.Context;
import android.content.Intent;

public class SMSManager {

    private Context context;
    private String numTelephone;
    private String message = "Toi aussi, tu veux aider ton enfant à s'entraîner aux bases des mathématique ? Télécharge donc Gumi ! C'est une application très simple qui permettra à ton enfant de s'entraîner au grâce a des exercices a troue !";

    public SMSManager(Context context, String numTelephone) {
        this.context = context;
        this.numTelephone = numTelephone;

        Intent i = new Intent(android.content.Intent.ACTION_VIEW);
        i.putExtra("address", numTelephone);
        i.putExtra("sms_body", message);
        i.setType("vnd.android-dir/mms-sms");
        context.startActivity(i);

    }


}
