package riksasuviana.apps.onlinechat;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SignUpActivity extends AppCompatActivity {

    Toast t;

    FirebaseAuth mAuth;

    @BindView(R.id.regname) EditText regname;
    @BindView (R.id.regemail) EditText regemail;
    @BindView (R.id.regpw) EditText regpw;
    @BindView (R.id.regpw2) EditText regpw2;

    @OnClick(R.id.signupbtn) void signup(){
        String name = regname.getText().toString();
        String email = regemail.getText().toString();
        String pw = regpw.getText().toString();
        String pw2 = regpw2.getText().toString();

        if(!name.isEmpty() && !email.isEmpty() && !pw.isEmpty() && !pw2.isEmpty()) {
            if(pw.equals(pw2)) {
                if(pw.length() >= 6) {
                    mAuth.createUserWithEmailAndPassword(email, pw)
                            .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        showToast("Sign Up Success");
                                        finish();
                                    } else {
                                        showToast("Sign Up Failed");
                                    }
                                }
                            });
                }else{
                    showToast("Your password must be at least 6 characters");
                }
            }else{
                showToast("Password doesn't match");
            }
        }else{
            showToast("All column must be filled !");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        ButterKnife.bind(this);

        mAuth = FirebaseAuth.getInstance();
    }

    public void showToast(String msg){
        if(t != null){
            t.cancel();
        }
        Toast t = Toast.makeText(SignUpActivity.this, msg, Toast.LENGTH_LONG);
        t.show();
    }
}
