package asap.asapdev.testpos.Util;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPref {
    private static final String TAG = "SharedPref";
    public SharedPreferences sp;
    SharedPreferences.Editor spEditor;

    public SharedPref(Context context) {
        sp = context.getSharedPreferences(TAG, Context.MODE_PRIVATE);
        spEditor = sp.edit();
    }

    public void saveSPString(String keySP, String value){
        spEditor.putString(keySP, value);
        spEditor.commit();
    }

    public void saveSPInt(String keySP, int value){
        spEditor.putInt(keySP, value);
        spEditor.commit();
    }

    public void saveSPBoolean(String keySP, boolean value){
        spEditor.putBoolean(keySP, value);
        spEditor.commit();
    }

}
