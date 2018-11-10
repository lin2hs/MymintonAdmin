package bbs.lochv.adminbbs;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class AddPromotionActivity extends AppCompatActivity {


    DatePickerDialog.OnDateSetListener date;
    final Calendar calendar = Calendar.getInstance();
    TextView txtStartDay;
    TextView txtEndDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_promotion);
        txtStartDay = findViewById(R.id.txtSelectStartDay);
        txtEndDay = findViewById(R.id.txtSelectEndDay);

    }

    public void clickToSelectMondayDiscount(View view) {
    }

    public void clickToSelectMondayPercentage(View view) {
    }

    public void clickToSelectStartDay(View view) {
        date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, month);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                String format = "dd/MM/yyyy";
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format, Locale.US);
                txtStartDay.setText(simpleDateFormat.format(calendar.getTime()));
            }


        };
        DatePickerDialog datePickerDialog =
                new DatePickerDialog(this, date, calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
        datePickerDialog.show();}


    public void clickToSelectEndDay(View view) {
        date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, month);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                String format = "dd/MM/yyyy";
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format, Locale.US);
                txtEndDay.setText(simpleDateFormat.format(calendar.getTime()));
            }


        };
        DatePickerDialog datePickerDialog =
                new DatePickerDialog(this, date, calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
        datePickerDialog.show();
    }
    }
