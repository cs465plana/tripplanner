package cs465.tripplanner;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class TripsFragment extends Fragment {
    private static final String ARG_IS_USER_VIEW = "isUserView";

    public TripsFragment() {
    }

    public static TripsFragment newInstance(boolean isUserView) {
        TripsFragment fragment = new TripsFragment();
        Bundle args = new Bundle();
        args.putBoolean(ARG_IS_USER_VIEW, isUserView);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_trips, container, false);

        RecyclerView trip_list = view.findViewById(R.id.trips_list);

        boolean isUserView = getArguments().getBoolean(ARG_IS_USER_VIEW);
        TripsAdapter adapter = new TripsAdapter(isUserView);
        trip_list.setAdapter(adapter);

        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        llm.setReverseLayout(true);
        llm.setStackFromEnd(true);
        trip_list.setLayoutManager(llm);

        return view;
    }

}
