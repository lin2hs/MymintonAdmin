package bbs.lochv.adminbbs;


import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.util.JsonReader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class PromotionFragment extends Fragment {

    private View view;
    private List<String> listOfPromotion;
    private ArrayAdapter<String> listItems;
    private ListView listDisplayPromotion;
    private ArrayList<String> title = new ArrayList<>();
    private ArrayList<String> description = new ArrayList<>();
    private ArrayList<String> promotionValue = new ArrayList<>();
    private ArrayList<String> promotionStatus = new ArrayList<>();
    private ArrayList<String> startTime = new ArrayList<>();
    private ArrayList<String> endTime = new ArrayList<>();

    public PromotionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_promotion, container, false);

        listOfPromotion = new ArrayList<String>();
        listDisplayPromotion = view.findViewById(R.id.listPromotion);
        listOfPromotion.add("Khuyến mãi 1");
        listItems = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_2, android.R.id.text1, listOfPromotion) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                TextView text1 = (TextView) view.findViewById(android.R.id.text1);
                TextView text2 = (TextView) view.findViewById(android.R.id.text2);

                text1.setText(listOfPromotion.get(position).toString());
                text2.setText("Đang khuyến mãi");
                return view;
            }
        };
        listDisplayPromotion.setClickable(true);
        listDisplayPromotion.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getContext(), DemoPromotionActivity.class);
                startActivity(intent);
            }
        });
        listDisplayPromotion.setAdapter(listItems);
        FloatingActionButton fabClickToAddPromotion = view.findViewById(R.id.fabClickToAddPromotion);
        fabClickToAddPromotion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), AddPromotionActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }


    private class AsyncTaskPromotionInformation extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);
                URL githubEndpoint = new URL("http://"  + getResources().getString(R.string.ipAddress) + "/badmintoncourt/get_court_list");
                // Create connection
                HttpURLConnection myConnection = (HttpURLConnection) githubEndpoint.openConnection();
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
                                    if (value.equalsIgnoreCase("title")) {
                                        title.add(jsonReader.nextString());
                                    } else if (value.equalsIgnoreCase("description")) {
                                        description.add(jsonReader.nextString());
                                    } else if (value.equalsIgnoreCase("promotionValue")) {
                                        promotionValue.add(jsonReader.nextString());
                                    } else if (value.equalsIgnoreCase("promotionStatus")) {
                                        promotionStatus.add(jsonReader.nextString());
                                    } else if (value.equalsIgnoreCase("startTime")) {
                                        startTime.add(jsonReader.nextString());
                                    } else if (value.equalsIgnoreCase("endTime")) {
                                        endTime.add(jsonReader.nextString());
                                    } else jsonReader.nextString();
                                }
                                jsonReader.endObject();
                            }
                            jsonReader.endArray();
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
            System.out.println("Load Promotion Information Done!!");
            return null;
        }
    }


    private class AsyncTaskUpdatePromotionInformation extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);
                URL githubEndpoint = new URL("http://"  + getResources().getString(R.string.ipAddress) + "/badmintoncourt/get_court_list");
                // Create connection
                HttpURLConnection myConnection = (HttpURLConnection) githubEndpoint.openConnection();
                if (myConnection.getResponseCode() == 200) {
                    // Success
                    // Further processing here
                    myConnection.disconnect();
                    System.out.println("update promotion done");
                } else {
                    // Error handling code goes here
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("Update Promotion Information Done!!");
            return null;
        }
    }

}
