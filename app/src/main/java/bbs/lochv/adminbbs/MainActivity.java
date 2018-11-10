package bbs.lochv.adminbbs;

import android.app.Dialog;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
//
//    private Dialog dialog;
//    public TextView txtCalendar;
//    public Context thisContext = this;
//    public FloatingActionButton fabClickToAddPromotion;
//    public Button btnEditCourtProfile;
//    public ViewSwitcher vscCourtName;
//    public ViewSwitcher vscCourtAddress;
//    public ViewSwitcher vscCourtPhone;
//    public ViewSwitcher vscCourtPrice;
//    public TextView txtCourtName;
//    public TextView txtCourtAddress;
//    public TextView txtCourtPhone;
//    public TextView txtCourtPrice;
//    public EditText edtCourtName;
//    public EditText edtCourtAddress;
//    public EditText edtCourtPhone;
//    public EditText edtCourtPrice;
//    public RecyclerView rvPickedDayOpenInWeek;
//    public RecyclerView recyclerViewInPopup;
//    public List<String> listSlotToPick;
//    public List<String> listPickedSlots;
//    public RecyclerView.Adapter pickingSlotAdapter;
//    public View popupView;
//    public PopupWindow popupWindow;
//    public TextView txtSlot;
//    public LinearLayout slotLayout;
//    public TextView txtCourtStartTime;
//    public TextView txtCourtEndTime;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        listSlotToPick = new ArrayList<>();
//        listSlotToPick.add("Thứ 2");
//        listSlotToPick.add("Thứ 3");
//        listSlotToPick.add("Thứ 4");
//        listSlotToPick.add("Thứ 5");
//        listSlotToPick.add("Thứ 6");
//        listSlotToPick.add("Thứ 7");
//        listSlotToPick.add("Chủ nhật");
//        listPickedSlots = new ArrayList<>();
//        listPickedSlots.add("Thứ 2");
//        listPickedSlots.add("Thứ 3");
//        listPickedSlots.add("Thứ 4");
//        listPickedSlots.add("Thứ 5");
//        listPickedSlots.add("Thứ 6");
//        listPickedSlots.add("Thứ 7");
//        listPickedSlots.add("Chủ nhật");
//
//        ViewPager viewPager = findViewById(R.id.viewPager);
//        String bCourtId = "1";
//        Bundle bundle = getIntent().getExtras();
////        bCourtId = bundle.getString("bCourtId");
//
//
//        CustomeAdapter adapter = new CustomeAdapter(this, getSupportFragmentManager(), bCourtId);
//        viewPager.setAdapter(adapter);
//
//        TabLayout tabLayout = findViewById(R.id.tab);
//        tabLayout.setupWithViewPager(viewPager);
//        //tabLayout.setupWithViewPager(viewPager, true);
//    }
//
//    public void clickToEditInformation(View view) {
//        final View viewInClick = view;
//        final Context contextInClick = thisContext;
//        if (vscCourtName == null) {
//            vscCourtName = findViewById(R.id.vscCourtName);
//            vscCourtAddress = findViewById(R.id.vscCourtAddress);
//            vscCourtPhone = findViewById(R.id.vscCourtPhone);
//            vscCourtPrice = findViewById(R.id.vscCourtPrice);
//            txtCourtPrice = findViewById(R.id.txtCourtPrice);
//            txtCourtName = findViewById(R.id.txtCourtName);
//            txtCourtAddress = findViewById(R.id.txtCourtAddress);
//            txtCourtPhone = findViewById(R.id.txtCourtPhone);
//            edtCourtName = findViewById(R.id.edtCourtName);
//            edtCourtAddress = findViewById(R.id.edtCourtAddress);
//            edtCourtPhone = findViewById(R.id.edtCourtPhone);
//            edtCourtPrice = findViewById(R.id.edtCourtPrice);
//            btnEditCourtProfile = findViewById(R.id.btnEditCourtProfile);
//            rvPickedDayOpenInWeek = findViewById(R.id.rvDayOpenInWeek);
//
//            PickedSlotAdapter pickedSlotAdapter = new PickedSlotAdapter(thisContext, listPickedSlots);
//            rvPickedDayOpenInWeek.setAdapter(pickedSlotAdapter);
//            rvPickedDayOpenInWeek.setLayoutManager(new GridLayoutManager(thisContext, 3));
//            txtCalendar = findViewById(R.id.txtCalendar);
//            //Get item's layout
//            LayoutInflater inflater = (LayoutInflater)
//                    getSystemService(LAYOUT_INFLATER_SERVICE);
//            popupView = inflater.inflate(R.layout.popup_booking_slot, null);
//            //Set list layout of items
//            recyclerViewInPopup = popupView.findViewById(R.id.rvBookingSlots);
//            TextView title = popupView.findViewById(R.id.txtPopupTitle);
//            title.setText("Chọn lịch mở cửa");
//            TextView submitButton = popupView.findViewById(R.id.btnSubmitBookingSlots);
//            submitButton.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    PickedSlotAdapter pickedSlotAdapter = new PickedSlotAdapter(thisContext, listPickedSlots);
//                    rvPickedDayOpenInWeek.setAdapter(pickedSlotAdapter);
//                    rvPickedDayOpenInWeek.setLayoutManager(new GridLayoutManager(thisContext, 3));
//                    popupWindow.dismiss();
//                }
//            });
//            TextView cancelButton = popupView.findViewById(R.id.btnDismissBookingSlots);
//            cancelButton.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    popupWindow.dismiss();
//                }
//            });
//            txtCourtStartTime = findViewById(R.id.txtCourtStartTime);
//            txtCourtStartTime.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    selectStartTime();
//                }
//            });
//            txtCourtEndTime = findViewById(R.id.txtCourtEndTime);
//            txtCourtEndTime.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    selectEndTime();
//                }
//            });
//            //Enable scroll bar
//            recyclerViewInPopup.setVerticalScrollBarEnabled(true);
//            recyclerViewInPopup.setHasFixedSize(true);
//            //Create popupWindow with popupView
//            popupWindow = new PopupWindow(popupView, WindowManager.LayoutParams.WRAP_CONTENT,
//                    WindowManager.LayoutParams.WRAP_CONTENT, true);
//            //Edit popupWindow
//            popupWindow.setTouchable(true);
//            //Close popup when touch outsides
//            popupWindow.setOutsideTouchable(true);
//
//            recyclerViewInPopup.addOnItemTouchListener(new RecyclerItemClickListener(thisContext, recyclerViewInPopup, new RecyclerItemClickListener.OnItemClickListener() {
//                @Override
//                public void onItemClick(View view, int position) {
//                    txtSlot = view.findViewById(R.id.txtSlot);
//                    slotLayout = view.findViewById(R.id.ItemSlotsLayout);
//                    boolean clicked = false;
//                    for (int i = 0; i < listPickedSlots.size(); i++) {
//                        if (listPickedSlots.get(i).matches(listSlotToPick.get(position))) {
//                            slotLayout = recyclerViewInPopup.getChildAt(position).findViewById(R.id.ItemSlotsLayout);
//                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
//                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//                                    slotLayout.setBackground(getDrawable(R.drawable.slots_border_available));
//                                }
//                            }
//                            txtSlot.setTextColor(Color.GRAY);
//                            listPickedSlots.remove(i);
//                            clicked = true;
//                            break;
//                        }
//                    }
//                    if (!clicked) {
//                        slotLayout = recyclerViewInPopup.getChildAt(position).findViewById(R.id.ItemSlotsLayout);
//                        txtSlot = recyclerViewInPopup.getChildAt(position).findViewById(R.id.txtSlot);
//                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
//                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//                                slotLayout.setBackground(getDrawable(R.drawable.slots_border_clicked));
//                            }
//                        }
//                        txtSlot.setTextColor(Color.WHITE);
//                        listPickedSlots.add(listSlotToPick.get(position));
//                    }
//                }
//
//                @Override
//                public void onLongItemClick(View view, int position) {
//
//                }
//            }));
//
////            rvPickedDayOpenInWeek = findViewById(R.id.rvDayOpenInWeek);
////            pickingSlotAdapter = new PickingSlotAdapter(thisContext, listSlotToPick, listPickedSlots);
////            rvPickedDayOpenInWeek.setAdapter(pickingSlotAdapter);
////            rvPickedDayOpenInWeek.setLayoutManager(new GridLayoutManager(thisContext, 2));
//        }
//        if (btnEditCourtProfile.getText().toString().equalsIgnoreCase("Chỉnh sửa")) {
//            //Enable edit
//            vscCourtName.showNext();
//            edtCourtName.setText(txtCourtName.getText().toString());
//            vscCourtAddress.showNext();
//            edtCourtAddress.setText(txtCourtAddress.getText().toString());
//            vscCourtPhone.showNext();
//            edtCourtPhone.setText(txtCourtPhone.getText().toString());
//            vscCourtPrice.showNext();
//            int price = txtCourtPrice.getText().toString().indexOf(" ");
//            String priceValue = txtCourtPrice.getText().toString().substring(0, price);
//            edtCourtPrice.setText(priceValue);
//
//
//            txtCalendar.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    pickingSlotAdapter = new PickingSlotAdapter(contextInClick, listSlotToPick, listPickedSlots);
//                    recyclerViewInPopup.setAdapter(pickingSlotAdapter);
//                    recyclerViewInPopup.setLayoutManager(new GridLayoutManager(thisContext, 3));
//                    popupWindow.showAtLocation(viewInClick, Gravity.CENTER, 0, 0);
//                    dimBehind(popupWindow);
//                }
//            });
//
//            btnEditCourtProfile.setBackgroundColor(getResources().getColor(R.color.colorCornflowerBlue));
//            btnEditCourtProfile.setText("Hoàn Tất");
//        } else {
//            //Disable edit
//            vscCourtName.showNext();
//            txtCourtName.setText(edtCourtName.getText().toString());
//            vscCourtAddress.showNext();
//            txtCourtAddress.setText(edtCourtAddress.getText().toString());
//            vscCourtPhone.showNext();
//            txtCourtPhone.setText(edtCourtPhone.getText().toString());
//            vscCourtPrice.showNext();
//            txtCourtPrice.setText(edtCourtPrice.getText().toString() + " VNĐ");
//
//            btnEditCourtProfile.setText("Chỉnh sửa");
//            btnEditCourtProfile.setBackgroundColor(getResources().getColor(R.color.colorGreen));
//        }
//    }
//
//
//    public void dimBehind(PopupWindow popupWindow) {
//        View container = (View) popupWindow.getContentView().getParent();
//        Context context = popupWindow.getContentView().getContext();
//        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
//        WindowManager.LayoutParams p = (WindowManager.LayoutParams) container.getLayoutParams();
//        p.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
//        p.dimAmount = 0.8f;
//        wm.updateViewLayout(container, p);
//    }
//
//    private void selectStartTime() {
//        Calendar mcurrentTime = Calendar.getInstance();
//        int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
//        int minute = mcurrentTime.get(Calendar.MINUTE);
//        TimePickerDialog mTimePicker;
//        mTimePicker = new TimePickerDialog(thisContext, new TimePickerDialog.OnTimeSetListener() {
//            @Override
//            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
//                txtCourtStartTime.setText("" + selectedHour + ":" + selectedMinute);
//            }
//        }, hour, minute, true);
//        mTimePicker.setTitle("Select Time");
//        mTimePicker.show();
//    }
//
//    private void selectEndTime() {
//        Calendar mcurrentTime = Calendar.getInstance();
//        int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
//        int minute = mcurrentTime.get(Calendar.MINUTE);
//        TimePickerDialog mTimePicker;
//        mTimePicker = new TimePickerDialog(thisContext, new TimePickerDialog.OnTimeSetListener() {
//            @Override
//            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
//                txtCourtEndTime.setText("" + selectedHour + ":" + selectedMinute);
//            }
//        }, hour, minute, true);
//        mTimePicker.setTitle("Select Time");
//        mTimePicker.show();
//    }

    // Code to merge


    private Dialog dialog;
    private TabLayout tabs;
    private String bCourtId = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        ViewPager viewPager = findViewById(R.id.viewPager);

        final Bundle bundle = getIntent().getExtras();
