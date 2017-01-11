package riksasuviana.apps.onlinechat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeActivity extends AppCompatActivity {

    DatabaseReference root = FirebaseDatabase.getInstance().getReference();
    DatabaseReference ref = root.child("chat").child("asdasdads");

    @OnClick(R.id.chat) void chat(){

    }

    @OnClick(R.id.test) void test(){
        ref.push().setValue("qwe");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
    }
}
