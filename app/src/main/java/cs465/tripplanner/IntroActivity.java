package cs465.tripplanner;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class IntroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), TripsActivity.class);
                startActivity(i);
            }
        };
        Button signup = findViewById(R.id.intro_signup_button);
        Button login = findViewById(R.id.intro_login_button);
        signup.setOnClickListener(listener);
        login.setOnClickListener(listener);
    }
}