//        bCourtId = bundle.getString("bCourtId");
        bCourtId = "1";

//        CustomeAdapter adapter = new CustomeAdapter(this, getSupportFragmentManager(), bCourtId);
//        viewPager.setAdapter(adapter);
//
//        final TabLayout tabLayout = findViewById(R.id.tab);
//        tabLayout.setupWithViewPager(viewPager);
        //tabLayout.setupWithViewPager(viewPager, true);
        tabs = findViewById(R.id.tab);
        tabs.addTab(tabs.newTab().setText("Yêu cầu"), true);
        tabs.addTab(tabs.newTab().setText("Lịch sân"));
        tabs.addTab(tabs.newTab().setText("Khuyến mãi"));
        tabs.addTab(tabs.newTab().setText("Thông tin"));

        tabs.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        CheckFragment cf = new CheckFragment();
                        Bundle checkBundle = new Bundle();
                        checkBundle.putString("bCourtId", bCourtId);
                        cf.setArguments(checkBundle);
                        replaceFragment(cf);
                        break;
                    case 1:
                        NextCustomerFragment nxf = new NextCustomerFragment();
                        Bundle nextCustomerBundle = new Bundle();
                        nextCustomerBundle.putString("bCourtId", bCourtId);
                        nxf.setArguments(nextCustomerBundle);
                        replaceFragment(nxf);
                        break;
                    case 2:
                        PromotionFragment pmf = new PromotionFragment();
                        Bundle promotionBundle = new Bundle();
                        promotionBundle.putString("bCourtId", bCourtId);
                        pmf.setArguments(promotionBundle);
                        replaceFragment(pmf);
                        break;
                    case 3:
                        EditInformationFragment edf = new EditInformationFragment();
                        Bundle editInfoBundle = new Bundle();
                        editInfoBundle.putString("bCourtId", bCourtId);
                        edf.setArguments(editInfoBundle);
                        replaceFragment(edf);
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    public void replaceFragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragment_container, fragment);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.commit();
    }


    // End code to merge
}
