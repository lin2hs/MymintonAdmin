package bbs.lochv.adminbbs;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class NotificationFragment extends Fragment {
    private String[] customerName = {"Huỳnh Văn Lộc", "Nguyễn Hữu Tùng", "Trần Đoàn Linh"};
    private ListView list;

    public NotificationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_notification, container, false);
        list = view.findViewById(R.id.notificationList);

        NotificationAdapter adapter = new NotificationAdapter(getActivity(), customerName);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(), "" + customerName[position], Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

}
