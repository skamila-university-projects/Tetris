package ninja.madran.tetris.activities;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import ninja.madran.tetris.R;
import ninja.madran.tetris.fragments.MainMenuFragment;
import ninja.madran.tetris.fragments.SettingsFragment;

public class MainActivity extends AppCompatActivity implements MainMenuFragment.MainMenuEventListener, SettingsFragment.SettingsEventListener {

    private final FragmentManager fragmentManager = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.main_container, new MainMenuFragment());
        fragmentTransaction.commit();
    }

    @Override
    public void onMainMenuStartButtonPressed(View view) {

    }

    @Override
    public void onMainMenuSettingsButtonPressed(View view) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_container, new SettingsFragment());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void onMainMenuScoresButtonPressed(View view) {

    }

    @Override
    public void onMainMenuExitButtonPressed(View view) {

    }

    @Override
    public void onDifficultyLevelUp(View view) {

    }

    @Override
    public void onDifficultyLevelDown(View view) {

    }

    @Override
    public void onBackButtonPressed(View view) {
        onBackPressed();
    }
}
