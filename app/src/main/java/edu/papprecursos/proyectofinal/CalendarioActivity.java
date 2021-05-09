package edu.papprecursos.proyectofinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.os.LocaleList;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Locale;

public class CalendarioActivity extends AppCompatActivity {

    CalendarView calendarView;
    TextView myDate;
    Button timeButton;
    int hour, minute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendario);

        calendarView = (CalendarView) findViewById(R.id.calendarioView);
        myDate = (TextView) findViewById(R.id.myDate);
        timeButton = findViewById(R.id.timeButton);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String date = (month + 1) + "/" + dayOfMonth + "/" + year;
                myDate.setText(date);
            }
        });
    }

    public void popTimePicker(View view) {
        TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int selectedHour, int selectedMinute) {
                  hour = selectedHour;
                  minute = selectedMinute;
                  timeButton.setText(String.format(Locale.getDefault(), "%02d:%02d", hour, minute));
            }
        };

        int style = AlertDialog.THEME_HOLO_DARK;

        TimePickerDialog timePickerDialog = new TimePickerDialog(this, style, onTimeSetListener, hour, minute, true);
        timePickerDialog.setTitle("Seleccionar Hora");
        timePickerDialog.show();
    }
}