package mentorme.csumb.edu.mentorme.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.crashlytics.android.Crashlytics;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;

import butterknife.ButterKnife;
import io.fabric.sdk.android.Fabric;
import mentorme.csumb.edu.mentorme.R;
import mentorme.csumb.edu.mentorme.login.googleSignInModel.GoogleApiSignInModel;
import mentorme.csumb.edu.mentorme.mentorMe.MentorMeActivity;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends MentorMeActivity {

    private static final String TAG = "SignInActivity";
    private static final int RC_SIGN_IN = 9001;

    private LoginController mLoginController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // ** Needed for Fabric **//
        Fabric.with(this, new Crashlytics());

        mLoginController = new LoginController(this);
        ButterKnife.bind(this);
    }

    @Override
    public void onStart() {
        super.onStart();

        mLoginController.initialSubscriber();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mLoginController.onActivityResult(requestCode, data);
    }
}

