package com.example.pie_chart;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    PieChart pieChart ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pieChart = (PieChart)findViewById(R.id.piechart);
        pieChart.setUsePercentValues(true);
        pieChart.getDescription().setEnabled(false);
        pieChart.setExtraOffsets(5,10,5,5);

        pieChart.setDragDecelerationFrictionCoef(0.99f);

        pieChart.setDrawHoleEnabled(true);
        pieChart.setHoleColor(Color.WHITE);
        pieChart.setTransparentCircleRadius(60f);

        ArrayList<PieEntry> yvalue = new ArrayList<>();
        yvalue.add(new PieEntry(34f,"PartyA"));
        yvalue.add(new PieEntry(23f,"USA"));
        yvalue.add(new PieEntry(14f,"UK"));
        yvalue.add(new PieEntry(35,"India"));
        yvalue.add(new PieEntry(40,"Russia"));
        yvalue.add(new PieEntry(23,"Japan"));

        //Description desciption = new Description();
        //desciption.setText("Pie Demo");
        //desciption.setTextSize(9);
        //pieChart.setDescription(desciption);

        pieChart.animateY(1000, Easing.EasingOption.EaseInOutCubic);

        PieDataSet dataSet = new PieDataSet(yvalue, "Countries");
        dataSet.setSliceSpace(3f);
        dataSet.setSelectionShift(5.0f);
        dataSet.setColors(ColorTemplate.JOYFUL_COLORS);

        PieData data = new PieData(dataSet);
        data.setValueTextSize(10f);
        data.setValueTextColor(Color.YELLOW);

        pieChart.setData(data);
    }

}
