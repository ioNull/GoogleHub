package bz.tsung.android.googlehub;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;

/**
 * Created by tsung on 13-6-7.
 */
public class TextHubReceiver extends BroadcastReceiver {
    private static final String TAG = "TextHubReceiver";
    public void onReceive(Context context, Intent intent) {
        Log.i(TAG, "onReceive: " + intent);

        //get selection
        String selection = intent.getStringExtra("bz.tsung.android.texthub.EXTRA_TEXT");
        Log.i(TAG, "onReceive selection: " + selection);

        //search with google
        Uri uri = Uri.parse("http://www.google.com/#q=" + selection);
        Intent i = new Intent();
        i.setData(uri);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(i);
    }
}
