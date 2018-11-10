package bbs.lochv.adminbbs;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;



public class CustomeAdapter extends FragmentPagerAdapter {
    private Context mContext;
    private String bCourtId;
    private Bundle bundle;
    ArrayList<String> listPickedSlots = new ArrayList<>();


    public CustomeAdapter(Context mContext, FragmentManager fm, String bCourtId) {
        super(fm);
        this.mContext = mContext;
        this.bCourtId = bCourtId;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment f = null;
        //Fragment f1 = null;
        if (position == 0) {
            f = new CheckFragment();
            bundle = new Bundle();
            bundle.putString("bCourtId", bCourtId);
            f.setArguments(bundle);
            return f;
        } else if (position == 1) {
            f = new NextCustomerFragment();
            bundle = new Bundle();
            bundle.putString("bCourtId", bCourtId);
            f.setArguments(bundle);
            return f;
        } else if (position == 2){
            f = new PromotionFragment();
            bundle = new Bundle();
            f.setArguments(bundle);
            return f;
        } else if (position == 3){
            f = new EditInformationFragment();
//            listPickedSlots.add("Thứ 2");
//            listPickedSlots.add("Thứ 3");
//            listPickedSlots.add("Thứ 4");
//            listPickedSlots.add("Thứ 5");
//            listPickedSlots.add("Thứ 6");
//            listPickedSlots.add("Thứ 7");
//            listPickedSlots.add("Chủ nhật");
            bundle = new Bundle();
//            bundle.putStringArrayList("dateList", listPickedSlots);
            f.setArguments(bundle);
            return f;
        } else {

        }
        return f;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Yêu cầu";
            case 1:
                return "Lịch sắp tới";
            case 2:
                return "Khuyến mãi";
            case 3:
                return "Thông tin sân";
            default:
                return null;
        }
    }
}