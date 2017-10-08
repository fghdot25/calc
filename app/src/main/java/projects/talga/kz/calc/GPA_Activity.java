package projects.talga.kz.calc;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.liuguangqiang.swipeback.SwipeBackActivity;
import com.liuguangqiang.swipeback.SwipeBackLayout;

public class GPA_Activity extends SwipeBackActivity implements AdapterView.OnItemSelectedListener {

    Spinner spinner1, spinner2, spinner3, spinner4, spinner5, spinner6, spinner7, spinner8;

    EditText credit1EditText, credit2EditText, credit3EditText,
             credit4EditText, credit5EditText, credit6EditText,
             credit7EditText, credit8EditText;

    TextView resultGPA;


    String sSelected;

    int totalOfCredits = 0;

    double[] GPAGRADES = {4.0, 3.67, 3.33, 3.0, 2.67, 2.33, 2.0, 1.67, 1.33, 1.0, 0.0};
    double totalOfGrades = 0, totalOfCourses = 0;
    double course1 = 0,course2 = 0,course3 = 0,course4 = 0,course5 = 0,course6 = 0,course7 = 0,course8 = 0;
    double a, aMinus, bPlus, b, bMinus, cPlus, c, cMinus, dPlus, d, f;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gpa_);
        setDragEdge(SwipeBackLayout.DragEdge.LEFT);

        spinnerStart();
    }

    private void spinnerStart() {
        spinner1 = (Spinner) findViewById(R.id.spinner_one);
        spinner2 = (Spinner) findViewById(R.id.spinner_two);
        spinner3 = (Spinner) findViewById(R.id.spinner_three);
        spinner4 = (Spinner) findViewById(R.id.spinner_four);
        spinner5 = (Spinner) findViewById(R.id.spinner_five);
        spinner6 = (Spinner) findViewById(R.id.spinner_six);
        spinner7 = (Spinner) findViewById(R.id.spinner_seven);
        spinner8 = (Spinner) findViewById(R.id.spinner_eight);


        // ADAPTER 1
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.grade_names, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);
        spinner1.setOnItemSelectedListener(this);


        // ADAPTER 2
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.grade_names, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);
        spinner2.setOnItemSelectedListener(this);


        // ADAPTER 3
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this, R.array.grade_names, android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(adapter3);
        spinner3.setOnItemSelectedListener(this);


        // ADAPTER 4
        ArrayAdapter<CharSequence> adapter4 = ArrayAdapter.createFromResource(this, R.array.grade_names, android.R.layout.simple_spinner_item);
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner4.setAdapter(adapter4);
        spinner4.setOnItemSelectedListener(this);


        // ADAPTER 5
        ArrayAdapter<CharSequence> adapter5 = ArrayAdapter.createFromResource(this, R.array.grade_names, android.R.layout.simple_spinner_item);
        adapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner5.setAdapter(adapter5);
        spinner5.setOnItemSelectedListener(this);


        // ADAPTER 6
        ArrayAdapter<CharSequence> adapter6 = ArrayAdapter.createFromResource(this, R.array.grade_names, android.R.layout.simple_spinner_item);
        adapter6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner6.setAdapter(adapter6);
        spinner6.setOnItemSelectedListener(this);


        // ADAPTER 7
        ArrayAdapter<CharSequence> adapter7 = ArrayAdapter.createFromResource(this, R.array.grade_names, android.R.layout.simple_spinner_item);
        adapter7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner7.setAdapter(adapter7);
        spinner7.setOnItemSelectedListener(this);


        // ADAPTER 8
        ArrayAdapter<CharSequence> adapter8 = ArrayAdapter.createFromResource(this, R.array.grade_names, android.R.layout.simple_spinner_item);
        adapter8.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner8.setAdapter(adapter8);
        spinner8.setOnItemSelectedListener(this);


    }

    public void displayGpa(View view) {
        editTextValues();

        double res = totalOfCourses/totalOfCredits;
        res = Math.round(res*100.0)/100.0;
        resultGPA = (TextView) findViewById(R.id.gpa_result_text_view);
        resultGPA.setText(res+"");

    }

    private void editTextValues() {
        credit1EditText = (EditText) findViewById(R.id.credit1_tv);
        credit2EditText = (EditText) findViewById(R.id.credit2_tv);
        credit3EditText = (EditText) findViewById(R.id.credit3_tv);
        credit4EditText = (EditText) findViewById(R.id.credit4_tv);
        credit5EditText = (EditText) findViewById(R.id.credit5_tv);
        credit6EditText = (EditText) findViewById(R.id.credit6_tv);
        credit7EditText = (EditText) findViewById(R.id.credit7_tv);
        credit8EditText = (EditText) findViewById(R.id.credit8_tv);

        if (credit1EditText.getText().length() > 0) {

            int x = (int) spinner1.getSelectedItemId()-1;
            int t = Integer.parseInt(credit1EditText.getText() + "");
            // = spinnerValues.get(0) * Integer.parseInt(credit1EditText.getText() + "");;
            course1 = t * GPAGRADES[x];
            // selectedItem(course1);
            totalOfCredits+=t;
            totalOfGrades+=GPAGRADES[x];
            totalOfCourses +=course1;


        }
        if (credit2EditText.getText().length() > 0) {
            int x = (int) spinner2.getSelectedItemId()-1;
            int t = Integer.parseInt(credit2EditText.getText() + "");
            course2 = t * GPAGRADES[x];
            totalOfCredits+=t;
            totalOfGrades+=GPAGRADES[x];
            totalOfCourses += course2;

        }
        if (credit3EditText.getText().length() > 0) {
            int x = (int) spinner3.getSelectedItemId()-1;
            int t = Integer.parseInt(credit3EditText.getText() + "");
            course3 = t * GPAGRADES[x];
            totalOfCredits+=t;
            totalOfGrades+=GPAGRADES[x];
            totalOfCourses += course3;
        }
        if (credit4EditText.getText().length() > 0) {
            int x = (int) spinner4.getSelectedItemId()-1;
            int t = Integer.parseInt(credit4EditText.getText() + "");
            course4 = t * GPAGRADES[x];
            totalOfCredits+=t;
            totalOfGrades+=GPAGRADES[x];
            totalOfCourses += course4;
        }
        if (credit5EditText.getText().length() > 0) {
            int x = (int) spinner5.getSelectedItemId()-1;
            int t = Integer.parseInt(credit5EditText.getText() + "");
            course5 = t * GPAGRADES[x];
            totalOfCredits+=t;
            totalOfGrades+=GPAGRADES[x];
            totalOfCourses += course5;
        }
        if (credit6EditText.getText().length() > 0) {
            int x = (int) spinner6.getSelectedItemId()-1;
            int t = Integer.parseInt(credit6EditText.getText() + "");
            course6 = t * GPAGRADES[x];
            totalOfCredits+=t;
            totalOfGrades+=GPAGRADES[x];
            totalOfCourses += course6;
        }
        if (credit7EditText.getText().length() > 0) {
            int x = (int) spinner7.getSelectedItemId()-1;
            int t = Integer.parseInt(credit7EditText.getText() + "");
            course7 = t * GPAGRADES[x];
            totalOfCredits+=t;
            totalOfGrades+=GPAGRADES[x];
            totalOfCourses += course7;
        }
        if (credit8EditText.getText().length() > 0) {
            int x = (int) spinner8.getSelectedItemId()-1;
            int t = Integer.parseInt(credit8EditText.getText() + "");
            course8 = t * GPAGRADES[x];
            totalOfCredits+=t;
            totalOfGrades+=GPAGRADES[x];
            totalOfCourses += course8;
        }

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        sSelected = adapterView.getItemAtPosition(i).toString();
        //A
        if (sSelected.equalsIgnoreCase("a")) {
            a = GPAGRADES[0];
            //Toast.makeText(this, (a + ""), Toast.LENGTH_LONG).show();
        }
        //A PLUS
        if (sSelected.equalsIgnoreCase("a-")) {

            aMinus = GPAGRADES[1];
            //Toast.makeText(this, (aMinus + ""), Toast.LENGTH_LONG).show();
        }
        //B PLUS
        if (sSelected.equalsIgnoreCase("b+")) {

            bPlus = GPAGRADES[2];
            // Toast.makeText(this, (bPlus + ""), Toast.LENGTH_LONG).show();
        }

        if (sSelected.equalsIgnoreCase("b")) {

            b = GPAGRADES[3];
            // Toast.makeText(this, (b + ""), Toast.LENGTH_LONG).show();
        }
        if (sSelected.equalsIgnoreCase("b-")) {

            bMinus = GPAGRADES[4];
            // Toast.makeText(this, (bMinus+""), Toast.LENGTH_LONG).show();
        }

        if (sSelected.equalsIgnoreCase("c+")) {

            cPlus = GPAGRADES[5];
            // Toast.makeText(this, (cPlus+""), Toast.LENGTH_LONG).show();
        }

        if (sSelected.equalsIgnoreCase("c")) {

            c = GPAGRADES[6];
            //   Toast.makeText(this, (c+""), Toast.LENGTH_LONG).show();
        }

        if (sSelected.equalsIgnoreCase("c-")) {

            cMinus = GPAGRADES[7];
            //    Toast.makeText(this, (cMinus+""), Toast.LENGTH_LONG).show();
        }

        if (sSelected.equalsIgnoreCase("d+")) {

            dPlus = GPAGRADES[8];
            //   Toast.makeText(this, (dPlus+""), Toast.LENGTH_LONG).show();
        }

        if (sSelected.equalsIgnoreCase("d")) {
            d = GPAGRADES[9];
            //    Toast.makeText(this, (d+""), Toast.LENGTH_LONG).show();
        }
        if (sSelected.equalsIgnoreCase("f")) {
            f = GPAGRADES[10];
            //     Toast.makeText(this, (f+""), Toast.LENGTH_LONG).show();
        }

    }


    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void resetAll(View view) {
        spinner1.setSelection(0);
        spinner2.setSelection(0);
        spinner3.setSelection(0);
        spinner4.setSelection(0);
        spinner5.setSelection(0);
        spinner6.setSelection(0);
        spinner7.setSelection(0);
        spinner8.setSelection(0);
        resultGPA.setText("0");
        totalOfCourses = 0;
        totalOfCredits = 0;
        credit1EditText.setText("");
        credit2EditText.setText("");
        credit3EditText.setText("");
        credit4EditText.setText("");
        credit5EditText.setText("");
        credit6EditText.setText("");
        credit7EditText.setText("");
        credit8EditText.setText("");
    }
}
