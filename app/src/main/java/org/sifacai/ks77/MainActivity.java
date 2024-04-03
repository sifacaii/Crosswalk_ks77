package org.sifacai.ks77;

import android.net.http.SslError;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.widget.FrameLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.pakdata.xwalk.refactor.XWalkClient;
import com.pakdata.xwalk.refactor.XWalkPreferences;
import com.pakdata.xwalk.refactor.XWalkResourceClient;
import com.pakdata.xwalk.refactor.XWalkSettings;
import com.pakdata.xwalk.refactor.XWalkUIClient;
import com.pakdata.xwalk.refactor.XWalkView;

import org.xwalk.core.XWalkInitializer;

public class MainActivity extends AppCompatActivity implements XWalkInitializer.XWalkInitListener {

    private static final String TAG = "MainActivity";
    
    private XWalkView xwalkview;
    private XWalkInitializer xwalkinitializer;
    private XWalkSettings settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        xwalkinitializer =new XWalkInitializer(this,this);
        xwalkinitializer.initAsync();
        XWalkPreferences.setValue(XWalkPreferences.REMOTE_DEBUGGING,true);
    }

    @Override
    public void onXWalkInitStarted() {
        Log.d(TAG, "onXWalkInitStarted: ");
    }

    @Override
    public void onXWalkInitCancelled() {
        Log.d(TAG, "onXWalkInitCancelled: ");
    }

    @Override
    public void onXWalkInitFailed() {
        Log.d(TAG, "onXWalkInitFailed: ");
    }

    @Override
    public void onXWalkInitCompleted() {
        Log.d(TAG, "onXWalkInitCompleted: ");
        xwalkview = new XWalkView(this);
        xwalkview.setUIClient(new XWalkUIClient(xwalkview));

        xwalkview.setXWalkClient(new XWalkClient(xwalkview){
            @Override
            public void onLoadResource(XWalkView view, String url) {
                super.onLoadResource(view, url);
                Log.d(TAG, "onLoadResource: " + url);
            }

        });

        xwalkview.setResourceClient(new XWalkResourceClient(){
            @Override
            public void onReceivedSslError(XWalkView view, ValueCallback<Boolean> callback, SslError error) {
                //super.onReceivedSslError(view, callback, error);
                callback.onReceiveValue(true);
            }
        });

        xwalkview.getSettings().setCacheMode(XWalkSettings.LOAD_NO_CACHE);

        FrameLayout parent=findViewById(R.id.main);
        parent.addView(xwalkview,new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        String url = "https://sample-videos.com/";
        xwalkview.loadUrl(url);
    }
}