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

public class MainMenuFragment extends Fragment {

    private MainMenuEventListener mainMenuEventListener;

    public MainMenuFragment() {

        // Required empty public constructor
    }

    public static MainMenuFragment newInstance() {

        return new MainMenuFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main_menu, container, false);

        final Button startButton = view.findViewById(R.id.main_menu_start);
        startButton.setOnClickListener(startButtonClick);

        final Button settingsButton = view.findViewById(R.id.main_menu_settings);
        settingsButton.setOnClickListener(settingsButtonClick);

        final Button scoresButton = view.findViewById(R.id.main_menu_scores);
        scoresButton.setOnClickListener(scoresButtonClick);

        final Button exitButton = view.findViewById(R.id.main_menu_exit);
        exitButton.setOnClickListener(exitButtonClick);

        return view;
    }

    @Override
    public void onAttach(Context context) {

        super.onAttach(context);

        if (context instanceof MainMenuEventListener) {
            mainMenuEventListener = (MainMenuEventListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement MainMenuEventListener");
        }
    }

    @Override
    public void onDetach() {

        super.onDetach();

        mainMenuEventListener = null;
    }

    public interface MainMenuEventListener {
        void onMainMenuStartButtonPressed(View view);
        void onMainMenuSettingsButtonPressed(View view);
        void onMainMenuScoresButtonPressed(View view);
        void onMainMenuExitButtonPressed(View view);
    }

    private View.OnClickListener startButtonClick = (View view) -> mainMenuEventListener.onMainMenuStartButtonPressed(view);

    private View.OnClickListener settingsButtonClick = (View view) -> mainMenuEventListener.onMainMenuSettingsButtonPressed(view);

    private View.OnClickListener scoresButtonClick = (View view) -> mainMenuEventListener.onMainMenuScoresButtonPressed(view);

    private View.OnClickListener exitButtonClick = (View view) -> mainMenuEventListener.onMainMenuExitButtonPressed(view);
}
