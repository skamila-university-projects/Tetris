package ninja.madran.tetris.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import ninja.madran.tetris.R;

public class SettingsFragment extends Fragment {

    private SettingsEventListener settingsEventListener;

    public SettingsFragment() {
        // Required empty public constructor
    }

    public static SettingsFragment newInstance() {

        return new SettingsFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_settings, container, false);

        final Button backButton = view.findViewById(R.id.settings_back);
        backButton.setOnClickListener(back);

        return view;
    }

    @Override
    public void onAttach(Context context) {

        super.onAttach(context);

        if (context instanceof SettingsEventListener) {
            settingsEventListener = (SettingsEventListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement SettingsEventListener");
        }
    }

    @Override
    public void onDetach() {

        super.onDetach();

        settingsEventListener = null;
    }

    public interface SettingsEventListener {

        void onDifficultyLevelUp(View view);
        void onDifficultyLevelDown(View view);
        void onBackButtonPressed(View view);
    }

    private View.OnClickListener difficultyLevelUp = (View view) -> settingsEventListener.onDifficultyLevelUp(view);

    private View.OnClickListener difficultyLevelDown = (View view) -> settingsEventListener.onDifficultyLevelDown(view);

    private View.OnClickListener back = (View view) -> settingsEventListener.onBackButtonPressed(view);
}
