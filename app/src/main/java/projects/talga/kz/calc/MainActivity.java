package projects.talga.kz.calc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnMidterm, btnGpa, todoBtn, attendanceBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMidterm = (Button) findViewById(R.id.midterm_button);
        btnGpa = (Button) findViewById(R.id.gpa_btn);
        todoBtn = (Button) findViewById(R.id.todo_btn);
        attendanceBtn = (Button) findViewById(R.id.attendance_btn);

        btnMidterm.setOnClickListener(this);
        btnGpa.setOnClickListener(this);
        todoBtn.setOnClickListener(this);
        attendanceBtn.setOnClickListener(this);


    }

/*    public void goToActivity(View view){
        switch (view.getId()){
            case R.id.midterm_button:
                Intent goMidtermActivity = new Intent(MainActivity.this, MidtermActivity.class);
                startActivity(goMidtermActivity);
                break;
            case R.id.gpa_btn:
                Intent goToGpaActivity = new Intent(this, GPA_Activity.class);
                startActivity(goToGpaActivity);
                break;
            default:
                Toast.makeText(MainActivity.this, "Error motherfucker!", Toast.LENGTH_LONG).show();
        }
    }*/

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.midterm_button:
                Intent goMidtermActivity = new Intent(MainActivity.this, MidtermActivity.class);
                startActivity(goMidtermActivity);
                break;
            case R.id.gpa_btn:
                Intent goToGpaActivity = new Intent(this, GPA_Activity.class);
                startActivity(goToGpaActivity);
                break;
            default:
                Toast.makeText(MainActivity.this, "Error!", Toast.LENGTH_LONG).show();
        }

    }

/*    public void goToMidterm(View view) {



    }

    public void goToGpa(View view) {

    }*/
}
