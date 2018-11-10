package bbs.lochv.adminbbs;

import android.Manifest;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class CheckListAdapter extends ArrayAdapter<String> {
    private Context context;
    private ArrayList<String> CustomerName;
    private ArrayList<String> CustomerPhone;
    private ArrayList<String> Date;
    private ArrayList<String> Time;
    private ArrayList<String> BookingIDSend;
    private LayoutInflater layoutInflater;
//    private Button calling;
//    private Button confirm;
//    private Button cancel;
    private Dialog dialog;
    private String selectedBookingId;
    private int selectedPosition;
    private boolean result;

    public CheckListAdapter(Context context, ArrayList<String> CustomerName, ArrayList<String> CustomerPhone, ArrayList<String> Date, ArrayList<String> Time, ArrayList<String> BookingIDSend) {
        super(context, R.layout.itemrow, CustomerName);
        this.context = context;
        this.CustomerName = CustomerName;
        this.CustomerPhone = CustomerPhone;
        this.Date = Date;
        this.Time = Time;
        this.BookingIDSend = BookingIDSend;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (layoutInflater == null) {
            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if (convertView == null) {


            convertView = layoutInflater.inflate(R.layout.itemrow, null);

        }

        TextView name = convertView.findViewById(R.id.customerName);
        final TextView phone = convertView.findViewById(R.id.customerPhone);
        TextView date = convertView.findViewById(R.id.date);
        TextView time = convertView.findViewById(R.id.time);

        Button call = convertView.findViewById(R.id.calling);
        Button confirm = convertView.findViewById(R.id.confirm);
        Button cancel = convertView.findViewById(R.id.cancel);


        name.setText(CustomerName.get(position));
        phone.setText(CustomerPhone.get(position));
        date.setText(Date.get(position));
        time.setText(Time.get(position));
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:" +  CustomerPhone.get(position)));//CustomerPhone.get(position)
                if (ActivityCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
//                v.getContext().startActivity(callIntent);
                context.startActivity(callIntent);
            }
        });

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedBookingId = BookingIDSend.get(position);
                selectedPosition = position;
                showDialog();
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedBookingId = BookingIDSend.get(position);
                selectedPosition = position;
                showCancelDialog();
            }
        });


        return convertView;
    }

    public void showCancelDialog() {
        dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.canceldialog);
        dialog.show();
        Button no = dialog.findViewById(R.id.cancelno);
        Button yes = dialog.findViewById(R.id.cancelyes);
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.hide();
            }
        });
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ListView updateListView = v.findViewById(R.id.checkList);
                new AsyncTaskUpdateStatus3().doInBackground();

                if (result) {
                    CustomerName.remove(selectedPosition);
                    CustomerPhone.remove(selectedPosition);
                    Date.remove(selectedPosition);
                    Time.remove(selectedPosition);
                    BookingIDSend.remove(selectedPosition);
                    CheckListAdapter.this.notifyDataSetChanged();
                    dialog.hide();
                } else {
                    dialog.hide();
                }
            }
        });
    }

    public void showDialog() {
        dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.acceptdialog);
        dialog.show();
        Button no = dialog.findViewById(R.id.confirmno);
        Button yes = dialog.findViewById(R.id.confirmyes);
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.hide();
            }
        });
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ListView updateListView = v.findViewById(R.id.checkList);
                new AsyncTaskUpdateStatus4().doInBackground();

                if(result) {
                    CustomerName.remove(selectedPosition);
                    CustomerPhone.remove(selectedPosition);
                    Date.remove(selectedPosition);
                    Time.remove(selectedPosition);
                    BookingIDSend.remove(selectedPosition);
                    CheckListAdapter.this.notifyDataSetChanged();
                    dialog.hide();
                } else {
                    dialog.hide();
                }

//                courtName.remove(selectedPosition);
//                timeBooking.remove(selectedPosition);
//                slotBooking.remove(selectedPosition);
//                bookingId.remove(selectedPosition);
//                adapter.notifyDataSetChanged();
//                dialog.hide();
            }
        });


    }

    private class AsyncTaskUpdateStatus4 extends AsyncTask<Void, Void, Void> {
        // 4 la da dat
        @Override
        protected Void doInBackground(Void... voids) {
            try {
                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);

                String linkUrl = "http://"+ context.getResources().getString(R.string.ipAddress) + "/bookingslot/update?bookingStatus=4&bookingID=" + selectedBookingId;
                URL url = new URL(linkUrl);

                // Create connection
                HttpURLConnection myConnection = (HttpURLConnection) url.openConnection();


                if (myConnection.getResponseCode() == 200) {

                    System.out.println("Update successful");
                } else {
                    // Error handling code goes here
                }
                result = true;
                myConnection.disconnect();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {

            }

            System.out.println("update Done ");
            return null;
        }
    }

    private class AsyncTaskUpdateStatus3 extends AsyncTask<Void, Void, Void> {
        //3 la da huy
        @Override
        protected Void doInBackground(Void... voids) {
            try {
                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);

                String linkUrl = "http://"+ context.getResources().getString(R.string.ipAddress) + "/bookingslot/update?bookingStatus=3&bookingID=" + selectedBookingId;
                URL url = new URL(linkUrl);

                // Create connection
                HttpURLConnection myConnection = (HttpURLConnection) url.openConnection();


                if (myConnection.getResponseCode() == 200) {

                    System.out.println("Update successful");
                } else {
                    // Error handling code goes here
                }
                result = true;
                myConnection.disconnect();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {

            }

            System.out.println("update Done ");
            return null;
        }
    }
}

