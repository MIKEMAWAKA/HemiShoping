package m.mawaka.hemishopping.Fragements;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import m.mawaka.hemishopping.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyshopFragment extends Fragment {


    public MyshopFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_myshop, container, false);
    }

}
