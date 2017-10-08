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

public class AuthTodo extends AppCompatActivity implements View.OnClickListener {

    private EditText usernameEditText;
    private EditText passwordEditText;

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth_todo);

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

        usernameEditText = (EditText) findViewById(R.id.tvUsername);
        passwordEditText = (EditText) findViewById(R.id.tvPassword);

        findViewById(R.id.btn_signIn).setOnClickListener(this);
        findViewById(R.id.btn_registr).setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_signIn) {

            signing(usernameEditText.getText().toString(), passwordEditText.getText().toString());

        } else if (view.getId() == R.id.btn_registr) {

            registr(usernameEditText.getText().toString(), passwordEditText.getText().toString());

        }
    }


    public void signing(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                   /* Intent intent = new Intent(AuthTodo.this, TodoActivity.class);
                    startActivity(intent);*/
                    Toast.makeText(AuthTodo.this, "Succesfully", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(AuthTodo.this, "Error dickhead!", Toast.LENGTH_LONG).show();
                }


            }
        });
    }

    public void registr(String email, String password) {
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(AuthTodo.this, "Succesfully", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(AuthTodo.this, "Error motherfucker", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
