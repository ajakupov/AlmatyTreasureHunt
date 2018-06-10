package fr.gouv.httpdiplomatie.almatytreasurehunt;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by eisti on 20/03/17.
 *
 * The main map is represented as a fragment of a navigation drawer activity
 */

public class TipTrickFragment extends Fragment{
    private View gameMap;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        // obtain the main map fragment from an inflatter object
        gameMap = inflater.inflate(R.layout.tips_n_tricks, container, false);

        return gameMap;
    }
}
