package projects.talga.kz.calc;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class Register_activity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    private EditText passEditText, mailEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_activity);

        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    //User is sign in

                } else {
                    //User is sign out
                }

            }
        };

        mailEditText = (EditText) findViewById(R.id.mail_edit);
        passEditText = (EditText) findViewById(R.id.pass_edit);

        findViewById(R.id.reg_btn).setOnClickListener(this);
        findViewById(R.id.cancel_btn).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.reg_btn:

                registr(mailEditText.getText().toString(), passEditText.getText().toString());


                break;

            case R.id.cancel_btn:

                Toast.makeText(Register_activity.this, "Cancelled", Toast.LENGTH_LONG).show();

                break;
        }
    }


    public void registr(String email, String password) {
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(Register_activity.this, "Succesfully", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(Register_activity.this, "Error !", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
