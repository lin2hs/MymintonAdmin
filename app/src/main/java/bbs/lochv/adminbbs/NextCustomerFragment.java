package bbs.lochv.adminbbs;


import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.app.Fragment;
import android.util.JsonReader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class NextCustomerFragment extends Fragment {
    private ArrayList<String> CustomerName = new ArrayList<>();// = {"Huỳnh Văn Lộc", "Nguyễn Hữu Tùng", "Trần Đoàn Linh"};
    private ArrayList<String> CustomerPhone= new ArrayList<>(); // = {"01262616380", "01255355165", "01292916255"};
    private ArrayList<String> Date = new ArrayList<>(); // = {"20/10/2018", "21/10/2018", "22/10/2018"};
    private ArrayList<String> Time = new ArrayList<>(); // = {"18:00PM - 20:00PM", "18:00PM - 20:00PM", "18:00PM - 20:00PM"};
    private ArrayList<String> bookingId = new ArrayList<>();
    private ArrayList<CheckItem> listCheck = new ArrayList<>();
    private String bCourtId ;
    private String[] timeSelecte = {"", "7:00AM - 7:30AM", "7:30AM - 8:00AM", "8:00AM - 8:30AM", "8:30AM - 9:00AM", "9:00AM - 9:30AM", "9:30 - 10:00",
            "10:00AM - 10:30AM", "10:30AM - 11:00AM", "11:00AM - 11:30AM", "11:30AM - 12:00AM", "12:00AM - 12:30PM", "12:30PM - 13:00PM",
            "13:00PM - 13:30PM", "13:30PM - 14:00PM", "14:00PM - 14:30PM","14:30PM - 15:00PM", "15:00PM - 15:30PM", "15:30PM - 16:00PM",
            "16:00PM - 16:30PM", "16:30PM - 17:00PM","17:00PM - 17:30PM", "17:30PM - 18:00PM","18:00PM - 18:30PM", "18:30PM - 19:00PM",
            "19:00PM - 19:30PM", "19:30PM - 20:00PM","20:00PM - 20:30PM", "20:30PM - 21:00PM","21:00PM - 21:30PM", "21:30PM - 22:00PM",
            "22:00PM - 22:30PM", "22:30PM - 23:00PM","23:00PM - 23:30PM", "23:30PM - 00:00PM"};
    //private Boolean[] BookingStatus = {true, "", ""}
    private ArrayList<String> stringTime = new ArrayList<>();
    private ListView list;

    public NextCustomerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_next_customer, container, false);
        list = view.findViewById(R.id.nextCustomerList);

        Bundle bundle = getArguments();
        bCourtId = bundle.getString("bCourtId");
        System.out.println(bCourtId);

        new AsyncTaskNextCustomerFragment().doInBackground();


        ArrayList<String> nameSend = new ArrayList<>();
        ArrayList<String> phoneSend= new ArrayList<>();
        ArrayList<String> dateSend = new ArrayList<>();
//        ArrayList<String> bookingIdSend = new ArrayList<>();
//        ArrayList<String> timeSend = new ArrayList<>();
        ArrayList<String> tmp = new ArrayList<>();
        for (int i = 0; i < bookingId.size(); i++) {
            if(!tmp.contains(bookingId.get(i))) {
                tmp.add(bookingId.get(i));
                nameSend.add(CustomerName.get(i));
                phoneSend.add(CustomerPhone.get(i));
                dateSend.add(Date.get(i));
//                bookingIdSend.add(bookingId.get(i));
            }
//                timeSend.add(Time.get(i));
//            } else {
//
//            }
        }



        boolean checkStart = false;
        String date_temp = "";
        String startTime = "";
        String endTime = "";
        ArrayList<String> timeSend = new ArrayList<>();
        for (int i = 0; i < tmp.size(); i++) {
            for (int j = 0; j < Time.size(); j++) {
                if(tmp.get(i).equalsIgnoreCase(bookingId.get(j))) {
                    date_temp = Time.get(j);
                    if (checkStart == false) {
                        startTime = Time.get(j);
                        checkStart = true;
                    }
                }  else {
                    checkStart = false;
                }
            }
            endTime = date_temp;
            if(startTime.equalsIgnoreCase(endTime)) {
                timeSend.add(startTime);
            } else {
                timeSend.add(startTime+endTime);
            }
        }

        String buildTime = "";
        String startTmp= "";
        String endTmp= "";
        for (int i = 0; i < timeSend.size(); i++) {
            if(timeSend.get(i).length() == 4) {
                startTmp = timeSend.get(i).substring(0, 2);
                endTmp = timeSend.get(i).substring(2,4);
                buildTime = timeSelecte[Integer.parseInt(startTmp)].split("-")[0].trim()
                        + " - " + timeSelecte[Integer.parseInt(endTmp)].split("-")[1].trim();
                stringTime.add(buildTime);
            } else {
                stringTime.add(timeSelecte[Integer.parseInt(timeSend.get(i))]);
            }

        }

        NextCustomerAdapter adapter = new NextCustomerAdapter(getActivity(), nameSend, phoneSend, dateSend, stringTime);
        list.setAdapter(adapter);
        return  view;
    }

    private class AsyncTaskNextCustomerFragment extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);

                String linkUrl = "http://" + getResources().getString(R.string.ipAddress) + "/bookingslot/get_list_booking_by_bcourtId?bcourtId=" + bCourtId +"&status=4";
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
                                    if (value.equalsIgnoreCase("nameCustomer")) {
                                        CustomerName.add(jsonReader.nextString());
                                    } else if (value.equalsIgnoreCase("phoneCustomer")) {
                                        CustomerPhone.add(jsonReader.nextString());
                                    } else if (value.equalsIgnoreCase("slotId")) {
                                        Time.add(jsonReader.nextString());
                                    } else if (value.equalsIgnoreCase("bookingDay")) {
                                        Date.add(jsonReader.nextString());
                                    } else if (value.equalsIgnoreCase("bookingId")) {
                                        bookingId.add(jsonReader.nextString());
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
            System.out.println(bCourtId);
            System.out.println("Check fragment Done ");
            return null;
        }
    }


}
