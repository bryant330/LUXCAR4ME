package kakibuku.hou.com.luxcar4me;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTouch;

public class SearchActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{

    @Bind(R.id.pickup_date) EditText pickupDateView;
    @Bind(R.id.return_date) EditText returnDateView;

    boolean isStartingDate = false;
    Calendar pickupDate = null;
    Calendar returnDate = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.fab)
    void onClickNeext(){
        Intent intent = new Intent(SearchActivity.this, ResultsActivity.class);
        startActivity(intent);
    }

    void showDatePicker(boolean isStartingDate) {
        this.isStartingDate = isStartingDate;
        Calendar calendar = Calendar.getInstance();

        // Show dialog
        DatePickerDialog dialog = new DatePickerDialog(
                this, this,
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
        );
        dialog.getDatePicker().setMinDate(calendar.getTimeInMillis());
        dialog.show();

    }


    @Override
    public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, monthOfYear, dayOfMonth);

        SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy", Locale.getDefault());
        String dateText = formatter.format(calendar.getTime());

        // TODO: update data views
        if (isStartingDate) {
            pickupDate = calendar;
            pickupDateView.setText(dateText);
        } else {
            returnDate = calendar;
            returnDateView.setText(dateText);
        }
    }

    @OnTouch(R.id.pickup_date)
    boolean onTouchStartDate(View view, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_UP)
            showDatePicker(true);
        return true;
    }

    @OnTouch(R.id.return_date)
    boolean onTouchEndingDate(View view, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_UP)
            showDatePicker(false);
        return true;
    }


}




















