package com.ayako_sayama.twittrendy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.ayako_sayama.twittrendy.utils.Debug;
import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterAuthToken;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.identity.TwitterLoginButton;

import io.fabric.sdk.android.Fabric;

public class LoginActivity extends AppCompatActivity {


    private TwitterLoginButton loginButton;
    // Note: Your consumer key and secret should be obfuscated in your source code before shipping.
//    private String TWITTER_KEY = "@string/twitter_api_key";
//    private String TWITTER_SECRET = "UYJyGmirLH3qbtufZkGpwEEllHtM0yNeZmYsCvNmgDEBkCfaHA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        String TWITTER_KEY = getString(R.string.twitter_api_key);
        String TWITTER_SECRET = getString(R.string.twitter_secret_key);

        super.onCreate(savedInstanceState);
        TwitterAuthConfig authConfig = new TwitterAuthConfig(TWITTER_KEY, TWITTER_SECRET);
        Fabric.with(this, new Twitter(authConfig));
        setContentView(R.layout.activity_login);
    }


    protected void onResume() {
        super.onResume();

            TwitterSession session = Twitter.getSessionManager().getActiveSession();
            TwitterAuthToken authToken = session.getAuthToken();
            String token = authToken.token;
            String secret = authToken.secret;

            if(session == null || authToken.isExpired()){


                loginButton = (TwitterLoginButton) findViewById(R.id.login_button);
                loginButton.setCallback(new Callback<TwitterSession>() {
                    @Override
                    public void success(Result<TwitterSession> result) {

                        TwitterSession session = result.data;
                        String msg = "@" + session.getUserName() + " logged in! (#" + session.getUserId() + ")";
                        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
                        startTweetList();
                    }

                    @Override
                    public void failure(TwitterException exception) {
                        Log.d("TwitterKit", "Login with Twitter failure", exception);
                    }
                });

            }else{

                Debug.Log("session: " + session + "\nAuthToken: "+token + "\nSecret.token: "+secret);
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                finish();

            }

    }

    public void startTweetList() {
        final Intent intent = new Intent(LoginActivity.this,
                MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Make sure that the loginButton hears the result from any
        // Activity that it triggered.
        Debug.Log("Loggedin! reading onActivityResult");
        loginButton.onActivityResult(requestCode, resultCode, data);
    }

}
