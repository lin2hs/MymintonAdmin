package bbs.lochv.adminbbs;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.os.StrictMode;
import android.support.v7.widget.RecyclerView;
import android.util.JsonReader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class EditInformationFragment extends Fragment {

    private ArrayList<String> dateList = new ArrayList<>();
    private RecyclerView rvPickedDayOpenInWeek;
    private Button btnEditCourtProfile;
    private ViewSwitcher vscCourtName;
    private ViewSwitcher vscCourtAddress;
    private ViewSwitcher vscCourtPhone;
    private ViewSwitcher vscCourtPrice;
    private TextView txtCourtName;
    private TextView txtCourtAddress;
    private TextView txtCourtPhone;
    private TextView txtCourtPrice;
    private EditText edtCourtName;
    private EditText edtCourtAddress;
    private EditText edtCourtPhone;
    private EditText edtCourtPrice;
    private String name;
    private String address;
    private String price;
    private String phone;
    private String startTime;
    private String endTime;

    public EditInformationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_edit_information, container, false);
        btnEditCourtProfile = view.findViewById(R.id.btnEditCourtProfile);
        vscCourtName = view.findViewById(R.id.vscCourtName);
        vscCourtAddress = view.findViewById(R.id.vscCourtAddress);
        vscCourtPhone = view.findViewById(R.id.vscCourtPhone);
        vscCourtPrice = view.findViewById(R.id.vscCourtPrice);
        txtCourtPrice = view.findViewById(R.id.txtCourtPrice);
        txtCourtName = view.findViewById(R.id.txtCourtName);
        txtCourtAddress = view.findViewById(R.id.txtCourtAddress);
        txtCourtPhone = view.findViewById(R.id.txtCourtPhone);
        edtCourtName = view.findViewById(R.id.edtCourtName);
        edtCourtAddress = view.findViewById(R.id.edtCourtAddress);
        edtCourtPhone = view.findViewById(R.id.edtCourtPhone);
        edtCourtPrice = view.findViewById(R.id.edtCourtPrice);
        btnEditCourtProfile = view.findViewById(R.id.btnEditCourtProfile);
        btnEditCourtProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btnEditCourtProfile.getText().toString().equalsIgnoreCase("Chỉnh sửa")) {
                    makeEditable();
                } else {
                    doneEdit();
                }
            }
        });

        return view;
    }

    private void makeEditable() {
        btnEditCourtProfile.setText("Hoàn Tát");
        btnEditCourtProfile.setBackgroundColor(getResources().getColor(R.color.colorCornflowerBlue));
        vscCourtName.showNext();
        edtCourtName.setText(txtCourtName.getText().toString());
        vscCourtAddress.showNext();
        edtCourtAddress.setText(txtCourtAddress.getText().toString());
        vscCourtPhone.showNext();
        edtCourtPhone.setText(txtCourtPhone.getText().toString());
        vscCourtPrice.showNext();
        int price = txtCourtPrice.getText().toString().indexOf(" ");
        String priceValue = txtCourtPrice.getText().toString().substring(0, price);
        priceValue.replace(".", "");
        edtCourtPrice.setText(priceValue);
    }

    private void doneEdit() {
        vscCourtName.showNext();
        txtCourtName.setText(edtCourtName.getText().toString());
        vscCourtAddress.showNext();
        txtCourtAddress.setText(edtCourtAddress.getText().toString());
        vscCourtPhone.showNext();
        txtCourtPhone.setText(edtCourtPhone.getText().toString());
        vscCourtPrice.showNext();
        String number = edtCourtPrice.getText().toString().replace(".", "");
        Integer amount = Integer.getInteger(number);
        DecimalFormat formatter = new DecimalFormat("#.###");
        txtCourtPrice.setText(String.valueOf(formatter.format(amount)) + " VNĐ");

        btnEditCourtProfile.setText("Chỉnh sửa");
        btnEditCourtProfile.setBackgroundColor(getResources().getColor(R.color.colorGreen));
    }

    private class AsyncTaskUpdateBCourtInformation extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);
                URL githubEndpoint = new URL("http://" + getResources().getString(R.string.ipAddress) + "/badmintoncourt/get_court_list");
                // Create connection
                HttpURLConnection myConnection = (HttpURLConnection) githubEndpoint.openConnection();
                if (myConnection.getResponseCode() == 200) {
                    // Success
                    // Further processing here
                    myConnection.disconnect();
                    System.out.println("update done");
                } else {
                    // Error handling code goes here
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("Load Badminton court Information Done!!");
            return null;
        }
    }

    private class AsyncTaskBCourtInformation extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);
                URL githubEndpoint = new URL("http://" + getResources().getString(R.string.ipAddress) + "/badmintoncourt/get_court_list");
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
                                    if (value.equalsIgnoreCase("address")) {
                                        address = jsonReader.nextString();
                                    } else if (value.equalsIgnoreCase("phone")) {
                                        phone = jsonReader.nextString();
                                    } else if (value.equalsIgnoreCase("price")) {
                                        price = jsonReader.nextString();
                                    } else if (value.equalsIgnoreCase("name")) {
                                        name = jsonReader.nextString();
                                    } else if (value.equalsIgnoreCase("startTime")) {
                                        startTime = jsonReader.nextString();
                                    } else if (value.equalsIgnoreCase("endTime")) {
                                        endTime = jsonReader.nextString();
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
            System.out.println("Load Badminton court Information Done!!");
            return null;
        }
    }


}
