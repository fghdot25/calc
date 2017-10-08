package projects.talga.kz.calc;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.irozon.sneaker.Sneaker;
import com.liuguangqiang.swipeback.SwipeBackActivity;
import com.liuguangqiang.swipeback.SwipeBackLayout;

import java.util.ArrayList;
import java.util.List;

public class MidtermActivity extends SwipeBackActivity {

    int sum = 0;

    double result, total;

    EditText grade1EditText;

    List<Integer> gradeList = new ArrayList<Integer>();

    TextView midterm1TextView, midterm2TextView, totalTextView, subTotalTextView;
    RadioButton midterm1RadioButton, midterm2RadioButton;
    RadioGroup radioGroup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_midterm);
        setDragEdge(SwipeBackLayout.DragEdge.LEFT);
    }

    public void displayResult(View view) {
        midterm1TextView = (TextView) findViewById(R.id.midterm1_text_view);
        midterm2TextView = (TextView) findViewById(R.id.midterm2_text_view);

        midterm1RadioButton = (RadioButton) findViewById(R.id.midterm1_rb);
        midterm2RadioButton = (RadioButton) findViewById(R.id.midterm2_rb);

        checkRadioBtn();
        double res1 = Double.parseDouble(midterm1TextView.getText()+"");
        double res2 = Double.parseDouble(midterm2TextView.getText()+"");

        if(Double.parseDouble(res1+"")>2 && Double.parseDouble(res2+"")>2){
            total = ((res1 + res2)/2)*0.6;
            totalTextView = (TextView) findViewById(R.id.total_text_view);
            totalTextView.setText(total+"");
        }
    }

    private void checkRadioBtn() {

        if (midterm1RadioButton.isChecked()) {
            for (int i = 0; i < gradeList.size(); i++) {
                sum += gradeList.get(i);
            }
            if (grade1EditText.getText().length() > 0) {
                sum += Integer.parseInt(grade1EditText.getText() + "");
                result = sum / (gradeList.size() + 1);
            } else {
                result = sum / gradeList.size();
            }

            midterm1TextView.setText(result + "");
            clear();
        } else if (midterm2RadioButton.isChecked()) {
            for (int i = 0; i < gradeList.size(); i++) {
                sum += gradeList.get(i);
            }
            if (grade1EditText.getText().length() > 0) {
                sum += Integer.parseInt(grade1EditText.getText() + "");
                result = sum / (gradeList.size() + 1);
            } else {
                result = sum / gradeList.size();
            }

            midterm2TextView.setText(result + "");
            clear();
        } else {


            Sneaker.with(MidtermActivity.this)
                    .setHeight(100)
                    .setTitle("Warning!")
                    .setMessage("Please check one midterm!")
                    .sneakWarning();
        }

    }

    public void subTotal(View view) {

        grade1EditText = (EditText) findViewById(R.id.grade1_edit_text);
        subTotalTextView = (TextView) findViewById(R.id.subtotal_text_view);


        String number = grade1EditText.getText() + "";

        if (grade1EditText.getText().length() > 0) {

            if (Integer.parseInt(number) <= 100 && Integer.parseInt(number) >= 0) {

                int a = Integer.parseInt(number);
                grade1EditText.setText("");
                gradeList.add(a);
                String str = gradeList + "";
                str = str.replace("[", "");
                str = str.replace("]", "");
                subTotalTextView.setText(str);

            } else {

                grade1EditText.setError("It seems your number is higher than 100.");

      /*        Sneaker.with(MidtermActivity.this)
                        .setHeight(100)
                        .setTitle("Error")
                        .setMessage("It seems your number is higher than 100.")
                        .sneakError();*/

                return;
            }

        } else {

            grade1EditText.setError("Enter some number");
            // Toast.makeText(getApplicationContext(), , Toast.LENGTH_LONG).show();
        }
    }


    public void displayReset(View view) {
        clear();
        midterm1TextView.setText("0");
        midterm2TextView.setText("0");
        Toast.makeText(getApplicationContext(), "GOOOOOOD!", Toast.LENGTH_LONG).show();

    }

    private void clear() {
        sum = 0;
        result = 0;
        gradeList.clear();
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioGroup.clearCheck();
        subTotalTextView.setText("0");
        grade1EditText.setText("");


    }
}
