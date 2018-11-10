package bbs.lochv.adminbbs;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class NotificationAdapter extends ArrayAdapter<String> {
    private Context context;
    private String[] notification;
    private LayoutInflater layoutInflater;

    public NotificationAdapter(Context context, String[] notification) {
        super(context, R.layout.itemrownotification);
        this.context = context;
        this.notification = notification;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null) {
            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.itemrownotification, null);
        }

        TextView notification = convertView.findViewById(R.id.notification);

        Boolean isBooking = true;
        if (isBooking)
            notification.setText(this.notification[position] + "đã đặt sân, xem chi tiết ở trang xác nhận đặt sân");
        else
            notification.setText(this.notification[position] + "đã hủy đặt sân, xem chi tiết vui lòng xem trang danh sách khách hàng");

        return convertView;
    }
}
