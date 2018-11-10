package bbs.lochv.adminbbs;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.JsonReader;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class LoginActivity extends Activity {

    private EditText phoneNumber;
    private EditText password;
    private Button login;
    private String result;
    private String staffId;
    private String bCourtId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        phoneNumber = findViewById(R.id.txtLoginPhone);
        password = findViewById(R.id.txtLoginPassword);
        login = findViewById(R.id.btnLogin);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println(result);
                new AsyncTaskLogin().doInBackground();
                if (result.equals("true")) {
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("bCourtId", bCourtId);
                    intent.putExtras(bundle);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    private class AsyncTaskLogin extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);

                String linkUrl = "http://" + getResources().getString(R.string.ipAddress) + "/account/check_login?username=" + phoneNumber.getText().toString() + "&password=" + password.getText().toString() + "&role=2";
                URL url = new URL(linkUrl);
                System.out.println(linkUrl);
                // Create connection
                HttpURLConnection myConnection = (HttpURLConnection) url.openConnection();

                if (myConnection.getResponseCode() == 200) {
                    // Success
                    // Further processing here
                    InputStream responseBody = myConnection.getInputStream();
                    InputStreamReader responseBodyReader = new InputStreamReader(responseBody, "UTF-8");
                    JsonReader jsonReader = new JsonReader(responseBodyReader);

                    //start Reading
                    jsonReader.beginObject(); // Start processing the JSON object
                    while (jsonReader.hasNext()) { // Loop through all keys
                        String key = jsonReader.nextName(); // Fetch the next key
                        if (key.equals("data")) { // Check if desired key

                            // Fetch the value as a String
                            jsonReader.beginArray();
                            while (jsonReader.hasNext()) {
                                jsonReader.beginObject();
                                while (jsonReader.hasNext()) {
                                    String value = jsonReader.nextName();
                                    if (value.equalsIgnoreCase("result")) {
                                        result = jsonReader.nextString();
                                    } else if (value.equalsIgnoreCase("staffId")) {
                                        staffId = jsonReader.nextString();
                                    } else if (value.equalsIgnoreCase("bCourtId")) {
                                        bCourtId = jsonReader.nextString();
                                    } else jsonReader.nextString();
                                }
                                jsonReader.endObject();
                            }
                            jsonReader.endArray();

                            // Do something with the value
                            // ...

                            break; // Break out of the loop
                        } else {
                            jsonReader.skipValue(); // Skip values of other keys
                        }

                    }
                    jsonReader.close();
                    myConnection.disconnect();
                } else {
                    // Error handling code goes here
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(result);
            System.out.println(staffId);
            System.out.println(bCourtId);
            System.out.println("Check Login Done ");
            return null;
        }
    }


}
