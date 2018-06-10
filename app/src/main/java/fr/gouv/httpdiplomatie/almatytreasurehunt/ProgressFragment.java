package fr.gouv.httpdiplomatie.almatytreasurehunt;

import android.app.Fragment;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

/**
 * Created by eisti on 20/03/17.
 *
 * The main map is represented as a fragment of a navigation drawer activity
 */

public class ProgressFragment extends Fragment{
    private View gameMap;
    private static double distance;
    private ProgressBar userProgress;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        // obtain the main map fragment from an inflatter object
        gameMap = inflater.inflate(R.layout.progress_layout, container, false);

        //getting userDistance from MapNavigationActivity that has been obtinaed
        //from the GameMapFragment
        distance = ((MapNavigationActivity) getActivity()).getUserDistance();

        //getting progress bar from the Fragment
        //userProgress = (ProgressBar) getView().findViewById(R.id.userProgress);
        //userProgress.setProgress(50);


        return gameMap;
    }
}
