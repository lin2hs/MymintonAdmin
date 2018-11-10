package bbs.lochv.adminbbs;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class NextCustomerAdapter extends ArrayAdapter<String> {
    private Context context;
    private ArrayList<String> CustomerName;
    private ArrayList<String> CustomerPhone;
    private ArrayList<String> Date;
    private ArrayList<String> Time;
//    private Boolean[] isAccept;
    private LayoutInflater layoutInflater;

    public NextCustomerAdapter(Context context, ArrayList<String> CustomerName, ArrayList<String> CustomerPhone, ArrayList<String> Date, ArrayList<String> Time) {
        super(context, R.layout.itemrownextcustomer, CustomerName);
        this.context = context;
        this.CustomerName = CustomerName;
        this.CustomerPhone = CustomerPhone;
        this.Date = Date;
        this.Time = Time;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null) {
            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.itemrownextcustomer, null);

        }

        TextView customerName = convertView.findViewById(R.id.customerName);
        TextView customerPhone = convertView.findViewById(R.id.customerPhone);
        TextView date = convertView.findViewById(R.id.date);
        TextView time = convertView.findViewById(R.id.time);
//        TextView result = convertView.findViewById(R.id.result);
        Button call = convertView.findViewById(R.id.calling);

        customerName.setText(CustomerName.get(position));
        customerPhone.setText(CustomerPhone.get(position));
        date.setText(Date.get(position));
        time.setText(Time.get(position));
//        if(isAccept[position]) {
//            result.setText("Đã xác nhận");
//        } else
//            result.setText("Đã hủy");

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

        return convertView;
    }
}
