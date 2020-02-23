package m.mawaka.hemishopping.Fragements;


import android.content.DialogInterface;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.kaopiz.kprogresshud.KProgressHUD;
import com.viewpagerindicator.CirclePageIndicator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


import m.mawaka.hemishopping.Model.Banner;
import m.mawaka.hemishopping.R;
import m.mawaka.hemishopping.Volley.VolleySingleton;


import static m.mawaka.hemishopping.Common.Common.BANNER_URL;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private static ViewPager mPager;
    ArrayList<Banner> bannerArrayList;
    CirclePageIndicator indicator;
    private ViewPager viewPager;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        mPager = view.findViewById(R.id.pager);
        indicator = view.findViewById(R.id.indicator);

        fetchingJSON();



        return view;
    }

    private void fetchingJSON() {



     final KProgressHUD Hhdprogress = KProgressHUD.create(getContext())
                .setStyle(KProgressHUD.Style.PIE_DETERMINATE)
                .setLabel("Please wait")
                .setCancellable(false)
                .setAnimationSpeed(2)
                .setDimAmount(0.5f);


        Hhdprogress.setCancellable(new  DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                dialog.dismiss();

            }
        });


        Hhdprogress.show();
        StringRequest stringRequest = new StringRequest(Request.Method.GET, BANNER_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {

                            JSONObject obj = new JSONObject(response);
                            if (obj.optString("success").equals("true")){
                                Hhdprogress.dismiss();
                                bannerArrayList = new ArrayList<>();
                                JSONArray dataArray  = obj.getJSONArray("data");



                                for (int i = 0; i < dataArray.length(); i++) {

                                    Banner playerModel = new Banner();
                                    JSONObject dataobj = dataArray.getJSONObject(i);

                                    playerModel.setName(dataobj.getString("name"));
                                    playerModel.setLink(dataobj.getString("link"));




                                    bannerArrayList.add(playerModel);




                                }

                                displaybanner();
                            }


                            Hhdprogress.dismiss();


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }




                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }) ;


        VolleySingleton.getInstance(this.getContext()).addToRequestQueue(stringRequest);

    }

    private void displaybanner() {
//        sliderLayout.setAdapter(new BannerAdapter(bannerArrayList));
//        sliderLayout.setInterval(2000);
    }




}
